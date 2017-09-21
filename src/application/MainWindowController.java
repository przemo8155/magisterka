package application;

//tix

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
import javafx.scene.input.DragEvent;
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

public class MainWindowController {

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	static int minusWidth = 95;
	String selectedToggle = "";
	String idObj = "";
	int circleId = 0;

	static int circleRay = 30, squareRay = 40, lineRay = 10;

	double _cSecPosX, _cSecPosY, _cFirstPosX, _cFirstPosY;
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

	public void setMiddleLabelText(String text) {
		middleLabel.setDisable(false);
		middleLabel.setText(text);

		FadeTransition ft = new FadeTransition(Duration.millis(1200), middleLabel);
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
			try {
				Circle c = ((Circle) t.getSource());
				int index = circleList.indexOf(c);

				for (Line l : lineList) {
					if (l.getStartX() == c.getCenterX() && l.getStartY() == c.getCenterY()) {
						startLineList.add(l);
					}
				}

				lineList.removeAll(startLineList);

				for (Line l : lineList){
					if (l.getEndX() == c.getCenterX() && l.getEndY() == c.getCenterY()) {
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

				for (Line l : endLineList) {
					l.setEndX(c.getCenterX());
					l.setEndY(c.getCenterY());
				}

				for (Line l : startLineList) {
					l.setStartX(c.getCenterX());
					l.setStartY(c.getCenterY());
				}

				lineList.addAll(endLineList);
				lineList.addAll(startLineList);
				utilities.clearStartAndEndLineLists(startLineList, endLineList);

			} catch (Exception e) {
				e.printStackTrace();
			}


		}
	};

	EventHandler<MouseEvent> squareOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Rectangle) (t.getSource())).getX();
			orgTranslateY = ((Rectangle) (t.getSource())).getY();
		}
	};

	EventHandler<MouseEvent> squareOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			try {
				Rectangle r = ((Rectangle) t.getSource());
				int index = squareList.indexOf(r);

				for (Line l : lineList) {
					if (l.getStartX() - 20 == r.getX() && l.getStartY() - 20 == r.getY()) {
						startLineList.add(l);
					}
				}

				lineList.removeAll(startLineList);

				for (Line l : lineList){
					if (l.getEndX() - 20 == r.getX() && l.getEndY() - 20 == r.getY()) {
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

				for (Line l : endLineList) {
					l.setEndX(r.getX() + 20);
					l.setEndY(r.getY() + 20);
				}

				for (Line l : startLineList) {
					l.setStartX(r.getX() + 20);
					l.setStartY(r.getY() + 20);
				}

				lineList.addAll(endLineList);
				lineList.addAll(startLineList);
				utilities.clearStartAndEndLineLists(startLineList, endLineList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	@FXML
	void anchorPane_OnMouseClicked(MouseEvent event) {

	}

	@FXML
	void mainPane_OnMouseClicked(MouseEvent event) {
		switch (selectedToggle) {

		case "remove":
				int _it3 = 0;
				while (_it3 <= utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
					try {
						if (event.getSceneY() > minusWidth + 10 && event.getSceneY() > 10) {
							Object g = mainPane.getChildren().get(_it3);

							if(g instanceof Circle){
								Circle check1 = circleList.get(_it3);

								double _c1 = check1.getCenterX();
								double _c2 = check1.getCenterY();


								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;

								if ((_x > _c1 - circleRay) && (_x < _c1 + circleRay) && (_y > _c2 - circleRay)
										&& (_y < _c2 + circleRay) && (_y > minusWidth)) {
									circleList.remove(check1);
									mainPane.getChildren().remove(check1);
									break;
								}
							}


							else if (g instanceof Rectangle) {
								Rectangle check1 = squareList.get(_it3);

								double _c1 = check1.getX() + 20;
								double _c2 = check1.getY() + 20;

								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;

								if ((_x > _c1 - squareRay) && (_x < _c1 + squareRay) && (_y > _c2 - squareRay)
										&& (_y < _c2 + squareRay) && (_y > minusWidth)) {
									squareList.remove(check1);
									mainPane.getChildren().remove(check1);
									break;
								}
							}
							_it3 += 1;
						}
					}catch(Exception e){
						e.fillInStackTrace();
					}
				}

			break;

		case "circle":
			if (event.getSceneY() > minusWidth + 10) {
				Circle c = new Circle(event.getSceneX(), event.getSceneY() - minusWidth, 20.0f,
				Paint.valueOf("#923456"));
				c.setStroke(Paint.valueOf("#555555"));
				c.setStrokeWidth(5.0f);
				mainPane.getChildren().add(c);
				c.setOnMousePressed(circleOnMousePressedEventHandler);
				circleList.add(c);
			}
			break;

		case "square":
			if (event.getSceneY() > minusWidth + 10) {
				Rectangle r = new Rectangle(event.getSceneX() - 20, event.getSceneY() - minusWidth - 20, 40.0f, 40.0f);
				r.setFill(Paint.valueOf("#ABCDEF"));
				r.setStroke(Paint.valueOf("#555555"));
				r.setStrokeWidth(5.0f);
				mainPane.getChildren().add(r);
				r.setOnMousePressed(squareOnMousePressedEventHandler);
				squareList.add(r);
			}
			break;

		case "line":
			if (_isCircleFirst) {
				int _it = 0;
				while (_it <= utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
					try {
						if (event.getSceneY() > minusWidth + 10 && event.getSceneY() > 10) {
							Object g = mainPane.getChildren().get(_it);

							if (g instanceof Circle) {
								Circle check1 = circleList.get(_it);

								double _c1 = check1.getCenterX();
								double _c2 = check1.getCenterY();

								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;

								if ((_x > _c1 - circleRay) && (_x < _c1 + circleRay) && (_y > _c2 - circleRay)
										&& (_y < _c2 + circleRay) && (_y > minusWidth)) {
									_cFirstPosX = ((Circle) g).getCenterX();
									_cFirstPosY = ((Circle) g).getCenterY();
									_isCircleFirst = false;
									_it = 0;
									setMiddleLabelText("First point of line...");
									break;
								}
								_it += 1;

							}

							else if (g instanceof Rectangle) {
								Rectangle check1 = squareList.get(_it);

								double _c1 = check1.getX() + 20;
								double _c2 = check1.getY() + 20;

								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;

								if ((_x > _c1 - squareRay) && (_x < _c1 + squareRay) && (_y > _c2 - squareRay)
										&& (_y < _c2 + squareRay) && (_y > minusWidth)) {
									_cFirstPosX = ((Rectangle) g).getX() + 20;
									_cFirstPosY = ((Rectangle) g).getY() + 20;
									_isCircleFirst = false;
									_it = 0;
									setMiddleLabelText("First point of line...");
									break;
								}
								_it += 1;
							}

							else {
								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;
								for (Circle c : circleList) {
									if ((_x > c.getCenterX() - circleRay) && (_x < c.getCenterX() + circleRay)
											&& (_y > c.getCenterY() - circleRay) && (_y < c.getCenterY() + circleRay)) {
										_cFirstPosX = c.getCenterX();
										_cFirstPosY = c.getCenterY();
										setMiddleLabelText("First point of line...");
										break;
									}
								}

								for (Rectangle r : squareList) {
									if ((_x > r.getX()) && (_x < r.getX() + squareRay) && (_y > r.getY())
											&& (_y < r.getY() + squareRay)) {
										_cFirstPosX = r.getX() + 20;
										_cFirstPosY = r.getY() + 20;
										setMiddleLabelText("First point of line...");
										break;
									}
								}

								_isCircleFirst = false;
								_it += 1;
								break;
							}

						}

					} catch (Exception e) {
						e.getMessage();
					}

				}

			} else {
				int _it = 0;
				while (_it <= utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
					try {
						if (event.getSceneY() > minusWidth) {
							Object g = mainPane.getChildren().get(_it);
							if (g instanceof Circle) {

								Circle check1 = circleList.get(_it);
								double _c1 = check1.getCenterX();
								double _c2 = check1.getCenterY();

								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;

								if ((_x > _c1 - circleRay) && (_x < _c1 + circleRay) && (_y < _c2 + circleRay)
										&& (_y > _c2 - circleRay) && (_y > minusWidth)) {
									_cSecPosX = ((Circle) g).getCenterX();
									_cSecPosY = ((Circle) g).getCenterY();
									Line l = new Line(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY);
									l.setStroke(Paint.valueOf("#ABCDEF"));
									l.setStrokeWidth(10.0f);
									mainPane.getChildren().add(l);
									lineList.add(l);
									_isCircleFirst = true;
									setMiddleLabelText("Second point of line...");
									_it = 0;
									break;

								}
								_it += 1;

							}

							else if (g instanceof Rectangle) {
								Rectangle check1 = squareList.get(_it);
								double _c1 = check1.getX() + 20;
								double _c2 = check1.getY() + 20;

								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;

								if ((_x > _c1 - squareRay) && (_x < _c1 + squareRay) && (_y > _c2 - squareRay)
										&& (_y < _c2 + squareRay) && (_y > minusWidth)) {
									_cSecPosX = ((Rectangle) g).getX() + 20;
									_cSecPosY = ((Rectangle) g).getY() + 20;
									Line l = new Line(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY);
									l.setStroke(Paint.valueOf("#ABCDEF"));
									l.setStrokeWidth(10.0f);
									mainPane.getChildren().add(l);
									lineList.add(l);
									_isCircleFirst = true;
									setMiddleLabelText("Second point of line...");
									_it = 0;
									break;

								}
								_it += 1;
							} else {
								double _x = event.getSceneX();
								double _y = event.getSceneY() - minusWidth;
								for (Circle c : circleList) {
									if ((_x > c.getCenterX() - circleRay) && (_x < c.getCenterX() + circleRay)
											&& (_y > c.getCenterY() - circleRay) && (_y < c.getCenterY() + circleRay)) {
										_cSecPosX = c.getCenterX();
										_cSecPosY = c.getCenterY();
										setMiddleLabelText("Second point of line...");
										Line l = new Line(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY);
										l.setStroke(Paint.valueOf("#ABCDEF"));
										l.setStrokeWidth(10.0f);
										mainPane.getChildren().add(l);
										lineList.add(l);
										break;

									}
								}

								for (Rectangle r : squareList) {
									if ((_x > r.getX()) && (_x < r.getX() + squareRay) && (_y > r.getY())
											&& (_y < r.getY() + squareRay)) {
										_cSecPosX = r.getX() + 20;
										_cSecPosY = r.getY() + 20;
										setMiddleLabelText("Second point of line...");
										Line l = new Line(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY);
										l.setStroke(Paint.valueOf("#ABCDEF"));
										l.setStrokeWidth(10.0f);
										mainPane.getChildren().add(l);
										lineList.add(l);
										break;
									}
								}

								_it += 1;
								_isCircleFirst = true;
								break;

							}

						}
					} catch (Exception e) {
						e.getMessage();
					}

				}

			}

		}
	}

	public void waitOnSecClick(MouseEvent e) {
		_cSecPosX = e.getSceneX();
		_cSecPosY = e.getSceneY();
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
						((Circle) g).setOnMousePressed(circleOnMousePressedEventHandler);
						((Circle) g).setOnMouseDragged(circleOnMouseDraggedEventHandler);

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

		backgroundColor = settingsController.setBackgroundColorLabel();


		mainPane.setStyle("-fx-background-color: #FFFFFF");

		middleLabel.setDisable(true);

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

		toggleButtonsGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
				if (new_toggle == null)
					selectedToggle = "null";
				else {
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

	@FXML
	void mainPane_OnDragDropped(MouseEvent event) {
		// nic
	}

	@FXML
	void mainPane_OnMouseReseased(MouseEvent event) {
		// nic

	}


}