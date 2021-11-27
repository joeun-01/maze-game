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

public class UI3 extends JFrame {
	
	private JPanel panel1, displayPanel;
	private myButton keyUp, keyDown, keyRight, keyLeft, answer;
	private JTextArea display;
	
	public UI3() {
				
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1.setLayout(null);
				
		// text display
		displayPanel = new JPanel();
		display = new JTextArea(20,20);
		display.setBackground(Color.lightGray);
		display.setEditable(false);
		displayPanel.add(new JScrollPane(display));
		
		keyUp = new myButton("^");
		keyDown = new myButton("v");
		keyRight = new myButton("<");
		keyLeft = new myButton(">");
		answer = new myButton("ANSWER");
		
		add(keyUp);
		add(keyDown);
		add(keyRight);
		add(keyLeft);
		add(answer);
		
		this.buttonClick(keyUp);
		this.buttonClick(keyDown);
		this.buttonClick(keyRight);
		this.buttonClick(keyLeft);
		this.answerClick(answer);
		
		keyUp.setBounds(150, 320, 50, 50);
		keyDown.setBounds(150, 370, 50 , 50);
		keyRight.setBounds(100, 370, 50, 50);
		keyLeft.setBounds(200, 370, 50, 50);
		answer.setBounds(500, 370, 50, 50);
		
		setSize(600,500);
		setLayout(new BorderLayout());
		add(panel1);
		add(displayPanel, BorderLayout.EAST);
		
		panel1.setBackground(Color.white);
		displayPanel.setBackground(Color.darkGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MAZE Level1");
		setVisible(true);
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		DrawMiro(g);
	}
	
	public void DrawMiro(Graphics g) {
		for (int y = 1; y <= INIT.MAZE_BOARD_HEIGHT3;y++) {
			for (int x = 1; x <= INIT.MAZE_BOARD_WIDTH3;x++) {
				if(INIT.mazeL3[y-1][x-1] == 1) { // wall
					g.setColor(Color.BLACK);
					g.fillRect(x*30+15, y*30+5, 29, 29);
				}
				else if(INIT.mazeL3[y-1][x-1] == 0) { // room
					g.setColor(Color.lightGray);
					g.fillRect(x*30+15, y*30+5, 29, 29);
				}
				else if(INIT.mazeL3[y-1][x-1] == 2) {
					g.setColor(Color.BLUE);
					g.fillRect(x*30+15, y*30+5, 29, 29);
					INIT.xpos = x-1;
					INIT.ypos = y-1;
				}
				else if(INIT.mazeL3[y-1][x-1] == 3) {
					g.setColor(Color.RED);
					g.fillRect(x*30+15, y*30+5, 29, 29);
				}
			}
		}
	}
	
	public void buttonClick(JButton button) {
		button.addActionListener(new ActionListener() {
			
			void Wincheck() {
				if(INIT.xpos == 9 && INIT.ypos == 9) { // x 의 위치 5행 8 열
					JOptionPane.showMessageDialog(null, "탈출성공");
					System.exit(0);
				}
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				String check = btn.getText();
				switch(check) {
				case "^":
					if(INIT.ypos - 1 >= 0) {
						if(INIT.mazeL3[INIT.ypos - 1][INIT.xpos] == 0 || INIT.mazeL3[INIT.ypos - 1][INIT.xpos - 1] == 3) {
							INIT.mazeL3[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL3[--INIT.ypos][INIT.xpos] = 2;
						}
					}
					break;
				case "v":
					if(INIT.ypos + 1 < INIT.MAZE_BOARD_HEIGHT3) {
						if(INIT.mazeL3[INIT.ypos + 1][INIT.xpos] ==0 || INIT.mazeL3[INIT.ypos + 1][INIT.xpos] == 3) {
							INIT.mazeL3[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL3[++INIT.ypos][INIT.xpos] = 2;
						}
					}
					break;
				case "<":
					if(INIT.xpos - 1 >= 0) {
						if(INIT.mazeL3[INIT.ypos][INIT.xpos - 1] == 0 || INIT.mazeL3[INIT.ypos][INIT.xpos - 1] == 3) {
							INIT.mazeL3[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL3[INIT.ypos][--INIT.xpos] = 2;
						}
					}
					break;
				case ">":
					if(INIT.xpos + 1 < INIT.MAZE_BOARD_WIDTH3) {
						if(INIT.mazeL3[INIT.ypos][INIT.xpos + 1] == 0 || INIT.mazeL3[INIT.ypos][INIT.xpos + 1] == 3) {
							INIT.mazeL3[INIT.ypos][INIT.xpos] = 0;
							INIT.mazeL3[INIT.ypos][++INIT.xpos] = 2;
						}
					}
					break;
				}
				repaint();
				Wincheck();
			}
			
		});
	}
	
	public void answerClick(JButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
