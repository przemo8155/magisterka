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

	//bez getera
	private final String backward_persistent = "backward_persistent";
	private final String bcf = "bcf";


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

}
