package modele;

import modele.movables.Direction;
import utulities.AbstractModeleEcouteur;

import java.util.ArrayDeque;
import java.util.Deque;

public class Modele extends AbstractModeleEcouteur {
    private State state;
    private Deque<State> history = new ArrayDeque();

    //private Menu menu;
    public Modele(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void deplacement(Direction d) {
        history.addLast(state);
        state = state.deplacement(d);
        fireChangement();
    }

    public void annulDeplacement() {
        if (history.size() != 0) {
            state = history.removeLast();
            fireChangement();
        }
    }

    public boolean isFinished() {
        return state.isFinished();
    }


    public void resetLevel() {
        state = history.removeFirst();
        fireChangement();
        history = new ArrayDeque();
    }
  /*
    public void nextLevel(){
    }

    public void selectLevel(){
    }
*/


}
