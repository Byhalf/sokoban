package intelligence;

import modele.Modele;
import modele.movables.Box;
import modele.movables.Direction;

import java.util.ArrayList;

public class Intelligence {
    AstarGrid basicGrid;
    ArrayList<Box> boxes;
    ArrayList goals;
    Modele modele;

    public Intelligence(Modele modele) {
        //basicGrid = sans les movables
        basicGrid = new AstarGrid(modele.getState());
        boxes = modele.getState().getBoxes();
        goals = basicGrid.getGoals();

    }

    public ArrayList<Direction> getDirection(ArrayList<Node> path, Node start) {
        ArrayList<Direction> directions = new ArrayList<>();
        for (Node node : path) {
            if (node.getX() == start.getX() - 1)
                directions.add(Direction.L);
            else if (node.getX() == start.getX() + 1)
                directions.add(Direction.R);
            else if (node.getY() == start.getY() + 1)
                directions.add(Direction.D);
            else if (node.getY() == start.getY() - 1)
                directions.add(Direction.U);
            start = node;
        }
        return directions;
    }

    public boolean movableBoxes() {
        for (Box box : boxes) {
            //inférieur ou égal à 1 car il faut 2 espace libre pour pousser une caisse
            if (basicGrid.getNeighbourNodes(box).size() <= 1 && !modele.getState().isOnGoal(box))
                return false;
        }
        return true;
    }


}
