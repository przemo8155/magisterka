
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.text.Position;
import javax.xml.ws.handler.MessageContext.Scope;

import com.itextpdf.kernel.geom.Line;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Light.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
	private ScrollPane scrollMainPane;

	@FXML
	private Button closeButton;

	public LTSPreviewController()
	{
		// TODO Auto-generated constructor stub
	}

	private void setInitialState(String state)
	{
		final double width = 800;
		Circle c = new Circle((width / 2) - 5, 70, 15.0f, Paint.valueOf("#FFFFFF"));
		c.setStroke(Paint.valueOf("#555555"));
		c.setStrokeWidth(5.0f);
		mainPane.getChildren().add(c);
		javafx.scene.shape.Line l = new javafx.scene.shape.Line((width / 2) - 5, 20, (width / 2) - 5, 55);
		l.setStroke(Paint.valueOf("#555555"));
		l.setStrokeWidth(5.0f);
		mainPane.getChildren().add(l);
		Label lab = new Label(state);
		lab.setLayoutX(c.getCenterX() - 6);
		lab.setLayoutY(c.getCenterY() - 10);
		lab.setFont(Font.font(14));
		mainPane.getChildren().add(lab);

	}

	@FXML
	public void initialize()
	{
		final double width = 800;
		final double height = 600;
		mainPane.setStyle("-fx-background-color: #F5FFFF");
		scrollMainPane.setPrefSize(width, height);
		readTemponaryFile();
		String initial = null;

		ObservableList<String> firstSplitFrom = FXCollections.observableArrayList();
		ObservableList<String> firstSplitTo = FXCollections.observableArrayList();
		ObservableList<String> firstSplitLabels = FXCollections.observableArrayList();

		ObservableList<String> tempArc = FXCollections.observableArrayList();
		ObservableList<String> tempLab = FXCollections.observableArrayList();

		ObservableList<String> doneArc = FXCollections.observableArrayList();

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

		double levelY = 120;
		String actualState = initial;
		String name = "";
		String prevName = "";

		String arc = "";

		for (String s : statesListFromFile)
		{
			int actIndex = statesListFromFile.indexOf(s);
			prevName = prevName.replaceAll("s", "");
			String[] prevNameParts = prevName.split(" ");

			if (prevName.length() > 0)
			{
				for (String part : prevNameParts)
				{
					Integer i = Integer.parseInt(part);
					if (i > actIndex)
					{
						name += "s" + part + " ";
					}
				}
			}

			try
			{
				int spaceIndex = s.indexOf("[");
				if (spaceIndex != -1)
				{
					s = s.substring(0, spaceIndex);
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}

			for (String a : arcsListFromFile)
			{
				String[] parts = a.split(" ");
				if (parts[0].equals(s))
				{
					tempArc.add(parts[2]);
					tempLab.add(parts[1]);
				}
			}

			for (String f : tempArc)
			{
				if (!name.contains(f))
				{
					name += f + " ";

				}
			}

			for(String f : tempLab)
			{
				if(!arc.contains(f))
				{
					arc += f + " ";
				}
			}

			int widthPersp = name.length() * 5;

			Rectangle r = new Rectangle(width/2 - 5 - widthPersp*0.80, levelY, 15 + 1.3f*widthPersp,
					22.0f);
			r.setFill(Paint.valueOf("FFFFFF"));
			r.setStroke(Paint.valueOf("#555555"));
			r.setStrokeWidth(5.0f);
			mainPane.getChildren().add(r);


			javafx.scene.shape.Line l = new javafx.scene.shape.Line((width / 2) - 5, levelY - 25, (width / 2) - 5,
					levelY - 5);
			l.setStroke(Paint.valueOf("#555555"));
			l.setStrokeWidth(5.0f);
			mainPane.getChildren().add(l);

			Label lab = new Label(name);
			lab.setLayoutX((width / 2) - widthPersp*0.65);
			lab.setLayoutY(levelY);
			lab.setFont(Font.font(14));
			mainPane.getChildren().add(lab);

			Label lab2 = new Label("Step " + String.valueOf(actIndex+1) + ":\t");
			lab2.setLayoutX((width / 2) - 300);
			lab2.setLayoutY(levelY);
			lab2.setFont(Font.font(14));
			mainPane.getChildren().add(lab2);

			Label lab3 = new Label(arc);
			lab3.setLayoutX((width / 2) + 15);
			lab3.setLayoutY(levelY - 26);
			lab3.setFont(Font.font(14));
			mainPane.getChildren().add(lab3);

			prevName = name;
			name = "";
			arc = "";
			levelY = levelY + 50;
			tempArc.clear();
			tempLab.clear();
		}

		scrollMainPane.setContent(mainPane);
		scrollMainPane.setMinHeight(levelY + 60);
		scrollMainPane.setMaxHeight(levelY + 60);
		mainPane.setMinHeight(levelY + 60);
		mainPane.setMinHeight(levelY + 60);
		this.closeButton.setLayoutY(levelY + 30);



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
		}

		File file1 = new File("out_temp.txt");
		file1.delete();

	}

	private void drawLevel(String state, int maxLevel, int maxWidthSize, int actualWidthPosition, int beforeWidthPos)
	{
		final double width = 800;
		final double height = 600;

		Circle c = new Circle(actualWidthPosition * (width / maxWidthSize) - 5, (height / maxLevel), 15.0f,
				Paint.valueOf("#FFFFFF"));
		c.setStroke(Paint.valueOf("#555555"));
		c.setStrokeWidth(5.0f);
		mainPane.getChildren().add(c);
		javafx.scene.shape.Line l = new javafx.scene.shape.Line((width / beforeWidthPos) - 5,
				beforeWidthPos * (height / maxLevel), actualWidthPosition * (width / maxWidthSize) - 5,
				actualWidthPosition * (height / maxLevel));
		l.setStroke(Paint.valueOf("#555555"));
		l.setStrokeWidth(5.0f);
		mainPane.getChildren().add(l);
		Label lab = new Label(state);
		lab.setLayoutX(c.getCenterX() - 6);
		lab.setLayoutY(c.getCenterY() - 10);
		lab.setFont(Font.font(14));
		mainPane.getChildren().add(lab);
	}

	private void draw(String state, int maxLevels, int actualLevel, int maxWidthObjects, int actualWidthObject,
			int previousWidthObject)
	{
		final double width = 800;
		final double height = 600;

		Circle c = new Circle(actualWidthObject * (width / maxWidthObjects) - 5, actualLevel * (height / maxLevels),
				15.0f, Paint.valueOf("#FFFFFF"));
		c.setStroke(Paint.valueOf("#555555"));
		c.setStrokeWidth(5.0f);
		mainPane.getChildren().add(c);

		javafx.scene.shape.Line l = new javafx.scene.shape.Line((width / previousWidthObject) - 5,
				(actualLevel - 1) * (height / maxLevels), actualWidthObject * (width / maxWidthObjects) - 5,
				actualLevel * (height / maxLevels));
		l.setStroke(Paint.valueOf("#555555"));
		l.setStrokeWidth(5.0f);
		mainPane.getChildren().add(l);
		Label lab = new Label(state);

		lab.setLayoutX(c.getCenterX() - 6);
		lab.setLayoutY(c.getCenterY() - 10);
		lab.setFont(Font.font(14));
		mainPane.getChildren().add(lab);
	}

}
