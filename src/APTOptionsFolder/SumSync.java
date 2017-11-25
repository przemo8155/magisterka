package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SumSync
{
	public ObservableList<String> sumSyncClassList = FXCollections.observableArrayList();


	public SumSync()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getSumSyncClassList()
	{
		return sumSyncClassList;
	}


	public void setSumSyncClassList(ObservableList<String> sumSyncClassList)
	{
		this.sumSyncClassList = sumSyncClassList;
	}
}
