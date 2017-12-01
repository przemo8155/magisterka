package aptOptionsFolderConveters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PnConvert
{
	public ObservableList<String> pnConvertClassList = FXCollections.observableArrayList();


	public PnConvert()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getPnConvertClassList()
	{
		return pnConvertClassList;
	}


	public void setPnConvertClassList(ObservableList<String> pnConvertClassList)
	{
		this.pnConvertClassList = pnConvertClassList;
	}
}
