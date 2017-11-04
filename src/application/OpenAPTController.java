package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;



public class OpenAPTController
{
	@FXML
	private Label headLabel, typeLabel;

	@FXML
	private ChoiceBox<String> typeChoiceBox;

	private ObservableList<String> list = FXCollections.observableArrayList("Bounded", "Coverab", "Weakly live");

	public void initialize()
	{
		typeChoiceBox.setItems(list);
		typeChoiceBox.getSelectionModel().selectFirst();
	}
}
