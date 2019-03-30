package modele;

import modele.movables.Box;
import modele.movables.Direction;
import modele.movables.Player;
import utulities.AbstractModeleEcouteur;

import java.util.ArrayList;

public class State extends AbstractModeleEcouteur {

    private Grid grid;
    private Player player;
    private ArrayList<Box> boxes;

    public State(Grid grid, ArrayList<Box> boxes, Player player) {
        this.grid = grid;
        this.boxes = boxes;
        this.player = player;
    }

    public Grid getGrid() {
        return grid;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public State deplacement(Direction d) {
        State newState = getCopy(this);
        newState.getPlayer().deplacement(newState, d);
        return newState;
    }

    public boolean isFinished() {
        boxes = this.boxes;
        for (Box box : boxes) {
            if (this.grid.getCase(box.getX(), box.getY()) != Case.GOAL) {
                return false;
            }
        }

        return true;
    }

    public State getCopy(State state) {
        ArrayList<Box> newBoxes = new ArrayList<Box>();
        for (Box box : boxes) {
            Box newBox = new Box(box.getX(), box.getY());
            newBoxes.add(newBox);
        }
        Player newPlayer = new Player(player.getX(), player.getY());
        return new State(getGrid(), newBoxes, newPlayer);
    }


}
