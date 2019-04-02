package intelligence;

import modele.movables.Movable;

public class Node {
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.distanceStart = 0;
    }

    private int value;

    //non heuristique
    private int distanceStart;
    //heuristique
    private int distanceEnd;

    private Node parent;

    private int x;
    private int y;

    public Node(int x, int y, Node node) {
        this(x, y);
        setDistanceStart(node.getDistanceStart() + 1); //distance forcément de 1
    }

    public Node(Movable movable) {
        this(movable.getX(), movable.getY());
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setDistanceStart(int distanceStart) {
        this.distanceStart = distanceStart;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean compare(Node nodeToCompare) {
        return (nodeToCompare.getX() == getX() && nodeToCompare.getY() == getY());
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
