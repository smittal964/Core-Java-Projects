package system;

public class CombineTopBottom implements Diagram {
	private int animationType;
	private char[][] board;

	/*
	 * Constructor that initializes the animationType with the provided parameter
	 * value and initializes the board with the diagram resulting from calling
	 * TwoDimArrayUtil.appendTopBottom() on the boards associated with the top and
	 * bottom diagrams.
	 */
	public CombineTopBottom(Diagram top, Diagram bottom, int animationType) {

		if (top.getBoard().length != bottom.getBoard().length) {
			throw new IllegalArgumentException("Invalid arrays");
		} else {
			this.animationType = animationType;
			this.board = TwoDimArrayUtil.appendTopBottom(top.getBoard(), bottom.getBoard());
		}
	}// CombineTopBottom constructor

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
}// CombineTopBottom
