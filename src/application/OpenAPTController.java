
package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OpenAPTController
{
	BigInfoAPTList bial = new BigInfoAPTList();

	public String typeOfNet = "";
	final String startDir = System.getProperty("user.dir");
	final String eee = startDir + "\\apt\\apt.jar";
	final String aptJarPath = eee.replaceAll("\\\\", "/");
	String sep = System.getProperty("file.separator");
	Stage stage = MainWindowController.aptStage;

	File jarFile;


	@FXML
	private Label headLabel, typeLabel, fileLabel;

	@FXML
	private Label label1;

	@FXML
	private Button selectFileButton, openButton, closeButton, infoAboutNetButton;

	@FXML
	private TextField fileTextField;

	@FXML
	private ChoiceBox<String> typeChoiceBox;

	final Tooltip tooltip = new Tooltip();

	public void initialize()
	{
		HashMap<String, String> myList = bial.getBigList();
		ArrayList<String> tempList = new ArrayList<String>(myList.keySet());
		ObservableList<String> allTypes= FXCollections.observableArrayList(tempList);
		typeChoiceBox.setItems(allTypes);
		typeChoiceBox.getSelectionModel().selectFirst();
		typeChoiceBox.setOnMouseMoved(mouseHandler);

	}

	 EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent mouseEvent) {

	        	Node node = (Node) mouseEvent.getSource();
	        	tooltip.setText(startDir);
	        	tooltip.show(node, mouseEvent.getScreenX(), mouseEvent.getScreenY());


	        }

	    };

	@FXML
	void selectFileButton_OnAction(ActionEvent event)
	{
		File file;
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
			setJarFile(file);
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
		if (typeChoiceBox.getSelectionModel().isSelected(1))
		{

		} else
		{
			Alert alert = new Alert(AlertType.WARNING,
					"You need to set type of net as 'coverab' to open net in program.", ButtonType.OK);
			alert.showAndWait();

		}

	}

	@FXML
	void infoAboutNetButton_OnAction(ActionEvent event)
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

		if (!fileTextField.getText().trim().isEmpty())
		{
			JarProcess(jarFile);

		} else
		{
			Alert alert = new Alert(AlertType.WARNING, "Select file.", ButtonType.OK);
			alert.showAndWait();
		}
	}

	public void setJarFile(File file)
	{
		this.jarFile = file;
	}

	public File getJarFile()
	{
		return this.jarFile;
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
			Utilities.infoBox(strFileContents);
			System.out.println(strFileContents);
		} catch (IOException e)
		{
			System.out.print(e.getMessage());
		}

	}
}
