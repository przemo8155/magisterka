package application;

import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;

public class Utilities {
	public void clearUpMessage(Pane pane, String title, String header, String content){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			pane.getChildren().clear();
		} else {
			// ... user chose CANCEL or closed the dialog
		}
	}


	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}


	public static void exitFromApplication(){
		Platform.exit();
		System.exit(0);
	}

	public int takeMaximumFromLists(ObservableList<Circle> circle, ObservableList<Rectangle> rectangle) {
		int w = 0;
		w = circle.size() + rectangle.size();
		return w;
	}


}
