package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TotallyReachable
{
	public ObservableList<String> totallyReachableClassList = FXCollections.observableArrayList();


	public TotallyReachable()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getTotallyReachableClassList()
	{
		return totallyReachableClassList;
	}


	public void setTotallyReachableClassList(ObservableList<String> totallyReachableClassList)
	{
		this.totallyReachableClassList = totallyReachableClassList;
	}
}
