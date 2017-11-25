package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeakComponents
{
	public ObservableList<String> weakComponentsClassList = FXCollections.observableArrayList();


	public WeakComponents()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getWeakComponentsClassList()
	{
		return weakComponentsClassList;
	}


	public void setWeakComponentsClassList(ObservableList<String> weakComponentsClassList)
	{
		this.weakComponentsClassList = weakComponentsClassList;
	}
}
