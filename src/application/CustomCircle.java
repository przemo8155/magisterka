package application;

import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CustomCircle
{
	public CustomCircle(MouseEvent event, Pane mainPane, ObservableList<Circle> circleList, EventHandler<MouseEvent> circleOnMousePressedEventHandler, Label l)
	{

		final int minusWidth = 95;
		Circle c = new Circle(event.getSceneX(), event.getSceneY() - minusWidth, 20.0f,
				Paint.valueOf("#923456"));
		c.setStroke(Paint.valueOf("#555555"));
		c.setStrokeWidth(5.0f);
		mainPane.getChildren().add(c);
		c.setOnMousePressed(circleOnMousePressedEventHandler);
		setMiddleLabelText("Circle created...", l);
		circleList.add(c);
	}

	public void setMiddleLabelText(String text, Label middleLabel)
	{
		middleLabel.setDisable(false);
		middleLabel.setText(text);

		FadeTransition ft = new FadeTransition(Duration.millis(1200), middleLabel);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setAutoReverse(false);
		ft.play();
		middleLabel.setDisable(true);

	}

}
