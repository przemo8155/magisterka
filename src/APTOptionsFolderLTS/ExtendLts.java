package APTOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExtendLts
{
	public ObservableList<String> extendLtsGClassList = FXCollections.observableArrayList();

	public ObservableList<String> extendLtsModeClassList = FXCollections.observableArrayList();


	public ExtendLts()
	{
		extendLtsGClassList.add("0");
		extendLtsGClassList.add("1");
		extendLtsGClassList.add("2");
		extendLtsGClassList.add("3");
		extendLtsGClassList.add("4");
		extendLtsGClassList.add("5");
		extendLtsGClassList.add("6");
		extendLtsGClassList.add("7");
		extendLtsGClassList.add("8");
		extendLtsGClassList.add("9");
		extendLtsGClassList.add("10");

		extendLtsModeClassList.add("next");
		extendLtsModeClassList.add("next_valid");
		extendLtsModeClassList.add("next_minimal_valid");
	}

	public ObservableList<String> getExtendLtsGClassList()
	{
		return extendLtsGClassList;
	}


	public void setExtendLtsGClassList(ObservableList<String> extendLtsGClassList)
	{
		this.extendLtsGClassList = extendLtsGClassList;
	}


	public ObservableList<String> getExtendLtsModeClassList()
	{
		return extendLtsModeClassList;
	}


	public void setExtendLtsModeClassList(ObservableList<String> extendLtsModeClassList)
	{
		this.extendLtsModeClassList = extendLtsModeClassList;
	}
}
