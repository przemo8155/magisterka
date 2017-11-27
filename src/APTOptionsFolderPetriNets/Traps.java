package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Traps
{
	public ObservableList<String> trapsClassList = FXCollections.observableArrayList();


	public Traps()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getTrapsClassList()
	{
		return trapsClassList;
	}


	public void setTrapsClassList(ObservableList<String> trapsClassList)
	{
		this.trapsClassList = trapsClassList;
	}
}
