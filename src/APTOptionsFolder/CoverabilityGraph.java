package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoverabilityGraph
{
	public ObservableList<String> coverabilityGraphClassList = FXCollections.observableArrayList();


	public CoverabilityGraph()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getCoverabilityGraphClassList()
	{
		return coverabilityGraphClassList;
	}


	public void setCoverabilityGraphClassList(ObservableList<String> coverabilityGraphClassList)
	{
		this.coverabilityGraphClassList = coverabilityGraphClassList;
	}
}
