package programs;

/**
 * This class represents a person's passport. It has three instance variables
 * representing the first, last and middle name (all are String variables). A
 * character instance variable representing a separator (to be used for
 * formatting purposes) is also part of the class. In addition, the class has a
 * StringBuffer instance variable that represents the passport stamps the person
 * has received.
 * 
 * For this class you need to define and use a private method called
 * validateAndFormat that takes a character as a parameter.
 * 
 * The class will keep track of the number of instances created by using a
 * private static field called objectCount.
 * 
 * @author CS
 *
 */
public class Passport {

	private static StringBuffer passportStamp = new StringBuffer();
	private String firstName;
	private String lastName;
	private String middleName;
	private char Separator;
	private static int numObjects;

	public Passport(String firstname, String middlename, String lastname) {
		String valFirstName = validateAndFormat(firstname);
		String valMiddleName = validateAndFormat(middlename);
		String valLastName = validateAndFormat(lastname);

		if (middlename.isBlank()) {// check if middleName is blank
			this.middleName = "";

			if (valFirstName.equals(null) || valLastName.equals(null)) {
				return;
			} else {
				this.firstName = valFirstName;
				this.lastName = valLastName;
				this.Separator = ',';
				numObjects++;// increment numObjects
			}
		} else {
			if (valFirstName.equals(null) || valMiddleName.equals(null) || valLastName.equals(null)) {
				return;
			} else {
				this.firstName = valFirstName;
				this.middleName = valMiddleName;
				this.lastName = valLastName;
				this.Separator = ',';
				numObjects++;// increment numObjects
			}
		} // else
	}// Passport (first, middle, last)

	public String toString() {
		String returnString;

		if (middleName.equals("")) {
			returnString = lastName + Separator + firstName;
		} else {
			returnString = lastName + Separator + firstName + Separator + middleName;
		}

		return returnString;
	}// toString

	public Passport(String firstname, String lastname) {
		String firstNameApproved = validateAndFormat(firstname);
		String lastNameApproved = validateAndFormat(lastname);

		this.firstName = firstNameApproved;
		this.lastName = lastNameApproved;
		Separator = ',';
		middleName = "";

		numObjects++;// increment numObjects

		this.toString();

	}// Passport (first, last)

	public Passport() {
		firstName = "Samplefirstname";
		middleName = "Samplemiddlename";
		lastName = "Samplelastname";
		Separator = ',';

		numObjects++;// increment numObjects

		this.toString();

	}// Passport

	public Passport(Passport passport) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.Separator = Separator;
		this.passportStamp = passportStamp;

		numObjects++;// increment numObjects
	}

	public Passport addStamp(String stamp) {
		Passport passport = new Passport();

		if (stamp.isBlank() || stamp.equals(null)) {
			return null;
		} else {
			passportStamp.append(stamp);
		}

		return passport;
	}// addStamp

	public StringBuffer getStamps() {
		StringBuffer copyOfStamps = new StringBuffer(passportStamp);

		return copyOfStamps;
	}// getStamps

	public char getSeparator() {
		return Separator;
	}// getSeparator

	public boolean setSeparator(char separator) {
		if (separator == '@' || Character.isSpaceChar(separator) == true 
				|| Character.isLetter(separator) == true) {
			return false;
		} else {
			Separator = separator;
			return true;
		}
	}// setSeparator

	public boolean equals(Object obj) {
		boolean returnVal;

		Passport passport1 = (Passport) obj;
		String compFirstName = passport1.firstName;
		String compMiddleName = passport1.middleName;
		String compLastName = passport1.lastName;

		if (firstName.equals(compFirstName) && middleName.equals(compMiddleName) 
				&& lastName.equals(compLastName)) {
			returnVal = true;
		} else {
			returnVal = false;
		}

		return returnVal;

	}// equals

	public int compareTo(Passport passport) {
		String oFirstName = firstName;
		String oLastName = lastName;
		String oMiddleName = middleName;

		String xFirstName = passport.firstName;
		String xLastName = passport.lastName;
		String xMiddleName = passport.middleName;

		int lastnameReturnVal = 0;
		int firstnameReturnVal = 0;
		int middlenameReturnVal = 0;
		int returnVal = 0;

		if (oLastName.compareTo(xLastName) < 0) {
			lastnameReturnVal = -1;
		} else if (oLastName.compareTo(xLastName) > 0) {
			lastnameReturnVal = 1;
		} else if (oLastName.compareTo(xLastName) == 0) {
			lastnameReturnVal = 0;
		} // lastName comparisons

		if (oFirstName.compareTo(xFirstName) < 0) {
			firstnameReturnVal = -1;
		} else if (oFirstName.compareTo(xFirstName) > 0) {
			firstnameReturnVal = 1;
		} else if (oFirstName.compareTo(xFirstName) == 0) {
			firstnameReturnVal = 0;
		} // firstName comparisons

		if (oMiddleName.compareTo(xMiddleName) < 0) {
			middlenameReturnVal = -1;
		} else if (oMiddleName.compareTo(xMiddleName) > 0) {
			middlenameReturnVal = 1;
		} else if (oMiddleName.compareTo(xMiddleName) == 0) {
			middlenameReturnVal = 0;
		} // middleName comparisons

		if (lastnameReturnVal == 1) {
			returnVal = 1;
		} else if (lastnameReturnVal == -1) {
			returnVal = -1;
		} else if (lastnameReturnVal == 0) {//if lastNames are equal, compare firstNames
			if (firstnameReturnVal == 1) {
				returnVal = 1;
			} else if (firstnameReturnVal == -1) {
				returnVal = -1;
			} else if (firstnameReturnVal == 0) {//if lastNames and firstNames are equal, compare midNames
				if (middlenameReturnVal == 1) {
					returnVal = 1;
				} else if (middlenameReturnVal == -1) {
					returnVal = -1;
				} else if (middlenameReturnVal == 0) {
					returnVal = 0;
				} // middleNames
			} // firstNames
		} // lastNames

		return returnVal;

	}// compareTo

	public static int getNumberOfPassportObjects() {
		return numObjects;
	}// getNumberOfPassportObjects

	public static void resetNumberOfPassportObjects() {
		numObjects = 0;
	}// resetNumberOfPassportObjects

	public static Passport normalize(Passport passport, boolean uppercase) {
		Passport newPassport = new Passport(passport.firstName, passport.middleName, passport.lastName);

		String newFirstName = newPassport.firstName.toLowerCase();
		String newLastName = newPassport.lastName.toLowerCase();
		String newMiddleName = newPassport.middleName.toLowerCase();

		String newFirstNameCap = newPassport.firstName.toUpperCase();
		String newLastNameCap = newPassport.lastName.toUpperCase();
		String newMiddleNameCap = newPassport.middleName.toUpperCase();

		newPassport.Separator = passport.Separator;

		if (uppercase == false && passport != null) {
			newPassport.firstName = newFirstName;
			newPassport.lastName = newLastName;
			newPassport.middleName = newMiddleName;
		} else if (uppercase == true && passport != null) {
			newPassport.firstName = newFirstNameCap;
			newPassport.lastName = newLastNameCap;
			newPassport.middleName = newMiddleNameCap;
		} else if (passport == null) {
			return null;
		}
		return newPassport;
	}// normalize

	public boolean changeLastname(String lastname) {
		String newLastname = lastname;

		if (newLastname.equals(null) || newLastname.isBlank()) {
			return false;
		} else {
			this.lastName = newLastname;
			return true;
		}
	}// changeLastname

	/*
	 * This method will generate and return a formatted string in lowercase with the
	 * first character in uppercase. The parameter is valid if it is not null and it
	 * is not blank according to the string method isBlank(). If the parameter is
	 * invalid, the method will return null and perform no further processing. If
	 * the parameter is valid, spaces surrounding the parameter will be removed, the
	 * string will be converted to lowercase, and the first character of the string
	 * (after spaces have been removed) will be in upper case. The following methods
	 * can be helpful during the implementation of this method:
	 * Character.toUpperCase, and the string methods charAt and substring.
	 * 
	 * You can test this method by initially defining it public; once you have
	 * tested it, make it private.
	 * 
	 */
	public static String validateAndFormat(String name) {
		String newName = name;

		if (name.isBlank() || name.equals(null)) {
			return null;
		} else {
			newName = newName.trim();// remove spaces

			newName = newName.toLowerCase();// convert to lower case

			newName = newName.substring(0, 1).toUpperCase() + newName.substring(1);// capitalize

			return newName;
		}
	}// validateAndFormat
}