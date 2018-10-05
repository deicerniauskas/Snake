package gyvunija.app;

import gyvunija.Directions;
import gyvunija.Point;
import gyvunija.Snake;

import java.util.List;



public class AppDebug {

    public static void main(String[] args) {
        Snake melvin = new Snake(10, 10);

        printmap(melvin);

        melvin.move(Directions.DOWN);
        melvin.move(Directions.DOWN);
        melvin.move(Directions.DOWN);
        melvin.move(Directions.DOWN);
        melvin.move(Directions.RIGHT);

        System.out.println();

        printmap(melvin);

    }

    private static void printmap(Snake melvin) {
        melvin.getPoints();

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {

                if (notEmpty(melvin.getPoints(), x, y)) {
                    System.out.print("x");
                } else {
                    System.out.print(".");
                }

            }

            System.out.println();
        }

    }

    private static boolean notEmpty(List<Point> points, int x, int y) {
        for (Point point : points) {
            if (point.getX() == x && point.getY() == y) {
                return true;
            }
        }
        return false;
    }

}