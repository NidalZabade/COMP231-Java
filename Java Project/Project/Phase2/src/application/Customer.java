package application;

import java.util.*;

public class Customer implements Comparable<Customer> {

	protected long Id;
	protected String name;
	protected String address;
	protected String mobile;
	protected String plan;
	protected ArrayList<String> interested;
	protected ArrayList<String> rented;


	public Customer(long id, String name, String address, String mobile, String plan){
		
		Id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.plan = plan;
		interested = new ArrayList<String>();
		rented = new ArrayList<String>();
	}

	public long getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getMobile() {
		return mobile;
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

	@Override
	public String toString() {
		return "Id= " + Id + " ,name= " + name + " ,address= " + address + " ,mobile= " + mobile + " ,plan= "+ plan;
	}

	public String One() {
		return "interested=" + interested ;
	}
	public String Two() {
		return "Rented=" + rented ;
	}

	@Override
	public int compareTo(Customer c) {

		if (this.getId() == c.getId())
			return 0;
		else if (this.getId() > c.getId())
			return 1;
		else
			return -1;
	}
}
