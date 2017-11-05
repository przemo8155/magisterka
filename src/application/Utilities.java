
package application;

import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

public class Utilities
{

	private MainWindowController mwc;

	public Boolean checkCleared = false;

	public void clearUpMessage(Pane pane, String title, String header, String content, ObservableList<Circle> circ,
			ObservableList<Rectangle> rect, ObservableList<HeadArrow> lin, ObservableList<LeftDoubleArrow> leftDoubleArrows,
			ObservableList<RightDoubleArrow> rightDoubleArrows,  ObservableList<ImageView> imageViews, ObservableList<Label> labelList)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
		{
			pane.getChildren().clear();
			circ.clear();
			rect.clear();
			lin.clear();
			leftDoubleArrows.clear();
			rightDoubleArrows.clear();
			imageViews.clear();
			labelList.clear();
			checkCleared = true;
		} else
		{
			checkCleared = false;
		}
	}

	public static void infoBox(String infoMessage)
	{
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void doubleBox(Double infoMessage)
	{
		JOptionPane.showMessageDialog(null, infoMessage.toString(), "InfoBox:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void intBox(int infoMessage)
	{
		JOptionPane.showMessageDialog(null, Integer.toString(infoMessage), "InfoBox:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void booleanBox(boolean infoMessage)
	{
		JOptionPane.showMessageDialog(null, Boolean.toString(infoMessage), "InfoBox:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exitFromApplication()
	{
		Platform.exit();
		System.exit(0);
	}

	public int takeMaximumFromLists(ObservableList<Circle> circle, ObservableList<Rectangle> rectangle,
			ObservableList<HeadArrow> arrow, ObservableList<LeftDoubleArrow> da, ObservableList<RightDoubleArrow> da2)
	{
		int w = 0;
		w = circle.size() + rectangle.size() + arrow.size() + da.size() + da2.size();
		return w;
	}

	public void clearAllLists(ObservableList<Circle> circ, ObservableList<Rectangle> rect, ObservableList<HeadArrow> arr, ObservableList<LeftDoubleArrow> lda, ObservableList<RightDoubleArrow> rda, ObservableList<ImageView> images, ObservableList<Label> labelList)
	{
		circ.clear();
		rect.clear();
		arr.clear();
		lda.clear();
		rda.clear();
		images.clear();
		labelList.clear();
	}

	public void clearStartAndEndLineLists(ObservableList<Line> lin1, ObservableList<Line> lin2)
	{
		lin1.clear();
		lin2.clear();
	}

	public void clearStartAndEndHeadArrowLists(ObservableList<HeadArrow> lin1, ObservableList<HeadArrow> lin2)
	{
		lin1.clear();
		lin2.clear();
	}

	public void showCircleList(ObservableList<Circle> circle)
	{
		for (Circle c : circle)
		{
			Utilities.infoBox(c.toString());
		}
	}

	public void showLineList(ObservableList<Line> line)
	{
		for (Line l : line)
		{
			Utilities.infoBox(l.toString());
		}
	}


	public void clearStartAndEndArrowLists(ObservableList<Arrow> lin1, ObservableList<Arrow> lin2)
	{
		lin1.clear();
		lin2.clear();
	}

	public void clearStartAndEndLeftDoubleArrowLists(ObservableList<LeftDoubleArrow> lin1, ObservableList<LeftDoubleArrow> lin2)
	{
		lin1.clear();
		lin2.clear();
	}

	public void clearStartAndEndRightDoubleArrowLists(ObservableList<RightDoubleArrow> lin1, ObservableList<RightDoubleArrow> lin2)
	{
		lin1.clear();
		lin2.clear();
	}

	public Shape createHandDrawnLine(double x1, double y1, double x2, double y2, double strokeWidth, Pane pane) {
        Point2D startPoint = new Point2D(x1, y1);
        Point2D endPoint = new Point2D(x2, y2);

        double wobble = Math.sqrt((endPoint.getX() - startPoint.getX()) * (endPoint.getX() - startPoint.getX()) + (endPoint.getY() - startPoint.getY()) * (endPoint.getY() - startPoint.getY())) / 25;

        double r1 = Math.random();
        double r2 = Math.random();

        double xfactor = Math.random() > 0.5 ? wobble : -wobble;
        double yfactor = Math.random() > 0.5 ? wobble : -wobble;

        Point2D control1 = new Point2D((endPoint.getX() - startPoint.getX()) * r1 + startPoint.getX() + xfactor, (endPoint.getY() - startPoint.getY()) * r1 + startPoint.getY() + yfactor);
        Point2D control2 = new Point2D((endPoint.getX() - startPoint.getX()) * r2 + startPoint.getX() - xfactor, (endPoint.getY() - startPoint.getY()) * r2 + startPoint.getY() - yfactor);

        MoveTo startMove = new MoveTo(startPoint.getX(), startPoint.getY());
        CubicCurveTo curve = new CubicCurveTo(control1.getX(), control1.getY(),
                control2.getX(), control2.getY(),
                endPoint.getX(), endPoint.getY());

        Path path = new Path(startMove, curve);
        path.setStrokeLineCap(StrokeLineCap.ROUND);
        path.setStrokeWidth(strokeWidth + (strokeWidth * (Math.random() - 0.5) / 8.0));
        path.setStrokeType(StrokeType.CENTERED);
        pane.getChildren().add(path);
        return path;
    }

	 public Shape createHandDrawnArrow(double x1, double y1, double x2, double y2, double strokeWidth, Pane pane) {
	        Shape line = createHandDrawnLine(x1, y1, x2, y2, strokeWidth, pane);

	        double arrowlenght = strokeWidth * 5;
	        double distance = Math.sqrt(Math.pow(x2 -x1, 2) + Math.pow(y2 -y1, 2));
	        double unrotatedX = x2 + ((x1 - x2) / distance) * arrowlenght;
	        double unrotatedY = y2 + ((y1 - y2) / distance) * arrowlenght;

	        Point2D rotated1 = new Point2D(x2 + (unrotatedX - x2)*Math.cos(0.5) - (unrotatedY - y2)*Math.sin(0.5), y2 + (unrotatedX - x2)*Math.sin(0.5) + (unrotatedY - y2)*Math.cos(0.5));
	        Shape arrowLeft = createHandDrawnLine(x2, y2, rotated1.getX(), rotated1.getY(), strokeWidth, pane);

	        Point2D rotated2 = new Point2D(x2 + (unrotatedX - x2)*Math.cos(-0.5) - (unrotatedY - y2)*Math.sin(-0.5), y2 + (unrotatedX - x2)*Math.sin(-0.5) + (unrotatedY - y2)*Math.cos(-0.5));
	        Shape arrowRight = createHandDrawnLine(x2, y2, rotated2.getX(), rotated2.getY(), strokeWidth, pane);
	        return Shape.union(line, Shape.union(arrowLeft, arrowRight));
	    }


	 public void refreshCreatedLine(ObservableList<HeadArrow> arr, ObservableList<Circle> cir, ObservableList<Rectangle> rec, Pane gc)
	 {
		 gc.getChildren().remove(arr.size() + cir.size() + rec.size() - 2);
		 gc.getChildren().remove(arr.size() + cir.size() + rec.size() - 1);

		 arr.remove(arr.size() - 2);
	 }


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




}
