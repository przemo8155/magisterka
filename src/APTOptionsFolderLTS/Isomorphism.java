package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Isomorphism
{
	public ObservableList<String> isomorphismClassList = FXCollections.observableArrayList();


	public Isomorphism()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getIsomorphismClassList()
	{
		return isomorphismClassList;
	}


	public void setIsomorphismClassList(ObservableList<String> isomorphismClassList)
	{
		this.isomorphismClassList = isomorphismClassList;
	}
}
