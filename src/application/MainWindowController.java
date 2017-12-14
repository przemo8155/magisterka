
package application;

//tix

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
import javafx.geometry.Rectangle2D;
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
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.util.Pair;
import javafx.*;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
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
	protected int startingFaze = 0;

	public static String optPath = "";
	public static String checkFileRecognition = "";

	private static int labelInTokensRay = 15;

	static double ll = 15;

	public static Stage aptStage;

	static double moveArrowWithoutHead = 5.0f;

	static int doubleArrowMove = 100;
	String selectedToggle = "";
	String idObj = "";
	int circleId = 0;
	String secondObject = "";

	final String cannotExecuteTransition = "Cannot execute transition...";

	int mouseBothClicked = 0, mouseRightClicked = 0, mouseLeftClicked = 0;
	int objectsDeleted = 0, objectsMoved = 0;

	Scale scaleTransform;
	Group zoomGroup;

	static int circleRay = 30, squareRay = 40, arrowRay = 30;

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

	Label doubleArrowsCreatedL = new Label("Double arrows created: ");
	Label numberOfDoubleArrowsCreatedL = new Label("0");

	Label tagsCreatedL = new Label("Tags created: ");
	Label numberOfTagsCreatedL = new Label("0");

	Label tokensCreatedL = new Label("Tokens created: ");
	Label numberOfTokensCreatedL = new Label("0");

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

	ObservableList<Label> allStatsLabels = FXCollections.observableArrayList();

	final ToggleGroup toggleButtonsGroup = new ToggleGroup();

	Utilities utilities = new Utilities();
	FileManager fileManager = new FileManager();
	Main main = new Main();
	SettingsController settingsController = new SettingsController();
	Counters counters = new Counters();
	ConnectToDatabase connectToDatabase = new ConnectToDatabase();
	ExportPDF exportPdf = new ExportPDF();
	LeftDoubleArrow doubleArrow = new LeftDoubleArrow();
	AnimationSchedules animationsSchedules = new AnimationSchedules();
	LeftDoubleArrow lda_t;

	private String backgroundColor;
	private String circleColor;
	private String rectangleColor;
	private String arrowColor;

	private Boolean deleteSecondOfEndLine = false;

	Alert statisticsAlert = new Alert(Alert.AlertType.INFORMATION);

	ObservableList<Circle> circleList = FXCollections.observableArrayList();
	ObservableList<Rectangle> rectangleList = FXCollections.observableArrayList();
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

	ObservableList<LeftDoubleArrow> leftDoubleArrowList = FXCollections.observableArrayList();
	ObservableList<LeftDoubleArrow> leftEndDoubleArrowList = FXCollections.observableArrayList();
	ObservableList<LeftDoubleArrow> leftStartDoubleArrowList = FXCollections.observableArrayList();

	ObservableList<RightDoubleArrow> rightDoubleArrowList = FXCollections.observableArrayList();
	ObservableList<RightDoubleArrow> rightEndDoubleArrowList = FXCollections.observableArrayList();
	ObservableList<RightDoubleArrow> rightStartDoubleArrowList = FXCollections.observableArrayList();

	Map<Circle, Integer> circleTokensMap = new HashMap<Circle, Integer>();
	Map<Rectangle, Integer> rectangleTokensMap = new HashMap<Rectangle, Integer>();

	ObservableList<ImageView> existingImageViews = FXCollections.observableArrayList();
	ObservableList<ImageView> imageViewsToRemove = FXCollections.observableArrayList();
	ObservableList<Label> tokensBiggerThanTen = FXCollections.observableArrayList();

	ObservableList<Label> tags = FXCollections.observableArrayList();

	ObservableList<Label> tagsToRemove = FXCollections.observableArrayList();

	Map<Label, HeadArrow> headArrowTags = new LinkedHashMap<Label, HeadArrow>();
	Map<Label, HeadArrow> moveHeadArrowTags = new LinkedHashMap<Label, HeadArrow>();

	Map<Label, LeftDoubleArrow> leftDoubleArrowTags = new LinkedHashMap<Label, LeftDoubleArrow>();
	Map<Label, RightDoubleArrow> rightDoubleArrowTags = new LinkedHashMap<Label, RightDoubleArrow>();
	Map<Label, LeftDoubleArrow> moveLeftDoubleArrowTags = new LinkedHashMap<Label, LeftDoubleArrow>();
	Map<Label, RightDoubleArrow> moveRightDoubleArrowTags = new LinkedHashMap<Label, RightDoubleArrow>();

	ObservableList<FourDimensionObject> dimensionMinusHeadArrow = FXCollections.observableArrayList();
	ObservableList<FourDimensionObject> dimensionPlusHeadArrow = FXCollections.observableArrayList();

	ObservableList<FourDimensionLeftObject> dimensionMinusLeftDoubleArrow = FXCollections.observableArrayList();
	ObservableList<FourDimensionLeftObject> dimensionPlusLeftDoubleArrow = FXCollections.observableArrayList();

	ObservableList<FourDimensionRightObject> dimensionMinusRightDoubleArrow = FXCollections.observableArrayList();
	ObservableList<FourDimensionRightObject> dimensionPlusRightDoubleArrow = FXCollections.observableArrayList();

	@FXML
	private TitledPane titledPaneStats;

	@FXML
	private Accordion accordionStats;

	@FXML
	private MenuItem exportPdfMenuItem;

	@FXML
	private MenuItem showStatisticsMenuItem;

	@FXML
	private MenuItem compareNetsMenuItem;

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
	private MenuItem openAPTFileMenuItem;

	@FXML
	private Button clearAllButton;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	public Pane mainPane;

	@FXML
	private ToggleButton squareToggleButton, circleToggleButton, moveToggleButton, lineToggleButton, removeToggleButton,
			removeTokenToggleButton, addTokenToggleButton, addTagToggleButton, removeTagToggleButton;

	@FXML
	private ToggleButton startAnimationToggleButton, pauseAnimationToggleButton;

	@FXML
	private Button stopAnimationButton;

	@FXML
	private Separator toggleButtonSeparator1, toggleButtonSeparator2, toggleButtonSeparator3, toggleButtonSeparator4;

	@FXML
	private Label middleLabel;

	@FXML
	Parent root;

	// tokens
	public static Image imageToken1 = new Image("tokens/token_1.png");
	public static Image imageToken2 = new Image("tokens/token_2.png");
	public static Image imageToken3 = new Image("tokens/token_3.png");
	public static Image imageToken4 = new Image("tokens/token_4.png");
	public static Image imageToken5 = new Image("tokens/token_5.png");
	public static Image imageToken6 = new Image("tokens/token_6.png");
	public static Image imageToken7 = new Image("tokens/token_7.png");
	public static Image imageToken8 = new Image("tokens/token_8.png");
	public static Image imageToken9 = new Image("tokens/token_9.png");

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

				ImageView selectedImageView = null;
				Label selectedLabel = null;

				for (ImageView iv : existingImageViews)
				{
					if (iv.getLayoutX() == c.getCenterX() - 20 && iv.getLayoutY() == c.getCenterY() - 20)
					{
						selectedImageView = iv;
						break;
					}
				}

				for (Label l : tokensBiggerThanTen)
				{
					if (l.getLayoutX() == c.getCenterX() - 15 && l.getLayoutY() == c.getCenterY() - 15)
					{
						selectedLabel = l;
						break;
					}
				}

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getStartX() == c.getCenterX() && ha.getStartY() == c.getCenterY())
					{
						startHeadArrowList.add(ha);
						for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
						{
							if (ha.equals(entry.getValue()))
							{
								moveHeadArrowTags.put(entry.getKey(), ha);
							}
						}
					}

				}

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getEndX() == c.getCenterX() && ha.getEndY() == c.getCenterY())
					{
						endHeadArrowList.add(ha);
						for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
						{
							if (ha.equals(entry.getValue()))
							{
								moveHeadArrowTags.put(entry.getKey(), ha);
							}
						}

					}

				}

				for (LeftDoubleArrow da : leftDoubleArrowList)
				{
					if (da.getStartX() == c.getCenterX() && da.getStartY() == c.getCenterY())
					{
						leftStartDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveLeftDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				for (LeftDoubleArrow da : leftDoubleArrowList)
				{
					if (da.getEndX() == c.getCenterX() && da.getEndY() == c.getCenterY())
					{
						leftEndDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveLeftDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				for (RightDoubleArrow da : rightDoubleArrowList)
				{
					if (da.getStartX() == c.getCenterX() && da.getStartY() == c.getCenterY())
					{
						rightStartDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveRightDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				for (RightDoubleArrow da : rightDoubleArrowList)
				{
					if (da.getEndX() == c.getCenterX() && da.getEndY() == c.getCenterY())
					{
						rightEndDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveRightDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				headArrowList.removeAll(startHeadArrowList);
				headArrowList.removeAll(endHeadArrowList);

				leftDoubleArrowList.removeAll(leftStartDoubleArrowList);
				leftDoubleArrowList.removeAll(leftEndDoubleArrowList);

				rightDoubleArrowList.removeAll(rightStartDoubleArrowList);
				rightDoubleArrowList.removeAll(rightEndDoubleArrowList);

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

				for (LeftDoubleArrow da : leftStartDoubleArrowList)
				{
					da.setLeftArrowStartX(c.getCenterX(), mainPane);
					da.setLeftArrowStartY(c.getCenterY(), mainPane);
					da.setLeft(c.getCenterX(), c.getCenterY(), mainPane);
					da.setRight(c.getCenterX(), c.getCenterY(), mainPane);
					da.setFill(arrowColor);
				}

				for (LeftDoubleArrow da : leftEndDoubleArrowList)
				{
					da.setLeftArrowEndX(c.getCenterX(), mainPane);
					da.setLeftArrowEndY(c.getCenterY(), mainPane);
					da.setLeft(c.getCenterX(), c.getCenterY(), mainPane);
					da.setRight(c.getCenterX(), c.getCenterY(), mainPane);
					da.setFill(arrowColor);
				}

				for (RightDoubleArrow da : rightStartDoubleArrowList)
				{
					da.setRightArrowStartX(c.getCenterX(), mainPane);
					da.setRightArrowStartY(c.getCenterY(), mainPane);
					da.setLeft(c.getCenterX(), c.getCenterY(), mainPane);
					da.setRight(c.getCenterX(), c.getCenterY(), mainPane);
					da.setFill(arrowColor);
				}

				for (RightDoubleArrow da : rightEndDoubleArrowList)
				{
					da.setRightArrowEndX(c.getCenterX(), mainPane);
					da.setRightArrowEndY(c.getCenterY(), mainPane);
					da.setLeft(c.getCenterX(), c.getCenterY(), mainPane);
					da.setRight(c.getCenterX(), c.getCenterY(), mainPane);
					da.setFill(arrowColor);
				}

				for (Map.Entry<Label, HeadArrow> entry : moveHeadArrowTags.entrySet())
				{
					Label l = entry.getKey();
					HeadArrow ha = entry.getValue();
					Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double midX = pair.getKey();
					double midY = pair.getValue();
					Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double mvX = pair2.getKey() / 5;
					double mvY = pair2.getValue() / 5;
					l.setLayoutX(midX + mvX);
					l.setLayoutY(midY + mvY);
				}

				for (Map.Entry<Label, LeftDoubleArrow> entry : moveLeftDoubleArrowTags.entrySet())
				{
					Label l = entry.getKey();
					LeftDoubleArrow ha = entry.getValue();
					Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double midX = pair.getKey();
					double midY = pair.getValue();
					Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double mvX = pair2.getKey();
					double mvY = pair2.getValue();
					l.setLayoutX(midX + mvX);
					l.setLayoutY(midY + mvY);
				}

				for (Map.Entry<Label, RightDoubleArrow> entry : moveRightDoubleArrowTags.entrySet())
				{
					Label l = entry.getKey();
					RightDoubleArrow ha = entry.getValue();
					Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double midX = pair.getKey();
					double midY = pair.getValue();
					Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double mvX = pair2.getKey();
					double mvY = pair2.getValue();
					l.setLayoutX(midX - mvX);
					l.setLayoutY(midY - mvY);
				}

				headArrowList.addAll(startHeadArrowList);
				headArrowList.addAll(endHeadArrowList);

				leftDoubleArrowList.addAll(leftStartDoubleArrowList);
				leftDoubleArrowList.addAll(leftEndDoubleArrowList);

				rightDoubleArrowList.addAll(rightStartDoubleArrowList);
				rightDoubleArrowList.addAll(rightEndDoubleArrowList);

				utilities.clearStartAndEndHeadArrowLists(startHeadArrowList, endHeadArrowList);
				utilities.clearStartAndEndLeftDoubleArrowLists(leftStartDoubleArrowList, leftEndDoubleArrowList);
				utilities.clearStartAndEndRightDoubleArrowLists(rightStartDoubleArrowList, rightEndDoubleArrowList);

				moveHeadArrowTags.clear();
				moveLeftDoubleArrowTags.clear();
				moveRightDoubleArrowTags.clear();

				for (HeadArrow ha : headArrowList)
				{
					ha.setFill(arrowColor);
				}

				if (selectedImageView != null)
				{
					selectedImageView.setLayoutX(c.getCenterX() - 20);
					selectedImageView.setLayoutY(c.getCenterY() - 20);

				}

				if (selectedLabel != null)
				{
					selectedLabel.setLayoutX(c.getCenterX() - 15);
					selectedLabel.setLayoutY(c.getCenterY() - 15);
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
				int index = rectangleList.indexOf(r);

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getStartX() - 20 == r.getX() && ha.getStartY() - 20 == r.getY())
					{
						startHeadArrowList.add(ha);
						for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
						{
							if (ha.equals(entry.getValue()))
							{
								moveHeadArrowTags.put(entry.getKey(), ha);
							}
						}
					}
				}

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getEndX() - 20 == r.getX() && ha.getEndY() - 20 == r.getY())
					{
						endHeadArrowList.add(ha);
						for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
						{
							if (ha.equals(entry.getValue()))
							{
								moveHeadArrowTags.put(entry.getKey(), ha);
							}
						}
					}
				}

				for (LeftDoubleArrow da : leftDoubleArrowList)
				{
					if (da.getStartX() - 20 == r.getX() && da.getStartY() - 20 == r.getY())
					{
						leftStartDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveLeftDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				for (LeftDoubleArrow da : leftDoubleArrowList)
				{
					if (da.getEndX() - 20 == r.getX() && da.getEndY() - 20 == r.getY())
					{
						leftEndDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveLeftDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				for (RightDoubleArrow da : rightDoubleArrowList)
				{
					if (da.getStartX() - 20 == r.getX() && da.getStartY() - 20 == r.getY())
					{
						rightStartDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveRightDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				for (RightDoubleArrow da : rightDoubleArrowList)
				{
					if (da.getEndX() - 20 == r.getX() && da.getEndY() - 20 == r.getY())
					{
						rightEndDoubleArrowList.add(da);
						da.setFill(arrowColor);
						for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
						{
							if (da.equals(entry.getValue()))
							{
								moveRightDoubleArrowTags.put(entry.getKey(), da);
							}
						}
					}
				}

				headArrowList.removeAll(startHeadArrowList);
				headArrowList.removeAll(endHeadArrowList);

				leftDoubleArrowList.removeAll(leftStartDoubleArrowList);
				leftDoubleArrowList.removeAll(leftEndDoubleArrowList);

				rightDoubleArrowList.removeAll(rightStartDoubleArrowList);
				rightDoubleArrowList.removeAll(rightEndDoubleArrowList);

				double offsetX = t.getSceneX() - orgSceneX;
				double offsetY = t.getSceneY() - orgSceneY;
				double newTranslateX = orgTranslateX + offsetX;
				double newTranslateY = orgTranslateY + offsetY;

				r.setX(newTranslateX);
				r.setY(newTranslateY);

				rectangleList.set(index, r);

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

				for (LeftDoubleArrow da : leftStartDoubleArrowList)
				{
					da.setLeftArrowStartX(r.getX() + 20, mainPane);
					da.setLeftArrowStartY(r.getY() + 20, mainPane);
					da.setLeft(r.getX() + 20, r.getY() + 20, mainPane);
					da.setRight(r.getX() + 20, r.getY() + 20, mainPane);
					da.setFill(arrowColor);
				}

				for (LeftDoubleArrow da : leftEndDoubleArrowList)
				{
					da.setLeftArrowEndX(r.getX() + 20, mainPane);
					da.setLeftArrowEndY(r.getY() + 20, mainPane);
					da.setLeft(r.getX() + 20, r.getY() + 20, mainPane);
					da.setRight(r.getX() + 20, r.getY() + 20, mainPane);
					da.setFill(arrowColor);
				}

				for (RightDoubleArrow da : rightStartDoubleArrowList)
				{
					da.setRightArrowStartX(r.getX() + 20, mainPane);
					da.setRightArrowStartY(r.getY() + 20, mainPane);
					da.setLeft(r.getX() + 20, r.getY() + 20, mainPane);
					da.setRight(r.getX() + 20, r.getY() + 20, mainPane);
					da.setFill(arrowColor);
				}

				for (RightDoubleArrow da : rightEndDoubleArrowList)
				{
					da.setRightArrowEndX(r.getX() + 20, mainPane);
					da.setRightArrowEndY(r.getY() + 20, mainPane);
					da.setLeft(r.getX() + 20, r.getY() + 20, mainPane);
					da.setRight(r.getX() + 20, r.getY() + 20, mainPane);
					da.setFill(arrowColor);
				}

				for (Map.Entry<Label, HeadArrow> entry : moveHeadArrowTags.entrySet())
				{
					Label l = entry.getKey();
					HeadArrow ha = entry.getValue();
					Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double midX = pair.getKey();
					double midY = pair.getValue();
					Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double mvX = pair2.getKey() / 5;
					double mvY = pair2.getValue() / 5;
					l.setLayoutX(midX + mvX);
					l.setLayoutY(midY + mvY);
				}

				for (Map.Entry<Label, LeftDoubleArrow> entry : moveLeftDoubleArrowTags.entrySet())
				{
					Label l = entry.getKey();
					LeftDoubleArrow ha = entry.getValue();
					Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double midX = pair.getKey();
					double midY = pair.getValue();
					Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double mvX = pair2.getKey();
					double mvY = pair2.getValue();
					l.setLayoutX(midX + mvX);
					l.setLayoutY(midY + mvY);
				}

				for (Map.Entry<Label, RightDoubleArrow> entry : moveRightDoubleArrowTags.entrySet())
				{
					Label l = entry.getKey();
					RightDoubleArrow ha = entry.getValue();
					Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double midX = pair.getKey();
					double midY = pair.getValue();
					Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getStartX(), ha.getStartY(),
							ha.getEndX(), ha.getEndY());
					double mvX = pair2.getKey();
					double mvY = pair2.getValue();
					l.setLayoutX(midX - mvX);
					l.setLayoutY(midY - mvY);
				}

				headArrowList.addAll(startHeadArrowList);
				headArrowList.addAll(endHeadArrowList);

				leftDoubleArrowList.addAll(leftStartDoubleArrowList);
				leftDoubleArrowList.addAll(leftEndDoubleArrowList);

				rightDoubleArrowList.addAll(rightStartDoubleArrowList);
				rightDoubleArrowList.addAll(rightEndDoubleArrowList);

				utilities.clearStartAndEndHeadArrowLists(startHeadArrowList, endHeadArrowList);
				utilities.clearStartAndEndLeftDoubleArrowLists(leftStartDoubleArrowList, leftEndDoubleArrowList);
				utilities.clearStartAndEndRightDoubleArrowLists(rightStartDoubleArrowList, rightEndDoubleArrowList);

				moveHeadArrowTags.clear();
				moveLeftDoubleArrowTags.clear();
				moveRightDoubleArrowTags.clear();

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
		counters.rectangleCounter(rectangleList, numberOfRectanglesCreatedL);
		counters.headArrowCounter(headArrowList, numberOfArrowsCreatedL);
		counters.mouseClickerCounter(mouseBothClicked, numberOfMouseBothClickL);
		counters.mouseClickerCounter(mouseRightClicked, numberOfMouseRightClickL);
		counters.mouseClickerCounter(mouseLeftClicked, numberOfMouseLeftClickL);
		counters.doubleArrowsCounter(leftDoubleArrowList, numberOfDoubleArrowsCreatedL);
		counters.objDeleted(objectsDeleted, numberOfObjectsDeletedL);
		counters.objDeleted(objectsMoved, numberOfObjectsMovedL);
		counters.tagsCounter(tags, numberOfTagsCreatedL);
		counters.tokensCounter(tokensBiggerThanTen, existingImageViews, numberOfTokensCreatedL);
	}

	@FXML
	void mainPane_OnMouseClicked(MouseEvent event)
	{

		switch (selectedToggle)
		{
			case "play":
				boolean canRunTransition = true;
				FourDimensionObject fdo_temp = null;
				FourDimensionLeftObject fdo_left_temp = null;
				FourDimensionRightObject fdo_right_temp = null;
				// Colors
				javafx.scene.paint.Color active = javafx.scene.paint.Color.INDIANRED;
				javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;
				Shadow s = new Shadow();
				s.setRadius(10.0f);
				s.setColor(active);

				for (Rectangle r : rectangleList)
				{
					if ((event.getSceneX() + squareRay > r.getX() + 20)
							&& (event.getSceneX() - squareRay < r.getX() + 20)
							&& (event.getSceneY() + squareRay - minusWidth > r.getY() + 20)
							&& (event.getSceneY() - squareRay - minusWidth < r.getY() + 20))
					{
						for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
						{
							if (entry.getValue().getStartX() == r.getX() + 20
									&& entry.getValue().getStartY() == r.getY() + 20)
							{
								for (Circle c : circleList)
								{
									if (entry.getValue().getEndX() == c.getCenterX()
											&& entry.getValue().getEndY() == c.getCenterY())
									{
										for (HeadArrow ha : headArrowList)
										{
											if (ha.equals(entry.getValue()))
											{
												dimensionPlusHeadArrow
														.add(new FourDimensionObject(r, ha, entry.getKey(), c));
											}
										}

									}
								}
							}

							if (entry.getValue().getEndX() == r.getX() + 20
									&& entry.getValue().getEndY() == r.getY() + 20)
							{
								for (Circle c : circleList)
								{
									if (entry.getValue().getStartX() == c.getCenterX()
											&& entry.getValue().getStartY() == c.getCenterY())
									{
										for (HeadArrow ha : headArrowList)
										{
											if (ha.equals(entry.getValue()))
											{
												dimensionMinusHeadArrow
														.add(new FourDimensionObject(r, ha, entry.getKey(), c));
											}
										}

									}
								}
							}
						}

						for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
						{
							if (entry.getValue().getStartX() == r.getX() + 20
									&& entry.getValue().getStartY() == r.getY() + 20)
							{
								for (Circle c : circleList)
								{
									if (entry.getValue().getEndX() == c.getCenterX()
											&& entry.getValue().getEndY() == c.getCenterY())
									{
										for (LeftDoubleArrow ha : leftDoubleArrowList)
										{
											if (ha.equals(entry.getValue()))
											{
												dimensionPlusLeftDoubleArrow
														.add(new FourDimensionLeftObject(r, ha, entry.getKey(), c));
											}
										}

									}
								}
							}

							if (entry.getValue().getEndX() == r.getX() + 20
									&& entry.getValue().getEndY() == r.getY() + 20)
							{
								for (Circle c : circleList)
								{
									if (entry.getValue().getStartX() == c.getCenterX()
											&& entry.getValue().getStartY() == c.getCenterY())
									{
										for (LeftDoubleArrow ha : leftDoubleArrowList)
										{
											if (ha.equals(entry.getValue()))
											{
												dimensionMinusLeftDoubleArrow
														.add(new FourDimensionLeftObject(r, ha, entry.getKey(), c));
											}
										}

									}
								}
							}
						}

						for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
						{
							if (entry.getValue().getStartX() == r.getX() + 20
									&& entry.getValue().getStartY() == r.getY() + 20)
							{
								for (Circle c : circleList)
								{
									if (entry.getValue().getEndX() == c.getCenterX()
											&& entry.getValue().getEndY() == c.getCenterY())
									{
										for (RightDoubleArrow ha : rightDoubleArrowList)
										{
											if (ha.equals(entry.getValue()))
											{
												dimensionPlusRightDoubleArrow
														.add(new FourDimensionRightObject(r, ha, entry.getKey(), c));
											}
										}

									}
								}
							}

							if (entry.getValue().getEndX() == r.getX() + 20
									&& entry.getValue().getEndY() == r.getY() + 20)
							{
								for (Circle c : circleList)
								{
									if (entry.getValue().getStartX() == c.getCenterX()
											&& entry.getValue().getStartY() == c.getCenterY())
									{
										for (RightDoubleArrow ha : rightDoubleArrowList)
										{
											if (ha.equals(entry.getValue()))
											{
												dimensionMinusRightDoubleArrow
														.add(new FourDimensionRightObject(r, ha, entry.getKey(), c));
											}
										}

									}
								}
							}
						}

					}
					for (FourDimensionObject fdo : dimensionMinusHeadArrow)
					{
						Circle c = fdo.getC();
						Label l = fdo.getL();
						HeadArrow ha = fdo.getHa();
						double positionX = c.getCenterX() - 20;
						double positionY = c.getCenterY() - 20;
						int i = checkBitmapToken(positionX, positionY);
						String labValS = l.getText();
						int tagValue = Integer.parseInt(labValS);

						if (tagValue > i)
						{
							canRunTransition = false;
							animationWhoCantBeExecuteHeadArrow(c, l, ha, r);
							fdo_temp = fdo;
						}

					}

					for (FourDimensionLeftObject fdo : dimensionMinusLeftDoubleArrow)
					{
						Circle c = fdo.getC();
						Label l = fdo.getL();
						LeftDoubleArrow ha = fdo.getHa();
						double positionX = c.getCenterX() - 20;
						double positionY = c.getCenterY() - 20;
						int i = checkBitmapToken(positionX, positionY);
						String labValS = l.getText();
						int tagValue = Integer.parseInt(labValS);

						if (tagValue > i)
						{
							canRunTransition = false;
							animationWhoCantBeExecuteLeftDoubleArrow(c, l, ha, r);
							fdo_left_temp = fdo;
						}
					}

					for (FourDimensionRightObject fdo : dimensionMinusRightDoubleArrow)
					{
						Circle c = fdo.getC();
						Label l = fdo.getL();
						RightDoubleArrow ha = fdo.getHa();
						double positionX = c.getCenterX() - 20;
						double positionY = c.getCenterY() - 20;
						int i = checkBitmapToken(positionX, positionY);
						String labValS = l.getText();
						int tagValue = Integer.parseInt(labValS);

						if (tagValue > i)
						{
							canRunTransition = false;
							animationWhoCantBeExecuteRightDoubleArrow(c, l, ha, r);
							fdo_right_temp = fdo;
						}
					}

					if (canRunTransition)
					{
						for (FourDimensionObject fdo : dimensionPlusHeadArrow)
						{
							Circle c = fdo.getC();
							Label l = fdo.getL();
							HeadArrow ha = fdo.getHa();
							double positionX = c.getCenterX() - 20;
							double positionY = c.getCenterY() - 20;
							int i = checkBitmapToken(positionX, positionY);
							String labValS = l.getText();
							int tagValue = Integer.parseInt(labValS);
							animationPlusHeadArrow(c, l, ha, r, i, tagValue);
							if (i != 0 && i < 10)
							{
								deleteBitmapToken(positionX, positionY);
								setBitmapToken(c, i + tagValue);

							} else if (i != 0 && i >= 10)
							{
								deleteTokenBiggerThanTen(positionX, positionY);
								setBitmapToken(c, i + tagValue - 1);
							}

							else
							{
								i += tagValue;
								setBitmapToken(c, tagValue);
							}
						}

						for (FourDimensionObject fdo : dimensionMinusHeadArrow)
						{
							Circle c = fdo.getC();
							Label l = fdo.getL();
							HeadArrow ha = fdo.getHa();
							double positionX = c.getCenterX() - 20;
							double positionY = c.getCenterY() - 20;
							int i = checkBitmapToken(positionX, positionY);
							String labValS = l.getText();
							int tagValue = Integer.parseInt(labValS);
							animationMinusHeadArrow(c, l, ha, r, i, tagValue);
							if (i > tagValue && i < 11)
							{
								deleteBitmapToken(positionX, positionY);
								setBitmapToken(c, i - tagValue);

							}

							else if (i > 11)
							{
								deleteTokenBiggerThanTen(positionX, positionY);
								setBitmapToken(c, i - tagValue - 1);
							}

							else if (i == 11)
							{
								i -= tagValue;
								deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay,
										c.getCenterY() - labelInTokensRay);
								setBitmapToken(c, i - tagValue);

							} else if (i > 0 && i < tagValue)
							{

							}

							else
							{
								deleteBitmapToken(positionX, positionY);
							}
						}

						for (FourDimensionLeftObject fdo : dimensionPlusLeftDoubleArrow)
						{
							Circle c = fdo.getC();
							Label l = fdo.getL();
							LeftDoubleArrow ha = fdo.getHa();
							double positionX = c.getCenterX() - 20;
							double positionY = c.getCenterY() - 20;
							int i = checkBitmapToken(positionX, positionY);
							String labValS = l.getText();
							int tagValue = Integer.parseInt(labValS);
							animationPlusLeftDoubleArrow(c, l, ha, r, i, tagValue);
							if (i != 0 && i < 10)
							{
								deleteBitmapToken(positionX, positionY);
								setBitmapToken(c, i + tagValue);

							} else if (i != 0 && i >= 10)
							{
								deleteTokenBiggerThanTen(positionX, positionY);
								setBitmapToken(c, i + tagValue - 1);
							}

							else
							{
								i += tagValue;
								setBitmapToken(c, tagValue);
							}
						}

						for (FourDimensionLeftObject fdo : dimensionMinusLeftDoubleArrow)
						{
							Circle c = fdo.getC();
							Label l = fdo.getL();
							LeftDoubleArrow ha = fdo.getHa();
							double positionX = c.getCenterX() - 20;
							double positionY = c.getCenterY() - 20;
							int i = checkBitmapToken(positionX, positionY);
							String labValS = l.getText();
							int tagValue = Integer.parseInt(labValS);
							animationMinusLeftDoubleArrow(c, l, ha, r, i, tagValue);
							if (i > tagValue && i < 11)
							{
								deleteBitmapToken(positionX, positionY);
								setBitmapToken(c, i - tagValue);

							}

							else if (i > 11)
							{
								deleteTokenBiggerThanTen(positionX, positionY);
								setBitmapToken(c, i - tagValue - 1);
							}

							else if (i == 11)
							{
								i -= tagValue;
								deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay,
										c.getCenterY() - labelInTokensRay);
								setBitmapToken(c, i - tagValue);

							} else if (i > 0 && i < tagValue)
							{

							}

							else
							{
								deleteBitmapToken(positionX, positionY);
							}
						}

						for (FourDimensionRightObject fdo : dimensionPlusRightDoubleArrow)
						{
							Circle c = fdo.getC();
							Label l = fdo.getL();
							RightDoubleArrow ha = fdo.getHa();
							double positionX = c.getCenterX() - 20;
							double positionY = c.getCenterY() - 20;
							int i = checkBitmapToken(positionX, positionY);
							String labValS = l.getText();
							int tagValue = Integer.parseInt(labValS);
							animationPlusRightDoubleArrow(c, l, ha, r, i, tagValue);
							if (i != 0 && i < 10)
							{
								deleteBitmapToken(positionX, positionY);
								setBitmapToken(c, i + tagValue);

							} else if (i != 0 && i >= 10)
							{
								deleteTokenBiggerThanTen(positionX, positionY);
								setBitmapToken(c, i + tagValue - 1);
							}

							else
							{
								i += tagValue;
								setBitmapToken(c, tagValue);
							}
						}

						for (FourDimensionRightObject fdo : dimensionMinusRightDoubleArrow)
						{
							Circle c = fdo.getC();
							Label l = fdo.getL();
							RightDoubleArrow ha = fdo.getHa();
							double positionX = c.getCenterX() - 20;
							double positionY = c.getCenterY() - 20;
							int i = checkBitmapToken(positionX, positionY);
							String labValS = l.getText();
							int tagValue = Integer.parseInt(labValS);
							animationMinusRightDoubleArrow(c, l, ha, r, i, tagValue);
							if (i > tagValue && i < 11)
							{
								deleteBitmapToken(positionX, positionY);
								setBitmapToken(c, i - tagValue);

							}

							else if (i > 11)
							{
								deleteTokenBiggerThanTen(positionX, positionY);
								setBitmapToken(c, i - tagValue - 1);
							}

							else if (i == 11)
							{
								i -= tagValue;
								deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay,
										c.getCenterY() - labelInTokensRay);
								setBitmapToken(c, i - tagValue);

							} else if (i > 0 && i < tagValue)
							{

							}

							else
							{
								deleteBitmapToken(positionX, positionY);
							}
						}

					} else
					{
						setMiddleLabelText(cannotExecuteTransition);
						if (fdo_temp != null)
						{
							animationWhoCantBeExecuteHeadArrow(fdo_temp.getC(), fdo_temp.getL(), fdo_temp.getHa(),
									fdo_temp.getR());
						}
						if (fdo_left_temp != null)
						{
							animationWhoCantBeExecuteLeftDoubleArrow(fdo_left_temp.getC(), fdo_left_temp.getL(),
									fdo_left_temp.getHa(), fdo_left_temp.getR());
						}
						if (fdo_right_temp != null)
						{
							animationWhoCantBeExecuteRightDoubleArrow(fdo_right_temp.getC(), fdo_right_temp.getL(),
									fdo_right_temp.getHa(), fdo_right_temp.getR());
						}
					}

					dimensionMinusHeadArrow.clear();
					dimensionPlusHeadArrow.clear();
					dimensionPlusLeftDoubleArrow.clear();
					dimensionMinusLeftDoubleArrow.clear();
					dimensionMinusRightDoubleArrow.clear();
					dimensionPlusRightDoubleArrow.clear();
					canRunTransition = true;
					fdo_temp = null;
					fdo_left_temp = null;
					fdo_right_temp = null;
				}

				break;

			case "addTag":
				String tag = "";
				for (Circle c : circleList)
				{
					if (c.getCenterX() < event.getSceneX() + circleRay && c.getCenterX() > event.getSceneX() - circleRay
							&& c.getCenterY() < event.getSceneY() + circleRay - minusWidth
							&& c.getCenterY() > event.getSceneY() - circleRay - minusWidth)
					{
						tag = utilities.tagDialog();
						if (utilities.checkNameTagOfCircleOrRectangle(tag) && !tag.equals(""))
						{
							Pair<Double, Double> pair = utilities.returnCircleTagPosition(c, headArrowList);
							Label l = new Label();
							l.setText(tag);
							l.setLayoutX(c.getCenterX() + pair.getKey());
							l.setLayoutY(c.getCenterY() + pair.getValue());
							l.setFont(new Font("Arial", 16));
							l.setId("fancytext");
							mainPane.getChildren().add(l);
							tags.add(l);
						}
					}
				}

				for (Rectangle myRectangle : rectangleList)
				{
					if ((event.getSceneX() + squareRay > myRectangle.getX() + 20)
							&& (event.getSceneX() - squareRay < myRectangle.getX() + 20)
							&& (event.getSceneY() + squareRay - minusWidth > myRectangle.getY() + 20)
							&& (event.getSceneY() - squareRay - minusWidth < myRectangle.getY() + 20))
					{
						tag = utilities.tagDialog();
						if (utilities.checkNameTagOfCircleOrRectangle(tag) && !tag.equals(""))
						{
							Utilities.infoBox("rect");
						}
					}
				}

				LeftDoubleArrow left = new LeftDoubleArrow();
				for (LeftDoubleArrow lda : leftDoubleArrowList)
				{
					if (lda.getControlX() < event.getSceneX() + arrowRay
							&& lda.getControlX() > event.getSceneX() - arrowRay
							&& lda.getControlY() < event.getSceneY() + arrowRay - minusWidth
							&& lda.getControlY() > event.getSceneY() - arrowRay - minusWidth)
					{
						tag = utilities.tagDialog();
						if (utilities.checkNameTag(tag) && !tag.equals(""))
						{
							Pair<Double, Double> pair = lda.returnMiddlePoint(lda.getStartX(), lda.getStartY(),
									lda.getEndX(), lda.getEndY());
							double midX = pair.getKey();
							double midY = pair.getValue();
							Pair<Double, Double> pair2 = lda.returnMoveXandY(lda.getStartX(), lda.getStartY(),
									lda.getEndX(), lda.getEndY());
							double mvX = pair2.getKey();
							double mvY = pair2.getValue();
							Label l = new Label();
							l.setText(tag);
							l.setLayoutX(midX + mvX);
							l.setLayoutY(midY + mvY);
							l.setFont(new Font("Arial", 16));
							l.setId("fancytext");
							mainPane.getChildren().add(l);
							tags.add(l);
							leftDoubleArrowTags.put(l, lda);

							break;
						} else
						{
							break;
						}
					}

				}

				for (RightDoubleArrow lda : rightDoubleArrowList)
				{
					if (lda.getControlX() < event.getSceneX() + arrowRay
							&& lda.getControlX() > event.getSceneX() - arrowRay
							&& lda.getControlY() < event.getSceneY() + arrowRay - minusWidth
							&& lda.getControlY() > event.getSceneY() - arrowRay - minusWidth)
					{
						tag = utilities.tagDialog();
						if (utilities.checkNameTag(tag) && !tag.equals(""))
						{
							Pair<Double, Double> pair = lda.returnMiddlePoint(lda.getStartX(), lda.getStartY(),
									lda.getEndX(), lda.getEndY());
							double midX = pair.getKey();
							double midY = pair.getValue();
							Pair<Double, Double> pair2 = lda.returnMoveXandY(lda.getStartX(), lda.getStartY(),
									lda.getEndX(), lda.getEndY());
							double mvX = pair2.getKey();
							double mvY = pair2.getValue();
							Label l = new Label();
							l.setText(tag);
							l.setLayoutX(midX - mvX);
							l.setLayoutY(midY - mvY);
							l.setFont(new Font("Arial", 16));
							l.setId("fancytext");
							mainPane.getChildren().add(l);
							tags.add(l);
							rightDoubleArrowTags.put(l, lda);
							break;
						} else
						{
							break;
						}
					}

				}

				for (HeadArrow ha : headArrowList)
				{
					double middleX = (ha.getStartX() + ha.getEndX()) / 2;
					double middleY = (ha.getStartY() + ha.getEndY()) / 2;
					if (middleX < event.getSceneX() + arrowRay && middleX > event.getSceneX() - arrowRay
							&& middleY < event.getSceneY() + arrowRay - minusWidth
							&& middleY > event.getSceneY() - arrowRay - minusWidth)
					{
						tag = utilities.tagDialog();
						if (utilities.checkNameTag(tag) && !tag.equals(""))
						{
							Pair<Double, Double> pair = left.returnMiddlePoint(ha.getStartX(), ha.getStartY(),
									ha.getEndX(), ha.getEndY());
							double midX = pair.getKey();
							double midY = pair.getValue();
							Pair<Double, Double> pair2 = left.returnMoveXandY(ha.getStartX(), ha.getStartY(),
									ha.getEndX(), ha.getEndY());
							double mvX = pair2.getKey() / 5;
							double mvY = pair2.getValue() / 5;
							Label l = new Label();
							l.setText(tag);
							l.setLayoutX(midX + mvX);
							l.setLayoutY(midY + mvY);
							l.setFont(new Font("Arial", 16));
							l.setId("fancytext");
							mainPane.getChildren().add(l);
							tags.add(l);
							headArrowTags.put(l, ha);
							break;
						} else
						{
							break;
						}

					}
				}
				break;
			case "removeTag":
				int _localIndex = -1;
				for (Label l : tags)
				{
					if (l.getLayoutX() < event.getSceneX() + arrowRay && l.getLayoutX() > event.getSceneX() - arrowRay
							&& l.getLayoutY() < event.getSceneY() + arrowRay - minusWidth
							&& l.getLayoutY() > event.getSceneY() - arrowRay - minusWidth)
					{
						_localIndex = tags.indexOf(l);
						mainPane.getChildren().remove(l);
						break;
					}
				}

				if (_localIndex != -1)
				{
					tags.remove(_localIndex);
				}

				break;

			case "addToken":
				boolean foundCircle1 = false;

				for (Circle c : circleList)
				{
					if (event.getSceneX() - circleRay < c.getCenterX() && event.getSceneX() + circleRay > c.getCenterX()
							&& event.getSceneY() - circleRay - minusWidth < c.getCenterY()
							&& event.getSceneY() + circleRay - minusWidth > c.getCenterY())
					{
						foundCircle1 = true;
						double positionX = c.getCenterX() - 20;
						double positionY = c.getCenterY() - 20;
						int i = checkBitmapToken(positionX, positionY);
						if (i != 0 && i < 10)
						{
							deleteBitmapToken(positionX, positionY);
							setBitmapToken(c, i + 1);

						} else if (i != 0 && i >= 10)
						{
							deleteTokenBiggerThanTen(positionX, positionY);
							setBitmapToken(c, i);
							i += 1;
						}

						else
						{
							setBitmapToken(c, 1);
						}

					}
				}

				if (!foundCircle1)
				{
					setMiddleLabelText("Click on circle...");
				}
				break;

			case "removeToken":
				boolean foundCircle2 = false;
				for (Circle c : circleList)
				{
					if (event.getSceneX() - circleRay < c.getCenterX() && event.getSceneX() + circleRay > c.getCenterX()
							&& event.getSceneY() - circleRay - minusWidth < c.getCenterY()
							&& event.getSceneY() + circleRay - minusWidth > c.getCenterY())
					{
						foundCircle2 = true;
						double positionX = c.getCenterX() - 20;
						double positionY = c.getCenterY() - 20;
						int i = checkBitmapToken(positionX, positionY);
						if (i > 1 && i < 11)
						{
							deleteBitmapToken(positionX, positionY);
							setBitmapToken(c, i - 1);

						}

						else if (i > 11)
						{
							i -= 1;
							deleteTokenBiggerThanTen(positionX, positionY);
							setBitmapToken(c, i - 1);
						}

						else if (i == 11)
						{
							i -= 1;
							deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay,
									c.getCenterY() - labelInTokensRay);
							setBitmapToken(c, i - 1);

						} else
						{
							deleteBitmapToken(positionX, positionY);
						}

					}
				}
				if (!foundCircle2)
				{
					setMiddleLabelText("Click on circle...");
				}
				break;

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

							for (ImageView iv : existingImageViews)
							{
								if (iv.getLayoutX() == myCircle.getCenterX() - 20
										&& iv.getLayoutY() == myCircle.getCenterY() - 20)
								{
									imageViewsToRemove.add(iv);
								}
							}

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

							for (LeftDoubleArrow da : leftDoubleArrowList)
							{
								if (da.getStartX() == myCircle.getCenterX() && da.getStartY() == myCircle.getCenterY())
								{
									leftStartDoubleArrowList.add(da);
								}
							}

							for (LeftDoubleArrow da : leftDoubleArrowList)
							{
								if (da.getEndX() == myCircle.getCenterX() && da.getEndY() == myCircle.getCenterY())
								{
									leftEndDoubleArrowList.add(da);
								}
							}

							for (RightDoubleArrow da : rightDoubleArrowList)
							{
								if (da.getStartX() == myCircle.getCenterX() && da.getStartY() == myCircle.getCenterY())
								{
									rightStartDoubleArrowList.add(da);
								}
							}

							for (RightDoubleArrow da : rightDoubleArrowList)
							{
								if (da.getEndX() == myCircle.getCenterX() && da.getEndY() == myCircle.getCenterY())
								{
									rightEndDoubleArrowList.add(da);
								}
							}

							for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
							{
								for (HeadArrow rda : startHeadArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
							{
								for (HeadArrow rda : endHeadArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
							{
								for (RightDoubleArrow rda : rightStartDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
							{
								for (RightDoubleArrow rda : rightEndDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
							{
								for (LeftDoubleArrow rda : leftEndDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
							{
								for (LeftDoubleArrow rda : leftStartDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							if (!imageViewsToRemove.isEmpty())
							{
								existingImageViews.removeAll(imageViewsToRemove);
								for (ImageView iv : imageViewsToRemove)
								{
									mainPane.getChildren().remove(iv);
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

							if (!leftStartDoubleArrowList.isEmpty())
							{
								leftDoubleArrowList.removeAll(leftStartDoubleArrowList);

								for (LeftDoubleArrow ha : leftStartDoubleArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!leftEndDoubleArrowList.isEmpty())
							{
								leftDoubleArrowList.removeAll(leftEndDoubleArrowList);

								for (LeftDoubleArrow ha : leftEndDoubleArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!rightEndDoubleArrowList.isEmpty())
							{
								rightDoubleArrowList.removeAll(rightEndDoubleArrowList);

								for (RightDoubleArrow ha : rightEndDoubleArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!rightStartDoubleArrowList.isEmpty())
							{
								rightDoubleArrowList.removeAll(rightStartDoubleArrowList);

								for (RightDoubleArrow ha : rightStartDoubleArrowList)
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

					for (Rectangle myRectangle : rectangleList)
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

							for (LeftDoubleArrow da : leftDoubleArrowList)
							{
								if (da.getStartX() == myRectangle.getX() + 20
										&& da.getStartY() == myRectangle.getY() + 20)
								{
									leftStartDoubleArrowList.add(da);
								}
							}

							for (LeftDoubleArrow da : leftDoubleArrowList)
							{
								if (da.getEndX() == myRectangle.getX() + 20 && da.getEndY() == myRectangle.getY() + 20)
								{
									leftEndDoubleArrowList.add(da);
								}
							}

							for (RightDoubleArrow da : rightDoubleArrowList)
							{
								if (da.getStartX() == myRectangle.getX() + 20
										&& da.getStartY() == myRectangle.getY() + 20)
								{
									rightStartDoubleArrowList.add(da);
								}
							}

							for (RightDoubleArrow da : rightDoubleArrowList)
							{
								if (da.getEndX() == myRectangle.getX() + 20 && da.getEndY() == myRectangle.getY() + 20)
								{
									rightEndDoubleArrowList.add(da);
								}
							}

							for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
							{
								for (HeadArrow rda : startHeadArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, HeadArrow> entry : headArrowTags.entrySet())
							{
								for (HeadArrow rda : endHeadArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
							{
								for (RightDoubleArrow rda : rightStartDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, RightDoubleArrow> entry : rightDoubleArrowTags.entrySet())
							{
								for (RightDoubleArrow rda : rightEndDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
							{
								for (LeftDoubleArrow rda : leftEndDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

							for (Map.Entry<Label, LeftDoubleArrow> entry : leftDoubleArrowTags.entrySet())
							{
								for (LeftDoubleArrow rda : leftStartDoubleArrowList)
								{
									if (rda.equals(entry.getValue()))
									{
										tagsToRemove.add(entry.getKey());
									}
								}
							}

							if (!tagsToRemove.isEmpty())
							{
								for (Label l : tagsToRemove)
								{
									mainPane.getChildren().remove(l);
								}
								tags.removeAll(tagsToRemove);
							}

							tagsToRemove.clear();

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

							if (!leftStartDoubleArrowList.isEmpty())
							{
								leftDoubleArrowList.removeAll(leftStartDoubleArrowList);

								for (LeftDoubleArrow ha : leftStartDoubleArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!leftEndDoubleArrowList.isEmpty())
							{
								leftDoubleArrowList.removeAll(leftEndDoubleArrowList);

								for (LeftDoubleArrow ha : leftEndDoubleArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!rightEndDoubleArrowList.isEmpty())
							{
								rightDoubleArrowList.removeAll(rightEndDoubleArrowList);

								for (RightDoubleArrow ha : rightEndDoubleArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							if (!rightStartDoubleArrowList.isEmpty())
							{
								rightDoubleArrowList.removeAll(rightStartDoubleArrowList);

								for (RightDoubleArrow ha : rightStartDoubleArrowList)
								{
									ha.removeFromMainPane(mainPane);
								}
							}

							rectangleList.remove(myRectangle);
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
					r.setStroke(Paint.valueOf("#555555"));
					r.setStrokeWidth(5.0f);
					mainPane.getChildren().add(r);
					r.setOnMousePressed(squareOnMousePressedEventHandler);
					setMiddleLabelText("Rectangle created...");
					rectangleList.add(r);
				}
				break;

			case "line":
				if (event.getSceneY() > minusWidth + 10)
				{
					LeftDoubleArrow doubleArrow = new LeftDoubleArrow();
					double x = event.getSceneX();
					double y = event.getSceneY();

					double control1X = 0;
					double control2X = 0;
					double control1Y = 0;
					double control2Y = 0;

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

								int _index = -1;

								for (HeadArrow ha : headArrowList)
								{
									if (ha.getEndX() == _cFirstPosX && ha.getEndY() == _cFirstPosY
											&& ha.getStartX() == _cSecPosX && ha.getStartY() == _cSecPosY)
									{

										Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(_cFirstPosX,
												_cFirstPosY, _cSecPosX, _cSecPosY);
										double midX = pair.getKey();
										double midY = pair.getValue();

										Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(_cFirstPosX,
												_cFirstPosY, _cSecPosX, _cSecPosY);
										double moveX = pair2.getKey();
										double moveY = pair2.getValue();

										control1X = midX + moveX;
										control2X = midX - moveX;
										control1Y = midY + moveY;
										control2Y = midY - moveY;

										ha.removeFromMainPane(mainPane);
										_index = headArrowList.indexOf(ha);

									}
								}

								if (_index != -1)
								{
									LeftDoubleArrow path1 = new LeftDoubleArrow(_cFirstPosX, _cFirstPosY, control1X,
											control1Y, _cSecPosX, _cSecPosY);

									RightDoubleArrow path2 = new RightDoubleArrow(_cSecPosX, _cSecPosY, control2X,
											control2Y, _cFirstPosX, _cFirstPosY);

									path1.addToMainPane(mainPane);
									path2.addToMainPane(mainPane);

									path1.setFill(arrowColor);
									path2.setFill(arrowColor);

									setMiddleLabelText("Second point of line...");
									headArrowList.remove(_index);

									leftDoubleArrowList.add(path1);
									rightDoubleArrowList.add(path2);

									_cFirstPosX = 0;
									_cFirstPosY = 0;
									_cSecPosX = 0;
									_cSecPosY = 0;

									secondObject = "";
									break;

								}

								else
								{
									HeadArrow headArrow = new HeadArrow(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY,
											mainPane);
									headArrow.setFill(arrowColor);
									headArrowList.add(headArrow);
									headArrow.addToMainPane(mainPane);

									setMiddleLabelText("Second point of line...");

									_cFirstPosX = 0;
									_cFirstPosY = 0;
									_cSecPosX = 0;
									_cSecPosY = 0;

									secondObject = "";
									break;
								}
							}

							if (_cFirstPosX != 0 && _cFirstPosY != 0 && secondObject == "rectangle")
							{
								setMiddleLabelText("Second object must be rectangle...");
							}
						}
					}

					for (Rectangle myRectangle : rectangleList)
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

								int _index = -1;

								for (HeadArrow ha : headArrowList)
								{
									if (ha.getEndX() == _cFirstPosX && ha.getEndY() == _cFirstPosY
											&& ha.getStartX() == _cSecPosX && ha.getStartY() == _cSecPosY)
									{

										Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(_cFirstPosX,
												_cFirstPosY, _cSecPosX, _cSecPosY);
										double midX = pair.getKey();
										double midY = pair.getValue();

										Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(_cFirstPosX,
												_cFirstPosY, _cSecPosX, _cSecPosY);
										double moveX = pair2.getKey();
										double moveY = pair2.getValue();

										control1X = midX + moveX;
										control2X = midX - moveX;
										control1Y = midY + moveY;
										control2Y = midY - moveY;

										ha.removeFromMainPane(mainPane);
										_index = headArrowList.indexOf(ha);

									}
								}
								if (_index != -1)
								{
									LeftDoubleArrow path1 = new LeftDoubleArrow(_cFirstPosX, _cFirstPosY, control1X,
											control1Y, _cSecPosX, _cSecPosY);

									RightDoubleArrow path2 = new RightDoubleArrow(_cSecPosX, _cSecPosY, control2X,
											control2Y, _cFirstPosX, _cFirstPosY);

									path1.addToMainPane(mainPane);
									path2.addToMainPane(mainPane);

									path1.setFill(arrowColor);
									path2.setFill(arrowColor);

									setMiddleLabelText("Second point of line...");
									headArrowList.remove(_index);

									leftDoubleArrowList.add(path1);
									rightDoubleArrowList.add(path2);

									_cFirstPosX = 0;
									_cFirstPosY = 0;
									_cSecPosX = 0;
									_cSecPosY = 0;

									secondObject = "";
									break;

								} else
								{

									HeadArrow headArrow = new HeadArrow(_cFirstPosX, _cFirstPosY, _cSecPosX, _cSecPosY,
											mainPane);
									headArrow.setFill(arrowColor);
									headArrowList.add(headArrow);
									headArrow.addToMainPane(mainPane);
									setMiddleLabelText("Second point of line...");

									_cFirstPosX = 0;
									_cFirstPosY = 0;
									_cSecPosX = 0;
									_cSecPosY = 0;
									secondObject = "";
									break;
								}
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
				while (_it < utilities.takeMaximumFromLists(circleList, rectangleList, headArrowList,
						leftDoubleArrowList, rightDoubleArrowList, existingImageViews, tokensBiggerThanTen, tags,
						headArrowTags, rightDoubleArrowTags, leftDoubleArrowTags))
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
						System.out.println(e.getLocalizedMessage());
					}

				}

				break;
		}
	}

	public void initialize()
	{
		mainWindowControllerReadSetting();
		setPaneResolution();

		setBackgroundColor();
		setTooltips();
		initializeStats();

		middleLabel.setDisable(true);

		mainPane_AddEventHandlerClick();

		saveFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		openFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		openAPTFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));

		utilities.clearAllLists(circleList, rectangleList, headArrowList, leftDoubleArrowList, rightDoubleArrowList,
				existingImageViews, tokensBiggerThanTen, tags, headArrowTags, rightDoubleArrowTags,
				leftDoubleArrowTags);

		circleToggleButton.setToggleGroup(toggleButtonsGroup);
		squareToggleButton.setToggleGroup(toggleButtonsGroup);
		moveToggleButton.setToggleGroup(toggleButtonsGroup);
		lineToggleButton.setToggleGroup(toggleButtonsGroup);
		removeToggleButton.setToggleGroup(toggleButtonsGroup);
		addTokenToggleButton.setToggleGroup(toggleButtonsGroup);
		removeTokenToggleButton.setToggleGroup(toggleButtonsGroup);
		addTagToggleButton.setToggleGroup(toggleButtonsGroup);
		removeTagToggleButton.setToggleGroup(toggleButtonsGroup);
		startAnimationToggleButton.setToggleGroup(toggleButtonsGroup);

		circleToggleButton.setUserData("circle");
		squareToggleButton.setUserData("square");
		moveToggleButton.setUserData("move");
		lineToggleButton.setUserData("line");
		removeToggleButton.setUserData("remove");
		addTokenToggleButton.setUserData("addToken");
		removeTokenToggleButton.setUserData("removeToken");
		addTagToggleButton.setUserData("addTag");
		removeTagToggleButton.setUserData("removeTag");
		startAnimationToggleButton.setUserData("play");

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
					else if (selectedToggle == "addToken")
						setMiddleLabelText("Adding tokens...");
					else if (selectedToggle == "removeToken")
						setMiddleLabelText("Removing tokens...");
					else if (selectedToggle == "addTag")
						setMiddleLabelText("Adding tags...");
					else if (selectedToggle == "removeTag")
						setMiddleLabelText("Removing tags...");
					else if (selectedToggle == "play")
						setMiddleLabelText("Starting animation...");
				}

			}
		});

		Main.getPrimaryStage().focusedProperty().addListener(new ChangeListener<Boolean>()
		{

			@Override
			public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1)
			{
				if (checkFileRecognition.equals("yes"))
				{
					openFile(optPath);
					// ReadFile(optPath);
					checkFileRecognition = "";
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
			mainWindowControllerReadSetting();
			setBackgroundColor();
			setCircleColor();
			setRectangleColor();
			setArrowColor();

		}
	};

	@FXML
	void saveFileMenuItem_OnAction(ActionEvent event)
	{
		Stage s = Main.getPrimaryStage();
		fileManager.SaveFile(s, circleList, rectangleList, headArrowList, leftDoubleArrowList, rightDoubleArrowList,
				existingImageViews, tokensBiggerThanTen, tags, headArrowTags, rightDoubleArrowTags,
				leftDoubleArrowTags);
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

		for (Rectangle r : rectangleList)
		{
			mainPane.getChildren().remove(r);
		}

		for (HeadArrow ha : headArrowList)
		{
			ha.removeFromMainPane(mainPane);
		}

		for (LeftDoubleArrow lda : leftDoubleArrowList)
		{
			lda.removeFromMainPane(mainPane);
		}

		for (RightDoubleArrow rda : rightDoubleArrowList)
		{
			rda.removeFromMainPane(mainPane);
		}

		for (Label l : tags)
		{
			mainPane.getChildren().remove(l);
		}

		utilities.clearAllLists(circleList, rectangleList, headArrowList, leftDoubleArrowList, rightDoubleArrowList,
				existingImageViews, tokensBiggerThanTen, tags, headArrowTags, rightDoubleArrowTags,
				leftDoubleArrowTags);

		Stage s = Main.getPrimaryStage();
		circleList.clear();
		rectangleList.clear();
		fileManager.OpenFile(s, circleList, rectangleList, headArrowList, leftDoubleArrowList, rightDoubleArrowList,
				existingImageViews, tokensBiggerThanTen, tags, headArrowTags, rightDoubleArrowTags, leftDoubleArrowTags,
				mainPane);

		for (Circle c : circleList)
		{
			mainPane.getChildren().add(c);
			c.setOnMousePressed(circleOnMousePressedEventHandler);
			c.setOnMouseDragged(circleOnMouseDraggedEventHandler);
		}

		for (Rectangle r : rectangleList)
		{
			mainPane.getChildren().add(r);
			r.setOnMousePressed(squareOnMousePressedEventHandler);
			r.setOnMouseDragged(squareOnMouseDraggedEventHandler);
		}

		for (HeadArrow ha : headArrowList)
		{
			ha.addToMainPane(mainPane);
		}

		for (LeftDoubleArrow lda : leftDoubleArrowList)
		{
			lda.addToMainPane(mainPane);
		}

		for (RightDoubleArrow rda : rightDoubleArrowList)
		{
			rda.addToMainPane(mainPane);
		}

		for (ImageView iv : existingImageViews)
		{
			mainPane.getChildren().add(iv);
		}

		for (Label l : tokensBiggerThanTen)
		{
			mainPane.getChildren().add(l);
		}

		for (Label l : tags)
		{
			mainPane.getChildren().add(l);
		}

		Boolean fileOpened = fileManager.getSomethingOpened();
		if (fileOpened)
		{
			setMiddleLabelText("File opened...");
			mainWindowControllerReadSetting();
			setBackgroundColor();
			setCircleColor();
			setArrowColor();
			setRectangleColor();

		}

	}

	@FXML
	void clearAllButton_OnMouseClicked(MouseEvent event)
	{
		utilities.clearUpMessage(mainPane, "Question", "Clear all elements", "Are you sure?", circleList, rectangleList,
				headArrowList, leftDoubleArrowList, rightDoubleArrowList, existingImageViews, tokensBiggerThanTen,
				tags);
		if (utilities.checkCleared)
		{
			counters.circleCounter(circleList, numberOfCirclesCreatedL);
			counters.rectangleCounter(rectangleList, numberOfRectanglesCreatedL);
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
		Font fontToUse = Font.font("Arial", 18);

		Label objects = new Label("Objects");
		objects.setFont(Font.font("Arial", 30));
		objects.setAlignment(Pos.CENTER);

		Label interactions = new Label("Interactions");
		interactions.setFont(Font.font("Arial", 30));
		interactions.setAlignment(Pos.CENTER);

		Separator separator1 = new Separator();
		separator1.setOrientation(Orientation.HORIZONTAL);
		separator1.setMinWidth(150.0);
		Separator separator2 = new Separator();
		separator2.setOrientation(Orientation.HORIZONTAL);
		separator2.setMinWidth(150.0);

		GridPane grid = new GridPane();
		grid.getColumnConstraints().add(new ColumnConstraints(240));
		grid.setVgap(5);
		GridPane.setHalignment(objects, HPos.RIGHT);
		GridPane.setHalignment(interactions, HPos.RIGHT);
		GridPane.setHalignment(circlesCreatedL, HPos.RIGHT);
		GridPane.setHalignment(rectanglesCreatedL, HPos.RIGHT);
		GridPane.setHalignment(doubleArrowsCreatedL, HPos.RIGHT);
		GridPane.setHalignment(arrowsCreatedL, HPos.RIGHT);
		GridPane.setHalignment(mouseBothClickL, HPos.RIGHT);
		GridPane.setHalignment(mouseLeftClickL, HPos.RIGHT);
		GridPane.setHalignment(mouseRightClickL, HPos.RIGHT);
		GridPane.setHalignment(objectsDeletedL, HPos.RIGHT);
		GridPane.setHalignment(objectsMovedL, HPos.RIGHT);
		GridPane.setHalignment(tagsCreatedL, HPos.RIGHT);
		GridPane.setHalignment(tokensCreatedL, HPos.RIGHT);

		grid.setPadding(new Insets(5, 5, 5, 5));

		grid.add(objects, 0, 0);
		grid.add(circlesCreatedL, 0, 1);
		grid.add(numberOfCirclesCreatedL, 1, 1);

		grid.add(rectanglesCreatedL, 0, 2);
		grid.add(numberOfRectanglesCreatedL, 1, 2);

		grid.add(arrowsCreatedL, 0, 3);
		grid.add(numberOfArrowsCreatedL, 1, 3);

		grid.add(doubleArrowsCreatedL, 0, 4);
		grid.add(numberOfDoubleArrowsCreatedL, 1, 4);

		grid.add(tagsCreatedL, 0, 5);
		grid.add(numberOfTagsCreatedL, 1, 5);

		grid.add(tokensCreatedL, 0, 6);
		grid.add(numberOfTokensCreatedL, 1, 6);

		grid.add(separator1, 0, 7);
		grid.add(separator2, 1, 7);

		grid.add(interactions, 0, 8);

		grid.add(mouseBothClickL, 0, 9);
		grid.add(numberOfMouseBothClickL, 1, 9);

		grid.add(mouseRightClickL, 0, 10);
		grid.add(numberOfMouseRightClickL, 1, 10);

		grid.add(mouseLeftClickL, 0, 11);
		grid.add(numberOfMouseLeftClickL, 1, 11);

		grid.add(objectsDeletedL, 0, 12);
		grid.add(numberOfObjectsDeletedL, 1, 12);

		grid.add(objectsMovedL, 0, 13);
		grid.add(numberOfObjectsMovedL, 1, 13);

		allStatsLabels.add(arrowsCreatedL);
		allStatsLabels.add(circlesCreatedL);
		allStatsLabels.add(doubleArrowsCreatedL);
		allStatsLabels.add(rectanglesCreatedL);
		allStatsLabels.add(mouseBothClickL);
		allStatsLabels.add(mouseLeftClickL);
		allStatsLabels.add(mouseRightClickL);
		allStatsLabels.add(objectsDeletedL);
		allStatsLabels.add(objectsMovedL);
		allStatsLabels.add(tokensCreatedL);
		allStatsLabels.add(tagsCreatedL);
		allStatsLabels.add(numberOfArrowsCreatedL);
		allStatsLabels.add(numberOfCirclesCreatedL);
		allStatsLabels.add(numberOfDoubleArrowsCreatedL);
		allStatsLabels.add(numberOfMouseBothClickL);
		allStatsLabels.add(numberOfMouseLeftClickL);
		allStatsLabels.add(numberOfMouseRightClickL);
		allStatsLabels.add(numberOfObjectsDeletedL);
		allStatsLabels.add(numberOfObjectsMovedL);
		allStatsLabels.add(numberOfRectanglesCreatedL);
		allStatsLabels.add(numberOfTokensCreatedL);
		allStatsLabels.add(numberOfTagsCreatedL);

		for (Label l : allStatsLabels)
		{
			l.setFont(fontToUse);
		}

		/*
		 * circlesCreatedL.setFont(fontToUse);
		 * numberOfCirclesCreatedL.setFont(fontToUse);
		 * rectanglesCreatedL.setFont(fontToUse);
		 * numberOfRectanglesCreatedL.setFont(fontToUse);
		 * arrowsCreatedL.setFont(fontToUse);
		 * numberOfArrowsCreatedL.setFont(fontToUse);
		 * doubleArrowsCreatedL.setFont(fontToUse);
		 * numberOfDoubleArrowsCreatedL.setFont(fontToUse);
		 */

		statisticsAlert.getDialogPane().setContent(grid);

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
		mainPane.getChildren().remove(circleList.size() + rectangleList.size() + headArrowList.size() - 2);
		mainPane.getChildren().remove(circleList.size() + rectangleList.size() + headArrowList.size() - 2);
		mainPane.getChildren().remove(circleList.size() + rectangleList.size() + headArrowList.size() - 2);
		headArrowList.remove(headArrowList.size() - 1);
	}

	private void mainWindowControllerReadSetting()
	{
		SettingsController set = new SettingsController();
		set.ReadSettings();
		backgroundColor = set.getBackgroundColor();
		rectangleColor = set.getRectangleColor();
		circleColor = set.getCircleColor();
		arrowColor = set.getLineColor();
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

		for (Rectangle r : rectangleList)
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

		for (LeftDoubleArrow lda : leftDoubleArrowList)
		{
			lda.setFill(leftDoubleArrowList, arrowColor);
		}

		for (RightDoubleArrow rda : rightDoubleArrowList)
		{
			rda.setFill(rightDoubleArrowList, arrowColor);
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

	private int checkBitmapToken(double x, double y)
	{
		int whatToReturn = 0;
		for (ImageView iv : existingImageViews)
		{
			if (iv.getLayoutX() == x && iv.getLayoutY() == y)
			{
				if (iv.getImage() == imageToken1)
				{
					whatToReturn = 1;
					break;
				}
				if (iv.getImage() == imageToken2)
				{
					whatToReturn = 2;
					break;
				}
				if (iv.getImage() == imageToken3)
				{
					whatToReturn = 3;
					break;
				}
				if (iv.getImage() == imageToken4)
				{
					whatToReturn = 4;
					break;
				}
				if (iv.getImage() == imageToken5)
				{
					whatToReturn = 5;
					break;
				}
				if (iv.getImage() == imageToken6)
				{
					whatToReturn = 6;
					break;
				}
				if (iv.getImage() == imageToken7)
				{
					whatToReturn = 7;
					break;
				}
				if (iv.getImage() == imageToken8)
				{
					whatToReturn = 8;
					break;
				}
				if (iv.getImage() == imageToken9)
				{
					whatToReturn = 9;
					break;
				}

			}
		}
		for (Label l : tokensBiggerThanTen)
		{

			if (l.getLayoutX() - (20 - labelInTokensRay) == x && l.getLayoutY() - (20 - labelInTokensRay) == y)
			{
				String t = l.getText();
				whatToReturn = Integer.parseInt(t) + 1;
				break;
			}

		}
		return whatToReturn;
	}

	private void deleteBitmapToken(double x, double y)
	{
		int _index = -1;
		try
		{
			for (ImageView iv : existingImageViews)
			{
				if (iv.getLayoutX() == x && iv.getLayoutY() == y)
				{
					_index = existingImageViews.indexOf(iv);
					mainPane.getChildren().remove(iv);
				}
			}

			if (_index != -1)
			{
				existingImageViews.remove(_index);
			}

		} catch (Exception e)
		{
			e.fillInStackTrace();
		}
	}

	private void deleteTokenBiggerThanTen(double x, double y)
	{
		int _index = -1;
		try
		{
			for (Label l : tokensBiggerThanTen)
			{
				if (l.getLayoutX() == x && l.getLayoutY() == y)
				{
					_index = tokensBiggerThanTen.indexOf(l);
					mainPane.getChildren().remove(l);
				}
			}

			if (_index != -1)
			{
				tokensBiggerThanTen.remove(_index);
			}

		} catch (Exception e)
		{
			e.fillInStackTrace();
		}
	}

	public void setBitmapToken(Circle c, int tokens)
	{
		if (tokens > 9)
		{
			deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay, c.getCenterY() - labelInTokensRay);

			Label numberOfTokens = new Label();
			numberOfTokens.setText(String.valueOf(tokens));
			numberOfTokens.setFont(new Font("Arial", 24));
			numberOfTokens.setLayoutX(c.getCenterX() - labelInTokensRay);
			numberOfTokens.setLayoutY(c.getCenterY() - labelInTokensRay);
			numberOfTokens.setTextFill(Paint.valueOf("#222222"));
			tokensBiggerThanTen.add(numberOfTokens);
			mainPane.getChildren().add(numberOfTokens);

		} else
		{
			deleteBitmapToken(c.getCenterX() - 20, c.getCenterY() - 20);

			ImageView imageView = new ImageView();
			imageView.setFitHeight(40.0f);
			imageView.setFitWidth(40.0f);
			imageView.setLayoutX(c.getCenterX() - 20);
			imageView.setLayoutY(c.getCenterY() - 20);

			switch (tokens)
			{
				case 1:
					imageView.setImage(imageToken1);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 2:
					imageView.setImage(imageToken2);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 3:
					imageView.setImage(imageToken3);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 4:
					imageView.setImage(imageToken4);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 5:
					imageView.setImage(imageToken5);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 6:
					imageView.setImage(imageToken6);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 7:
					imageView.setImage(imageToken7);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 8:
					imageView.setImage(imageToken8);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;
				case 9:
					imageView.setImage(imageToken9);
					mainPane.getChildren().add(imageView);
					existingImageViews.add(imageView);
					break;

			}

		}

	}

	@FXML
	void openAPTFileMenuItem_OnAction(ActionEvent event)
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("OpenAPT.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 870, 700);
			scene.getStylesheets().add(getClass().getResource("openapt.css").toExternalForm());
			aptStage = new Stage();
			aptStage.setTitle("Open APT");
			aptStage.setScene(scene);
			aptStage.getIcons()
					.add(new Image(MainWindowController.class.getResourceAsStream("resources/settings-icon.png")));
			aptStage.show();
			aptStage.setOnHiding(closeWindow);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public Stage getAptStage()
	{
		return this.aptStage;
	}

	@FXML
	void addTagToggleButton_OnAction(ActionEvent event)
	{

	}

	@FXML
	void removeTagToggleButton_OnAction(ActionEvent event)
	{

	}

	void insertTag(String text, double posX, double posY)
	{
		Label l = new Label();
		l.setText(text);
		l.setLayoutX(posX);
		l.setLayoutY(posY);
		l.setFont(new Font("Arial", 16));
		l.setId("fancytext");
		mainPane.getChildren().add(l);
		tags.add(l);
	}

	@FXML
	void showStatisticsMenuItem_OnAction(ActionEvent event)
	{
		statisticsAlert.setTitle("Statistics");
		statisticsAlert.setHeaderText(null);
		DialogPane dialogPane = statisticsAlert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("statisticsAlert.css").toExternalForm());
		dialogPane.getStyleClass().add("statDialog");
		statisticsAlert.showAndWait();
	}

	@FXML
	void exportPdfMenuItem_OnAction(ActionEvent event)
	{
		exportPdf.exportToPDF();
	}

	public Pane getMainPane()
	{
		return mainPane;
	}

	public void setMainPane(Pane mainPane)
	{
		this.mainPane = mainPane;
	}

	public ObservableList<Circle> getCircleList()
	{
		return circleList;
	}

	public void setCircleList(ObservableList<Circle> circleList)
	{
		this.circleList = circleList;
	}

	public ObservableList<Rectangle> getRectangleList()
	{
		return rectangleList;
	}

	public void setRectangleList(ObservableList<Rectangle> rectangleList)
	{
		this.rectangleList = rectangleList;
	}

	public ObservableList<HeadArrow> getHeadArrowList()
	{
		return headArrowList;
	}

	public void setHeadArrowList(ObservableList<HeadArrow> headArrowList)
	{
		this.headArrowList = headArrowList;
	}

	public ObservableList<LeftDoubleArrow> getLeftDoubleArrowList()
	{
		return leftDoubleArrowList;
	}

	public void setLeftDoubleArrowList(ObservableList<LeftDoubleArrow> leftDoubleArrowList)
	{
		this.leftDoubleArrowList = leftDoubleArrowList;
	}

	public ObservableList<RightDoubleArrow> getRightDoubleArrowList()
	{
		return rightDoubleArrowList;
	}

	public void setRightDoubleArrowList(ObservableList<RightDoubleArrow> rightDoubleArrowList)
	{
		this.rightDoubleArrowList = rightDoubleArrowList;
	}

	public void ReadFile(String p)
	{
		try
		{
			for (Circle c : circleList)
			{
				mainPane.getChildren().remove(c);
			}
			circleList.clear();

			for (Rectangle r : rectangleList)
			{
				mainPane.getChildren().remove(r);
			}
			rectangleList.clear();

			for (HeadArrow ha : headArrowList)
			{
				ha.removeFromMainPane(mainPane);
			}
			headArrowList.clear();

			for (RightDoubleArrow rda : rightDoubleArrowList)
			{
				rda.removeFromMainPane(mainPane);
			}
			rightDoubleArrowList.clear();

			for (LeftDoubleArrow lda : leftDoubleArrowList)
			{
				lda.removeFromMainPane(mainPane);
			}
			leftDoubleArrowList.clear();

			for (Label t : tokensBiggerThanTen)
			{
				mainPane.getChildren().remove(t);
			}
			tokensBiggerThanTen.clear();

			for (ImageView iv : existingImageViews)
			{
				mainPane.getChildren().remove(iv);
			}
			existingImageViews.clear();

			for (Label l : tags)
			{
				mainPane.getChildren().remove(l);

			}
			tags.clear();

			FilesRecognition fr = new FilesRecognition(p);
			ObservableList<String> edgesListFromFile = fr.getEdgesList();
			ObservableList<String> circlesListFromFile = fr.getCirclesList();
			ObservableList<String> rectanglesListFromFile = fr.getRectanglesList();

			double width = 1350;
			double height = 700;

			int obj = 1;

			for (String s : circlesListFromFile)
			{
				Circle c = new Circle((obj * width / (circlesListFromFile.size() + 1)), (2 * height / 3) - minusWidth,
						20.0f, Paint.valueOf(circleColor));

				c.setStroke(Paint.valueOf("#555555"));
				c.setStrokeWidth(5.0f);
				this.mainPane.getChildren().add(c);
				c.setOnMousePressed(circleOnMousePressedEventHandler);
				circleList.add(c);
				obj++;
			}

			obj = 1;

			for (String s : rectanglesListFromFile)
			{
				Rectangle r = new Rectangle((obj * width / (rectanglesListFromFile.size() + 1)),
						(height / 3) - minusWidth - 20, 40.0f, 40.0f);
				r.setFill(Paint.valueOf(rectangleColor));
				r.setStroke(Paint.valueOf("#555555"));
				r.setStrokeWidth(5.0f);
				mainPane.getChildren().add(r);
				r.setOnMousePressed(squareOnMousePressedEventHandler);
				rectangleList.add(r);
				obj++;
			}

			for (String s : edgesListFromFile)
			{
				double firstX = 0, firstY = 0, secX = 0, secY = 0;

				String[] parts = s.split("->");
				if (parts[0].contains("s"))
				{
					String numberS = parts[0].replaceAll("\\D+", "");
					Integer liczba = Integer.parseInt(numberS);
					Circle c = circleList.get(liczba - 1);
					firstX = c.getCenterX();
					firstY = c.getCenterY();
				}

				else if (parts[0].contains("t"))
				{
					String numberS = parts[0].replaceAll("\\D+", "");
					Integer liczba = Integer.parseInt(numberS);
					Rectangle r = rectangleList.get(liczba - 1);
					firstX = r.getX() + 20;
					firstY = r.getY() + 20;
				}

				if (parts[1].contains("s"))
				{
					String numberS = parts[1].replaceAll("\\D+", "");
					Integer liczba = Integer.parseInt(numberS);
					Circle c = circleList.get(liczba - 1);
					secX = c.getCenterX();
					secY = c.getCenterY();
				}

				else if (parts[1].contains("t"))
				{
					String numberS = parts[1].replaceAll("\\D+", "");
					Integer liczba = Integer.parseInt(numberS);
					Rectangle r = rectangleList.get(liczba - 1);
					secX = r.getX() + 20;
					secY = r.getY() + 20;
				}

				boolean flag = false;
				int index = -1;
				double control1X = 0, control2X = 0, control1Y = 0, control2Y = 0;

				HeadArrow tempHeadArrow = null;

				for (HeadArrow ha : headArrowList)
				{
					if (ha.getStartX() == secX && ha.getStartY() == secY && ha.getEndX() == firstX
							&& ha.getEndY() == firstY
							|| ha.getStartX() == firstX && ha.getStartY() == firstY && ha.getEndX() == secX
									&& ha.getEndY() == secY)
					{
						flag = true;
						Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(firstX, firstY, secX, secY);
						double midX = pair.getKey();
						double midY = pair.getValue();

						Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getEndX(), ha.getEndY(),
								ha.getStartX(), ha.getStartY());
						double moveX = pair2.getKey();
						double moveY = pair2.getValue();

						control1X = midX + moveX;
						control2X = midX - moveX;
						control1Y = midY + moveY;
						control2Y = midY - moveY;

						LeftDoubleArrow path1 = new LeftDoubleArrow(firstX, firstY, control1X, control1Y, secX, secY);

						RightDoubleArrow path2 = new RightDoubleArrow(ha.getStartX(), ha.getStartY(), control2X,
								control2Y, ha.getEndX(), ha.getEndY());

						path1.addToMainPane(mainPane);
						path2.addToMainPane(mainPane);

						path1.setFill(arrowColor);
						path2.setFill(arrowColor);

						leftDoubleArrowList.add(path1);
						rightDoubleArrowList.add(path2);

						index = headArrowList.indexOf(ha);
						tempHeadArrow = ha;
					}
				}

				if (flag)
				{
					if (index != -1)
					{
						tempHeadArrow.removeFromMainPane(mainPane);
						headArrowList.remove(index);
					}
				} else
				{
					HeadArrow headArrow = new HeadArrow(firstX, firstY, secX, secY, mainPane);
					headArrow.setFill(arrowColor);
					headArrowList.add(headArrow);
					headArrow.addToMainPane(mainPane);

				}
				index = -1;
				flag = false;

			}
		} catch (Exception e)
		{
			System.err.println(e.toString());
		}

	}

	private void setTooltips()
	{
		Tooltip addTagTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(addTagTooltip);
		Tooltip.install(addTagToggleButton, addTagTooltip);
		addTagTooltip.setText("Add Tag");
		addTagTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;"
				+ "-fx-font-size: 16;");

		Tooltip createCircleTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(createCircleTooltip);
		Tooltip.install(circleToggleButton, createCircleTooltip);
		createCircleTooltip.setText("Add Circle");
		createCircleTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; "
				+ "-fx-text-fill: orange;" + "-fx-font-size: 16;");

		Tooltip createRectangleTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(createRectangleTooltip);
		Tooltip.install(squareToggleButton, createRectangleTooltip);
		createRectangleTooltip.setText("Add Rectangle");
		createRectangleTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; "
				+ "-fx-text-fill: orange;" + "-fx-font-size: 16;");

		Tooltip createArrowTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(createArrowTooltip);
		Tooltip.install(lineToggleButton, createArrowTooltip);
		createArrowTooltip.setText("Add Arrow");
		createArrowTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; "
				+ "-fx-text-fill: orange;" + "-fx-font-size: 16;");

		Tooltip removeTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(removeTooltip);
		Tooltip.install(removeToggleButton, removeTooltip);
		removeTooltip.setText("Remove");
		removeTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;"
				+ "-fx-font-size: 16;");

		Tooltip clearAllTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(clearAllTooltip);
		Tooltip.install(clearAllButton, clearAllTooltip);
		clearAllTooltip.setText("Clear All");
		clearAllTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;"
				+ "-fx-font-size: 16;");

		Tooltip createTokenTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(createTokenTooltip);
		Tooltip.install(addTokenToggleButton, createTokenTooltip);
		createTokenTooltip.setText("Add Token");
		createTokenTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; "
				+ "-fx-text-fill: orange;" + "-fx-font-size: 16;");

		Tooltip removeTokenTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(removeTokenTooltip);
		Tooltip.install(removeTokenToggleButton, removeTokenTooltip);
		removeTokenTooltip.setText("Remove Token");
		removeTokenTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; "
				+ "-fx-text-fill: orange;" + "-fx-font-size: 16;");

		Tooltip removeTagTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(removeTagTooltip);
		Tooltip.install(removeTagToggleButton, removeTagTooltip);
		removeTagTooltip.setText("Remove Tag");
		removeTagTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;"
				+ "-fx-font-size: 16;");

		Tooltip moveTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(moveTooltip);
		Tooltip.install(moveToggleButton, moveTooltip);
		moveTooltip.setText("Move Objects");
		moveTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;"
				+ "-fx-font-size: 16;");

		Tooltip animationTooltip = new Tooltip();
		Utilities.hackTooltipStartTiming(animationTooltip);
		Tooltip.install(startAnimationToggleButton, animationTooltip);
		animationTooltip.setText("Animation");
		animationTooltip.setStyle("-fx-font: normal bold 4 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;"
				+ "-fx-font-size: 16;");

	}

	@FXML
	void compareNetsMenuItem_OnAction(ActionEvent event)
	{

	}

	void setPaneResolution()
	{
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		mainPane.setMaxWidth(primaryScreenBounds.getWidth());
		mainPane.setMaxHeight(primaryScreenBounds.getHeight());
		mainPane.setMinWidth(primaryScreenBounds.getWidth());
		mainPane.setMinHeight(primaryScreenBounds.getHeight());
	}

	void animationMinusHeadArrow(Circle c, Label l, HeadArrow ha, Rectangle r, int valueCirc, int valueLab)
	{
		double duration = 130;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.INDIANRED;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		double positionX = c.getCenterX() - 20;
		double positionY = c.getCenterY() - 20;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		if (valueCirc < valueLab)
		{
			setMiddleLabelText(cannotExecuteTransition);
		} else
		{
			int n = valueCirc;

			final KeyFrame kf1 = new KeyFrame(Duration.millis(0 * duration), e -> c.setEffect(act));
			final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
			final KeyFrame kf3 = new KeyFrame(Duration.millis(2 * duration), e -> r.setEffect(act));
			final KeyFrame kf4 = new KeyFrame(Duration.millis(3 * duration), e -> c.setEffect(don));
			final KeyFrame kf5 = new KeyFrame(Duration.millis(4 * duration), e -> ha.setEffect(don));
			final KeyFrame kf6 = new KeyFrame(Duration.millis(5 * duration), e -> r.setEffect(don));
			final KeyFrame kf7 = new KeyFrame(Duration.millis(6 * duration), e -> c.setEffect(null));
			final KeyFrame kf8 = new KeyFrame(Duration.millis(7 * duration), e -> ha.setEffect(null));
			final KeyFrame kf9 = new KeyFrame(Duration.millis(8 * duration), e -> r.setEffect(null));
			final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);
			Platform.runLater(timeline::play);

			int i = Integer.parseInt(l.getText());
			if (n > 1 && n < 11)
			{
				deleteBitmapToken(positionX, positionY);
				setBitmapToken(c, n - i);

			}

			else if (n > 11)
			{
				deleteTokenBiggerThanTen(positionX, positionY);
				setBitmapToken(c, n - i);
			}

			else if (n == 11)
			{
				deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay, c.getCenterY() - labelInTokensRay);
				setBitmapToken(c, n - i);

			} else
			{
				deleteBitmapToken(positionX, positionY);
			}

			n = n - valueLab;

		}

	}

	void animationMinusLeftDoubleArrow(Circle c, Label l, LeftDoubleArrow ha, Rectangle r, int valueCirc, int valueLab)
	{
		double duration = 130;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.INDIANRED;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		double positionX = c.getCenterX() - 20;
		double positionY = c.getCenterY() - 20;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		if (valueCirc < valueLab)
		{
			setMiddleLabelText(cannotExecuteTransition);
		} else
		{
			int n = valueCirc;
			while (n > 0)
			{
				final KeyFrame kf1 = new KeyFrame(Duration.millis(0 * duration), e -> c.setEffect(act));
				final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
				final KeyFrame kf3 = new KeyFrame(Duration.millis(2 * duration), e -> r.setEffect(act));
				final KeyFrame kf4 = new KeyFrame(Duration.millis(3 * duration), e -> c.setEffect(don));
				final KeyFrame kf5 = new KeyFrame(Duration.millis(4 * duration), e -> ha.setEffect(don));
				final KeyFrame kf6 = new KeyFrame(Duration.millis(5 * duration), e -> r.setEffect(don));
				final KeyFrame kf7 = new KeyFrame(Duration.millis(6 * duration), e -> c.setEffect(null));
				final KeyFrame kf8 = new KeyFrame(Duration.millis(7 * duration), e -> ha.setEffect(null));
				final KeyFrame kf9 = new KeyFrame(Duration.millis(8 * duration), e -> r.setEffect(null));
				final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);
				Platform.runLater(timeline::play);

				int i = Integer.parseInt(l.getText());
				if (n > 1 && n < 11)
				{
					deleteBitmapToken(positionX, positionY);
					setBitmapToken(c, n - i);

				}

				else if (n > 11)
				{
					deleteTokenBiggerThanTen(positionX, positionY);
					setBitmapToken(c, n - i);
				}

				else if (n == 11)
				{
					deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay, c.getCenterY() - labelInTokensRay);
					setBitmapToken(c, n - i);

				} else
				{
					deleteBitmapToken(positionX, positionY);
				}

				n = n - valueLab;

			}

		}

	}

	void animationMinusRightDoubleArrow(Circle c, Label l, RightDoubleArrow ha, Rectangle r, int valueCirc,
			int valueLab)
	{
		double duration = 130;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.INDIANRED;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		double positionX = c.getCenterX() - 20;
		double positionY = c.getCenterY() - 20;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		if (valueCirc < valueLab)
		{
			setMiddleLabelText(cannotExecuteTransition);
		} else
		{
			int n = valueCirc;
			while (n > 0)
			{
				final KeyFrame kf1 = new KeyFrame(Duration.millis(0 * duration), e -> c.setEffect(act));
				final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
				final KeyFrame kf3 = new KeyFrame(Duration.millis(2 * duration), e -> r.setEffect(act));
				final KeyFrame kf4 = new KeyFrame(Duration.millis(3 * duration), e -> c.setEffect(don));
				final KeyFrame kf5 = new KeyFrame(Duration.millis(4 * duration), e -> ha.setEffect(don));
				final KeyFrame kf6 = new KeyFrame(Duration.millis(5 * duration), e -> r.setEffect(don));
				final KeyFrame kf7 = new KeyFrame(Duration.millis(6 * duration), e -> c.setEffect(null));
				final KeyFrame kf8 = new KeyFrame(Duration.millis(7 * duration), e -> ha.setEffect(null));
				final KeyFrame kf9 = new KeyFrame(Duration.millis(8 * duration), e -> r.setEffect(null));
				final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);
				Platform.runLater(timeline::play);

				int i = Integer.parseInt(l.getText());
				if (n > 1 && n < 11)
				{
					deleteBitmapToken(positionX, positionY);
					setBitmapToken(c, n - i);

				}

				else if (n > 11)
				{
					deleteTokenBiggerThanTen(positionX, positionY);
					setBitmapToken(c, n - i);
				}

				else if (n == 11)
				{
					deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay, c.getCenterY() - labelInTokensRay);
					setBitmapToken(c, n - i);

				} else
				{
					deleteBitmapToken(positionX, positionY);
				}

				n = n - valueLab;

			}

		}

	}

	void animationPlusHeadArrow(Circle c, Label l, HeadArrow ha, Rectangle r, int valueCirc, int valueLab)
	{
		double duration = 130;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.INDIANRED;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		double positionX = c.getCenterX() - 20;
		double positionY = c.getCenterY() - 20;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		int n = valueCirc;

		final KeyFrame kf1 = new KeyFrame(Duration.millis(0 * duration), e -> r.setEffect(act));
		final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
		final KeyFrame kf3 = new KeyFrame(Duration.millis(2 * duration), e -> c.setEffect(act));
		final KeyFrame kf4 = new KeyFrame(Duration.millis(3 * duration), e -> r.setEffect(don));
		final KeyFrame kf5 = new KeyFrame(Duration.millis(4 * duration), e -> ha.setEffect(don));
		final KeyFrame kf6 = new KeyFrame(Duration.millis(5 * duration), e -> c.setEffect(don));
		final KeyFrame kf7 = new KeyFrame(Duration.millis(6 * duration), e -> r.setEffect(null));
		final KeyFrame kf8 = new KeyFrame(Duration.millis(7 * duration), e -> ha.setEffect(null));
		final KeyFrame kf9 = new KeyFrame(Duration.millis(8 * duration), e -> c.setEffect(null));
		final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);
		Platform.runLater(timeline::play);
		int i = Integer.parseInt(l.getText());

		if (n > 1 && n < 11)
		{
			deleteBitmapToken(positionX, positionY);
			setBitmapToken(c, n + i);

		}

		else if (n > 11)
		{
			deleteTokenBiggerThanTen(positionX, positionY);
			setBitmapToken(c, n + i);
		}

		else if (n == 11)
		{
			deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay, c.getCenterY() - labelInTokensRay);
			setBitmapToken(c, n + i);

		} else
		{
			setBitmapToken(c, i);
		}

		n = n + valueLab;

	}

	void animationPlusLeftDoubleArrow(Circle c, Label l, LeftDoubleArrow ha, Rectangle r, int valueCirc, int valueLab)
	{
		double duration = 130;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.INDIANRED;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		double positionX = c.getCenterX() - 20;
		double positionY = c.getCenterY() - 20;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		int n = valueCirc;

		final KeyFrame kf1 = new KeyFrame(Duration.millis(0 * duration), e -> r.setEffect(act));
		final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
		final KeyFrame kf3 = new KeyFrame(Duration.millis(2 * duration), e -> c.setEffect(act));
		final KeyFrame kf4 = new KeyFrame(Duration.millis(3 * duration), e -> r.setEffect(don));
		final KeyFrame kf5 = new KeyFrame(Duration.millis(4 * duration), e -> ha.setEffect(don));
		final KeyFrame kf6 = new KeyFrame(Duration.millis(5 * duration), e -> c.setEffect(don));
		final KeyFrame kf7 = new KeyFrame(Duration.millis(6 * duration), e -> r.setEffect(null));
		final KeyFrame kf8 = new KeyFrame(Duration.millis(7 * duration), e -> ha.setEffect(null));
		final KeyFrame kf9 = new KeyFrame(Duration.millis(8 * duration), e -> c.setEffect(null));
		final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);
		Platform.runLater(timeline::play);
		int i = Integer.parseInt(l.getText());

		if (n > 1 && n < 11)
		{
			deleteBitmapToken(positionX, positionY);
			setBitmapToken(c, n + i);

		}

		else if (n > 11)
		{
			deleteTokenBiggerThanTen(positionX, positionY);
			setBitmapToken(c, n + i);
		}

		else if (n == 11)
		{
			deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay, c.getCenterY() - labelInTokensRay);
			setBitmapToken(c, n + i);

		} else
		{
			setBitmapToken(c, i);
		}

		n = n + valueLab;

	}

	void animationPlusRightDoubleArrow(Circle c, Label l, RightDoubleArrow ha, Rectangle r, int valueCirc, int valueLab)
	{
		double duration = 130;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.INDIANRED;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		double positionX = c.getCenterX() - 20;
		double positionY = c.getCenterY() - 20;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		int n = valueCirc;

		final KeyFrame kf1 = new KeyFrame(Duration.millis(0 * duration), e -> r.setEffect(act));
		final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
		final KeyFrame kf3 = new KeyFrame(Duration.millis(2 * duration), e -> c.setEffect(act));
		final KeyFrame kf4 = new KeyFrame(Duration.millis(3 * duration), e -> r.setEffect(don));
		final KeyFrame kf5 = new KeyFrame(Duration.millis(4 * duration), e -> ha.setEffect(don));
		final KeyFrame kf6 = new KeyFrame(Duration.millis(5 * duration), e -> c.setEffect(don));
		final KeyFrame kf7 = new KeyFrame(Duration.millis(6 * duration), e -> r.setEffect(null));
		final KeyFrame kf8 = new KeyFrame(Duration.millis(7 * duration), e -> ha.setEffect(null));
		final KeyFrame kf9 = new KeyFrame(Duration.millis(8 * duration), e -> c.setEffect(null));
		final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);
		Platform.runLater(timeline::play);
		int i = Integer.parseInt(l.getText());

		if (n > 1 && n < 11)
		{
			deleteBitmapToken(positionX, positionY);
			setBitmapToken(c, n + i);

		}

		else if (n > 11)
		{
			deleteTokenBiggerThanTen(positionX, positionY);
			setBitmapToken(c, n + i);
		}

		else if (n == 11)
		{
			deleteTokenBiggerThanTen(c.getCenterX() - labelInTokensRay, c.getCenterY() - labelInTokensRay);
			setBitmapToken(c, n + i);

		} else
		{
			setBitmapToken(c, i);
		}

		n = n + valueLab;

	}

	void animationWhoCantBeExecuteHeadArrow(Circle c, Label l, HeadArrow ha, Rectangle r)
	{
		double duration = 30;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.CRIMSON;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		final KeyFrame kf1 = new KeyFrame(Duration.millis(1 * duration), e -> r.setEffect(act));
		final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
		final KeyFrame kf3 = new KeyFrame(Duration.millis(1 * duration), e -> c.setEffect(act));
		final KeyFrame kf4 = new KeyFrame(Duration.millis(15 * duration), e -> r.setEffect(null));
		final KeyFrame kf5 = new KeyFrame(Duration.millis(15 * duration), e -> ha.setEffect(null));
		final KeyFrame kf6 = new KeyFrame(Duration.millis(15 * duration), e -> c.setEffect(null));
		final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6);
		Platform.runLater(timeline::play);

	}

	void animationWhoCantBeExecuteRightDoubleArrow(Circle c, Label l, RightDoubleArrow ha, Rectangle r)
	{
		double duration = 30;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.CRIMSON;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		final KeyFrame kf1 = new KeyFrame(Duration.millis(1 * duration), e -> r.setEffect(act));
		final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
		final KeyFrame kf3 = new KeyFrame(Duration.millis(1 * duration), e -> c.setEffect(act));
		final KeyFrame kf4 = new KeyFrame(Duration.millis(15 * duration), e -> r.setEffect(null));
		final KeyFrame kf5 = new KeyFrame(Duration.millis(15 * duration), e -> ha.setEffect(null));
		final KeyFrame kf6 = new KeyFrame(Duration.millis(15 * duration), e -> c.setEffect(null));
		final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6);
		Platform.runLater(timeline::play);

	}

	void animationWhoCantBeExecuteLeftDoubleArrow(Circle c, Label l, LeftDoubleArrow ha, Rectangle r)
	{
		double duration = 30;
		javafx.scene.paint.Color active = javafx.scene.paint.Color.CRIMSON;
		javafx.scene.paint.Color done = javafx.scene.paint.Color.DARKGRAY;

		Shadow act = new Shadow();
		act.setRadius(10.0f);
		act.setColor(active);

		Shadow don = new Shadow();
		don.setRadius(10.0f);
		don.setColor(done);

		final KeyFrame kf1 = new KeyFrame(Duration.millis(1 * duration), e -> r.setEffect(act));
		final KeyFrame kf2 = new KeyFrame(Duration.millis(1 * duration), e -> ha.setEffect(act));
		final KeyFrame kf3 = new KeyFrame(Duration.millis(1 * duration), e -> c.setEffect(act));
		final KeyFrame kf4 = new KeyFrame(Duration.millis(15 * duration), e -> r.setEffect(null));
		final KeyFrame kf5 = new KeyFrame(Duration.millis(15 * duration), e -> ha.setEffect(null));
		final KeyFrame kf6 = new KeyFrame(Duration.millis(15 * duration), e -> c.setEffect(null));
		final Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6);
		Platform.runLater(timeline::play);

	}

	public void openFile(String p)
	{
		try
		{
			for (Circle c : circleList)
			{
				mainPane.getChildren().remove(c);
			}

			for (Rectangle r : rectangleList)
			{
				mainPane.getChildren().remove(r);
			}

			for (HeadArrow ha : headArrowList)
			{
				ha.removeFromMainPane(mainPane);
			}

			for (RightDoubleArrow rda : rightDoubleArrowList)
			{
				rda.removeFromMainPane(mainPane);
			}

			for (LeftDoubleArrow lda : leftDoubleArrowList)
			{
				lda.removeFromMainPane(mainPane);
			}

			for (Label t : tokensBiggerThanTen)
			{
				mainPane.getChildren().remove(t);
			}

			for (ImageView iv : existingImageViews)
			{
				mainPane.getChildren().remove(iv);
			}

			for (Label l : tags)
			{
				mainPane.getChildren().remove(l);

			}

			utilities.clearAllLists(circleList, rectangleList, headArrowList, leftDoubleArrowList, rightDoubleArrowList,
					existingImageViews, tokensBiggerThanTen, tags, headArrowTags, rightDoubleArrowTags,
					leftDoubleArrowTags);

			NetParser lp = new NetParser(p);
			ObservableList<String> placesListFromFile = lp.getPlacesList();
			ObservableList<String> transitionsListFromFile = lp.getTransitionsList();
			ObservableList<String> flowsListFromFile = lp.getFlowsList();
			ObservableList<String> markingsListFromFile = lp.getInitialMarkingsList();

			double width = 1350;
			double height = 700;

			int obj = 1;

			for (String s : placesListFromFile)
			{

				Circle c = new Circle((obj * width / (placesListFromFile.size() + 1)), (2 * height / 3),
						20.0f, Paint.valueOf(circleColor));

				c.setStroke(Paint.valueOf("#555555"));
				c.setStrokeWidth(5.0f);
				c.setOnMousePressed(circleOnMousePressedEventHandler);
				circleList.add(c);
				this.mainPane.getChildren().add(c);
				obj++;
			}

			obj = 1;

			for (String s : transitionsListFromFile)
			{
				Rectangle r = new Rectangle((obj * width / (transitionsListFromFile.size() + 1)),
						minusWidth, 40.0f, 40.0f);
				r.setFill(Paint.valueOf(rectangleColor));
				r.setStroke(Paint.valueOf("#555555"));
				r.setStrokeWidth(5.0f);
				r.setOnMousePressed(squareOnMousePressedEventHandler);
				rectangleList.add(r);
				mainPane.getChildren().add(r);
				obj++;
			}


			boolean zeroFlag = false;
			for(String s : flowsListFromFile)
			{
				String[] parts = s.split(";");
				String transition = parts[0];
				transition = transition.replaceAll("\\D+","");

				Integer numberOfTransition = Integer.parseInt(transition);
				if(numberOfTransition == 0)
				{
					numberOfTransition = 1;
					zeroFlag = true;
				}
				if(zeroFlag)
				{
					numberOfTransition += 1;
				}
				Rectangle r = rectangleList.get(numberOfTransition - 1);

				String starts = parts[1];
				String[] startPoints = starts.split(",");
				for(String ins : startPoints)
				{

					if(ins.contains("*"))
					{
						ins = ins.replaceAll("s", "");
						ins = ins.replaceAll("p", "");
						Integer val = Integer.parseInt(ins.split("\\*")[0]);
						Integer lIndex = Integer.parseInt(ins.split("\\*")[1]);
						if(zeroFlag)
						{
							lIndex += 1;
						}
						Circle c = circleList.get(lIndex - 1);

						HeadArrow headArrow = new HeadArrow(c.getCenterX(), c.getCenterY(), r.getX() + 20, r.getY() + 20,
								mainPane);
						headArrow.setFill(arrowColor);
						headArrowList.add(headArrow);
						headArrow.addToMainPane(mainPane);

						LeftDoubleArrow left = new LeftDoubleArrow();
						Pair<Double, Double> pair = left.returnMiddlePoint(headArrow.getStartX(), headArrow.getStartY(),
								headArrow.getEndX(), headArrow.getEndY());
						double midX = pair.getKey();
						double midY = pair.getValue();
						Pair<Double, Double> pair2 = left.returnMoveXandY(headArrow.getStartX(), headArrow.getStartY(),
								headArrow.getEndX(), headArrow.getEndY());
						double mvX = pair2.getKey() / 5;
						double mvY = pair2.getValue() / 5;
						Label l = new Label();
						l.setText(String.valueOf(val));
						l.setLayoutX(midX + mvX);
						l.setLayoutY(midY + mvY);
						l.setFont(new Font("Arial", 16));
						l.setId("fancytext");
						mainPane.getChildren().add(l);
						tags.add(l);
						headArrowTags.put(l, headArrow);



					}
					else
					{
						ins = ins.replaceAll("\\D+","");
						Integer lIndex = Integer.parseInt(ins);
						Circle c = circleList.get(lIndex - 1);
						if(zeroFlag)
						{
							lIndex += 1;
						}
						HeadArrow headArrow = new HeadArrow(c.getCenterX(), c.getCenterY(), r.getX() + 20, r.getY() + 20,
								mainPane);
						headArrow.setFill(arrowColor);
						headArrowList.add(headArrow);
						headArrow.addToMainPane(mainPane);
					}

				}



				String ends = parts[2];
				String[] endPoints = ends.split(",");
				HeadArrow tempHeadArrow = null;

				for(String ins : endPoints)
				{
					if(ins.contains("*"))
					{
						ins = ins.replaceAll("s", "");
						ins = ins.replaceAll("p", "");
						Integer val = Integer.parseInt(ins.split("\\*")[0]);
						Integer lIndex = Integer.parseInt(ins.split("\\*")[1]);
						if(zeroFlag)
						{
							lIndex += 1;
						}
					}
					else
					{
						ins = ins.replaceAll("\\D+","");
						Integer lIndex = Integer.parseInt(ins);
						if(zeroFlag)
						{
							lIndex += 1;
						}
						Circle c = circleList.get(lIndex - 1);

						boolean flag = false;
						int index = -1;
						double control1X = 0, control2X = 0, control1Y = 0, control2Y = 0;
						for(HeadArrow ha : headArrowList)
						{
							if (ha.getStartX() == c.getCenterX() && ha.getStartY() == c.getCenterY() && ha.getEndX() == r.getX() + 20
									&& ha.getEndY() == r.getY() + 20)
							{
								flag = true;
								Pair<Double, Double> pair = doubleArrow.returnMiddlePoint(c.getCenterX(), c.getCenterY(), r.getX() + 20, r.getY() + 20);
								double midX = pair.getKey();
								double midY = pair.getValue();

								Pair<Double, Double> pair2 = doubleArrow.returnMoveXandY(ha.getEndX(), ha.getEndY(),
										ha.getStartX(), ha.getStartY());
								double moveX = pair2.getKey();
								double moveY = pair2.getValue();

								control1X = midX + moveX;
								control2X = midX - moveX;
								control1Y = midY + moveY;
								control2Y = midY - moveY;

								LeftDoubleArrow path1 = new LeftDoubleArrow(c.getCenterX(), c.getCenterY(), control1X, control1Y, r.getX() + 20, r.getY() + 20);

								RightDoubleArrow path2 = new RightDoubleArrow(ha.getEndX(), ha.getEndY(), control2X,
										control2Y, ha.getStartX(), ha.getStartY());

								path1.addToMainPane(mainPane);
								path2.addToMainPane(mainPane);

								path1.setFill(arrowColor);
								path2.setFill(arrowColor);

								leftDoubleArrowList.add(path1);
								rightDoubleArrowList.add(path2);

								index = headArrowList.indexOf(ha);
								tempHeadArrow = ha;
							}
						}

						if (flag)
						{
							if (index != -1)
							{
								tempHeadArrow.removeFromMainPane(mainPane);
								headArrowList.remove(index);
							}
						} else
						{
							HeadArrow headArrow = new HeadArrow(r.getX() + 20,  r.getY() + 20, c.getCenterX() , c.getCenterY(),
									mainPane);
							headArrow.setFill(arrowColor);
							headArrowList.add(headArrow);
							headArrow.addToMainPane(mainPane);

						}
						index = -1;
						flag = false;

					}





				}

			}

			zeroFlag = false;

			for(String s : markingsListFromFile)
			{
				String[] parts = s.split("\\,");
				for(String a : parts)
				{
					if(a.contains("*"))
					{
						String[] numberAndCirc = a.split("\\*");
						Integer val = Integer.parseInt(numberAndCirc[0]);

						String partTwo = numberAndCirc[1];
						partTwo = partTwo.replaceAll("\\D+", "");
						Integer num = Integer.parseInt(partTwo);
						Circle c = circleList.get(num-1);
						setBitmapToken(c, val);
					}
					else
					{
						a = a.replaceAll("\\D+","");
						Integer num = Integer.parseInt(a);
						Circle c = circleList.get(num-1);
						setBitmapToken(c, 1);

					}
				}
			}



		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}