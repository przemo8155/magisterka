package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Snet
{
	public ObservableList<String> snetClassList = FXCollections.observableArrayList();


	public Snet()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getSnetClassList()
	{
		return snetClassList;
	}


	public void setSnetClassList(ObservableList<String> snetClassList)
	{
		this.snetClassList = snetClassList;
	}
}
