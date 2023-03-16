/* 
 * The scheduler used in Connect-4.
 * Leon Zhang
 * 20/2/2023
 */

/*
 * The class should be implemented with a board, two players and a view.
 */
public class C4Scheduler extends Scheduler {

	public C4Scheduler() {
		super();
	}
	
	public C4Scheduler(Board board, Player P1, Player P2, View view) {
		super(board, P1, P2, view);
		if (P1.getPiece() == 'X') {
			schedule[0] = P1;
			schedule[1] = P2;
		}
		else {
			schedule[0] = P2;
			schedule[1] = P1;
		}
	}
	
	@Override
	public boolean takeAction() {
		int row, col;
		Player curPlayer;
		curPlayer = schedule[turn];
		view.print(curPlayer.getName() + " Enter the column you want to place piece:");
		col = view.getI();
		row = getAvaiPos(col);
		if (row < 0) {
			view.print("Cannot place a piece in that column.");
			return false;
		}
		else {
			boolean isPlaced = board.placePiece(row, col, curPlayer.getPiece());
			if (isPlaced) {
				turn = (turn+1) % 2;
			}
			return isPlaced;
		}
	}
	/*
	 * Get the first available position of the given column from bottom to top.
	 * Parameters:
	 * col: column coordinate
	 * Output: 
	 * A integer that is the index of the row where the first available position from bottom to top is.
	 *		   If the column is full, return -1
	 */
	public int getAvaiPos(int col) {
		if (col < 0 | col >= board.col) {
			return -1;
		}
		for (int i = board.row-1; i >= 0; --i) {
			if (board.getPos(i, col) == ' ') {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public void reset() {
		if (schedule[0].getPiece() == 'X') {
			turn = 0;
		}
		else {
			turn = 1;
		}
	}
}
