/* 
 * The general class of schedulers.
 * Leon Zhang
 * 20/2/2023
 */

public abstract class Scheduler {
	protected Board board;
	protected Player[] schedule; // An array of char that stores the sequence of playing.
	protected int turn; // Current player in the schedule.
	protected View view;
	
	public Scheduler() {
		this(new Board(3, 3), new Player(), new Player(), new View());
	}
	
	public Scheduler(Board board, Player P1, Player P2, View view) {
		this.board = board;
		turn = 0;
		this.view = view;
		schedule = new Player[2];
		schedule[0] = P1;
		schedule[1] = P2;
	} 
	
	/* Try to place a piece on given place.
	* Output: 
	* a boolean indicates whether the piece is placed successfully
	* If a piece is placed successfully, return true. Otherwise, return false.
	*/
	public abstract boolean takeAction();
	
	/*
	 *  Reset the scheduler in order to start a new game.
	 */
	public abstract void reset();
	/*
	 * Get the current playing player
	 */
	public Player getCurPlayer() {
		return schedule[turn];
	}
	/*
	 * Check that the coordinate input format is correct
	 * Parameters:
	 * str: the input string, expecting in row,col format
	 * Output:
	 * a boolean indicates whether it is in correct format
	 */
	protected boolean checkFormat(String str) {
		int index;
		String[] pos;
		index = str.indexOf(",");
		if (index == -1) {
			return false;
		}
		pos = str.split(",");
		if (pos.length != 2) {
			return false;
		}
		try {
			Integer.parseInt(pos[0]);
			Integer.parseInt(pos[1]);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}