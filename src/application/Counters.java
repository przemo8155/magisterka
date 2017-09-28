package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class Counters
{
	public void circleCounter(ObservableList<Circle> circle, Label label)
	{
		final int number = circle.size();
		String text = Integer.toString(number);
		label.setText(text);

	}
}
