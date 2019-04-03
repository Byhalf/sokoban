package intelligence;

import modele.movables.Movable;

public class Node {


    private int value;

    //non heuristique
    private int distanceStart;
    //heuristique
    private int distanceEnd;

    private Node parent = null;

    private int x;
    private int y;

    public Node(int x, int y, Node node) {
        this(x, y);
        setDistanceStart(node.getDistanceStart() + 1); //distance forcément de 1
    }

    public Node(Movable movable) {
        this(movable.getX(), movable.getY());
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.distanceStart = 0;
    }

    @Override
    public String toString() {
        return getX() + "   " + getY();
    }


    public boolean compare(Node nodeToCompare) {
        return (nodeToCompare.getX() == getX() && nodeToCompare.getY() == getY());
    }



    public void setDistanceEnd(Node endNode) {
        distanceEnd = Math.abs(getX() - endNode.getX()) + Math.abs(getY() - endNode.getY());
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDistanceStart() {
        return distanceStart;
    }

    public void setDistanceStart(int distanceStart) {
        this.distanceStart = distanceStart;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getDistanceEnd() {
        return distanceEnd;
    }

}
