/*-
 * APT - Analysis of Petri Nets and labeled Transition systems
 * Copyright (C) 2015  Uli Schlachter
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package uniol.apt.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.iterators.PeekingIterator;
import static org.apache.commons.collections4.iterators.PeekingIterator.peekingIterator;

/**
 * Instances of this class represent an equivalence relation over an unknown set. Initially, all elements are only
 * equivalent to themselves, but the equivalence classes of two elements can be joined.
 * @param <E> The type of elements in the equivalence relation.
 * @author Uli Schlachter
 */
public class EquivalenceRelation<E> extends AbstractEquivalenceRelation<E> {

	@Override
	public EquivalenceRelation<E> refine(IEquivalenceRelation<? super E> relation) {
		EquivalenceRelation<E> result = new EquivalenceRelation<>();
		if (super.refine(result, relation))
			return result;
		return this;
	}

	@Override
	public int size() {
		// Remove all classes which have only a single entry
		Iterator<Set<E>> iter = leaderToClass.values().iterator();
		while (iter.hasNext()) {
			Set<E> klass = iter.next();
			if (klass.size() == 1) {
				iter.remove();
			}
		}
		return super.size();
	}

	@Override
	public Iterator<Set<E>> iterator() {
		return new Iterator<Set<E>>() {
			private PeekingIterator<Set<E>> iter = peekingIterator(leaderToClass.values().iterator());

			@Override
			public boolean hasNext() {
				// Skip all sets which have just a single entry
				Set<E> next = iter.peek();
				while (next != null && next.size() == 1) {
					iter.next();
					iter.remove();
					next = iter.peek();
				}
				return iter.hasNext();
			}

			@Override
			public Set<E> next() {
				hasNext();
				return Collections.unmodifiableSet(iter.next());
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120
