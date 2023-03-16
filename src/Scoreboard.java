/* 
 * A score board that record the number of wins and ties for each of the two players.
 * Leon Zhang
 * 20/2/2023
 */
public class Scoreboard {
	Player P1, P2;
	int[] scores; // A 3 elements array that holds the score of P1, P2 and the number of ties in that order.
	
	public Scoreboard() {
		P1 = new Player("Player1");
		P2 = new Player("Player2");
		scores = new int[3];
		for (int i = 0; i < 3; ++i) {
			scores[i] = 0;
		}
	}
	
	public Scoreboard(Player P1, Player P2) {
		this.P1 = P1;
		this.P2 = P2;
		scores = new int[3];
		for (int i = 0; i < 3; ++i) {
			scores[i] = 0;
		}
	}
	
	public void reset() {
		for (int i = 0; i < 3; ++i) {
			scores[i] = 0;
		}
	}
	/*
	 * Give a player point.
	 * Parameters:
	 * the winner. If there is a tie, the input will be null.
	 */
	public void score(Player P) {
		if (P == null) {
			++scores[2];
		}
		else if (P == P1) {
			++scores[0];
		}
		else if (P == P2) {
			++scores[1];
		}
	} 
	
	public String toString() {
		String s = P1.getName() + ": " + scores[0] +"\n" + P2.getName() + ": " + scores[1] + "\nStalemate: " + scores[2];
		return s;
	}
}