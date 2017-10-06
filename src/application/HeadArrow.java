package application;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class HeadArrow
{
	public double x1, y1, x2, y2;

	public double startPointX, startPointY, endPointX, endPointY;

	public Line main;
	public Line left, right;


	public HeadArrow(double ax1, double ay1, double ax2, double ay2, Pane gc)
	{
		double arrowAngle = Math.toRadians(25.0);
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
		gc.getChildren().add(main);
		this.left = new Line(ax2, ay2, x1, y1);
		left.setStrokeWidth(5.0f);
		gc.getChildren().add(left);
		this.right = new Line(ax2, ay2, x2, y2);
		right.setStrokeWidth(5.0f);
		gc.getChildren().add(right);
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

	public final void setStartX(double val)
	{
		this.startPointX = val;
	}

	public final void setStartY(double val)
	{
		this.startPointY = val;
	}

	public final void setEndX(double val)
	{
		this.endPointX = val;
	}

	public final void setEndY(double val)
	{
		this.endPointY = val;
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

	public final void setLeftX(double val)
	{
		this.x1 = val;
	}

	public final void setLeftY(double val)
	{
		this.y1 = val;
	}

	public final void setRightY(double val)
	{
		this.y2 = val;
	}

	public final void setRightX(double val)
	{
		this.x2 = val;
	}


}
