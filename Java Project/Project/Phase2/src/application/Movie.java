package application;

public class Movie extends Media {

	private String rating;

	public Movie(String Code, String title, int Copies, String rating) {
		super(Code, title, Copies);
		this.rating = rating;
	}

	public Movie() {
		super("", "", 0);
		this.rating = "";
	}

	public String getRating() {
		return rating;
	}

	public String toString() {

		return "Movie:- Code: " + Code + " ,Title: " + title + " ,Copies Available: " + Copies + " ,Rating: "
				+ rating;

	}

}
