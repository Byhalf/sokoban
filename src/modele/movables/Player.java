package modele.movables;

import modele.*;

public class Player extends Movable{

    public void deplacement(State s,Direction d){
        if(isPossible(s,d)){
            super.deplacement(s,d);
            super.increment_num_coup();
        }
    }


    public Player(int x,int y){
        super(x,y);
    }

    @Override
    public boolean isPossible(State tab,Direction d) {
        int[] coord = nextMove(getX(),getY(),d);
        int x1=coord[0];
        int y1=coord[1];
        if (super.isPossible(tab, d)) {
            for (Box b : tab.getBoxes()) {
                if (b.getX() == x1 && b.getY() == y1) {
                    if (!b.isPossible(tab,d))
                        return false;
                    else
                        b.deplacement(tab,d );
                        return true;
                }
            }return true;
        }else
            return false;
    }

}