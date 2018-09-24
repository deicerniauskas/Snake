package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Snake implements ActionListener {

    public JFrame jframe;

    public RenderPanel renderPanel;

    public Timer timer = new Timer(20,this);

    public static Snake snake;

    public Toolkit toolkit;

    public ArrayList<Point> snakeParts = new ArrayList<Point>();



    public Snake(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        toolkit = Toolkit.getDefaultToolkit();
        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(800,700);
        jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
        jframe.add(renderPanel = new RenderPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();

    }

    public static void main(String[] args) {
        snake = new Snake();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
    }
}
