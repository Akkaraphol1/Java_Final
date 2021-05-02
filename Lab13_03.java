
// File Name : Lab13_03.java
import java.awt.*;
import java.awt.event.*;
//import java.time.Clock;

import javax.swing.*;

public class Lab13_03 extends JFrame implements ActionListener {
    private Clock time;
    private JButton playBtn, stopBtn;

    public Lab13_03() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        playBtn = new JButton("Start Time");
        playBtn.addActionListener(this);
        stopBtn = new JButton("Stop Time");
        stopBtn.addActionListener(this);
        time = new Clock();
        c.add(playBtn);
        c.add(stopBtn);
        c.add(time);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playBtn) {
            time.start();
            playBtn.setEnabled(false);
        } else if (e.getSource() == stopBtn) {
            time.stop();
            playBtn.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        Lab13_03 window = new Lab13_03();
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}