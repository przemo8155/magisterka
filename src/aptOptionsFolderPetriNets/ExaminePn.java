package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExaminePn
{
	public ObservableList<String> examinePnClassList = FXCollections.observableArrayList();


	public ExaminePn()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getExaminePnClassList()
	{
		return examinePnClassList;
	}


	public void setExaminePnClassList(ObservableList<String> examinePnClassList)
	{
		this.examinePnClassList = examinePnClassList;
	}
}
