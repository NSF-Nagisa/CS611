/* 
 * The general class of board games.
 * Leon Zhang
 * 20/2/2023
 */

public abstract class Game {
	protected View view;
	protected Player P1, P2;
	protected Board board;
	protected Scoreboard scoreboard;
	protected Scheduler scheduler;
	protected Judge judger;
	
	public Game(View view) {
		P1 = new Player();
		P2 = new Player();
		board = null;
		scoreboard = null;
		scheduler = null;
		judger = null;
		this.view = view;
	}
	
	public Game() {
		this(new View());
	}
	/*
	 * Required setting of the game.
	 */
	public abstract void setting();
	
	/*
	 * Determine players take which piece.
	 */
	public abstract void takePiece();
	/*
	 * complete game logic
	 */
	public abstract void start();
}
