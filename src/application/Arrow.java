
package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class Arrow
{

	public void drawArrow(Pane gc, double node1X, double node1Y, double node2X, double node2Y)
	{
		double arrowAngle = Math.toRadians(45.0);
		double arrowLength = 30.0;
		double dx = node1X - node2X;
		double dy = node1Y - node2Y;
		double angle = Math.atan2(dy, dx);
		double x1 = Math.cos(angle + arrowAngle) * arrowLength + node2X;
		double y1 = Math.sin(angle + arrowAngle) * arrowLength + node2Y;

		double x2 = Math.cos(angle - arrowAngle) * arrowLength + node2X;
		double y2 = Math.sin(angle - arrowAngle) * arrowLength + node2Y;
		Line l1 = new Line(node2X, node2Y, x1, y1);
		Line l2 = new Line(node2X, node2Y, x2, y2);
		l1.setStroke(Paint.valueOf("#ABCDEF"));
		l1.setStrokeWidth(10.0f);

		l2.setStroke(Paint.valueOf("#ABCDEF"));
		l2.setStrokeWidth(10.0f);
		gc.getChildren().add(l1);
		gc.getChildren().add(l2);

		Line l = new Line(node1X, node1Y, node2X, node2Y);
		l.setStroke(Paint.valueOf("#ABCDEF"));
		l.setStrokeWidth(10.0f);

		gc.getChildren().add(l);

	}

	public void graphDrawArrow(Line line, GraphicsContext gc)
	{
		double arrowAngle = Math.toRadians(45.0);
		double arrowLength = 10.0;
		double dx = line.getStartX() - line.getEndX();
		double dy = line.getStartY() - line.getEndY();
		double angle = Math.atan2(dy, dx);

		double x1 = Math.cos(angle + arrowAngle) * arrowLength + line.getEndX();
		double y1 = Math.sin(angle + arrowAngle) * arrowLength + line.getEndY();

		double x2 = Math.cos(angle - arrowAngle) * arrowLength + line.getEndX();
		double y2 = Math.sin(angle - arrowAngle) * arrowLength + line.getEndY();
		gc.strokeLine(line.getEndX(), line.getEndY(), x1, y1);
		gc.strokeLine(line.getEndX(), line.getEndY(), x2, y2);
	}

	void drawArrow2(GraphicsContext gc, int x1, int y1, int x2, int y2) {
		final int ARR_SIZE = 8;

	    double dx = x2 - x1, dy = y2 - y1;
	    double angle = Math.atan2(dy, dx);
	    int len = (int) Math.sqrt(dx * dx + dy * dy);

	    Transform transform = Transform.translate(x1, y1);
	    transform = transform.createConcatenation(Transform.rotate(Math.toDegrees(angle), 0, 0));
	    gc.setTransform(new Affine(transform));

	    gc.strokeLine(0, 0, len, 0);
	    gc.fillPolygon(new double[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new double[]{0, -ARR_SIZE, ARR_SIZE, 0},
	            4);
	}
}