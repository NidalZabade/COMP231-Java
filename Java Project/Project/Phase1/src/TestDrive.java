import java.io.*;
import java.util.*;

/*public class TestDrive {
	static MediaRentalManager m = new MediaRentalManager();

	public static void main(String[] args) throws Exception {
		File customer = new File("/Users/hp/Desktop/Project/Customer.txt");
		File media = new File("/Users/hp/Desktop/Project/media.txt");
		File prosses = new File("/Users/hp/Desktop/Project/Prosses.txt");
		File extra = new File("/Users/hp/Desktop/Project/Extra.txt");
		Scanner sc = new Scanner(customer);
		PrintWriter first = new PrintWriter(customer);
		first.print("Customers' Information:-");
		first.close();
		PrintWriter second = new PrintWriter(media);
		second.print("Media Information:-");
		second.close();

		if (sc.nextLine().equals("Customers' Information:-")) {
			while (sc.hasNextLine()) {
				String[] c = sc.nextLine().split(" ");
				testAddingCustomers(c[1], c[3], c[5]);
			}
			Scanner sm = new Scanner(media);
			if (sm.nextLine().equals("Media Information:-")) {
				while (sm.hasNextLine()) {
					String[] m = sm.nextLine().split(" ");
					if (m[0].equals("Movie")) {
						testAddingMedia(m[0], m[3], m[6], m[8], "", "", "");
					} else if (m[0].equals("Album")) {
						testAddingMedia(m[0], m[3], m[6], "", m[8], m[10], "");
					} else if (m[0].equals("Game")) {
						testAddingMedia(m[0], m[3], m[6], "", "", "", m[8]);
					}

				}
			}

			boolean True = true;
			Scanner ss = new Scanner(System.in);

			while (True) {
				int selected;
				System.out.println(
						"1- Add new Customer\n2- Add Media\n3- Rent Media\n4- Remove Rented Media\n5- RequestOne\n6- RequestOne\n7- Return Media\n8- Search for Media\n9- Update Files\n0- Exit");

				System.out.println("Enter a Number:");
				selected = ss.nextInt();
				if (selected == 1) {
					System.out.println("Enter Customer's Name, Address and Plan (LIMITED/UNLIMITED)");
					String[] c = new String[3];
					c[0] = ss.next();
					c[1] = ss.next();
					c[2] = ss.next();
					testAddingCustomers(c[0], c[1], c[2]);
				} else if (selected == 2) {
					System.out.println("Enter Media type(Movie/Album/Game)");
					String Type = ss.next();
					if (Type.equals("Movie")) {
						System.out.println("Enter Movie's Title, Number Of Copies and Rating");
						String[] movie = new String[3];
						movie[0] = ss.next();
						movie[1] = ss.next();
						movie[2] = ss.next();
						testAddingMedia(Type, movie[0], movie[1], movie[2], "", "", "");

					} else if (Type.equals("Album")) {
						System.out.println("Enter Album's Title, Number Of Copies, Artist and Songs");
						String[] album = new String[4];
						album[0] = ss.next();
						album[1] = ss.next();
						album[2] = ss.next();
						album[3] = ss.next();
						testAddingMedia(Type, album[0], album[1], "", album[2], album[3], "");
					} else if (Type.equals("Game")) {
						System.out.println("Enter Game's Title, Number Of Copies and Weight");
						String[] game = new String[3];
						game[0] = ss.next();
						game[1] = ss.next();
						game[2] = ss.next();
						testAddingMedia(Type, game[0], game[1], "", "", "", game[2]);
					}

				} else if (selected == 3) {
					System.out.println("Enter Customer Name and Media Title");
					String[] rent = new String[2];
					rent[0] = ss.next();
					rent[1] = ss.next();
					testingAddingToCart(rent[0], rent[1]);
				} else if (selected == 4) {
					System.out.println("Enter Customer Name and Media Title");
					String[] remove = new String[2];
					remove[0] = ss.next();
					remove[1] = ss.next();
					testingAddingToCart(remove[0], remove[1]);
				} else if (selected == 5) {
					testProcessingRequestsTwo();
				} else if (selected == 6) {
					testProcessingRequestsTwo();
				} else if (selected == 7) {
					System.out.println("Enter Customer Name and Media Title");
					String[] Return = new String[2];
					Return[0] = ss.next();
					Return[1] = ss.next();
					testReturnMedia(Return[0], Return[1]);
				} else if (selected == 8) {
					System.out.println("Write to Search in form of(Title Rating Artist Songs)");
					String[] search = ss.nextLine().split(" ");
					testSearchMedia(search[0], search[1], search[2], search[3]);
				} else if (selected == 9) {
					PrintWriter writer1 = new PrintWriter("/Users/hp/Desktop/Project/Customer.txt");
					PrintWriter writer2 = new PrintWriter("/Users/hp/Desktop/Project/Media.txt");
					writer1.print(m.getAllCustomersInfo());
					writer2.print(m.getAllMediaInfo());
					writer1.close();
					writer2.close();
				} else if (selected == 0) {
					System.out.println("Thank you for using");
					PrintWriter writer1 = new PrintWriter("/Users/hp/Desktop/Project/Customer.txt");
					PrintWriter writer2 = new PrintWriter("/Users/hp/Desktop/Project/Media.txt");
					writer1.print(m.getAllCustomersInfo());
					writer2.print(m.getAllMediaInfo());
					writer1.close();
					writer2.close();
					break;
				}

			}
		}
	}

	public static void testAddingCustomers(String name, String address, String plan) {
		m.addCustomer(name, address, plan);
	}

	public static void testAddingMedia(String Type, String Title, String numberOfCopies, String Rating, String Artist,
			String Songs, String Whight) {
		if (Type.equals("Movie")) {
			m.addMovie(Title, Integer.parseInt(numberOfCopies), Rating);
		} else if (Type.equals("Album")) {
			m.addAlbum(Title, Integer.parseInt(numberOfCopies), Artist, Songs);
		} else if (Type.equals("Game")) {
			m.addGame(Title, Integer.parseInt(numberOfCopies), Double.parseDouble(Whight));
		}
	}

	public static void testingAddingToCart(String customerName, String Title) {
		m.addToCart(customerName, Title);
	}

	public static void testingRemovingFromCart(String customerName, String Title) {
		m.removeFromCart(customerName, Title);

	}

	public static void testReturnMedia(String customerName, String Title) {
		m.returnMedia(customerName, Title);
	}
	
	public static void testProcessingRequestsOne() throws IOException {
		PrintWriter write2 = new PrintWriter("/Users/hp/Desktop/Project/Extra.txt");
		write2.print("Befor prosses:-\n");
		write2.print(m.CustomerData);
		write2.print(m.processRequests());
		write2.close();
	}

	public static void testProcessingRequestsTwo() throws IOException {
		PrintWriter write2 = new PrintWriter("/Users/hp/Desktop/Project/Prosses.txt");
		write2.print(m.processRequests());
		write2.close();
	}

	public static void testSearchMedia(String Title, String Rating, String Artist, String Songs) {
		for (int i = 0; i < m.searchMedia(Title, Rating, Artist, Songs).size(); i++) {
			System.out.println(m.searchMedia(Title, Rating, Artist, Songs));
		}
	}

}*/
