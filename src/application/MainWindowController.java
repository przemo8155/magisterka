
package application;

//tix

import java.awt.Color;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.javafx.stage.StageHelper;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.*;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.*;

import application.Main;

public class MainWindowController
{

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	static int minusWidth = 95;
	String selectedToggle = "";
	String idObj = "";
	int circleId = 0;

	static int circleRay = 30, squareRay = 40, lineRay = 10;

	double _cSecPosX = 0, _cSecPosY = 0, _cFirstPosX = 0, _cFirstPosY = 0;
	double _rFirstPosX, _rFirstPosY, _rSecPosX, _rSecPosY;
	double _circleLine1, _circleLine2;
	boolean _isCircleFirst = true, _isRectangleFirst = true;

	Utilities utilities = new Utilities();
	FileManager fileManager = new FileManager();
	Main main = new Main();
	LabelTexts labelTexts = new LabelTexts();
	SettingsController settingsController = new SettingsController();

	public String backgroundColor;

	ObservableList<Circle> circleList = FXCollections.observableArrayList();
	ObservableList<Rectangle> squareList = FXCollections.observableArrayList();
	ObservableList<Line> lineList = FXCollections.observableArrayList();

	ObservableList<Line> startLineList = FXCollections.observableArrayList();
	ObservableList<Line> endLineList = FXCollections.observableArrayList();

	ObservableList<Line> moveLineList = FXCollections.observableArrayList();

	@FXML
	private MenuItem openFileMenuItem;

	@FXML
	private MenuItem saveFileMenuItem;

	@FXML
	private MenuItem settingsMenuItem;

	@FXML
	private MenuItem exitMenuItem;

	@FXML
	private MenuItem aboutMenuItem;

	@FXML
	private Button clearAllButton;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	public Pane mainPane;

	@FXML
	private ToggleButton squareToggleButton, circleToggleButton, moveToggleButton, lineToggleButton, removeToggleButton;

	@FXML
	private Label middleLabel;

	@FXML
	Parent root;

	public void setMiddleLabelText(String text)
	{
		middleLabel.setDisable(false);
		middleLabel.setText(text);

		FadeTransition ft = new FadeTransition(Duration.millis(1200), middleLabel);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setAutoReverse(false);
		ft.play();
		middleLabel.setDisable(true);

	}

	EventHandler<MouseEvent> deleteSecondLastLineEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent event)
		{
			if (lineList.size() > 1)
			{
				lineList.remove(lineList.size() - 2);
			}
		}

	};

	EventHandler<MouseEvent> secondPointOfLineEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent event)
		{
			if (_cFirstPosX != 0 && _cFirstPosY != 0)
			{
				if (!moveLineList.isEmpty())
				{
					lineList.removeAll(moveLineList);

					for (Line l : moveLineList)
					{
						mainPane.getChildren().remove(l);
					}

					moveLineList.clear();
				}

				Line l = new Line(_cFirstPosX, _cFirstPosY, event.getScreenX(), event.getSceneY() - minusWidth);
				l.setStroke(Paint.valueOf("#ABCDEF"));
				l.setStrokeWidth(10.0f);
				mainPane.getChildren().add(l);
				lineList.add(l);

				moveLineList.add(l);

			}

		}
	};

	EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY() - minusWidth;
			orgTranslateX = ((Circle) (t.getSource())).getTranslateX();
			orgTranslateY = ((Circle) (t.getSource())).getTranslateY();

		}

	};

	EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			try
			{
				Circle c = ((Circle) t.getSource());
				int index = circleList.indexOf(c);

				for (Line l : lineList)
				{
					if (l.getStartX() == c.getCenterX() && l.getStartY() == c.getCenterY())
					{
						startLineList.add(l);
					}
				}

				lineList.removeAll(startLineList);

				for (Line l : lineList)
				{
					if (l.getEndX() == c.getCenterX() && l.getEndY() == c.getCenterY())
					{
						endLineList.add(l);
					}
				}

				lineList.removeAll(endLineList);

				double offsetX = t.getSceneX();
				double offsetY = t.getSceneY() - minusWidth;

				double newTranslateX = orgTranslateX + offsetX;
				double newTranslateY = orgTranslateY + offsetY;

				c.setCenterX(newTranslateX);
				c.setCenterY(newTranslateY);

				circleList.set(index, c);

				for (Line l : endLineList)
				{
					l.setEndX(c.getCenterX());
					l.setEndY(c.getCenterY());
				}

				for (Line l : startLineList)
				{
					l.setStartX(c.getCenterX());
					l.setStartY(c.getCenterY());
				}

				lineList.addAll(endLineList);
				lineList.addAll(startLineList);
				utilities.clearStartAndEndLineLists(startLineList, endLineList);

			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	};

	EventHandler<MouseEvent> squareOnMousePressedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Rectangle) (t.getSource())).getX();
			orgTranslateY = ((Rectangle) (t.getSource())).getY();
		}
	};

	EventHandler<MouseEvent> squareOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			try
			{
				Rectangle r = ((Rectangle) t.getSource());
				int index = squareList.indexOf(r);

				for (Line l : lineList)
				{
					if (l.getStartX() - 20 == r.getX() && l.getStartY() - 20 == r.getY())
					{
						startLineList.add(l);
					}
				}

				lineList.removeAll(startLineList);

				for (Line l : lineList)
				{
					if (l.getEndX() - 20 == r.getX() && l.getEndY() - 20 == r.getY())
					{
						endLineList.add(l);
					}
				}

				lineList.removeAll(endLineList);

				double offsetX = t.getSceneX() - orgSceneX;
				double offsetY = t.getSceneY() - orgSceneY;
				double newTranslateX = orgTranslateX + offsetX;
				double newTranslateY = orgTranslateY + offsetY;

				r.setX(newTranslateX);
				r.setY(newTranslateY);

				squareList.set(index, r);

				for (Line l : endLineList)
				{
					l.setEndX(r.getX() + 20);
					l.setEndY(r.getY() + 20);
				}

				for (Line l : startLineList)
				{
					l.setStartX(r.getX() + 20);
					l.setStartY(r.getY() + 20);
				}

				lineList.addAll(endLineList);
				lineList.addAll(startLineList);
				utilities.clearStartAndEndLineLists(startLineList, endLineList);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	};

	@FXML
	void anchorPane_OnMouseClicked(MouseEvent event)
	{

	}

	@FXML
	void mainPane_OnMouseClicked(MouseEvent event)
	{
		switch (selectedToggle)
		{

			case "remove":
				if (event.getSceneY() > minusWidth + 10)
				{
					double x = event.getSceneX();
					double y = event.getSceneY();
					for (Circle myCircle : circleList)
					{
						if ((x > myCircle.getCenterX() - circleRay) && (x < myCircle.getCenterX() + circleRay)
								&& (y > myCircle.getCenterY() - circleRay + minusWidth)
								&& (y < myCircle.getCenterY() + circleRay + minusWidth))
						{

							for (Line l : lineList)
							{
								if (l.getStartX() == myCircle.getCenterX() && l.getStartY() == myCircle.getCenterY())
								{
									startLineList.add(l);
								}
							}

							for (Line l : lineList)
							{
								if (l.getEndX() == myCircle.getCenterX() && l.getEndY() == myCircle.getCenterY())
								{
									endLineList.add(l);
								}
							}

							if (!startLineList.isEmpty())
							{
								lineList.removeAll(startLineList);
								for (Line l : startLineList)
								{
									mainPane.getChildren().remove(l);
								}
							}

							if (!endLineList.isEmpty())
							{
								lineList.removeAll(endLineList);
								for (Line l : endLineList)
								{
									mainPane.getChildren().remove(l);
								}

							}

							circleList.remove(myCircle);
							mainPane.getChildren().remove(myCircle);

							setMiddleLabelText("Circle removed...");
							utilities.clearStartAndEndLineLists(startLineList, endLineList);
							break;
						}
					}

					for (Rectangle myRectangle : squareList)
					{
						if ((x > myRectangle.getX() + 20 - squareRay) && (x < myRectangle.getX() + 20 + squareRay)
								&& (y > myRectangle.getY() + 20 - squareRay + minusWidth)
								&& (y < myRectangle.getY() + 20 + squareRay + minusWidth))
						{

							for (Line l : lineList)
							{
								if (l.getStartX() == myRectangle.getX() + 20
										&& l.getStartY() == myRectangle.getY() + 20)
								{
									startLineList.add(l);
								}
							}

							for (Line l : lineList)
							{
								if (l.getEndX() == myRectangle.getX() + 20 && l.getEndY() == myRectangle.getY() + 20)
								{
									endLineList.add(l);
								}
							}

							if (!startLineList.isEmpty())
							{
								lineList.removeAll(startLineList);
								for (Line l : startLineList)
								{
									mainPane.getChildren().remove(l);
								}
							}

							if (!endLineList.isEmpty())
							{
								lineList.removeAll(endLineList);
								for (Line l : endLineList)
								{
									mainPane.getChildren().remove(l);
								}

							}

							squareList.remove(myRectangle);
							mainPane.getChildren().remove(myRectangle);

							setMiddleLabelText("Rectangle removed...");
							utilities.clearStartAndEndLineLists(startLineList, endLineList);
							break;
						}
					}

				}
				break;
			case "circle":
				if (event.getSceneY() > minusWidth + 10)
				{
					Circle c = new Circle(event.getSceneX(), event.getSceneY() - minusWidth, 20.0f,
							Paint.valueOf("#923456"));
					c.setStroke(Paint.valueOf("#555555"));
					c.setStrokeWidth(5.0f);
					mainPane.getChildren().add(c);
					c.setOnMousePressed(circleOnMousePressedEventHandler);
					setMiddleLabelText("Circle created...");
					circleList.add(c);
				}
				break;

			case "square":
				if (event.getSceneY() > minusWidth + 10)
				{
					Rectangle r = new Rectangle(event.getSceneX() - 20, event.getSceneY() - minusWidth - 20, 40.0f,
							40.0f);
					r.setFill(Paint.valueOf("#ABCDEF"));
					r.setStroke(Paint.valueOf("#555555"));
					r.setStrokeWidth(5.0f);
					mainPane.getChildren().add(r);
					r.setOnMousePressed(squareOnMousePressedEventHandler);
					setMiddleLabelText("Rectangle created...");
					squareList.add(r);
				}
				break;

			case "line":
				if (event.getSceneY() > minusWidth + 10)
				{
					double x = event.getSceneX();
					double y = event.getSceneY();

					boolean goIntoRectangle = false;
					boolean goIntoCircle = false;

					for (Circle myCircle : circleList)
					{
						if ((x > myCircle.getCenterX() - circleRay) && (x < myCircle.getCenterX() + circleRay)
								&& (y > myCircle.getCenterY() - circleRay + minusWidth)
								&& (y < myCircle.getCenterY() + circleRay + minusWidth))
						{
							if (_cFirstPosX == 0 && _cFirstPosY == 0 && !goIntoCircle)
							{
								_cFirstPosX = myCircle.getCenterX();
								_cFirstPosY = myCircle.getCenterY();
								setMiddleLabelText("First point of line...");
								goIntoRectangle = true;
								mainPane.setOnMouseMoved(secondPointOfLineEventHandler);
								break;
							}

							if (_cFirstPosX != 0 && _cFirstPosY != 0)
							{
								_cSecPosX = myCircle.getCenterX();
								_cSecPosY = myCircle.getCenterY();
								Line l = new Line(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY);
								l.setStroke(Paint.valueOf("#ABCDEF"));
								l.setStrokeWidth(10.0f);
								mainPane.getChildren().add(l);
								lineList.add(l);
								setMiddleLabelText("Second point of line...");
								_cFirstPosX = 0;
								_cFirstPosY = 0;
								_cSecPosX = 0;
								_cSecPosY = 0;
								goIntoRectangle = false;
								break;
							}
						}
					}

					for (Rectangle myRectangle : squareList)
					{
						if ((x > myRectangle.getX() + 20 - squareRay) && (x < myRectangle.getX() + 20 + squareRay)
								&& (y > myRectangle.getY() + 20 - squareRay + minusWidth)
								&& (y < myRectangle.getY() + 20 + squareRay + minusWidth))
						{
							if (_cFirstPosX == 0 && _cFirstPosY == 0 && !goIntoRectangle)
							{
								_cFirstPosX = myRectangle.getX() + 20;
								_cFirstPosY = myRectangle.getY() + 20;
								setMiddleLabelText("First point of line...");
								goIntoCircle = true;
								mainPane.setOnMouseMoved(secondPointOfLineEventHandler);
								break;
							}

							if (_cFirstPosX != 0 && _cFirstPosY != 0)
							{
								_cSecPosX = myRectangle.getX() + 20;
								_cSecPosY = myRectangle.getY() + 20;
								Line l = new Line(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY);
								l.setStroke(Paint.valueOf("#ABCDEF"));
								l.setStrokeWidth(10.0f);
								mainPane.getChildren().add(l);
								lineList.add(l);
								setMiddleLabelText("Second point of line...");
								_cFirstPosX = 0;
								_cFirstPosY = 0;
								_cSecPosX = 0;
								_cSecPosY = 0;
								goIntoCircle = false;
								break;
							}
						}
					}
				}

		}
	}

	@FXML
	void mainPane_OnMouseDragged(MouseEvent event)
	{
		switch (selectedToggle)
		{
			case "move":
				int _it = 0;
				while (_it < utilities.takeMaximumFromLists(circleList, squareList, lineList))
				{
					try
					{
						Object g = mainPane.getChildren().get(_it);
						if (g instanceof Circle)
						{
							((Circle) g).setOnMousePressed(circleOnMousePressedEventHandler);
							((Circle) g).setOnMouseDragged(circleOnMouseDraggedEventHandler);

						}

						if (g instanceof Rectangle)
						{
							((Rectangle) g).setOnMousePressed(squareOnMousePressedEventHandler);
							((Rectangle) g).setOnMouseDragged(squareOnMouseDraggedEventHandler);
						}

						_it += 1;
					} catch (Exception e)
					{
						e.getMessage();
					}

				}

				break;
		}
	}

	public void initialize()
	{

		// backgroundColor = settingsController.getBackgroundColorLabel();
		// mainPane.setStyle("-fx-background-color: " + backgroundColor);
		mainPane.setStyle("-fx-background-color: #FFFFFF");

		middleLabel.setDisable(true);

		saveFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		openFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

		utilities.clearAllLists(circleList, squareList, lineList);

		final ToggleGroup toggleButtonsGroup = new ToggleGroup();
		circleToggleButton.setToggleGroup(toggleButtonsGroup);
		squareToggleButton.setToggleGroup(toggleButtonsGroup);
		moveToggleButton.setToggleGroup(toggleButtonsGroup);
		lineToggleButton.setToggleGroup(toggleButtonsGroup);
		removeToggleButton.setToggleGroup(toggleButtonsGroup);

		circleToggleButton.setUserData("circle");
		squareToggleButton.setUserData("square");
		moveToggleButton.setUserData("move");
		lineToggleButton.setUserData("line");
		removeToggleButton.setUserData("remove");

		toggleButtonsGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
		{

			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle)
			{
				if (new_toggle == null)
					selectedToggle = "null";
				else
				{
					selectedToggle = (String) toggleButtonsGroup.getSelectedToggle().getUserData();
					if (selectedToggle == "circle")
						setMiddleLabelText("Drawing circles...");
					else if (selectedToggle == "square")
						setMiddleLabelText("Drawing squares...");
					else if (selectedToggle == "line")
						setMiddleLabelText("Drawing lines...");
					else if (selectedToggle == "move")
						setMiddleLabelText("Moving objects...");
					else if (selectedToggle == "remove")
						setMiddleLabelText("Removing objects...");
				}

			}
		});

	}

	@FXML
	void exitMenuItem_OnAction(ActionEvent event)
	{
		Utilities.exitFromApplication();
	}

	@FXML
	void settingsMenuItem_OnAction(ActionEvent event)
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Settings.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 300, 300);
			scene.getStylesheets().add(getClass().getResource("settings.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Settings");
			stage.setScene(scene);
			stage.getIcons()
					.add(new Image(MainWindowController.class.getResourceAsStream("resources/settings-icon.png")));
			stage.show();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public enum StageFactory
	{
		INSTANCE;

		private final ObservableList<Stage> openStages = FXCollections.observableArrayList();

		public ObservableList<Stage> getOpenStages()
		{
			return openStages;
		}

		private final ObjectProperty<Stage> currentStage = new SimpleObjectProperty<>(null);

		public final ObjectProperty<Stage> currentStageProperty()
		{
			return this.currentStage;
		}

		public final javafx.stage.Stage getCurrentStage()
		{
			return this.currentStageProperty().get();
		}

		public final void setCurrentStage(final javafx.stage.Stage currentStage)
		{
			this.currentStageProperty().set(currentStage);
		}

		public void registerStage(Stage stage)
		{
			stage.addEventHandler(WindowEvent.WINDOW_SHOWN, e -> openStages.add(stage));
			stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, e -> openStages.remove(stage));
			stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) ->
			{
				if (isNowFocused)
				{
					currentStage.set(stage);
				} else
				{
					currentStage.set(null);
				}
			});
		}

		public Stage createStage()
		{
			Stage stage = new Stage();
			registerStage(stage);
			return stage;
		}

	}

	@FXML
	void saveFileMenuItem_OnAction(ActionEvent event)
	{
		Stage s = Main.getPrimaryStage();
		fileManager.SaveFile(s, circleList, squareList, lineList);
		Boolean fileSaved = fileManager.getSomethingSaved();
		if (fileSaved)
		{
			setMiddleLabelText("File saved...");

		}
	}

	@FXML
	void openFileMenuItem_OnAction(ActionEvent event)
	{

		for (Circle c : circleList)
		{
			mainPane.getChildren().remove(c);
		}

		for (Rectangle r : squareList)
		{
			mainPane.getChildren().remove(r);
		}

		for (Line l : lineList)
		{
			mainPane.getChildren().remove(l);
		}
		utilities.clearAllLists(circleList, squareList, lineList);

		Stage s = Main.getPrimaryStage();
		circleList.clear();
		squareList.clear();
		fileManager.OpenFile(s, circleList, squareList, lineList);

		for (Circle c : circleList)
		{
			mainPane.getChildren().add(c);
			c.setOnMousePressed(circleOnMousePressedEventHandler);
			c.setOnMouseDragged(circleOnMouseDraggedEventHandler);
		}

		for (Rectangle r : squareList)
		{
			mainPane.getChildren().add(r);
			r.setOnMousePressed(squareOnMousePressedEventHandler);
			r.setOnMouseDragged(squareOnMouseDraggedEventHandler);
		}

		for (Line l : lineList)
		{
			mainPane.getChildren().add(l);
		}

		Boolean fileOpened = fileManager.getSomethingOpened();
		if (fileOpened)
		{
			setMiddleLabelText("File opened...");

		}

	}

	@FXML
	void clearAllButton_OnMouseClicked(MouseEvent event)
	{
		utilities.clearUpMessage(mainPane, "Question", "Clear all elements", "Are you sure?", circleList, squareList,
				lineList);
		if (utilities.checkCleared)
		{
			setMiddleLabelText("Cleared...");
		} else
		{
			setMiddleLabelText("");
		}
	}

	@FXML
	void mainPane_OnDragDropped(MouseEvent event)
	{
		// nic
	}

	@FXML
	void mainPane_OnMouseReseased(MouseEvent event)
	{
		// nic

	}

	@FXML
	void aboutMenuItem_OnAction(ActionEvent event)
	{
		try
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About Box");
			alert.setHeaderText("Using Chernikova's Algorithm");
			alert.setContentText("You have actions to execute:\n" + "1. Create circle\n" + "You can create a circle\n\n"
					+ "2. Create rectangle\n" + "You can create a rectangle\n\n" + "3. Create line\n"
					+ "You can create a line\n\n" + "4. Move\n" + "You can move a created object\n\n"
					+ "5. Delete object\n" + "You can delete a created object\n\n" + "6. Clear all\n"
					+ "You can clear all lists and all visible objects\n");

			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(this.getClass().getResource("resources/yellowbulb.jpg").toString()));
			alert.show();
		} catch (Exception e)
		{
			e.fillInStackTrace();
		}
	}

}