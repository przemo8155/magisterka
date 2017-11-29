package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Nonpure
{
	public ObservableList<String> nonpureClassList = FXCollections.observableArrayList();


	public Nonpure()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getNonpureClassList()
	{
		return nonpureClassList;
	}


	public void setNonpureClassList(ObservableList<String> nonpureClassList)
	{
		this.nonpureClassList = nonpureClassList;
	}
}
