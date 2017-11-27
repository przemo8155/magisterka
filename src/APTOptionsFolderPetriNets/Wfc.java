package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Wfc
{
	public ObservableList<String> wfcClassList = FXCollections.observableArrayList();


	public Wfc()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getWfcClassList()
	{
		return wfcClassList;
	}


	public void setWfcClassList(ObservableList<String> wfcClassList)
	{
		this.wfcClassList = wfcClassList;
	}
}
