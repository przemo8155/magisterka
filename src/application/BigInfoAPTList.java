package application;

import java.util.HashMap;

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



	public BigInfoAPTList()
	{
		//typesList
		typesList.add(misc);
		typesList.add(draw);
		typesList.add(help);


		//bigInfo
		//misc
		bigInfoAPTList.put("MISC", "");
		bigInfoAPTList.put(draw, "Convert a Petri net or LTS to the Dot format used by Graphviz");
		bigInfoAPTList.put(help, "Get information about a module");
		//petri nets

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

}
