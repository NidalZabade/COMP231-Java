package application;

public class Album extends Media {

	private String artist;
	private String songs;

	public Album(String Code, String title, int Copies, String artist, String songs) {
		super(Code, title, Copies);
		this.artist = artist;
		this.songs = songs;
	}

	public Album() {
		super("", "", 0);
		this.artist = "";
		this.songs = "";
	}

	public String getArtist() {
		return artist;
	}

	public String getSongs() {
		return songs;
	}

	@Override
	public String toString() {
		return "Album:- Code: " + Code + " ,Title: " + title + " ,Copies Available: " + Copies + " ,Artist: "
				+ artist + " ,Songs: " + songs;
	}

}
