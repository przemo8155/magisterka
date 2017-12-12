
package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.scene.effect.Effect;
import javafx.scene.shape.Circle;

public class AnimationSchedules
{

	public AnimationSchedules()
	{
		// TODO Auto-generated constructor stub
	}

	public void animationCircle(Circle c, Effect e)
	{
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate(new Runnable()
		{

			int counter = 0;

			@Override
			public void run()
			{
				counter++;
				if (counter <= 10)
				{

					Platform.runLater(new Runnable()
					{

						@Override
						public void run()
						{
							c.setEffect(e);
						}
					});

				} else
				{
					scheduler.shutdown();
					Platform.runLater(new Runnable()
					{

						@Override
						public void run()
						{
							c.setEffect(e);
						}
					});
				}

			}
		}, 1, 1, TimeUnit.SECONDS);

	}
}
