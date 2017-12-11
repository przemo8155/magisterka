
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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
	Log log = new Log();
	Logger logger = new Logger(log, null);

	public String backgroundColorString = null, circleColorString = null, rectangleColorString = null,
			lineColorString = null;

	@FXML
	private Button cancelButton, saveButton;

	@FXML
	private Label backgroundColorLabel, circleColorLabel, rectangleColorLabel, lineColorLabel;

	@FXML
	private ComboBox<String> backgroundColorBox, circleColorBox, rectangleColorBox, lineColorBox;

	public ObservableList<String> allEnableColors = FXCollections.observableArrayList();

	// colors
	private final String white = "#FFFFFF";
	private final String black = "#3A3938";
	private final String blue = "#5C4CFB";
	private final String red = "#FF420E";
	private final String green = "#89C25E";
	private final String yellow = "#E7DF18";
	private final String pink = "#D118E7";

	public void ReadSettings()
	{
		File f = new File("settings.sat");
		if(f.exists())
		{
			try {
				BufferedReader br = new BufferedReader(new FileReader("settings.sat"));
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();
			    int i = 1;
			    while (line != null) {
			    	if(i == 1)
			    	{
			    		backgroundColorString = line;
			    	} else if(i == 2)
			    	{
			    		circleColorString = line;
			    	} else if(i == 3)
			    	{
			    		rectangleColorString= line;
			    	} else if(i == 4)
			    	{
			    		lineColorString = line;
			    	}
			    	i=i+1;
			    	line = br.readLine();
			    }

			    String everything = sb.toString();
			    i = 1;
			    br.close();
			} catch(IOException e){
				logger.debug(e.getLocalizedMessage());

			}
		}
		else
		{	Utilities.infoBox("else");
			try
			{
				FileWriter fileWriter = new FileWriter("settings.sat");
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.println(white);
			    printWriter.println(white);
			    printWriter.println(white);
			    printWriter.println(black);
			    setBackgroundColor(white);
			    setCircleColor(white);
			    setRectangleColor(white);
			    setLineColor(black);
			    printWriter.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}


	}

	public void WriteSettings()
	{
		try
		{
			FileWriter fileWriter = new FileWriter("settings.sat");
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.println(backgroundColorString);
		    printWriter.println(circleColorString);
		    printWriter.println(rectangleColorString);
		    printWriter.println(lineColorString);
		    printWriter.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}


	}

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
							} else if (item.contains("Red"))
							{
								setTextFill(Color.RED);
							} else if (item.contains("Green"))
							{
								setTextFill(Color.GREEN);
							} else if (item.contains("Yellow"))
							{
								setTextFill(Color.YELLOW);
							} else if (item.contains("Pink"))
							{
								setTextFill(Color.PINK);
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
							} else if (item.contains("Red"))
							{
								setTextFill(Color.RED);
							} else if (item.contains("Green"))
							{
								setTextFill(Color.GREEN);
							} else if (item.contains("Yellow"))
							{
								setTextFill(Color.YELLOW);
							} else if (item.contains("Pink"))
							{
								setTextFill(Color.PINK);
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
							} else if (item.contains("White"))
							{
								setTextFill(Color.BLACK);
							} else if (item.contains("Blue"))
							{
								setTextFill(Color.BLUE);
							} else if (item.contains("Red"))
							{
								setTextFill(Color.RED);
							} else if (item.contains("Green"))
							{
								setTextFill(Color.GREEN);
							} else if (item.contains("Yellow"))
							{
								setTextFill(Color.YELLOW);
							} else if (item.contains("Pink"))
							{
								setTextFill(Color.PINK);
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
								setTextFill(Color.BLACK);
							} else if (item.contains("White"))
							{

							} else if (item.contains("Blue"))
							{
								setTextFill(Color.BLUE);
							} else if (item.contains("Red"))
							{
								setTextFill(Color.RED);
							} else if (item.contains("Green"))
							{
								setTextFill(Color.GREEN);
							} else if (item.contains("Yellow"))
							{
								setTextFill(Color.YELLOW);
							} else if (item.contains("Pink"))
							{
								setTextFill(Color.PINK);
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

		backgroundColorBox.getItems().addAll("Default", "Black", "Blue", "Red", "Green", "Yellow", "Pink");
		circleColorBox.getItems().addAll("Default", "Black", "Blue", "Red", "Green", "Yellow", "Pink");
		rectangleColorBox.getItems().addAll("Default", "Black", "Blue", "Red", "Green", "Yellow", "Pink");
		lineColorBox.getItems().addAll("Default", "White", "Blue", "Red", "Green", "Yellow", "Pink");
		ReadSettings();
		setComboItems();
		backgroundSetItems();
		circleSetItems();
		rectangleSetItems();
		arrowSetItems();

	}

	@FXML
	void saveButton_OnAction(ActionEvent event)
	{
		switch (backgroundColorBox.getSelectionModel().getSelectedIndex())
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
			case 3:
				setBackgroundColor(red);
				break;
			case 4:
				setBackgroundColor(green);
				break;
			case 5:
				setBackgroundColor(yellow);
				break;
			case 6:
				setBackgroundColor(pink);
				break;
		}

		switch (circleColorBox.getSelectionModel().getSelectedIndex())
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
			case 3:
				setCircleColor(red);
				break;
			case 4:
				setCircleColor(green);
				break;
			case 5:
				setCircleColor(yellow);
				break;
			case 6:
				setCircleColor(pink);
				break;
		}

		switch (rectangleColorBox.getSelectionModel().getSelectedIndex())
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
			case 3:
				setRectangleColor(red);
				break;
			case 4:
				setRectangleColor(green);
				break;
			case 5:
				setRectangleColor(yellow);
				break;
			case 6:
				setRectangleColor(pink);
				break;
		}

		switch (lineColorBox.getSelectionModel().getSelectedIndex())
		{
			case 0:
				setLineColor(black);
				break;
			case 1:
				setLineColor(white);
				break;
			case 2:
				setLineColor(blue);
				break;
			case 3:
				setLineColor(red);
				break;
			case 4:
				setLineColor(green);
				break;
			case 5:
				setLineColor(yellow);
				break;
			case 6:
				setLineColor(pink);
				break;
		}
		//UpdateDatabase updateDatabase = new UpdateDatabase();
		//updateDatabase.Update(backgroundColorString, "background");
		//updateDatabase.Update(circleColorString, "circle");
		//updateDatabase.Update(rectangleColorString, "rectangle");
		//updateDatabase.Update(lineColorString, "arrow");

		WriteSettings();

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
			case red:
				backgroundColorBox.getSelectionModel().select(3);
				break;
			case green:
				backgroundColorBox.getSelectionModel().select(4);
				break;
			case yellow:
				backgroundColorBox.getSelectionModel().select(5);
				break;
			case pink:
				backgroundColorBox.getSelectionModel().select(6);
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
			case red:
				circleColorBox.getSelectionModel().select(3);
				break;
			case green:
				circleColorBox.getSelectionModel().select(4);
				break;
			case yellow:
				circleColorBox.getSelectionModel().select(5);
				break;
			case pink:
				circleColorBox.getSelectionModel().select(6);
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
			case red:
				rectangleColorBox.getSelectionModel().select(3);
				break;
			case green:
				rectangleColorBox.getSelectionModel().select(4);
				break;
			case yellow:
				rectangleColorBox.getSelectionModel().select(5);
				break;
			case pink:
				rectangleColorBox.getSelectionModel().select(6);
				break;
		}

		switch (lineColorString)
		{
			case black:
				lineColorBox.getSelectionModel().select(0);
				break;
			case white:
				lineColorBox.getSelectionModel().select(1);
				break;
			case blue:
				lineColorBox.getSelectionModel().select(2);
				break;
			case red:
				lineColorBox.getSelectionModel().select(3);
				break;
			case green:
				lineColorBox.getSelectionModel().select(4);
				break;
			case yellow:
				lineColorBox.getSelectionModel().select(5);
				break;
			case pink:
				lineColorBox.getSelectionModel().select(6);
				break;
		}
	}

}
