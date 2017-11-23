package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Plain
{
	public ObservableList<String> plainClassList = FXCollections.observableArrayList();


	public Plain()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getPlainClassList()
	{
		return plainClassList;
	}


	public void setPlainClassList(ObservableList<String> plainClassList)
	{
		this.plainClassList = plainClassList;
	}
}
