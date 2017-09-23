package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManager {

	public Boolean somethingOpened = false;
	public Boolean somethingSaved = false;

	public void SaveFile(Stage stage, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<Line> lines) {
		try {
			setSomethingSaved(false);
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

			if(file != null){
				setSomethingSaved(true);
			}

			Saver(stringToFile, file);

		} catch (NullPointerException ex) {
			ex.fillInStackTrace();
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
		try {
			setSomethingOpened(false);
			FileChooser fileChooser = new FileChooser();
			File file;
			fileChooser.setTitle("Open File");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PB files (*.pb)", "*.pb");
			fileChooser.getExtensionFilters().add(extFilter);
			file = fileChooser.showOpenDialog(stage);
			if(file != null){
				setSomethingOpened(true);
			}
			Reader(file, circles, squares, lines);

		} catch (NullPointerException ex) {
			ex.fillInStackTrace();
		}

	}



	private void Reader(File file, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<Line> lines) {
		Scanner scanner;

		Boolean fullCircle = false;
		Boolean fullSquare = false;

		int faze = 1;

		Double g1 = 0.0, g2 = 0.0;
		Double s1 = 0.0, s2 = 0.0;
		Double ls1 = 0.0, ls2 = 0.0, le1 = 0.0, le2 = 0.0;
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
			e1.printStackTrace();
		}

		try {
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				String tmp = scanner.next();

				if (tmp.equals("squares")) {
					String t;
					while (!(t = scanner.next()).equals("lines")) {

						if (!fullSquare) {
							s1 = Double.parseDouble(t);
							fullSquare = true;
						} else {
							s2 = Double.parseDouble(t);
							fullSquare = false;
							Rectangle r = new Rectangle(s1, s2, 40.0f, 40.0f);
							r.setFill(Paint.valueOf("#ABCDEF"));
							r.setStroke(Paint.valueOf("#555555"));
							r.setStrokeWidth(5.0f);
							squares.add(r);

						}

					}
				}

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				String tmp = scanner.next();

				if (tmp.equals("lines")) {
					String t;
					while (scanner.hasNext()) {
						t = scanner.next();

						switch (faze) {
						case 1:
							ls1 = Double.parseDouble(t);
							faze += 1;
							break;
						case 2:
							ls2 = Double.parseDouble(t);
							faze += 1;
							break;
						case 3:
							le1 = Double.parseDouble(t);
							faze += 1;
							break;
						case 4:
							le2 = Double.parseDouble(t);
							faze = 1;
							Line l = new Line(ls1, ls2, le1, le2);
							l.setStroke(Paint.valueOf("#ABCDEF"));
							l.setStrokeWidth(10.0f);
							lines.add(l);
							break;

						}

					}
				}

			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	public Boolean getSomethingOpened(){
		return somethingOpened;
	}

	public void setSomethingOpened(Boolean a){
		somethingOpened = a;
	}

	public Boolean getSomethingSaved(){
		return somethingSaved;
	}

	public void setSomethingSaved(Boolean a){
		somethingSaved = a;
	}
}
