package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExamineLts
{
	public ObservableList<String> examineLtsClassList = FXCollections.observableArrayList();


	public ExamineLts()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getExamineLtsClassList()
	{
		return examineLtsClassList;
	}


	public void setExamineLtsClassList(ObservableList<String> examineLtsClassList)
	{
		this.examineLtsClassList = examineLtsClassList;
	}
}
