package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mf
{
	public ObservableList<String> mfClassList = FXCollections.observableArrayList();


	public Mf()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getMfClassList()
	{
		return mfClassList;
	}


	public void setMfClassList(ObservableList<String> mfClassList)
	{
		this.mfClassList = mfClassList;
	}
}
