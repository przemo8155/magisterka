
package application;

import javafx.collections.ObservableList;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Pair;

public class LeftDoubleArrow
{

	public double x1, y1, x2, y2;

	public Path path = new Path();
	public MoveTo moveTo = new MoveTo();
	public QuadCurveTo quadTo = new QuadCurveTo();
	public HeadArrow headArrow = new HeadArrow();
	public Line left, right;


	private static double arrowLength = 30.0;
	private static double arrowAngle = Math.toRadians(8.0);

	static int doubleArrowMove = 100;

	static double maxMove = 12.0;
	static double multiply = 0.01111111111111;

	public static double moveInDoubleLine = 50.0f;

	public double startPointX, startPointY, endPointX, endPointY, controlX, controlY;

	public LeftDoubleArrow()
	{

	}

	public Pair<Double, Double> getTag(double firstX, double firstY, double contX, double contY, double secX, double secY)
	{
		Pair<Double, Double> pair = returnMiddlePoint(firstX, firstY, secX, secY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(firstX, firstY, secX, secY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		double control1X = midX + moveX;
		double control1Y = midY + moveY;

		return new Pair<>(control1X, control1Y);
	}

	public Pair<Double, Double> returnMiddlePoint(double firstX, double firstY, double secX, double secY)
	{
		double midX = (firstX + secX) / 2;
		double midY = (firstY + secY) / 2;
		return new Pair<>(midX, midY);
	}

	public Pair<Double, Double> returnMoveXandY(double firstX, double firstY, double secX, double secY)
	{
		double angle = headArrow.returnAngle(firstX, firstY, secX, secY);
		double calcAngle = angle % 90;
		double mvX = ((90 - calcAngle) * multiply) * moveInDoubleLine;
		double mvY = calcAngle * multiply * moveInDoubleLine;
		if (angle >= 0 && angle <= 90 || angle > 180 && angle <= 270)
		{
			return new Pair<>(moveInDoubleLine - mvX, moveInDoubleLine - mvY);

		} else
			return new Pair<>(mvX, mvY);


	}

	public final void setRight(double valX, double valY, Pane gc)
	{
		gc.getChildren().remove(right);
		this.x1 = valX;
		this.y1 = valY;
		double arrowLength = 30;
		double arrowWidth = 5;
		double sx = this.controlX;
		double ex = this.endPointX;
		double sy = this.controlY;
		double ey = this.endPointY;
		double factor = arrowLength / Math.hypot(sx - ex, sy - ey);
		double factorO = arrowWidth / Math.hypot(sx - ex, sy - ey);

		// part in direction of main line
		double dx = (sx - ex) * factor;
		double dy = (sy - ey) * factor;

		// part ortogonal to main line
		double ox = (sx - ex) * factorO;
		double oy = (sy - ey) * factorO;

		double myAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);
		double calX = headArrow.calculateX(myAngle);
		double calY = headArrow.calculateY(myAngle);

		this.right = new Line(endPointX - calX, endPointY - calY, ex + dx + oy - calX, ey + dy - ox - calY);
		right.setStrokeWidth(5.0f);
		gc.getChildren().add(right);
	}

	public final void setLeft(double valX, double valY, Pane gc)
	{
		gc.getChildren().remove(left);
		this.x1 = valX;
		this.y1 = valY;
		double arrowLength = 30;
		double arrowWidth = 5;
		double sx = this.controlX;
		double ex = this.endPointX;
		double sy = this.controlY;
		double ey = this.endPointY;
		double factor = arrowLength / Math.hypot(sx - ex, sy - ey);
		double factorO = arrowWidth / Math.hypot(sx - ex, sy - ey);

		// part in direction of main line
		double dx = (sx - ex) * factor;
		double dy = (sy - ey) * factor;

		// part ortogonal to main line
		double ox = (sx - ex) * factorO;
		double oy = (sy - ey) * factorO;

		double myAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);
		double calX = headArrow.calculateX(myAngle);
		double calY = headArrow.calculateY(myAngle);

		this.left = new Line(endPointX - calX, endPointY - calY, ex + dx - oy - calX, ey + dy + ox - calY);
		left.setStrokeWidth(5.0f);
		gc.getChildren().add(left);
	}

	public LeftDoubleArrow(double firstX, double firstY, double contX, double contY, double secX, double secY)
	{
		double angle = headArrow.returnAngle(firstX, firstY, secX, secY);
		double myX = headArrow.calculateX(angle);
		double myY = headArrow.calculateY(angle);

		double dx = contX - secX;
		double dy = contY - secY;
		double angle2 = Math.atan2(dy, dx);
		double x1 = Math.cos(angle2 + arrowAngle) * arrowLength + secX;
		double y1 = Math.sin(angle2 + arrowAngle) * arrowLength + secY;

		double x2 = Math.cos(angle2 - arrowAngle) * arrowLength + secX;
		double y2 = Math.sin(angle2 - arrowAngle) * arrowLength + secY;

		this.startPointX = firstX;
		this.startPointY = firstY;
		this.endPointX = secX;
		this.endPointY = secY;
		this.controlX = contX;
		this.controlY = contY;

		this.moveTo.setX(startPointX + myX);
		this.moveTo.setY(startPointY + myY);
		this.quadTo.setControlX(contX);
		this.quadTo.setControlY(contY);
		this.quadTo.setX(endPointX - myX);
		this.quadTo.setY(endPointY - myY);

		this.left = new Line(secX - myX, secY - myY, x1 - myX, y1 - myY);
		left.setStrokeWidth(5.0f);
		this.right = new Line(secX - myX, secY - myY, x2 - myX, y2 - myY);
		right.setStrokeWidth(5.0f);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

	}

	public void addToMainPane(Pane gc)
	{
		gc.getChildren().add(this.path);
		gc.getChildren().add(this.left);
		gc.getChildren().add(this.right);
	}

	public final void setLeftArrowStartX(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.startPointX = val;
		this.path = new Path();

		double angle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);
		double myX = headArrow.calculateX(angle);
		double myY = headArrow.calculateY(angle);

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX + moveX;
		this.controlY = midY + moveY;

		this.moveTo.setX(startPointX + myX);
		this.moveTo.setY(startPointY + myY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX - myX);
		this.quadTo.setY(endPointY - myY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);
		gc.getChildren().add(this.path);

	}

	public final void setLeftArrowStartY(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.startPointY = val;
		this.path = new Path();

		double angle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);
		double myX = headArrow.calculateX(angle);
		double myY = headArrow.calculateY(angle);

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX + moveX;
		this.controlY = midY + moveY;

		this.moveTo.setX(startPointX + myX);
		this.moveTo.setY(startPointY + myY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX - myX);
		this.quadTo.setY(endPointY - myY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public final void setLeftArrowEndX(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.endPointX = val;
		this.path = new Path();

		double angle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);
		double myX = headArrow.calculateX(angle);
		double myY = headArrow.calculateY(angle);

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX + moveX;
		this.controlY = midY + moveY;

		this.moveTo.setX(startPointX + myX);
		this.moveTo.setY(startPointY + myY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX - myX);
		this.quadTo.setY(endPointY - myY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public final void setLeftArrowEndY(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.endPointY = val;
		this.path = new Path();

		double angle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);
		double myX = headArrow.calculateX(angle);
		double myY = headArrow.calculateY(angle);

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX + moveX;
		this.controlY = midY + moveY;

		this.moveTo.setX(startPointX + myX);
		this.moveTo.setY(startPointY + myY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX - myX);
		this.quadTo.setY(endPointY - myY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public final void setRightArrowStartX(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.startPointX = val;
		this.path = new Path();

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX - moveX;
		this.controlY = midY - moveY;

		this.moveTo.setX(startPointX);
		this.moveTo.setY(startPointY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX);
		this.quadTo.setY(endPointY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);
		gc.getChildren().add(this.path);

	}

	public final void setRightArrowStartY(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.startPointY = val;
		this.path = new Path();

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX - moveX;
		this.controlY = midY - moveY;

		this.moveTo.setX(startPointX);
		this.moveTo.setY(startPointY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX);
		this.quadTo.setY(endPointY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public final void setRightArrowEndX(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.endPointX = val;
		this.path = new Path();

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX - moveX;
		this.controlY = midY - moveY;

		this.moveTo.setX(startPointX);
		this.moveTo.setY(startPointY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX);
		this.quadTo.setY(endPointY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public final void setRightArrowEndY(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.endPointY = val;
		this.path = new Path();

		Pair<Double, Double> pair = returnMiddlePoint(startPointX, startPointY, endPointX, endPointY);
		double midX = pair.getKey();
		double midY = pair.getValue();

		Pair<Double, Double> pair2 = returnMoveXandY(startPointX, startPointY, endPointX, endPointY);
		double moveX = pair2.getKey();
		double moveY = pair2.getValue();

		this.controlX = midX - moveX;
		this.controlY = midY - moveY;

		this.moveTo.setX(startPointX);
		this.moveTo.setY(startPointY);
		this.quadTo.setControlX(controlX);
		this.quadTo.setControlY(controlY);
		this.quadTo.setX(endPointX);
		this.quadTo.setY(endPointY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public LeftDoubleArrow(double firstX, double firstY, double contX, double contY, double secX, double secY, Pane gc,
			String paint)
	{
		double mainAngle = headArrow.returnAngle(firstX, firstY, secX, secY);

		double angle1 = headArrow.returnAngle(firstY, firstY, contX, contY);
		double cutX1 = headArrow.calculateX(angle1);
		double cutY1 = headArrow.calculateY(angle1);

		double angle2 = headArrow.returnAngle(contX, contY, secX, secY);
		double cutX2 = headArrow.calculateX(angle2);
		double cutY2 = headArrow.calculateY(angle2);

		this.startPointX = firstX;
		this.startPointY = firstY;
		this.endPointX = secX;
		this.endPointY = secY;
		this.controlX = contX;
		this.controlY = contY;

		if (mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(firstX + cutX1);
			this.moveTo.setY(firstY + cutY1);
			this.quadTo.setControlX(contX);
			this.quadTo.setControlY(contY);
			this.quadTo.setX(secX - cutX2);
			this.quadTo.setY(secY - cutY2);
		}

		if (mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(firstX - cutX1);
			this.moveTo.setY(firstY + cutY1);
			this.quadTo.setControlX(contX);
			this.quadTo.setControlY(contY);
			this.quadTo.setX(secX - cutX2);
			this.quadTo.setY(secY - cutY2);
		}

		if (mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(firstX - cutX1);
			this.moveTo.setY(firstY + cutY1);
			this.quadTo.setControlX(contX);
			this.quadTo.setControlY(contY);
			this.quadTo.setX(secX - cutX2);
			this.quadTo.setY(secY - cutY2);
		}

		if (mainAngle > 270 && mainAngle <= 360)
		{
			this.moveTo.setX(firstX + cutX1);
			this.moveTo.setY(firstY + cutY1);
			this.quadTo.setControlX(contX);
			this.quadTo.setControlY(contY);
			this.quadTo.setX(secX - cutX2);
			this.quadTo.setY(secY - cutY2);
		}

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);
		this.path.setStroke(Paint.valueOf(paint));

		gc.getChildren().add(this.path);
	}

	public final double getControlX()
	{
		return this.controlX;
	}

	public final double getControlY()
	{
		return this.controlY;
	}

	public final double getStartX()
	{
		return this.startPointX;
	}

	public final double getStartY()
	{
		return this.startPointY;
	}

	public final double getEndX()
	{
		return this.endPointX;
	}

	public final double getEndY()
	{
		return this.endPointY;
	}

	public double calculateDoubleArrowX(double angle, double firstX, double firstY, double secX, double secY)
	{
		double mainAngle = headArrow.returnAngle(firstX, firstY, secX, secY);

		double reducedAngle = mainAngle % 90;

		double myMultiply = reducedAngle * multiply;

		double moveX = myMultiply * maxMove;

	if (mainAngle > 180 && mainAngle <= 360)
		{
			return maxMove - moveX;
		} else
			return moveX;


	}

	public double calculateDoubleArrowY(double angle, double firstX, double firstY, double secX, double secY)
	{
		double mainAngle = headArrow.returnAngle(firstX, firstY, secX, secY);

		double reducedAngle = mainAngle % 90;

		double myMultiply = reducedAngle * multiply;

		double moveY = (1 - myMultiply) * maxMove;

		if (mainAngle > 180 && mainAngle <= 360)
		{
			return maxMove - moveY;
		} else
			return moveY;

	}

	public void removeFromMainPane(Pane gc)
	{
		gc.getChildren().remove(this.path);
		gc.getChildren().remove(this.left);
		gc.getChildren().remove(this.right);
	}

	public void setFill(ObservableList<LeftDoubleArrow> list, String val)
	{
		for (LeftDoubleArrow ha : list)
		{
			ha.path.setStroke(Paint.valueOf(val));
			ha.left.setStroke(Paint.valueOf(val));
			ha.right.setStroke(Paint.valueOf(val));
		}
	}

	public void setFill(String val)
	{
		this.path.setStroke(Paint.valueOf(val));
		this.left.setStroke(Paint.valueOf(val));
		this.right.setStroke(Paint.valueOf(val));
	}

	public void setEffect(Effect effect)
	{
		this.path.setEffect(effect);
		this.left.setEffect(effect);
		this.right.setEffect(effect);
	}

}
