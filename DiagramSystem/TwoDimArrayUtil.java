package system;

public class TwoDimArrayUtil {

	/*
	 * Returns true if the array is a ragged array and false otherwise
	 */
	public static boolean isRagged(char[][] array) {
		boolean returnVal = true;

		for (int i = 0; i < array.length; i++) {
			if (array[i].length != array[0].length) {
				return true;
			} else {
				returnVal = false;
			} // else
		} // for
		return returnVal;
	}// isRagged

	/*
	 * Rotates the array by shifting rows one position up (second row will become
	 * the first row, third row will become the second row, etc.). The first row
	 * will become the last row. To get the most practice you should not create a
	 * new array in order to perform the rotation. No processing takes place if the
	 * array only has one row.
	 */
	public static void rotateTopOneRow(char[][] array) {
		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid array");
		} else if (array.length == 1) {
			return;
		} else {
			char[] firstElement = array[0];
			for (int i = 0; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			} // for
			array[array.length - 1] = firstElement;
		} // else
	}// rotateTopOneRow

	/*
	 * Rotates the array by shifting columns one position to the left (second column
	 * will become the first column, third column will become the second column,
	 * etc.). The first column will become the last column. To get the most practice
	 * you should not create a new array in order to perform the rotation. No
	 * processing takes place if the array only has one column.
	 */
	public static void rotateLeftOneColumn(char[][] array) {
		int j;
		char firstElement;

		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid array");
		} else if (array[0].length == 1) {
			return;
		} else {
			for (int i = 0; i < array.length; i++) {
				firstElement = array[i][0];
				for (j = 0; j < array[i].length - 1; j++) {
					array[i][j] = array[i][j + 1];
				}
				array[i][array[i].length - 1] = firstElement;
			} // for
		} // else
	}// rotateLeftOneColumn

	/*
	 * Returns a new two-dimensional array of characters where elements from the top
	 * array appear first, followed by elements from the bottom array. The arrays do
	 * not need to have the same number of rows or columns.
	 */
	public static char[][] appendTopBottom(char[][] top, char[][] bottom) {
		char[][] newArray = new char[top.length + bottom.length][];

		for (int i = 0; i < newArray.length; i++) {// total number of rows
			if (i < top.length) {// top
				newArray[i] = top[i];
			} else {// bottom
				newArray[i] = bottom[i - top.length];
			}
		} // for

		return newArray;
	}// appendTopBottom

	/*
	 * Returns a new two-dimensional array of characters where rows with the same
	 * index in the left and right arrays have been combined (row from right array
	 * appended to corresponding row from left array). The arrays do not need to
	 * have the same number of rows or columns.
	 */
	public static char[][] appendLeftRight(char[][] left, char[][] right) {
		int arraySize;
		char[][] newArray;

		if (left.length > right.length) {// set size of newArray
			arraySize = left.length;
		} else {
			arraySize = right.length;
		}
		newArray = new char[arraySize][];

		for (int i = 0; i < newArray.length; i++) {// left is longer
			if (left.length > right.length) {
				if (i > right.length - 1) {// extra rows
					newArray[i] = left[i];
				} else {// when rows correspond
					newArray[i] = new char[left[i].length + right[i].length];
					for (int j = 0; j < newArray[i].length; j++) {
						if (j < left[i].length) {
							newArray[i][j] = left[i][j];
						} else {
							if (left[i].length != right[i].length) {// different lengths
								newArray[i][j] = right[i][j - left[i].length];
							} else {// right and left are same length
								newArray[i][j] = right[i][j - right[i].length];
							}
						}
					} // for
				} // else
			} else if (right.length > left.length) {// right is longer
				if (i > left.length - 1) {// extra rows
					newArray[i] = right[i];
				} else {// when rows correspond
					newArray[i] = new char[left[i].length + right[i].length];
					for (int j = 0; j < newArray[i].length; j++) {
						if (j < left[i].length) {// left array first
							newArray[i][j] = left[i][j];
						} else {// right array
							if (left[i].length != right[i].length) {// different row lengths
								newArray[i][j] = right[i][j - left[i].length];
							} else {// right and left rows are same length
								newArray[i][j] = right[i][j - right[i].length];
							}
						} // else
					} // for
				} // else
			} else {// left and right are equal in length
				newArray[i] = new char[left[i].length + right[i].length];
				for (int j = 0; j < newArray[i].length; j++) {
					if (j < left[i].length) {
						newArray[i][j] = left[i][j];
					} else {
						if (left[i].length != right[i].length) {// different row lengths
							newArray[i][j] = right[i][j - left[i].length];
						} else {// right and left rows are same length
							newArray[i][j] = right[i][j - right[i].length];
						}
					} // else
				} // for
			} // else
		} // for

		return newArray;
	}// appendLeftRight

}// TwoDimArrayUtil
