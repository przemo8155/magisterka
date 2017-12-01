package aptOptionsFolderGenerators;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TNetGenerator
{
	public ObservableList<String> tNetGeneratorNPClassList = FXCollections.observableArrayList();

	public ObservableList<String> tNetGeneratorNTClassList = FXCollections.observableArrayList();

	public ObservableList<String> tNetGeneratorMClassList = FXCollections.observableArrayList();


	public TNetGenerator()
	{
		tNetGeneratorNPClassList.add("1");
		tNetGeneratorNPClassList.add("2");
		tNetGeneratorNPClassList.add("3");
		tNetGeneratorNPClassList.add("4");
		tNetGeneratorNPClassList.add("5");
		tNetGeneratorNPClassList.add("6");
		tNetGeneratorNPClassList.add("7");
		tNetGeneratorNPClassList.add("8");
		tNetGeneratorNPClassList.add("9");
		tNetGeneratorNPClassList.add("10");


		tNetGeneratorNTClassList.add("1");
		tNetGeneratorNTClassList.add("2");
		tNetGeneratorNTClassList.add("3");
		tNetGeneratorNTClassList.add("4");
		tNetGeneratorNTClassList.add("5");
		tNetGeneratorNTClassList.add("6");
		tNetGeneratorNTClassList.add("7");
		tNetGeneratorNTClassList.add("8");
		tNetGeneratorNTClassList.add("9");
		tNetGeneratorNTClassList.add("10");


		tNetGeneratorMClassList.add("1");
		tNetGeneratorMClassList.add("2");
		tNetGeneratorMClassList.add("3");
		tNetGeneratorMClassList.add("4");
		tNetGeneratorMClassList.add("5");
		tNetGeneratorMClassList.add("6");
		tNetGeneratorMClassList.add("7");
		tNetGeneratorMClassList.add("8");
		tNetGeneratorMClassList.add("9");
		tNetGeneratorMClassList.add("10");

	}



	public ObservableList<String> gettNetGeneratorNPClassList()
	{
		return tNetGeneratorNPClassList;
	}



	public void settNetGeneratorNPClassList(ObservableList<String> tNetGeneratorNPClassList)
	{
		this.tNetGeneratorNPClassList = tNetGeneratorNPClassList;
	}




	public ObservableList<String> gettNetGeneratorNTClassList()
	{
		return tNetGeneratorNTClassList;
	}




	public void settNetGeneratorNTClassList(ObservableList<String> tNetGeneratorNTClassList)
	{
		this.tNetGeneratorNTClassList = tNetGeneratorNTClassList;
	}




	public ObservableList<String> gettNetGeneratorMClassList()
	{
		return tNetGeneratorMClassList;
	}




	public void settNetGeneratorMClassList(ObservableList<String> tNetGeneratorMClassList)
	{
		this.tNetGeneratorMClassList = tNetGeneratorMClassList;
	}
}
