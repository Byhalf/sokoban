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

    int dimX, dimY;

    public AstarGrid(State state) {
        this.state = state;
        Grid grid = state.getGrid();
        dimX = grid.getDimX();
        dimY = grid.getDimY();
        nodes = new Node[dimX][dimY];
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                if (grid.getCase(i, j) == Case.FLOOR || grid.getCase(i, j) == Case.GOAL) {
                    nodes[i][j] = new Node(i, j);
                }
                if (grid.getCase(i, j) == Case.GOAL)
                    goals.add(new Node(i, j));
            }
        }
    }

    public AstarGrid(State state, Node[][] nodes, ArrayList goals) {
        this.state = state;
        this.nodes = nodes;
        this.goals = goals;
    }

    Node[][] nodes;

    public State getState() {
        return state;
    }

    public ArrayList getGoals() {
        return goals;
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public AstarGrid makeCopy(AstarGrid original) {
        Node[][] originalNodes = original.getNodes();
        Node[][] nodesCopy = new Node[getDimX()][getDimY()];
        for (int i = 0; i < getDimX(); i++) {
            for (int j = 0; j < getDimY(); j++) {
                nodesCopy[i][j] = new Node(originalNodes[i][j].getX(), originalNodes[i][j].getY());
            }
        }
        return new AstarGrid(original.getState(), nodesCopy, original.getGoals());
    }

    public AstarGrid movableToUnmovable(Movable movable) {
        AstarGrid res = makeCopy(this);
        for (Box box : state.getBoxes()) {
            res.getNodes()[box.getX()][box.getY()] = null;
        }
        if (movable instanceof Player)
            return res;
        else
            res.getNodes()[movable.getX()][movable.getY()] = new Node(movable.getX(), movable.getY());
        return res;
    }

    public AstarGrid movableToUnmovable() {
        AstarGrid res = makeCopy(this);
        for (Box box : state.getBoxes()) {
            res.getNodes()[box.getX()][box.getY()] = null;
        }
        return res;
    }

    public ArrayList<Node> getNeighbourNodes(Node node) {
        //On transforme les box en null, comme ça si une boite en colle un autre son chemin est bloqué.
        //Notre pathfinder ne cherchera pas à arrivé sur la boite mais à coté donc tans pis ça valeur est null
        //faut juste une case d'arrivé à coté
        AstarGrid unmovables = movableToUnmovable();
        Node[][] nodes = unmovables.getNodes();
        ArrayList<Node> res = new ArrayList<>();
        int x = node.getX();
        int y = node.getY();
        if (x - 1 > 0) {
            if (nodes[x - 1][y] != null)
                res.add(nodes[x - 1][y]);
        }
        if (x + 1 >= getDimX()) {
            if (nodes[x + 1][y] != null)
                res.add(nodes[x + 1][y]);
        }
        if (y - 1 > 0) {
            if (nodes[x][y - 1] != null) {
                res.add(nodes[x][y - 1]);
            }
        }
        if (y + 1 >= getDimY()) {
            if (nodes[x][y + 1] != null) {
                res.add(nodes[x][y + 1]);
            }
        }
        return res;
    }


}
