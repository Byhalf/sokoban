package intelligence;

import modele.Case;
import modele.Grid;
import modele.State;
import modele.movables.Box;
import modele.movables.Movable;
import modele.movables.Player;

import java.util.ArrayList;

public class AstarGrid {
    State state;
    ArrayList goals = new ArrayList();
    Node[][] nodes;
    int x, y;

    public AstarGrid(State state) {
        this.state = state;
        Grid grid = state.getGrid();
        x = grid.getDimX();
        y = grid.getDimY();
        nodes = new Node[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid.getCase(i, j) == Case.FLOOR || grid.getCase(i, j) == Case.GOAL) {
                    nodes[i][j] = new Node(i, j);
                }
                if (grid.getCase(i, j) == Case.GOAL)
                    goals.add(new Node(i, j));
            }
        }
    }

    public void movableToUnmovable(Movable movable) {
        if (movable instanceof Player) {
            for (Box box : state.getBoxes()) {
                nodes[box.getX()][box.getY()] = new Node(box.getX(), box.getY());
            }
        }
    }

}
