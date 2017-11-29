package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConcurrentCoverabilityGraph
{
	public ObservableList<String> concurrentCoverabilityGraphClassList = FXCollections.observableArrayList();



	public ConcurrentCoverabilityGraph()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getConcurrentCoverabilityGraphClassList()
	{
		return concurrentCoverabilityGraphClassList;
	}


	public void setConcurrentCoverabilityGraphClassList(ObservableList<String> concurrentCoverabilityGraphClassList)
	{
		this.concurrentCoverabilityGraphClassList = concurrentCoverabilityGraphClassList;
	}
}
