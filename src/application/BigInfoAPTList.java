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
		typesList.add(check);
		typesList.add(check_all_cycle_prop);
		typesList.add(compute_pvs);
		typesList.add(concurrent_coverability_graph);
		typesList.add(conpres);
		typesList.add(coverability_graph);
		typesList.add(covered_by_invariant);
		typesList.add(cycles_same_disjoint_pv);
		typesList.add(cycles_same_pv);
		typesList.add(cf);
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




		//bigInfo
		//misc
		bigInfoAPTList.put(misc, "");
		bigInfoAPTList.put(draw, "Convert a Petri net or LTS to the Dot format used by Graphviz");
		bigInfoAPTList.put(help, "Get information about a module");
		//petri nets
		bigInfoAPTList.put(petri_net, "");
		bigInfoAPTList.put(ac, "Check if a Petri net is asymmetric-choice");
		bigInfoAPTList.put(backward_persistent, "Check if a Petri net or LTS is backward persistent");
		bigInfoAPTList.put(bcf, "Check if a Petri net is behaviourally conflict free (BCF)");
		bigInfoAPTList.put(bicf, "Check if a Petri net is binary conflict free (BiCF)");
		bigInfoAPTList.put(bisimulation, "Check if the reachability graphs of two bounded labeled Petri nets or of two LTS or a combination of both are bisimilar");
		bigInfoAPTList.put(bounded, "Check if a Petri net is bounded or k-bounded");
		bigInfoAPTList.put(cf, "Check if a plain Petri net is conflict-free");
		bigInfoAPTList.put(check, "Search for a Petri net which fulfills the given attributes");
		bigInfoAPTList.put(check_all_cycle_prop, "Check all cycle properties of a Petri net");
		bigInfoAPTList.put(compute_pvs, "Compute parikh vectors of smallest cycles of a Petri net or LTS");
		bigInfoAPTList.put(concurrent_coverability_graph, "Calculate the concurrent coverability graph of a Petri net in the step semantics");
		bigInfoAPTList.put(conpres, "Check if a Petri net is concurrency-preserving");
		bigInfoAPTList.put(coverability_graph, "Compute a Petri net's coverability graph");
		bigInfoAPTList.put(covered_by_invariant, "Check if a Petri net is covered by an S-invariant or a T-invariant");
		bigInfoAPTList.put(cycles_same_disjoint_pv, "Check if the smallest cycles of a Petri net or LTS have the same or mutually disjoint parikh vectors");
		bigInfoAPTList.put(cycles_same_pv, "Check if the smallest cycles of Petri net or LTS have the same parikh vector");
		bigInfoAPTList.put(examine_pn, "Perform various tests on a Petri net at once");
		bigInfoAPTList.put(fairness, "Check if a Petri net or transition system is fair");
		bigInfoAPTList.put(fc, "Check if a Petri net is free-choice");
		bigInfoAPTList.put(fire_sequence, "Try to fire a given firing sequence on a Petri net");
		bigInfoAPTList.put(homogeneous, "Check if a Petri net is homogeneous");
		bigInfoAPTList.put(invariants, "Compute a generator set of S- or T-invariants");
		bigInfoAPTList.put(isolated, "Check if a Petri net contains isolated elements");
		bigInfoAPTList.put(isolated_elements, "Find isolated elements in a graph");
		bigInfoAPTList.put(isomorphism, "Check if two Petri nets have isomorphic reachability graphs");
		bigInfoAPTList.put(k_bounded, "Find the smallest k for which a Petri net is k-bounded");
		bigInfoAPTList.put(k_marking, "Compute the largest k for which M0 is a k-marking");
		bigInfoAPTList.put(language_equivalence, "Check if two Petri nets generate the same language");
		bigInfoAPTList.put(matrices, "Calculate forward, backward, and incidence matrices");
		bigInfoAPTList.put(mf, "Check if a Petri net is merge-free");
		bigInfoAPTList.put(nonpure, "Check if a Petri net is nonpure but only simple sideconditions");
		bigInfoAPTList.put(on, "Check if a Petri net is output-nonbranching");
		bigInfoAPTList.put(persistent, "Check if a Petri net or LTS is persistent");
		bigInfoAPTList.put(plain, "Check if a Petri net is plain");
		bigInfoAPTList.put(pn_analysis, "Output a T-system of size g, which has a reachability graph, which is isomorph to the reachability graph of the input Petri net");
		bigInfoAPTList.put(prime_cycle_property, "Check if the give Petri net or LTS fulfills the prime cycle property");
		bigInfoAPTList.put(pure, "Check if a Petri net is pure");
		bigInfoAPTList.put(reachability_graph, "Compute a Petri net's reachability graph");
		bigInfoAPTList.put(reversible, "Check if a Petri net or LTS is reversible");
		bigInfoAPTList.put(rfc, "Check if a Petri net is restricted-free-choice");
		bigInfoAPTList.put(safe, "Check if a Petri net is safe");
		bigInfoAPTList.put(sideconditions, "Compute the sideconditions of a Petri net");
		bigInfoAPTList.put(simply_live, "Check if a Petri net or a transition (if given) is simply live");
		bigInfoAPTList.put(siphons, "Compute all minimal siphons in a Petri net");
		bigInfoAPTList.put(snet, "Check if a plain Petri net is an S-net");
		bigInfoAPTList.put(strong_components, "Find the strongly connected components of a Petri net or LTS");
		bigInfoAPTList.put(strong_separation, "Check if a given sequence is strongly k-separable");
		bigInfoAPTList.put(strong_separation_length, "Check if all sequences up to a length are strongly k-separable");
		bigInfoAPTList.put(strongly_connected, "Check if a Petri net or LTS is strongly connected");
		bigInfoAPTList.put(strongly_live, "Check if a Petri net or a transition (if given) is strongly live");
		bigInfoAPTList.put(sum_async, "Compute the synchronous sum of two PN");
		bigInfoAPTList.put(sum_sync, "Compute the synchronous sum of two PN");
		bigInfoAPTList.put(tnet, "Check if a plain Petri net is a T-net");
		bigInfoAPTList.put(to_regular_expression, "Create a language-equivalent (up to prefix creation) regular expression");
		bigInfoAPTList.put(traps, "Compute all minimal traps in a Petri net");
		bigInfoAPTList.put(weak_components, "Find the weakly connected components of a Petri net or LTS");
		bigInfoAPTList.put(weak_separation, "Check if a given sequence is weakly k-separable");
		bigInfoAPTList.put(weak_separation_length, "Check if all sequences up to a length are weakly k-separable");
		bigInfoAPTList.put(weakly_connected, "Check if a Petri net or LTS is weakly connected");
		bigInfoAPTList.put(weakly_live, "Check if a Petri net or a transition (if given) is weakly live");
		bigInfoAPTList.put(wfc, "Check if a Petri net is weighted free-choice");
		bigInfoAPTList.put(word, " Check if a word is in a Petri net's prefix language");

		//lts





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


	public String getHelp()
	{
		return help;
	}


	public String getDraw()
	{
		return draw;
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

}
