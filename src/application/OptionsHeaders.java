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
}
