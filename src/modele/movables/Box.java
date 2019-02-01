package modele.movables;

import modele.*;

public class Box extends Movable{
    public int x;
    public int y;
    public int testx;
    public int testy;

    public void deplacement(char d){
        super.deplacement(d);
    }

    public boolean isPossible(State grid,int x,int y){
        if (!super.isPossible(grid,x,y)){
            return false;
        }
        return true;

    }

    public Box(int x,int y){
        super(x,y);

    }


}