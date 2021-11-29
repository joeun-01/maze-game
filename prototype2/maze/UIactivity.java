package maze;

import javax.swing.*;
import java.awt.*;

public class UIactivity extends JFrame {
	
	public UIactivity(JButton button)  {
		String check = button.getText();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// choose level 1 ~ 3 
				try {
					switch(check) {
					case "Level 1":  // level 1
						UI1 frame1 = new UI1();
						frame1.setVisible(true);
						break;
					case "Level 2":  // level 2
						UI2 frame2 = new UI2();
						frame2.setVisible(true);
						break;
					case "Level 3":  // level 3
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
