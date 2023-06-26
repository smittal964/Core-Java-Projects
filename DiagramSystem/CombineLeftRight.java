package system;

public class CombineLeftRight implements Diagram {
	private int animationType;
	private char[][] board;

	/*
	 * Constructor that initializes the animationType with the provided parameter
	 * value and initializes the board with the diagram resulting from calling
	 * TwoDimArrayUtil.appendLeftRight() on the boards associated with the left and
	 * right diagrams.
	 */
	public CombineLeftRight(Diagram left, Diagram right, int animationType) {
		if (left.getBoard().length != right.getBoard().length) {
			throw new IllegalArgumentException("Invalid arrays");
		} else {
			this.animationType = animationType;
			this.board = TwoDimArrayUtil.appendLeftRight(left.getBoard(), right.getBoard());
		}
	}// CombineLeftRight constructor

	// returns the board
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
		if (this.animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn(board);
		} else if (this.animationType == 2) {
			TwoDimArrayUtil.rotateTopOneRow(board);
		}

		return board;
	}// nextAnimationStep

	public int getNumberRows() {
		return board.length;
	}// getNumberRowws

	public int getNumberCols() {
		return board[0].length;
	}// getNumberCols

}// CombineLeftRight
