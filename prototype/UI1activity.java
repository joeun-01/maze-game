package maze;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UIactivity1 extends JFrame {
	public UIactivity1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI1 frame = new UI1();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
