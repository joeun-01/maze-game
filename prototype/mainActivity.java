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
	JButton Level1, Level2, Level3;
	
	public mainActivity() {
		
		JPanel p = new JPanel();
		p.setLayout(null);
		
		JButton Level1 = new JButton("Level 1");
		JButton Level2 = new JButton("Level 2");
		JButton Level3 = new JButton("Level 3");
		
		add(Level1);
		add(Level2);
		add(Level3);
		
		Level1.setBounds(100, 100, 100, 100);
		Level2.setBounds(100, 300, 100, 100);
		Level3.setBounds(100, 500, 100, 100);
		
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
		
		add(p);
		setSize(800, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		mainActivity start = new mainActivity();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
