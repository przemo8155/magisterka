
package application;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SettingsController
{

	public String backgroundColorString, circleColorString, rectangleColorString, lineColorString;

	@FXML
	private Button cancelButton, saveButton;

	@FXML
	private Label backgroundColorLabel, circleColorLabel, rectangleColorLabel, lineColorLabel;

	@FXML
	private ComboBox<String> backgroundColorBox, circleColorBox, rectangleColorBox, lineColorBox;

	private SettingsFileManager settingsFileManager;

	public void initialize()
	{

		backgroundColorBox.getItems().addAll("Default", "Black", "Blue");

		circleColorBox.getItems().addAll("Default", "Black", "Blue");
		rectangleColorBox.getItems().addAll("Default", "Black", "Blue");
		lineColorBox.getItems().addAll("Default", "Black", "Blue");

	}

	@FXML
	void saveButton_OnAction(ActionEvent event)
	{
		try
		{
			if(backgroundColorString.equals(null))
			{
				backgroundColorString = "White";
			}

			if(circleColorString.equals(null))
			{
				circleColorString = "White";

			}

			if(rectangleColorString.equals(null))
			{
				rectangleColorString = "White";
			}

			if(lineColorString.equals(null))
			{
				lineColorString = "White";
			}
			settingsFileManager.SaveSettingsFile(backgroundColorString, circleColorString, rectangleColorString, lineColorString);

		} catch (NullPointerException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void cancelButton_OnAction(ActionEvent event)
	{
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	public String getBackgroundColorLabel()
	{
		return backgroundColorString;
	}

	public void setBackgroundColorLabel(String a)
	{
		backgroundColorString = a;
	}

	public String getCircleColorLabel()
	{
		return circleColorString;
	}

	public void setCircleColorLabel(String a)
	{
		circleColorString = a;
	}

	public String getRectangleColorLabel()
	{
		return rectangleColorString;
	}

	public void setRectangleColorLabel(String a)
	{
		rectangleColorString = a;
	}

	public String getLineColorLabel()
	{
		return lineColorString;
	}

	public void setLineColorLabel(String a)
	{
		lineColorString = a;
	}

}
