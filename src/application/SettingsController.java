
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
		backgroundColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
						super.setFont(Font.font("Allan", 14));
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default (White)"))
							{
								setBackgroundColorLabel("White");
							} else if (item.contains("Black"))
							{
								setBackgroundColorLabel("White");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setBackgroundColorLabel("White");
								setTextFill(Color.BLUE);
							}
						} else
						{
							setText(null);
						}
					}
				};
				return cell;
			}
		});

		circleColorBox.getItems().addAll("Default", "Black", "Blue");
		circleColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
						super.setFont(Font.font("Allan", 14));
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default (White)"))
							{
								setCircleColorLabel("White");
							} else if (item.contains("Black"))
							{
								setCircleColorLabel("White");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setCircleColorLabel("White");
								setTextFill(Color.BLUE);
							}
						} else
						{
							setText(null);
						}
					}
				};
				return cell;
			}
		});

		rectangleColorBox.getItems().addAll("Default", "Black", "Blue");
		rectangleColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
						super.setFont(Font.font("Allan", 14));
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default (White)"))
							{
								setRectangleColorLabel("White");
							} else if (item.contains("Black"))
							{
								setRectangleColorLabel("White");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setRectangleColorLabel("White");
								setTextFill(Color.BLUE);
							}
						} else
						{
							setText(null);
						}
					}
				};
				return cell;
			}
		});

		lineColorBox.getItems().addAll("Default", "Black", "Blue");
		lineColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
						super.setFont(Font.font("Allan", 14));
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default (White)"))
							{
								setLineColorLabel("White");
							} else if (item.contains("Black"))
							{
								setLineColorLabel("White");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setLineColorLabel("White");
								setTextFill(Color.BLUE);
							}
						} else
						{
							setText(null);
						}
					}
				};
				return cell;
			}
		});

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
