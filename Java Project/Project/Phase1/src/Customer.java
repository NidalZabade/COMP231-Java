import java.util.*;

public class Customer implements Comparable<Customer> {


	protected String name;
	protected String address;
	protected String plan;

	protected ArrayList<String> interested;
	protected ArrayList<String> rented;

	public Customer() {

		this.name = "";
		this.address = "";
		this.plan = "";
		interested = new ArrayList<String>();
		rented = new ArrayList<String>();

	}

	public Customer(String name, String address, String plan) {

		this.name = name;
		this.address = address;
		this.plan = plan;
		interested = new ArrayList<String>();
		rented = new ArrayList<String>();

	}

	public String getName() {
		return name;
	}

	public String getPlan() {
		return plan;
	}
	public ArrayList<String> getInterested() {
		return interested;
	}

	public ArrayList<String> getRented() {
		return rented;
	}

	public String toString() {

		return "Name: " + name + " /Address: " + address + " /Plan: " +
		plan ;

	}

	public String One() {
		return "Customer [interested=" + interested + ", rented=" + rented + "]";
	}
	@Override
	public int compareTo(Customer c) {

		Customer temp = (Customer) c;

		return this.getName().compareTo(temp.getName());
	}
	

}

