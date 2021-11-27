package maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class UI1 extends JFrame {
   
   private JPanel panel1, displayPanel;
   private myButton keyUp, keyDown, keyRight, keyLeft;
   private JTextArea display;
   private ImageIcon runner, door;
   
   public UI1() {
      
      panel1 = new JPanel();
      panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
      panel1.setLayout(null);
      
      // text display
      displayPanel = new JPanel();
      display = new JTextArea(20,20);
      display.setBackground(Color.lightGray);
      display.setEditable(false);
      displayPanel.add(new JScrollPane(display));
      
      keyUp = new myButton("^");
      keyDown = new myButton("v");
      keyRight = new myButton("<");
      keyLeft = new myButton(">");
      
      add(keyUp);
      add(keyDown);
      add(keyRight);
      add(keyLeft);
      
      this.buttonClick(keyUp);
      this.buttonClick(keyDown);
      this.buttonClick(keyRight);
      this.buttonClick(keyLeft);
      
      keyUp.setBounds(150, 320, 50, 50);
      keyDown.setBounds(150, 370, 50 , 50);
      keyRight.setBounds(100, 370, 50, 50);
      keyLeft.setBounds(200, 370, 50, 50);
      
      setSize(600,500);
      setLayout(new BorderLayout());
      add(panel1);
      add(displayPanel, BorderLayout.EAST);
      
      panel1.setBackground(Color.white);
      displayPanel.setBackground(Color.darkGray);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("MAZE Level1");
      setVisible(true);
      setFocusable(true);
   }
   
   public void paint(Graphics g) {
      super.paint(g);
      DrawMiro(g);
   }
   
   public void DrawMiro(Graphics g) {
      runner = new ImageIcon("C:\\Users\\Gihyun\\eclipse-workspace\\algorithms_maze\\src\\running.png");
      Image runImg = runner.getImage();
      
      for (int y = 1; y <= INIT.MAZE_BOARD_HEIGHT1;y++) {
         for (int x = 1; x <= INIT.MAZE_BOARD_WIDTH1;x++) {
            if(INIT.mazeL1[y-1][x-1] == 1) { // wall
               g.setColor(Color.BLACK);
               g.fillRect(x*50 + 25, y*50 + 20, 45, 45);
            }
            else if(INIT.mazeL1[y-1][x-1] == 0) { // room
               g.setColor(Color.lightGray);
               //g.drawImage(runImg,20,20,this);
               g.fillRect(x*50+25, y*50 + 20, 45, 45);
               

            }
            else if(INIT.mazeL1[y-1][x-1] == 2) {
               g.setColor(Color.blue);
               g.fillRect(x*50+25, y*50 + 20, 45, 45);
               INIT.xpos = x-1;
               INIT.ypos = y-1;
            }
            else if(INIT.mazeL1[y-1][x-1] == 3) {
               g.setColor(Color.RED);
               g.fillRect(x*50+25, y*50+20, 45, 45);
            }
         }
      }
   }
   
   public void buttonClick(JButton button) {
      button.addActionListener(new ActionListener() {
         
         void Wincheck() {
            if(INIT.xpos == 4 && INIT.ypos == 4) { // x 의 위치 5행 8 열
               JOptionPane.showMessageDialog(null, "탈출성공");
               
            }
         }
         
         @Override
         public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            String check = btn.getText();
            String X = null;
            String Y = null;
            switch(check) {
            case "^":
               if(INIT.ypos - 1 >= 0) {
                  if(INIT.mazeL1[INIT.ypos - 1][INIT.xpos] == 0 || INIT.mazeL1[INIT.ypos - 1][INIT.xpos - 1] == 3) {
                     INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
                     INIT.mazeL1[--INIT.ypos][INIT.xpos] = 2;
                     X = String.valueOf(INIT.xpos);
                     Y = String.valueOf(INIT.ypos);
                  }
               }
               display.append("(" + X + ", " + Y + ")\n");
               break;
            case "v":
               if(INIT.ypos + 1 < INIT.MAZE_BOARD_HEIGHT1) {
                  if(INIT.mazeL1[INIT.ypos + 1][INIT.xpos] ==0 || INIT.mazeL1[INIT.ypos + 1][INIT.xpos] == 3) {
                     INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
                     INIT.mazeL1[++INIT.ypos][INIT.xpos] = 2;
                     X = String.valueOf(INIT.xpos);
                     Y = String.valueOf(INIT.ypos);
                  }
               }
               display.append("(" + X + ", " + Y + ")\n");
               break;
            case "<":
               if(INIT.xpos - 1 >= 0) {
                  if(INIT.mazeL1[INIT.ypos][INIT.xpos - 1] == 0 || INIT.mazeL1[INIT.ypos][INIT.xpos - 1] == 3) {
                     INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
                     INIT.mazeL1[INIT.ypos][--INIT.xpos] = 2;
                     X = String.valueOf(INIT.xpos);
                     Y = String.valueOf(INIT.ypos);
                  }
               }
               display.append("(" + X + ", " + Y + ")\n");
               break;
            case ">":
               if(INIT.xpos + 1 < INIT.MAZE_BOARD_WIDTH1) {
                  if(INIT.mazeL1[INIT.ypos][INIT.xpos + 1] == 0 || INIT.mazeL1[INIT.ypos][INIT.xpos + 1] == 3) {
                     INIT.mazeL1[INIT.ypos][INIT.xpos] = 0;
                     INIT.mazeL1[INIT.ypos][++INIT.xpos] = 2;
                     X = String.valueOf(INIT.xpos);
                     Y = String.valueOf(INIT.ypos);
                  }
               }
               display.append("(" + X + ", " + Y + ")\n");
               break;
            }
            
            repaint();
            Wincheck();
            //display.append();
         }
         
      });
   }
}