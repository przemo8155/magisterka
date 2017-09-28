package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Counters
{
	public String circleCounter(ObservableList<Circle> list)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		return text;
	}

	public String rectangleCounter(ObservableList<Rectangle> list)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		return text;
	}

	public String lineCounter(ObservableList<Line> list)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		return text;
	}
}
