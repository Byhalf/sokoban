package modele;

import modele.movables.Direction;
import modele.movables.Movable;

import java.util.ArrayList;

public class Move {
    public ArrayList<Movable> getmList() {
        return mList;
    }

    private ArrayList<Movable> mList;

    public Direction getD() {
        return d;
    }

    private Direction d;
    int num_coup;
    public Move(Movable m, Direction d,int num_coup){
        this.mList.add(m);
        this.d = d;
        this.num_coup = num_coup;
    }
    public Move(Movable m1, Movable m2, Direction d,int num_coup){
        this(m1,d,num_coup);
        this.mList.add(m2);

    }
}
