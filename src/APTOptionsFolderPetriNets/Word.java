package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Word
{
	public ObservableList<String> wordClassList = FXCollections.observableArrayList();


	public Word()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getWordClassList()
	{
		return wordClassList;
	}


	public void setWordClassList(ObservableList<String> wordClassList)
	{
		this.wordClassList = wordClassList;
	}
}
