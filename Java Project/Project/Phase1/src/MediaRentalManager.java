import java.util.*;

public class MediaRentalManager implements MediaRentalInt {

	private int PlanLimit;
	public ArrayList<Customer> CustomerData;
	public ArrayList<Media> MediaData;

	public MediaRentalManager() {

		this.PlanLimit = 2;
		this.CustomerData = new ArrayList<Customer>();
		this.MediaData = new ArrayList<Media>();

	}

	@Override
	public void addCustomer(String name, String address, String plan) {
		Customer c=new Customer(name, address, plan);
		CustomerData.add(c);

	}
	
	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {
		Movie m=new Movie(title, copiesAvailable, rating);
		MediaData.add(m);

	}
	
	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Album a=new Album(title, copiesAvailable, artist, songs);
		MediaData.add(a);

	}


	@Override
	public void addGame(String title, int copiesAvailable, double weight) {
		Game g=new Game(title, copiesAvailable, weight);
		MediaData.add(g);

	}

	@Override
	public boolean addToCart(String customerName, String mediaTitle) {

		int x = -99;

		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getName() == customerName) {
				x = i;
			}

		}

		if (x == -99) {
			return false;
		}

		for (int i = 0; i < CustomerData.get(x).interested.size(); i++) {
			if (CustomerData.get(x).interested.get(i) == mediaTitle) {
				return false;
			}
		}

		CustomerData.get(x).interested.add(mediaTitle);
		return true;

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

						String mediaTitle = m.getTitle();

						System.out.println(c.getInterested().size());
						if (mediaTitle.equals(c.getInterested().get(r))) {

							if (m.getCopies() > 0) {

								if (c.rented.size() < PlanLimit) {

									c.interested.remove(r);

									c.rented.add(mediaTitle);

									m.numberOfCopiesAvailable(false);

									processed += "Adding " + mediaTitle + " to " + c.getName() + "\n";

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

						String mediaTitle = m.getTitle();

						if (mediaTitle.equals(c.interested.get(r))) {
							if (m.getCopies() > 0) {

								c.interested.remove(r);

								c.rented.add(mediaTitle);

								m.numberOfCopiesAvailable(false);

								processed += "Adding " + mediaTitle + " to " + c.getName() + "\n";

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
	public boolean removeFromCart(String customerName, String mediaTitle) {

		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getName() == customerName) {
				CustomerData.get(i).interested.remove(mediaTitle);
				return true;
			}
		}

		return false;

	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {

		int x = -99;

		for (int i = 0; i < CustomerData.size(); i++) {
			if (CustomerData.get(i).getName().equals(customerName)) {
				x = i;
			}
		}

		if (x == -99) {
			return false;
		}

		Customer C = CustomerData.get(x);

		for (int i = 0; i < C.rented.size(); i++) {
			if (C.rented.get(i).equals(mediaTitle)) {
				C.rented.remove(mediaTitle);

				for (int j = 0; j < MediaData.size(); j++) {
					if (MediaData.get(j).getTitle().equals(mediaTitle)) {
						MediaData.get(j).numberOfCopiesAvailable(true);
					}
				}

				return true;

			}
		}

		return false;

	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {

		ArrayList<String> Search = new ArrayList<String>();

		boolean titleSearch = false, ratingSearch = false, artistSearch = false, songsSearch = false;

		for (Media M : MediaData) {

			titleSearch = (title == null || M.getTitle().equals(title));

			if (M instanceof Movie) {

				Movie movie = (Movie) M;

				ratingSearch = (rating == null || movie.getRating().equals(rating));

				artistSearch = (artist == null);

				songsSearch = (songs == null);

			} else if (M instanceof Album) {

				Album album = (Album) M;

				artistSearch = (artist == null || album.getArtist().equals(artist));

				songsSearch = (songs == null || album.getSongs().indexOf(songs) != -1);

				ratingSearch = (rating == null);

			}

			if (titleSearch && ratingSearch && artistSearch && songsSearch) {
				Search.add(M.getTitle());
			}

		}

		Collections.sort(Search);

		return Search;

	}
	

}
