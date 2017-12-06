/**
 *
 */
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author przem
 *
 */
public class OptionsHeaders
{
	private final String help2 = "Module name";
	private final String bisimulation2 = "The first Petri net that should be examined";
	private final String bisimulation3 = "The second Petri net that should be examined";
	private final String bounded2 = "If given, k-boundedness is checked";
	private final String check2 = "Generators";
	private final String check3 = "Attributes";
	private final String check4 = "Max seconds";
	private final String covered_by_invariant2 = "Parameter 's' for s-invariants and 't' for t-invariants";
	private final String covered_by_invariant3 = "Parameter 'f' for farkas algorithm and 'p' for the adapted farkas algorithm of pipe";
	private final String fairness2 = "If given, break if a k-unfair situation is found The default value is '0'";
	private final String fairness3 = "If given, fairness regarding this event is checked";
	private final String fire_sequence2 = "Sequence that should be fired";
	private final String invariants2 = "Parameter 's' for s-invariants and 't' for t-invariants";
	private final String invariants3 = "Parameter 'f' for Farkas algorithm and 'p' for the adapted Farkas algorithm of PIPE";
	private final String pn_analysis2 = "maximum size of places of the checked T-systems";
	private final String pn_analysis3 = "maximum number of token of the checked T-systems";
	private final String pn_analysis4 = "Parameter, which say, that a randomly selected T-system is checked with g as maximum size of places. The default value is ''";
	private final String simply_live2 = "A transition that should be checked for liveness";
	private final String strong_separation2 = "Firing sequence which should be checked";
	private final String strong_separation3 = "Value of k";
	private final String strong_separation4 = "Optional more output";
	private final String strong_separation_length2 = "Maximum length of firing sequences";
	private final String strong_separation_length3 = "Value of k";
	private final String strong_separation_length4 = "Optional more output";
	private final String strongly_live2 = "A transition that should be checked for liveness";
	private final String weak_separation2 = "Firing sequence which should be checked";
	private final String weak_separation3 = "Value of k";
	private final String weak_separation4 = "Optional more output";
	private final String weak_separation_length2 = "Maximum length of firing sequences";
	private final String weak_separation_length3 = "Value of k";
	private final String weak_separation_length4 = "Optional more output";
	private final String weakly_live2 = "A transition that should be checked for liveness";
	private final String extend_deterministic_persistent2 = "Maximum allowed number of processing rounds that add new states";


	public ObservableList<String> optionsHeadersList = FXCollections.observableArrayList();


	public OptionsHeaders()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getOptionsHeadersList()
	{
		return optionsHeadersList;
	}


	public void setOptionsHeadersList(ObservableList<String> optionsHeadersList)
	{
		this.optionsHeadersList = optionsHeadersList;
	}


	public String getHelp2()
	{
		return help2;
	}


	public String getBisimulation2()
	{
		return bisimulation2;
	}


	public String getBisimulation3()
	{
		return bisimulation3;
	}


	public String getBounded2()
	{
		return bounded2;
	}


	public String getCheck2()
	{
		return check2;
	}


	public String getCheck3()
	{
		return check3;
	}


	public String getCheck4()
	{
		return check4;
	}


	public String getCovered_by_invariant2()
	{
		return covered_by_invariant2;
	}


	public String getCovered_by_invariant3()
	{
		return covered_by_invariant3;
	}


	public String getFairness2()
	{
		return fairness2;
	}


	public String getFairness3()
	{
		return fairness3;
	}


	public String getFire_sequence2()
	{
		return fire_sequence2;
	}


	public String getInvariants2()
	{
		return invariants2;
	}


	public String getInvariants3()
	{
		return invariants3;
	}


	public String getPn_analysis2()
	{
		return pn_analysis2;
	}


	public String getPn_analysis3()
	{
		return pn_analysis3;
	}


	public String getPn_analysis4()
	{
		return pn_analysis4;
	}


	public String getSimply_live2()
	{
		return simply_live2;
	}


	public String getStrong_separation2()
	{
		return strong_separation2;
	}


	public String getStrong_separation3()
	{
		return strong_separation3;
	}


	public String getStrong_separation4()
	{
		return strong_separation4;
	}


	public String getStrong_separation_length2()
	{
		return strong_separation_length2;
	}


	public String getStrong_separation_length3()
	{
		return strong_separation_length3;
	}


	public String getStrong_separation_length4()
	{
		return strong_separation_length4;
	}


	public String getStrongly_live2()
	{
		return strongly_live2;
	}


	public String getWeak_separation2()
	{
		return weak_separation2;
	}


	public String getWeak_separation3()
	{
		return weak_separation3;
	}


	public String getWeak_separation4()
	{
		return weak_separation4;
	}


	public String getWeak_separation_length2()
	{
		return weak_separation_length2;
	}


	public String getWeak_separation_length3()
	{
		return weak_separation_length3;
	}


	public String getWeak_separation_length4()
	{
		return weak_separation_length4;
	}


	public String getWeakly_live2()
	{
		return weakly_live2;
	}


	public String getExtend_deterministic_persistent2()
	{
		return extend_deterministic_persistent2;
	}
}
