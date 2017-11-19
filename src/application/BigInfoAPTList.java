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
