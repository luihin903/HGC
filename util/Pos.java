package util;
public class Pos {
    
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos copy() {
        return new Pos(this.x, this.y);
    }

}
