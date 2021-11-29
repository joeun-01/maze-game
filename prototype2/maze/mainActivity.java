package maze;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class mainActivity extends JFrame{
	myButton Level1, Level2, Level3;
	
	public mainActivity() {
		
		JPanel p = new JPanel();
		p.setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\jjy02\\eclipse-workspace2\\Algorithm\\src\\maze.png"));
		p.add(label);
		
		Level1 = new myButton("Level 1");
		Level2 = new myButton("Level 2");
		Level3 = new myButton("Level 3");
		
		p.add(Level1);
		p.add(Level2);
		p.add(Level3);
		
		label.setBounds(50, 0, 500, 300);
		Level1.setBounds(75, 350, 100, 50);
		Level2.setBounds(225, 350, 100, 50);
		Level3.setBounds(375, 350, 100, 50);
		
		Level1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  // show level 1 maze
				JButton btn1 = (JButton) e.getSource();
				UIactivity goMaze = new UIactivity(btn1);
			}
			
		});
		
		Level2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  // show level 2 maze
				JButton btn2 = (JButton) e.getSource();
				UIactivity goMaze = new UIactivity(btn2);
			}
		});
		
		Level3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  // show level 3 maze
				JButton btn3 = (JButton) e.getSource();
				UIactivity goMaze = new UIactivity(btn3);
			}
			
		});
		
		add(p, BorderLayout.CENTER);
		setTitle("MAZE");
		setSize(600, 500);
		p.setBackground(Color.white);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

	}
	
	public static void main(String[] args) {
		mainActivity start = new mainActivity();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
