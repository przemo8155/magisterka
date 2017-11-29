package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StronglyConnected
{
	public ObservableList<String> stronglyConnectedClassList = FXCollections.observableArrayList();


	public StronglyConnected()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getStronglyConnectedClassList()
	{
		return stronglyConnectedClassList;
	}


	public void setStronglyConnectedClassList(ObservableList<String> stronglyConnectedClassList)
	{
		this.stronglyConnectedClassList = stronglyConnectedClassList;
	}
}
