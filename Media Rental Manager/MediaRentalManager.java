package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalManagerInt {
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<MoviesAlbum> mediaList = new ArrayList<MoviesAlbum>();
	private int limitedPlanLimit;

	/*
	 * Adds the specified customer to the database. The address is a physical
	 * address (not e-mail). The plan options available are: LIMITED and UNLIMITED.
	 * LIMITED defines a default maximum of two media that can be rented.
	 */
	public void addCustomer(String name, String address, String plan) {
		Customer customerToAdd = new Customer(name, address, plan);

		if (plan == "LIMITED" || plan == "UNLIMITED") {
			customerList.add(customerToAdd);

			if (customerToAdd.getPlan() == "LIMITED") {
				limitedPlanLimit = 2;
			}
		} // if
	}// addCustomer

	/*
	 * Adds the specified movie to the database. The possible values for rating are
	 * "PG", "R", "NR".
	 */
	public void addMovie(String title, int copiesAvailable, String rating) {
		Movie movieToAdd = new Movie(title, copiesAvailable, rating);

		if (rating == "PG" || rating == "R" || rating == "NR") {
			mediaList.add(movieToAdd);
		}
	}// addMovie

	/*
	 * Adds the specified album to the database. The songs String includes a list of
	 * the title of songs in the album (song titles are separated by commas).
	 */
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Album albumToAdd = new Album(title, copiesAvailable, artist, songs);

		mediaList.add(albumToAdd);
	}// addAlbum

	/*
	 * This set the number of media associated with the LIMITED plan.
	 */
	public void setLimitedPlanLimit(int value) {
		if (value > 0) {
			limitedPlanLimit = value;
		}
	}// setLimitedPlanLimit

	/*
	 * Returns information about the customers in the database. The information is
	 * presented sorted by customer name. See the public tests for the format to
	 * use.
	 */
	public String getAllCustomersInfo() {
		String returnString = "***** Customers' Information *****\n";

		Collections.sort(customerList);

		for (int i = 0; i < customerList.size(); i++) {
			returnString = returnString + "Name: " + customerList.get(i).getName() + ", ";
			returnString = returnString + "Address: " + customerList.get(i).getAddress() + ", ";
			returnString = returnString + "Plan: " + customerList.get(i).getPlan() + "\n";
			returnString = returnString + "Rented: " + customerList.get(i).getRented() + "\n";
			returnString = returnString + "Queue: " + customerList.get(i).getQueue() + "\n";
		} // for

		return returnString;
	}// getAllCustomersInfo

	/*
	 * Returns information about all the media (movies and albums) that are part of
	 * the database. The information is presented sorted by media title. See the
	 * public tests for the format to use.
	 */
	public String getAllMediaInfo() {
		String returnString = "***** Media Information *****\n";

		Collections.sort(mediaList);

		for (int i = 0; i < mediaList.size(); i++) {
			returnString = returnString + "Title: " + mediaList.get(i).getTitle() + ", ";
			returnString = returnString + "Copies Available: " + mediaList.get(i).getCopiesAvailable() + ", ";
			if (mediaList.get(i) instanceof Movie) {
				returnString = returnString + "Rating: " + mediaList.get(i).getRating() + "\n";
			} else if (mediaList.get(i) instanceof Album) {
				returnString = returnString + "Artist: " + mediaList.get(i).getArtist() + ", ";
				returnString = returnString + "Songs: " + mediaList.get(i).getSongs() + "\n";
			} // else if
		} // for
		return returnString;
	}// getAllMediaInfo

	/*
	 * Adds the specified media title to the queue associated with a customer.
	 */
	public boolean addToQueue(String customerName, String mediaTitle) {
		boolean returnVal = false;

		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName() == customerName) {
				if (!customerList.get(i).getQueue().contains(mediaTitle)) {// media does not already exist in queue
					customerList.get(i).getQueue().add(mediaTitle);
					return true;
				} // if
			} // if
		} // for
		return returnVal;
	}// addToQueue

	/*
	 * Removes the specified media title from the customer's queue.
	 */
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		boolean returnVal = false;

		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName() == customerName) {
				customerList.get(i).getQueue().remove(mediaTitle);
				return true;
			} // if
		} // for
		return returnVal;
	}// removeFromQueue

	/*
	 * Private support method. Finds the index associated with a movie or album
	 */
	private int findMedia(String title) {
		int returnVal = -1;

		if (title == null) {
			return -1;
		} else {
			for (int idx = 0; idx < mediaList.size(); idx++) {

				if (mediaList.get(idx).getTitle().equals(title)) {// found
					return idx;
				} else if (!mediaList.get(idx).getTitle().equals(title)) {// not found
					returnVal = -1;
				}
			} // for
		} // else
		return returnVal;
	}// find Media

	/*
	 * Private support method. Finds the index associated with a customer
	 */
	private int findCustomer(String name) {
		int returnVal = -1;

		if (name == null) {
			return -1;
		} else {
			for (int idx = 0; idx < customerList.size(); idx++) {

				if (customerList.get(idx).getName().equals(name)) {// found
					return idx;
				} else if (!customerList.get(idx).getName().equals(name)) {// not found
					returnVal = -1;
				} // else if
			} // for
		} // else
		return returnVal;
	}// find Media

	/*
	 * Processes the requests queue of each customer. The customers will be
	 * processed in alphabetical order. For each customer, the requests queue will
	 * be checked and media will be added to the rented queue, if the plan
	 * associated with the customer allows it, and if there is a copy of the media
	 * available. For UNLIMITED plans the media will be added to the rented queue
	 * always, as long as there are copies associated with the media available. For
	 * LIMITED plans, the number of entries moved from the requests queue to the
	 * rented queue will depend on the number of currently rented media, and whether
	 * copies associated with the media are available.
	 * 
	 * For each media that is rented, the following message will be generated:
	 * "Sending [mediaTitle] to [customerName]"
	 */
	public String processRequests() {
		String returnString = "";
		int counter = 0;

		Collections.sort(customerList);

		for (int i = 0; i < customerList.size(); i++) {
			int queueSize = customerList.get(i).getQueue().size();// customer's queue size

			if (customerList.get(i).getQueue().size() > 0) {// queue isn't empty

				if (customerList.get(i).getPlan() == "LIMITED") {// Limited plan

					if (queueSize < limitedPlanLimit) {// if queue size is less than limit
						for (int j = 0; j < queueSize; j++) {
							String mediaToAddL = customerList.get(i).getQueue().get(counter);// gets title of media to
																								// add

							if (mediaList.get(findMedia(mediaToAddL)).getCopiesAvailable() > 0) {// copies are available
								customerList.get(i).getRented().add(mediaToAddL);
								customerList.get(i).getQueue().remove(mediaToAddL);
								mediaList.get(findMedia(mediaToAddL)).decreaseCopies(1);
								returnString += "Sending " + mediaToAddL + " to " + customerList.get(i).getName()
										+ "\n";
							} else {
								counter++;// goes to next item in queue
							} // else
						} // for
					} else {// if queue size is equal to or greater than limit
						for (int j = 0; j < limitedPlanLimit; j++) {
							String mediaToAddL = customerList.get(i).getQueue().get(counter);// gets title of media to
																								// add

							if (mediaList.get(findMedia(mediaToAddL)).getCopiesAvailable() > 0) {
								customerList.get(i).getRented().add(mediaToAddL);
								customerList.get(i).getQueue().remove(mediaToAddL);
								mediaList.get(findMedia(mediaToAddL)).decreaseCopies(1);
								returnString += "Sending " + mediaToAddL + " to " + customerList.get(i).getName()
										+ "\n";
							} else {
								counter++;
							} // else
						} // for
					} // else

				} else if (customerList.get(i).getPlan() == "UNLIMITED") {// customer plan is UNLIMIED
					for (int j = 0; j < queueSize; j++) {

						String mediaToAddU = customerList.get(i).getQueue().get(counter);// gets title of media to add

						if (mediaList.get(findMedia(mediaToAddU)).getCopiesAvailable() > 0) {
							customerList.get(i).getRented().add(mediaToAddU);
							customerList.get(i).getQueue().remove(mediaToAddU);
							mediaList.get(findMedia(mediaToAddU)).decreaseCopies(1);
							returnString += "Sending " + mediaToAddU + " to " + customerList.get(i).getName() + "\n";
						} else {
							counter++;
						} // else
					} // for
				} // else if
			} // if
			counter = 0;// resets counter for next customer
		} // for
		return returnString;

	}// processRequests

	/*
	 * This is how a customer returns a rented media. This method will remove the
	 * item from the rented queue and adjust any other values that are necessary
	 * (e.g., copiesAvailable)
	 */
	public boolean returnMedia(String customerName, String mediaTitle) {
		Customer customer = customerList.get(findCustomer(customerName));

		if (customer.getRented().size() > 0) {// checks if there is actually things to return
			for (int i = 0; i < customer.getRented().size(); i++) {
				if (customer.getRented().get(i) == mediaTitle) {
					customer.getRented().remove(i);
					mediaList.get(findMedia(mediaTitle)).decreaseCopies(-1);// decrease by -1 which is +1
					return true;
				} // if
			} // for
		} // if
		return false;
	}// returnMedia

	/*
	 * Returns a SORTED ArrayList with media titles that satisfy the provided
	 * parameter values. If null is specified for a parameter, then that parameter
	 * should be ignore in the search. Providing null for all parameters will return
	 * all media titles.
	 */
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> foundArray = new ArrayList<String>();

		if (title == null && rating == null && artist == null && songs == null) {
			Collections.sort(mediaList);
			for (int i = 0; i < mediaList.size(); i++) {
				foundArray.add(mediaList.get(i).getTitle());
			}
		} else {
			for (int i = 0; i < mediaList.size(); i++) {

				if (mediaList.get(i).getTitle() == title || mediaList.get(i).getRating() == rating
						|| mediaList.get(i).getArtist() == artist
						|| (songs != null && mediaList.get(i).getSongs().contains(songs))) {

					foundArray.add(mediaList.get(i).getTitle());
				} // if
			} // for
		} // else
		Collections.sort(foundArray);
		return foundArray;
	}// searchMedia

}// MediaRentalManager
