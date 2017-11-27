package APTOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeakSeparationLength
{
	public ObservableList<String> weakSeparationLengthLengthClassList = FXCollections.observableArrayList();

	public ObservableList<String> weakSeparationLengthKClassList = FXCollections.observableArrayList();


	public WeakSeparationLength()
	{
		weakSeparationLengthKClassList.add("1");
		weakSeparationLengthKClassList.add("2");
		weakSeparationLengthKClassList.add("3");
		weakSeparationLengthKClassList.add("4");
		weakSeparationLengthKClassList.add("5");
		weakSeparationLengthKClassList.add("6");
		weakSeparationLengthKClassList.add("7");
		weakSeparationLengthKClassList.add("8");
		weakSeparationLengthKClassList.add("9");
		weakSeparationLengthKClassList.add("10");

		weakSeparationLengthLengthClassList.add("1");
		weakSeparationLengthLengthClassList.add("2");
		weakSeparationLengthLengthClassList.add("3");
		weakSeparationLengthLengthClassList.add("4");
		weakSeparationLengthLengthClassList.add("5");
		weakSeparationLengthLengthClassList.add("6");
		weakSeparationLengthLengthClassList.add("7");
		weakSeparationLengthLengthClassList.add("8");
		weakSeparationLengthLengthClassList.add("9");
		weakSeparationLengthLengthClassList.add("10");

	}

	public ObservableList<String> getWeakSeparationLengthLengthClassList()
	{
		return weakSeparationLengthLengthClassList;
	}


	public void setWeakSeparationLengthLengthClassList(ObservableList<String> weakSeparationLengthLengthClassList)
	{
		this.weakSeparationLengthLengthClassList = weakSeparationLengthLengthClassList;
	}



	public ObservableList<String> getWeakSeparationLengthKClassList()
	{
		return weakSeparationLengthKClassList;
	}



	public void setWeakSeparationLengthKClassList(ObservableList<String> weakSeparationLengthKClassList)
	{
		this.weakSeparationLengthKClassList = weakSeparationLengthKClassList;
	}
}
