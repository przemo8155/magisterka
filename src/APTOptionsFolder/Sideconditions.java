package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sideconditions
{
	public ObservableList<String> sideconditionsClassList = FXCollections.observableArrayList();


	public Sideconditions()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getSideconditionsClassList()
	{
		return sideconditionsClassList;
	}


	public void setSideconditionsClassList(ObservableList<String> sideconditionsClassList)
	{
		this.sideconditionsClassList = sideconditionsClassList;
	}
}
