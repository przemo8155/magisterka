package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

public class DoubleArrow
{

	Path path = new Path();
	MoveTo moveTo = new MoveTo();
	QuadCurveTo quadTo = new QuadCurveTo();
	HeadArrow headArrow = new HeadArrow();

	static int doubleArrowMove = 100;

	public double startPointX, startPointY, endPointX, endPointY, controlX, controlY;

	public DoubleArrow(double firstX, double firstY, double contX, double contY, double secX, double secY, Pane gc, String paint)
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


		if(mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(firstX + cutX1);
			this.moveTo.setY(firstY + cutY1);
			this.quadTo.setControlX(contX);
			this.quadTo.setControlY(contY);
			this.quadTo.setX(secX - cutX2);
			this.quadTo.setY(secY - cutY2);
		}

		if(mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(firstX - cutX1);
			this.moveTo.setY(firstY + cutY1);
			this.quadTo.setControlX(contX);
			this.quadTo.setControlY(contY);
			this.quadTo.setX(secX - cutX2);
			this.quadTo.setY(secY - cutY2);
		}

		if(mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(firstX - cutX1);
			this.moveTo.setY(firstY + cutY1);
			this.quadTo.setControlX(contX);
			this.quadTo.setControlY(contY);
			this.quadTo.setX(secX - cutX2);
			this.quadTo.setY(secY - cutY2);
		}

		if(mainAngle > 270 && mainAngle <= 360)
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
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);


		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove)
				+ ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove)
				+ ((startPointY + endPointY) / 2);

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

		if(mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 270 && mainAngle <= 360)
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


	public final void setStartY(double val, Pane gc)
	{
		gc.getChildren().remove(this.path);
		this.startPointY = val;
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);


		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove)
				+ ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove)
				+ ((startPointY + endPointY) / 2);

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

		if(mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 270 && mainAngle <= 360)
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
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);


		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove)
				+ ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove)
				+ ((startPointY + endPointY) / 2);

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

		if(mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 270 && mainAngle <= 360)
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
		double mainAngle = headArrow.returnAngle(startPointX, startPointY, endPointX, endPointY);


		mainAngle = mainAngle % 90;
		double eAngle = 90.0 - mainAngle;

		double mvX = ((mainAngle / 90.0) * doubleArrowMove)
				+ ((startPointX + endPointX) / 2);

		double mvY = ((eAngle / 90.0) * doubleArrowMove)
				+ ((startPointY + endPointY) / 2);

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

		if(mainAngle >= 0 && mainAngle <= 90)
		{
			this.moveTo.setX(startPointX + cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 90 && mainAngle <= 180)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 180 && mainAngle <= 270)
		{
			this.moveTo.setX(startPointX - cutX1);
			this.moveTo.setY(startPointY + cutY1);
			this.quadTo.setControlX(mvX);
			this.quadTo.setControlY(mvY);
			this.quadTo.setX(endPointX - cutX2);
			this.quadTo.setY(endPointY - cutY2);
		}

		if(mainAngle > 270 && mainAngle <= 360)
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





}
