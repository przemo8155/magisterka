package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

	ObservableList<String> level1 = FXCollections.observableArrayList();
	ObservableList<String> level2 = FXCollections.observableArrayList();
	ObservableList<String> level3 = FXCollections.observableArrayList();
	ObservableList<String> level4 = FXCollections.observableArrayList();
	ObservableList<String> level5= FXCollections.observableArrayList();
	ObservableList<String> level6 = FXCollections.observableArrayList();
	ObservableList<String> level7 = FXCollections.observableArrayList();
	ObservableList<String> level8 = FXCollections.observableArrayList();


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
		}

		for(String s : level1)
		{
			createCircle(width/2, 200, s);
			System.out.println("level 1: " + s);
		}

		System.out.println();

		for(String s : level2)
		{
			createCircle((level2.indexOf(s) + 1) * (width / (level2.size() + 1)), 300, s);
			System.out.println("level 2: " + s);
		}

		System.out.println();

		for(String s : level3)
		{
			createCircle((level3.indexOf(s) + 1) * (width / (level3.size() + 1)), 400, s);
			System.out.println("level 3: " + s);
		}

		System.out.println();

		for(String s : level4)
		{
			createCircle((level4.indexOf(s) + 1) * (width / (level4.size() + 1)), 500, s);
			System.out.println("level 4: " + s);
		}

		System.out.println();

		for(String s : level5)
		{
			createCircle((level5.indexOf(s) + 1) * (width / (level5.size() + 1)), 600, s);
			System.out.println("level 5: " + s);
		}


		double levelY = 400;
		for(Node n : mainPane.getChildren())
		{
			if(n.getLayoutY() > levelY) levelY = n.getLayoutY();
		}

		scrollMainPane.setContent(mainPane);
		scrollMainPane.setMinHeight(levelY + 60);
		scrollMainPane.setMaxHeight(levelY + 60);
		mainPane.setMinHeight(levelY + 60);
		mainPane.setMinHeight(levelY + 60);
		this.closeButton.setLayoutY(levelY + 60);


	}

	public void drawTree(TreeNode<String> tree) {

	}

	public static TreeNode<String> getSet1() {
		TreeNode<String> root = new TreeNode<String>("root");
		{
			TreeNode<String> node0 = root.addChild("node0");
			TreeNode<String> node1 = root.addChild("node1");
			TreeNode<String> node2 = root.addChild("node2");
			{
				TreeNode<String> node20 = node2.addChild("node20");
				TreeNode<String> node21 = node2.addChild("node21");
				{
					TreeNode<String> node210 = node21.addChild("node210");
					TreeNode<String> node211 = node21.addChild("node211");
				}
			}
			TreeNode<String> node3 = root.addChild("node3");
			{
				TreeNode<String> node30 = node3.addChild("node30");
			}
		}

		return root;
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
