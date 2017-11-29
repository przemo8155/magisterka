package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RegularLanguageToLts
{
	public ObservableList<String> regularLanguageToLtsOperationsClassList = FXCollections.observableArrayList();


	public RegularLanguageToLts()
	{
		regularLanguageToLtsOperationsClassList.add("!a - negation of 'a'");
		regularLanguageToLtsOperationsClassList.add("@a is the prefix closure of 'a'");
		regularLanguageToLtsOperationsClassList.add("a* is the Kleene closure of 'a'");
		regularLanguageToLtsOperationsClassList.add("a+ is the Kleene plus of 'a'");
		regularLanguageToLtsOperationsClassList.add("a{x} means repeating 'a' x times");
		regularLanguageToLtsOperationsClassList.add("a{x,} means repeating 'a' at least x times");
		regularLanguageToLtsOperationsClassList.add("a{x,y} means repeating 'a' between x and y times");
		regularLanguageToLtsOperationsClassList.add("a? matches either 'a' or nothing");
		regularLanguageToLtsOperationsClassList.add("a|b matches either 'a' or 'b'");
		regularLanguageToLtsOperationsClassList.add("a&b means the intersection which matches if both subexpresssion (a and b) match");
		regularLanguageToLtsOperationsClassList.add("~ describes the empty language");
		regularLanguageToLtsOperationsClassList.add("$ is the language containing only the empty word");

	}

	public ObservableList<String> getRegularLanguageToLtsOperationsClassList()
	{
		return regularLanguageToLtsOperationsClassList;
	}


	public void setRegularLanguageToLtsOperationsClassList(ObservableList<String> regularLanguageToLtsOperationsClassList)
	{
		this.regularLanguageToLtsOperationsClassList = regularLanguageToLtsOperationsClassList;
	}
}
