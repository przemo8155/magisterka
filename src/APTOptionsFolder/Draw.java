package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Draw
{
	public ObservableList<String> drawClassList = FXCollections.observableArrayList();
	public Draw()
	{

		drawClassList.add("draw");
		drawClassList.add("ac");
		drawClassList.add("backward_persistent");
		drawClassList.add("bcf");
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
