package songLibApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSource {
	
	private final ObservableList<Song> data = FXCollections.observableArrayList();
	
	public ObservableList<Song> getData(){
		return data;
	}
	
	
	public DataSource(){
		data.add(new Song("Versace on the Floor", "Bruno Mars"));
		data.add(new Song("24K Magic", "Mruno Bars"));
		data.add(new Song("That's What I Like", "Rbuno Amars"));
	}

}
