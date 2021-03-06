package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Counters
{
	public String circleCounter(ObservableList<Circle> list, Label label)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		label.setText(text);
		return text;
	}

	public String rectangleCounter(ObservableList<Rectangle> list, Label label)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		label.setText(text);
		return text;
	}

	public String doubleArrowsCounter(ObservableList<LeftDoubleArrow> list, Label label)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		label.setText(text);
		return text;
	}

	public String lineCounter(ObservableList<Line> list, Label label)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		label.setText(text);
		return text;
	}

	public String headArrowCounter(ObservableList<HeadArrow> list, Label label)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		label.setText(text);
		return text;
	}

	public String tagsCounter(ObservableList<Label> list, Label label)
	{
		final int number = list.size();
		String text = Integer.toString(number);
		label.setText(text);
		return text;
	}

	public String tokensCounter(ObservableList<Label> list, ObservableList<ImageView> list2, Label label)
	{
		final int number = list.size();
		final int number2 = list2.size();
		String text = Integer.toString(number+number2);
		label.setText(text);
		return text;
	}


	public String mouseClickerCounter(int n, Label label)
	{
		String text = Integer.toString(n);
		label.setText(text);
		return text;
	}

	public String objDeleted(int n, Label label)
	{
		String text = Integer.toString(n);
		label.setText(text);
		return text;
	}


}
