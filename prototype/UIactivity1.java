package maze;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UIactivity1 extends JFrame {
	public UIactivity1(JButton button) {
		String check = button.getText();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					switch(check) {
						case "Level 1" :
							UI1 frame1 = new UI1();
							frame1.setVisible(true);
							break;
						case "Level 2" :
							UI1 frame2 = new UI1();
							frame2.setVisible(true);
							break;
						case "Level 3" :
							UI1 frame3 = new UI1();
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
