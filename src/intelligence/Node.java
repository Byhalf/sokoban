package intelligence;

import modele.movables.Movable;

public class Node {
    //non heuristique
    private int distanceStart;
    //heuristique
    private int distanceEnd;

    private Node parent;

    private int value;
    private int x;
    private int y;

    public Node(Movable movable) {
        this(movable.getX(), movable.getY());
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getDistanceStart() {
        return distanceStart;
    }

    public int getDistanceEnd() {
        return distanceEnd;
    }

    public void setDistanceEnd(Node endNode) {
        distanceEnd = Math.abs(getX() - endNode.getX()) + Math.abs(getY() - endNode.getY());
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
