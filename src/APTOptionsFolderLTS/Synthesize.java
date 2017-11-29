package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Synthesize
{
	public ObservableList<String> synthesizeOptionsClassList = FXCollections.observableArrayList();


	public Synthesize()
	{
		synthesizeOptionsClassList.add("none");
		synthesizeOptionsClassList.add("[k]-bounded");
		synthesizeOptionsClassList.add("safe");
		synthesizeOptionsClassList.add("[k]-marking");
		synthesizeOptionsClassList.add("pure");
		synthesizeOptionsClassList.add("plain");
		synthesizeOptionsClassList.add("tnet");
		synthesizeOptionsClassList.add("generalized-marked-graph");
		synthesizeOptionsClassList.add("marked-graph");
		synthesizeOptionsClassList.add("generalized-output-nonbranching");
		synthesizeOptionsClassList.add("output-nonbranching");
		synthesizeOptionsClassList.add("merge-free");
		synthesizeOptionsClassList.add("conflict-free");
		synthesizeOptionsClassList.add("homogeneous");
		synthesizeOptionsClassList.add("behaviourally-conflict-free");
		synthesizeOptionsClassList.add("binary-conflict-free");
		synthesizeOptionsClassList.add("equal-conflict");
		synthesizeOptionsClassList.add("minimize");
		synthesizeOptionsClassList.add("verbose");
		synthesizeOptionsClassList.add("quick-fail");
	}

	public ObservableList<String> getSynthesizeOptionsClassList()
	{
		return synthesizeOptionsClassList;
	}


	public void setSynthesizeOptionsClassList(ObservableList<String> synthesizeOptionsClassList)
	{
		this.synthesizeOptionsClassList = synthesizeOptionsClassList;
	}
}
