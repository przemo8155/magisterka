package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OverapproximateSynthesize
{
	public ObservableList<String> overapproximateSynthesizeOptionsClassList = FXCollections.observableArrayList();


	public OverapproximateSynthesize()
	{
		overapproximateSynthesizeOptionsClassList.add("safe");
		overapproximateSynthesizeOptionsClassList.add("pure");
		overapproximateSynthesizeOptionsClassList.add("plain");
		overapproximateSynthesizeOptionsClassList.add("tnet");
		overapproximateSynthesizeOptionsClassList.add("marked-graph");
	}

	public ObservableList<String> getOverapproximateSynthesizeOptionsClassList()
	{
		return overapproximateSynthesizeOptionsClassList;
	}


	public void setOverapproximateSynthesizeOptionsClassList(
			ObservableList<String> overapproximateSynthesizeOptionsClassList)
	{
		this.overapproximateSynthesizeOptionsClassList = overapproximateSynthesizeOptionsClassList;
	}
}
