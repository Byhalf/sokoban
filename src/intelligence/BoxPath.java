package intelligence;

import java.util.ArrayList;

public class BoxPath {
    private Node box;
    private Node goal;
    private ArrayList<Node> path;

    public BoxPath(Node box, Node goal, ArrayList<Node> path) {
        this.box = box;
        this.goal = goal;
        this.path = path;
    }

    public Node getBox() {
        return box;
    }

    public Node getPlayerPosition() {
        Node whereToGo = path.get(0);
        Node whereToBe = null;
        if (whereToGo.getX() == box.getX()) {
            if (whereToGo.getY() == box.getY() - 1)
                whereToBe = new Node(whereToGo.getX(), whereToGo.getY() + 1);
            else if (whereToGo.getY() == box.getY() + 1)
                whereToBe = new Node(whereToGo.getX(), whereToGo.getY() - 1);
        }
        if (whereToGo.getY() == box.getY()) {
            if (whereToGo.getX() == box.getX() - 1)
                whereToBe = new Node(whereToGo.getX() + 1, whereToGo.getY());
            else if (whereToGo.getX() == box.getX() + 1)
                whereToBe = new Node(whereToGo.getX() - 1, whereToGo.getY());
        }
        return whereToBe;
    }

    public Node getGoal() {
        return goal;
    }


    public ArrayList<Node> getPath() {
        return path;
    }


}
