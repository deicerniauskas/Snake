package gyvunija;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake {

    private List<Point> points = new ArrayList<Point>();
    private int width = 0;
    private int height = 0;

    private Point apple;

//    obuolio collision?

    private void makeApple (){
        Random rnd = new Random();
        int randX = rnd.nextInt(width);
        int randY = rnd.nextInt(height);

        if ((points.size() == randX) && (points.size() == randY)) {

            randY++;

        }
    }


    public Snake(int width, int height) {
        reset();
        this.width = width;
        this.height = height;
    }


    public void reset() {
        points.add(new Point(0, 0));
        points.add(new Point(1, 0));
        points.add(new Point(2, 0));
        points.add(new Point(3, 0));
        points.add(new Point(4, 0));
        points.add(new Point(5, 0));
    }

    public boolean move() {
        return move(detectDirection());

    }
    public List<Point> getPoints() {
        return points;
    }
    public boolean move(Directions changeDirection) {
        Directions headDirection = detectDirection();
        if (checkDirection(changeDirection, headDirection)) {
            points.add(new Point(getHead(), changeDirection));

        } else {
            points.add(new Point(getHead(), detectDirection()));
        }
        points.remove(0);

       return collision(getHead());
    }


    private Point getHead() {
        return points.get(points.size() - 1);
    }


    private Directions detectDirection() {
        Point galva = getHead();
        Point kaklas = points.get(points.size() - 2);
        return galva.findDirection(kaklas);
    }

    private boolean checkDirection(Directions changeDirection, Directions headDirection) {
        if (Directions.UP.equals(changeDirection) || Directions.DOWN.equals(changeDirection)) {
            return Directions.LEFT.equals(headDirection) || Directions.RIGHT.equals(headDirection);
        }
        if (Directions.LEFT.equals(changeDirection) || Directions.RIGHT.equals(changeDirection)) {
            return Directions.DOWN.equals(headDirection) || Directions.UP.equals(headDirection);
        }
        throw new RuntimeException("" + changeDirection);
    }


    private boolean collision(Point galva) {
        return bodyCollision(galva) && wallCollision(galva);
    }

    private boolean bodyCollision(Point galva) {
        //Jei galva atsitrenkia grazina True ir zaidimas baigtas?
        for (int i = 0; i < points.size() -1; i++) {
            if (galva.getX() == points.get(i).getX() && galva.getY() == points.get(i).getY()) {
                return false;
            }
        }
        return true;
    }

//    private boolean appleCollision(Point galva){
//        if ((galva.getX() == apple.getX()) && (galva.getY() == apple.getY())) {
//            return true;
//        } else{
//            return false;
//        }
//    }

    //private boolean snakeGrow(Point galva){


    private boolean wallCollision(Point galva) {


        if (galva.getX() < 0 || galva.getY() < 0 || galva.getX() > width || galva.getY() > height) {
            return false;
        }

        return true;

    }


}
