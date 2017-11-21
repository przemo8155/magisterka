package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoveredByInvariant
{
	public ObservableList<String> coveredByInvariantInvClassList = FXCollections.observableArrayList();
	public ObservableList<String> coveredByInvariantAlgoClassList = FXCollections.observableArrayList();



	public CoveredByInvariant()
	{
		coveredByInvariantInvClassList.add("s");
		coveredByInvariantInvClassList.add("t");
		coveredByInvariantAlgoClassList.add("f");
		coveredByInvariantAlgoClassList.add("p");

	}




	public ObservableList<String> getCoveredByInvariantInvClassList()
	{
		return coveredByInvariantInvClassList;
	}




	public void setCoveredByInvariantInvClassList(ObservableList<String> coveredByInvariantInvClassList)
	{
		this.coveredByInvariantInvClassList = coveredByInvariantInvClassList;
	}





	public ObservableList<String> getCoveredByInvariantAlgoClassList()
	{
		return coveredByInvariantAlgoClassList;
	}





	public void setCoveredByInvariantAlgoClassList(ObservableList<String> coveredByInvariantAlgoClassList)
	{
		this.coveredByInvariantAlgoClassList = coveredByInvariantAlgoClassList;
	}

}
