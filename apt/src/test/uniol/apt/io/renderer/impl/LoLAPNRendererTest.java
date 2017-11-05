/*-
 * APT - Analysis of Petri Nets and labeled Transition systems
 * Copyright (C) 2012-2013  Members of the project group APT
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

package uniol.apt.io.renderer.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static uniol.apt.TestNetCollection.*;
import static uniol.apt.io.matcher.StringEqualsIgnoringLineEndings.equalsIgnoringLineEndings;

import org.testng.annotations.Test;

import uniol.apt.adt.pn.PetriNet;
import uniol.apt.module.exception.ModuleException;

/** @author Uli Schlachter, vsp */
public class LoLAPNRendererTest {
	// Please only add tests to this class after you verified that LoLA can actually parse them!

	private String render(PetriNet pn) throws ModuleException {
		return new LoLAPNRenderer().render(RendererTestUtils.getSortedNet(pn));
	}

	@Test(expectedExceptions = ModuleException.class)
	public void testEmptyNet() throws Exception {
		render(getEmptyNet());
	}

	@Test(expectedExceptions = ModuleException.class)
	public void testNoTransitionOnePlaceNet() throws Exception {
		render(getNoTransitionOnePlaceNet());
	}

	@Test(expectedExceptions = ModuleException.class)
	public void testOneTransitionNoPlaceNet() throws Exception {
		render(getOneTransitionNoPlaceNet());
	}

	@Test
	public void testTokenGeneratorNet() throws Exception {
		String expected = "{ Petri net generated by APT for net TokenGeneratorNet }"
				+ "\n\nPLACE\np1;\n\nMARKING;\n\n"
				+ "TRANSITION t1\nCONSUME;\nPRODUCE\n\tp1\t: 1;\n";
		assertThat(render(getTokenGeneratorNet()), equalsIgnoringLineEndings(expected));
	}

	@Test
	public void testDeadlockNet() throws Exception {
		String expected = "{ Petri net generated by APT for net DeadlockNet }"
				+ "\n\nPLACE\np1;\n\n"
				+ "MARKING\n\tp1\t: 1;\n\n"
				+ "TRANSITION t1\nCONSUME\n\tp1\t: 1;\nPRODUCE;\n\n"
				+ "TRANSITION t2\nCONSUME\n\tp1\t: 1;\nPRODUCE;\n";
		assertThat(render(getDeadlockNet()), equalsIgnoringLineEndings(expected));
	}

	@Test
	public void testNonPersistentNet() throws Exception {
		String expected = "{ Petri net generated by APT for net NonPersistentNet }\n\nPLACE\np1, p2;\n\n"
				+ "MARKING\n\tp1\t: 1;\n\n"
				+ "TRANSITION a\nCONSUME\n\tp1\t: 1;\nPRODUCE\n\tp2\t: 1;\n\n"
				+ "TRANSITION b\nCONSUME\n\tp1\t: 1;\nPRODUCE\n\tp2\t: 1;\n\n"
				+ "TRANSITION c\nCONSUME\n\tp2\t: 1;\nPRODUCE\n\tp1\t: 1;\n";
		assertThat(render(getNonPersistentNet()), equalsIgnoringLineEndings(expected));
	}

	@Test
	public void checkPersistentBiCFNet() throws Exception {
		String expected = "{ Petri net generated by APT for net PersistentBiCFNet }"
				+ "\n\nPLACE\np1, p2, p3, p4, p5;\n\n"
				+ "MARKING\n\tp1\t: 1,\n\tp3\t: 2,\n\tp5\t: 1;\n\n"
				+ "TRANSITION a\nCONSUME\n\tp1\t: 1,\n\tp3\t: 1;\n"
				+ "PRODUCE\n\tp2\t: 1;\n\n"
				+ "TRANSITION b\nCONSUME\n\tp3\t: 1,\n\tp5\t: 1;\n"
				+ "PRODUCE\n\tp4\t: 1;\n\n"
				+ "TRANSITION c\nCONSUME\n\tp2\t: 1;\n"
				+ "PRODUCE\n\tp1\t: 1,\n\tp3\t: 1;\n\n"
				+ "TRANSITION d\nCONSUME\n\tp4\t: 1;\n"
				+ "PRODUCE\n\tp3\t: 1,\n\tp5\t: 1;\n";
		assertThat(render(getPersistentBiCFNet()), equalsIgnoringLineEndings(expected));
	}

	@Test
	public void testConcurrentDiamondNet() throws Exception {
		String expected = "{ Petri net generated by APT for net "
				+ "ConcurrentDiamondNet }\n\nPLACE\n"
				+ "p1, p2;\n\nMARKING\n\tp1\t: 1,\n\tp2\t: 1;\n\n"
				+ "TRANSITION t1\nCONSUME\n\tp1\t: 1;\nPRODUCE;\n\n"
				+ "TRANSITION t2\nCONSUME\n\tp2\t: 1;\nPRODUCE;\n";
		assertThat(render(getConcurrentDiamondNet()), equalsIgnoringLineEndings(expected));
	}

	@Test
	public void testConflictingDiamondNet() throws Exception {
		String expected = "{ Petri net generated by APT for net "
				+ "ConflictingDiamondNet }\n\n"
				+ "PLACE\np1, p2, p3;\n\n"
				+ "MARKING\n\tp1\t: 1,\n\tp2\t: 1,\n\tp3\t: 1;\n\n"
				+ "TRANSITION t1\nCONSUME\n\tp1\t: 1,\n\tp3\t: 1;\n"
				+ "PRODUCE\n\tp3\t: 1;\n\n"
				+ "TRANSITION t2\nCONSUME\n\tp2\t: 1,\n\tp3\t: 1;\n"
				+ "PRODUCE\n\tp3\t: 1;\n";
		assertThat(render(getConflictingDiamondNet()), equalsIgnoringLineEndings(expected));
	}

	@Test(expectedExceptions = ModuleException.class)
	public void testInvalidIdentifier() throws Exception {
		PetriNet pn = new PetriNet();
		pn.createTransition(",");
		pn.createPlace("\n");
		render(pn);
	}
}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120