package maze;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		int level;
		
		Scanner keyboard = new Scanner(System.in);
		
		level = keyboard.nextInt();
				
		if (level == 1) {
			maze_5x5 five = new maze_5x5();
			five.maze_info();
		}
		else if(level == 2) {
			maze_7x7 seven = new maze_7x7();
			seven.maze_info();
		}
		else if(level == 3) {
			maze_10x10 ten = new maze_10x10();
			ten.maze_info();
		}
		
	}
}