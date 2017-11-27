package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IsolatedElements
{
	public ObservableList<String> isolatedElementsClassList = FXCollections.observableArrayList();


	public IsolatedElements()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getIsolatedElementsClassList()
	{
		return isolatedElementsClassList;
	}


	public void setIsolatedElementsClassList(ObservableList<String> isolatedElementsClassList)
	{
		this.isolatedElementsClassList = isolatedElementsClassList;
	}
}
