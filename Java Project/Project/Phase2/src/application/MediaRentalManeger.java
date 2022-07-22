package application;

import java.util.*;

public class MediaRentalManeger implements MediaRentalInt {

	private int PlanLimit;
	public ArrayList<Customer> CustomerData;
	public ArrayList<Media> MediaData;

	public MediaRentalManeger() {

		this.PlanLimit = 2;
		this.CustomerData = new ArrayList<Customer>();
		this.MediaData = new ArrayList<Media>();

	}

	@Override
	public void addCustomer(long id, String name, String address, String mobile, String plan) {
		Customer c = new Customer(id, name, address, mobile, plan);
		CustomerData.add(c);

	}

	@Override
	public void addMovie(String Code, String title, int Copies, String rating) {
		Movie m = new Movie(Code, title, Copies, rating);
		MediaData.add(m);

	}

	@Override
	public void addGame(String Code, String title, int Copies, double weight) {
		Game g = new Game(Code, title, Copies, weight);
		MediaData.add(g);

	}

	@Override
	public void addAlbum(String Code, String title, int Copies, String artist, String songs) {
		Album a = new Album(Code, title, Copies, artist, songs);
		MediaData.add(a);

	}

	@Override
	public void setLimitedPlanLimit(int value) {
		this.PlanLimit = value;

	}

	@Override
	public String getAllCustomersInfo() {
		String customerInfo = "Customers' Information:-\n";

		Collections.sort(CustomerData);

		for (int i = 0; i < CustomerData.size(); i++) {
			customerInfo += CustomerData.get(i).toString() + "\n";
		}

		return customerInfo;
	}

	@Override
	public String getAllMediaInfo() {
		String mediaInfo = "Media Information:-\n";

		Collections.sort(MediaData);

		for (int i = 0; i < MediaData.size(); i++) {
			mediaInfo += MediaData.get(i).toString() + "\n";
		}

		return mediaInfo;
	}

	@Override
	public boolean addToCart(long id, String Code) {
		int x = -99;

		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id) {
				x = i;
			}

		}
		if (x == -99) {
			return false;
		}

		for (int i = 0; i < CustomerData.get(x).interested.size(); i++) {
			if (CustomerData.get(x).interested.get(i).equals(Code)) {
				return false;
			}
		}
		CustomerData.get(x).interested.add(MediaData.get(x).getTitle());
		return true;

	}

	@Override
	public boolean removeFromCart(long id, String Code) {
		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id) {
				CustomerData.get(i).interested.remove(Code);
				return true;
			}
		}

		return false;

	}

	@Override
	public String processRequests() {
		String processed = "";

		Collections.sort(CustomerData);

		for (int i = 0; i < CustomerData.size(); i++) {

			Customer c = CustomerData.get(i);

			int size = c.getInterested().size();
			int r = 0;

			if (c.getPlan() == "LIMITED") {

				for (int j = 0; j < size; j++) {

					for (int k = 0; k < MediaData.size(); k++) {

						Media m = MediaData.get(k);

						String mediaCode = m.getCode();

						System.out.println(c.getInterested().size());
						if (mediaCode.equals(c.getInterested().get(r))) {

							if (m.getCopies() > 0) {

								if (c.rented.size() < PlanLimit) {

									c.interested.remove(r);

									c.rented.add(mediaCode);

									m.numberOfCopiesAvailable(false);

									processed += "Adding " + m.getTitle() + " to " + c.getName() + "\n";

									break;

								}
							} else
								r++;

						}
					}

				}

			} else if (c.getPlan() == "UNLIMITED") {

				for (int j = 0; j < size; j++) {

					for (int k = 0; k < MediaData.size(); k++) {

						Media m = MediaData.get(k);

						String mediaCode = m.getCode();

						if (mediaCode.equals(c.interested.get(r))) {
							if (m.getCopies() > 0) {

								c.interested.remove(r);

								c.rented.add(mediaCode);

								m.numberOfCopiesAvailable(false);

								processed += "Adding " + m.getTitle() + " to " + c.getName() + "\n";

								break;

							} else
								r++;
						}

					}

				}

			}

		}

		return processed;
	}

	@Override
	public boolean returnMedia(long id, String Code) {
		int x = -99;

		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id) {
				x = i;
			}
		}

		if (x == -99) {
			return false;
		}

		Customer C = CustomerData.get(x);

		for (int i = 0; i < C.rented.size(); i++) {
			if (C.rented.get(i).equals(Code)) {
				C.rented.remove(Code);

				for (int j = 0; j < MediaData.size(); j++) {
					if (MediaData.get(j).getCode().equals(Code)) {
						MediaData.get(j).numberOfCopiesAvailable(true);
					}
				}

				return true;

			}
		}

		return false;

	}

	@Override
	public ArrayList<String> searchMedia(String Code) {

		ArrayList<String> MediaSearch = new ArrayList<String>();

		for (int i = 0; i < MediaData.size(); i++) {
			if (MediaData.get(i).getCode().equals(Code))
				MediaSearch.add(MediaData.get(i).toString());
		}

		Collections.sort(MediaSearch);

		return MediaSearch;
	}

	@Override
	public ArrayList<String> searchCustomer(long id) {
		ArrayList<String> CustomerSearch = new ArrayList<String>();
		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id) {
				CustomerSearch.add(CustomerData.get(i).toString());
			}
		}
		Collections.sort(CustomerSearch);
		return CustomerSearch;
	}

	@Override
	public void deleteCustomer(long id) {
		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id) {
				CustomerData.remove(i);
			}
		}

	}

	@Override
	public void deleteMedia(String Code) {
		for (int i = 0; i < MediaData.size(); i++) {
			if (MediaData.get(i).getCode().equals(Code)) {
				MediaData.remove(i);
			}
		}
	}

	@Override
	public String getCustomerInfo(long id) {
		String Search = null;

		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id)
				Search = (CustomerData.get(i).toString());

		}
		return Search;
	}

	@Override
	public String getMediaInfo(String Code) {
		String Search = null;

		for (int i = 0; i < MediaData.size(); i++) {
			if (MediaData.get(i).getCode().equals(Code))
				Search = (MediaData.get(i).toString());

		}
		return Search;
	}

	@Override
	public String getIntrested(long id) {
		String Intrested = null;
		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id)
				Intrested = (CustomerData.get(i).One());

		}
		return Intrested;
	}

	@Override
	public String getRented(long id) {
		String Rented = null;
		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id)
				Rented = (CustomerData.get(i).Two());

		}
		return Rented;
	}

	@Override
	public boolean checkCustomer(long id) {
		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getId() == id)
				return true;
		}
		return false;
	}

	@Override
	public boolean checkMedia(String Code) {
		for (int i = 0; i < MediaData.size(); i++) {
			if (MediaData.get(i).getCode().equals(Code))
				return true;
		}
		return false;
	}

	@Override
	public boolean chechIntrested(long id) {
		for (int i = 0; i < CustomerData.size(); i++) {
			if ((CustomerData.get(i).getId() == id)&& !(CustomerData.get(i).getInterested().equals(null)))
				return true;
		}
		return false;
	}

	@Override
	public boolean chechRented(long id) {
		for (int i = 0; i < CustomerData.size(); i++) {
			if ((CustomerData.get(i).getId() == id)&& !(CustomerData.get(i).getRented().equals(null)))
				return true;
		}
		return false;
	}
}
