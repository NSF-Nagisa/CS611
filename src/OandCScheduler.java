/* 
 * The scheduler used in Order and Chaos.
 * Leon Zhang
 * 20/2/2023
 */

/*
 * The class should be implemented with a board, two OandCPlayers and a view.
 */
public class OandCScheduler extends Scheduler {
	
	public OandCScheduler() {
		this(new Board(3, 3), new Player(), new Player(), new View());
	}
	
	public OandCScheduler(Board board, Player P1, Player P2, View view) {
		super(board, P1, P2, view);
		OandCPlayer P = (OandCPlayer) P1;
		if (P.getSide() == 'O') {
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
		chooseAPiece(curPlayer);
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
	/*
	 * Set a player's piece.
	 * Parameters:
	 * P: player who need to be set
	 */
	public void chooseAPiece(Player P) {
		int index = 0;
		boolean isValid = false;
		view.print("" + P.getName() + " Choose which piece you want to take:\n 1. O\n 2. X\n");
		while(!isValid) {
			index = view.getI();
			if (index == 1) {
				P.setPiece('O');
				isValid = true;
			}
			else if (index == 2) {
				P.setPiece('X');
				isValid = true;
			}
			else {
				view.print("Invalid input. Please try again.");
			}
		}
	}
	
	@Override
	public void reset() {
		OandCPlayer P = (OandCPlayer) schedule[0];
		if (P.getSide() == 'O') {
			turn = 0;
		}
		else {
			turn = 1;
		}
	}
}
