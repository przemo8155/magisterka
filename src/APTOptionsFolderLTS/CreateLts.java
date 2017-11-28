package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CreateLts
{
	public ObservableList<String> createLtsClassList = FXCollections.observableArrayList();


	public CreateLts()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getCreateLtsClassList()
	{
		return createLtsClassList;
	}


	public void setCreateLtsClassList(ObservableList<String> createLtsClassList)
	{
		this.createLtsClassList = createLtsClassList;
	}
}
