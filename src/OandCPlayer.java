/* 
 * The class of players in Order and Chaos game.
 * Leon Zhang
 * 20/2/2023
 */

public class OandCPlayer extends Player {
	private char side; // Side is O or C representing Order or Chaos.
	
	public OandCPlayer() {
		super();
		side = 'O';
	}
	
	public OandCPlayer(String name) {
		super(name);
		side = 'O';
	}

	public void setSide(char s) {
		side = s;
	}
	
	public char getSide() {
		return side;
	}
}
