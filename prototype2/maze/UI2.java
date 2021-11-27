package maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class UI2 extends JFrame {
	
	private JPanel panel1, displayPanel;
	private JButton keyUp, keyDown, keyRight, keyLeft;
	private JTextArea display;
	
	public UI2() {
				
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1.setLayout(null);
		
		// text display
		displayPanel = new JPanel();
		display = new JTextArea(20,20);
		display.setBackground(Color.lightGray);
		display.setEditable(false);
		displayPanel.add(new JScrollPane(display));
		
		keyUp = new JButton("^");
		keyDown = new JButton("v");
		keyRight = new JButton("<");
		keyLeft = new JButton(">");
		
		add(keyUp);
		add(keyDown);
		add(keyRight);
		add(keyLeft);
		
		this.buttonClick(keyUp);
		this.buttonClick(keyDown);
		this.buttonClick(keyRight);
		this.buttonClick(keyLeft);
		
		keyUp.setBounds(150, 320, 50, 50);
		keyDown.setBounds(150, 370, 50 , 50);
		keyRight.setBounds(100, 370, 50, 50);
		keyLeft.setBounds(200, 370, 50, 50);
		
		setSize(600,500);
		setLayout(new BorderLayout());
		add(panel1);
		add(displayPanel, BorderLayout.EAST);
		
		panel1.setBackground(Color.white);
		displayPanel.setBackground(Color.darkGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MAZE Level2");
		setVisible(true);
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		DrawMiro(g);
	}
	
	public void DrawMiro(Graphics g) {
		for (int y = 1; y <= INIT.MAZE_BOARD_HEIGHT2;y++) {
			for (int x = 1; x <= INIT.MAZE_BOARD_WIDTH2;x++) {
				if(INIT.mazeL2[y-1][x-1] == 1) { // wall
					g.setColor(Color.BLACK);
					g.fillRect(x*35 + 40, y*35 + 30, 33, 33);
				}
				else if(INIT.mazeL2[y-1][x-1] == 0) { // room
					g.setColor(Color.lightGray);
					g.fillRect(x*35 + 40, y*35 + 30, 33, 33);

				}
				else if(INIT.mazeL2[y-1][x-1] == 2) {
					g.setColor(Color.BLUE);
					g.fillRect(x*35 + 40, y*35 + 30, 33, 33);
					INIT.xpos = x-1;
					INIT.ypos = y-1;
				}
				else if(INIT.mazeL2[y-1][x-1] == 3) {
					g.setColor(Color.RED);
					g.fillRect(x*35+40, y*35+30, 33, 33);
				}
			}
		}
	}
	
	public void buttonClick(JButton button) {
		button.addActionListener(new ActionListener() {
			
			void Wincheck() {
				if(INIT.xpos == 6 && INIT.ypos == 6) { // x �� ��ġ 5�� 8 ��
					JOptionPane.showMessageDialog(null, "Ż�⼺��");
					System.exit(0);
				}
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String check = btn.getText();
				String X = null;
	            String Y = null;
				switch(check) {
				case "^":
					if(INIT.ypos - 1 >= 0) {
						if(INIT.mazeL2[INIT.ypos - 1][INIT.xpos] == 0 || INIT.mazeL2[INIT.ypos - 1][INIT.xpos - 1] == 3) {
							INIT.mazeL2[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL2[--INIT.ypos][INIT.xpos] = 2;
							X = String.valueOf(INIT.xpos);
		                     Y = String.valueOf(INIT.ypos);
						}
						display.append("(" + X + ", " + Y + ")\n");
					}
					break;
				case "v":
					if(INIT.ypos + 1 < INIT.MAZE_BOARD_HEIGHT2) {
						if(INIT.mazeL2[INIT.ypos + 1][INIT.xpos] ==0 || INIT.mazeL2[INIT.ypos + 1][INIT.xpos] == 3) {
							INIT.mazeL2[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL2[++INIT.ypos][INIT.xpos] = 2;
							X = String.valueOf(INIT.xpos);
		                     Y = String.valueOf(INIT.ypos);
						}
						display.append("(" + X + ", " + Y + ")\n");
					}
					break;
				case "<":
					if(INIT.xpos - 1 >= 0) {
						if(INIT.mazeL2[INIT.ypos][INIT.xpos - 1] == 0 || INIT.mazeL2[INIT.ypos][INIT.xpos - 1] == 3) {
							INIT.mazeL2[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL2[INIT.ypos][--INIT.xpos] = 2;
							X = String.valueOf(INIT.xpos);
		                     Y = String.valueOf(INIT.ypos);
						}
					}
					break;
				case ">":
					if(INIT.xpos + 1 < INIT.MAZE_BOARD_WIDTH2) {
						if(INIT.mazeL2[INIT.ypos][INIT.xpos + 1] == 0 || INIT.mazeL2[INIT.ypos][INIT.xpos + 1] == 3) {
							INIT.mazeL2[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL2[INIT.ypos][++INIT.xpos] = 2;
							X = String.valueOf(INIT.xpos);
		                     Y = String.valueOf(INIT.ypos);
						}
						display.append("(" + X + ", " + Y + ")\n");
					}
					break;
				}
				repaint();
				Wincheck();
			}
			
		});
	}
}
