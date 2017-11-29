package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsePetrify
{
	public ObservableList<String> usePetrifyDeadClassList = FXCollections.observableArrayList();


	public UsePetrify()
	{
		usePetrifyDeadClassList.add("dead");
		usePetrifyDeadClassList.add("[no dead]");
	}

	public ObservableList<String> getUsePetrifyDeadClassList()
	{
		return usePetrifyDeadClassList;
	}


	public void setUsePetrifyDeadClassList(ObservableList<String> usePetrifyDeadClassList)
	{
		this.usePetrifyDeadClassList = usePetrifyDeadClassList;
	}
}
