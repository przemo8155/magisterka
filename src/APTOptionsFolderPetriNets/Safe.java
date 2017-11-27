package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Safe
{
	public ObservableList<String> safeClassList = FXCollections.observableArrayList();


	public Safe()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getSafeClassList()
	{
		return safeClassList;
	}


	public void setSafeClassList(ObservableList<String> safeClassList)
	{
		this.safeClassList = safeClassList;
	}
}
