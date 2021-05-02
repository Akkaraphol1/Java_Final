
// File Name : Lab12_05.java
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Lab12_05 extends JFrame implements KeyListener, ActionListener {
    private int width, height;
    private JButton startBtn, stopBtn;
    private int xMin, xMax, yMin, yMax;
    private int x, y, size, xSpeed, ySpeed;
    Timer swTimer;

    public Lab12_05() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        startBtn = new JButton("Play");
        startBtn.addActionListener(this);
        startBtn.addKeyListener(this);
        c.add(startBtn);
        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(this);
        stopBtn.addKeyListener(this);
        c.add(stopBtn);
        width = 480;
        height = 240;//320
        xMin = 20; //20
        xMax = 478; //478
        yMin = 90;//30
        yMax = 329; // 319
        xSpeed = 5; //2
        ySpeed = 5; //2
        x = 240;
        y = 160;
        size = 40;
        swTimer = new Timer(10, this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(20, 80, 460, 245); // 100, 10, 500, 400
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyChar() == 'p')
            swTimer.start();
        else if (event.getKeyChar() == 's')
            swTimer.stop();
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn)
            swTimer.start();
        else if (e.getSource() == stopBtn)
            swTimer.stop();
        else {
            move();
            repaint();
        }
    }

    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;
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
    }

    public static void main(String[] args) {
        Lab12_05 window = new Lab12_05();
        //                x    y   z    v          y = 100    ,  y = 200
        window.setBounds(100, 10, 500, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}