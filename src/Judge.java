/* 
 * class for determining winning conditions
 * Leon Zhang
 * 20/2/2023
 */

/*
 * The class should be implemented with the game board.
 */
public class Judge{
	private Board board;
	private String Xwin;	// the winning series of X
	private String Owin;	// the winning series of O
	private int length;	// the number of pieces in a row needed to win
	
	public Judge() {
		this(null);
	}
	public Judge(Board board) {
		this.board = board;
		length = 0;
		Xwin = "";
		Owin = "";
	}
	/*
	 * Check whether the game is over.
	 * Output:
	 * a char that indicates the winner 
	 * If there is a winner, return the winning piece. If it is a tie, return 'T'. Otherwise, return 'N'.
	 */
	public char checkStatus() {
		char winner;
		int row = board.row;
		int col = board.col;
		for (int i = 0; i < row-length+1; ++i) {
			for (int j = 0; j < col-length+1; ++j) {
				winner = findWinner(getDiag(length, i, j));
				if (winner != ' ') {
					return winner;
				}
				winner = findWinner(getOpDiag(length, i, j+length-1));
				if (winner != ' ') {
					return winner;
				}
			}
		}
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col-length+1; ++j) {
				winner = findWinner(getHoriz(length, i, j));
				if (winner != ' ') {
					return winner;
				}
			}
		}
		for (int i = 0; i < row-length+1; ++i) {
			for (int j = 0; j < col; ++j) {
				winner = findWinner(getVert(length, i, j));
				if (winner != ' ') {
					return winner;
				}
			}
		}
		if (board.space <= 0) {
			return 'T';
		}
		return 'N';
	}
	/*
	 * Set the winning conditions for X and O.
	 * Parameters:
	 * len: the number of pieces in the winning series
	 * Output:
	 * a boolean that indicates whether the rule is set successfully.
	 */
	public boolean setRule(int len) {
		if (len > board.col | len > board.row) {
			System.out.println("It cannot longer than the size of the board.");
			return false;
		}
		Owin = "";
		Xwin = "";
		length = len;
		for (int i = 0; i < len; ++i) {
			Owin = Owin + 'O';
			Xwin = Xwin + 'X';
		}
		return true;
	}
	
	/* Get a diagonal series of pieces on the board with the top-left location.
	 * Parameters:
	 * (x, y) is the top-left point of the returned series.
	 * The len is the length of it.
	 * Output:
	 * a string of required series
	 */
	public String getDiag(int len, int x, int y) {
		String s = "";
		if (x >= 0 & y >= 0 & x+len-1 < board.row & y+len-1 < board.col) {
			for (int i = 0; i < len; ++i) {
				s = s + board.getPos(x+i, y+i);
			}
		}
		return s;
	}
	
	/* Get a diagonal series of pieces on the board with the top-right location.
	 * Parameters:
	 * (x, y) is the top-right point of the returned series.
	 * The len is the length of it.
	 * Output:
	 * a string of required series
	 */
	public String getOpDiag(int len, int x, int y) {
		String s = "";
		if (x >= 0 & y-len+1 >= 0 & x+len-1 < board.row & y < board.col) {
			for (int i = 0; i < len; ++i) {
				s = s + board.getPos(x+i, y-i);
			}
		}
		return s;
	}
	
	/* Get a horizontal series of pieces on the board with the left-most location.
	 * Parameters:
	 * (x, y) is the left-most point of the returned series.
	 * The len is the length of it.
	 * Output:
	 * a string of required series
	 */
	public String getHoriz(int len, int x, int y) {
		String s = "";
		if (x >= 0 & y >= 0 & x < board.row & y+len-1 < board.col) {
			for (int i = 0; i < len; ++i) {
				s = s + board.getPos(x, y+i);
			}
		}
		return s;
	}
	
	/* Get a vertical series of pieces on the board with the top location.
	 * Parameters:
	 * (x, y) is the top point of the returned series.
	 * The len is the length of it.
	 * Output:
	 * a string of required series
	 */
	public String getVert(int len, int x, int y) {
		String s = "";
		if (x >= 0 & y >= 0 & x+len-1 < board.row & y < board.col) {
			for (int i = 0; i < len; ++i) {
				s = s + board.getPos(x+i, y);
			}
		}
		return s;
	}	
	
	/*
	 * Match a string with the winning series.
	 * Parameters:
	 * line: series to be matched
	 * Output:
	 * a char that indicates the winner
	 * If line matches Owin, return O. If line matches Xwin, return X. Otherwise, return a space.
	 */
	private char findWinner(String line) {
		if (line.equals(Owin)) {
			return 'O';
		}
		else if (line.equals(Xwin)) {
			return 'X';
		}
		return ' ';
	}
	/*
	 * Get a string that shows the game rule.
	 * Output:
	 * a string
	 */
	public String toString() {
		String s = "length: " + length + "\nXwin: " + Xwin + "\nOwin: " + Owin + "\n";
		return s;
	}
}