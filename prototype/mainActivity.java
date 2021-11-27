package algorithms_maze;

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
		
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\Gihyun\\eclipse-workspace\\algorithms_maze\\src\\maze.png"));
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
			public void actionPerformed(ActionEvent e) {
				JButton btn1 = (JButton) e.getSource();
				main2Activity goMaze = new main2Activity(btn1);
			}
			
		});
		
		Level2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn2 = (JButton) e.getSource();
				main2Activity goMaze = new main2Activity(btn2);
			}
		});
		
		Level3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn3 = (JButton) e.getSource();
				main2Activity goMaze = new main2Activity(btn3);
			}
			
		});
		
		add(p, BorderLayout.CENTER);
		setTitle("MAZE");
		setSize(600, 500);
		p.setBackground(Color.white);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		mainActivity start = new mainActivity();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
