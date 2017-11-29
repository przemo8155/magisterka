package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Matrices
{
	public ObservableList<String> matricesClassList = FXCollections.observableArrayList();


	public Matrices()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getMatricesClassList()
	{
		return matricesClassList;
	}


	public void setMatricesClassList(ObservableList<String> matricesClassList)
	{
		this.matricesClassList = matricesClassList;
	}
}
