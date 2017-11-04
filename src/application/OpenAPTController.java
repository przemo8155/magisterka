package application;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class OpenAPTController
{
	Stage stage = MainWindowController.aptStage;

	@FXML
	private Label headLabel, typeLabel, fileLabel;

	@FXML
	private Button selectFileButton;

	@FXML
	private TextField fileTextField;

	@FXML
	private ChoiceBox<String> typeChoiceBox;

	private ObservableList<String> list = FXCollections.observableArrayList("Bounded", "Coverab", "Weakly live");

	public void initialize()
	{
		typeChoiceBox.setItems(list);
		typeChoiceBox.getSelectionModel().selectFirst();
	}

	@FXML
	void selectFileButton_OnAction(ActionEvent event)
	{
		FileChooser fileChooser = new FileChooser();
		File file;
		fileChooser.setTitle("Open File");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("APT files (*.apt)", "*.apt");
		fileChooser.getExtensionFilters().add(extFilter);
		file = fileChooser.showOpenDialog(stage);
	}
}
