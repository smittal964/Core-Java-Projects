package photomanager;

/**
 * The Photo class represents a photo. A photo has a source (url o path to the
 * file), the width and height in pixels, the date the photo was taken and
 * comments the user has added (if any). If you look at the class definition,
 * after "public class Photo" you will see "implements Comparable&lt;Photo&gt;".
 * You can ignore it; it means that the Photo class must implement a method
 * called compareTo that takes a Photo as a parameter and returns an integer.
 * Why we need it? Because it will allow us to sort ArrayList of Photos using
 * the compareTo method that you will define. This description has been written
 * under the influence of a lot of caffeine :)
 * 
 * @author UMCP CS Department
 *
 */
public class Photo implements Comparable<Photo> {
	private String photoSource;
	private int width, height;
	private String date;
	private StringBuffer comments;

	/**
	 * Initializes the instance variables with the provided parameter values and
	 * initializes comments with a StringBuffer object. It will throw an
	 * IllegalArgumentException with the message "Constructor: Invalid arguments" if
	 * any string parameter is null or blank, or if the width or height (or both)
	 * are negative or zero. Use the String class isBlank() method to verify whether
	 * a string is blank. You can assume that if a date is provided, it represents a
	 * valid date. You don't need to verify whether photoSource represents a photo
	 * that exists.
	 * 
	 * @param photoSource Url or file location.
	 * @param width       Photo's width in pixels.
	 * @param height      Photo's height in pixels.
	 * @param date        Date the photo was taken.
	 * @throws IllegalArgumentException For invalid parameter.
	 */
	public Photo(String photoSource, int width, int height, String date) {
		StringBuffer photoComments = new StringBuffer();

		if (photoSource == null || photoSource.isBlank()) {
			throw new IllegalArgumentException("Constructor: Invalid arguments");
		} else if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Constructor: Invalid arguments");
		} else if (date.isBlank() || date == null) {
			throw new IllegalArgumentException("Constructor: Invalid arguments");
		} else {
			this.width = width;
			this.height = height;
			this.date = date;
			this.photoSource = photoSource;
			comments = photoComments;

		}
	}// Photo initializing

	/**
	 * Returns a string with photoSource, width, height and date values separated by
	 * commas. Comments are not part of the string.
	 * 
	 * @return String with values separated by commas.
	 */
	public String toString() {
		String completePhoto;
		String photoWidth = Integer.toString(width);
		String photoHeight = Integer.toString(height);

		completePhoto = photoSource + "," + photoWidth + "," + photoHeight + "," + date;

		return completePhoto;
	}// toString

	/**
	 * Get method for photoSource.
	 * 
	 * @return photoSource.
	 */
	public String getPhotoSource() {
		return photoSource;
	}// getPhotoSource

	/**
	 * Get method for width.
	 * 
	 * @return width.
	 */
	public int getWidth() {
		return width;
	}// getWidth

	/**
	 * Get method for height.
	 * 
	 * @return height.
	 */
	public int getHeight() {
		return height;
	}// getHeight

	/**
	 * Get method for date.
	 * 
	 * @return date.
	 */
	public String getDate() {
		return date;
	}// getDate

	/**
	 * Appends the newComment parameter to the comments StringBuffer. Comments must
	 * be separated by commas (the last comment should not be followed by a comma).
	 * If the parameter is null or blank (according to the String class isBlank()
	 * method) no comment will be appended, and the IllegalArgumentException with
	 * the message "Invalid comment" will be thrown. The method returns a reference
	 * to the current object.
	 * 
	 * @param newComment Comment to add.
	 * @return Reference to the current object.
	 */
	public Photo addComments(String newComment) {

		try {
			if (newComment.equals(null) || newComment.isBlank()) {
				throw new IllegalArgumentException("Invalid comment");
			} else {
				if (this.comments.length() == 0) {
					this.comments.append(newComment);
				} else {
					this.comments.append("," + newComment);
				}
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} // catch

		return this;
	}// addComments

	/**
	 * Returns a string that corresponds to the comments.
	 * 
	 * @return String corresponding to comments.
	 */
	public String getComments() {
		String photoComments = comments.toString();

		return photoComments;
	}// getComments

	/**
	 * Copy constructor. Modifications to the new object should not affect the
	 * original (parameter) object.
	 * 
	 * @param photo To copy.
	 */
	public Photo(Photo photo) {
		photoSource = photo.photoSource;
		width = photo.width;
		height = photo.height;
		date = photo.date;
		comments = new StringBuffer(photo.comments);
	}// Photo copy constructor

	/**
	 * This method will compare the date of the current object against the
	 * parameter's object. Use the Utilities.getDate() method that takes a string as
	 * a parameter and returns an integer (of type long) representing the date. We
	 * can represent dates (including time) using integers. The number returned by
	 * Utilities.getDate() represents the number of seconds that have elapsed since
	 * the Unix epoch (00:00:00 UTC on 1 January 1970). Run the main method of the
	 * Utilities.java class to see examples of these integer values.
	 * 
	 * The compareTo method will return a negative value if the date of the current
	 * object precedes the date of the parameter, zero if the dates are the same,
	 * and a positive value otherwise. Don't be surprise if the amount of code
	 * required for compareTo method is minimal. Do not using casting to convert a
	 * long to int as this could lead to wrong results.
	 * 
	 */
	public int compareTo(Photo photo) {
		Photo curPhoto = new Photo(photoSource, width, height, date);
		int returnVal = 0;
		long curObjDate = Utilities.getDate(curPhoto.date);
		long paramObjDate = Utilities.getDate(photo.date);

		if (curObjDate > paramObjDate) {// before
			returnVal = 1;
		} else if (curObjDate < paramObjDate) {// after
			returnVal = -1;
		} else if (curObjDate == paramObjDate) {// equal
			returnVal = 0;
		}

		return returnVal;
	}// compareTo
}// photo_class