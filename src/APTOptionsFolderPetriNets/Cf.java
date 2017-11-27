package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cf
{
	public ObservableList<String> cfClassList = FXCollections.observableArrayList();


	public Cf()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getCfClassList()
	{
		return cfClassList;
	}


	public void setCfClassList(ObservableList<String> cfClassList)
	{
		this.cfClassList = cfClassList;
	}
}
