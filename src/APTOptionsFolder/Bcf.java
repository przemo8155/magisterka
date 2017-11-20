package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bcf
{
	public ObservableList<String> bcfClassList = FXCollections.observableArrayList();

	public Bcf()
	{

	}


	public ObservableList<String> getBcfClassList()
	{
		return bcfClassList;
	}


	public void setBcfClassList(ObservableList<String> bcfClassList)
	{
		this.bcfClassList = bcfClassList;
	}
}
