package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Deterministic
{
	public ObservableList<String> deterministicClassList = FXCollections.observableArrayList();


	public Deterministic()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getDeterministicClassList()
	{
		return deterministicClassList;
	}


	public void setDeterministicClassList(ObservableList<String> deterministicClassList)
	{
		this.deterministicClassList = deterministicClassList;
	}
}
