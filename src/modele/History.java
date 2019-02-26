package modele;
import modele.movables.Direction;
import modele.movables.Movable;
import modele.movables.Player;

import java.util.ArrayList;

public class History {
    private ArrayList<Move> history;

    public void addMove(Move m){
        history.add(m);
    }
    public void undoMove(){
        //je dois l'initialisé j'aime pas ça
        Direction opposite_d = Direction.U;
        Move move = history.get(history.size()-1);
        switch (move.getD()){
            case D:
                opposite_d = Direction.U;
                break;
            case U:
                opposite_d = Direction.D;
                break;
            case L:
                opposite_d = Direction.R;
                break;
            case R:
                opposite_d = Direction.L;
                break;
        }for(Movable m:move.getmList()){
            m.deplacement(opposite_d);
            if(m instanceof Player){
                //mooooche c'est pcq ça augmente quand on deplace je ne sais pas comment fair autrement
                m.decrement_num_coup();
                m.decrement_num_coup();

            }
        }history.remove(history.size()-1);

    }
}
