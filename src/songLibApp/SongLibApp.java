package songLibApp;

import java.io.IOException;

//import javafx.fxml.FXMLLoader;
import javafx.application.Application;
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
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
		
		
		

		//Setting the top, bottom, center, right and left nodes of the pane
		//bPane.setTop(new TextField("Song Library"));
		//bPane.setBottom(new TextField("Current Song"));
		//bPane.setLeft(new TextField("Song Library"));
		//bPane.setRight(new TextField("Song Details"));
		
	
		
		
		
		//Create new song library controller 
			//SongLibController songlibController = loader.getController();
			//songlibController.start();
			//SongLibController.start(primaryStage); 
		
		
		
		/*AnchorPane root = new AnchorPane();
	       
        Button okBtn = new Button("OK");
        Button closeBtn = new Button("Close");
        VBox vbox = new VBox(5, okBtn, closeBtn);

        root.getChildren().addAll(vbox);
        
        AnchorPane.setRightAnchor(vbox, 10d);
        AnchorPane.setBottomAnchor(vbox, 10d);
		*/
		
		/* trial */
		/* BorderPane root = new BorderPane();
        Label centeredText = new Label("I want this text centered!");
        Button unorganizedButton = new Button("Press me");
        
        BorderPane.setAlignment(centeredText, Pos.CENTER);
        root.setTop(centeredText);
        root.setBottom(unorganizedButton);
        
        Scene scene = new Scene(root, 500, 500);
        
            
	
*/
		
	/*
	Button btn1 = new Button();
    Button btn2 = new Button("h1");
    Button btn3 = new Button("h2");
    btn1.setText("Click me please!");
    BorderPane pane = new BorderPane();
    HBox pane2 = new HBox();
    pane2.getChildren().add(btn1);
    pane2.getChildren().add(btn2);
    pane2.getChildren().add(btn3);
    pane.setCenter(pane2);

  

    Scene scene = new Scene(pane, 700, 550);
    primaryStage.setScene(scene);
    primaryStage.setTitle("The Click Me App");
    primaryStage.show();
	
		
		
		
        
        //AnchorPane anchorPane = new AnchorPane();
        //root.setTop(anchorPane);

        primaryStage.setTitle("Corner buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	*/
		
		/* Actual START */
		/*
		SplitPane splitPane = new SplitPane(new TableView(), new VBox(new Label("Current Song Details")));
		//SplitPane splitPane = new SplitPane();
		
		
		splitPane.setOrientation(Orientation.HORIZONTAL);
		
		BorderPane borderPane = new BorderPane(splitPane);
		borderPane.setBottom(new MenuBar(new Menu("Song Library")));
		
		//Button button1 = new Button("Add");
		//Button button2 = new Button("Edit");
		//Button button3 = new Button("Delete");
		
		HBox pane2 = new HBox();
		pane2.getChildren().add(new Label("Button PlaceHolder"));
		//pane2.getChildren().add(button1);
		//pane2.getChildren().add(button2);
		//pane2.getChildren().add(button3);
		borderPane.setBottom(pane2);
		
		VBox vbox = new VBox();
		ListView list = new ListView();
		VBox.setVgrow(list, Priority.ALWAYS);
		vbox.getChildren().addAll(new Label("Song Details"), list);
		borderPane.setRight(vbox);
		
		
		Scene scene = new Scene(borderPane, 600, 400);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Song Library");
		primaryStage.show();
		
		*/

}
