package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PnExtendAndSynthesize
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



	public ObservableList<String> pnExtendAndSynthesizeOptionsClassList = FXCollections.observableArrayList();


	public PnExtendAndSynthesize()
	{
		pnExtendAndSynthesizeOptionsClassList.add(bcf);
		pnExtendAndSynthesizeOptionsClassList.add(bicf);
		pnExtendAndSynthesizeOptionsClassList.add(cf);
		pnExtendAndSynthesizeOptionsClassList.add(homogeneous);
		pnExtendAndSynthesizeOptionsClassList.add(mf);
		pnExtendAndSynthesizeOptionsClassList.add(on);
		pnExtendAndSynthesizeOptionsClassList.add(pure);
		pnExtendAndSynthesizeOptionsClassList.add(safe);
		pnExtendAndSynthesizeOptionsClassList.add(tnet);

	}

	public ObservableList<String> getPnExtendAndSynthesizeOptionsClassList()
	{
		return pnExtendAndSynthesizeOptionsClassList;
	}


	public void setPnExtendAndSynthesizeOptionsClassList(ObservableList<String> pnExtendAndSynthesizeOptionsClassList)
	{
		this.pnExtendAndSynthesizeOptionsClassList = pnExtendAndSynthesizeOptionsClassList;
	}
}
