package mediaRentalManager;

public class Movie implements MoviesAlbum {
	private String title;
	private int copiesAvailable;
	private String rating;

	public Movie(String title, int copiesAvailable, String rating) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
		this.rating = rating;
	}// Movie constructor

	/*
	 * Gets movie title
	 */
	public String getTitle() {

		return title;
	}// getTitle

	/*
	 * Gets copies available
	 */
	public int getCopiesAvailable() {

		return copiesAvailable;
	}

	/*
	 * Compares movie titles
	 */
	public int compareTo(MoviesAlbum media) {
		return title.compareTo(media.getTitle());
	}

	/*
	 * Gets movie rating
	 */
	public String getRating() {

		return rating;
	}

	/*
	 * Decreases copies available by specified number
	 */
	public void decreaseCopies(int decNum) {
		copiesAvailable = copiesAvailable - decNum;
	}

	public String getArtist() {// Movies don't have artists
		return "";
	}

	public String getSongs() {// Movies don't have songs
		return "";
	}
}// Movies
