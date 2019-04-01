package intelligence;

import java.util.ArrayList;

public class AstarAlgo {
    private ArrayList<Node> openList = new ArrayList<>();
    private ArrayList<Node> closedList = new ArrayList<>();
    private Node start;
    private Node end;

    public AstarAlgo(Node start, Node end, AstarGrid grid) {
        this.start = start;
        this.end = end;
        start.setValue(0);
        openList.add(start);
        while (openList.size() > 0) {
            Node q = popMinFromList(openList);
            ArrayList<Node> neighbors = grid.getNeighbourNodes(q);
            for (Node neighbor : neighbors)
                neighbor.setParent(q);

        }
    }

    public Node popMinFromList(ArrayList<Node> openList) {
        Node res = new Node(-1, -1);
        res.setValue(999999999);
        for (Node node : openList) {
            if (node.getValue() < res.getValue()) {
                res = node;
            }
        }
        openList.remove(res);
        return res;
    }




}
