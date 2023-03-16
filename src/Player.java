/* 
 * The general class of players.
 * Leon Zhang
 * 20/2/2023
 */

public class Player {
	private String name;
	private char piece;
	
	public Player() {
		this("Player");
	}
	
	public Player(String name) {
		this.name = name;
		piece = 'X';
	}
	/*
	 * Get the name of the player.
	 * Output:
	 * a string of the name
	 */
	public String getName() {
		return name;
	}
	/*
	 * Set the name of the player.
	 */
	public void rename(String name) {
		this.name = name;
	}
	/*
	 * Set the piece the player takes.
	 */
	public void setPiece(char p) {
		piece = p;
	}
	
	public char getPiece() {
		return piece;
	}
}