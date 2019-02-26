package modele.movables;

import modele.*;

public class Box extends Movable{
    private int x;
    private int y;


    public void deplacement(Direction d){
        super.deplacement(d);
    }

    public boolean isPossible(State tab,Direction d){
        int x1=x;
        int y1=y;
        if(super.isPossible(tab,d)){
            for (Box m:tab.boxes) {
                if (m.x == x1 && m.y == y1) {
                    return false;
                }
            }

        }
//        if (super.isPossible(grid,x,y)){
//            return false;
//        }
//        return true;
        return true;
    }

    public Box(int x,int y){
        super(x,y);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}