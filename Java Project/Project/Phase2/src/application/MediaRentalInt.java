package application;

import java.util.*;

public interface MediaRentalInt {
	public void addCustomer(long id, String name, String address, String mobile, String plan);
	public void addMovie(String Code, String title, int Copies, String rating);

	public void addGame(String Code, String title, int Copies, double weight);

	public void addAlbum(String Code, String title, int Copies, String artist, String songs);

	public void setLimitedPlanLimit(int value);

	public String getAllCustomersInfo();

	public String getAllMediaInfo();

	public boolean addToCart(long id, String Code);

	public boolean removeFromCart(long id, String Code);

	public String processRequests();

	public boolean returnMedia(long id, String Code);

	public ArrayList<String> searchMedia(String Code);

	public ArrayList<String> searchCustomer(long id);

	public void deleteCustomer(long id);

	public void deleteMedia(String Code);

	public String getCustomerInfo(long id);

	public String getMediaInfo(String Code);

	public String getIntrested(long id);

	public String getRented(long id);

	public boolean checkCustomer(long id);

	public boolean checkMedia(String Code);
	
	public boolean chechIntrested(long id);
	
	public boolean chechRented(long id);

}
