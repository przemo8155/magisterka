package application;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
public class MyPreloader extends Preloader {
private Stage preloaderStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
       this.preloaderStage = primaryStage;

       VBox loading = new VBox(20);
       loading.setMaxWidth(Region.USE_PREF_SIZE);
       loading.setMaxHeight(Region.USE_PREF_SIZE);
       loading.getChildren().add(new ProgressBar());
       loading.getChildren().add(new Label("Please wait..."));

       BorderPane root = new BorderPane(loading);
       Scene scene = new Scene(root);
       scene.setFill(Paint.valueOf("#555555"));

       primaryStage.setWidth(800);
       primaryStage.setHeight(600);
       primaryStage.setScene(scene);
       primaryStage.show();
       new Thread( new Runnable() {
           public void run()  {
               try  { Thread.sleep( 1000 ); }
               catch (InterruptedException ie)  {}

           }
       } ).start();

   }

   @Override
   public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
      if (stateChangeNotification.getType() == Type.BEFORE_START) {
         preloaderStage.hide();
      }
   }

   public void initialize()
   {
	   long start = new Date().getTime();
	   while(new Date().getTime() - start < 1000L){}
   }
}