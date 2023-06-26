package system;

import app.DrawingApp;
import gui.BoardCell;

public class Flag implements Diagram {
	private int animationType;
	private char[][] board;

	/*
	 * Constructor that initializes the animationType with the provided parameter
	 * value and initializes the board with the diagram resulting from calling
	 * DrawingApp.getFlag(). You can use the method BoardCell.getCharArray() to
	 * generate a two-dimensional array of characters from the string returned by
	 * DrawingApp.getFlag().
	 */
	public Flag(int size, char color1, char color2, char color3, int animationType) {
		String boardChars = DrawingApp.getFlag(size, color1, color2, color3);

		this.animationType = animationType;
		board = BoardCell.getCharArray(boardChars);
	}// Flag constructor

	// Returns the board
	public char[][] getBoard() {
		return board;
	}// getBoard

	/*
	 * Returns a two-dimensional array of characters representing the next animation
	 * step. If the animationType is 1, the board instance variable will be updated
	 * by rotating the board one column to the left; if the animationType is 2, the
	 * board instance variable will be updated by rotating the top row.
	 */
	public char[][] nextAnimationStep() {
		if (animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn(board);
		} else if (animationType == 2) {
			TwoDimArrayUtil.rotateTopOneRow(board);
		}

		return board;
	}// nextAnimationStep

	// Number of rows associated with the diagram
	public int getNumberRows() {
		return board.length;
	}// getNumberRows

	// Number of columns associated with the diagram
	public int getNumberCols() {
		return board[0].length;
	}// getNumberCols
}// Flag
