package modele.movables;

import modele.*;

public class Box extends Movable{

    public boolean isPossible(State tab,Direction d){
        int x = getX();
        int y = getY();
        int[] coord = nextMove(x,y,d);
        int x1=coord[0];
        int y1=coord[1];
        if (super.isPossible(tab, d)){
            for (Box b:tab.getBoxes()) {
                if (b.getX() == x1 && b.getY() == y1) {
                    return false;
                }
            }
            return true;
        }else
            return false;

    }

    public Box(int x,int y){
        super(x,y);

    }


}