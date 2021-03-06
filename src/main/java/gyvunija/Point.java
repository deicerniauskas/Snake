package gyvunija;

public class Point {


    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point head, Directions changeDirection) {
        x = head.x;
        y = head.y;

        switch (changeDirection) {
            case UP:
                y--;
                return;
            case DOWN:
                y++;
                return;
            case LEFT:
                x--;
                return;
            case RIGHT:
                x++;
                return;
        }

    }

    public int getX() { return x; }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Directions findDirection(Point neck) {
        if (x == neck.x) {
            if (y > neck.y) {
                return Directions.DOWN;
            } else {
                return Directions.UP;
            }
        }
        if (y == neck.y) {
            if (x > neck.x) {
                return Directions.RIGHT;
            } else {
                return Directions.LEFT;
            }
        }

        throw new RuntimeException();

    }
}
