package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Help
{
	public ObservableList<String> helpClassList = FXCollections.observableArrayList();
	public Help()
	{
		helpClassList.add("draw");
		helpClassList.add("ac");
		helpClassList.add("backward_persistent");
		helpClassList.add("bcf");
	}

	public ObservableList<String> getHelpClassList()
	{
		return helpClassList;
	}

	public void setHelpClassList(ObservableList<String> helpClassList)
	{
		this.helpClassList = helpClassList;
	}
}
