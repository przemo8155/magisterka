package application;

import java.awt.Color;
import java.awt.List;
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
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.*;

import application.Main;

public class MainWindowController {

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	static int minusWidth = 95;
	String selectedToggle = "";
	String idObj = "";
	int circleId = 0;

	static int circleRay = 30, squareRay = 200, lineRay = 10;

	double _secPosX, _secPosY, _firstPosX, _firstPosY;
	boolean _isCircleFirst = true, _isRectangleFirst = true;

	Utilities utilities = new Utilities();
	FileManager fileManager = new FileManager();
	Main main = new Main();
	LabelTexts labelTexts = new LabelTexts();

	ObservableList<Circle> circleList = FXCollections.observableArrayList();
	ObservableList<Rectangle> squareList = FXCollections.observableArrayList();
	ObservableList<Line> lineList = FXCollections.observableArrayList();

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
	private ToggleButton squareToggleButton, circleToggleButton, moveToggleButton, lineToggleButton;

	@FXML
	private Label middleLabel;

	@FXML
	Parent root;

	public void setMiddleLabelText(String text) {
		middleLabel.setDisable(false);
		middleLabel.setText(text);

		FadeTransition ft = new FadeTransition(Duration.millis(1500), middleLabel);
	     ft.setFromValue(1.0);
	     ft.setToValue(0.0);
	     ft.setAutoReverse(false);
	     ft.play();
	     middleLabel.setDisable(true);


	}

	EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY() - minusWidth;
			orgTranslateX = ((Circle) (t.getSource())).getTranslateX();
			orgTranslateY = ((Circle) (t.getSource())).getTranslateY();
		}
	};

	EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY - minusWidth;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Circle) (t.getSource())).setTranslateX(newTranslateX);
			((Circle) (t.getSource())).setTranslateY(newTranslateY);
		}
	};

	EventHandler<MouseEvent> squareOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Rectangle) (t.getSource())).getTranslateX();
			orgTranslateY = ((Rectangle) (t.getSource())).getTranslateY();
		}
	};

	EventHandler<MouseEvent> squareOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Rectangle) (t.getSource())).setTranslateX(newTranslateX);
			((Rectangle) (t.getSource())).setTranslateY(newTranslateY);
		}
	};

	EventHandler<MouseEvent> myHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			if (event.getSource() instanceof Circle) {

				Circle circle = ((Circle) (event.getSource()));
				circleId = mainPane.getChildren().indexOf(circle);
			} else {

				Node node = ((Node) (event.getSource()));

			}

		}
	};

	@FXML
	void anchorPane_OnMouseClicked(MouseEvent event) {

	}

	@FXML
	void mainPane_OnMouseClicked(MouseEvent event) {
		switch (selectedToggle) {
		case "circle":
			Circle c = new Circle(event.getSceneX(), event.getSceneY() - minusWidth, 20.0f, Paint.valueOf("#923456"));
			c.setStroke(Paint.valueOf("#555555"));
			c.setStrokeWidth(5.0f);
			mainPane.getChildren().add(c);
			c.setOnMousePressed(circleOnMousePressedEventHandler);
			circleList.add(c);
			break;

		case "square":
			Rectangle r = new Rectangle(event.getSceneX() - 20, event.getSceneY() - minusWidth - 20, 40.0f, 40.0f);
			r.setFill(Paint.valueOf("#ABCDEF"));
			r.setStroke(Paint.valueOf("#555555"));
			r.setStrokeWidth(5.0f);
			mainPane.getChildren().add(r);
			r.setOnMousePressed(squareOnMousePressedEventHandler);
			squareList.add(r);
			break;

		case "line":
			if (_isCircleFirst) {
				int _it = 0;
				while (_it < utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
					try {
						// utilities.infoBox(Integer.toString(_it));
						Object g = mainPane.getChildren().get(_it);
						if (g instanceof Circle) {

							Circle check1 = circleList.get(_it);

							double _c1 = check1.getCenterX();
							double _c2 = check1.getCenterY();

							double _x = event.getSceneX();
							double _y = event.getSceneY() - minusWidth;

							if ((_x > _c1 - circleRay) && (_x < _c1 + circleRay) && (_y > _c2 - circleRay)
									&& (_y < _c2 + circleRay)) {
								Circle check2 = ((Circle) g);
								_firstPosX = ((Circle) g).getCenterX();
								_firstPosY = ((Circle) g).getCenterY();
								_isCircleFirst = false;
								break;
							}
							_it += 1;

						}

						else {
							// utilities.infoBox("rectangle 1");
							Rectangle check1 = squareList.get(_it);

							double _c1 = check1.getLayoutX();
							double _c2 = check1.getLayoutY();

							double _x = event.getSceneX() - 20;
							double _y = event.getSceneY() - minusWidth - 20;

							if ((_x > _c1 - squareRay) && (_y < _c2 + squareRay)) {
								_firstPosX = ((Rectangle) g).getX();
								_firstPosY = ((Rectangle) g).getY();
								_isCircleFirst = false;
								break;
							}
							_it += 1;
						}

					} catch (Exception e) {
						e.getMessage();
					}

				}

			} else {
				int _it = 0;
				while (_it < utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
					try {
						// utilities.infoBox(Integer.toString(_it));
						Object g = mainPane.getChildren().get(_it);
						if (g instanceof Circle) {
							Circle check1 = circleList.get(_it);

							double _c1 = check1.getCenterX();
							double _c2 = check1.getCenterY();

							double _x = event.getSceneX();
							double _y = event.getSceneY() - minusWidth;

							if ((_x > _c1 - circleRay) && (_x < _c1 + circleRay) && (_y < _c2 + circleRay)
									&& (_y > _c2 - circleRay)) {
								_secPosX = ((Circle) g).getCenterX();
								_secPosY = ((Circle) g).getCenterY();
								Line l = new Line(_firstPosX, _firstPosY, _secPosX, _secPosY);
								l.setStroke(Paint.valueOf("#ABCDEF"));
								l.setStrokeWidth(10.0f);
								mainPane.getChildren().add(l);
								lineList.add(l);
								_isCircleFirst = true;
								break;

							}
							_it += 1;

						}

						else {
							// utilities.infoBox("rectangle 2");
							Rectangle check1 = squareList.get(_it);

							double _c1 = check1.getLayoutX();
							double _c2 = check1.getLayoutY();

							double _x = event.getSceneX();
							double _y = event.getSceneY() - minusWidth;

							if ((_x > _c1 - squareRay) && (_y < _c2 + squareRay)) {
								_secPosX = ((Rectangle) g).getX();
								_secPosY = ((Rectangle) g).getY();
								Line l = new Line(_firstPosX, _firstPosY, _secPosX, _secPosY);
								l.setStroke(Paint.valueOf("#ABCDEF"));
								l.setStrokeWidth(10.0f);
								mainPane.getChildren().add(l);
								lineList.add(l);
								_isCircleFirst = true;
								break;

							}
							_it += 1;
						}


					} catch (Exception e) {
						e.getMessage();
					}
				}

			}

		}
	}

	public void waitOnSecClick(MouseEvent e) {
		_secPosX = e.getSceneX();
		_secPosY = e.getSceneY();
	}

	@FXML
	void mainPane_OnMouseDragged(MouseEvent event) {
		switch (selectedToggle) {
		case "move":
			int _it = 0;
			while (_it < utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
				try {
					Object g = mainPane.getChildren().get(_it);
					if (g instanceof Circle) {
						double _lineStartX = 0, _lineStartY = 0, _lineEndX = 0, _lineEndY = 0;
						boolean start = true;

						if(!lineList.isEmpty()){
							for (Line l : lineList) {
								double _t1 = ((Circle) g).getCenterX();
								double _t2 = ((Circle) g).getCenterY();

								if (l.getStartX() == _t1 && l.getStartY() == _t2) {
									_lineEndX = l.getEndX();
									_lineEndY = l.getEndY();
									((Circle) g).setOnMousePressed(circleOnMousePressedEventHandler);
									((Circle) g).setOnMouseDragged(circleOnMouseDraggedEventHandler);
									double _t3 = ((Circle) g).getCenterX();
									double _t4 = ((Circle) g).getCenterY();
									_lineStartX = _t3;
									_lineStartY = _t4;
									Line _l = new Line(_lineStartX, _lineStartY, _lineEndX, _lineEndY);
									_l.setStroke(Paint.valueOf("#ABCDEF"));
									_l.setStrokeWidth(10.0f);
									mainPane.getChildren().add(_l);


								}
								if (l.getEndX() == _t1 && l.getEndY() == _t2) {
									_lineStartX = l.getStartX();
									_lineStartY = l.getStartY();
									((Circle) g).setOnMousePressed(circleOnMousePressedEventHandler);
									((Circle) g).setOnMouseDragged(circleOnMouseDraggedEventHandler);
									double _t3 = ((Circle) g).getCenterX();
									double _t4 = ((Circle) g).getCenterY();
									_lineEndX = _t3;
									_lineEndY = _t4;
									Line _l = new Line(_lineStartX, _lineStartY, _lineEndX, _lineEndY);
									_l.setStroke(Paint.valueOf("#ABCDEF"));
									_l.setStrokeWidth(10.0f);
									mainPane.getChildren().add(_l);
								}
							}
						}

						else{
							((Circle) g).setOnMousePressed(circleOnMousePressedEventHandler);
							((Circle) g).setOnMouseDragged(circleOnMouseDraggedEventHandler);
						}




					}

					if (g instanceof Rectangle) {
						((Rectangle) g).setOnMousePressed(squareOnMousePressedEventHandler);
						((Rectangle) g).setOnMouseDragged(squareOnMouseDraggedEventHandler);
					}

					_it += 1;
				} catch (Exception e) {
					e.getMessage();
				}

			}

			break;
		}
	}

	public void initialize() {

		mainPane.setStyle("-fx-background-color: #FFFFFF");

		middleLabel.setDisable(true);

		final ToggleGroup toggleButtonsGroup = new ToggleGroup();
		circleToggleButton.setToggleGroup(toggleButtonsGroup);
		squareToggleButton.setToggleGroup(toggleButtonsGroup);
		moveToggleButton.setToggleGroup(toggleButtonsGroup);
		lineToggleButton.setToggleGroup(toggleButtonsGroup);

		circleToggleButton.setUserData("circle");
		squareToggleButton.setUserData("square");
		moveToggleButton.setUserData("move");
		lineToggleButton.setUserData("line");

		toggleButtonsGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
				if (new_toggle == null)
					selectedToggle = "null";
				else{
					selectedToggle = (String) toggleButtonsGroup.getSelectedToggle().getUserData();
					if(selectedToggle == "circle")setMiddleLabelText("Drawing circles...");
					else if(selectedToggle == "square")setMiddleLabelText("Drawing squares...");
					else if(selectedToggle == "line")setMiddleLabelText("Drawing lines...");
					else if(selectedToggle == "move")setMiddleLabelText("Moving...");
				}

			}
		});

	}

	@FXML
	void exitMenuItem_OnAction(ActionEvent event) {
		Utilities.exitFromApplication();
	}

	@FXML
	void settingsMenuItem_OnAction(ActionEvent event) {
		try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public enum StageFactory {
		INSTANCE;

		private final ObservableList<Stage> openStages = FXCollections.observableArrayList();

		public ObservableList<Stage> getOpenStages() {
			return openStages;
		}

		private final ObjectProperty<Stage> currentStage = new SimpleObjectProperty<>(null);

		public final ObjectProperty<Stage> currentStageProperty() {
			return this.currentStage;
		}

		public final javafx.stage.Stage getCurrentStage() {
			return this.currentStageProperty().get();
		}

		public final void setCurrentStage(final javafx.stage.Stage currentStage) {
			this.currentStageProperty().set(currentStage);
		}

		public void registerStage(Stage stage) {
			stage.addEventHandler(WindowEvent.WINDOW_SHOWN, e -> openStages.add(stage));
			stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, e -> openStages.remove(stage));
			stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
				if (isNowFocused) {
					currentStage.set(stage);
				} else {
					currentStage.set(null);
				}
			});
		}

		public Stage createStage() {
			Stage stage = new Stage();
			registerStage(stage);
			return stage;
		}

	}

	@FXML
	void saveFileMenuItem_OnAction(ActionEvent event) {
		Stage s = Main.getPrimaryStage();
		fileManager.SaveFile(s, circleList, squareList, lineList);
		setMiddleLabelText("File saved...");
	}

	@FXML
	void openFileMenuItem_OnAction(ActionEvent event) {
		Stage s = Main.getPrimaryStage();
		circleList.clear();
		squareList.clear();
		fileManager.OpenFile(s, circleList, squareList, lineList);
		for (Circle c : circleList) {
			mainPane.getChildren().add(c);
			c.setOnMousePressed(circleOnMousePressedEventHandler);
			c.setOnMouseDragged(circleOnMouseDraggedEventHandler);
		}

		for (Rectangle r : squareList) {
			mainPane.getChildren().add(r);
			r.setOnMousePressed(squareOnMousePressedEventHandler);
			r.setOnMouseDragged(squareOnMouseDraggedEventHandler);
		}

		for (Line l : lineList) {
			mainPane.getChildren().add(l);
		}

		setMiddleLabelText("File opened...");

	}

	@FXML
	void clearAllButton_OnMouseClicked(MouseEvent event) {
		utilities.clearUpMessage(mainPane, "Question", "Clear all elements", "Are you sure?", circleList, squareList,
				lineList);
		if (utilities.checkCleared) {
			setMiddleLabelText("Cleared...");
		} else {
			setMiddleLabelText("");
		}
	}

}