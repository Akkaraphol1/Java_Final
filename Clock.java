
// File Name : Clock.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Clock extends JPanel implements ActionListener {
    private int width = 300;
    private int height = 300;
    private int xC = 150;
    private int yC = 150;
    private Color red, blue, green;
    private int Hour, Minute, Second;
    private double angle1 = -270, angle2 = -180, angle3 = -270;
    private Timer time;

    public Clock() {
        super();
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createBevelBorder(0));
        red = Color.RED;
        blue = Color.BLUE;
        green = Color.GREEN;
        setFont(new Font("Tahoma", Font.BOLD, 16));
        Hour = 0;
        Minute = 45;
        Second = 0;
        time = new Timer(1000, this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(xC - 145, yC - 145, 290, 290);
        g.drawOval(xC - 146, yC - 146, 292, 292);
        drawText(g);
        g.setColor(red);
        int x = (int) (125 * Math.cos(toRadians(angle1)));
        int y = (int) (125 * Math.sin(toRadians(angle1)));
        // Second
        if (angle1 <= 90)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle1 <= 180)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle1 <= 270)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle1 <= 360)
            g.drawLine(150, 150, xC + x, yC - y);

        // Minute
        g.setColor(green);
        x = (int) (100 * Math.cos(toRadians(angle2)));
        y = (int) (100 * Math.sin(toRadians(angle2)));
        if (angle2 <= 90)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle2 <= 180)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle2 <= 270)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle2 <= 360)
            g.drawLine(150, 150, xC + x, yC - y);
        // Hour
        g.setColor(blue);
        x = (int) (80 * Math.cos(toRadians(angle3)));
        y = (int) (80 * Math.sin(toRadians(angle3)));
        if (angle3 <= 90)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle3 <= 180)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle3 <= 270)
            g.drawLine(150, 150, xC + x, yC - y);
        else if (angle3 <= 360)
            g.drawLine(150, 150, xC + x, yC - y);
        g.setColor(Color.BLACK);
        g.fillOval(xC - 4, yC - 4, 8, 8);
    }

    public void drawText(Graphics g) {
        g.drawString("12", 140, 22);
        g.drawString("6", 145, 290);
        g.drawString("3", 280, 157);
        g.drawString("9", 10, 157);
    }

    private double toRadians(double angle) {
        return (Math.PI * angle / 180.0);
    }

    public void start() {
        time.start();
    }

    public void stop() {
        time.stop();
    }

    public void actionPerformed(ActionEvent e) {
        if (Second == 60) {
            angle1 = -270;
            Second = 0;
            Minute = Minute + 1;
            if (Minute == 60) {
                angle2 = -270;
                Minute = 0;
                Hour = Hour + 1;
                angle3 = angle3 - 30;
                if (Hour == 12) {
                    angle3 = -270;
                    Hour = 0;
                }
            } else {
                angle2 = angle2 - 6;
            }
        } else {
            angle1 = angle1 - 6;
            Second = Second + 1;
        }
        repaint();
    }
}