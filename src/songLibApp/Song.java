//CS 213 Assignment 1
//Jake Van Osten (jrv89) & Tiffany Moral (tm558)

package songLibApp;


import javafx.beans.property.SimpleStringProperty;

/*
 * Song Library Assignment
 * CS213 Soft Meth
 * 
 * Project Done by:
 * Tiffany Moral (tm558)
 * Jake Van Osten (jrv89)
 * 
 * 
 */


public class Song{

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
		albumTitle = new SimpleStringProperty("Not listed");
		albumYear = new SimpleStringProperty("Not listed");
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
		this.songTitle.set(s);
	}
	
	/*----- get&set methods for songArtist -----*/
	public String getSongArtist(){
		return songArtist.get();
	}
	public void setSongArtist(String s){
		this.songArtist.set(s);
	}
	
	/*----- get&set methods for albumTitle -----*/
	public String getAlbumTitle(){
		return albumTitle.get();
	}
	public void setAlbumTitle(String s){
		this.albumTitle.set(s);
	}
	
	/*----- get&set methods for albumYear -----*/
	public String getAlbumYear(){
		return albumYear.get();
	}
	public void setAlbumYear(String s){
		this.albumYear.set(s);
	}
   
	
}
