package application;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class HeadArrow
{
	public double x1, y1, x2, y2;

	public double startPointX, startPointY, endPointX, endPointY;

	public Line main;
	public Line left, right;

	private static int width = 15;

	public HeadArrow()
	{

	}

	public double returnAngle(double ax1, double ay1, double ax2, double ay2)
	{
		double angle = 0;
		double absX = Math.abs(ax1 - ax2);
		double absY = Math.abs(ay1 - ay2);
		double t = 0, localAngle = 0;

		int cwiartka = 0;


		if(ax1 < ax2 && ay1 > ay2)
		{
			cwiartka = 1;
		}

		if(ax1 < ax2 && ay1 < ay2)
		{
			cwiartka = 2;
		}

		if(ax1 > ax2 && ay1 < ay2)
		{
			cwiartka = 3;
		}

		if(ax1 > ax2 && ay1 > ay2)
		{
			cwiartka = 4;
		}

		switch(cwiartka)
		{
			case 1:
				t = absX / absY;
				localAngle = Math.atan2(absY, absX);
				angle = 360.0 - Math.toDegrees(localAngle);
				break;
			case 2:
				t = absX / absY;
				localAngle = Math.atan2(absY, absX);
				angle = Math.toDegrees(localAngle);
				break;
			case 3:
				t = absX / absY;
				localAngle = Math.atan2(absY, absX);
				angle = 180.0 - Math.toDegrees(localAngle);
				break;
			case 4:
				t = absX / absY;
				localAngle = Math.atan2(absY, absX);
				angle = 180.0 + Math.toDegrees(localAngle);
				break;
		}

		return angle;
	}


	public HeadArrow(double ax1, double ay1, double ax2, double ay2, Pane gc)
	{
		double arrowAngle = Math.toRadians(8.0);
		double arrowLength = 30.0;
		double dx = ax1 - ax2;
		double dy = ay1 - ay2;
		double angle = Math.atan2(dy, dx);
		double x1 = Math.cos(angle + arrowAngle) * arrowLength + ax2;
		double y1 = Math.sin(angle + arrowAngle) * arrowLength + ay2;

		double x2 = Math.cos(angle - arrowAngle) * arrowLength + ax2;
		double y2 = Math.sin(angle - arrowAngle) * arrowLength + ay2;

		this.startPointX = ax1;
		this.startPointY = ay1;
		this.endPointX = ax2;
		this.endPointY = ay2;

		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

		this.main = new Line(ax1, ay1, ax2, ay2);
		main.setStrokeWidth(5.0f);
		this.left = new Line(ax2, ay2, x1, y1);
		left.setStrokeWidth(5.0f);
		this.right = new Line(ax2, ay2, x2, y2);
		right.setStrokeWidth(5.0f);
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
		gc.getChildren().remove(main);
		this.startPointX = val;
		this.main = new Line(startPointX, startPointY, endPointX, endPointY);
		main.setStrokeWidth(5.0f);
		gc.getChildren().add(main);
	}

	public final void setStartY(double val, Pane gc)
	{
		gc.getChildren().remove(main);
		this.startPointY = val;
		this.main = new Line(startPointX, startPointY, endPointX, endPointY);
		main.setStrokeWidth(5.0f);
		gc.getChildren().add(main);
	}

	public final void setEndX(double val, Pane gc)
	{
		gc.getChildren().remove(main);
		this.endPointX = val;
		this.main = new Line(startPointX, startPointY, endPointX, endPointY);
		main.setStrokeWidth(5.0f);
		gc.getChildren().add(main);
	}

	public final void setEndY(double val, Pane gc)
	{
		gc.getChildren().remove(main);
		this.endPointY = val;
		this.main = new Line(startPointX, startPointY, endPointX, endPointY);
		main.setStrokeWidth(5.0f);
		gc.getChildren().add(main);
	}


	public final double getLeftX()
	{
		return this.x1;
	}

	public final double getRightX()
	{
		return this.x2;
	}

	public final double getLeftY()
	{
		return this.y1;
	}

	public final double getRightY()
	{
		return this.y2;
	}

	public final void setLeftTemponary(double valX, double valY, Pane gc)
	{
		gc.getChildren().remove(left);
		this.x1 = valX;
		this.y1 = valY;

		double arrowAngle = Math.toRadians(25.0);
		double arrowLength = 30.0;
		double dx = startPointX - endPointX;
		double dy = startPointX - endPointY;
		double angle = Math.atan2(dy, dx);
		double x1 = Math.cos(angle + arrowAngle) * arrowLength + endPointX;
		double y1 = Math.sin(angle + arrowAngle) * arrowLength + endPointY;


		this.left = new Line(endPointX, endPointY, x1, y1);
		left.setStrokeWidth(5.0f);
		gc.getChildren().add(left);
	}

	public final void setRightTemponary(double valX, double valY, Pane gc)
	{

		gc.getChildren().remove(right);
		this.y2 = valY;
		this.x2 = valX;

		double arrowAngle = Math.toRadians(45.0);
		double arrowLength = 30.0;
		double dx = startPointX - endPointX;
		double dy = startPointX - endPointY;
		double angle = Math.atan2(dy, dx);
		double x2 = Math.cos(angle - arrowAngle) * arrowLength + endPointX;
		double y2 = Math.sin(angle - arrowAngle) * arrowLength + endPointY;


		this.right = new Line(endPointX, endPointY, x2, y2);
		right.setStrokeWidth(5.0f);
		gc.getChildren().add(right);
	}

	public final void setRight(double valX, double valY, Pane gc)
	{
		gc.getChildren().remove(right);
		this.x1 = valX;
		this.y1 = valY;
		double arrowLength = 30;
		double arrowWidth = 5;
		double sx = this.startPointX;
		double ex = this.endPointX;
		double sy = this.startPointY;
		double ey = this.endPointY;
		 double factor = arrowLength / Math.hypot(sx-ex, sy-ey);
         double factorO = arrowWidth / Math.hypot(sx-ex, sy-ey);

         // part in direction of main line
         double dx = (sx - ex) * factor;
         double dy = (sy - ey) * factor;

         // part ortogonal to main line
         double ox = (sx - ex) * factorO;
         double oy = (sy - ey) * factorO;
         this.right = new Line(endPointX, endPointY, ex + dx + oy, ey + dy - ox );
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
		double sx = this.startPointX;
		double ex = this.endPointX;
		double sy = this.startPointY;
		double ey = this.endPointY;
		 double factor = arrowLength / Math.hypot(sx-ex, sy-ey);
         double factorO = arrowWidth / Math.hypot(sx-ex, sy-ey);

         // part in direction of main line
         double dx = (sx - ex) * factor;
         double dy = (sy - ey) * factor;

         // part ortogonal to main line
         double ox = (sx - ex) * factorO;
         double oy = (sy - ey) * factorO;
         this.left = new Line(endPointX, endPointY, ex + dx - oy, ey + dy + ox);
         left.setStrokeWidth(5.0f);
         gc.getChildren().add(left);
	}

	public void removeFromMainPane(Pane gc)
	{
		gc.getChildren().remove(left);
		gc.getChildren().remove(right);
		gc.getChildren().remove(main);
	}

	public void addToMainPane(Pane gc)
	{
		gc.getChildren().add(left);
		gc.getChildren().add(right);
		gc.getChildren().add(main);
	}

	public void setFill(ObservableList<HeadArrow> list, String val)
	{
		for(HeadArrow ha : list)
		{
			ha.left.setStroke(Paint.valueOf(val));
			ha.main.setStroke(Paint.valueOf(val));
			ha.right.setStroke(Paint.valueOf(val));
		}
	}

	public void setFill(String val)
	{

			this.left.setStroke(Paint.valueOf(val));
			this.right.setStroke(Paint.valueOf(val));
			this.main.setStroke(Paint.valueOf(val));

	}



}
