
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
import javafx.scene.layout.Pane;
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
							} else if (item.contains("Black"))
							{
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
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
							} else if (item.contains("Black"))
							{
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
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
							} else if (item.contains("Black"))
							{
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
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
							} else if (item.contains("Black"))
							{
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
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


		switch(circleColorBox.getSelectionModel().getSelectedIndex())
		{
			case 0:
				setCircleColor(white);
				break;
			case 1:
				setCircleColor(black);
				break;
			case 2:
				setCircleColor(blue);
				break;
		}

		switch(rectangleColorBox.getSelectionModel().getSelectedIndex())
		{
			case 0:
				setRectangleColor(white);
				break;
			case 1:
				setRectangleColor(black);
				break;
			case 2:
				setRectangleColor(blue);
				break;
		}

		switch(lineColorBox.getSelectionModel().getSelectedIndex())
		{
			case 0:
				setLineColor(white);
				break;
			case 1:
				setLineColor(black);
				break;
			case 2:
				setLineColor(blue);
				break;
		}
		UpdateDatabase updateDatabase = new UpdateDatabase();
		updateDatabase.Update(backgroundColorString, "background");
		updateDatabase.Update(circleColorString, "circle");
		updateDatabase.Update(rectangleColorString, "rectangle");
		updateDatabase.Update(lineColorString, "arrow");

		cancelButton_OnAction(event);

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
			case white:
				backgroundColorBox.getSelectionModel().select(0);
				break;
			case black:
				backgroundColorBox.getSelectionModel().select(1);
				break;
			case blue:
				backgroundColorBox.getSelectionModel().select(2);
				break;
		}

		switch (circleColorString)
		{
			case white:
				circleColorBox.getSelectionModel().select(0);
				break;
			case black:
				circleColorBox.getSelectionModel().select(1);
				break;
			case blue:
				circleColorBox.getSelectionModel().select(2);
				break;
		}

		switch (rectangleColorString)
		{
			case white:
				rectangleColorBox.getSelectionModel().select(0);
				break;
			case black:
				rectangleColorBox.getSelectionModel().select(1);
				break;
			case blue:
				rectangleColorBox.getSelectionModel().select(2);
				break;
		}

		switch (lineColorString)
		{
			case white:
				lineColorBox.getSelectionModel().select(0);
				break;
			case black:
				lineColorBox.getSelectionModel().select(1);
				break;
			case blue:
				lineColorBox.getSelectionModel().select(2);
				break;
		}
	}

}
