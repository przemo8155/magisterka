package application;

import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;

public class Utilities {
	private MainWindowController mwc;

	public Boolean checkCleared = false;

	public void clearUpMessage(Pane pane, String title, String header, String content, ObservableList<Circle> circ,
			ObservableList<Rectangle> rect, ObservableList<Line> lin) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			pane.getChildren().clear();
			circ.clear();
			rect.clear();
			lin.clear();
			checkCleared = true;
		} else {
			checkCleared = false;
		}
	}

	public static void infoBox(String infoMessage) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void doubleBox(Double infoMessage) {
		JOptionPane.showMessageDialog(null, infoMessage.toString(), "InfoBox:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void intBox(int infoMessage) {
		JOptionPane.showMessageDialog(null, Integer.toString(infoMessage), "InfoBox:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exitFromApplication() {
		Platform.exit();
		System.exit(0);
	}

	public int takeMaximumFromLists(ObservableList<Circle> circle, ObservableList<Rectangle> rectangle,
			ObservableList<Line> line) {
		int w = 0;
		w = circle.size() + rectangle.size() + line.size();
		return w;
	}

}
