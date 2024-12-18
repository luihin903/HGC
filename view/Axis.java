package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import util.Pos;

import static java.lang.Math.abs;

public class Axis {

    private View view;

    public Axis(View view) {
        this.view = view;
    }

    public void draw(Graphics2D g) {
        AffineTransform at = g.getTransform();
        g.translate(1280 - view.WIDTH + view.WIDTH / 2, view.HEIGHT / 2);
        g.translate(-view.center.x * view.zoom, view.center.y * view.zoom);

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));
        g.drawLine((int) ((-view.WIDTH - abs(view.center.x)) / view.zoom), 0, (int) ((view.WIDTH + abs(view.center.x)) / view.zoom), 0);
        g.drawLine(0, (int) ((-view.HEIGHT - abs(view.center.y)) / view.zoom), 0, (int) ((view.HEIGHT + abs(view.center.y)) / view.zoom));

        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        g.drawString("0", -20, 22);
        for (int i = 1; i < 10 + (int) (abs(view.center.x) / 100 / view.zoom); i ++) {
            String positiveText = Integer.toString(100 * i);
            String negativeText = Integer.toString(-100 * i);
            int targetX = 100 * i;
            int targetY = 8;
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int positiveTextWidth = metrics.stringWidth(positiveText);
            int negativeTextWidth = metrics.stringWidth(negativeText);
            int textHeight = metrics.getAscent();
            g.setColor(Color.WHITE);
            g.fill(new Rectangle(targetX - positiveTextWidth / 2, targetY - textHeight / 2 + 8, positiveTextWidth, textHeight - 8));
            g.fill(new Rectangle(-targetX - negativeTextWidth / 2, targetY - textHeight / 2 + 8, negativeTextWidth, textHeight - 8));
            g.setColor(Color.BLACK);
            g.drawString(positiveText, targetX - positiveTextWidth / 2, targetY + textHeight / 2);
            g.drawString(negativeText, -targetX - negativeTextWidth / 2, targetY + textHeight / 2);
        }
        for (int i = 1; i < 10 + (int) (abs(view.center.y) / 100 / view.zoom); i ++) {
            String positiveText = Integer.toString(100 * i);
            String negativeText = Integer.toString(-100 * i);
            int targetX = -8;
            int targetY = 100 * i;
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int positiveTextWidth = metrics.stringWidth(positiveText);
            int negativeTextWidth = metrics.stringWidth(negativeText);
            int textHeight = metrics.getAscent();
            g.setColor(Color.WHITE);
            g.fill(new Rectangle(targetX - positiveTextWidth, -targetY - textHeight / 2, positiveTextWidth, textHeight - 4));
            g.fill(new Rectangle(targetX - negativeTextWidth, targetY - textHeight / 2, negativeTextWidth, textHeight - 4));
            g.setColor(Color.BLACK);
            g.drawString(positiveText, targetX - positiveTextWidth, -targetY + textHeight / 2 - 4);
            g.drawString(negativeText, targetX - negativeTextWidth, targetY + textHeight / 2 - 4);
        }
        

        g.setTransform(at);
    }

}
