import java.util.*;

public interface MediaRentalInt {
	public void addCustomer(String name, String address, String plan);
	public void addMovie(String title, int copiesAvailable, String rating);
	public void addGame(String title, int copiesAvailable, double weight);
	public void addAlbum(String title, int copiesAvailable, String artist, String songs);
	public void setLimitedPlanLimit(int value);
	public String getAllCustomersInfo();
	public String getAllMediaInfo();
	public boolean addToCart(String customerName, String mediaTitle);
	public boolean removeFromCart(String customerName, String mediaTitle);
	public String processRequests();
	public boolean returnMedia(String customerName, String mediaTitle);
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs);
}

