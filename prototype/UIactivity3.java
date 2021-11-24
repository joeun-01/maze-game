package maze;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class UIactivity3 extends JFrame {
	
	public UIactivity3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI3 frame = new UI3();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}

