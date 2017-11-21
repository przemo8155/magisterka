package APTOptionsFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComputePvs
{
	public ObservableList<String> computePvsClassList = FXCollections.observableArrayList();



	public ComputePvs()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getComputePvsClassList()
	{
		return computePvsClassList;
	}


	public void setComputePvsClassList(ObservableList<String> computePvsClassList)
	{
		this.computePvsClassList = computePvsClassList;
	}
}
