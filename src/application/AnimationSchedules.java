
package application;

import java.util.concurrent.Executors;
import javafx.animation.AnimationTimer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AnimationSchedules
{

	public AnimationSchedules()
	{
		// TODO Auto-generated constructor stub
	}

	void dd()
	{
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate(new Runnable()
		{
			@Override
			public void run()
			{

					Platform.runLater(new Runnable()
					{

						@Override
						public void run()
						{
							//l.setEffect(e);
						}
					});
			}
		}, 1, 1, TimeUnit.SECONDS);

	}

	public void animationRectangle(Rectangle r, Effect e)
	{
		new AnimationTimer()
		{
			
			@Override
			public void handle(long now)
			{
				// TODO Auto-generated method stub
				
			}
		};

	}

	public void animationLabel(Label l, Effect e)
	{
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
	    wait.setOnFinished((f) -> {
	        l.setEffect(e);
	        try
			{
				f.wait(1000);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        wait.playFromStart();
	    });
	    wait.play();

	}

	public void animationHeadArrow(HeadArrow ha, Effect e)
	{
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
	    wait.setOnFinished((f) -> {
	        ha.setEffect(e);
	        try
			{
				f.wait(1000);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        wait.playFromStart();
	    });
	    wait.play();

	}


	public void animationCircle(Circle c, Effect e)
	{
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
	    wait.setOnFinished((f) -> {
	        c.setEffect(e);
	        try
			{
				f.wait(1000);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        wait.playFromStart();
	    });
	    wait.play();
	}
}
