package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeaklyConnected
{
	public ObservableList<String> weaklyConnectedClassList = FXCollections.observableArrayList();


	public WeaklyConnected()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getWeaklyConnectedClassList()
	{
		return weaklyConnectedClassList;
	}


	public void setWeaklyConnectedClassList(ObservableList<String> weaklyConnectedClassList)
	{
		this.weaklyConnectedClassList = weaklyConnectedClassList;
	}
}
