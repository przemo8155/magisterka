package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KBounded
{
	public ObservableList<String> kBoundedClassList = FXCollections.observableArrayList();


	public KBounded()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getkBoundedClassList()
	{
		return kBoundedClassList;
	}


	public void setkBoundedClassList(ObservableList<String> kBoundedClassList)
	{
		this.kBoundedClassList = kBoundedClassList;
	}
}
