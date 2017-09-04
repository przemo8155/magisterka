package application;

import java.awt.Color;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.omg.CORBA.PUBLIC_MEMBER;

import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
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
import javafx.*;
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
	boolean _isFirst = true;

	Utilities utilities = new Utilities();

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
	private Pane mainPane;

	@FXML
	private ToggleButton squareToggleButton, circleToggleButton, moveToggleButton, lineToggleButton;

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
			if (_isFirst) {
				int _it = 0;
				while (_it < utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
					try {
						Object g = mainPane.getChildren().get(_it);
						if (g instanceof Circle) {

							Circle check1 = circleList.get(_it);

							double _c1 = check1.getCenterX();
							double _c2 = check1.getCenterY();

							double _x = event.getSceneX();
							double _y = event.getSceneY() - minusWidth;

							if ((_x > _c1 - circleRay) && (_x < _c1 + circleRay) && (_y > _c2 - circleRay) && (_y < _c2 + circleRay)) {
								Circle check2 = ((Circle) g);
								_firstPosX = ((Circle) g).getCenterX();
								_firstPosY = ((Circle) g).getCenterY();
								_isFirst = false;
							}


						}

						if(g instanceof Rectangle){

							Rectangle check1 = squareList.get(_it);

							double _c1 = check1.getLayoutX();
							double _c2 = check1.getLayoutY();

							double _x = event.getSceneX() - 20;
							double _y = event.getSceneY() - minusWidth - 20;

							if ((_x > _c1 - squareRay) && (_x < _c1 + squareRay) && (_y < _c2 + squareRay) && (_y > _c2 - squareRay)) {
								_firstPosX = ((Rectangle) g).getX();
								_firstPosY = ((Rectangle) g).getY();
								_isFirst = false;

							}
						}

						_it += 1;
					} catch (Exception e) {
						e.getMessage();
					}

				}

			} else {
				int _it = 0;
				while (_it < utilities.takeMaximumFromLists(circleList, squareList, lineList)) {
					try {
						Object g = mainPane.getChildren().get(_it);
						if (g instanceof Circle) {
							Circle check1 = circleList.get(_it);

							double _c1 = check1.getCenterX();
							double _c2 = check1.getCenterY();

							double _x = event.getSceneX();
							double _y = event.getSceneY() - minusWidth;

							if ((_x > _c1 - circleRay) && (_x < _c1 + circleRay) && (_y < _c2 + circleRay) && (_y > _c2 - circleRay)) {
								_secPosX = ((Circle) g).getCenterX();
								_secPosY = ((Circle) g).getCenterY();
								Line l = new Line(_firstPosX, _firstPosY, _secPosX, _secPosY);
								l.setStroke(Paint.valueOf("#ABCDEF"));
								l.setStrokeWidth(10.0f);
								mainPane.getChildren().add(l);
								lineList.add(l);
								_isFirst = true;

							}

						}

						if(g instanceof Rectangle){
							Rectangle check1 = squareList.get(_it);

							double _c1 = check1.getLayoutX();
							double _c2 = check1.getLayoutY();

							double _x = event.getSceneX();
							double _y = event.getSceneY() - minusWidth;

							if ((_x > _c1 - squareRay) && (_x < _c1 + squareRay) && (_y < _c2 + squareRay) && (_y > _c2 - squareRay)) {
								_secPosX = ((Rectangle) g).getX();
								_secPosY = ((Rectangle) g).getY();
								Line l = new Line(_firstPosX, _firstPosY, _secPosX, _secPosY);
								l.setStroke(Paint.valueOf("#ABCDEF"));
								l.setStrokeWidth(10.0f);
								mainPane.getChildren().add(l);
								lineList.add(l);
								_isFirst = true;

							}
						}
						_it += 1;
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

		mainPane.setStyle("-fx-background-color: #FFFFFF");
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
				else
					selectedToggle = (String) toggleButtonsGroup.getSelectedToggle().getUserData();
			}
		});

	}

	@FXML
	void exitMenuItem_OnAction(ActionEvent event) {
		Utilities.exitFromApplication();
	}

	@FXML
	void clearAllButton_OnMouseClicked(MouseEvent event) {
		utilities.clearUpMessage(mainPane, "Question", "Clear all elements", "Are you sure?");
		circleList.clear();
		squareList.clear();
		lineList.clear();
	}

}