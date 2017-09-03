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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
	static int minusWidth = 130;
	int radio = 0;
	String selectedToggle = "";

	ObservableList<Circle> circleList = FXCollections.observableArrayList();

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
    private Button createCircleButton, clearAllButton;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Pane mainPane;

    @FXML
    private ToggleButton squareToggleButton, circleToggleButton;


    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY() - minusWidth;
                orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
            }
        };

        EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
                new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY - minusWidth;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Circle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

            EventHandler<MouseEvent> arcOnMousePressedEventHandler =
                    new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        orgSceneX = t.getSceneX();
                        orgSceneY = t.getSceneY();
                        orgTranslateX = ((Arc)(t.getSource())).getTranslateX();
                        orgTranslateY = ((Arc)(t.getSource())).getTranslateY();
                    }
                };

                EventHandler<MouseEvent> arcOnMouseDraggedEventHandler =
                        new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent t) {
                            double offsetX = t.getSceneX() - orgSceneX;
                            double offsetY = t.getSceneY() - orgSceneY;
                            double newTranslateX = orgTranslateX + offsetX;
                            double newTranslateY = orgTranslateY + offsetY;

                            ((Arc)(t.getSource())).setTranslateX(newTranslateX);
                            ((Arc)(t.getSource())).setTranslateY(newTranslateY);
                        }
                    };

    @FXML
    void anchorPane_OnMouseClicked(MouseEvent event)
    {

    }

    @FXML
    void mainPane_OnMouseClicked(MouseEvent event)
    {
    	switch(radio)
		{
			case 1:
				Circle c = new Circle(event.getSceneX(), event.getSceneY() - minusWidth, 20.0f, Paint.valueOf("#923456"));
				c.setStroke(Paint.valueOf("#555555"));
				c.setStrokeWidth(5.0f);
				mainPane.getChildren().add(c);
				c.setOnMousePressed(circleOnMousePressedEventHandler);
				circleList.add(c);
				break;

			case 2:
				Rectangle r = new Rectangle(event.getSceneX() - 20, event.getSceneY() - minusWidth - 20, 40.0f, 40.0f);
				r.setFill(Paint.valueOf("#ABCDEF"));
				r.setStroke(Paint.valueOf("#555555"));
				r.setStrokeWidth(5.0f);
				mainPane.getChildren().add(r);
				r.setOnMousePressed(circleOnMousePressedEventHandler);
				break;
			case 3:
				mainPane.getChildren().clear();
		}

    	switch(selectedToggle)
    	{
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
				r.setOnMousePressed(circleOnMousePressedEventHandler);
				break;

    	}
    }


	public void initialize()
	{
		mainPane.setStyle("-fx-background-color: #FFFFFF");
		final ToggleGroup toggleButtonsGroup = new ToggleGroup();
		circleToggleButton.setToggleGroup(toggleButtonsGroup);
		squareToggleButton.setToggleGroup(toggleButtonsGroup);

		circleToggleButton.setUserData("circle");
		squareToggleButton.setUserData("square");

		toggleButtonsGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov,
		        Toggle toggle, Toggle new_toggle) {
		            if (new_toggle == null)
		                selectedToggle = "null";
		            else
		                selectedToggle = (String)toggleButtonsGroup.getSelectedToggle().getUserData();
		         }
		});



	}


	@FXML
	void exitMenuItem_OnAction(ActionEvent event)
	{
		Platform.exit();
		System.exit(0);
	}


	@FXML
	void clearAllButton_OnMouseClicked(MouseEvent event)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Question");
		alert.setHeaderText("Clear all elements");
		alert.setContentText("Are you sure?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			mainPane.getChildren().clear();
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
	}


	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}