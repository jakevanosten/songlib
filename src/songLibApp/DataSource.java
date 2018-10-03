package songLibApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSource {
	
	private final ObservableList<Song> data = FXCollections.observableArrayList();
	
	public ObservableList<Song> getData(){
		return data;
	}
	
	
	public DataSource() throws IOException{
		
		//New material for parsing the file to use previously saved songs
		 
			Path savedSongsPath = Paths.get("savedSongs.txt");
			
			try {
				@SuppressWarnings("resource")
				Scanner fileScan = new Scanner(savedSongsPath).useDelimiter("\n");
				while(fileScan.hasNext()) {
					data.add(new Song(fileScan.next(), fileScan.next(), fileScan.next(), fileScan.next()));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		
			//DEFAULT SONGS -- MUST REMOVE FOR FINAL TESTING
			data.add(new Song("Versace on the Floor", "Bruno Mars"));
			data.add(new Song("24K Magic", "Bruno Mars"));
			data.add(new Song("That's What I Like", "Bruno Mars"));
		
	}

}
