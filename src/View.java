/* 
 * The view of all classes, for input from and output to the console..
 * Leon Zhang
 * 20/2/2023
 */

import java.util.Scanner;

public class View {
	Scanner scanner;
	
	public View() {
		scanner = new Scanner(System.in);
	}
	
	public void print(String s) {
		System.out.println(s);
	}
	/*
	 * Get a string.
	 */
	public String getS() {
		String s = scanner.next();
		return s;
	}
	/*
	 * Get an integer
	 */
	public int getI() {
		boolean isValid = false;
		int i = 0;
		while(!isValid) {
			if (scanner.hasNextInt()) {
				i = scanner.nextInt();
				isValid = true;
			}
			else {
				System.out.println("Invalid input. Please try again.");
				scanner.next();
			}
		}
		return i;
	}
	
	public void close() {
		scanner.close();
	}
}
