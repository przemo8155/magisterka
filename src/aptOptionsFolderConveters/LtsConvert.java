package aptOptionsFolderConveters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LtsConvert
{
	public ObservableList<String> ltsConvertClassList = FXCollections.observableArrayList();


	public LtsConvert()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getLtsConvertClassList()
	{
		return ltsConvertClassList;
	}


	public void setLtsConvertClassList(ObservableList<String> ltsConvertClassList)
	{
		this.ltsConvertClassList = ltsConvertClassList;
	}
}
