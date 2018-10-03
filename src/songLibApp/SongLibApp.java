package songLibApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class SongLibApp extends Application {
	@Override
	public void start(Stage primaryStage) 
	throws IOException {
				
		/*---- Loading in FXML and starting up the scene ----*/
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("SongLib.fxml"));
		BorderPane root = (BorderPane) loader.load();
		
		SongLibController libraryController = loader.getController();
		libraryController.start(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Song Library");  
		primaryStage.show();
		
		stop(libraryController);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//creates a save file for songs before the app closes

	public void stop(SongLibController lc) {
		try {
			lc.saveToFile();
		} catch (IOException e) {
			System.out.println("Song file not saved.");
			Platform.exit();
		}
	}

}
