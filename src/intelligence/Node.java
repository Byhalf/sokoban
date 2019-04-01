package intelligence;

public class Node {
    //non heuristique
    private int distanceStart;
    //heuristique
    private int distanceEnd;
    private int value;
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
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
