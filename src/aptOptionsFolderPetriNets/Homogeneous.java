package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Homogeneous
{
	public ObservableList<String> homogeneousClassList = FXCollections.observableArrayList();


	public Homogeneous()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getHomogeneousClassList()
	{
		return homogeneousClassList;
	}


	public void setHomogeneousClassList(ObservableList<String> homogeneousClassList)
	{
		this.homogeneousClassList = homogeneousClassList;
	}
}
