

public class Game extends Media{
	

	private double weight;

	public Game(String title, int Copies, double weight) {

		super(title, Copies);
		this.weight = weight;

	}

	public double getweight() {
		return weight;
	}

	public String toString() {

		return "Game Title: " + title + " /Copies Available: " + 
				Copies + " /Weight: " + weight;

	}

	
	
}
