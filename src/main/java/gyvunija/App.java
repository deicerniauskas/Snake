package gyvunija;

import java.util.List;

public class App {

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



melvin.drawing();
    }


    private static void printmap(Snake melvin) {
        melvin.getJoints();

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {


                if (notEmpty(melvin.getJoints(), x, y)) {
                    System.out.print("x");
                } else {
                    System.out.print(".");
                }


            }

            System.out.println();
        }

    }

    private static boolean notEmpty(List<Joint> joints, int x, int y) {
        for (Joint joint: joints) {
            if (joint.getX() == x && joint.getY() == y){
                return true;
            }
        }
        return false;
    }

}
