package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Factorize
{
	public ObservableList<String> factorizeClassList = FXCollections.observableArrayList();


	public Factorize()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getFactorizeClassList()
	{
		return factorizeClassList;
	}


	public void setFactorizeClassList(ObservableList<String> factorizeClassList)
	{
		this.factorizeClassList = factorizeClassList;
	}
}
