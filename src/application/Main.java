
package application;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

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

		try
		{
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

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{

		launch(args);

	}

}
