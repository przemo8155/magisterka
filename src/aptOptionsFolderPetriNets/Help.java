package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Help
{
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



	private static ObservableList<String> helpClassList = FXCollections.observableArrayList();
	public Help()
	{
		//typesList
				//misc
				helpClassList.add(misc);
				helpClassList.add(draw);
				helpClassList.add(help);
				//petri net
				helpClassList.add(petri_net);
				helpClassList.add(ac);
				helpClassList.add(backward_persistent);
				helpClassList.add(bcf);
				helpClassList.add(bicf);
				helpClassList.add(bisimulation);
				helpClassList.add(bounded);
				helpClassList.add(check);
				helpClassList.add(check_all_cycle_prop);
				helpClassList.add(compute_pvs);
				helpClassList.add(concurrent_coverability_graph);
				helpClassList.add(conpres);
				helpClassList.add(coverability_graph);
				helpClassList.add(covered_by_invariant);
				helpClassList.add(cycles_same_disjoint_pv);
				helpClassList.add(cycles_same_pv);
				helpClassList.add(cf);
				helpClassList.add(examine_pn);
				helpClassList.add(fairness);
				helpClassList.add(fc);
				helpClassList.add(fire_sequence);
				helpClassList.add(homogeneous);
				helpClassList.add(invariants);
				helpClassList.add(isolated);
				helpClassList.add(isolated_elements);
				helpClassList.add(isomorphism);
				helpClassList.add(k_bounded);
				helpClassList.add(k_marking);
				helpClassList.add(language_equivalence);
				helpClassList.add(matrices);
				helpClassList.add(mf);
				helpClassList.add(nonpure);
				helpClassList.add(on);
				helpClassList.add(persistent);
				helpClassList.add(plain);
				helpClassList.add(pn_analysis);
				helpClassList.add(prime_cycle_property);
				helpClassList.add(pure);
				helpClassList.add(reachability_graph);
				helpClassList.add(reversible);
				helpClassList.add(rfc);
				helpClassList.add(safe);
				helpClassList.add(sideconditions);
				helpClassList.add(simply_live);
				helpClassList.add(siphons);
				helpClassList.add(snet);
				helpClassList.add(strong_components);
				helpClassList.add(strong_separation);
				helpClassList.add(strong_separation_length);
				helpClassList.add(strongly_connected);
				helpClassList.add(strongly_live);
				helpClassList.add(sum_async);
				helpClassList.add(sum_sync);
				helpClassList.add(tnet);
				helpClassList.add(to_regular_expression);
				helpClassList.add(traps);
				helpClassList.add(weak_components);
				helpClassList.add(weak_separation);
				helpClassList.add(weak_separation_length);
				helpClassList.add(weakly_connected);
				helpClassList.add(weakly_live);
				helpClassList.add(wfc);
				helpClassList.add(word);

				//lts
				helpClassList.add(lts);
				helpClassList.add(backward_persistent2);
				helpClassList.add(backwards_deterministic2);
				helpClassList.add(bisimulation2);
				helpClassList.add(compute_pvs2);
				helpClassList.add(create_lts2);
				helpClassList.add(cycles_same_disjoint_pv2);
				helpClassList.add(cycles_same_pv2);
				helpClassList.add(deterministic2);
				helpClassList.add(examine_lts2);
				helpClassList.add(extend_deterministic_persistent2);
				helpClassList.add(extend_lts2);
				helpClassList.add(factorize2);
				helpClassList.add(fairness2);
				helpClassList.add(find_words2);
				helpClassList.add(gdiam2);
				helpClassList.add(isolated_elements2);
				helpClassList.add(isomorphism2);
				helpClassList.add(label_separation2);
				helpClassList.add(language_equivalence2);
				helpClassList.add(limited_unfolding2);
				helpClassList.add(overapproximate_synthesize2);
				helpClassList.add(persistent2);
				helpClassList.add(pn_extend_and_synthesize2);
				helpClassList.add(ppspresynthesis2);
				helpClassList.add(prime_cycle_property2);
				helpClassList.add(product_async2);
				helpClassList.add(product_sync2);
				helpClassList.add(regular_language_to_lts2);
				helpClassList.add(reversible2);
				helpClassList.add(strong_components2);
				helpClassList.add(strongly_connected2);
				helpClassList.add(synthesize2);
				helpClassList.add(to_regular_expression2);
				helpClassList.add(totally_reachable2);
				helpClassList.add(use_petrify2);
				helpClassList.add(use_synet2);
				helpClassList.add(weak_components2);
				helpClassList.add(weakly_connected2);
				helpClassList.add(word_synthesize2);

				//generators
				helpClassList.add(generators);
				helpClassList.add(bistate_philnet_generator);
				helpClassList.add(bitnet_generator);
				helpClassList.add(connected_bitnet_generator);
				helpClassList.add(cycle_generator);
				helpClassList.add(generate_reverse_arc);
				helpClassList.add(inverse_generator);
				helpClassList.add(quadstate_philnet_generator);
				helpClassList.add(random_t_net_generator);
				helpClassList.add(tnet_generator);
				helpClassList.add(tristate_philnet_generator);

				//converts
				helpClassList.add(conveters);
				helpClassList.add(draw_convert);


	}

	public ObservableList<String> getHelpClassList()
	{
		return helpClassList;
	}

	public void setHelpClassList(ObservableList<String> helpClassList)
	{
		this.helpClassList = helpClassList;
	}
}
