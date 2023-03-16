/* 
 * The general class of the game connect 4.
 * Leon Zhang
 * 20/2/2023
 */

public class Connect4 extends Game {

	public Connect4() {
		super();
	}
	
	public Connect4(View view) {
		super(view);
	}
	
	@Override
	public void setting() {
		int length = 7;
		int height = 6;
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
			length = view.getI();
			if (length >= 7 & length <= 15) {
				isValid = true;
			}
			else {
				view.print("The length should between 7 and 15.");
			}
		}
		isValid = false;
		view.print("Please enter the height of the board:");
		while(!isValid) {
			height = view.getI();
			if (height >= 6 & height <= 10) {
				isValid = true;
			}
			else {
				view.print("The height should between 6 and 10.");
			}
		}
		board = new Board(height, length);
		scheduler = new C4Scheduler(board, P1, P2, view);
		judger = new Judge(board);
		scoreboard = new Scoreboard(P1, P2);
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
	public void start() {
		boolean isEnd = false;
		char state;
		String line;
		
		setting();
		judger.setRule(4);
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

}
