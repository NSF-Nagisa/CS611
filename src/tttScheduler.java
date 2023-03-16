/* 
 * The scheduler used in tic-tac-toe.
 * Leon Zhang
 * 20/2/2023
 */

/*
 * The class should be implemented with a board, two players and a view.
 */
public class tttScheduler extends Scheduler {
	public tttScheduler() {
		super();
	}
	
	public tttScheduler(Board board, Player P1, Player P2, View view) {
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
		String line;
		String[] pos;
		Player curPlayer;
		curPlayer = schedule[turn];
		view.print(curPlayer.getName() + " Enter your move:");
		line = view.getS();
		if (checkFormat(line)) {
			pos = line.split(",");
			row = Integer.valueOf(pos[0]);
			col = Integer.valueOf(pos[1]);
			boolean isPlaced = board.placePiece(row, col, curPlayer.getPiece());
			if (isPlaced) {
				turn = (turn+1) % 2;
			}
			return isPlaced;
		}
		else {
			view.print("Incorrect input format.");
			return false;
		}
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
