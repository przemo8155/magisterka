package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tnet
{
	public ObservableList<String> tnetClassList = FXCollections.observableArrayList();


	public Tnet()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getTnetClassList()
	{
		return tnetClassList;
	}


	public void setTnetClassList(ObservableList<String> tnetClassList)
	{
		this.tnetClassList = tnetClassList;
	}
}
