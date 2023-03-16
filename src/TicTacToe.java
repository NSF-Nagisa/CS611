/* 
 * The general class of the game tic-tac-toe.
 * Leon Zhang
 * 20/2/2023
 */

public class TicTacToe extends Game{
	
	public TicTacToe(View view) {
		super(view);
	}
	
	public TicTacToe() {
		super();
	}
	@Override
	public void start() {
		boolean isEnd = false;
		char state;
		String line;
		
		setting();
		judger.setRule(3);
		takePiece();
		view.print(board.getSample());
		while(!isEnd) {
			scheduler.takeAction();
			view.print(board.getBoard());;
			state = judger.checkStatus();
			if (state == 'T') {
				scoreboard.score(null);
				view.print("Stalemate.");
				isEnd = true;
			}
			else if (state == 'O' | state == 'X') {
				if (P1.getPiece() == state) {
					scoreboard.score(P1);
					view.print("" + P1.getName() + " wins.");
				}
				else if (P2.getPiece() == state) {
					scoreboard.score(P2);
					view.print("" + P2.getName() + " wins.");
				}
				isEnd = true;
			}
			if (isEnd) {
				view.print("Continue? (y/Y)");
				line = view.getS();
				if (line.equals("y") | line.equals("Y")) {
					isEnd = false;
					board.clear();
					takePiece();
					scheduler.reset();
					view.print(board.getSample());
				}
			}
		}
		view.print(scoreboard.toString());
	}
	@Override
	public void takePiece() {
		int index = 1;
		view.print("Please choose the player who takes X:\n1. " + P1.getName() + "\n2. " + P2.getName());
		index = view.getI();
		if (index == 1) {
			P1.setPiece('X');
			P2.setPiece('O');
			
		}
		else {
			P1.setPiece('O');
			P2.setPiece('X');
		}
	}
	@Override
	public void setting() {
		int size = 3;
		boolean isValid = false;

		String name;
		view.print("Please enter the name of player 1:");
		name = view.getS();
		P1.rename(name);
		view.print("Please enter the name of player 2:");
		name = view.getS();
		P2.rename(name);
		view.print("Please enter the length of the board:");
		while(!isValid) {
			size = view.getI();
			if (size >= 3 & size <= 10) {
				isValid = true;
			}
			else {
				view.print("The size should between 3 and 10 .");
			}
		}
		board = new Board(size, size);
		scheduler = new tttScheduler(board, P1, P2, view);
		judger = new Judge(board);
		scoreboard = new Scoreboard(P1, P2);
	}
}