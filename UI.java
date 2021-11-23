import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Main extends JFrame{
	Container con;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public Main() {
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
		
		
		setFocusable(true);
		panel.addKeyListener(new key());
		newFrame.getContentPane().add(panel, BorderLayout.CENTER);
		
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
					g.setColor(Color.WHITE);
					g.fillRect(x*30, y*30, 29, 29);

				}
				else if(INIT.maze[y-1][x-1] == 'e') {
					g.setColor(Color.BLUE);
					g.fillRect(x*30, y*30, 29, 29);
					INIT.xpos = x-1;
					INIT.ypos = y-1;
				}
				else if(INIT.maze[y-1][x-1] == 'x') {
					g.setColor(Color.RED);
					g.drawString("*", x*30+8, y*30+17);
				}
			}
		}
	}

}
