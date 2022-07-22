package application;

public class Game extends Media {

	private double weight;

	public Game(String Code, String title, int Copies, double weight) {
		super(Code, title, Copies);
		this.weight = weight;
	}

	public Game() {
		super("", "", 0);
		this.weight = 0;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Game:- Code" + Code + " ,Title: " + title + " ,Copies Available: " + Copies + " ,Weight: " + weight;
	}
}
