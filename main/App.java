package main;

import javax.swing.JFrame;

public class App extends JFrame {

    public App(String title) {
        super(title);
        Panel panel = new Panel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new App("HGC");
    }

}