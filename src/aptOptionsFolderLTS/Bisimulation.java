package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bisimulation
{
	public ObservableList<String> bisimulationClassList = FXCollections.observableArrayList();


	public Bisimulation()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getBisimulationClassList()
	{
		return bisimulationClassList;
	}


	public void setBisimulationClassList(ObservableList<String> bisimulationClassList)
	{
		this.bisimulationClassList = bisimulationClassList;
	}
}
