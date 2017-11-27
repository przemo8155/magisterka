package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BackwardPersistent
{
	public ObservableList<String> backwardPersistentClassList = FXCollections.observableArrayList();


	public BackwardPersistent()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getBackwardPersistentClassList()
	{
		return backwardPersistentClassList;
	}


	public void setBackwardPersistentClassList(ObservableList<String> backwardPersistentClassList)
	{
		this.backwardPersistentClassList = backwardPersistentClassList;
	}
}
