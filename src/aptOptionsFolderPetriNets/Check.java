package aptOptionsFolderPetriNets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Check
{
	public ObservableList<String> checkGeneratorsClassList = FXCollections.observableArrayList();

	public ObservableList<String> checkAttributesClassList = FXCollections.observableArrayList();

	public ObservableList<String> checkMaxSecondsClassList = FXCollections.observableArrayList();

	public Check()
	{
		checkMaxSecondsClassList.add("1");
		checkMaxSecondsClassList.add("2");
		checkMaxSecondsClassList.add("3");
		checkMaxSecondsClassList.add("4");
		checkMaxSecondsClassList.add("5");
		checkMaxSecondsClassList.add("6");
		checkMaxSecondsClassList.add("7");
		checkMaxSecondsClassList.add("8");
		checkMaxSecondsClassList.add("9");
		checkMaxSecondsClassList.add("10");
		checkMaxSecondsClassList.add("11");
		checkMaxSecondsClassList.add("12");
		checkMaxSecondsClassList.add("13");
		checkMaxSecondsClassList.add("14");
		checkMaxSecondsClassList.add("15");
		checkMaxSecondsClassList.add("16");
		checkMaxSecondsClassList.add("17");
		checkMaxSecondsClassList.add("18");
		checkMaxSecondsClassList.add("19");
		checkMaxSecondsClassList.add("20");
		checkMaxSecondsClassList.add("21");
		checkMaxSecondsClassList.add("22");
		checkMaxSecondsClassList.add("23");
		checkMaxSecondsClassList.add("24");
		checkMaxSecondsClassList.add("25");
		checkMaxSecondsClassList.add("26");
		checkMaxSecondsClassList.add("27");
		checkMaxSecondsClassList.add("28");
		checkMaxSecondsClassList.add("29");
		checkMaxSecondsClassList.add("30");
		checkMaxSecondsClassList.add("31");
		checkMaxSecondsClassList.add("32");
		checkMaxSecondsClassList.add("33");
		checkMaxSecondsClassList.add("34");
		checkMaxSecondsClassList.add("35");
		checkMaxSecondsClassList.add("36");
		checkMaxSecondsClassList.add("37");
		checkMaxSecondsClassList.add("38");
		checkMaxSecondsClassList.add("39");
		checkMaxSecondsClassList.add("40");
		checkMaxSecondsClassList.add("41");
		checkMaxSecondsClassList.add("42");
		checkMaxSecondsClassList.add("43");
		checkMaxSecondsClassList.add("44");
		checkMaxSecondsClassList.add("45");
		checkMaxSecondsClassList.add("46");
		checkMaxSecondsClassList.add("47");
		checkMaxSecondsClassList.add("48");
		checkMaxSecondsClassList.add("49");
		checkMaxSecondsClassList.add("50");
		checkMaxSecondsClassList.add("51");
		checkMaxSecondsClassList.add("52");
		checkMaxSecondsClassList.add("53");
		checkMaxSecondsClassList.add("54");
		checkMaxSecondsClassList.add("55");
		checkMaxSecondsClassList.add("56");
		checkMaxSecondsClassList.add("57");
		checkMaxSecondsClassList.add("58");
		checkMaxSecondsClassList.add("59");
		checkMaxSecondsClassList.add("60");
		checkMaxSecondsClassList.add("61");
		checkMaxSecondsClassList.add("62");
		checkMaxSecondsClassList.add("63");
		checkMaxSecondsClassList.add("64");
		checkMaxSecondsClassList.add("65");
		checkMaxSecondsClassList.add("66");
		checkMaxSecondsClassList.add("67");
		checkMaxSecondsClassList.add("68");
		checkMaxSecondsClassList.add("69");
		checkMaxSecondsClassList.add("70");
		checkMaxSecondsClassList.add("71");
		checkMaxSecondsClassList.add("72");
		checkMaxSecondsClassList.add("73");
		checkMaxSecondsClassList.add("74");
		checkMaxSecondsClassList.add("75");
		checkMaxSecondsClassList.add("76");
		checkMaxSecondsClassList.add("77");
		checkMaxSecondsClassList.add("78");
		checkMaxSecondsClassList.add("79");
		checkMaxSecondsClassList.add("80");
		checkMaxSecondsClassList.add("81");
		checkMaxSecondsClassList.add("82");
		checkMaxSecondsClassList.add("83");
		checkMaxSecondsClassList.add("84");
		checkMaxSecondsClassList.add("85");
		checkMaxSecondsClassList.add("86");
		checkMaxSecondsClassList.add("87");
		checkMaxSecondsClassList.add("88");
		checkMaxSecondsClassList.add("89");
		checkMaxSecondsClassList.add("90");
		checkMaxSecondsClassList.add("91");
		checkMaxSecondsClassList.add("92");
		checkMaxSecondsClassList.add("93");
		checkMaxSecondsClassList.add("94");
		checkMaxSecondsClassList.add("95");
		checkMaxSecondsClassList.add("96");
		checkMaxSecondsClassList.add("97");
		checkMaxSecondsClassList.add("98");
		checkMaxSecondsClassList.add("99");



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



	public ObservableList<String> getCheckMaxSecondsClassList()
	{
		return checkMaxSecondsClassList;
	}



	public void setCheckMaxSecondsClassList(ObservableList<String> checkMaxSecondsClassList)
	{
		this.checkMaxSecondsClassList = checkMaxSecondsClassList;
	}
}
