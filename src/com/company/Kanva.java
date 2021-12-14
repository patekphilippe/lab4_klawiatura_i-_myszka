package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.CancellationException;

public class Kanva extends JPanel implements MouseInputListener {
    public final BufferedImage canvas ;

    public Shape shape = Shape.None;
    public Kanva() {
        super();
        requestFocusInWindow();
        canvas = new BufferedImage(450,450, BufferedImage.TYPE_INT_RGB);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyChar() == 'o') {
                    shape = Shape.Oval;
                } else if(e.getKeyChar() == 'r') {
                    shape = Shape.Rectangle;
                }
            }
        });

        addMouseListener(this);
        setVisible(true);
        setFocusable(true);
        }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas,0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        var g = canvas.getGraphics();
        if(shape == Shape.Oval) {
            g.setColor(Color.RED);
            g.drawOval(e.getX(),e.getY(),20,20);
        } else if(shape == Shape.Rectangle) {
            g.setColor(Color.GREEN);
            g.drawRect(e.getX(),e.getY(),20,20);
        }
        g.dispose();
        Kanva.this.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
