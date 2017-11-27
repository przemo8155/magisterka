package APTOptionsFolderPetriNets;

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


	public ObservableList<String> helpClassList = FXCollections.observableArrayList();
	public Help()
	{
		helpClassList.add(petri_net);
		helpClassList.add(ac);
		helpClassList.add(backward_persistent);
		helpClassList.add(bcf);
		helpClassList.add(bicf);
		helpClassList.add(bisimulation);
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
		helpClassList.add(check);
		helpClassList.add(check_all_cycle_prop);
		helpClassList.add(compute_pvs);
		helpClassList.add(concurrent_coverability_graph);
		helpClassList.add(conpres);
		helpClassList.add(coverability_graph);
		helpClassList.add(covered_by_invariant);
		helpClassList.add(cycles_same_disjoint_pv);
		helpClassList.add(cycles_same_pv);
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
