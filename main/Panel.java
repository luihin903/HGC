package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import menu.Menu;
import view.View;

public class Panel extends JPanel {
    
    private View view = new View();
    private Menu menu = new Menu();

    public Panel() {
        this.setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1280, 720));
    }

    @Override
    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;

        view.draw(g);
        menu.draw(g);

    }

}
