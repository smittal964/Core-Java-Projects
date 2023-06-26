package sysImplementation;
//import sysImplementation.*;

public class Utilities {

	/*
	 * Return a string where each array entry (except the last one) is followed by
	 * the specified separator. An empty string will be return if the array has no
	 * elements.
	 */
	public static String getArrayString​(int[] array, char separator) {
		String arrayString = "";

		if (array == null) {
			throw new IllegalArgumentException();
		} else {
			if (array.length == 0) {
				return "";
			} else {
				for (int i = 0; i < array.length; i++) {
					if (i == 0) {
						arrayString = arrayString + array[i];
					} else {
						arrayString = arrayString + separator + array[i];
					}
				} // for
				return arrayString;
			} // else
		} // else
	}// getArrayString

	/*
	 * Returns the number of values that are in the range defined by lowerLimit
	 * (inclusive) and upperLimit (inclusive).
	 */
	public static int getInstances​(int[] array, int lowerLimit, int upperLimit) {
		int counter = 0;

		if (array == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i] >= lowerLimit && array[i] <= upperLimit) {
					counter++;
				}
			}// for
			return counter;
		} // else
	}// getInstances

	/*
	 * Returns a new array with values in array that exists in the range defined by
	 * lowerLimit (inclusive) and upperLimit (inclusive).
	 */
	public static int[] filter​(int[] array, int lowerLimit, int upperLimit) {
		int newArraySize = Utilities.getInstances​(array, lowerLimit, upperLimit);
		int[] newArray = new int[newArraySize];
		int counter = 0;

		if (array == null || lowerLimit > upperLimit) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < newArraySize + counter; i++) {
				if (array[i] < lowerLimit || array[i] > upperLimit) {
					counter++;
				} else if (array[i] >= lowerLimit && array[i] <= upperLimit) {
					newArray[i - counter] = array[i];
				}
			}// for
			return newArray;
		}// else
	}// filter

	private static void rotateOneLeft(int[] array) {
		int temp = array[0];
		int i;

		for (i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[i] = temp;
	}// rotate 1 left

	private static void rotateOneRight(int[] array) {
		int temp = array[array.length - 1];
		int i;

		for (i = array.length - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[i] = temp;
	}// rotate 1 right

	/*
	 * Rotates the provided array left if leftRotation is true; right otherwise. The
	 * number of positions to rotate is determined by positions. For example,
	 * rotating the array 10, 20, 7, 8 two positions to the left will update the
	 * array to 7, 8, 10, 20. Only arrays with 2 or more elements will be rotated.
	 * Hint: adding private methods that rotate an array one position to the left
	 * and one position to the right can help.
	 */
	public static void rotate​(int[] array, boolean leftRotation, int positions) {
		if (array == null) {
			throw new IllegalArgumentException();
		} else if(array.length < 2){
			return;
		}else {
			if (leftRotation == true) {
				for (int i = 0; i < positions; i++) {
					rotateOneLeft(array);
				}
			} else {
				for (int i = 0; i < positions; i++) {
					rotateOneRight(array);
				}
			} // else
		} // else
	}// rotate

	private static int StringBufferCount(StringBuffer[] array, int length) {
		int counter = 0;

		if (array == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i].length() > length) {
					counter++;
				} // if
			} // for
			return counter;
		}// else

	}// returns number of elements with lengths greater than specified length in
		// array

	/*
	 * Returns a StringBuffer array with COPIES of StringBuffer objects in the array
	 * parameter that have a length greater than the length parameter. If no strings
	 * are found an empty array will be returned.
	 */
	public static StringBuffer[] getArrayStringsLongerThan​(StringBuffer[] array, int length) {
		int newArraySize = StringBufferCount(array, length);
		int counter = 0;
		StringBuffer[] newArray = new StringBuffer[newArraySize];
		StringBuffer copy;
		StringBuffer[] emptyArray = new StringBuffer[newArraySize];

		if (array == null) {
			throw new IllegalArgumentException();
		} else if(newArraySize == 0){
			return emptyArray;
		}else {
			for (int i = 0; i < newArraySize + counter; i++) {
				if (array[i].length() <= length) {
					counter++;
				} else if (array[i].length() > length) {
					copy = array[i];
					newArray[i - counter] = copy;
				}
			} // for
			return newArray;
		} // else
	}// getArrayStringsLongerThan
}// Utilities