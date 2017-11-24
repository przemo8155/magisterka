package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Reversible
{
	public ObservableList<String> reversibleClassList = FXCollections.observableArrayList();


	public Reversible()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getReversibleClassList()
	{
		return reversibleClassList;
	}


	public void setReversibleClassList(ObservableList<String> reversibleClassList)
	{
		this.reversibleClassList = reversibleClassList;
	}
}
