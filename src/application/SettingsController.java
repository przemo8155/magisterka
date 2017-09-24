package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SettingsController {

	public String backgroundColorString, circleColorString, rectangleColorString, lineColorString;

	@FXML
	private Button cancelButton, saveButton;

	@FXML
	private Label backgroundColorLabel, circleColorLabel, rectangleColorLabel, lineColorLabel;

	@FXML
	private ComboBox<String> backgroundColorBox, circleColorBox, rectangleColorBox, lineColorBox;





	public void initialize(){

		backgroundColorBox.getItems().addAll("Default", "Black", "Blue");
		backgroundColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

			@Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(100);
	                super.setFont(Font.font("Allan", 14));
	              }

	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  if (item.contains("Default (White)")) {
	                	  backgroundColorString = "White";
	                  } else if (item.contains("Black")) {
	                	  backgroundColorString = "Black";
	                    setTextFill(Color.BLACK);
	                  } else if (item.contains("Blue")){
	                	  backgroundColorString = "Blue";
	                    setTextFill(Color.BLUE);
	                  }
	                } else {
	                  setText(null);
	                }
	              }
	            };
	            return cell;
	          }
		});


		circleColorBox.getItems().addAll("Default", "Black", "Blue");
		circleColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

			@Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(100);
	                super.setFont(Font.font("Allan", 14));
	              }

	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  if (item.contains("Default (White)")) {
	                	  circleColorString = "White";
	                  } else if (item.contains("Black")) {
	                	  circleColorString = "Black";
	                    setTextFill(Color.BLACK);
	                  } else if (item.contains("Blue")){
	                	  circleColorString = "Blue";
	                    setTextFill(Color.BLUE);
	                  }
	                } else {
	                  setText(null);
	                }
	              }
	            };
	            return cell;
	          }
		});

		rectangleColorBox.getItems().addAll("Default", "Black", "Blue");
		rectangleColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

			@Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(100);
	                super.setFont(Font.font("Allan", 14));
	              }

	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  if (item.contains("Default (White)")) {
	                	  rectangleColorString = "White";
	                  } else if (item.contains("Black")) {
	                	  rectangleColorString = "Black";
	                    setTextFill(Color.BLACK);
	                  } else if (item.contains("Blue")){
	                	  rectangleColorString = "Blue";
	                    setTextFill(Color.BLUE);
	                  }
	                } else {
	                  setText(null);
	                }
	              }
	            };
	            return cell;
	          }
		});

		lineColorBox.getItems().addAll("Default", "Black", "Blue");
		lineColorBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

			@Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(100);
	                super.setFont(Font.font("Allan", 14));
	              }

	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  if (item.contains("Default (White)")) {
	                	  lineColorString = "White";
	                  } else if (item.contains("Black")) {
	                	  lineColorString = "Black";
	                    setTextFill(Color.BLACK);
	                  } else if (item.contains("Blue")){
	                	  lineColorString = "Blue";
	                    setTextFill(Color.BLUE);
	                  }
	                } else {
	                  setText(null);
	                }
	              }
	            };
	            return cell;
	          }
		});


	}

	@FXML
	void saveButton_OnAction(ActionEvent event){

	}

	@FXML
	void cancelButton_OnAction(ActionEvent event){
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}


	public String getBackgroundColorLabel(){
		return backgroundColorString;
	}

	public void setBackgroundColorLabel(String a){
		backgroundColorString = a;
	}

	public String getCircleColorLabel(){
		return circleColorString;
	}

	public void setCircleColorLabel(String a){
		circleColorString = a;
	}

	public String getRectangleColorLabel(){
		return rectangleColorString;
	}

	public void setRectangleColorLabel(String a){
		rectangleColorString = a;
	}

	public String getLineColorLabel(){
		return lineColorString;
	}

	public void setLineColorLabel(String a){
		lineColorString = a;
	}

}
