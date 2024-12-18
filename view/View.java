package view;
import java.awt.Graphics2D;

import util.Pos;


public class View {
    
    public final int WIDTH = 720;
    public final int HEIGHT = 720;

    // the coordinates of the center of the view
    public Pos center = new Pos(0, 0);
    public double zoom = 1;

    private Grid grid = new Grid(this);
    private Axis axis = new Axis(this);

    public void draw(Graphics2D g) {
        grid.draw(g);
        axis.draw(g);
    }

}
