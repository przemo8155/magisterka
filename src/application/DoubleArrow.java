
package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Pair;

public class DoubleArrow
{

	Path path = new Path();
	MoveTo moveTo = new MoveTo();
	QuadCurveTo quadTo = new QuadCurveTo();
	HeadArrow headArrow = new HeadArrow();

	static int doubleArrowMove = 100;

	static double maxMove = 12.0;
	static double multiply = 0.01111111111111;

	public static double moveInDoubleLine = 50.0f;

	public double startPointX, startPointY, endPointX, endPointY, controlX, controlY;

	public DoubleArrow()
	{

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
		double mvX = ((90 - calcAngle) * multiply)  * moveInDoubleLine;
		double mvY = calcAngle * multiply * moveInDoubleLine;
		if(angle >= 0 && angle <= 90 || angle > 180 && angle <= 270)
		{
			return new Pair<>(moveInDoubleLine-mvX,moveInDoubleLine-mvY);

		}
		else
			return new Pair<>(mvX,mvY);
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

	public DoubleArrow(double firstX, double firstY, double contX, double contY, double secX, double secY, Pane gc)
	{
		this.startPointX = firstX;
		this.startPointY = firstY;
		this.endPointX = secX;
		this.endPointY = secY;
		this.controlX = contX;
		this.controlY = contY;

		this.moveTo.setX(startPointX);
		this.moveTo.setY(startPointY);
		this.quadTo.setControlX(contX);
		this.quadTo.setControlY(contY);
		this.quadTo.setX(endPointX);
		this.quadTo.setY(endPointY);

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);
	}
	public DoubleArrow(double firstX, double firstY, double contX, double contY, double secX, double secY, Pane gc,
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

	public final void setStartX(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.startPointX = val;
		this.path = new Path();
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);

		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove) + ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove) + ((startPointY + endPointY) / 2);

		if (mainAngle > 35 && mainAngle < 55)
		{
			mvX = ((startPointX + endPointX) / 2) + 50;
			mvY = ((startPointY + endPointY) / 2) - 50;
		}

		double angle1 = headArrow.returnAngle(startPointX, startPointY, mvX, mvY);
		double angle2 = headArrow.returnAngle(mvX, mvY, endPointX, endPointY);

		double cutX1 = headArrow.calculateX(angle1);
		double cutY1 = headArrow.calculateY(angle1);

		double cutX2 = headArrow.calculateX(angle2);
		double cutY2 = headArrow.calculateY(angle2);

		if (mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 270 && mainAngle <= 360)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);
		gc.getChildren().add(this.path);

		/*
		 * this.path = new Path(); double mainAngle2 =
		 * headArrow.returnAngle(endPointX, endPointY, startPointX,
		 * startPointY); mainAngle2 = mainAngle % 90; double eAngle2 = 90.0 -
		 * mainAngle;
		 *
		 * double mvX2 = ((mainAngle2 / 90.0) * doubleArrowMove) + ((startPointX
		 * + endPointX) / 2);
		 *
		 * double mvY2 = ((eAngle2 / 90.0) * doubleArrowMove) + ((startPointY +
		 * endPointY) / 2);
		 *
		 * if (mainAngle2 > 35 && mainAngle2 < 55) { mvX = ((startPointX +
		 * endPointX) / 2) + 50; mvY = ((startPointY + endPointY) / 2) - 50; }
		 *
		 * double angle3 = headArrow.returnAngle(endPointX, endPointY, mvX2,
		 * mvY2); double angle4 = headArrow.returnAngle(mvX2, mvY2, startPointX,
		 * startPointY);
		 *
		 * double cutX3 = headArrow.calculateX(angle3); double cutY3 =
		 * headArrow.calculateY(angle3);
		 *
		 * double cutX4 = headArrow.calculateX(angle4); double cutY4 =
		 * headArrow.calculateY(angle4);
		 *
		 * if(mainAngle2 >= 0 && mainAngle2 <= 90) { this.moveTo.setX(endPointX
		 * + cutX3); this.moveTo.setY(endPointY + cutY3);
		 * this.quadTo.setControlX(mvX2); this.quadTo.setControlY(mvY2);
		 * this.quadTo.setX(startPointX - cutX4); this.quadTo.setY(startPointY -
		 * cutY4); }
		 *
		 * if(mainAngle2 > 90 && mainAngle2 <= 180) { this.moveTo.setX(endPointX
		 * - cutX3); this.moveTo.setY(endPointY + cutY3);
		 * this.quadTo.setControlX(mvX2); this.quadTo.setControlY(mvY2);
		 * this.quadTo.setX(startPointX - cutX4); this.quadTo.setY(startPointY -
		 * cutY4); }
		 *
		 * if(mainAngle > 180 && mainAngle <= 270) { this.moveTo.setX(endPointX
		 * - cutX3); this.moveTo.setY(endPointY + cutY3);
		 * this.quadTo.setControlX(mvX2); this.quadTo.setControlY(mvY2);
		 * this.quadTo.setX(startPointX - cutX4); this.quadTo.setY(startPointY -
		 * cutY4); }
		 *
		 * if(mainAngle > 270 && mainAngle <= 360) { this.moveTo.setX(endPointX
		 * + cutX3); this.moveTo.setY(endPointY + cutY3);
		 * this.quadTo.setControlX(mvX2); this.quadTo.setControlY(mvY2);
		 * this.quadTo.setX(startPointX - cutX4); this.quadTo.setY(startPointY -
		 * cutY4); }
		 *
		 *
		 *
		 * this.path.getElements().add(this.moveTo);
		 * this.path.getElements().add(this.quadTo);
		 *
		 * this.path.setStrokeWidth(5.0f);
		 *
		 * gc.getChildren().add(this.path);
		 */

	}

	public final void setStartY(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.startPointY = val;
		this.path = new Path();
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);

		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove) + ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove) + ((startPointY + endPointY) / 2);

		if (mainAngle > 35 && mainAngle < 55)
		{
			mvX = ((startPointX + endPointX) / 2) + 50;
			mvY = ((startPointY + endPointY) / 2) - 50;
		}

		double angle1 = headArrow.returnAngle(startPointX, startPointY, mvX, mvY);
		double angle2 = headArrow.returnAngle(mvX, mvY, endPointX, endPointY);

		double cutX1 = headArrow.calculateX(angle1);
		double cutY1 = headArrow.calculateY(angle1);

		double cutX2 = headArrow.calculateX(angle2);
		double cutY2 = headArrow.calculateY(angle2);

		if (mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 270 && mainAngle <= 360)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public final void setEndX(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.endPointX = val;
		this.path = new Path();
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);

		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove) + ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove) + ((startPointY + endPointY) / 2);

		if (mainAngle > 35 && mainAngle < 55)
		{
			mvX = ((startPointX + endPointX) / 2) + 50;
			mvY = ((startPointY + endPointY) / 2) - 50;
		}

		double angle1 = headArrow.returnAngle(startPointX, startPointY, mvX, mvY);
		double angle2 = headArrow.returnAngle(mvX, mvY, endPointX, endPointY);

		double cutX1 = headArrow.calculateX(angle1);
		double cutY1 = headArrow.calculateY(angle1);

		double cutX2 = headArrow.calculateX(angle2);
		double cutY2 = headArrow.calculateY(angle2);

		if (mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 270 && mainAngle <= 360)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	public final void setEndY(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.endPointY = val;
		this.path = new Path();
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);

		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove) + ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove) + ((startPointY + endPointY) / 2);

		if (mainAngle > 35 && mainAngle < 55)
		{
			mvX = ((startPointX + endPointX) / 2) + 50;
			mvY = ((startPointY + endPointY) / 2) - 50;
		}

		double angle1 = headArrow.returnAngle(startPointX, startPointY, mvX, mvY);
		double angle2 = headArrow.returnAngle(mvX, mvY, endPointX, endPointY);

		double cutX1 = headArrow.calculateX(angle1);
		double cutY1 = headArrow.calculateY(angle1);

		double cutX2 = headArrow.calculateX(angle2);
		double cutY2 = headArrow.calculateY(angle2);

		if (mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if (mainAngle > 270 && mainAngle <= 360)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		this.path.getElements().add(this.moveTo);
		this.path.getElements().add(this.quadTo);

		this.path.setStrokeWidth(5.0f);

		gc.getChildren().add(this.path);

	}

	// TEMP
	/*
	 * HeadArrow tempHa = new HeadArrow();
	 *
	 * double oldAngle = tempHa.returnAngle(ha.getEndX(), ha.getEndY(),
	 * ha.getStartX(), ha.getStartY()); oldAngle = oldAngle % 90; double
	 * oldEAngle = 90.0 - oldAngle; double oldMvX = ((ha.getEndX() +
	 * ha.getStartX()) / 2) - ((oldAngle / 90.0) * doubleArrowMove); double
	 * oldMvY = ((ha.getEndY() + ha.getStartY()) / 2) - ((oldEAngle / 90.0) *
	 * doubleArrowMove);
	 *
	 * DoubleArrow da1 = new DoubleArrow(ha.getEndX(), ha.getEndY(), oldMvX,
	 * oldMvY, ha.getStartX(), ha.getStartY(), mainPane, arrowColor);
	 * doubleArrowList.add(da1);
	 *
	 * double angle = tempHa.returnAngle(_cFirstPosX, _cFirstPosY, _cSecPosX,
	 * _cSecPosY); angle = angle % 90; double eAngle = 90.0 - angle; double mvX
	 * = ((angle / 90.0) * doubleArrowMove) + ((_cFirstPosX + _cSecPosX) / 2);
	 * double mvY = ((eAngle / 90.0) * doubleArrowMove) + ((_cFirstPosY +
	 * _cSecPosY) / 2); if (angle > 35 && angle < 55) { mvX = ((_cFirstPosX +
	 * _cSecPosX) / 2) + 50; mvY = ((_cFirstPosY + _cSecPosY) / 2) - 50; }
	 *
	 * DoubleArrow da2 = new DoubleArrow(_cFirstPosX, _cFirstPosY, mvX, mvY,
	 * _cSecPosX, _cSecPosY, mainPane, arrowColor); doubleArrowList.add(da2);
	 *
	 * ha.removeFromMainPane(mainPane); _index = headArrowList.indexOf(ha);
	 */

	/*
	 * HeadArrow tempHa = new HeadArrow();
	 *
	 * double oldAngle = tempHa.returnAngle(ha.getEndX(), ha.getEndY(),
	 * ha.getStartX(), ha.getStartY()); oldAngle = oldAngle % 90; double
	 * oldEAngle = 90.0 - oldAngle; double oldMvX = ((ha.getEndX() +
	 * ha.getStartX()) / 2) - ((oldAngle / 90.0) * doubleArrowMove); double
	 * oldMvY = ((ha.getEndY() + ha.getStartY()) / 2) - ((oldEAngle / 90.0) *
	 * doubleArrowMove);
	 *
	 * DoubleArrow da1 = new DoubleArrow(ha.getEndX(), ha.getEndY(), oldMvX,
	 * oldMvY, ha.getStartX(), ha.getStartY(), mainPane, arrowColor);
	 * doubleArrowList.add(da1);
	 *
	 * double angle = tempHa.returnAngle(_cFirstPosX, _cFirstPosY, _cSecPosX,
	 * _cSecPosY); angle = angle % 90; double eAngle = 90.0 - angle; double mvX
	 * = ((angle / 90.0) * doubleArrowMove) + ((_cFirstPosX + _cSecPosX) / 2);
	 * double mvY = ((eAngle / 90.0) * doubleArrowMove) + ((_cFirstPosY +
	 * _cSecPosY) / 2); if (angle > 35 && angle < 55) { mvX = ((_cFirstPosX +
	 * _cSecPosX) / 2) + 50; mvY = ((_cFirstPosY + _cSecPosY) / 2) - 50; }
	 *
	 * DoubleArrow da2 = new DoubleArrow(_cFirstPosX, _cFirstPosY, mvX, mvY,
	 * _cSecPosX, _cSecPosY, mainPane, arrowColor); doubleArrowList.add(da2);
	 *
	 * ha.removeFromMainPane(mainPane); _index = headArrowList.indexOf(ha);
	 */

}
