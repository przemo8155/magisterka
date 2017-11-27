package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Siphons
{
	public ObservableList<String> siphonsClassList = FXCollections.observableArrayList();


	public Siphons()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getSiphonsClassList()
	{
		return siphonsClassList;
	}


	public void setSiphonsClassList(ObservableList<String> siphonsClassList)
	{
		this.siphonsClassList = siphonsClassList;
	}
}
