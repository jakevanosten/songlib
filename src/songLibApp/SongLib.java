package songLibApp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;



public class SongLib extends Application {
	@Override
	public void start(Stage primaryStage) 
	throws IOException {
				
		/*---- Loading in FXML and starting up the scene ----*/
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("SLib.fxml"));
		BorderPane root = (BorderPane) loader.load();
		
		SongLibController libraryController = loader.getController();
		libraryController.start(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Song Library");  
		primaryStage.show();
		
		primaryStage.setOnCloseRequest((WindowEvent event1) -> {
			try {
				libraryController.saveToFile();
			} catch (IOException e) {
				System.out.println("Song file not saved.");
			} 
	    });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
