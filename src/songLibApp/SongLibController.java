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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
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
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
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
		@FXML TextField newTitleField;
		@FXML TextField newArtistField;
		@FXML TextField newAlbumField;
		@FXML TextField newYearField;
		@FXML TextField sTitle;
		@FXML TextField sArtist;
		@FXML TextField sAlbum;
		@FXML TextField sYear;
		
		ObservableList<Song> tableItems;
	
	public void start(Stage primaryStage) throws IOException {
			
		/*----- PREPARES THE COLUMNS for DATA INPUT -----*/
		/*---- DEFAULT DATA LIVES IN DATASOURCE CLASS -----*/
		PropertyValueFactory<Song, String> songTitleProperty = 
		          new PropertyValueFactory<Song, String>("songTitle");
		PropertyValueFactory<Song, String> songArtistProperty = 
		          new PropertyValueFactory<Song, String>("songArtist");
		
		titlecol.setCellValueFactory(songTitleProperty);
	      artistcol.setCellValueFactory(songArtistProperty);
		
	      
	      DataSource data = new DataSource();
	      tableItems = data.getData();
	      songList.setItems(tableItems);
	     	
	      songList.setRowFactory(tv -> {
	            TableRow<Song> row = new TableRow<>();
	            row.setOnMouseClicked(event -> {
	                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
	                    Song rowData = row.getItem();
	                    System.out.println("Selected: "+ rowData.getSongTitle());
	                }
	            });
	            return row;
	      });
		
	}
 
	
	public void add(ActionEvent e) {
		//adds new song to songlist
		Song newSong = new Song();
		tableItems.add(newSong);
	}
	
	public void edit(ActionEvent e) {
		//edits fields of specific selected song
	}
	
	public void delete(ActionEvent e) {
		//removes a song from the songlist
	}

	
	
}
