package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Check
{
	public ObservableList<String> checkGeneratorsClassList = FXCollections.observableArrayList();

	public ObservableList<String> checkAttributesClassList = FXCollections.observableArrayList();
	public Check()
	{
		checkGeneratorsClassList.add("bitnet");
		checkGeneratorsClassList.add("chance");
		checkGeneratorsClassList.add("cycle");
		checkGeneratorsClassList.add("quadPhilgen");
		checkGeneratorsClassList.add("smartchance");
		checkGeneratorsClassList.add("tnetgen2");
		checkGeneratorsClassList.add("tnetgen3");
		checkGeneratorsClassList.add("triPhilgen");

		checkAttributesClassList.add("bounded");
		checkAttributesClassList.add("!bounded");
		checkAttributesClassList.add("freeChoice");
		checkAttributesClassList.add("!freeChoice");
		checkAttributesClassList.add("isolated");
		checkAttributesClassList.add("!isolated");
		checkAttributesClassList.add("k-marking");
		checkAttributesClassList.add("!k-marking");
		checkAttributesClassList.add("persistent");
		checkAttributesClassList.add("!persistent");
		checkAttributesClassList.add("plain");
		checkAttributesClassList.add("!plain");
		checkAttributesClassList.add("pure");
		checkAttributesClassList.add("!pure");
		checkAttributesClassList.add("reversible");
		checkAttributesClassList.add("!reversible");
		checkAttributesClassList.add("snet");
		checkAttributesClassList.add("!snet");
		checkAttributesClassList.add("!strongly_k-separable");
		checkAttributesClassList.add("stronglyLive");
		checkAttributesClassList.add("!stronglyLive");
		checkAttributesClassList.add("tnet");
		checkAttributesClassList.add("!tnet");
		checkAttributesClassList.add("!weakly_k-separable");

	}


	public ObservableList<String> getCheckGeneratorsClassList()
	{
		return checkGeneratorsClassList;
	}


	public void setCheckGeneratorsClassList(ObservableList<String> checkClassList)
	{
		this.checkGeneratorsClassList = checkClassList;
	}



	public ObservableList<String> getCheckAttributesClassList()
	{
		return checkAttributesClassList;
	}



	public void setCheckAttributesClassList(ObservableList<String> checkAttributesClassList)
	{
		this.checkAttributesClassList = checkAttributesClassList;
	}
}
