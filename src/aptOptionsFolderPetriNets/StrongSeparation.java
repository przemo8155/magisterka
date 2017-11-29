package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StrongSeparation
{
	public ObservableList<String> strongSeparationKClassList = FXCollections.observableArrayList();

	public ObservableList<String> strongSeparationSequenceClassList = FXCollections.observableArrayList();


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


		strongSeparationSequenceClassList.add("a1");
		strongSeparationSequenceClassList.add("a2");
		strongSeparationSequenceClassList.add("a3");
		strongSeparationSequenceClassList.add("a4");
		strongSeparationSequenceClassList.add("a5");

		strongSeparationSequenceClassList.add("a1;a2");
		strongSeparationSequenceClassList.add("a1;a3");
		strongSeparationSequenceClassList.add("a1;a4");
		strongSeparationSequenceClassList.add("a1;a5");
		strongSeparationSequenceClassList.add("a2;a1");
		strongSeparationSequenceClassList.add("a2;a3");
		strongSeparationSequenceClassList.add("a2;a4");
		strongSeparationSequenceClassList.add("a2;a5");
		strongSeparationSequenceClassList.add("a3;a1");
		strongSeparationSequenceClassList.add("a3;a2");
		strongSeparationSequenceClassList.add("a3;a4");
		strongSeparationSequenceClassList.add("a3;a5");
		strongSeparationSequenceClassList.add("a4;a1");
		strongSeparationSequenceClassList.add("a4;a2");
		strongSeparationSequenceClassList.add("a4;a3");
		strongSeparationSequenceClassList.add("a4;a5");
		strongSeparationSequenceClassList.add("a5;a1");
		strongSeparationSequenceClassList.add("a5;a2");
		strongSeparationSequenceClassList.add("a5;a3");
		strongSeparationSequenceClassList.add("a5;a4");
		strongSeparationSequenceClassList.add("a1;a2;a3");
		strongSeparationSequenceClassList.add("a1;a2;a4");
		strongSeparationSequenceClassList.add("a1;a2;a5");
		strongSeparationSequenceClassList.add("a1;a3;a2");
		strongSeparationSequenceClassList.add("a1;a3;a4");
		strongSeparationSequenceClassList.add("a1;a3;a5");
		strongSeparationSequenceClassList.add("a1");

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
}
