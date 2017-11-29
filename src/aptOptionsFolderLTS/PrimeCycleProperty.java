package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PrimeCycleProperty
{
	public ObservableList<String> primeCyclePropertyClassList = FXCollections.observableArrayList();


	public PrimeCycleProperty()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getPrimeCyclePropertyClassList()
	{
		return primeCyclePropertyClassList;
	}


	public void setPrimeCyclePropertyClassList(ObservableList<String> primeCyclePropertyClassList)
	{
		this.primeCyclePropertyClassList = primeCyclePropertyClassList;
	}
}
