package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import menu.Menu;
import util.Pos;
import view.View;

public class Panel extends JPanel {
    
    private View view = new View();
    private Menu menu = new Menu();

    private Pos mouseStart;
    private Pos centerStart; // the center when the user starts dragging

    public Panel() {
        
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1280, 720));
        addMouseListener(new MyMouseAdapter());
        addMouseMotionListener(new MyMouseMotionAdapter());

    }

    @Override
    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;

        view.draw(g);
        menu.draw(g);

    }

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            mouseStart = new Pos(e.getX(), e.getY());
            centerStart = view.center.copy();
        }

    }

    private class MyMouseMotionAdapter extends MouseMotionAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            if (mouseStart.x > menu.WIDTH && mouseStart.x < 1280 && mouseStart.y > 0 && mouseStart.y < 720) {
                view.center.setX((int) (centerStart.x - (e.getX() - mouseStart.x) / view.zoom));
                view.center.setY((int) (centerStart.y + (e.getY() - mouseStart.y) / view.zoom));
                repaint();
            }
        }

    }

}
