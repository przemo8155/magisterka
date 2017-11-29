package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WordSynthesize
{
	public ObservableList<String> wordSynthesizeOptionsClassList = FXCollections.observableArrayList();


	public WordSynthesize()
	{
		wordSynthesizeOptionsClassList.add("none");
		wordSynthesizeOptionsClassList.add("[k]-bounded");
		wordSynthesizeOptionsClassList.add("safe");
		wordSynthesizeOptionsClassList.add("[k]-marking");
		wordSynthesizeOptionsClassList.add("pure");
		wordSynthesizeOptionsClassList.add("plain");
		wordSynthesizeOptionsClassList.add("tnet");
		wordSynthesizeOptionsClassList.add("generalized-marked-graph");
		wordSynthesizeOptionsClassList.add("marked-graph");
		wordSynthesizeOptionsClassList.add("generalized-output-nonbranching");
		wordSynthesizeOptionsClassList.add("output-nonbranching");
		wordSynthesizeOptionsClassList.add("merge-free");
		wordSynthesizeOptionsClassList.add("conflict-free");
		wordSynthesizeOptionsClassList.add("homogeneous");
		wordSynthesizeOptionsClassList.add("behaviourally-conflict-free");
		wordSynthesizeOptionsClassList.add("binary-conflict-free");
		wordSynthesizeOptionsClassList.add("equal-conflict");
		wordSynthesizeOptionsClassList.add("minimize");
		wordSynthesizeOptionsClassList.add("verbose");
		wordSynthesizeOptionsClassList.add("quick-fail");
	}

	public ObservableList<String> getWordSynthesizeOptionsClassList()
	{
		return wordSynthesizeOptionsClassList;
	}


	public void setWordSynthesizeOptionsClassList(ObservableList<String> wordSynthesizeOptionsClassList)
	{
		this.wordSynthesizeOptionsClassList = wordSynthesizeOptionsClassList;
	}
}
