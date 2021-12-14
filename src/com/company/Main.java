package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;

public class Main extends JFrame{
    Random rand = new Random();
    int randX = rand.nextInt(300);
    int randY = rand.nextInt(300);
    int mouseX;
    int mouseY;
    public static void main(String[] args) throws IOException{
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main application = new Main();
                application.createFrame();
            }
        });
    }

    public void createFrame() {
        setTitle("uciekający przycisk");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

//        JPanel panel = new JPanel();
//        panel.setBounds(0, 0, 450, 450);
//        setContentPane(panel);
//        panel.setLayout(null);
//        panel.setFocusable(false);

        JButton clickBtn = new JButton("Run");
        clickBtn.setBounds(randX,randY,100,30);
        clickBtn.setVisible(true);

        Kanva cPanel = new Kanva();
        cPanel.setBounds(0, 0, 450, 450);
        cPanel.setLayout(null);
        setContentPane(cPanel);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(0,0,100,30);
        exitBtn.setVisible(false);

        clickBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mouseX = e.getX();
                if(mouseX < 80)
                    {
                         randX = rand.nextInt(300);
                         randY = rand.nextInt(300);
                         clickBtn.setLocation(randX, randY);
                    }
            }
        });

        clickBtn.addActionListener((e)->{
            clickBtn.setVisible(false);
            exitBtn.setVisible(true);
        });

        exitBtn.addActionListener((e)->{
           clickBtn.setVisible(true);
           exitBtn.setVisible(false);

           var g = cPanel.canvas.getGraphics();
           g.setColor(Color.BLACK);
           g.fillRect(0,0,450,450);
           g.dispose();
           cPanel.repaint();
           cPanel.shape = Shape.None;
        });


        cPanel.add(clickBtn);
        cPanel.add(exitBtn);
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}


