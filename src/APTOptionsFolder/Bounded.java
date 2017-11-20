package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bounded
{
	public ObservableList<String> boundedClassList = FXCollections.observableArrayList();

	public Bounded()
	{

	}


	public ObservableList<String> getBoundedClassList()
	{
		return boundedClassList;
	}


	public void setBoundedClassList(ObservableList<String> boundedClassList)
	{
		this.boundedClassList = boundedClassList;
	}
}
