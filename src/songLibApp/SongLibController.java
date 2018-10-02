package songLibApp;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
//import view.String;
//import view.ListView;
//import view.String;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.fxml.FXMLLoader;



public class SongLibController {

	/* controller: deals with event handling logic */
	
	/* FXML Widget IDs that will format the widgets within bottom HBox */
		@FXML Button buttAdd;
		@FXML Button buttDelete;
		@FXML Button buttEdit;
		@FXML TableView<Song> songList; 
		@FXML TableColumn<Song, String> titlecol;
		@FXML TableColumn<Song, String> artistcol;
	 
	
	  
	
	
	
	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) {
	
		
		/*----- Song Library Title Label -----*/
			/*
				Label label = new Label("Song Library");
				label.setTextFill(Color.FIREBRICK);
				label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
				HBox titleBox = new HBox();
				titleBox.setAlignment(Pos.CENTER);
				titleBox.getChildren().add(label);
			 */
		
		
		/*----- PREPARES THE COLUMNS for DATA INPUT -----*/
		/*---- DEFAULT DATA LIVES IN DATASOURCE CLASS -----*/
		PropertyValueFactory<Song, String> songTitleProperty = 
		          new PropertyValueFactory<Song, String>("songTitle");
		PropertyValueFactory<Song, String> songArtistProperty = 
		          new PropertyValueFactory<Song, String>("songArtist");
		
		titlecol.setCellValueFactory(songTitleProperty);
	      artistcol.setCellValueFactory(songArtistProperty);
		
	      
	      DataSource data = new DataSource();
	      ObservableList<Song> tableItems = data.getData();
	      songList.setItems(tableItems);
	            
		
		  
		
		
	}
	
	public void add(ActionEvent e) {
		//adds new song to songlist
	}
	
	public void edit(ActionEvent e) {
		//edits fields of specific selected song
	}
	
	public void delete(ActionEvent e) {
		//removes a song from the songlist
	}

	
	
	
	/*
	private ObservableList<Song> getInitialTableData() {
		
		List<Song> list = new ArrayList<>();
		
		list.add(new Song("Versace On The Floor", "Bruno Mars", "24K Magic", "2016"));
		list.add(new Song("24k Magic", "Bruno Mars", "24K Magic", "2016"));
		list.add(new Song("Finesse", "Bruno Mars", "24K Magic", "2016"));
		
		ObservableList<Song> data = FXCollections.observableArrayList(list);

		return data;
	}
	*/
	
}
