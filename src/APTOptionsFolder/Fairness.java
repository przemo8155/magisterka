package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Fairness
{
	public ObservableList<String> fairnessClassList = FXCollections.observableArrayList();


	public Fairness()
	{
		fairnessClassList.add("0");
		fairnessClassList.add("1");
		fairnessClassList.add("2");
		fairnessClassList.add("3");
		fairnessClassList.add("4");
		fairnessClassList.add("5");
		fairnessClassList.add("6");
		fairnessClassList.add("7");
		fairnessClassList.add("8");
		fairnessClassList.add("9");
		fairnessClassList.add("10");
	}

	public ObservableList<String> getFairnessClassList()
	{
		return fairnessClassList;
	}


	public void setFairnessClassList(ObservableList<String> fairnessClassList)
	{
		this.fairnessClassList = fairnessClassList;
	}
}
