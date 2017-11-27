package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Isolated
{
	public ObservableList<String> isolatedClassList = FXCollections.observableArrayList();


	public Isolated()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getIsolatedClassList()
	{
		return isolatedClassList;
	}


	public void setIsolatedClassList(ObservableList<String> isolatedClassList)
	{
		this.isolatedClassList = isolatedClassList;
	}
}
