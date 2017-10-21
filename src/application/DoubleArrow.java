package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

public class DoubleArrow
{
	HeadArrow headArrow = new HeadArrow();

	public void createDoubleArrow(double firstX, double firstY, double contX, double contY, double secX, double secY, Pane gc, String paint)
	{
		double mainAngle = headArrow.returnAngle(firstX, firstY, secX, secY);

		double angle1 = headArrow.returnAngle(firstY, firstY, contX, contY);
		double cutX1 = headArrow.calculateX(angle1);
		double cutY1 = headArrow.calculateY(angle1);

		double angle2 = headArrow.returnAngle(contX, contY, secX, secY);
		double cutX2 = headArrow.calculateX(angle2);
		double cutY2 = headArrow.calculateY(angle2);
		Path path = new Path();
		MoveTo moveTo = new MoveTo();
		QuadCurveTo quadTo = new QuadCurveTo();

		if(mainAngle >= 0 && mainAngle <= 90)
		{
			moveTo.setX(firstX + cutX1);
			moveTo.setY(firstY + cutY1);
			quadTo.setControlX(contX);
			quadTo.setControlY(contY);
			quadTo.setX(secX - cutX2);
			quadTo.setY(secY - cutY2);
		}

		else
		{
			Utilities.infoBox("inny kat");
		}



		path.getElements().add(moveTo);
		path.getElements().add(quadTo);

		path.setStrokeWidth(5.0f);
		path.setStroke(Paint.valueOf(paint));

		gc.getChildren().add(path);
	}

	public double moveX(double angle)
	{
		double mX = 0;
		return mX;
	}
}
