
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BallShared implements ActionListener {
   int choice = 0;
   private int xMin, xMax, yMin, yMax, xMin2, xMax2, yMin2, yMax2;
   private int x, y, size, xSpeed, ySpeed, xSpeed2, ySpeed2, x2, y2;
   Timer swTimer;
   int c  ;
   //private JPanel panel, gp;

   JLabel Txt = new JLabel("Add Ball");
   JTextField a   = new JTextField(10);

   JButton addBtn = new JButton("Add");   
   JButton startBtn = new JButton("Start");
   JButton stopBtn = new JButton("Stop");
   JButton SpBtn = new JButton("Speed up");
   JButton SdBtn = new JButton("Speed down");

   Drawing draw = new Drawing();
   

   public BallShared() {
      JFrame frame = new JFrame("Play Ball Shared");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      addBtn.addActionListener(this);

      startBtn.addActionListener(this);
     
      stopBtn.addActionListener(this);
      
      SpBtn.addActionListener(this);

      SdBtn.addActionListener(this);
     

      // circle
      xMin = 15; // 20
      xMax = 575; // 478
      yMin = 70;// 30
      yMax = 449; // 319
      x = 240;
      y = 160;
      xSpeed = 15;
      ySpeed = 10;

      // rectangle
      xMin2 = 15; // 20 // ซ้าย
      xMax2 = 575; // 478 // ขวา
      yMin2 = 20;// 30 // บน
      yMax2 = 400; // 319 // ล่าง
      x2 = 80;
      y2 = 100;
      xSpeed2 = 10;
      ySpeed2 = 15;
      size = 40;
      swTimer = new Timer(10, this);

      JPanel panel = new JPanel();

      panel.add(Txt);
      panel.add(a);
      panel.add(addBtn);
      panel.add(startBtn);
      panel.add(stopBtn);
      panel.add(SpBtn);
      panel.add(SdBtn);


      frame.add(panel, "North");
      frame.add(draw);
      frame.setBounds(500, 100, 600, 500);
      frame.setVisible(true);
      //frame.setResizable(false);
   }

   public void actionPerformed(ActionEvent e) {



      if (e.getSource() == addBtn ) {
         choice = 1;
         if(a.getText().equals("")){
            c = 0;
            }
            else {
               c  = Integer.parseInt(a.getText());  
           
            }
            
         swTimer.start();
      }
      if (e.getSource() == startBtn) {
         choice = 2;
         swTimer.start();
      }
    else if (e.getSource() == stopBtn) {
         choice = 3;
         swTimer.stop();
      } else if (e.getSource() == SpBtn) {
         //choice = 4;
         xSpeed *= 2;
         ySpeed *= 2;
         xSpeed2 *= 2;
         ySpeed2 *= 2;
         swTimer.start();
      } else if (e.getSource() == SdBtn) {
         //choice = 5;
         xSpeed /= 1.5;
         ySpeed /= 1.5;
         xSpeed2 /= 1.5;
         ySpeed2 /= 1.5;
         swTimer.start();
      } else {
         draw.move();
         draw.repaint();
      }

   }


   class Drawing extends JComponent {
      public void paint(Graphics g) {
         super.paint(g);
         g.setColor(Color.BLACK);
         g.drawRect(15, 20, 560, 380);
  
         if (choice == 2) {

            int Red = (int) (Math.random() * 256);
            int Green = (int) (Math.random() * 256);
            int Blue = (int) (Math.random() * 256);
            g.setColor(new Color(Red, Green, Blue) );
             g.fillOval((x), (y - 50), size, size);
             g.fillRect((x2), (y2), size, size);

         }


         else if(choice == 1) {
            for(int z = 0; z < c ; z++ ){
     
              int Red = (int) (Math.random() * 256);
               int Green = (int) (Math.random() * 256);
               int Blue = (int) (Math.random() * 256);
            g.setColor(new Color(Red, Green, Blue) );
            
             int l = c + (int) (Math.random() * x);
               int k = c + (int) (Math.random() * y);
               int l2 = c + (int) (Math.random() * x2);
               int k2 = c + (int) (Math.random() * y2);
                g.fillOval((l), (k), size, size);  //  (l), (k), size, size
                g.fillRect((l2), (k2), size, size); //  (l2), (k2), size, size
     
            }
          
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

         if ((x < xMin && y < yMin) == (x2 < xMin2 && y2 < yMin2) ) {

          
            xSpeed = +xSpeed;
            ySpeed = +ySpeed;
            xSpeed2 = +xSpeed2;
            ySpeed2 = +ySpeed2;

         }

      }
   }

   public static void main(String[] args) {
      new BallShared();
   }

 
}