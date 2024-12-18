package menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
    
    public final int WIDTH = 560;
    public final int HEIGHT = 720;

    public void draw(Graphics2D g) {
        
        g.setColor(Color.WHITE);
        g.fill(new Rectangle(WIDTH, HEIGHT));

    }

}
