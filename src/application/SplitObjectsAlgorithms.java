
package application;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SplitObjectsAlgorithms
{

	Utilities utilities = new Utilities();

	static int minusWidth = 95;

	public void splitBigAlgorithm(ObservableList<String> circlesList, ObservableList<String> rectanglesList,
			ObservableList<String> edgesList, String color, Pane pane, ObservableList<Circle> outputCircle,
			ObservableList<Rectangle> outputRectangle, ObservableList<HeadArrow> outputEdgeStraight,
			ObservableList<LeftDoubleArrow> outputEdgeLDA, ObservableList<RightDoubleArrow> outputEdgeRDA)
	{
		int sizeOfCirclesList = circlesList.size();
		int sizeOfRectanglesList = rectanglesList.size();
		int sizeOfEdgesList = edgesList.size();

		int sizeOfObjects = sizeOfCirclesList + sizeOfRectanglesList;


		String elo = "#555555";
		Circle y = new Circle(width / 2, height / 2 - minusWidth, 20.0f, Paint.valueOf(elo));
		y.setStroke(Paint.valueOf("#555555"));
		y.setStrokeWidth(5.0f);
		pane.getChildren().add(y);
		outputCircle.add(y);

		Rectangle x = new Rectangle(width/2, height/2 - minusWidth - 20, 40.0f,
				40.0f);
		x.setFill(Paint.valueOf(elo));
		x.setStroke(Paint.valueOf("#555555"));
		x.setStrokeWidth(5.0f);
		pane.getChildren().add(x);
		outputRectangle.add(x);

		utilities.intBox(sizeOfObjects);
		switch (sizeOfObjects)
		{

			case 1:
				if (sizeOfCirclesList == 1)
				{
					Circle c = new Circle(width / 2, height / 2 - minusWidth, 20.0f, Paint.valueOf(color));
					c.setStroke(Paint.valueOf("#555555"));
					c.setStrokeWidth(5.0f);
					pane.getChildren().add(c);
					outputCircle.add(c);
				}
				else if(sizeOfCirclesList == 0)
				{
					Rectangle r = new Rectangle(width/2, height/2 - minusWidth - 20, 40.0f,
							40.0f);
					r.setFill(Paint.valueOf(color));
					r.setStroke(Paint.valueOf("#555555"));
					r.setStrokeWidth(5.0f);
					pane.getChildren().add(r);
					outputRectangle.add(r);
				}
			case 2:
				if(sizeOfCirclesList == 2)
				{
					Circle c1 = new Circle(width / 3, height / 2 - minusWidth, 20.0f, Paint.valueOf(color));
					c1.setStroke(Paint.valueOf("#555555"));
					c1.setStrokeWidth(5.0f);
					pane.getChildren().add(c1);
					outputCircle.add(c1);

					Circle c2 = new Circle(2*width / 3, height / 2 - minusWidth, 20.0f, Paint.valueOf(color));
					c2.setStroke(Paint.valueOf("#555555"));
					c2.setStrokeWidth(5.0f);
					pane.getChildren().add(c2);
					outputCircle.add(c2);
				}

				else if(sizeOfCirclesList == 1)
				{
					Circle c = new Circle(2*width / 3, height / 2 - minusWidth, 20.0f, Paint.valueOf(color));
					c.setStroke(Paint.valueOf("#555555"));
					c.setStrokeWidth(5.0f);
					pane.getChildren().add(c);
					outputCircle.add(c);

					Rectangle r = new Rectangle(width/3, height/2 - minusWidth - 20, 40.0f,
							40.0f);
					r.setFill(Paint.valueOf(color));
					r.setStroke(Paint.valueOf("#555555"));
					r.setStrokeWidth(5.0f);
					pane.getChildren().add(r);
					outputRectangle.add(r);
				}

				else if(sizeOfCirclesList == 0)
				{
					Rectangle r1 = new Rectangle(width/3, height/2 - minusWidth - 20, 40.0f,
							40.0f);
					r1.setFill(Paint.valueOf(color));
					r1.setStroke(Paint.valueOf("#555555"));
					r1.setStrokeWidth(5.0f);
					pane.getChildren().add(r1);
					outputRectangle.add(r1);

					Rectangle r2 = new Rectangle(2*width/3, height/2 - minusWidth - 20, 40.0f,
							40.0f);
					r2.setFill(Paint.valueOf(color));
					r2.setStroke(Paint.valueOf("#555555"));
					r2.setStrokeWidth(5.0f);
					pane.getChildren().add(r2);
					outputRectangle.add(r2);
				}


		}

	}

}
