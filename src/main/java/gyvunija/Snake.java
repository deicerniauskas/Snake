package gyvunija;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Joint> joints = new ArrayList<Joint>();
    private int width = 0;
    private int height = 0;


   public Snake(int width, int height){
        reset();
        this.width = width;
        this.height = height;
    }

    public void collision() {
        //reikia patikrint ar head neatsitrenkia i sienas ir savo kuna, per for cikla
        //jei galva == kordinate x  = fail, tas tas su y
        //jei galva == visas kunas apart galvos = fail
        //for ()

        // if(getHead() == height){
    }
    public void drawing(){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; i++){
            }
            System.out.println("y");

        }



        //}
    }


    public void reset () {
        joints.add(new Joint(0, 0));
        joints.add(new Joint(1, 0));
        joints.add(new Joint(2, 0));
    }

    public void move(Directions changeDirection) {
        Directions headDirection = detectDirection();
        if (checkDirection(changeDirection, headDirection)) {
            joints.add(new Joint(getHead(), changeDirection));

        } else {
            joints.add(new Joint(getHead(), detectDirection()));
        }
        joints.remove(0);
    }


    private Joint getHead() {
        return joints.get(joints.size() - 1);
    }


    private Directions detectDirection() {
        Joint galva = getHead();
        Joint kaklas = joints.get(joints.size() - 2);
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

    public List<Joint> getJoints() {
        return joints;
    }
}
