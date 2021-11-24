package algorithms_maze;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class main2Activity extends JFrame {
	
	public main2Activity() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main2 frame = new main2();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
