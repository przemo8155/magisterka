package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LTSPreviewController
{
	Utilities utilities = new Utilities();


    @FXML
    private Pane mainPane;

    @FXML
    private Button closeButton;

    public void initialize()
    {
    	mainPane.setStyle("-fx-background-color: #FFFFFF");
    }

    @FXML
    void closeButton_OnAction(ActionEvent event)
    {
    	Stage closeStage = (Stage) closeButton.getScene().getWindow();
		closeStage.close();
    }

    void setBackgroundColor()
    {

    }

}
