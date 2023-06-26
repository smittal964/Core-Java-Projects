package mediaRentalManager;

public interface MoviesAlbum extends Comparable<MoviesAlbum> {
	public String getTitle();

	public int getCopiesAvailable();

	public String getRating();

	public String getArtist();

	public String getSongs();

	public void decreaseCopies(int decNum);

}// MoviesAlbum interface