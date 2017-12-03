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
}
