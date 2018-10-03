package songLibApp;

import java.util.Optional;
import java.util.Scanner;

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
import javafx.scene.shape.Path;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
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
	@FXML Button saveEdit;
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
	
	public void start(Stage primaryStage) throws IOException{
			
		/*----- PREPARES THE COLUMNS for DATA INPUT -----*/
		/*---- DEFAULT DATA LIVES IN DATASOURCE CLASS -----*/
		PropertyValueFactory<Song, String> songTitleProperty = 
		          new PropertyValueFactory<Song, String>("songTitle");
		PropertyValueFactory<Song, String> songArtistProperty = 
		          new PropertyValueFactory<Song, String>("songArtist");
		
		titlecol.setCellValueFactory(songTitleProperty);
	    artistcol.setCellValueFactory(songArtistProperty);
		
	    loadFileToList();
	      
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
		
		int sameSongFlag = 0;
		String albName = "Unknown";
		String albYear = "Unknown";
		
		if (newTitleField.getText().isEmpty() || newArtistField.getText().isEmpty()) {
			addErrorAlert();
		}else {
			if(!newAlbumField.getText().isEmpty()) { albName = newAlbumField.getText();}
			if(!newYearField.getText().isEmpty()) { albYear = newYearField.getText();}
		
			for(Song s: tableItems) {
				if(s.getSongTitle().equals(newTitleField.getText())  && s.getSongArtist().equals(newArtistField.getText())) {
						sameSongAlert();
						sameSongFlag = 1;
						break;
				}
			}
		
			if(sameSongFlag == 0) {
				Song newSong = new Song(newTitleField.getText(),newArtistField.getText(),albName,albYear);
				tableItems.add(newSong);
		
				newTitleField.clear();
				newArtistField.clear();
				newAlbumField.clear();
				newYearField.clear();
			}
		}
	}
	
	private void addErrorAlert() {                
	      Alert alert = 
	         new Alert(AlertType.INFORMATION);
	      alert.setTitle("Error With Add");
	      alert.setHeaderText("Cannot add song without title AND artist.");
	      
	      String content = "Please enter at least title and artist to add.";
	          alert.setContentText(content);
	          alert.showAndWait();
	   }
	
	private void sameSongAlert() {                
	      Alert alert = 
	         new Alert(AlertType.INFORMATION);
	      alert.setTitle("Error - Song Already Exists");
	      alert.setHeaderText("This song is already in the library.");
	      alert.showAndWait();
	   }
	
	public void edit(ActionEvent e) {
		 sTitle.setEditable(true);
		 sArtist.setEditable(true);
		 sAlbum.setEditable(true);
		 sYear.setEditable(true);
		/*
		
		String item =  Song.sTitle.getSelectionModel().getSelectedItem();
		 int index = songList.getSelectionModel().getSelectedIndex();
		 TextInputDialog dialog = new TextInputDialog(item);
		 dialog.initOwner(mainStage); dialog.setTitle("List Item");
		 dialog.setHeaderText("Selected Item (Index: " + index + ")");
		 dialog.setContentText("Enter name: ");
		 Optional<String> result = dialog.showAndWait();
		 if (result.isPresent()) { obsList.set(index, result.get()); 
		  */
	}
	
	
	
	
	public void save(ActionEvent e){
		songList.setItems(tableItems);
	}
	
	public void delete(ActionEvent e) {
		//removes a song from the songlist
	}

	public void saveToFile() 
		  throws IOException {
				
			    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("savedSongs.txt")));
			    if(tableItems != null) {
			    	for(Song s: tableItems) {
			    		writer.write(s.getSongTitle() + "\n");
			    		writer.write(s.getSongArtist() + "\n");
			    		writer.write(s.getAlbumTitle() + "\n");
			    		writer.write(s.getAlbumYear() + "\n");
			    	}
			    }
			    writer.close();
			}
		
	@SuppressWarnings("resource")
	public void loadFileToList() {
		//New material for parsing the file to use previously saved songs
			try {
				File savedSongs = new File("savedSongs.txt");
			
				Scanner fileScan = new Scanner(savedSongs).useDelimiter("\n");
				while(fileScan.hasNext()) {
					tableItems.add(new Song(fileScan.next(), fileScan.next(), fileScan.next(), fileScan.next()));
				}
				fileScan.close();
			} catch (FileNotFoundException e) {
				System.out.println("No songs in list currently");
			}
			
			
	}
	
}
