package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.activation.FileDataSource;

import com.sun.glass.ui.Window.Level;
import com.sun.javafx.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Paint;
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
		Reader(file, circles, squares, lines);

	}

	private void Reader(File file, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<Line> lines) {
		Scanner scanner;
		Boolean fullCircle = false;
		Double g1 = 0.0, g2 = 0.0;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String tmp = scanner.next();
				if (tmp.equals("circles")) {
					String t;
					while (!(t = scanner.next()).equals("squares")) {

						if (!fullCircle) {
							g1 = Double.parseDouble(t);
							fullCircle = true;
						} else {
							g2 = Double.parseDouble(t);
							fullCircle = false;
							Circle c = new Circle(g1, g2, 20.0f, Paint.valueOf("#923456"));
							c.setStroke(Paint.valueOf("#555555"));
							c.setStrokeWidth(5.0f);
							circles.add(c);
						}

					}
				}



			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
