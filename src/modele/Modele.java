package modele;

import modele.movables.Direction;
import utulities.AbstractModeleEcouteur;
import utulities.LevelMaker;

public class Modele extends AbstractModeleEcouteur {
    private State state;
    public State getState() {
        return state;
    }

    //private Menu menu;
    public Modele(State state){
        this.state = state;
    }
    public void deplacement(Direction d){
        state = state.deplacement(d);
        fireChangement();
    }
    public boolean isFinished(){
        return state.isFinished();
    }
/*
    public State nextLevel(){
    }

    public State selectLevel(){
    }
*/


}
