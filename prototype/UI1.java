package maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UI1 extends JFrame {
	
	private JPanel panel1, panel2, panel3;
	
	public UI1() {
		JFrame newFrame = new JFrame();
		newFrame.setTitle("MAZE");
		newFrame.setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 280, 408);
		
		panel1 = new JPanel();
		
		//panel2 = new JPanel();
		//panel3 = new JPanel();
		
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1.setLayout(new BorderLayout(0,0));
		setContentPane(panel1);
		
		panel1.addKeyListener(new KeyListener() {

			void Wincheck() {
				if(INIT.xpos == 5 && INIT.ypos == 8) { // x ÀÇ À§Ä¡ 5Çà 8 ¿­
					JOptionPane.showMessageDialog(null, "Å»Ãâ¼º°ø");
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
						if(INIT.mazeL1[INIT.ypos][INIT.xpos + 1] == 0 || INIT.mazeL1[INIT.ypos][INIT.xpos + 1] == 3) {
							INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL1[INIT.ypos][++INIT.xpos] = 2;
						}
					}
					break;
				case KeyEvent.VK_LEFT:
					if(INIT.xpos - 1 >= 0) {
						if(INIT.mazeL1[INIT.ypos][INIT.xpos - 1] == 0 || INIT.mazeL1[INIT.ypos][INIT.xpos - 1] == 3) {
							INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL1[INIT.ypos][--INIT.xpos] = 2;
						}
					}
					break;
				case KeyEvent.VK_UP:
					if(INIT.ypos - 1 >= 0) {
						if(INIT.mazeL1[INIT.ypos - 1][INIT.xpos] == 0 || INIT.mazeL1[INIT.ypos - 1][INIT.xpos - 1] == 3) {
							INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL1[--INIT.ypos][INIT.xpos] = 2;
						}
					}
					break;
				case KeyEvent.VK_DOWN:
					if(INIT.ypos + 1 < INIT.MAZE_BOARD_HEIGHT1) {
						if(INIT.mazeL1[INIT.ypos + 1][INIT.xpos] ==0 || INIT.mazeL1[INIT.ypos + 1][INIT.xpos] == 3) {
							INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL1[++INIT.ypos][INIT.xpos] = 2;
						}
					}
					break;
				}
				repaint();
				Wincheck();
			}

			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
		
		newFrame.getContentPane().add(panel1, BorderLayout.CENTER);
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		DrawMiro(g);
	}
	
	public void DrawMiro(Graphics g) {
		for (int y = 1; y <= INIT.MAZE_BOARD_HEIGHT1;y++) {
			for (int x = 1; x <= INIT.MAZE_BOARD_WIDTH1;x++) {
				if(INIT.mazeL1[y-1][x-1] == 1) { // wall
					g.setColor(Color.BLACK);
					g.fillRect(x*30, y*30, 29, 29);
				}
				else if(INIT.mazeL1[y-1][x-1] == 0) { // room
					g.setColor(Color.WHITE);
					g.fillRect(x*30, y*30, 29, 29);

				}
				else if(INIT.mazeL1[y-1][x-1] == 2) {
					g.setColor(Color.BLUE);
					g.fillRect(x*30, y*30, 29, 29);
					INIT.xpos = x-1;
					INIT.ypos = y-1;
				}
				else if(INIT.mazeL1[y-1][x-1] == 3) {
					g.setColor(Color.RED);
					g.drawString("*", x*30+8, y*30+17);
				}
			}
		}
	}
}
