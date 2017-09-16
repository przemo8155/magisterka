package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.activation.FileDataSource;

import com.sun.glass.ui.Window.Level;
import com.sun.javafx.logging.Logger;

import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class FileManager {

	public void SaveFile(Stage stage, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<Line> lines) {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			final String _circles = "circles";
			stringBuilder.append(_circles);
			stringBuilder.append(System.getProperty("line.separator"));
			for (Circle c : circles) {
				Double _d1 = c.getCenterX();
				Double _d2 = c.getCenterY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _squares = "squares";
			stringBuilder.append(_squares);
			stringBuilder.append(System.getProperty("line.separator"));
			for (Rectangle r : squares) {
				Double _d1 = r.getX();
				Double _d2 = r.getY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _lines = "lines";
			stringBuilder.append(_lines);
			stringBuilder.append(System.getProperty("line.separator"));
			for (Line l : lines) {
				Double _d1 = l.getStartX();
				Double _d2 = l.getStartY();
				Double _d3 = l.getEndX();
				Double _d4 = l.getEndY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				Integer _i3 = _d3.intValue();
				Integer _i4 = _d4.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(" ");
				stringBuilder.append(_i3);
				stringBuilder.append(" ");
				stringBuilder.append(_i4);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String stringToFile = stringBuilder.toString();
			FileChooser fileChooser = new FileChooser();
			File file;

			fileChooser.setTitle("Save File");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PB files (*.pb)", "*.pb");
			fileChooser.getExtensionFilters().add(extFilter);
			file = fileChooser.showSaveDialog(stage);
			Saver(stringToFile, file);
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}

	private void Saver(String content, File file) {
		try {
			FileWriter fileWriter = null;

			fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (IOException ex) {
			ex.getLocalizedMessage();
		}

	}

	public void OpenFile(Stage stage, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<Line> lines) {

		FileChooser fileChooser = new FileChooser();
		File file;

		fileChooser.setTitle("Open File");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PB files (*.pb)", "*.pb");
		fileChooser.getExtensionFilters().add(extFilter);
		file = fileChooser.showOpenDialog(stage);
		String buffer1 = Reader(file);

		Utilities.infoBox(buffer1);

	}

	private String Reader(File file) {
		StringBuilder stringBuffer = new StringBuilder();

		StringBuilder circlesBuffer = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {

			bufferedReader = new BufferedReader(new FileReader(file));

			String text;
			String circle;
			while ((text = bufferedReader.readLine()) != null) {
				if (bufferedReader.readLine() == "circles") {
					while (bufferedReader.readLine() != "squares") {
						circlesBuffer.append(text);
						circlesBuffer.append(System.getProperty("line.separator"));

					}
				}
				stringBuffer.append(text);
			}

		} catch (FileNotFoundException ex) {
			ex.getLocalizedMessage();
		} catch (IOException ex) {
			ex.getLocalizedMessage();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException ex) {
				ex.getLocalizedMessage();
			}
		}

		return stringBuffer.toString();
	}
}
