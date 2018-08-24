package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

	private static final double defaultArrowHeadSize = 5.0;

	ObservableList<String> statesListFromFile = FXCollections.observableArrayList();
	ObservableList<String> labelsListFromFile = FXCollections.observableArrayList();
	ObservableList<String> arcsListFromFile = FXCollections.observableArrayList();

	ObservableList<String> statesDone = FXCollections.observableArrayList();
	ObservableList<String> tempArc = FXCollections.observableArrayList();
	ObservableList<String> tempLab = FXCollections.observableArrayList();

	ObservableList<String> level1 = FXCollections.observableArrayList();
	ObservableList<String> level2 = FXCollections.observableArrayList();
	ObservableList<String> level3 = FXCollections.observableArrayList();
	ObservableList<String> level4 = FXCollections.observableArrayList();
	ObservableList<String> level5= FXCollections.observableArrayList();
	ObservableList<String> level6 = FXCollections.observableArrayList();
	ObservableList<String> level7 = FXCollections.observableArrayList();
	ObservableList<String> level8 = FXCollections.observableArrayList();

	ObservableList<Circle> level1Circ = FXCollections.observableArrayList();
	ObservableList<Circle> level2Circ = FXCollections.observableArrayList();
	ObservableList<Circle> level3Circ = FXCollections.observableArrayList();
	ObservableList<Circle> level4Circ = FXCollections.observableArrayList();
	ObservableList<Circle> level5Circ = FXCollections.observableArrayList();
	ObservableList<Circle> level6Circ = FXCollections.observableArrayList();
	ObservableList<Circle> level7Circ = FXCollections.observableArrayList();
	ObservableList<Circle> level8Circ = FXCollections.observableArrayList();

	ObservableList<Label> level1Lab = FXCollections.observableArrayList();
	ObservableList<Label> level2Lab = FXCollections.observableArrayList();
	ObservableList<Label> level3Lab = FXCollections.observableArrayList();
	ObservableList<Label> level4Lab = FXCollections.observableArrayList();
	ObservableList<Label> level5Lab = FXCollections.observableArrayList();
	ObservableList<Label> level6Lab = FXCollections.observableArrayList();
	ObservableList<Label> level7Lab = FXCollections.observableArrayList();
	ObservableList<Label> level8Lab = FXCollections.observableArrayList();


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

				initial = s;

				level1.add(initial);
			}
		}

		for(String s : arcsListFromFile)
		{
			String[] parts = s.split(" ");
			for(String state : level1)
			{
				if(state.equals(parts[0]) && !level2.contains(parts[2]) && !level1.contains(parts[2]))
				{
					level2.add(parts[2]);
				}
			}

			for(String state : level2)
			{
				if(state.equals(parts[0]) && !level3.contains(parts[2]) && !level2.contains(parts[2]) && !level1.contains(parts[2]))
				{
					level3.add(parts[2]);
				}
			}

			for(String state : level3)
			{
				if(state.equals(parts[0]) && !level4.contains(parts[2]) && !level3.contains(parts[2]) && !level2.contains(parts[2]) && !level1.contains(parts[2]))
				{
					level4.add(parts[2]);
				}
			}

			for(String state : level4)
			{
				if(state.equals(parts[0]) && !level5.contains(parts[2]) && !level4.contains(parts[2]) && !level3.contains(parts[2]) && !level2.contains(parts[2]) && !level1.contains(parts[2]))
				{
					level5.add(parts[2]);
				}
			}

			for(String state : level5)
			{
				if(state.equals(parts[0]) && !level6.contains(parts[2]) && !level5.contains(parts[2]) && !level4.contains(parts[2]) && !level3.contains(parts[2]) && !level2.contains(parts[2]) && !level1.contains(parts[2]))
				{
					level6.add(parts[2]);
				}
			}
		}

		for(String s : level1)
		{
			createCircle(width/2, 200, s, level1Circ, level1Lab);
		}


		for(String s : level2)
		{
			createCircle((level2.indexOf(s) + 1) * (width / (level2.size() + 1)), 300, s, level2Circ, level2Lab);
		}


		for(String s : level3)
		{
			createCircle((level3.indexOf(s) + 1) * (width / (level3.size() + 1)), 400, s, level3Circ, level3Lab);
		}


		for(String s : level4)
		{
			createCircle((level4.indexOf(s) + 1) * (width / (level4.size() + 1)), 500, s, level4Circ, level4Lab);
		}


		for(String s : level5)
		{
			createCircle((level5.indexOf(s) + 1) * (width / (level5.size() + 1)), 600, s, level5Circ, level5Lab);
		}

		for(String s : level6)
		{
			createCircle((level6.indexOf(s) + 1) * (width / (level6.size() + 1)), 700, s, level6Circ, level6Lab);
		}


		for(String arc : arcsListFromFile)
		{
			String[] parts = arc.split(" ");
			String one = parts[0];
			String two = parts[2];
			String line = parts[1];



			if(level1.contains(one))
			{
				int indexOf = level2.indexOf(two);
				int indexOfL1 = level1.indexOf(one);
				if(indexOf > -1 && indexOfL1 > -1)
				{
					Label l = level2Lab.get(indexOf);
					double posXE = l.getLayoutX();
					double posYE = l.getLayoutY();
					Label lab = level1Lab.get(indexOfL1);
					double posXS = lab.getLayoutX();
					double posYS = lab.getLayoutY();
					createLine(posXS, posYS, posXE, posYE, line);

				}
			}

			else if(level2.contains(one))
			{
				int indexOf = level3.indexOf(two);
				int indexOfL1 = level2.indexOf(one);
				if(indexOf > -1 && indexOfL1 > -1)
				{
					Label l = level3Lab.get(indexOf);
					double posXE = l.getLayoutX();
					double posYE = l.getLayoutY();

					Label lab = level2Lab.get(indexOfL1);
					double posXS = lab.getLayoutX();
					double posYS = lab.getLayoutY();
					createLine(posXS, posYS, posXE, posYE, line);
				}

			}

			else if(level3.contains(one))
			{
				int indexOf = level4.indexOf(two);
				int indexOfL1 = level3.indexOf(one);
				if(indexOf > -1 && indexOfL1 > -1)
				{
					Label l = level4Lab.get(indexOf);
					double posXE = l.getLayoutX();
					double posYE = l.getLayoutY();

					Label lab = level3Lab.get(indexOfL1);
					double posXS = lab.getLayoutX();
					double posYS = lab.getLayoutY();
					createLine(posXS, posYS, posXE, posYE, line);
				}

			}

			else if(level4.contains(one))
			{
				int indexOf = level5.indexOf(two);
				int indexOfL1 = level4.indexOf(one);
				if(indexOf > -1 && indexOfL1 > -1)
				{
					Label l = level5Lab.get(indexOf);
					double posXE = l.getLayoutX();
					double posYE = l.getLayoutY();

					Label lab = level4Lab.get(indexOfL1);
					double posXS = lab.getLayoutX();
					double posYS = lab.getLayoutY();
					createLine(posXS, posYS, posXE, posYE, line);
				}

			}

			else if(level5.contains(one))
			{
				int indexOf = level6.indexOf(two);
				int indexOfL1 = level5.indexOf(one);
				if(indexOf > -1 && indexOfL1 > -1)
				{
					Label l = level6Lab.get(indexOf);
					double posXE = l.getLayoutX();
					double posYE = l.getLayoutY();

					Label lab = level5Lab.get(indexOfL1);
					double posXS = lab.getLayoutX();
					double posYS = lab.getLayoutY();
					createLine(posXS, posYS, posXE, posYE, line);
				}

			}

			else if(level6.contains(one))
			{
				int indexOf = level7.indexOf(two);
				int indexOfL1 = level6.indexOf(one);
				if(indexOf > -1 && indexOfL1 > -1)
				{
					Label l = level7Lab.get(indexOf);
					double posXE = l.getLayoutX();
					double posYE = l.getLayoutY();

					Label lab = level6Lab.get(indexOfL1);
					double posXS = lab.getLayoutX();
					double posYS = lab.getLayoutY();
					createLine(posXS, posYS, posXE, posYE, line);
				}

			}

			else if(level7.contains(one))
			{
				int indexOf = level8.indexOf(two);
				int indexOfL1 = level7.indexOf(one);
				if(indexOf > -1 && indexOfL1 > -1)
				{
					Label l = level8Lab.get(indexOf);
					double posXE = l.getLayoutX();
					double posYE = l.getLayoutY();

					Label lab = level7Lab.get(indexOfL1);
					double posXS = lab.getLayoutX();
					double posYS = lab.getLayoutY();
					createLine(posXS, posYS, posXE, posYE, line);
				}

			}
		}


		double levelY = 400;
		for(Node n : mainPane.getChildren())
		{
			if(n.getLayoutY() > levelY) levelY = n.getLayoutY();
		}

		scrollMainPane.setContent(mainPane);
		scrollMainPane.setMinHeight(levelY + 60);
		scrollMainPane.setMaxHeight(levelY + 60);
		mainPane.setMinHeight(levelY + 100);
		mainPane.setMinHeight(levelY + 100);
		this.closeButton.setLayoutY(levelY + 60);

		ObservableList<Node> workingCollection = FXCollections.observableArrayList(mainPane.getChildren());
		Collections.swap(workingCollection, 0, 1);
		mainPane.getChildren().setAll(workingCollection);


	}

	double calculateLength(double startX, double startY, double endX, double endY)
	{
		double l1 = startX > endX ? startX - endX : endX - startX;
		double l2 = startY > endY ? startY - endY : endY - startY;
		double to_return = Math.sqrt(l1*l1 + l2*l2);

		return to_return;

	}

	void createLine(double startX, double startY, double endX, double endY, String text)
	{
		Line l = new Line(startX + 6, startY + 10, endX + 6, endY + 10);
		l.setStrokeWidth(3.0f);
		mainPane.getChildren().add(l);
		l.toBack();


		Text t = new Text(text);
		t.setLayoutX((startX+6 + endX + 12)/2);
		t.setLayoutY((startY + 10 + endY + 55)/2);
		t.setFont(Font.font(14));
		t.setFill(Color.BLUE);
		mainPane.getChildren().add(t);



		double ax1 = startX + 6;
		double ax2 = endX + 6;
		double ay1 = startY + 10;
		double ay2 = endY + 10;

		double arrowAngle = Math.toRadians(8.0);
		double arrowLength = 30.0;
		double dx = ax1 - ax2;
		double dy = ay1 - ay2;
		double angle = Math.atan2(dy, dx);
		double x1 = Math.cos(angle + arrowAngle) * arrowLength + ax2;
		double y1 = Math.sin(angle + arrowAngle) * arrowLength + ay2;

		double x2 = Math.cos(angle - arrowAngle) * arrowLength + ax2;
		double y2 = Math.sin(angle - arrowAngle) * arrowLength + ay2;

		HeadArrow ha = new HeadArrow();
		double myAngle = ha.returnAngle(ax1, ay1, ax2, ay2);
		double myX = ha.calculateX(myAngle) /2;
		double myY = ha.calculateY(myAngle) / 2;

		if(myAngle == 0)
		{
			myX = 0;
		}

		Line left = new Line(ax2 - myX, ay2 - myY, x1 - myX, y1 - myY);
		left.setStrokeWidth(5.0f);
		Line right = new Line(ax2 - myX, ay2 - myY, x2 - myX, y2 - myY);
		right.setStrokeWidth(5.0f);

		mainPane.getChildren().add(left);
		mainPane.getChildren().add(right);

		left.toBack();
		right.toBack();
	}



	void createCircle(double posX, double posY, String text, ObservableList<Circle> cList, ObservableList<Label> lList)
	{
		Circle c = new Circle(posX, posY, 15.0f, Paint.valueOf("#FFFFFF"));
		mainPane.getChildren().add(c);
		Label lab = new Label(text);
		lab.setLayoutX(c.getCenterX() - 6);
		lab.setLayoutY(c.getCenterY() - 10);
		lab.setFont(Font.font(14));
		mainPane.getChildren().add(lab);

		cList.add(c);
		lList.add(lab);
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
