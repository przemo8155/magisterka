
package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

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

	public String typeOfNet = "";
	final String startDir = System.getProperty("user.dir");
	final String eee = startDir + "\\apt\\apt.jar";
	final String aptJarPath = eee.replaceAll("\\\\", "/");
	String sep = System.getProperty("file.separator");
	Stage stage = MainWindowController.aptStage;
	File file;

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

		File directory = new File(startDir);
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
		if (typeChoiceBox.getSelectionModel().isSelected(0))
		{
			typeOfNet = "bounded";
		} else if (typeChoiceBox.getSelectionModel().isSelected(1))
		{
			typeOfNet = "coverab";
		} else if (typeChoiceBox.getSelectionModel().isSelected(2))
		{
			typeOfNet = "weakly_live";
		} else
		{
			typeOfNet = "";
		}

		JarProcess(file);
	}

	void JarProcess(File file)
	{

		try
		{
			ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar", typeOfNet,
					file.getAbsolutePath());

			Process p = pb.start();
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			byte[] contents = new byte[1024];

			int bytesRead = 0;
			String strFileContents = "";
			while ((bytesRead = in.read(contents)) != -1)
			{
				strFileContents += new String(contents, 0, bytesRead);
			}
			System.out.println(strFileContents);
		} catch (IOException e)
		{
			System.out.print(e.getMessage());
		}

	}
}
