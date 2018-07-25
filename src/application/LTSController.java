package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LTSController
{
	@FXML
	private Pane mainPane;

	@FXML
	private ScrollPane scrollMainPane;

	@FXML
	private Button closeButton;

	@FXML
	private Label pathInfoLabel, pathLabel, ltsPreviewLabel;

	Utilities utilities = new Utilities();

	ObservableList<String> statesListFromFile = FXCollections.observableArrayList();
	ObservableList<String> labelsListFromFile = FXCollections.observableArrayList();
	ObservableList<String> arcsListFromFile = FXCollections.observableArrayList();

	ObservableList<String> statesDone = FXCollections.observableArrayList();
	ObservableList<String> tempArc = FXCollections.observableArrayList();
	ObservableList<String> tempLab = FXCollections.observableArrayList();

	private String filePath = "";

	public LTSController()
	{

	}

	@FXML
	void closeButton_OnAction(ActionEvent event)
	{
		Stage closeStage = (Stage) closeButton.getScene().getWindow();
		closeStage.close();
	}

	@FXML
	public void initialize()
	{
		final double width = 800;
		final double height = 600;
		mainPane.setStyle("-fx-background-color: #ffefcc");
		scrollMainPane.setPrefSize(width, height);
		readTemponaryFile();
		pathLabel.setText(filePath);

		String initial = null;

		for (String s : statesListFromFile)
		{
			if (s.contains("initial"))
			{
				statesDone.add(s);
				int spaceIndex = s.indexOf("[");
				if (spaceIndex != -1)
				{
					s = s.substring(0, spaceIndex);
				}

				createCircle(width/2, 200, s);
				initial = s;


			}
		}



	}


	void createCircle(double posX, double posY, String text)
	{
		Circle c = new Circle(posX, posY, 15.0f, Paint.valueOf("#FFFFFF"));
		mainPane.getChildren().add(c);
		Label lab = new Label(text);
		lab.setLayoutX(c.getCenterX() - 6);
		lab.setLayoutY(c.getCenterY() - 10);
		lab.setFont(Font.font(14));
		mainPane.getChildren().add(lab);
	}

	void readTemponaryFile()
	{
		BufferedReader reader1 = null;

		try
		{
			File file1 = new File("out_temp.txt");
			reader1 = new BufferedReader(new FileReader(file1));

			String line1;
			while ((line1 = reader1.readLine()) != null)
			{

				if (line1.equals("path"))
				{
					this.filePath = reader1.readLine();

				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}


		try
		{
			File file1 = new File("out_temp.txt");
			reader1 = new BufferedReader(new FileReader(file1));

			String line1;
			while ((line1 = reader1.readLine()) != null)
			{

				if (line1.equals("states"))
				{
					while (!(line1 = reader1.readLine()).equals("labels"))
					{
						if (!line1.equals("") && !statesListFromFile.contains(line1))
						{
							statesListFromFile.add(line1);
						}
					}

				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			File file1 = new File("out_temp.txt");
			reader1 = new BufferedReader(new FileReader(file1));

			String line1;
			while ((line1 = reader1.readLine()) != null)
			{

				if (line1.equals("labels"))
				{
					while (!(line1 = reader1.readLine()).equals("arcs"))
					{
						if (!line1.equals("") && !labelsListFromFile.contains(line1))
						{
							labelsListFromFile.add(line1);
						}
					}

				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			File file1 = new File("out_temp.txt");
			reader1 = new BufferedReader(new FileReader(file1));

			String line1;
			while ((line1 = reader1.readLine()) != null)
			{

				if (line1.equals("arcs"))
				{

					while ((line1 = reader1.readLine()) != null)
					{
						if (!line1.equals("") && !line1.contains("arcs") && !arcsListFromFile.contains(line1))
						{
							arcsListFromFile.add(line1);
						}
					}

				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		File file1 = new File("out_temp.txt");
		file1.delete();

	}


}
