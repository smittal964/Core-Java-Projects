package mediaRentalManager;

public class Album implements MoviesAlbum {
	private String title;
	private int copiesAvailable;
	private String artist;
	private String songs;

	public Album(String title, int copiesAvailable, String artist, String songs) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
		this.artist = artist;
		this.songs = songs;
	}// Album constructor

	/*
	 * Gets album title
	 */
	public String getTitle() {
		String coTitle = title;

		return coTitle;
	}

	/*
	 * Gets copies available
	 */
	public int getCopiesAvailable() {
		int coCopies = copiesAvailable;

		return coCopies;
	}

	/*
	 * Decreases copies available by specified number
	 */
	public void decreaseCopies(int decNum) {
		copiesAvailable = copiesAvailable - decNum;
	}

	/*
	 * Gets album artist
	 */
	public String getArtist() {
		String coArtist = artist;

		return coArtist;
	}

	/*
	 * Gets album songs
	 */
	public String getSongs() {
		String coSongs = songs;

		return coSongs;
	}

	/*
	 * Compares album titles
	 */
	public int compareTo(MoviesAlbum media) {
		return title.compareTo(media.getTitle());
	}

	public String getRating() {// Albums don't have ratings
		return "";
	}
}// Album
