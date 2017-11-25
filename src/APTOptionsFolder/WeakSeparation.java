package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeakSeparation
{
	public ObservableList<String> weakSeparationKClassList = FXCollections.observableArrayList();

	public ObservableList<String> weakSeparationSequenceClassList = FXCollections.observableArrayList();

	public WeakSeparation()
	{
		weakSeparationKClassList.add("0");
		weakSeparationKClassList.add("1");
		weakSeparationKClassList.add("2");
		weakSeparationKClassList.add("3");
		weakSeparationKClassList.add("4");
		weakSeparationKClassList.add("5");
		weakSeparationKClassList.add("6");
		weakSeparationKClassList.add("7");
		weakSeparationKClassList.add("8");
		weakSeparationKClassList.add("9");
		weakSeparationKClassList.add("10");

		weakSeparationSequenceClassList.add("a1");
		weakSeparationSequenceClassList.add("a2");
		weakSeparationSequenceClassList.add("a3");
		weakSeparationSequenceClassList.add("a4");
		weakSeparationSequenceClassList.add("a5");

		weakSeparationSequenceClassList.add("a1;a2");
		weakSeparationSequenceClassList.add("a1;a3");
		weakSeparationSequenceClassList.add("a1;a4");
		weakSeparationSequenceClassList.add("a1;a5");
		weakSeparationSequenceClassList.add("a2;a1");
		weakSeparationSequenceClassList.add("a2;a3");
		weakSeparationSequenceClassList.add("a2;a4");
		weakSeparationSequenceClassList.add("a2;a5");
		weakSeparationSequenceClassList.add("a3;a1");
		weakSeparationSequenceClassList.add("a3;a2");
		weakSeparationSequenceClassList.add("a3;a4");
		weakSeparationSequenceClassList.add("a3;a5");
		weakSeparationSequenceClassList.add("a4;a1");
		weakSeparationSequenceClassList.add("a4;a2");
		weakSeparationSequenceClassList.add("a4;a3");
		weakSeparationSequenceClassList.add("a4;a5");
		weakSeparationSequenceClassList.add("a5;a1");
		weakSeparationSequenceClassList.add("a5;a2");
		weakSeparationSequenceClassList.add("a5;a3");
		weakSeparationSequenceClassList.add("a5;a4");
		weakSeparationSequenceClassList.add("a1;a2;a3");
		weakSeparationSequenceClassList.add("a1;a2;a4");
		weakSeparationSequenceClassList.add("a1;a2;a5");
		weakSeparationSequenceClassList.add("a1;a3;a2");
		weakSeparationSequenceClassList.add("a1;a3;a4");
		weakSeparationSequenceClassList.add("a1;a3;a5");
		weakSeparationSequenceClassList.add("a1");
	}


	public ObservableList<String> getWeakSeparationKClassList()
	{
		return weakSeparationKClassList;
	}


	public void setWeakSeparationKClassList(ObservableList<String> weakSeparationKClassList)
	{
		this.weakSeparationKClassList = weakSeparationKClassList;
	}



	public ObservableList<String> getWeakSeparationSequenceClassList()
	{
		return weakSeparationSequenceClassList;
	}



	public void setWeakSeparationSequenceClassList(ObservableList<String> weakSeparationSequenceClassList)
	{
		this.weakSeparationSequenceClassList = weakSeparationSequenceClassList;
	}

}
