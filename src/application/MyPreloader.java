
package application;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javafx.animation.FadeTransition;
import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.util.concurrent.TimeUnit.*;
import java.util.Timer;
import java.util.TimerTask;

public class MyPreloader extends Preloader
{

	private Stage preloaderStage;

	@Override
	public void handleStateChangeNotification(StateChangeNotification evt) {
	    if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
	        if (preloaderStage.isShowing()) {
	            //fade out, hide stage at the end of animation
	            FadeTransition ft = new FadeTransition(
	                Duration.millis(100), preloaderStage.getScene().getRoot());
	                ft.setFromValue(1.0);
	                ft.setToValue(0.0);
	                try
					{
						Thread.sleep(3000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                final Stage s = preloaderStage;
	                EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
	                    public void handle(ActionEvent t) {
	                        s.hide();
	                    }
	                };
	                ft.setOnFinished(eh);
	                ft.play();
	        } else {
	        	preloaderStage.hide();
	        }
	    }
	}



	@Override
	public void start(Stage primaryStage) throws Exception
	{
		ImageView image = new ImageView("file:resources/sowa.jpg");
		this.preloaderStage = primaryStage;

		VBox loading = new VBox(20);
		loading.setMaxWidth(Region.USE_PREF_SIZE);
		loading.setMaxHeight(Region.USE_PREF_SIZE);
		loading.getChildren().add(new ProgressBar());
		loading.getChildren().add(new Label("Please wait..."));
		loading.getChildren().add(image);

		BorderPane root = new BorderPane(loading);
		Scene scene = new Scene(root);
		scene.setFill(Paint.valueOf("#555555"));

		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	/*@Override
	public void handleStateChangeNotification(StateChangeNotification stateChangeNotification)
	{
		if (stateChangeNotification.getType() == Type.BEFORE_START)
		{
			preloaderStage.hide();
		}
	}*/


	public void initialize()
	{
		long start = new Date().getTime();
		while (new Date().getTime() - start < 1000L)
		{
		}
	}
}