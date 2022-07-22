

public class Movie extends Media {

	private String rating;
	
	
	public Movie() {

		super("", 0);
		this.rating = "";

	}
	public Movie(String title, int Copies, String rating) {

		super(title, Copies);
		this.rating = rating;

	}

	public String getRating() {
		return rating;
	}

	public String toString() {

		return "Movie Title: " + title + " /Copies Available: " + 
				Copies + " /Rating: " + rating;

	}


}
