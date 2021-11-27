package maze;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class myButton extends JButton{
	public myButton() {
		super();
		decorate();
	}
	public myButton(String text) {
		super(text);
		decorate();
	}
	public myButton(Action action) {
		super(action);
		decorate();
	}
	public myButton(Icon icon) {
		super(icon);
		decorate();
	}
	public myButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}
	
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Color c = new Color(51, 51, 51); // background
		Color o = new Color(255, 255, 255); // font color
		int width = getWidth();
		int height = getHeight();
		
		Graphics2D graphics = (Graphics2D) g;
		
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) { // 버튼작동 준비상태
			graphics.setColor(getBackground().darker());
		}
		else if (getModel().isRollover()) { // 마우스 포인터가 버튼 
			graphics.setColor(getBackground().brighter());
		}
		else {
			graphics.setColor(c);
		}
		
		graphics.fillRoundRect(0,0,width,height,10,10);
		
		FontMetrics font = graphics.getFontMetrics();
		Rectangle strBound = font.getStringBounds(this.getText(), graphics).getBounds();
		
		int textX = (width - strBound.width) / 2;
		int textY = (height - strBound.height) / 2 + font.getAscent();
		
		graphics.setColor(o);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		
		super.paintComponent(g);
	}
}
