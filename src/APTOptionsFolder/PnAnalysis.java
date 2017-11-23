package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PnAnalysis
{
	public ObservableList<String> gClassList = FXCollections.observableArrayList();
	public ObservableList<String> kClassList = FXCollections.observableArrayList();


	public PnAnalysis()
	{
		gClassList.add("1");
		gClassList.add("2");
		gClassList.add("3");
		gClassList.add("4");
		gClassList.add("5");
		gClassList.add("6");
		gClassList.add("7");
		gClassList.add("8");
		gClassList.add("9");
		gClassList.add("10");

		kClassList.add("1");
		kClassList.add("2");
		kClassList.add("3");
		gClassList.add("4");
		kClassList.add("5");
		kClassList.add("6");
		kClassList.add("7");
		kClassList.add("8");
		kClassList.add("9");
		kClassList.add("10");

	}

	public ObservableList<String> getgClassList()
	{
		return gClassList;
	}


	public void setgClassList(ObservableList<String> gClassList)
	{
		this.gClassList = gClassList;
	}



	public ObservableList<String> getkClassList()
	{
		return kClassList;
	}



	public void setkClassList(ObservableList<String> kClassList)
	{
		this.kClassList = kClassList;
	}
}
