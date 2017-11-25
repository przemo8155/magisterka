package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeaklyLive
{
	public ObservableList<String> weaklyLiveClassList = FXCollections.observableArrayList();


	public WeaklyLive()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getWeaklyLiveClassList()
	{
		return weaklyLiveClassList;
	}


	public void setWeaklyLiveClassList(ObservableList<String> weaklyLiveClassList)
	{
		this.weaklyLiveClassList = weaklyLiveClassList;
	}
}
