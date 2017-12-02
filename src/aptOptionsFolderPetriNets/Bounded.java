package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bounded
{
	public ObservableList<String> boundedClassList = FXCollections.observableArrayList();

	public Bounded()
	{
		boundedClassList.add("[no K]");
		boundedClassList.add("1");
		boundedClassList.add("2");
		boundedClassList.add("3");
		boundedClassList.add("4");
		boundedClassList.add("5");
		boundedClassList.add("6");
		boundedClassList.add("7");
		boundedClassList.add("8");
		boundedClassList.add("9");
		boundedClassList.add("10");
	}


	public ObservableList<String> getBoundedClassList()
	{
		return boundedClassList;
	}


	public void setBoundedClassList(ObservableList<String> boundedClassList)
	{
		this.boundedClassList = boundedClassList;
	}
}
