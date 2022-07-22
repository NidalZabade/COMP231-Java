

public class Album extends Media{

	private String artist;
	private String songs;
	
	public Album() {

		super(null, 0);
		this.artist =null;
		this.songs = null;

	}

	public Album(String title, int Copies, String artist, String songs) {

		super(title, Copies);
		this.artist = artist;
		this.songs = songs;

	}

	public String getArtist() {
		return artist;
	}

	public String getSongs() {
		return songs;
	}

	public String toString() {

		return "Album Title: " + title + " /Copies Available: " + 
				Copies + " /Artist: " + artist + " /Songs: "
				+ songs;

	}

	

	
}
