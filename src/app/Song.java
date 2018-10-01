package app;


import javafx.beans.property.SimpleStringProperty;


public class Song {

	private SimpleStringProperty songTitle;
	private SimpleStringProperty songArtist;
	private SimpleStringProperty albumTitle;
	private SimpleStringProperty albumYear;
	
	/*Default Constructor: Empty*/
	public Song(){
		
	}
	
	/*Constructor if only Song Title and Artist are provided*/
	public Song(String s1, String s2){
		songTitle = new SimpleStringProperty(s1);
		songArtist = new SimpleStringProperty(s2);
	}
	
	/*Constructor if all song fields are provided*/
	public Song(String s1, String s2, String s3, String s4){
		songTitle = new SimpleStringProperty(s1);
		songArtist = new SimpleStringProperty(s2);
		albumTitle = new SimpleStringProperty(s3);
		albumYear = new SimpleStringProperty(s4);
	}
	
	/*----- get&set methods for songTitle -----*/
	public String getSongTitle(){
		return songTitle.get();
	}
	public void setSongTitle(String s){
		songTitle.set(s);
	}
	
	/*----- get&set methods for songArtist -----*/
	public String getSongArtist(){
		return songArtist.get();
	}
	public void setSongArtist(String s){
		songArtist.set(s);
	}
	
	/*----- get&set methods for albumTitle -----*/
	public String getAlbumTitle(){
		return albumTitle.get();
	}
	public void setAlbumTitle(String s){
		albumTitle.set(s);
	}
	
	/*----- get&set methods for albumYear -----*/
	public String getAlbumYear(){
		return albumYear.get();
	}
	public void setAlbumYear(String s){
		albumYear.set(s);
	}
	
	public String toString(){
		return (songTitle.get() + ", by " + songArtist.get());
	}
	
	
	
	
}
