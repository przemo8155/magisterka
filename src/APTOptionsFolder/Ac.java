package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ac
{
	public ObservableList<String> acClassList = FXCollections.observableArrayList();

	public Ac()
	{

	}


	public ObservableList<String> getAcClassList()
	{
		return acClassList;
	}


	public void setAcClassList(ObservableList<String> acClassList)
	{
		this.acClassList = acClassList;
	}
}
