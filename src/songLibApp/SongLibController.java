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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		
		ObservableList<Song> tableItems = FXCollections.observableArrayList();
	
	public void start(Stage primaryStage) throws IOException {
			
		/*----- PREPARES THE COLUMNS for DATA INPUT -----*/
		/*---- DEFAULT DATA LIVES IN DATASOURCE CLASS -----*/
		PropertyValueFactory<Song, String> songTitleProperty = 
		          new PropertyValueFactory<Song, String>("songTitle");
		PropertyValueFactory<Song, String> songArtistProperty = 
		          new PropertyValueFactory<Song, String>("songArtist");
		
		titlecol.setCellValueFactory(songTitleProperty);
	      artistcol.setCellValueFactory(songArtistProperty);
		
	    //DEFAULT SONGS -- MUST REMOVE FOR FINAL TESTING
			tableItems.add(new Song("Versace on the Floor", "Bruno Mars"));
			tableItems.add(new Song("24K Magic", "Bruno Mars"));
			tableItems.add(new Song("That's What I Like", "Bruno Mars"));
			
	      songList.setItems(tableItems);
	     	
	      songList.setRowFactory(tv -> {
	            TableRow<Song> row = new TableRow<>();
	            row.setOnMouseClicked(event -> {
	                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
	                    Song rowSong = row.getItem();
	                    sTitle.setText(rowSong.getSongTitle());
	                    sArtist.setText(rowSong.getSongArtist());
	                    sAlbum.setText(rowSong.getAlbumTitle());
	                    sYear.setText(rowSong.getAlbumYear());
	                }
	            });
	            return row;
	      });
		
	}
 
	
	public void add(ActionEvent e) {
		String albName = "Unknown";
		String albYear = "Unknown";
		//first click display the form for adding
		//if already displayed, must have title and artist filled with something before song is created
		//if both are there, need to grab all the fields and save them as local vars.
		//then create newSong from them and add to obsList (tableItems)
		
		if (newTitleField.getText() == null || newArtistField.getText() == null) {
		     //need to throw alert message saying responses NEED to be in these fields
		}else {
			if(newAlbumField.getText() != null) { albName = newAlbumField.getText();}
			if(newYearField.getText() != null) { albYear = newYearField.getText();}
		}
		
		Song newSong = new Song(newTitleField.getText(),newArtistField.getText(),albName,albYear);
		tableItems.add(newSong);
		newTitleField.clear();
		newArtistField.clear();
		newAlbumField.clear();
		newYearField.clear();
	}
	
	public void edit(ActionEvent e) {
		//edits fields of specific selected song
	}
	
	public void delete(ActionEvent e) {
		//removes a song from the songlist
	}

	// --------NEW FILE SAVER -------
		public void saveToFile() 
				  throws IOException {
				
				    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("savedSongs.txt")));
				    for(Song s: tableItems) {
				    	writer.write(s.getSongTitle() + "\n");
				        writer.write(s.getSongArtist() + "\n");
				    	writer.write(s.getAlbumTitle() + "\n");
				    	writer.write(s.getAlbumYear() + "\n");
				    }
				    writer.close();
				}
		
		public void loadFileToList() {
			//New material for parsing the file to use previously saved songs
			 /*
				Path savedSongsPath = Paths.get("savedSongs.txt");
				
				try {
					@SuppressWarnings("resource")
					Scanner fileScan = new Scanner(savedSongsPath).useDelimiter("\n");
					while(fileScan.hasNext()) {
						tableItems.add(new Song(fileScan.next(), fileScan.next(), fileScan.next(), fileScan.next()));
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			*/
		}
	
}
