package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Invariants
{
	public ObservableList<String> invariantsInvClassList = FXCollections.observableArrayList();
	public ObservableList<String> invariantsAlgoClassList = FXCollections.observableArrayList();


	public Invariants()
	{
		invariantsInvClassList.add("s");
		invariantsInvClassList.add("t");
		invariantsAlgoClassList.add("f");
		invariantsAlgoClassList.add("p");
	}

	public ObservableList<String> getInvariantsInvClassList()
	{
		return invariantsInvClassList;
	}

	public void setInvariantsInvClassList(ObservableList<String> invariantsInvClassList)
	{
		this.invariantsInvClassList = invariantsInvClassList;
	}


	public ObservableList<String> getInvariantsAlgoClassList()
	{
		return invariantsAlgoClassList;
	}


	public void setInvariantsAlgoClassList(ObservableList<String> invariantsAlgoClassList)
	{
		this.invariantsAlgoClassList = invariantsAlgoClassList;
	}
}
