package modele.movables;

import modele.*;

public class Box extends Movable{
    public int x;
    public int y;
    public int testx;
    public int testy;

    public Box(int x,int y){
        super(x,y);

    }

    @Override
    public void deplacement(char d){
        super.deplacement(d);
    }
    @Override
    public boolean isPossible(State grid,int x,int y){
        if (!super.isPossible(grid,x,y)){
            return false;
        }
        for (Movable m:grid.movables) {
            if (m.x == this.testx && m.y == this.testy){
                return false;
            }
        return true;

    }



}