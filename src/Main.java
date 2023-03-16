/* The main class of the project
 * Leon Zhang
 * 20/2/2023
 */

public class Main {

    public static void main(String[] args) {
    	boolean isValid = false;
    	int index = 0;
    	View view = new View();
    	view.print("Welcome to Leon's game. Please select what you want to play:\n1. tic-tac-toe\n2. chaos and order\n3. connect-4\n4. exit\n");
    	while(!isValid) {
    		index = view.getI();
    		if (0 < index & index < 5) {
    			isValid = true;
    		}
    		else {
    			System.out.println("Invalid input. Please try again.");
    		}
    	}
    	if (index == 1) {
    		TicTacToe game = new TicTacToe(view);
    		game.start();
    	}
    	else if (index == 2) {
    		OandC game = new OandC(view);
    		game.start();
    	}
    	else if (index == 3) {
    		Connect4 game = new Connect4(view);
    		game.start();
    	}
    	view.close();
    }
}