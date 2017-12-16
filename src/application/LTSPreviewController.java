package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.Event;

public class LTSPreviewController
{
	Utilities utilities = new Utilities();

	ObservableList<String> statesListFromFile = FXCollections.observableArrayList();
	ObservableList<String> labelsListFromFile = FXCollections.observableArrayList();
	ObservableList<String> arcsListFromFile = FXCollections.observableArrayList();

    @FXML
    private Pane mainPane;

    @FXML
    private Button closeButton;



	public void initData(ObservableList<String> states, ObservableList<String> labels, ObservableList<String> arcs)
	{
		this.arcsListFromFile = arcs;
		this.statesListFromFile = states;
		this.labelsListFromFile = labels;
	}

    public void initialize()
    {
    	mainPane.setStyle("-fx-background-color: #FFFFFF");
    	utilities.intBox(statesListFromFile.size());
    	utilities.intBox(labelsListFromFile.size());
    	utilities.intBox(arcsListFromFile.size());
    }

    @FXML
    void closeButton_OnAction(ActionEvent event)
    {
    	Stage closeStage = (Stage) closeButton.getScene().getWindow();
		closeStage.close();
    }

    void readTemponaryFile()
    {

    }

}
