package maze;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class UIactivity extends JFrame {
	
	public UIactivity(JButton button)  {
		String check = button.getText();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					switch(check) {
					case "Level 1":
						UI1 frame1 = new UI1();
						frame1.setVisible(true);
						break;
					case "Level 2":
						UI2 frame2 = new UI2();
						frame2.setVisible(true);
						break;
					case "Level 3":
						UI3 frame3 = new UI3();
						frame3.setVisible(true);
						break;
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
