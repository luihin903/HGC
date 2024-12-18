package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import static java.lang.Math.abs;

public class Grid {

    private View view;

    public Grid(View view) {
        this.view = view;
    }
    
    public void draw(Graphics2D g) {
        AffineTransform at = g.getTransform();
        g.translate(1280 - view.WIDTH + view.WIDTH / 2, view.HEIGHT / 2);
        g.translate(-view.center.x * view.zoom, view.center.y * view.zoom);

        g.setColor(Color.LIGHT_GRAY);
        g.setStroke(new BasicStroke(1));
        for (int i = -40 - (int) ((abs(view.center.x) + abs(view.center.y)) / 25 / view.zoom); i <= 40 + (int) ((abs(view.center.x) + abs(view.center.y)) / 25 / view.zoom); i ++) {
            g.drawLine((int) ((-view.WIDTH - abs(view.center.x)) / view.zoom), 25 * i, (int) ((view.WIDTH + abs(view.center.x)) / view.zoom), 25 * i);
            g.drawLine(25 * i, (int) ((-view.HEIGHT - abs(view.center.y)) / view.zoom), 25 * i, (int) ((view.HEIGHT + abs(view.center.y)) / view.zoom));
        }

        g.setColor(Color.GRAY);
        g.setStroke(new BasicStroke(2));
        for (int i = -10 - (int) ((abs(view.center.x) + abs(view.center.y)) / 100 / view.zoom); i <= 10 + (int) ((abs(view.center.x) + abs(view.center.y)) / 100 / view.zoom); i ++) {
            g.drawLine((int) ((-view.WIDTH - abs(view.center.x)) / view.zoom), 100 * i, (int) ((view.WIDTH + abs(view.center.x)) / view.zoom), 100 * i);
            g.drawLine(100 * i, (int) ((-view.HEIGHT - abs(view.center.y)) / view.zoom), 100 * i, (int) ((view.HEIGHT + abs(view.center.y)) / view.zoom));
        }
        
        g.setTransform(at);
    }

}
