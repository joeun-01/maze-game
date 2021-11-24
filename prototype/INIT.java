package algorithms_maze;

public class INIT {
	static int MAZE_BOARD_HEIGHT1 = 5;
	static int MAZE_BOARD_WIDTH1 = 5;
	static int MAZE_BOARD_HEIGHT2 = 7;
	static int MAZE_BOARD_WIDTH2 = 7;
	static int MAZE_BOARD_HEIGHT3 = 10;
	static int MAZE_BOARD_WIDTH3 = 10;
	
	static int xpos;
	static int ypos;
	
	static maze_5x5 maze1 = new maze_5x5();
	static maze_7x7 maze2 = new maze_7x7();
	static maze_10x10 maze3 = new maze_10x10();

	static int[][] mazeL1 = maze1.maze_info();
	static int[][] mazeL2 = maze2.maze_info();
	static int[][] mazeL3 = maze3.maze_info();

	
}
