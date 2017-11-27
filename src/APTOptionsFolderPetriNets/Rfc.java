package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Rfc
{
	public ObservableList<String> rfcClassList = FXCollections.observableArrayList();


	public Rfc()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getRfcClassList()
	{
		return rfcClassList;
	}


	public void setRfcClassList(ObservableList<String> rfcClassList)
	{
		this.rfcClassList = rfcClassList;
	}
}
