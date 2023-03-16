/* 
 * The general class of the game Order and Chaos.
 * Leon Zhang
 * 20/2/2023
 */

public class OandC extends Game {
	private OandCPlayer P1;
	private OandCPlayer P2;
	private OandCScheduler scheduler;
	
	public OandC() {
		this(new View());
	}
	
	public OandC(View view) {
		super(view);
		P1 = new OandCPlayer();
		P2 = new OandCPlayer();
	}
	
	@Override
	public void takePiece() {
		int index = 1;
		view.print("Please choose the player who would be Order:\n1. " + P1.getName() + "\n2. " + P2.getName() + "\n");
		index = view.getI();
		if (index == 1) {
			P1.setSide('O');
			P2.setSide('C');
		}
		else {
			P1.setSide('C');
			P2.setSide('O');
		}
	}

	@Override
	public void start() {
		boolean isEnd = false;
		char state;
		String line;
		
		setting();
		judger.setRule(5);
		takePiece();
		view.print(board.getSample());
		while(!isEnd) {
			scheduler.takeAction();
			view.print(board.getBoard());;
			state = judger.checkStatus();
			if (state == 'T') {
				if (P1.getSide() == 'C') {
					scoreboard.score(P1);
					view.print("" + P1 + " wins.");
				}
				else if (P2.getSide() == 'C') {
					scoreboard.score(P2);
					view.print("" + P2 + " wins.");
				}
				isEnd = true;
			}
			else if (state == 'O' | state == 'X') {
				if (P1.getSide() == 'O') {
					scoreboard.score(P1);
					view.print("" + P1.getName() + " wins.");
				}
				else if (P2.getSide() == 'O') {
					scoreboard.score(P2);
					view.print("" + P2.getName() + " wins.");
				}
				isEnd = true;
			}
			if (isEnd) {
				view.print("Continue? (y/Y)\n");
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
	public void setting() {
		
		String name;
		view.print("Please enter the name of player 1:");
		name = view.getS();
		P1.rename(name);
		view.print("Please enter the name of player 2:");
		name = view.getS();
		P2.rename(name);
		board = new Board(6, 6);
		scheduler = new OandCScheduler(board, P1, P2, view);
		judger = new Judge(board);
		scoreboard = new Scoreboard(P1, P2);
	}
	
}
