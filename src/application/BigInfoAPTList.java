package application;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public class BigInfoAPTList
{
	public static HashMap<String, String> bigInfoAPTList = new HashMap<String, String> ();


	public BigInfoAPTList()
	{
		//misc
		bigInfoAPTList.put("draw", "Convert a Petri net or LTS to the Dot format used by Graphviz");
		bigInfoAPTList.put("help", "Get information about a module");
		//petri nets

	}

	public HashMap<String, String> getBigList()
	{
		return BigInfoAPTList.bigInfoAPTList;
	}

}
