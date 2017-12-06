package application;

import java.util.HashMap;
import java.util.function.BiFunction;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class BigInfoAPTList
{
	private static HashMap<String, String> bigInfoAPTList = new HashMap<String, String> ();

	private static ObservableList<String> typesList = FXCollections.observableArrayList();

	//petri nets
	private final String misc = "---MISC---";
	private final String draw = "draw";
	private final String help = "help";
	private final String petri_net = "---PETRI NET---";
	private final String ac = "ac";
	private final String backward_persistent = "backward_persistent";
	private final String bcf = "bcf";
	private final String bicf = "bicf";
	private final String bisimulation = "bisimulation";
	private final String bounded = "bounded";
	private final String cf = "cf";
	private final String check = "check";
	private final String check_all_cycle_prop = "check_all_cycle_prop";
	private final String compute_pvs = "compute_pvs";
	private final String concurrent_coverability_graph = "concurrent_coverability_graph";
	private final String conpres = "conpres";
	private final String coverability_graph = "coverability_graph";
	private final String covered_by_invariant = "covered_by_invariant";
	private final String cycles_same_disjoint_pv = "cycles_same_disjoint_pv";
	private final String cycles_same_pv = "cycles_same_pv";
	private final String examine_pn = "examine_pn";
	private final String fairness = "fairness";
	private final String fc = "fc";
	private final String fire_sequence = "fire_sequence";
	private final String homogeneous = "homogeneous";
	private final String invariants = "invariants";
	private final String isolated = "isolated";
	private final String isolated_elements = "isolated_elements";
	private final String isomorphism = "isomorphism";
	private final String k_bounded = "k_bounded";
	private final String k_marking = "k_marking";
	private final String language_equivalence = "language_equivalence";
	private final String matrices = "matrices";
	private final String mf = "mf";
	private final String nonpure = "nonpure";
	private final String on = "on";
	private final String persistent = "persistent";
	private final String plain = "plain";
	private final String pn_analysis = "pn_analysis";
	private final String prime_cycle_property = "prime_cycle_property";
	private final String pure = "pure";
	private final String reachability_graph = "reachability_graph";
	private final String reversible = "reversible";
	private final String rfc = "rfc";
	private final String safe = "safe";
	private final String sideconditions = "sideconditions";
	private final String simply_live = "simply_live";
	private final String siphons = "siphons";
	private final String snet = "snet";
	private final String strong_components = "strong_components";
	private final String strong_separation = "strong_separation";
	private final String strong_separation_length = "strong_separation_length";
	private final String strongly_connected = "strongly_connected";
	private final String strongly_live = "strongly_live";
	private final String sum_async = "sum_async";
	private final String sum_sync = "sum_sync";
	private final String tnet = "tnet";
	private final String to_regular_expression = "to_regular_expression";
	private final String traps = "traps";
	private final String weak_components = "weak_components";
	private final String weak_separation = "weak_separation";
	private final String weak_separation_length = "weak_separation_length";
	private final String weakly_connected = "weakly_connected";
	private final String weakly_live = "weakly_live";
	private final String wfc = "wfc";
	private final String word = "word";


	//lts
	private final String lts = "---LTS---";
	private final String backward_persistent2 = "backward_persistent";
	private final String backwards_deterministic2 = "backwards_deterministic";
	private final String bisimulation2 = "bisimulation";
	private final String create_lts2 = "create_lts";
	private final String compute_pvs2 = "compute_pvs";
	private final String cycles_same_disjoint_pv2 = "cycles_same_disjoint_pv";
	private final String cycles_same_pv2 = "cycles_same_pv";
	private final String deterministic2 = "deterministic";
	private final String examine_lts2 = "examine_lts";
	private final String extend_deterministic_persistent2 = "extend_deterministic_persistent";
	private final String extend_lts2 = "extend_lts";
	private final String factorize2 = "factorize";
	private final String fairness2 = "fairness";
	private final String find_words2 = "find_words";
	private final String gdiam2 = "gdiam";
	private final String isolated_elements2 = "isolated_elements";
	private final String isomorphism2 = "isomorphism";
	private final String label_separation2 = "label_separation";
	private final String language_equivalence2 = "language_equivalence";
	private final String limited_unfolding2 = "limited_unfolding";
	private final String overapproximate_synthesize2 = "overapproximate_synthesize";
	private final String persistent2 = "persistent";
	private final String pn_extend_and_synthesize2 = "pn_extend_and_synthesize";
	private final String ppspresynthesis2 = "ppspresynthesis";
	private final String prime_cycle_property2 = "prime_cycle_property";
	private final String product_async2 = "product_async";
	private final String product_sync2 = "product_sync";
	private final String regular_language_to_lts2 = "regular_language_to_lts";
	private final String reversible2 = "reversible";
	private final String strong_components2 = "strong_components";
	private final String strongly_connected2 = "strongly_connected";
	private final String synthesize2 = "synthesize";
	private final String to_regular_expression2 = "to_regular_expression";
	private final String totally_reachable2 = "totally_reachable";
	private final String use_petrify2 = "use_petrify";
	private final String use_synet2 = "use_synet";
	private final String weak_components2 = "weak_components";
	private final String weakly_connected2 = "weakly_connected";
	private final String word_synthesize2 = "word_synthesize";

	//generators
	private final String generators = "---GENERATORS---";
	private final String bistate_philnet_generator = "bistate_philnet_generator";
	private final String bitnet_generator = "bitnet_generator";
	private final String connected_bitnet_generator = "connected_bitnet_generator";
	private final String cycle_generator = "cycle_generator";
	private final String generate_reverse_arc = "generate_reverse_arc";
	private final String inverse_generator = "inverse_generator";
	private final String quadstate_philnet_generator = "quadstate_philnet_generator";
	private final String random_t_net_generator = "random_t_net_generator";
	private final String tnet_generator = "tnet_generator";
	private final String tristate_philnet_generator = "tristate_philnet_generator";

	//conveters
	private final String conveters = "---CONVETERS---";
	private final String draw_convert = "draw";
	private final String lts_convert = "lts_convert";
	private final String pn_convert = "pn_convert";


	public BigInfoAPTList()
	{
		//typesList
		//misc
		typesList.add(misc);
		typesList.add(draw);
		typesList.add(help);
		//petri net
		typesList.add(petri_net);
		typesList.add(ac);
		typesList.add(backward_persistent);
		typesList.add(bcf);
		typesList.add(bicf);
		typesList.add(bisimulation);
		typesList.add(bounded);
		typesList.add(cf);
		typesList.add(check);
		typesList.add(check_all_cycle_prop);
		typesList.add(compute_pvs);
		typesList.add(concurrent_coverability_graph);
		typesList.add(conpres);
		typesList.add(coverability_graph);
		typesList.add(covered_by_invariant);
		typesList.add(cycles_same_disjoint_pv);
		typesList.add(cycles_same_pv);
		typesList.add(examine_pn);
		typesList.add(fairness);
		typesList.add(fc);
		typesList.add(fire_sequence);
		typesList.add(homogeneous);
		typesList.add(invariants);
		typesList.add(isolated);
		typesList.add(isolated_elements);
		typesList.add(isomorphism);
		typesList.add(k_bounded);
		typesList.add(k_marking);
		typesList.add(language_equivalence);
		typesList.add(matrices);
		typesList.add(mf);
		typesList.add(nonpure);
		typesList.add(on);
		typesList.add(persistent);
		typesList.add(plain);
		typesList.add(pn_analysis);
		typesList.add(prime_cycle_property);
		typesList.add(pure);
		typesList.add(reachability_graph);
		typesList.add(reversible);
		typesList.add(rfc);
		typesList.add(safe);
		typesList.add(sideconditions);
		typesList.add(simply_live);
		typesList.add(siphons);
		typesList.add(snet);
		typesList.add(strong_components);
		typesList.add(strong_separation);
		typesList.add(strong_separation_length);
		typesList.add(strongly_connected);
		typesList.add(strongly_live);
		typesList.add(sum_async);
		typesList.add(sum_sync);
		typesList.add(tnet);
		typesList.add(to_regular_expression);
		typesList.add(traps);
		typesList.add(weak_components);
		typesList.add(weak_separation);
		typesList.add(weak_separation_length);
		typesList.add(weakly_connected);
		typesList.add(weakly_live);
		typesList.add(wfc);
		typesList.add(word);

		//lts
		typesList.add(lts);
		typesList.add(backward_persistent2);
		typesList.add(backwards_deterministic2);
		typesList.add(bisimulation2);
		typesList.add(compute_pvs2);
		typesList.add(create_lts2);
		typesList.add(cycles_same_disjoint_pv2);
		typesList.add(cycles_same_pv2);
		typesList.add(deterministic2);
		typesList.add(examine_lts2);
		typesList.add(extend_deterministic_persistent2);
		typesList.add(extend_lts2);
		typesList.add(factorize2);
		typesList.add(fairness2);
		typesList.add(find_words2);
		typesList.add(gdiam2);
		typesList.add(isolated_elements2);
		typesList.add(isomorphism2);
		typesList.add(label_separation2);
		typesList.add(language_equivalence2);
		typesList.add(limited_unfolding2);
		typesList.add(overapproximate_synthesize2);
		typesList.add(persistent2);
		typesList.add(pn_extend_and_synthesize2);
		typesList.add(ppspresynthesis2);
		typesList.add(prime_cycle_property2);
		typesList.add(product_async2);
		typesList.add(product_sync2);
		typesList.add(regular_language_to_lts2);
		typesList.add(reversible2);
		typesList.add(strong_components2);
		typesList.add(strongly_connected2);
		typesList.add(synthesize2);
		typesList.add(to_regular_expression2);
		typesList.add(totally_reachable2);
		typesList.add(use_petrify2);
		typesList.add(use_synet2);
		typesList.add(weak_components2);
		typesList.add(weakly_connected2);
		typesList.add(word_synthesize2);

		//generators
		typesList.add(generators);
		typesList.add(bistate_philnet_generator);
		typesList.add(bitnet_generator);
		typesList.add(connected_bitnet_generator);
		typesList.add(cycle_generator);
		typesList.add(generate_reverse_arc);
		typesList.add(inverse_generator);
		typesList.add(quadstate_philnet_generator);
		typesList.add(random_t_net_generator);
		typesList.add(tnet_generator);
		typesList.add(tristate_philnet_generator);

		//converts
		typesList.add(conveters);
		typesList.add(draw_convert);




		//bigInfo
		//misc
		bigInfoAPTList.put(misc, "");
		bigInfoAPTList.put(draw, "Convert a Petri net or LTS to the Dot format used by Graphviz");
		bigInfoAPTList.put(help, "Get information about a module");
		//petri nets
		bigInfoAPTList.put(petri_net, "");
		bigInfoAPTList.put(ac, "Check if a Petri net is asymmetric-choice.\nA Petri net is an asymmetric choice net if ?p?,p??P: p?°?p?°?? ? p?°?p?° ? p?°?p?°.");
		bigInfoAPTList.put(backward_persistent, "Check if a Petri net or LTS is backward persistent. \nA LTS is backward persistent if for all reachable states s and backward enabled labels a, b (a?b), there is a state r so that both r[ab>s and r[ba>s. A Petri net is backward persistent if its reachability graph is backward persistent.");
		bigInfoAPTList.put(bcf, "Check if a Petri net is behaviourally conflict free (BCF).\nA Petri net is BCF if in every reachable marking M and for any enabled pair of transitions (M[a>, M[b> and a ? b), the presets of the transitions is disjoint (°a?°b=?).");
		bigInfoAPTList.put(bicf, "Check if a Petri net is binary conflict free (BiCF).\nA Petri net is BiCF if in every reachable marking M and for any enabled pair of transitions (M[a>, M[b> and a ? b), enough tokens for both transitions are present (?p?P: M(p) ? F(p, a) + F(p, b)).");
		bigInfoAPTList.put(bisimulation, "Check if the reachability graphs of two bounded labeled Petri nets or of two LTS or a combination of both are bisimilar");
		bigInfoAPTList.put(bounded, "Check if a Petri net is bounded or k-bounded.\nA Petri net is bounded if there is an upper limit for the number of token on each place. It is k-bounded if this limit isn't bigger than k.");
		bigInfoAPTList.put(cf, "This module tests if a plain Petri net is conflict-free.\nThat is:\\forall s \\in S: \\mid s^\\bullet \\mid \\leq 1 \\vee s^\\bullet \\subset ^\bullet s");
		bigInfoAPTList.put(check, "Search for a Petri net which fulfills the given attributes.\nFor detailed descriptions see analysis modules and generator packet.");
		bigInfoAPTList.put(check_all_cycle_prop, "Check all cycle properties of a Petri net.\nCheck if all smallest cycles have same Parikh vectors, if all smallest cycles have same or mutually disjoint Parikh vectors and it computes Parikh vectors of smallest cycles");
		bigInfoAPTList.put(compute_pvs, "Compute parikh vectors of smallest cycles of a Petri net or LTS");
		bigInfoAPTList.put(concurrent_coverability_graph, "Calculate the concurrent coverability graph of a Petri net in the step semantics. In the step semantics, instead of individual transitions, sets of transitions called 'a step' are fired. When a step fires, first all of its transition consume token and only afterwards produce tokens. Put differently, on each place at least as many token have to be present as the sum of the arc weights of the transitions in a step require.");
		bigInfoAPTList.put(conpres, "Check if a Petri net is concurrency-preserving.\nThis module checks if a Petri net is concurrency-preserving.That is: for every transition t there are as many places in the preset as in the postset of t.");
		bigInfoAPTList.put(coverability_graph, "Compute a Petri net's coverability graph");
		bigInfoAPTList.put(covered_by_invariant, "Check if a Petri net is covered by an S-invariant or a T-invariant.\nAn invariant is a semi-positive vector from the nullspace of the incidence matrix C. For a T-invariant x?0 this means C*x=0 and a S-invariant x?0 satisfies C?*x=0. This module checks if a positive S- or T-invariant exists, that is an invariant without an entry equal to zero.");
		bigInfoAPTList.put(cycles_same_disjoint_pv, "Check if the smallest cycles of a Petri net or LTS have the same or mutually disjoint parikh vectors.");
		bigInfoAPTList.put(cycles_same_pv, "Check if the smallest cycles of Petri net or LTS have the same parikh vector.");
		bigInfoAPTList.put(examine_pn, "Perform various tests on a Petri net at once");
		bigInfoAPTList.put(fairness, "Check if a Petri net or transition system is fair. A transition system is fair if for every infinite firing sequence every infintely often k-activated event is fired infinitely often.");
		bigInfoAPTList.put(fc, "Check if a Petri net is free-choice.\nThat is: \\forall t1,t2 \\in T: ^{\\bullet}t1 \\Cap ^{\\bullet}t2 \\neq \\emptyset \\Rightarrow ^{\\bullet}t1 \\eq ^{\\bullet}t2.");
		bigInfoAPTList.put(fire_sequence, "Try to fire a given firing sequence on a Petri net.. This module tries to fire a given sequence of transitions in a Petri net. It will report the longest enabled prefix of the sequence and print the marking that is reached at the end.\nsequence: Words can be specified in two different forms. The first format includes explicit delimiters between events. For delimiters, either commas, semicolons or spaces are allowed. An example of this format would be 'a, b, c'. Note that leading and trailing spaces are skipped. The second format expects events to be individual letters. The special prefix : is used to indicate this format. An example would be ':abc'.");
		bigInfoAPTList.put(homogeneous, "Check if a Petri net is homogeneous.\nA Petri net is an homogeneous net if ?p?P:?t?,t??p°: F(p,t?)=F(p,t?)");
		bigInfoAPTList.put(invariants, "Compute a generator set of S- or T-invariants.\nAn invariant is a semi-positive vector from the nullspace of the incidence matrix C. For a T-invariant x?0 this means C*x=0 and a S-invariant x?0 satisfies C?*x=0. This module finds the set of generators for all S- or T-invariants.");
		bigInfoAPTList.put(isolated, "Check if a Petri net contains isolated elements. A Petri net contains isolated elements when at least one element's pre- and postset is empty.");
		bigInfoAPTList.put(isolated_elements, "Find isolated elements in a graph");
		bigInfoAPTList.put(isomorphism, "Check if two Petri nets have isomorphic reachability graphs");
		bigInfoAPTList.put(k_bounded, "Find the smallest k for which a Petri net is k-bounded. A Petri net is bounded if there is an upper limit for the number of token on each place. It is k-bounded if this limit isn't bigger than k.");
		bigInfoAPTList.put(k_marking, "Compute the largest k for which M0 is a k-marking.\ne.g.: Output: Largest k for which M0 is a k-marking: 1");
		bigInfoAPTList.put(language_equivalence, "Check if two Petri nets generate the same language");
		bigInfoAPTList.put(matrices, "Calculate forward, backward, and incidence matrices");
		bigInfoAPTList.put(mf, "This module checks if a Petri net is merge-free. A merge is a place where more than one transition produce token.");
		bigInfoAPTList.put(nonpure, "Check if a Petri net is nonpure but only simple sideconditions. A Petri net is nonpure when there exists atleast one self-loop. A sidecondition is simple, when both arcsof the self-loop have a weight of 1.");
		bigInfoAPTList.put(on, "This module checks if a Petri net is output-nonbranching. That is:\n\\forall s \\in S: \\mid s^\\bullet \\mid \\leq 1");
		bigInfoAPTList.put(persistent, "Check if a Petri net or LTS is persistent.\nA LTS is persistent if for all reachable states s and enabled labels a, b (a?b), there is a state r so that both s[ab>r and s[ba>r. A Petri net is persistent if its reachability graph is persistent.");
		bigInfoAPTList.put(plain, "Check if a Petri net is plain. A Petri net is plain if all arc weights are at most 1.");
		bigInfoAPTList.put(pn_analysis, "Output a T-system of size g, which has a reachability graph, which is isomorph to the reachability graph of the input Petri net");
		bigInfoAPTList.put(prime_cycle_property, "Check if the give Petri net or LTS fulfills the prime cycle property");
		bigInfoAPTList.put(pure, "Check if a Petri net is pure. A Petri net is pure if there are no side conditions. A side condition is a loop between a place p and a transition t (F(p,t)> 0 and F(t,p)>0).");
		bigInfoAPTList.put(reachability_graph, "Compute a Petri net's reachability graph");
		bigInfoAPTList.put(reversible, "CCheck if a Petri net or LTS is reversible. A LTS is reversible if every reachable state can reach the initial state again. A Petri net is reversible if its reachability graph is reversible.");
		bigInfoAPTList.put(rfc, "Check if a Petri net is restricted-free-choice.\nThat is:\n\\forall t_1,t_s\\in T\\colon{}^\\bullet t_1\\cap{}^\\bullet t_2\\neq\\es\n\\impl|{}^\\bullet t_1|=|{}^\\bullet t_2|=1");
		bigInfoAPTList.put(safe, "Check if a Petri net is safe. A Petri net is safe if no marking is reachable were a place has more than one token.");
		bigInfoAPTList.put(sideconditions, "Compute the sideconditions of a Petri net. A side condition is a self-loop, consisting of the place, the transition and the arcs.");
		bigInfoAPTList.put(simply_live, "Check if a Petri net or a transition (if given) is simply live. A transition is simply live when it can fire at least once. A Petri net is simply live when all of its transitions are simply live. For a simply live transition, this module finds a firing sequence that fires the transition.");
		bigInfoAPTList.put(siphons, "Compute all minimal siphons in a Petri net. A siphon is a set of places so that every transition consuming tokens from one of these places also produces tokens on at least one place in the set.");
		bigInfoAPTList.put(snet, "Check if a plain Petri net is an S-net. In a S-net, the preset and postset of any transition has at most one entry (plus the net is plain).");
		bigInfoAPTList.put(strong_components, "Find the strongly connected components of a Petri net or LTS");
		bigInfoAPTList.put(strong_separation, "Check if a given sequence is strongly k-separable.\nsequence:\nWords can be specified in two different forms.\nThe first format includes explicit delimiters between events. For delimiters, either commas, semicolons or spaces are allowed. An example of this format would be 'a, b, c'. Note that leading and trailing spaces are skipped.\nThe second format expects events to be individual letters. The special prefix : is used to indicate this format. An example would be ':abc'.");
		bigInfoAPTList.put(strong_separation_length, "Check if all sequences up to a length are strongly k-separable.");
		bigInfoAPTList.put(strongly_connected, "Check if a Petri net or LTS is strongly connected");
		bigInfoAPTList.put(strongly_live, "Check if a Petri net or a transition (if given) is strongly live. A transition is strongly live when for every reachable marking there exists a firing sequence after which this transition is activated. A Petri net is strongly live when all of its transitions are strongly live. For a transition which is not strongly live, this module finds a firing sequence after which the transition cannot fire anymore.");
		bigInfoAPTList.put(sum_async, "Compute the synchronous sum of two PN");
		bigInfoAPTList.put(sum_sync, "Compute the synchronous sum of two PN");
		bigInfoAPTList.put(tnet, "Check if a plain Petri net is a T-net. In a T-net, the preset and postset of any place has at most one entry (plus the net is plain).");
		bigInfoAPTList.put(to_regular_expression, "Create a language-equivalent (up to prefix creation) regular expression");
		bigInfoAPTList.put(traps, "Compute all minimal traps in a Petri net. A trap is a set of places so that every transition producing tokens on one of these places also consumes tokens from at least one place in the set.");
		bigInfoAPTList.put(weak_components, "Find the weakly connected components of a Petri net or LTS");
		bigInfoAPTList.put(weak_separation, "Check if a given sequence is weakly k-separable.\nsequence:\nWords can be specified in two different forms.\nThe first format includes explicit delimiters between events. For delimiters, either commas, semicolons or spaces are allowed. An example of this format would be 'a, b, c'. Note that leading and trailing spaces are skipped.\nThe second format expects events to be individual letters. The special prefix : is used to indicate this format. An example would be ':abc'.");
		bigInfoAPTList.put(weak_separation_length, "Check if all sequences up to a length are weakly k-separable");
		bigInfoAPTList.put(weakly_connected, "Check if a Petri net or LTS is weakly connected");
		bigInfoAPTList.put(weakly_live, "Check if a Petri net or a transition (if given) is weakly live. A transition is weakly live if an infinite fire sequence exists which fires this transition infinitely often. A Petri net is weakly live when all of its transitions are weakly live");
		bigInfoAPTList.put(wfc, "Check if a Petri net is weighted free-choice. That is: \\forall t1,t2 \\in T: ^{\\bullet}t1 \\Cap ^{\\bullet}t2 \\neq \\emptyset \\Rightarrow ^{\\bullet}t1 \\eq ^{\\bullet}t2.");
		bigInfoAPTList.put(word, " Check if a word is in a Petri net's prefix language.\nword:\nWords can be specified in two different forms.\nThe first format includes explicit delimiters between events. For delimiters, either commas, semicolons or spaces are allowed. An example of this format would be 'a, b, c'. Note that leading and trailing spaces are skipped.\nThe second format expects events to be individual letters. The special prefix : is used to indicate this format. An example would be ':abc'.");

		//lts
		bigInfoAPTList.put(lts, "");
		bigInfoAPTList.put(backward_persistent2,"A LTS is backward persistent if for all reachable states s and backward enabled labels a, b (a?b), there is a state r so that both r[ab>s and r[ba>s. A Petri net is backward persistent if its reachability graph is backward persistent.");
		bigInfoAPTList.put(backwards_deterministic2,"Check if a LTS is backwards deterministic");
		bigInfoAPTList.put(bisimulation2,"Check if the reachability graphs of two bounded labeled Petri nets or of two LTS or a combination of both are bisimilar");
		bigInfoAPTList.put(compute_pvs2,"Compute parikh vectors of smallest cycles of a Petri net or LTS");
		bigInfoAPTList.put(create_lts2,"Create an LTS from a list of words");
		bigInfoAPTList.put(cycles_same_disjoint_pv2,"Check if the smallest cycles of a Petri net or LTS have the same or mutually disjoint parikh vectors");
		bigInfoAPTList.put(cycles_same_pv2,"Check if the smallest cycles of Petri net or LTS have the same parikh vector");
		bigInfoAPTList.put(deterministic2,"Check if a LTS is deterministic");
		bigInfoAPTList.put(examine_lts2,"Perform various tests on a transition system at once");
		bigInfoAPTList.put(extend_deterministic_persistent2, "Extend a transition system to an deterministic persistent transition system");
		bigInfoAPTList.put(extend_lts2, "Generate extensions to a given LTS that satisfy certain properties.\nGenerate extensions to a given LTS that are reversible, persistent. Also, all smallest cycles share the same parikh vector. This module can run in three different modes: It can generate the next possible extension to the given LTS, the next extension that satisfies the above properties or the next satisfying extension that is also minimal among satisfying extensions.");
		bigInfoAPTList.put(factorize2,"Decompose a LTS into its factors (if possible)");
		bigInfoAPTList.put(fairness2,"Check if a Petri net or transition system is fair");
		bigInfoAPTList.put(find_words2,"Print either minimal unsolvable or all solvable words of some class.\nThis module only prints a subset of all words. For this, an equivalence relation on words is used were two words are equivalent if one can be created from the other by replacing letters with other letters. For example, 'abc' and 'abd' are equivalent in this sense, since c->d turns one into the other.\nMore concretely, words are generated so that the last letter of the word is the first letter of the alphabet. Then, the next new letter from the end is the second letter of the alphabet, and so on.");
		bigInfoAPTList.put(gdiam2,"Check if a LTS is a T'-gdiam.\nWords can be specified in two different forms.\nThe first format includes explicit delimiters between events. For delimiters, either commas, semicolons or spaces are allowed. An example of this format would be 'a, b, c'. Note that leading and trailing spaces are skipped.\nThe second format expects events to be individual letters. The special prefix : is used to indicate this format. An example would be ':abc'.");
		bigInfoAPTList.put(isolated_elements2,"Find isolated elements in a graph");
		bigInfoAPTList.put(isomorphism2,"Check if two Petri nets have isomorphic reachability graphs");
		bigInfoAPTList.put(label_separation2,"Check if a LTS is T'-separated for some label set T'");
		bigInfoAPTList.put(language_equivalence2,"Check if two Petri nets generate the same language");
		bigInfoAPTList.put(limited_unfolding2,"Calculate the limited unfolding of a lts");
		bigInfoAPTList.put(overapproximate_synthesize2,"Synthesize the minimal Petri Net overapproximation from a transition system");
		bigInfoAPTList.put(persistent2,"Check if a Petri net or LTS is persistent");
		bigInfoAPTList.put(pn_extend_and_synthesize2,"Synthesize a Petri Net from a transition system, reusing places of a PetriNet");
		bigInfoAPTList.put(ppspresynthesis2,"Performs pps-presynthesis checks on a transition system");
		bigInfoAPTList.put(prime_cycle_property2,"Check if the give Petri net or LTS fulfills the prime cycle property");
		bigInfoAPTList.put(product_async2,"Compute the asynchronous product of two LTS");
		bigInfoAPTList.put(product_sync2,"Compute the synchronous product of two LTS");
		bigInfoAPTList.put(regular_language_to_lts2,"Represent a regular language as a transition system");
		bigInfoAPTList.put(reversible2,"Check if a Petri net or LTS is reversible");
		bigInfoAPTList.put(strong_components2, "Find the strongly connected components of a Petri net or LTS");
		bigInfoAPTList.put(strongly_connected2, "Check if a Petri net or LTS is strongly connected");
		bigInfoAPTList.put(synthesize2, "Synthesize a Petri Net from a transition system");
		bigInfoAPTList.put(to_regular_expression2,"Create a language-equivalent (up to prefix creation) regular expression");
		bigInfoAPTList.put(totally_reachable2,"Check if the given LTS is totally reachable");
		bigInfoAPTList.put(use_petrify2,"Check if Petrify can generate a Petri net from a LTS");
		bigInfoAPTList.put(use_synet2,"Check if Synet can generate a Petri net from a LTS");
		bigInfoAPTList.put(weak_components2,"Find the weakly connected components of a Petri net or LTS");
		bigInfoAPTList.put(weakly_connected2,"Check if a Petri net or LTS is weakly connected");
		bigInfoAPTList.put(word_synthesize2,"Synthesize a Petri Net from a word");

		//generators
		bigInfoAPTList.put(generators, "");
		bigInfoAPTList.put(bistate_philnet_generator,"Construct a Petri net for a bistate philosopher's net of a given size");
		bigInfoAPTList.put(bitnet_generator,"Construct a Petri net for a bit nets of a given size");
		bigInfoAPTList.put(connected_bitnet_generator,"Construct a Petri net for a connected bit net of a given size");
		bigInfoAPTList.put(cycle_generator,"Construct a Petri net for a cycle of a given size with a given number of initial token");
		bigInfoAPTList.put(generate_reverse_arc,"Generate reverse arcs for all arcs with a given label");
		bigInfoAPTList.put(inverse_generator,"Construct the inverse of a Petri net");
		bigInfoAPTList.put(quadstate_philnet_generator,"Construct a Petri net for a quadstate philosopher's net of a given size");
		bigInfoAPTList.put(random_t_net_generator,"Construct a T-net or T-system (if k given) of size g");
		bigInfoAPTList.put(tnet_generator,"Construct all T-nets up to a given size");
		bigInfoAPTList.put(tristate_philnet_generator,"Construct a Petri net for a tristate philosopher's net of a given size");

		//conveters
		bigInfoAPTList.put(conveters, "");
		bigInfoAPTList.put(draw_convert,"Convert a Petri net or LTS to the Dot format used by Graphviz");






	}

	public HashMap<String, String> getBigList()
	{
		return BigInfoAPTList.bigInfoAPTList;
	}

	public ObservableList<String> getTypesList()
	{
		return BigInfoAPTList.typesList;
	}

	public String getMiscHeader()
	{
		return this.misc;
	}

	public String getPetriNetsHeader()
	{
		return this.petri_net;
	}

	public String getLTSHeader()
	{
		return this.lts;
	}


	public String getHelp()
	{
		return help;
	}


	public String getDraw()
	{
		return draw;
	}

	public String getGeneratorsHeader()
	{
		return this.generators;
	}

	public String getConvetersHeader()
	{
		return this.conveters;
	}


	public String getAc()
	{
		return ac;
	}


	public String getPetri_net()
	{
		return petri_net;
	}


	public String getBackward_persistent()
	{
		return backward_persistent;
	}


	public String getBcf()
	{
		return bcf;
	}


	public String getBicf()
	{
		return bicf;
	}


	public String getBisimulation()
	{
		return bisimulation;
	}


	public String getBounded()
	{
		return bounded;
	}


	public String getCf()
	{
		return cf;
	}


	public String getCheck()
	{
		return check;
	}


	public String getCheck_all_cycle_prop()
	{
		return check_all_cycle_prop;
	}


	public String getCompute_pvs()
	{
		return compute_pvs;
	}


	public String getConcurrent_coverability_graph()
	{
		return concurrent_coverability_graph;
	}


	public String getConpres()
	{
		return conpres;
	}


	public String getCoverability_graph()
	{
		return coverability_graph;
	}


	public String getCovered_by_invariant()
	{
		return covered_by_invariant;
	}


	public String getCycles_same_disjoint_pv()
	{
		return cycles_same_disjoint_pv;
	}


	public String getCycles_same_pv()
	{
		return cycles_same_pv;
	}


	public String getExamine_pn()
	{
		return examine_pn;
	}


	public String getFairness()
	{
		return fairness;
	}


	public String getFc()
	{
		return fc;
	}


	public String getFire_sequence()
	{
		return fire_sequence;
	}


	public String getHomogeneous()
	{
		return homogeneous;
	}


	public String getInvariants()
	{
		return invariants;
	}


	public String getIsolated()
	{
		return isolated;
	}


	public String getIsolated_elements()
	{
		return isolated_elements;
	}


	public String getIsomorphism()
	{
		return isomorphism;
	}


	public String getK_bounded()
	{
		return k_bounded;
	}


	public String getK_marking()
	{
		return k_marking;
	}


	public String getLanguage_equivalence()
	{
		return language_equivalence;
	}


	public String getMatrices()
	{
		return matrices;
	}


	public String getMf()
	{
		return mf;
	}


	public String getNonpure()
	{
		return nonpure;
	}


	public String getOn()
	{
		return on;
	}


	public String getPersistent()
	{
		return persistent;
	}


	public String getPlain()
	{
		return plain;
	}


	public String getPn_analysis()
	{
		return pn_analysis;
	}


	public String getPrime_cycle_property()
	{
		return prime_cycle_property;
	}


	public String getPure()
	{
		return pure;
	}


	public String getReachability_graph()
	{
		return reachability_graph;
	}


	public String getReversible()
	{
		return reversible;
	}


	public String getRfc()
	{
		return rfc;
	}


	public String getSafe()
	{
		return safe;
	}


	public String getSideconditions()
	{
		return sideconditions;
	}


	public String getSimply_live()
	{
		return simply_live;
	}


	public String getSiphons()
	{
		return siphons;
	}


	public String getSnet()
	{
		return snet;
	}


	public String getStrong_components()
	{
		return strong_components;
	}


	public String getStrong_separation()
	{
		return strong_separation;
	}


	public String getStrong_separation_length()
	{
		return strong_separation_length;
	}


	public String getStrongly_connected()
	{
		return strongly_connected;
	}


	public String getStrongly_live()
	{
		return strongly_live;
	}


	public String getSum_async()
	{
		return sum_async;
	}


	public String getSum_sync()
	{
		return sum_sync;
	}


	public String getTnet()
	{
		return tnet;
	}


	public String getTo_regular_expression()
	{
		return to_regular_expression;
	}


	public String getTraps()
	{
		return traps;
	}


	public String getWeak_components()
	{
		return weak_components;
	}


	public String getWeak_separation()
	{
		return weak_separation;
	}


	public String getWeak_separation_length()
	{
		return weak_separation_length;
	}


	public String getWeakly_connected()
	{
		return weakly_connected;
	}


	public String getWeakly_live()
	{
		return weakly_live;
	}


	public String getWfc()
	{
		return wfc;
	}


	public String getWord()
	{
		return word;
	}


	public String getMisc()
	{
		return misc;
	}



	public String getBackward_persistent2()
	{
		return backward_persistent2;
	}


	public String getBackwards_deterministic2()
	{
		return backwards_deterministic2;
	}


	public String getBisimulation2()
	{
		return bisimulation2;
	}


	public String getCreate_lts2()
	{
		return create_lts2;
	}


	public String getCompute_pvs2()
	{
		return compute_pvs2;
	}


	public String getCycles_same_disjoint_pv2()
	{
		return cycles_same_disjoint_pv2;
	}


	public String getCycles_same_pv2()
	{
		return cycles_same_pv2;
	}


	public String getDeterministic2()
	{
		return deterministic2;
	}


	public String getExamine_lts2()
	{
		return examine_lts2;
	}


	public String getExtend_deterministic_persistent2()
	{
		return extend_deterministic_persistent2;
	}


	public String getExtend_lts2()
	{
		return extend_lts2;
	}


	public String getFactorize2()
	{
		return factorize2;
	}


	public String getFairness2()
	{
		return fairness2;
	}


	public String getFind_words2()
	{
		return find_words2;
	}


	public String getGdiam2()
	{
		return gdiam2;
	}


	public String getIsolated_elements2()
	{
		return isolated_elements2;
	}


	public String getIsomorphism2()
	{
		return isomorphism2;
	}


	public String getLabel_separation2()
	{
		return label_separation2;
	}


	public String getLanguage_equivalence2()
	{
		return language_equivalence2;
	}


	public String getLimited_unfolding2()
	{
		return limited_unfolding2;
	}


	public String getOverapproximate_synthesize2()
	{
		return overapproximate_synthesize2;
	}


	public String getPersistent2()
	{
		return persistent2;
	}


	public String getPn_extend_and_synthesize2()
	{
		return pn_extend_and_synthesize2;
	}


	public String getPpspresynthesis2()
	{
		return ppspresynthesis2;
	}


	public String getPrime_cycle_property2()
	{
		return prime_cycle_property2;
	}


	public String getProduct_async2()
	{
		return product_async2;
	}


	public String getProduct_sync2()
	{
		return product_sync2;
	}


	public String getRegular_language_to_lts2()
	{
		return regular_language_to_lts2;
	}


	public String getReversible2()
	{
		return reversible2;
	}


	public String getStrong_components2()
	{
		return strong_components2;
	}


	public String getStrongly_connected2()
	{
		return strongly_connected2;
	}


	public String getSynthesize2()
	{
		return synthesize2;
	}


	public String getTo_regular_expression2()
	{
		return to_regular_expression2;
	}


	public String getTotally_reachable2()
	{
		return totally_reachable2;
	}


	public String getUse_petrify2()
	{
		return use_petrify2;
	}


	public String getUse_synet2()
	{
		return use_synet2;
	}


	public String getWeak_components2()
	{
		return weak_components2;
	}


	public String getWeakly_connected2()
	{
		return weakly_connected2;
	}


	public String getWord_synthesize2()
	{
		return word_synthesize2;
	}


	public String getBistate_philnet_generator()
	{
		return bistate_philnet_generator;
	}


	public String getBitnet_generator()
	{
		return bitnet_generator;
	}


	public String getConnected_bitnet_generator()
	{
		return connected_bitnet_generator;
	}


	public String getCycle_generator()
	{
		return cycle_generator;
	}


	public String getGenerate_reverse_arc()
	{
		return generate_reverse_arc;
	}


	public String getInverse_generator()
	{
		return inverse_generator;
	}


	public String getQuadstate_philnet_generator()
	{
		return quadstate_philnet_generator;
	}


	public String getRandom_t_net_generator()
	{
		return random_t_net_generator;
	}


	public String getTnet_generator()
	{
		return tnet_generator;
	}


	public String getTristate_philnet_generator()
	{
		return tristate_philnet_generator;
	}


	public String getDraw_convert()
	{
		return draw_convert;
	}


	public String getLts_convert()
	{
		return lts_convert;
	}


	public String getPn_convert()
	{
		return pn_convert;
	}


	public static void setTypesList(ObservableList<String> typesList)
	{
		BigInfoAPTList.typesList = typesList;
	}

}
