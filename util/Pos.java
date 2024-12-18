package util;

public class Pos {
    
    public int x;
    public int y;

    public Pos(int x, int y) {
        set(x, y);
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Pos copy() {
        return new Pos(this.x, this.y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
