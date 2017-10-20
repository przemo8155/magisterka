
package application;

//tix

import java.awt.Color;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Optional;

import javax.lang.model.element.Element;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.sun.javafx.font.FontFactory;
import com.sun.javafx.stage.StageHelper;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.*;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import application.Main;

public class MainWindowController
{

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	static int minusWidth = 95;
	String selectedToggle = "";
	String idObj = "";
	int circleId = 0;
	String secondObject = "";

	int mouseBothClicked = 0, mouseRightClicked = 0, mouseLeftClicked = 0;
	int objectsDeleted = 0, objectsMoved = 0;

	Scale scaleTransform;
	Group zoomGroup;

	static int circleRay = 30, squareRay = 40, lineRay = 10;

	double _cSecPosX = 0, _cSecPosY = 0, _cFirstPosX = 0, _cFirstPosY = 0;
	double _rFirstPosX, _rFirstPosY, _rSecPosX, _rSecPosY;
	double _circleLine1, _circleLine2;
	boolean _isCircleFirst = true, _isRectangleFirst = true;

	Label circlesCreatedL = new Label("Circles created: ");
	Label numberOfCirclesCreatedL = new Label("0");

	Label rectanglesCreatedL = new Label("Rectangles created: ");
	Label numberOfRectanglesCreatedL = new Label("0");

	Label arrowsCreatedL = new Label("Arrows created: ");
	Label numberOfArrowsCreatedL = new Label("0");

	Label mouseBothClickL = new Label("Mouse both clicked: ");
	Label numberOfMouseBothClickL = new Label("0");

	Label mouseRightClickL = new Label("Mouse right clicked: ");
	Label numberOfMouseRightClickL = new Label("0");

	Label mouseLeftClickL = new Label("Mouse left clicked: ");
	Label numberOfMouseLeftClickL = new Label("0");

	Label objectsDeletedL = new Label("Objects deleted: ");
	Label numberOfObjectsDeletedL = new Label("0");

	Label objectsMovedL = new Label("Objects moved: ");
	Label numberOfObjectsMovedL = new Label("0");

	Button exportToPdf = new Button("Export PDF");
	Button showStats = new Button("Elo");

	Utilities utilities = new Utilities();
	FileManager fileManager = new FileManager();
	Main main = new Main();
	SettingsController settingsController = new SettingsController();
	Counters counters = new Counters();
	ConnectToDatabase connectToDatabase = new ConnectToDatabase();
	ExportPDF exportPdf = new ExportPDF();

	private String backgroundColor;
	private String circleColor;
	private String rectangleColor;
	private String arrowColor;

	private Boolean deleteSecondOfEndLine = false;

	ObservableList<Circle> circleList = FXCollections.observableArrayList();
	ObservableList<Rectangle> squareList = FXCollections.observableArrayList();
	ObservableList<Line> lineList = FXCollections.observableArrayList();
	ObservableList<Arrow> arrowList = FXCollections.observableArrayList();

	ObservableList<Line> startLineList = FXCollections.observableArrayList();
	ObservableList<Line> endLineList = FXCollections.observableArrayList();

	ObservableList<Arrow> endArrowList = FXCollections.observableArrayList();
	ObservableList<Arrow> startArrowList = FXCollections.observableArrayList();

	ObservableList<Line> moveLineList = FXCollections.observableArrayList();
	ObservableList<Arrow> moveArrowList = FXCollections.observableArrayList();

	ObservableList<Line> leftArrowList = FXCollections.observableArrayList();
	ObservableList<Line> rightArrowList = FXCollections.observableArrayList();

	ObservableList<Line> moveRightArrowList = FXCollections.observableArrayList();
	ObservableList<Line> moveLeftArrowList = FXCollections.observableArrayList();

	ObservableList<HeadArrow> headArrowList = FXCollections.observableArrayList();
	ObservableList<HeadArrow> startHeadArrowList = FXCollections.observableArrayList();
	ObservableList<HeadArrow> endHeadArrowList = FXCollections.observableArrayList();
	ObservableList<HeadArrow> moveHeadArrowList = FXCollections.observableArrayList();

	@FXML
	private TitledPane titledPaneStats;

	@FXML
	private Accordion accordionStats;

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
	private Button clearAllButton;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	public Pane mainPane;

	@FXML
	private ToggleButton squareToggleButton, circleToggleButton, moveToggleButton, lineToggleButton, removeToggleButton;

	@FXML
	private Label middleLabel;

	@FXML
	Parent root;

	Task<Void> task = new Task<Void>()
	{

		@Override
		protected Void call() throws Exception
		{
			int iterations;
			for (iterations = 0; iterations < 1000; iterations++)
			{
				ConnectToDatabase ctd = new ConnectToDatabase();
				ctd.Connect();
				backgroundColor = ctd.getBackgroundString();
				rectangleColor = ctd.getRectangleString();
				circleColor = ctd.getCircleString();
				arrowColor = ctd.getArrowString();
				updateProgress(iterations, 1000);

				try
				{
					Thread.sleep(100);
				} catch (InterruptedException interrupted)
				{
					if (isCancelled())
					{
						updateMessage("Cancelled");
						break;
					}
				}
			}

			return null;
		}

	};

	public void setMiddleLabelText(String text)
	{
		middleLabel.setDisable(false);
		middleLabel.setText(text);


		FadeTransition ft = new FadeTransition(Duration.millis(1200), middleLabel);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setAutoReverse(false);
		ft.play();
		middleLabel.setDisable(true);

	}

	EventHandler<MouseEvent> deleteSecondLastLineEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent event)
		{
			if (headArrowList.size() > 1 && deleteSecondOfEndLine)
			{
				headArrowList.remove(headArrowList.size() - 1);
				deleteSecondOfEndLine = false;
			}
		}

	};

	EventHandler<MouseEvent> secondPointOfLineEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent event)
		{
			if (_cFirstPosX != 0 && _cFirstPosY != 0)
			{
				if (!moveHeadArrowList.isEmpty())
				{
					headArrowList.removeAll(moveHeadArrowList);

					for (HeadArrow ha : moveHeadArrowList)
					{
						ha.removeFromMainPane(mainPane);
					}

					moveHeadArrowList.clear();
				}

				HeadArrow ha = new HeadArrow(_cFirstPosX, _cFirstPosY, event.getScreenX(),
						event.getSceneY() - minusWidth, mainPane);
				headArrowList.add(ha);
				ha.setFill(arrowColor);
				moveHeadArrowList.add(ha);
				deleteSecondOfEndLine = true;

			}

		}
	};

	EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY() - minusWidth;
			orgTranslateX = ((Circle) (t.getSource())).getTranslateX();
			orgTranslateY = ((Circle) (t.getSource())).getTranslateY();

		}

	};

	EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			try
			{
				Circle c = ((Circle) t.getSource());
				int index = circleList.indexOf(c);

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getStartX() == c.getCenterX() && ha.getStartY() == c.getCenterY())
					{
						startHeadArrowList.add(ha);
					}
				}

				headArrowList.removeAll(startHeadArrowList);

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getEndX() == c.getCenterX() && ha.getEndY() == c.getCenterY())
					{
						endHeadArrowList.add(ha);
					}
				}

				headArrowList.removeAll(endHeadArrowList);

				double offsetX = t.getSceneX();
				double offsetY = t.getSceneY() - minusWidth;

				double newTranslateX = orgTranslateX + offsetX;
				double newTranslateY = orgTranslateY + offsetY;

				c.setCenterX(newTranslateX);
				c.setCenterY(newTranslateY);

				circleList.set(index, c);

				for (HeadArrow ha : endHeadArrowList)
				{
					ha.setEndX(c.getCenterX(), mainPane);
					ha.setEndY(c.getCenterY(), mainPane);
					ha.setLeft(c.getCenterX(), c.getCenterY(), mainPane);
					ha.setRight(c.getCenterX(), c.getCenterY(), mainPane);

				}

				for (HeadArrow ha : startHeadArrowList)
				{
					ha.setStartX(c.getCenterX(), mainPane);
					ha.setStartY(c.getCenterY(), mainPane);
					ha.setLeft(c.getCenterX(), c.getCenterY(), mainPane);
					ha.setRight(c.getCenterX(), c.getCenterY(), mainPane);
				}

				headArrowList.addAll(startHeadArrowList);
				headArrowList.addAll(endHeadArrowList);

				utilities.clearStartAndEndHeadArrowLists(startHeadArrowList, endHeadArrowList);

				for (HeadArrow ha : headArrowList)
				{
					ha.setFill(arrowColor);
				}

			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	};

	EventHandler<MouseEvent> squareOnMousePressedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Rectangle) (t.getSource())).getX();
			orgTranslateY = ((Rectangle) (t.getSource())).getY();
		}
	};

	EventHandler<MouseEvent> squareOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
	{

		@Override
		public void handle(MouseEvent t)
		{
			try
			{
				Rectangle r = ((Rectangle) t.getSource());
				int index = squareList.indexOf(r);

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getStartX() - 20 == r.getX() && ha.getStartY() - 20 == r.getY())
					{
						startHeadArrowList.add(ha);
					}
				}

				headArrowList.removeAll(startHeadArrowList);

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getEndX() - 20 == r.getX() && ha.getEndY() - 20 == r.getY())
					{
						endHeadArrowList.add(ha);
					}
				}

				headArrowList.removeAll(endHeadArrowList);

				double offsetX = t.getSceneX() - orgSceneX;
				double offsetY = t.getSceneY() - orgSceneY;
				double newTranslateX = orgTranslateX + offsetX;
				double newTranslateY = orgTranslateY + offsetY;

				r.setX(newTranslateX);
				r.setY(newTranslateY);

				squareList.set(index, r);

				for (HeadArrow ha : endHeadArrowList)
				{
					ha.setEndX(r.getX() + 20, mainPane);
					ha.setEndY(r.getY() + 20, mainPane);
					ha.setLeft(r.getX() + 20, r.getY() + 20, mainPane);
					ha.setRight(r.getX() + 20, r.getY() + 20, mainPane);

				}

				for (HeadArrow ha : startHeadArrowList)
				{
					ha.setStartX(r.getX() + 20, mainPane);
					ha.setStartY(r.getY() + 20, mainPane);
					ha.setLeft(r.getX() + 20, r.getY() + 20, mainPane);
					ha.setRight(r.getX() + 20, r.getY() + 20, mainPane);
				}

				headArrowList.addAll(startHeadArrowList);
				headArrowList.addAll(endHeadArrowList);

				utilities.clearStartAndEndHeadArrowLists(startHeadArrowList, endHeadArrowList);

				for (HeadArrow ha : headArrowList)
				{
					ha.setFill(arrowColor);
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	};

	@FXML
	void anchorPane_OnMouseClicked(MouseEvent event)
	{
		counters.circleCounter(circleList, numberOfCirclesCreatedL);
		counters.rectangleCounter(squareList, numberOfRectanglesCreatedL);
		counters.headArrowCounter(headArrowList, numberOfArrowsCreatedL);
		counters.mouseClickerCounter(mouseBothClicked, numberOfMouseBothClickL);
		counters.mouseClickerCounter(mouseRightClicked, numberOfMouseRightClickL);
		counters.mouseClickerCounter(mouseLeftClicked, numberOfMouseLeftClickL);
		counters.objDeleted(objectsDeleted, numberOfObjectsDeletedL);
		counters.objDeleted(objectsMoved, numberOfObjectsMovedL);
	}

	@FXML
	void mainPane_OnMouseClicked(MouseEvent event)
	{

		switch (selectedToggle)
		{

			case "remove":
				if (event.getSceneY() > minusWidth + 10)
				{
					double x = event.getSceneX();
					double y = event.getSceneY();
					for (Circle myCircle : circleList)
					{
						if ((x > myCircle.getCenterX() - circleRay) && (x < myCircle.getCenterX() + circleRay)
								&& (y > myCircle.getCenterY() - circleRay + minusWidth)
								&& (y < myCircle.getCenterY() + circleRay + minusWidth))
						{

							for (HeadArrow ha : headArrowList)
							{
								if (ha.getStartX() == myCircle.getCenterX() && ha.getStartY() == myCircle.getCenterY())
								{
									startHeadArrowList.add(ha);
								}
							}

							for (HeadArrow ha : headArrowList)
							{
								if (ha.getEndX() == myCircle.getCenterX() && ha.getEndY() == myCircle.getCenterY())
								{
									endHeadArrowList.add(ha);
								}
							}

							if (!startHeadArrowList.isEmpty())
							{
								headArrowList.removeAll(startHeadArrowList);

								for (HeadArrow ha : startHeadArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!endHeadArrowList.isEmpty())
							{
								headArrowList.removeAll(endHeadArrowList);

								for (HeadArrow ha : endHeadArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							circleList.remove(myCircle);
							mainPane.getChildren().remove(myCircle);
							objectsDeleted += 1;
							setMiddleLabelText("Circle removed...");
							utilities.clearStartAndEndHeadArrowLists(startHeadArrowList, endHeadArrowList);
							break;
						}
					}

					for (Rectangle myRectangle : squareList)
					{
						if ((x > myRectangle.getX() + 20 - squareRay) && (x < myRectangle.getX() + 20 + squareRay)
								&& (y > myRectangle.getY() + 20 - squareRay + minusWidth)
								&& (y < myRectangle.getY() + 20 + squareRay + minusWidth))
						{

							for (HeadArrow ha : headArrowList)
							{
								if (ha.getStartX() == myRectangle.getX() + 20
										&& ha.getStartY() == myRectangle.getY() + 20)
								{
									startHeadArrowList.add(ha);
								}
							}

							for (HeadArrow ha : headArrowList)
							{
								if (ha.getEndX() == myRectangle.getX() + 20 && ha.getEndY() == myRectangle.getY() + 20)
								{
									endHeadArrowList.add(ha);
								}
							}

							if (!startHeadArrowList.isEmpty())
							{
								headArrowList.removeAll(startHeadArrowList);

								for (HeadArrow ha : startHeadArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!endHeadArrowList.isEmpty())
							{
								headArrowList.removeAll(endHeadArrowList);

								for (HeadArrow ha : endHeadArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							squareList.remove(myRectangle);
							mainPane.getChildren().remove(myRectangle);
							objectsDeleted += 1;
							setMiddleLabelText("Rectangle removed...");
							utilities.clearStartAndEndHeadArrowLists(startHeadArrowList, endHeadArrowList);
							break;
						}
					}

				}
				break;
			case "circle":
				if (event.getSceneY() > minusWidth + 10)
				{
					Circle c = new Circle(event.getSceneX(), event.getSceneY() - minusWidth, 20.0f,
							Paint.valueOf(circleColor));

					c.setStroke(Paint.valueOf("#555555"));
					c.setStrokeWidth(5.0f);
					mainPane.getChildren().add(c);
					c.setOnMousePressed(circleOnMousePressedEventHandler);
					setMiddleLabelText("Circle created...");
					circleList.add(c);
				}
				break;

			case "square":
				if (event.getSceneY() > minusWidth + 10)
				{
					Rectangle r = new Rectangle(event.getSceneX() - 20, event.getSceneY() - minusWidth - 20, 40.0f,
							40.0f);
					r.setFill(Paint.valueOf(rectangleColor));
					// r.setFill(Paint.valueOf("#ABCDEF"));
					r.setStroke(Paint.valueOf("#555555"));
					r.setStrokeWidth(5.0f);
					mainPane.getChildren().add(r);
					r.setOnMousePressed(squareOnMousePressedEventHandler);
					setMiddleLabelText("Rectangle created...");
					squareList.add(r);
				}
				break;

			case "line":
				if (event.getSceneY() > minusWidth + 10)
				{
					double x = event.getSceneX();
					double y = event.getSceneY();

					for (Circle myCircle : circleList)
					{
						if ((x > myCircle.getCenterX() - circleRay) && (x < myCircle.getCenterX() + circleRay)
								&& (y > myCircle.getCenterY() - circleRay + minusWidth)
								&& (y < myCircle.getCenterY() + circleRay + minusWidth))
						{
							if (_cFirstPosX == 0 && _cFirstPosY == 0)
							{
								_cFirstPosX = myCircle.getCenterX();
								_cFirstPosY = myCircle.getCenterY();
								setMiddleLabelText("First point of line...");
								secondObject = "rectangle";
								// mainPane.setOnMouseMoved(secondPointOfLineEventHandler);
								break;
							}

							if (_cFirstPosX != 0 && _cFirstPosY != 0 && secondObject == "circle")
							{
								_cSecPosX = myCircle.getCenterX();
								_cSecPosY = myCircle.getCenterY();

								HeadArrow headArrow = new HeadArrow(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY,
										mainPane);
								headArrow.setFill(arrowColor);
								headArrowList.add(headArrow);
								headArrow.addToMainPane(mainPane);
								Utilities.doubleBox(headArrow.returnAngle(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY));
								setMiddleLabelText("Second point of line...");
								_cFirstPosX = 0;
								_cFirstPosY = 0;
								_cSecPosX = 0;
								_cSecPosY = 0;
								secondObject = "";
								break;
							}

							if (_cFirstPosX != 0 && _cFirstPosY != 0 && secondObject == "rectangle")
							{
								setMiddleLabelText("Second object must be rectangle...");
							}
						}
					}

					for (Rectangle myRectangle : squareList)
					{
						if ((x > myRectangle.getX() + 20 - squareRay) && (x < myRectangle.getX() + 20 + squareRay)
								&& (y > myRectangle.getY() + 20 - squareRay + minusWidth)
								&& (y < myRectangle.getY() + 20 + squareRay + minusWidth))
						{
							if (_cFirstPosX == 0 && _cFirstPosY == 0)
							{
								_cFirstPosX = myRectangle.getX() + 20;
								_cFirstPosY = myRectangle.getY() + 20;
								setMiddleLabelText("First point of line...");
								// mainPane.setOnMouseMoved(secondPointOfLineEventHandler);
								secondObject = "circle";
								break;
							}

							if (_cFirstPosX != 0 && _cFirstPosY != 0 && secondObject == "rectangle")
							{
								_cSecPosX = myRectangle.getX() + 20;
								_cSecPosY = myRectangle.getY() + 20;

								HeadArrow headArrow = new HeadArrow(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY,
										mainPane);
								headArrow.setFill(arrowColor);
								headArrowList.add(headArrow);
								headArrow.addToMainPane(mainPane);

								setMiddleLabelText("Second point of line...");
								Utilities.doubleBox(headArrow.returnAngle(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY));
								_cFirstPosX = 0;
								_cFirstPosY = 0;
								_cSecPosX = 0;
								_cSecPosY = 0;
								secondObject = "";
								break;
							}
							if (_cFirstPosX != 0 && _cFirstPosY != 0 && secondObject == "circle")
							{
								setMiddleLabelText("Second object must be circle...");
							}
						}
					}
				}

		}

	}

	@FXML
	void mainPane_OnMouseDragged(MouseEvent event)
	{
		switch (selectedToggle)
		{
			case "move":
				int _it = 0;
				while (_it < utilities.takeMaximumFromLists(circleList, squareList, arrowList))
				{
					try
					{
						Object g = mainPane.getChildren().get(_it);
						if (g instanceof Circle)
						{
							((Circle) g).setOnMousePressed(circleOnMousePressedEventHandler);
							((Circle) g).setOnMouseDragged(circleOnMouseDraggedEventHandler);
							objectsMoved += 1;

						}

						if (g instanceof Rectangle)
						{
							((Rectangle) g).setOnMousePressed(squareOnMousePressedEventHandler);
							((Rectangle) g).setOnMouseDragged(squareOnMouseDraggedEventHandler);
							objectsMoved += 1;
						}

						_it += 1;
					} catch (Exception e)
					{
						e.getMessage();
					}

				}

				break;
		}
	}

	public void initialize()
	{
		mainWindowControllerConnectToDatabase();

		setBackgroundColor();

		initializeStats();

		middleLabel.setDisable(true);

		mainPane_AddEventHandlerClick();

		saveFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		openFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

		exportToPdf.setOnAction(exportPdf.exportToPdfEventHandler);

		utilities.clearAllLists(circleList, squareList, headArrowList);

		final ToggleGroup toggleButtonsGroup = new ToggleGroup();
		circleToggleButton.setToggleGroup(toggleButtonsGroup);
		squareToggleButton.setToggleGroup(toggleButtonsGroup);
		moveToggleButton.setToggleGroup(toggleButtonsGroup);
		lineToggleButton.setToggleGroup(toggleButtonsGroup);
		removeToggleButton.setToggleGroup(toggleButtonsGroup);

		circleToggleButton.setUserData("circle");
		squareToggleButton.setUserData("square");
		moveToggleButton.setUserData("move");
		lineToggleButton.setUserData("line");
		removeToggleButton.setUserData("remove");

		toggleButtonsGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
		{

			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle)
			{
				if (new_toggle == null)
					selectedToggle = "null";
				else
				{
					selectedToggle = (String) toggleButtonsGroup.getSelectedToggle().getUserData();
					if (selectedToggle == "circle")
						setMiddleLabelText("Drawing circles...");
					else if (selectedToggle == "square")
						setMiddleLabelText("Drawing squares...");
					else if (selectedToggle == "line")
						setMiddleLabelText("Drawing arrows...");
					else if (selectedToggle == "move")
						setMiddleLabelText("Moving objects...");
					else if (selectedToggle == "remove")
						setMiddleLabelText("Removing objects...");
				}

			}
		});

	}

	@FXML
	void exitMenuItem_OnAction(ActionEvent event)
	{
		Utilities.exitFromApplication();
	}

	@FXML
	void settingsMenuItem_OnAction(ActionEvent event)
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Settings.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 300, 300);
			scene.getStylesheets().add(getClass().getResource("settings.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Settings");
			stage.setScene(scene);
			stage.getIcons()
					.add(new Image(MainWindowController.class.getResourceAsStream("resources/settings-icon.png")));
			stage.show();
			stage.setOnHiding(closeWindow);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	EventHandler<WindowEvent> closeWindow = new EventHandler<WindowEvent>()
	{

		@Override
		public void handle(WindowEvent event)
		{
			mainWindowControllerConnectToDatabase();
			setBackgroundColor();
			setCircleColor();
			setRectangleColor();
			setArrowColor();

		}
	};

	public enum StageFactory
	{
		INSTANCE;

		private final ObservableList<Stage> openStages = FXCollections.observableArrayList();

		public ObservableList<Stage> getOpenStages()
		{
			return openStages;
		}

		private final ObjectProperty<Stage> currentStage = new SimpleObjectProperty<>(null);

		public final ObjectProperty<Stage> currentStageProperty()
		{
			return this.currentStage;
		}

		public final javafx.stage.Stage getCurrentStage()
		{
			return this.currentStageProperty().get();
		}

		public final void setCurrentStage(final javafx.stage.Stage currentStage)
		{
			this.currentStageProperty().set(currentStage);
		}

		public void registerStage(Stage stage)
		{
			stage.addEventHandler(WindowEvent.WINDOW_SHOWN, e -> openStages.add(stage));
			stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, e -> openStages.remove(stage));
			stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) ->
			{
				if (isNowFocused)
				{
					currentStage.set(stage);
				} else
				{
					currentStage.set(null);
				}
			});
		}

		public Stage createStage()
		{
			Stage stage = new Stage();
			registerStage(stage);
			return stage;
		}

	}

	@FXML
	void saveFileMenuItem_OnAction(ActionEvent event)
	{
		Stage s = Main.getPrimaryStage();
		fileManager.SaveFile(s, circleList, squareList, headArrowList);
		Boolean fileSaved = fileManager.getSomethingSaved();
		if (fileSaved)
		{
			setMiddleLabelText("File saved...");

		}
	}

	@FXML
	void openFileMenuItem_OnAction(ActionEvent event)
	{

		for (Circle c : circleList)
		{
			mainPane.getChildren().remove(c);
		}

		for (Rectangle r : squareList)
		{
			mainPane.getChildren().remove(r);
		}

		for (HeadArrow ha : headArrowList)
		{
			ha.removeFromMainPane(mainPane);
		}
		utilities.clearAllLists(circleList, squareList, headArrowList);

		Stage s = Main.getPrimaryStage();
		circleList.clear();
		squareList.clear();
		fileManager.OpenFile(s, circleList, squareList, headArrowList, mainPane);

		for (Circle c : circleList)
		{
			mainPane.getChildren().add(c);
			c.setOnMousePressed(circleOnMousePressedEventHandler);
			c.setOnMouseDragged(circleOnMouseDraggedEventHandler);
		}

		for (Rectangle r : squareList)
		{
			mainPane.getChildren().add(r);
			r.setOnMousePressed(squareOnMousePressedEventHandler);
			r.setOnMouseDragged(squareOnMouseDraggedEventHandler);
		}

		for (HeadArrow ha : headArrowList)
		{
			ha.addToMainPane(mainPane);
		}

		Boolean fileOpened = fileManager.getSomethingOpened();
		if (fileOpened)
		{
			setMiddleLabelText("File opened...");
			mainWindowControllerConnectToDatabase();
			setBackgroundColor();
			setCircleColor();
			setArrowColor();
			setRectangleColor();

		}

	}

	@FXML
	void clearAllButton_OnMouseClicked(MouseEvent event)
	{
		utilities.clearUpMessage(mainPane, "Question", "Clear all elements", "Are you sure?", circleList, squareList,
				headArrowList);
		if (utilities.checkCleared)
		{
			counters.circleCounter(circleList, numberOfCirclesCreatedL);
			counters.rectangleCounter(squareList, numberOfRectanglesCreatedL);
			counters.headArrowCounter(headArrowList, numberOfArrowsCreatedL);
			setMiddleLabelText("Cleared...");
		} else
		{
			setMiddleLabelText("");
		}
	}

	@FXML
	void mainPane_OnDragDropped(MouseEvent event)
	{
		// nic
	}

	@FXML
	void mainPane_OnMouseReseased(MouseEvent event)
	{

	}

	@FXML
	void mainPane_OnMouseMoved(MouseEvent event)
	{

	}

	@FXML
	void aboutMenuItem_OnAction(ActionEvent event)
	{
		try
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About Box");
			alert.setHeaderText("Using Chernikova's Algorithm");
			alert.setContentText("You have actions to execute:\n" + "1. Create circle\n" + "You can create a circle\n\n"
					+ "2. Create rectangle\n" + "You can create a rectangle\n\n" + "3. Create line\n"
					+ "You can create a line\n\n" + "4. Move\n" + "You can move a created object\n\n"
					+ "5. Delete object\n" + "You can delete a created object\n\n" + "6. Clear all\n"
					+ "You can clear all lists and all visible objects\n");

			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(this.getClass().getResource("resources/yellowbulb.jpg").toString()));
			alert.show();
		} catch (Exception e)
		{
			e.fillInStackTrace();
		}
	}

	protected void initializeStats()
	{
		Label objects = new Label("Objects");
		objects.setFont(Font.font("Arial", 30));
		objects.setAlignment(Pos.CENTER);

		Label interactions = new Label("Interactions");
		interactions.setFont(Font.font("Arial", 30));
		interactions.setAlignment(Pos.CENTER);

		Separator separator1 = new Separator();
		separator1.setOrientation(Orientation.HORIZONTAL);
		separator1.setMinWidth(100.0);
		Separator separator2 = new Separator();
		separator2.setOrientation(Orientation.HORIZONTAL);
		separator2.setMinWidth(100.0);

		GridPane grid = new GridPane();
		grid.getColumnConstraints().add(new ColumnConstraints(180));
		grid.setVgap(5);
		GridPane.setHalignment(objects, HPos.RIGHT);
		GridPane.setHalignment(interactions, HPos.RIGHT);
		GridPane.setHalignment(circlesCreatedL, HPos.RIGHT);
		GridPane.setHalignment(rectanglesCreatedL, HPos.RIGHT);
		GridPane.setHalignment(arrowsCreatedL, HPos.RIGHT);
		GridPane.setHalignment(mouseBothClickL, HPos.RIGHT);
		GridPane.setHalignment(mouseLeftClickL, HPos.RIGHT);
		GridPane.setHalignment(mouseRightClickL, HPos.RIGHT);
		GridPane.setHalignment(objectsDeletedL, HPos.RIGHT);
		GridPane.setHalignment(objectsMovedL, HPos.RIGHT);

		grid.setPadding(new Insets(5, 5, 5, 5));

		grid.add(objects, 0, 0);
		grid.add(circlesCreatedL, 0, 1);
		grid.add(numberOfCirclesCreatedL, 1, 1);

		grid.add(rectanglesCreatedL, 0, 2);
		grid.add(numberOfRectanglesCreatedL, 1, 2);

		grid.add(arrowsCreatedL, 0, 3);
		grid.add(numberOfArrowsCreatedL, 1, 3);

		grid.add(separator1, 0, 4);
		grid.add(separator2, 1, 4);

		grid.add(interactions, 0, 5);

		grid.add(mouseBothClickL, 0, 6);
		grid.add(numberOfMouseBothClickL, 1, 6);

		grid.add(mouseRightClickL, 0, 7);
		grid.add(numberOfMouseRightClickL, 1, 7);

		grid.add(mouseLeftClickL, 0, 8);
		grid.add(numberOfMouseLeftClickL, 1, 8);

		grid.add(objectsDeletedL, 0, 9);
		grid.add(numberOfObjectsDeletedL, 1, 9);

		grid.add(objectsMovedL, 0, 10);
		grid.add(numberOfObjectsMovedL, 1, 10);

		grid.add(exportToPdf, 0, 11);

		titledPaneStats.setContent(grid);

	}

	protected void mainPane_AddEventHandlerClick()
	{
		mainPane.addEventFilter(MouseEvent.MOUSE_PRESSED, e ->
		{

			if (e.isPrimaryButtonDown() && e.isSecondaryButtonDown())
			{
				mouseBothClicked += 1;
			} else if (e.isPrimaryButtonDown())
			{
				mouseRightClicked += 1;
			} else if (e.isSecondaryButtonDown())
			{
				mouseLeftClicked += 1;
			}

		});
	}

	protected void refreshLine()
	{
		mainPane.getChildren().remove(circleList.size() + squareList.size() + headArrowList.size() - 2);
		mainPane.getChildren().remove(circleList.size() + squareList.size() + headArrowList.size() - 2);
		mainPane.getChildren().remove(circleList.size() + squareList.size() + headArrowList.size() - 2);
		headArrowList.remove(headArrowList.size() - 1);
	}

	private void mainWindowControllerConnectToDatabase()
	{
		ConnectToDatabase ctd = new ConnectToDatabase();
		ctd.Connect();
		backgroundColor = ctd.getBackgroundString();
		rectangleColor = ctd.getRectangleString();
		circleColor = ctd.getCircleString();
		arrowColor = ctd.getArrowString();
	}

	public void setBackgroundColor()
	{
		mainPane.setStyle("-fx-background-color: " + backgroundColor);
	}

	protected void setCircleColor()
	{

		for (Circle c : circleList)
		{
			c.setFill(Paint.valueOf(circleColor));
		}

	}

	protected void setRectangleColor()
	{

		for (Rectangle r : squareList)
		{
			r.setFill(Paint.valueOf(rectangleColor));
		}
	}

	protected void setArrowColor()
	{
		for (HeadArrow ha : headArrowList)
		{
			ha.setFill(headArrowList, arrowColor);
		}
	}

	public String getArrowColor()
	{
		return this.arrowColor;
	}

	public final Pane pane()
	{
		return this.mainPane;
	}

}