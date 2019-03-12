package modele;

import modele.movables.Direction;
import utulities.AbstractModeleEcouteur;
import utulities.LevelMaker;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Modele extends AbstractModeleEcouteur {
    private State state;
    public State getState() {
        return state;
    }
    private Deque<State> history = new ArrayDeque();

    //private Menu menu;
    public Modele(State state){
        this.state = state;
    }
    public void deplacement(Direction d){
        history.addLast(state);
        state = state.deplacement(d);
        fireChangement();
    }
    public void annulDeplacement(){
        state = history.removeLast();
        fireChangement();
    }
    public boolean isFinished(){
        return state.isFinished();
    }

  /*
    public void resetLevel(){}

    public void nextLevel(){
    }

    public void selectLevel(){
    }
*/


}
