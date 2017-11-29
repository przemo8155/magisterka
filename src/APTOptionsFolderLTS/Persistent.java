package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Persistent
{
	public ObservableList<String> persistentClassList = FXCollections.observableArrayList();


	public Persistent()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getPersistentClassList()
	{
		return persistentClassList;
	}


	public void setPersistentClassList(ObservableList<String> persistentClassList)
	{
		this.persistentClassList = persistentClassList;
	}
}
