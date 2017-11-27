package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Draw
{
	public ObservableList<String> drawClassList = FXCollections.observableArrayList();
	public Draw()
	{
	}

	public ObservableList<String> getDrawClassList()
	{
		return drawClassList;
	}

	public void setDrawClassList(ObservableList<String> drawClassList)
	{
		this.drawClassList = drawClassList;
	}
}
