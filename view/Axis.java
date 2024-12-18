package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.Pos;

public class Axis {

    private View view;

    public Axis(View view) {
        this.view = view;
    }

    public void draw(Graphics2D g) {
        AffineTransform at = g.getTransform();
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.translate(1280 - view.WIDTH + view.WIDTH / 2, view.HEIGHT / 2);
        g.translate(-view.center.x * view.zoom, view.center.y * view.zoom);
        g.drawLine(0, -view.HEIGHT, 0, view.HEIGHT);
        g.drawLine(-view.WIDTH, 0, view.WIDTH, 0);
        g.setTransform(at);
    }

}
