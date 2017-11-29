package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LabelSeparation
{
	public ObservableList<String> labelSeparationClassList = FXCollections.observableArrayList();


	public LabelSeparation()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getLabelSeparationClassList()
	{
		return labelSeparationClassList;
	}


	public void setLabelSeparationClassList(ObservableList<String> labelSeparationClassList)
	{
		this.labelSeparationClassList = labelSeparationClassList;
	}
}
