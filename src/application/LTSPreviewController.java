
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.itextpdf.kernel.geom.Line;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.Event;

public class LTSPreviewController
{

	Utilities utilities = new Utilities();

	ObservableList<String> statesListFromFile = FXCollections.observableArrayList();
	ObservableList<String> labelsListFromFile = FXCollections.observableArrayList();
	ObservableList<String> arcsListFromFile = FXCollections.observableArrayList();

	@FXML
	private Pane mainPane;

	@FXML
	private Button closeButton;

	public LTSPreviewController()
	{
		// TODO Auto-generated constructor stub
	}

	private void setInitialState(String state)
	{
		final double width = 800;
		Circle c = new Circle((width / 2) - 5, 70, 20.0f, Paint.valueOf("#FFFFFF"));
		c.setStroke(Paint.valueOf("#555555"));
		c.setStrokeWidth(5.0f);
		mainPane.getChildren().add(c);
		Point2D p1 = new Point2D(50, 20);
		javafx.scene.shape.Line l = new javafx.scene.shape.Line((width / 2) - 5, 20, (width / 2) - 5, 50);
		l.setStroke(Paint.valueOf("#555555"));
		l.setStrokeWidth(5.0f);
		mainPane.getChildren().add(l);
		Label lab = new Label(state);
		lab.setLayoutX(c.getCenterX() - 5);
		lab.setLayoutY(c.getCenterY() - 5);
		mainPane.getChildren().add(lab);

	}

	@FXML
	public void initialize()
	{
		final double width = 800;
		mainPane.setStyle("-fx-background-color: #FFFFFF");
		readTemponaryFile();
		String initial = null;

		ObservableList<String> firstSplitFrom = FXCollections.observableArrayList();
		ObservableList<String> firstSplitTo = FXCollections.observableArrayList();
		ObservableList<String> firstSplitLabels = FXCollections.observableArrayList();
		for (String s : statesListFromFile)
		{
			if (s.contains("initial"))
			{
				int spaceIndex = s.indexOf("[");
				if (spaceIndex != -1)
				{
					s = s.substring(0, spaceIndex);
				}
				setInitialState(s);
				initial = s;
			}
		}

		for (String s : arcsListFromFile)
		{
			String[] parts = s.split(" ");
			firstSplitTo.add(parts[2]);
			firstSplitLabels.add(parts[1]);
			firstSplitFrom.add(parts[0]);
		}

	}

	@FXML
	void closeButton_OnAction(ActionEvent event)
	{
		Stage closeStage = (Stage) closeButton.getScene().getWindow();
		closeStage.close();
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

				if (line1.equals("states"))
				{
					while (!(line1 = reader1.readLine()).equals("labels"))
					{
						if (!line1.equals(""))
						{
							statesListFromFile.add(line1);
						}
					}

				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				reader1.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
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
						if (!line1.equals(""))
						{
							labelsListFromFile.add(line1);
						}
					}

				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				reader1.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
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
						if (!line1.equals("") && !line1.contains("arcs"))
						{
							arcsListFromFile.add(line1);
						}
					}

				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				reader1.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

}
