
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
	private Button selectFileButton, openButton, closeButton;

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
		String startDir = System.getProperty("user.dir");
		File directory = new File(startDir);
		File file;


		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open APT File");
		fileChooser.setInitialDirectory(directory);
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("APT files (*.apt)", "*.apt");
		fileChooser.getExtensionFilters().add(extFilter);

		file = fileChooser.showOpenDialog(stage);

		if (file != null)
		{
			fileTextField.setText(file.getAbsolutePath());
		}
	}

	@FXML
	void closeButton_OnAction(ActionEvent event)
	{
		Stage closeStage = (Stage) closeButton.getScene().getWindow();
		closeStage.close();
	}

	@FXML
	void openButton_OnAction(ActionEvent event)
	{

	}
}
