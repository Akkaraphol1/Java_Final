import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HW12_05 implements ActionListener {
   int choice = 0;
   private int xMin, xMax, yMin, yMax, xMin2, xMax2, yMin2, yMax2;
   private int x, y, size, xSpeed, ySpeed, xSpeed2, ySpeed2, x2, y2;
   Timer swTimer;

   JButton stopBtn = new JButton("Stop");
   JButton Red = new JButton("Red");
   JButton Green = new JButton("Green");
   JButton Blue = new JButton("Blue");
   JButton Black = new JButton("Black");
   JButton Pink = new JButton("Pink");
   JButton Yellow = new JButton("Yellow");
   Drawing draw = new Drawing();

   public HW12_05() {
      JFrame frame = new JFrame("Play Rectangle and Circle");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Red.addActionListener(this);
      Green.addActionListener(this);
      Blue.addActionListener(this);
      Black.addActionListener(this);
      Pink.addActionListener(this);
      Yellow.addActionListener(this);
      stopBtn.addActionListener(this);

      // circle
      xMin = 15; // 20
      xMax = 478; // 478
      yMin = 70;// 30
      yMax = 449; // 319
      x = 240;
      y = 160;
      xSpeed = 15;
      ySpeed = 10;

      // rectangle
      xMin2 = 15; // 20 // ซ้าย
      xMax2 = 475; // 478 // ขวา
      yMin2 = 20;// 30 // บน
      yMax2 = 400; // 319 // ล่าง
      x2 = 80;
      y2 = 100;
      xSpeed2 = 10;
      ySpeed2 = 15;
      size = 40;
      swTimer = new Timer(10, this);

      JPanel panel = new JPanel();

      panel.add(Red);
      panel.add(Green);
      panel.add(Blue);
      panel.add(Black);
      panel.add(Pink);
      panel.add(Yellow);
      panel.add(stopBtn);
      frame.add(panel, "North");
      frame.add(draw);
      frame.setBounds(500, 100, 500, 500);
      frame.setVisible(true);
      frame.setResizable(false);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == Red) {
         choice = 1;
         swTimer.start();
      

      } else if (e.getSource() == Green) {
         choice = 2;
         swTimer.start();
      } else if (e.getSource() == Blue) {
         choice = 3;
         swTimer.start();
      } else if (e.getSource() == Black) {
         choice = 4;
         swTimer.start();
      } else if (e.getSource() == Pink) {
         choice = 5;
         swTimer.start();
      } else if (e.getSource() == Yellow) {
         choice = 6;
         swTimer.start();
      } else if (e.getSource() == stopBtn) {
         choice = 7;
         swTimer.stop();
      } else {
         draw.move();
         draw.repaint();
      }

   }

   class Drawing extends JComponent {
      public void paint(Graphics g) {
         super.paint(g);
         g.setColor(Color.BLACK);
         g.drawRect(15, 20, 460, 380);

         if (choice == 1) {
            g.setColor(Color.red);
            g.fillOval((x), (y - 50), size, size);
            g.fillRect((x2), (y2), size, size);
         } else if (choice == 2) {
            g.setColor(Color.green);
            g.fillOval((x), (y - 50), size, size);
            g.fillRect((x2), (y2), size, size);
         } else if (choice == 3) {
            g.setColor(Color.blue);
            g.fillOval((x), (y - 50), size, size);
            g.fillRect((x2), (y2), size, size);
         } else if (choice == 4) {
            g.setColor(Color.black);
            g.fillOval((x), (y - 50), size, size);
            g.fillRect((x2), (y2), size, size);
         } else if (choice == 5) {
            g.setColor(Color.pink);
            g.fillOval((x), (y - 50), size, size);
            g.fillRect((x2), (y2), size, size);
         } else if (choice == 6) {
            g.setColor(Color.yellow);
            g.fillOval((x), (y - 50), size, size);
            g.fillRect((x2), (y2), size, size);
         }

      }

      public void move() {
         x = x + xSpeed;
         y = y + ySpeed;
         x2 = x2 + xSpeed2;
         y2 = y2 + ySpeed2;

         if (x < xMin) {
            x = xMin;
            xSpeed = -xSpeed;
         } else if (x + size > xMax) {
            x = xMax - size;
            xSpeed = -xSpeed;
         }
         if (y < yMin) {
            y = yMin;
            ySpeed = -ySpeed;
         } else if (y + size > yMax) {
            y = yMax - size;
            ySpeed = -ySpeed;
         }

         if (x2 < xMin2) {
            x2 = xMin2;
            xSpeed2 = -xSpeed2;
         } else if (x2 + size > xMax2) {
            x2 = xMax2 - size;
            xSpeed2 = -xSpeed2;
         }
         if (y2 < yMin2) {
            y2 = yMin2;
            ySpeed2 = -ySpeed2;
         } else if (y2 + size > yMax2) {
            y2 = yMax2 - size;
            ySpeed2 = -ySpeed2;
         }



      }
   }

   public static void main(String[] args) {
      new HW12_05();
   }

}