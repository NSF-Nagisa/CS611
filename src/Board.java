/* 
 * The class is the board in board games.
 * Leon Zhang
 * 20/2/2023
 */

/*
 * The class should be implemented with the length and width of a board.
 */
public class Board {
	private char[][] board;	// The information for each position.
	public int row;
	public int col;
	public int space; // The empty space remaining.
	
	public Board() {
		this(3, 3);
	}
	
	public Board(int row, int col) {
		this.row = row;
		this.col = col;
		board = new char[row][col];
		space = row * col;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				board[i][j] = ' ';
			}
		}
	}
	
	/*
	 * Try to place a piece in the given positon.
	 * Parameters:
	 * r: row coordinate
	 * c: column coordinate
	 * p: the piece to be placed
	 * Output:
	 * A boolean indicates whether the piece is placed.
	 */
	public boolean placePiece(int r, int c, char p) {
		if (r >= row | c >= col | r < 0 | c < 0) {
			System.out.println("The position is out of bounds");
			return false;
		}
		else if (this.getPos(r, c) == ' ') {
			board[r][c] = p;
			--space;
			return true;
		}
		System.out.print("The position is occupied.");
		return false;
	}
	/*
	 * Get the current board.
	 * Output:
	 * A string of the current board.
	 */
	public String getBoard() {
		String line = "";
		for (int i = 0; i < row; ++i) {
			line = line + "\n+";
			for (int j = 0; j < col; ++j) {
				line = line + "---+";
			}
			
			line = line + "\n|";
			for (int j = 0; j < col; ++j) {
				line = line + " " + board[i][j] + " |";
			}
		}
		line = line + "\n+";
		for (int j = 0; j < col; ++j) {
			line = line + "---+";
		}
		line = line + "\n";
		return line;
	}
	/*
	 * Get a sample board with coordinates in the corresponding position.
	 * Output:
	 * A string of the sample board.
	 */
	public String getSample() {
		String line = "";
		for (int i = 0; i < row; ++i) {
			line = line + "\n+";
			for (int j = 0; j < col; ++j) {
				line = line + "---+";
			}
			
			line = line + "\n|";
			for (int j = 0; j < col; ++j) {
				line = line + i + ',' + j +"|";
			}
		}
		line = line + "\n+";
		for (int j = 0; j < col; ++j) {
			line = line + "---+";
		}
		line = line + "\n";
		return line;
	}
	/*
	 * Get the piece in the given position.
	 * Parameter:
	 * row: row coordinate
	 * col: column coordinate
	 * Output:
	 * A char that is the piece in the given position.
	 */
	public char getPos(int row, int col) {
		return board[row][col];
	}
	
	/*
	 * Clear the board.
	 */
	public void clear() {
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				board[i][j] = ' ';
			}
		}
		space = row * col;
	}
}