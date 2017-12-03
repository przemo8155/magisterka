package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StrongSeparation
{
	public ObservableList<String> strongSeparationKClassList = FXCollections.observableArrayList();

	public ObservableList<String> strongSeparationSequenceClassList = FXCollections.observableArrayList();

	public ObservableList<String> strongSeparationVerboseClassList = FXCollections.observableArrayList();


	public StrongSeparation()
	{
		strongSeparationKClassList.add("0");
		strongSeparationKClassList.add("1");
		strongSeparationKClassList.add("2");
		strongSeparationKClassList.add("3");
		strongSeparationKClassList.add("4");
		strongSeparationKClassList.add("5");
		strongSeparationKClassList.add("6");
		strongSeparationKClassList.add("7");
		strongSeparationKClassList.add("8");
		strongSeparationKClassList.add("9");
		strongSeparationKClassList.add("10");

		strongSeparationVerboseClassList.add("[no verbose]");
		strongSeparationVerboseClassList.add("verbose");


	}

	public ObservableList<String> getStrongSeparationKClassList()
	{
		return strongSeparationKClassList;
	}


	public void setStrongSeparationKClassList(ObservableList<String> strongSeparationKClassList)
	{
		this.strongSeparationKClassList = strongSeparationKClassList;
	}


	public ObservableList<String> getStrongSeparationSequenceClassList()
	{
		return strongSeparationSequenceClassList;
	}


	public void setStrongSeparationSequenceClassList(ObservableList<String> strongSeparationSequenceClassList)
	{
		this.strongSeparationSequenceClassList = strongSeparationSequenceClassList;
	}


	public ObservableList<String> getStrongSeparationVerboseClassList()
	{
		return strongSeparationVerboseClassList;
	}


	public void setStrongSeparationVerboseClassList(ObservableList<String> strongSeparationVerboseClassList)
	{
		this.strongSeparationVerboseClassList = strongSeparationVerboseClassList;
	}
}
