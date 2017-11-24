package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReachabilityGraph
{
	public ObservableList<String> reachabilityGraphClassList = FXCollections.observableArrayList();


	public ReachabilityGraph()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getReachabilityGraphClassList()
	{
		return reachabilityGraphClassList;
	}


	public void setReachabilityGraphClassList(ObservableList<String> reachabilityGraphClassList)
	{
		this.reachabilityGraphClassList = reachabilityGraphClassList;
	}
}
