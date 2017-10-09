
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

	public String backgroundColorString = null, circleColorString = null, rectangleColorString = null,
			lineColorString = null;

	@FXML
	private Button cancelButton, saveButton;

	@FXML
	private Label backgroundColorLabel, circleColorLabel, rectangleColorLabel, lineColorLabel;

	@FXML
	private ComboBox<String> backgroundColorBox, circleColorBox, rectangleColorBox, lineColorBox;

	public ObservableList<String> allEnableColors = FXCollections.observableArrayList();

	//colors
	private final String white = "#FFFFFF";
	private final String black = "#3A3938";
	private final String blue = "#5C4CFB";

	private void backgroundSetItems()
	{
		backgroundColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default"))
							{
								setBackgroundColor("#FFFFFF");
							} else if (item.contains("Black"))
							{
								setBackgroundColor("#3A3938");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setBackgroundColor("#5C4CFB");
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

	private void circleSetItems()
	{
		circleColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default"))
							{
								setCircleColor("#555555");
							} else if (item.contains("Black"))
							{
								setCircleColor("#3A3938");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setCircleColor("#5C4CFB");
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

	private void rectangleSetItems()
	{
		rectangleColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default"))
							{
								setRectangleColor("#ABCDEF");
							} else if (item.contains("Black"))
							{
								setRectangleColor("#3A3938");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setRectangleColor("#5C4CFB");
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

	private void arrowSetItems()
	{
		lineColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				final ListCell<String> cell = new ListCell<String>()
				{

					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (item != null)
						{
							setText(item);
							if (item.contains("Default"))
							{
								setLineColor("#FFFFFF");
							} else if (item.contains("Black"))
							{
								setLineColor("#3A3938");
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setLineColor("#5C4CFB");
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

	public void initialize()
	{

		backgroundColorBox.getItems().addAll("Default", "Black", "Blue");
		circleColorBox.getItems().addAll("Default", "Black", "Blue");
		rectangleColorBox.getItems().addAll("Default", "Black", "Blue");
		lineColorBox.getItems().addAll("Default", "Black", "Blue");
		getDataFromDatabase();
		setComboItems();
		backgroundSetItems();
		circleSetItems();
		rectangleSetItems();
		arrowSetItems();

	}

	@FXML
	void saveButton_OnAction(ActionEvent event)
	{
		switch(backgroundColorBox.getSelectionModel().getSelectedIndex())
		{
			case 0:
				setBackgroundColor(white);
				break;
			case 1:
				setBackgroundColor(black);
				break;
			case 2:
				setBackgroundColor(blue);
				break;
		}
		UpdateDatabase updateDatabase = new UpdateDatabase();
		updateDatabase.Update(backgroundColorString, "background");

	}

	@FXML
	void cancelButton_OnAction(ActionEvent event)
	{
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	public String getBackgroundColor()
	{
		return backgroundColorString;
	}

	public void setBackgroundColor(String a)
	{
		backgroundColorString = a;
	}

	public String getCircleColor()
	{
		return circleColorString;
	}

	public void setCircleColor(String a)
	{
		circleColorString = a;
	}

	public String getRectangleColor()
	{
		return rectangleColorString;
	}

	public void setRectangleColor(String a)
	{
		rectangleColorString = a;
	}

	public String getLineColor()
	{
		return lineColorString;
	}

	public void setLineColor(String a)
	{
		lineColorString = a;
	}

	private void getDataFromDatabase()
	{
		ConnectToDatabase ctd = new ConnectToDatabase();
		ctd.Connect();
		this.backgroundColorString = ctd.getBackgroundString();
		this.circleColorString = ctd.getCircleString();
		this.rectangleColorString = ctd.getRectangleString();
		this.lineColorString = ctd.getArrowString();
	}

	private void setComboItems()
	{
		switch (backgroundColorString)
		{
			case "#FFFFFF":
				backgroundColorBox.getSelectionModel().select(0);
				break;
			case "#3A3938":
				backgroundColorBox.getSelectionModel().select(1);
				break;
			case "#5C4CFB":
				backgroundColorBox.getSelectionModel().select(2);
				break;
		}

		switch (circleColorString)
		{
			case "#555555":
				circleColorBox.getSelectionModel().select(0);
				break;
			case "#3A3938":
				circleColorBox.getSelectionModel().select(1);
				break;
			case "#5C4CFB":
				circleColorBox.getSelectionModel().select(2);
				break;
		}

		switch (rectangleColorString)
		{
			case "#ABCDEF":
				rectangleColorBox.getSelectionModel().select(0);
				break;
			case "#3A3938":
				rectangleColorBox.getSelectionModel().select(1);
				break;
			case "#5C4CFB":
				rectangleColorBox.getSelectionModel().select(2);
				break;
		}

		switch (lineColorString)
		{
			case "#FFFFFF":
				lineColorBox.getSelectionModel().select(0);
				break;
			case "#3A3938":
				lineColorBox.getSelectionModel().select(1);
				break;
			case "#5C4CFB":
				lineColorBox.getSelectionModel().select(2);
				break;
		}
	}

}
