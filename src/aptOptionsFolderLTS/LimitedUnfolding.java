package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LimitedUnfolding
{
	public ObservableList<String> limitedUnfoldingClassList = FXCollections.observableArrayList();


	public LimitedUnfolding()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getLimitedUnfoldingClassList()
	{
		return limitedUnfoldingClassList;
	}


	public void setLimitedUnfoldingClassList(ObservableList<String> limitedUnfoldingClassList)
	{
		this.limitedUnfoldingClassList = limitedUnfoldingClassList;
	}
}
