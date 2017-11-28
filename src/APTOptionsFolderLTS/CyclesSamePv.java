package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CyclesSamePv
{
	public ObservableList<String> cyclesSamePvClassList = FXCollections.observableArrayList();


	public CyclesSamePv()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getCyclesSamePvClassList()
	{
		return cyclesSamePvClassList;
	}


	public void setCyclesSamePvClassList(ObservableList<String> cyclesSamePvClassList)
	{
		this.cyclesSamePvClassList = cyclesSamePvClassList;
	}
}
