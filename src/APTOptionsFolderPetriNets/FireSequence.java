package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FireSequence
{
	public ObservableList<String> fireSequenceClassList = FXCollections.observableArrayList();


	public FireSequence()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getFireSequenceClassList()
	{
		return fireSequenceClassList;
	}


	public void setFireSequenceClassList(ObservableList<String> fireSequenceClassList)
	{
		this.fireSequenceClassList = fireSequenceClassList;
	}
}
