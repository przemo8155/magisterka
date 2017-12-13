
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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
						Thread.sleep(1000);
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
		this.preloaderStage = primaryStage;

		ProgressIndicator pi = new ProgressIndicator();
		pi.setLayoutX(250.0f);
		pi.setLayoutY(180.0f);
		pi.setMinHeight(100.0f);
		pi.setMinWidth(100.f);

		Label waitLabel = new Label("Please wait...");
		waitLabel.setLayoutX(230.0f);
		waitLabel.setLayoutY(300.0f);
		waitLabel.setFont(Font.font("Verdana", 22));


		Pane pane = new Pane();
		pane.setId("pane");
		pane.setPickOnBounds(false);
		pane.setLayoutX(0.0f);
		pane.setLayoutY(0.0f);
		pane.setMinWidth(600);
		pane.setMinHeight(400);


		pane.getChildren().add(pi);
		pane.getChildren().add(waitLabel);


		BorderPane root = new BorderPane(pane);
		Scene scene = new Scene(root);
		scene.getStylesheets().addAll(this.getClass().getResource("MyPreloader.css").toExternalForm());
		scene.setFill(Paint.valueOf("#555555"));
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setWidth(600);
		primaryStage.setHeight(400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}



	public void initialize()
	{
		long start = new Date().getTime();
		while (new Date().getTime() - start < 1000L)
		{
		}
	}
}