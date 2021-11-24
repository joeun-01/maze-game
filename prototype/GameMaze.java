/*
 * package algorithms_maze;
 

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameMaze extends JFrame {
	public GameMaze() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0,0));
		setContentPane(panel);
		
		key listener = new key();
		addKeyListener(listener);
		
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		DrawMiro(g);
	}
	
	public void DrawMiro(Graphics g) {
		for (int y = 1; y <= INIT.MAZE_BOARD_HEIGHT;y++) {
			for (int x = 1; x <= INIT.MAZE_BOARD_WIDTH;x++) {
				if(INIT.maze[y-1][x-1] == '1') { // wall
					g.setColor(Color.BLACK);
					g.fillRect(x*30, y*30, 29, 29);
				}
				else if(INIT.maze[y-1][x-1] == '0') { // room
					g.fillRect(x*30, y*30, 29, 29);

				}
				else if(INIT.maze[y-1][x-1] == 'e') {
					g.fillRect(x*30, y*30, 29, 29);

				}
				else if(INIT.maze[y-1][x-1] == 'x') {
					
				}
			}
		}
	}
}

class key implements KeyListener {
	//private Graphics g;
	
	void Wincheck() {
		if(INIT.xpos == 5 && INIT.ypos == 8) { // x 의 위치 5행 8 열
			JOptionPane.showMessageDialog(null, "탈출성공");
			System.exit(0);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) 
		{
		case KeyEvent.VK_RIGHT:
			if(INIT.xpos + 1 < INIT.MAZE_BOARD_WIDTH) {
				if(INIT.maze[INIT.ypos][INIT.xpos + 1] =='0' || INIT.maze[INIT.ypos][INIT.xpos + 1] == 'x') {
					INIT.maze[INIT.ypos][INIT.xpos] = '0';
					INIT.maze[INIT.ypos][++INIT.xpos] = 'e';
				}
			}
			break;
		case KeyEvent.VK_LEFT:
			if(INIT.xpos - 1 >= 0) {
				if(INIT.maze[INIT.ypos][INIT.xpos - 1] == '0' || INIT.maze[INIT.ypos][INIT.xpos - 1] == 'x') {
					INIT.maze[INIT.ypos][INIT.xpos] = '0';
					INIT.maze[INIT.ypos][--INIT.xpos] = 'e';
				}
			}
			break;
		case KeyEvent.VK_UP:
			if(INIT.ypos - 1 >= 0) {
				if(INIT.maze[INIT.ypos - 1][INIT.xpos] == '0' || INIT.maze[INIT.ypos - 1][INIT.xpos - 1] == 'x') {
					INIT.maze[INIT.ypos][INIT.xpos] = '0';
					INIT.maze[--INIT.ypos][INIT.xpos] = 'e';
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			if(INIT.ypos + 1 < INIT.MAZE_BOARD_HEIGHT) {
				if(INIT.maze[INIT.ypos + 1][INIT.xpos] =='0' || INIT.maze[INIT.ypos + 1][INIT.xpos] == 'x') {
					INIT.maze[INIT.ypos][INIT.xpos] = '0';
					INIT.maze[++INIT.ypos][INIT.xpos] = 'e';
				}
			}
			break;
		}
		//repaint();
		Wincheck();
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
*/