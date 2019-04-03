package intelligence;

import modele.movables.Box;

import java.util.ArrayList;

public class PlayerPath {
    private Node targetBox;
    private Node neighbour;
    private ArrayList<Node> path;

    public PlayerPath(Box targetBox, Node neighbour, ArrayList<Node> path) {
        this(new Node(targetBox.getX(), targetBox.getY()), neighbour, path);
    }

    public PlayerPath(Node targetBox, Node neighbour, ArrayList<Node> path) {
        this.targetBox = targetBox;
        this.neighbour = neighbour;
        this.path = path;
    }

    public Node getTargetBox() {
        return targetBox;
    }

    public Node getNeighbour() {
        return neighbour;
    }

    public ArrayList<Node> getPath() {
        return path;
    }
}
