
package application;

import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class Arrow
{
	public double x1, x2, y1, y2;
	public double s1x, s1y;
	public double s2x, s2y;

	public Arrow(Pane gc, double node1X, double node1Y, double node2X, double node2Y)
	{
		this.x1 = node1X;
		this.x2 = node2X;
		this.y1 = node1Y;
		this.y2 = node2Y;
		double arrowAngle = Math.toRadians(25.0);
		double arrowLength = 15.0;
		double dx = node1X - node2X;
		double dy = node1Y - node2Y;
		double angle = Math.atan2(dy, dx);
		double x1 = Math.cos(angle + arrowAngle) * arrowLength + node2X;
		double y1 = Math.sin(angle + arrowAngle) * arrowLength + node2Y;

		double x2 = Math.cos(angle - arrowAngle) * arrowLength + node2X;
		double y2 = Math.sin(angle - arrowAngle) * arrowLength + node2Y;

		this.s1x = x1;
		this.s1y = y1;
		this.s2x = x2;
		this.s2y = y2;

		Line l1 = new Line(node2X, node2Y, x1, y1);
		Line l2 = new Line(node2X, node2Y, x2, y2);
		l1.setStroke(Paint.valueOf("#ABCDEF"));
		l1.setStrokeWidth(5.0f);

		l2.setStroke(Paint.valueOf("#ABCDEF"));
		l2.setStrokeWidth(5.0f);
		gc.getChildren().add(l1);
		gc.getChildren().add(l2);

		Line l = new Line(node1X, node1Y, node2X, node2Y);
		l.setStroke(Paint.valueOf("#ABCDEF"));
		l.setStrokeWidth(5.0f);

		gc.getChildren().add(l);


	}

	public final double getStartX()
	{
		return this.x1;
	}

	public final void setStartX(double val)
	{
		this.x1 = val;
	}

	public final double getStartY()
	{
		return this.y1;
	}

	public final void setStartY(double val)
	{
		this.y1 = val;
	}

	public final double getEndX()
	{
		return this.x2;
	}

	public final void setEndX(double val)
	{
		this.x2 = val;
	}

	public final double getEndY()
	{
		return this.y2;
	}

	public final void setEndY(double val)
	{
		this.y2 = val;
	}

	public final double getS1X()
	{
		return this.s1x;
	}

	public final double getS2X()
	{
		return this.s2x;
	}

	public final double getS1Y()
	{
		return this.s1y;
	}

	public final double getS2Y()
	{
		return this.s2y;
	}

	public final void setS1X(double val)
	{
		this.s1x = val;
	}

	public final void setS2X(double val)
	{
		this.s2x = val;
	}

	public final void setS1Y(double val)
	{
		this.s1y = val;
	}

	public final void setS2Y(double val)
	{
		this.s2y = val;
	}


	public void testUtilities()
	{
		Utilities.doubleBox(x1);
		Utilities.doubleBox(y1);
		Utilities.doubleBox(x2);
		Utilities.doubleBox(y1);
	}

}