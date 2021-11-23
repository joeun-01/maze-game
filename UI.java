package maze;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UI extends JFrame{
	
	Container con;
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public UI() {
		JFrame newFrame = new JFrame();
		newFrame.setTitle("MAZE");
		newFrame.setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 280, 408);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0,0));
		setContentPane(panel);
		
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
					if(INIT.xpos + 1 < INIT.MAZE_BOARD_WIDTH1) {
						if(INIT.maze11[INIT.ypos][INIT.xpos + 1] ==0 || INIT.maze11[INIT.ypos][INIT.xpos + 1] == 3) {
							INIT.maze11[INIT.ypos][INIT.xpos] = 0;
							INIT.maze11[INIT.ypos][++INIT.xpos] = 2;
						}
					}
					break;
				case KeyEvent.VK_LEFT:
					if(INIT.xpos - 1 >= 0) {
						if(INIT.maze11[INIT.ypos][INIT.xpos - 1] == 0 || INIT.maze11[INIT.ypos][INIT.xpos - 1] == 3) {
							INIT.maze11[INIT.ypos][INIT.xpos] = 0;
							INIT.maze11[INIT.ypos][--INIT.xpos] = 2;
						}
					}
					break;
				case KeyEvent.VK_UP:
					if(INIT.ypos - 1 >= 0) {
						if(INIT.maze11[INIT.ypos - 1][INIT.xpos] == 0 || INIT.maze11[INIT.ypos - 1][INIT.xpos - 1] == 3) {
							INIT.maze11[INIT.ypos][INIT.xpos] = 0;
							INIT.maze11[--INIT.ypos][INIT.xpos] = 2;
						}
					}
					break;
				case KeyEvent.VK_DOWN:
					if(INIT.ypos + 1 < INIT.MAZE_BOARD_HEIGHT1) {
						if(INIT.maze11[INIT.ypos + 1][INIT.xpos] ==0 || INIT.maze11[INIT.ypos + 1][INIT.xpos] == 3) {
							INIT.maze11[INIT.ypos][INIT.xpos] = 0;
							INIT.maze11[++INIT.ypos][INIT.xpos] = 2;
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
		
		setFocusable(true);
		panel.addKeyListener(new key());
		newFrame.getContentPane().add(panel, BorderLayout.CENTER);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		DrawMiro(g);
	}
	
	public void DrawMiro(Graphics g) {
		for (int y = 1; y <= INIT.MAZE_BOARD_HEIGHT1;y++) {
			for (int x = 1; x <= INIT.MAZE_BOARD_WIDTH1;x++) {
				if(INIT.maze11[y-1][x-1] == 1) { // wall
					g.setColor(Color.BLACK);
					g.fillRect(x*30, y*30, 29, 29);
				}
				else if(INIT.maze11[y-1][x-1] == 0) { // room
					g.setColor(Color.WHITE);
					g.fillRect(x*30, y*30, 29, 29);

				}
				else if(INIT.maze11[y-1][x-1] == 2) {
					g.setColor(Color.BLUE);
					g.fillRect(x*30, y*30, 29, 29);
					INIT.xpos = x-1;
					INIT.ypos = y-1;
				}
				else if(INIT.maze11[y-1][x-1] == 3) {
					g.setColor(Color.RED);
					g.drawString("*", x*30+8, y*30+17);
				}
			}
		}
	}

}
