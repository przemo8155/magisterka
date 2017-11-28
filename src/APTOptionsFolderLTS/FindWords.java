package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FindWords
{
	public ObservableList<String> findWordsOptionsClassList = FXCollections.observableArrayList();

	public ObservableList<String> findWordsOperationsClassList = FXCollections.observableArrayList();


	public FindWords()
	{
		findWordsOptionsClassList.add("safe");
		findWordsOptionsClassList.add("none");

		findWordsOperationsClassList.add("solvable");
		findWordsOperationsClassList.add("unsolvable");
	}

	public ObservableList<String> getFindWordsOptionsClassList()
	{
		return findWordsOptionsClassList;
	}


	public void setFindWordsOptionsClassList(ObservableList<String> findWordsOptionsClassList)
	{
		this.findWordsOptionsClassList = findWordsOptionsClassList;
	}



	public ObservableList<String> getFindWordsOperationsClassList()
	{
		return findWordsOperationsClassList;
	}



	public void setFindWordsOperationsClassList(ObservableList<String> findWordsOperationsClassList)
	{
		this.findWordsOperationsClassList = findWordsOperationsClassList;
	}
}
