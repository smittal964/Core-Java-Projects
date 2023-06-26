package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements CustomerInt {
	private String name;
	private String address;
	private String plan;
	private ArrayList<Object> rented = new ArrayList<Object>();
	private ArrayList<String> queue = new ArrayList<String>();

	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
	}// Customer constructor

	/*
	 * Compares customer names
	 */
	public int compareTo(Customer customer) {

		return this.name.compareTo(customer.getName());
	}

	/*
	 * Gets customer name
	 */
	public String getName() {

		return name;
	}

	/*
	 * Gets customer address
	 */
	public String getAddress() {

		return address;
	}

	/*
	 * Gets customer plan
	 */
	public String getPlan() {

		return plan;
	}

	/*
	 * Gets customer queue arraylist
	 */
	public ArrayList<String> getQueue() {

		return queue;
	}

	/*
	 * Gets customer rented arraylist
	 */
	public ArrayList<Object> getRented() {

		return rented;
	}
}// Customer
