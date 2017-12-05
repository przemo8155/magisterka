package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StrongSeparationLength
{
	public ObservableList<String> strongSeparationLengthLengthClassList = FXCollections.observableArrayList();

	public ObservableList<String> strongSeparationLengthKClassList = FXCollections.observableArrayList();

	public ObservableList<String> strongSeparationLengthVerboseClassList = FXCollections.observableArrayList();


	public StrongSeparationLength()
	{
		strongSeparationLengthLengthClassList.add("1");
		strongSeparationLengthLengthClassList.add("2");
		strongSeparationLengthLengthClassList.add("3");
		strongSeparationLengthLengthClassList.add("4");
		strongSeparationLengthLengthClassList.add("5");
		strongSeparationLengthLengthClassList.add("6");
		strongSeparationLengthLengthClassList.add("7");
		strongSeparationLengthLengthClassList.add("8");
		strongSeparationLengthLengthClassList.add("9");
		strongSeparationLengthLengthClassList.add("10");

		strongSeparationLengthKClassList.add("1");
		strongSeparationLengthKClassList.add("2");
		strongSeparationLengthKClassList.add("3");
		strongSeparationLengthKClassList.add("4");
		strongSeparationLengthKClassList.add("5");
		strongSeparationLengthKClassList.add("6");
		strongSeparationLengthKClassList.add("7");
		strongSeparationLengthKClassList.add("8");
		strongSeparationLengthKClassList.add("9");
		strongSeparationLengthKClassList.add("10");

		strongSeparationLengthVerboseClassList.add("[no verbose]");
		strongSeparationLengthVerboseClassList.add("verbose");


	}

	public ObservableList<String> getStrongSeparationLengthLengthClassList()
	{
		return strongSeparationLengthLengthClassList;
	}


	public void setStrongSeparationLengthLengthClassList(ObservableList<String> strongSeparationLengthLengthClassList)
	{
		this.strongSeparationLengthLengthClassList = strongSeparationLengthLengthClassList;
	}



	public ObservableList<String> getStrongSeparationLengthKClassList()
	{
		return strongSeparationLengthKClassList;
	}



	public void setStrongSeparationLengthKClassList(ObservableList<String> strongSeparationLengthKClassList)
	{
		this.strongSeparationLengthKClassList = strongSeparationLengthKClassList;
	}


	public ObservableList<String> getStrongSeparationLengthVerboseClassList()
	{
		return strongSeparationLengthVerboseClassList;
	}


	public void setStrongSeparationLengthVerboseClassList(ObservableList<String> strongSeparationLengthVerboseClassList)
	{
		this.strongSeparationLengthVerboseClassList = strongSeparationLengthVerboseClassList;
	}
}
