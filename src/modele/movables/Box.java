package modele.movables;

import modele.*;

public class Box extends Movable{
    public int x;
    public int y;


    public void deplacement(char d){
        super.deplacement(d);
    }

    public boolean isPossible(State grid,Direction d){
        int x1=x;
        int y1=y;
        if(super.isPossible(grid,d)){
            for (Box m:grid.movables) {
                if (m.x == x1 && m.y == y1) {
                    return false;
                }
            }
            return true;
        }
//        if (super.isPossible(grid,x,y)){
//            return false;
//        }
//        return true;

    }

    public Box(int x,int y){
        super(x,y);

    }


}