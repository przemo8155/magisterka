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
import javafx.util.Callback;

public class SettingsController {

	public String backgroundColorString;

	@FXML
	private Button cancelButton, saveButton;

	@FXML
	private Label backgroundColorLabel, circleColorLabel, rectangleColorLabel, lineColorLabel;

	@FXML
	private ComboBox<String> backgroundColorBox;

	private String inyy;

	public String setBackgroundColorLabel(){
		return backgroundColorString;
	}

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
	}

}
