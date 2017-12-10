
package application;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Logger;

import com.sun.javafx.application.LauncherImpl;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

public class Main extends Application
{


	private static Stage pStage;

	public static Stage getPrimaryStage()
	{
		return pStage;
	}

	private void setPrimaryStage(Stage pStage)
	{
		Main.pStage = pStage;
	}

	@Override
	public void start(Stage primaryStage)
	{
		try{

			setPrimaryStage(primaryStage);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainWindow.fxml"));
			BorderPane root = new BorderPane();

			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();

			Scene scene = new Scene(loader.load(), 1200, 700);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Using a Chernikova's Algorithm");
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("resources/icon.png")));

			primaryStage.setMaximized(true);

			primaryStage.show();

		}catch(IOException e)
		{
			Logger.getGlobal();
		}



	}



	public static void main(String[] args)
	{
		//launch(args);
		LauncherImpl.launchApplication(Main.class, MyPreloader.class, args);

	}




}
