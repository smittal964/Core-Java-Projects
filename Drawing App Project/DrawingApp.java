package app;

import java.util.Random;

public class DrawingApp {
	/*
	 * For every method remove the line with "throw ..." and implement the method.
	 * We are using "throw..." so your code does not display any compilation errors
	 * when you import the zip file. Also, if you don't implement a method you will
	 * see a white square (instead of green) in the submit server
	 */
	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		String rectangle = "";
		String recSymbol = Character.toString(symbol);
		String newLine = System.lineSeparator();

		if (maxRows < 1 || maxCols < 1) {// initial check
			return null;
		} else {
			for (int counter = 0; counter < maxRows; counter++) {
				for (int counterTwo = 0; counterTwo < maxCols; counterTwo++) {
					rectangle = rectangle + recSymbol;
				} // inner for
				if (counter != maxRows - 1) {
					rectangle = rectangle + newLine;
				}
			} // outer for
			return rectangle;
		} // else
	}// getRectangle

	private static String flagOneRow(int size, int limit, char color1, char color2) {
		int counter;
		int counter2;
		String rectangle = "";
		String colorToUse1 = Character.toString(color1);
		String colorToUse2 = Character.toString(color2);

		for (counter = 0; counter < limit; counter++) {
			rectangle = rectangle + colorToUse1;
		} // making first color group
		for (counter2 = 0; counter2 < (size - limit); counter2++) {
			rectangle = rectangle + colorToUse2;
		} // making second color group

		return rectangle;

	}// one row of flag

	public static String getFlag(int size, char color1, char color2, char color3) {
		int numRows = size * 2;
		int numCols = size * 5;
		int counter2 = 1;
		int counter;
		String rectangle = "";
		String newLine = System.lineSeparator();

		if (size < 3) {// initial check
			return null;
		} else {
			for (counter = 0; counter <= numRows; counter++) {
				if (counter == 0) {
					rectangle = rectangle + flagOneRow(numCols, counter + 1, color1, color2);
					rectangle = rectangle + newLine;
				} else if (counter > 0 && counter < size - 1 && counter != numRows) {
					rectangle = rectangle + flagOneRow(numCols, counter + 1, color1, color3);
					rectangle = rectangle + newLine;
				} else if (counter > 0 && (counter == size || counter == size + 1) && counter != numRows) {
					rectangle = rectangle + flagOneRow(numCols, size, color1, color2);
					rectangle = rectangle + newLine;
				} else if (counter > 0 && counter > size + 1 && counter != numRows) {
					rectangle = rectangle + flagOneRow(numCols, size - counter2, color1, color3);
					rectangle = rectangle + newLine;
					counter2++;
				} else if (counter == numRows) {
					rectangle = rectangle + flagOneRow(numCols, 1, color1, color2);
				}
			} // for outer
			return rectangle;
		} // else
	}// getFlag

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		int numBars = maxRows / bars;
		int counter;
		String rectangle = "";
		String newLine = System.lineSeparator();

		if (numBars < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {// initial check
			return null;
		} else {
			for (counter = 0; counter < bars; counter++) {
				if (counter % 3 == 0) {
					rectangle = rectangle + getRectangle(numBars, maxCols, color1);
				} else if ((counter - 1) % 3 == 0) {
					rectangle = rectangle + getRectangle(numBars, maxCols, color2);
				} else if ((counter - 2) % 3 == 0) {
					rectangle = rectangle + getRectangle(numBars, maxCols, color3);
				}
				if (counter != bars - 1) {
					rectangle = rectangle + newLine;
				}
			}
			return rectangle;
		}
	}// getHorizontalBars

	private static String verBarOneRow(int numChars, char charToUse) {
		String row = "";
		String symToUse = Character.toString(charToUse);
		int counter;

		for (counter = 0; counter < numChars; counter++) {
			row = row + symToUse;
		}

		return row;
	}// one row for getVerticalBars

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		int verBars = maxCols / bars;
		int counter;
		int counter2;
		String rectangle = "";
		String newLine = System.lineSeparator();

		if (verBars < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		} else {
			for (counter = 0; counter < maxRows; counter++) {
				for (counter2 = 0; counter2 < bars; counter2++) {
					if (counter2 % 3 == 0) {
						rectangle = rectangle + verBarOneRow(verBars, color1);
					} else if ((counter2 - 1) % 3 == 0) {
						rectangle = rectangle + verBarOneRow(verBars, color2);
					} else if ((counter2 - 2) % 3 == 0) {
						rectangle = rectangle + verBarOneRow(verBars, color3);
					}
				} // inner for

				if (counter != maxRows - 1) {
					rectangle = rectangle + newLine;
				} // newLine

			} // outer for
			return rectangle;
		} // else
	}// getVerticalBars

	public static char getRandomColor(Random random) {
		int newRand = random.nextInt(6);
		char returnVal = ' ';

		if (newRand == 0) {
			returnVal = 'R';
		} else if (newRand == 1) {
			returnVal = 'G';
		} else if (newRand == 2) {
			returnVal = 'B';
		} else if (newRand == 3) {
			returnVal = 'Y';
		} else if (newRand == 4) {
			returnVal = '*';
		} else if (newRand == 5) {
			returnVal = '.';
		} else {
			returnVal = '$';
		}
		return returnVal;

	}// getRandomColor

	private static boolean isValidColor(char color) {
		if (color == 'R') {
			return true;
		} else if (color == 'G') {
			return true;
		} else if (color == 'B') {
			return true;
		} else if (color == 'Y') {
			return true;
		} else if (color == '*') {// black
			return true;
		} else if (color == '.') {// white
			return true;
		} else
			return false;
	}// isValidColor

}// DrawingApp class