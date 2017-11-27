package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bicf
{
	public ObservableList<String> bicfClassList = FXCollections.observableArrayList();

	public Bicf()
	{

	}


	public ObservableList<String> getBicfClassList()
	{
		return bicfClassList;
	}


	public void setBicfClassList(ObservableList<String> bicfClassList)
	{
		this.bicfClassList = bicfClassList;
	}
}
