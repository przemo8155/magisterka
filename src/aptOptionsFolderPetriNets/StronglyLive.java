package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StronglyLive
{
	public ObservableList<String> stronglyLiveClassList = FXCollections.observableArrayList();


	public StronglyLive()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getStronglyLiveClassList()
	{
		return stronglyLiveClassList;
	}


	public void setStronglyLiveClassList(ObservableList<String> stronglyLiveClassList)
	{
		this.stronglyLiveClassList = stronglyLiveClassList;
	}
}
