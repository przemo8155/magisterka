package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pure
{
	public ObservableList<String> pureClassList = FXCollections.observableArrayList();


	public Pure()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getPureClassList()
	{
		return pureClassList;
	}


	public void setPureClassList(ObservableList<String> pureClassList)
	{
		this.pureClassList = pureClassList;
	}
}
