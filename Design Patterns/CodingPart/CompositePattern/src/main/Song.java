package main;

public class Song extends SongComponent{
	private String songName;
	private String songBandName;
	private int releaseYear;
	
	public Song(String songName, String songBandName, int releaseYear) {
		this.songName = songName;
		this.songBandName = songBandName;
		this.releaseYear = releaseYear;
	}

	public String getSongName() 	{ return this.songName; }
	public String getBandName() { return this.songBandName; }
	public int getReleaseYear() 	{ return this.releaseYear; }
	
	public void displaySongInfo() {
		System.out.println(getSongName() + " was recorded by " + getBandName() + " in " + getReleaseYear());
	}
	
}
