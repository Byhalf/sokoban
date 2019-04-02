package intelligence;

import java.util.ArrayList;

public class AstarAlgo {
    private ArrayList<Node> openList = new ArrayList<>();
    private ArrayList<Node> closedList = new ArrayList<>();
    private Node start;
    private Node end;

    public AstarAlgo(Node start, Node end) {
        this.start = start;
        this.end = end;
        start.setValue(0);
        openList.add(start);
    }

    public void algoStart(AstarGrid grid) {
        while (openList.size() > 0) {
            Node q = popMinFromList(openList);
            ArrayList<Node> neighbors = grid.getNeighbourNodes(q);
            for (Node neighbor : neighbors) {
                neighbor.setParent(q);
                if (neighbor.compare(end)) {
                    break;
                    //stop search sur l'aglo a voir push puis return?
                }
                neighbor.setDistanceEnd(end);
                int distanceStart = q.getDistanceStart() + 1; //distance forcément de 1
                neighbor.setDistanceStart(distanceStart);
                neighbor.setValue(distanceStart + neighbor.getDistanceEnd());

            }


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
