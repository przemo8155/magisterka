package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Fc
{
	public ObservableList<String> fcClassList = FXCollections.observableArrayList();



	public Fc()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getFcClassList()
	{
		return fcClassList;
	}


	public void setFcClassList(ObservableList<String> fcClassList)
	{
		this.fcClassList = fcClassList;
	}
}
