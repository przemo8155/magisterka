package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KMarking
{
	public ObservableList<String> kMarkingClassList = FXCollections.observableArrayList();


	public KMarking()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getkMarkingClassList()
	{
		return kMarkingClassList;
	}


	public void setkMarkingClassList(ObservableList<String> kMarkingClassList)
	{
		this.kMarkingClassList = kMarkingClassList;
	}
}
