package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LanguageEquivalence
{
	public ObservableList<String> languageEquivalenceClassList = FXCollections.observableArrayList();


	public LanguageEquivalence()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getLanguageEquivalenceClassList()
	{
		return languageEquivalenceClassList;
	}


	public void setLanguageEquivalenceClassList(ObservableList<String> languageEquivalenceClassList)
	{
		this.languageEquivalenceClassList = languageEquivalenceClassList;
	}
}
