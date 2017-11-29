package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StrongComponents
{
	public ObservableList<String> strongComponentsClassList = FXCollections.observableArrayList();


	public StrongComponents()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getStrongComponentsClassList()
	{
		return strongComponentsClassList;
	}


	public void setStrongComponentsClassList(ObservableList<String> strongComponentsClassList)
	{
		this.strongComponentsClassList = strongComponentsClassList;
	}
}
