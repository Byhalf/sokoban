package intelligence;

import modele.Modele;
import modele.movables.Box;
import modele.movables.Direction;

import java.util.ArrayList;

public class Intelligence {
    AstarGrid basicGrid;
    //ArrayList<Box> boxes;
    ArrayList<Node> goals;
    Modele modele;
    //Player player;

    public Intelligence(Modele modele) {
        //basicGrid = sans les movables
        basicGrid = new AstarGrid(modele.getState());
        goals = basicGrid.getGoals();


    }

    public boolean basicIntelligence() {
        ArrayList<Direction> pathToTake = new ArrayList<>();

        if (!movableBoxes())
            return false;
        ArrayList<BoxPath> boxesPaths = possibleHeuristicPaths();
        //possibleHeuristicPaths apelle basicPathToBox qui remplit l'array playerPaths.
        if (boxesPaths == null)
            return false;
        for (BoxPath boxPath : boxesPaths) {
            AstarAlgo algo = new AstarAlgo(new Node(modele.getState().getPlayer()), boxPath.getPlayerPosition());
            Node endNode = algo.algoStart(basicGrid.movableToUnmovable());
            if (endNode == null)
                return false;
            pathToTake = getDirection(algo.getPath(endNode), new Node(modele.getState().getPlayer()));
            pathToTake.addAll(getDirection(boxPath.getPath(), boxPath.getBox()));
            makeMoves(pathToTake);
        }
        return true;



    }

    /**
     * Ajoute les chemins(paths) trouvé vers les caisse à playerPath.
     *
     * @return un AstarGrid où si le joueur ne peut pas accéder à un endroit à coté d'une boite,
     * cet endroit devient "bloqué" pour l'algorithme si on passe cet AstarGrid en paramêtre
     */
    public AstarGrid basicPathToBoxes() {
        AstarGrid newGrid = basicGrid.movableToUnmovable();
        Node playerPos = new Node(modele.getState().getPlayer().getX(), modele.getState().getPlayer().getY());
        for (Box box : modele.getState().getBoxes()) {
            ArrayList<Node> neighbours = newGrid.getNeighbourNodes(box);
            for (Node neighbour : neighbours) {
                AstarAlgo algo = new AstarAlgo(playerPos, neighbour);
                Node endNode = algo.algoStart(newGrid);
                ArrayList<Node> path = algo.getPath(endNode);
                if (path.size() == 0)
                    newGrid.getBoolGrid()[neighbour.getX()][neighbour.getY()] = false;

            }
        }
        return newGrid;
    }

    public ArrayList<BoxPath> possibleHeuristicPaths() {
        ArrayList<BoxPath> res = null;
        ArrayList<BoxGoalCouples> pairs = heuristicBoxGoals();
        AstarGrid unMovablesUnaccessible = basicPathToBoxes();
        for (BoxGoalCouples pair : pairs) {
            AstarAlgo algo = new AstarAlgo(pair.getBox(), pair.getGoal());
            Node endNode = algo.algoStart(unMovablesUnaccessible);
            ArrayList<Node> path = algo.getPath(endNode);
            if (path.size() == 0)
                return null;
            res.add(new BoxPath(pair.getBox(), pair.getGoal(), path));
        }
        return res;

    }
/*
    public ArrayList<ArrayList<Node>> possiblePaths() {
        ArrayList<Box> tempBoxes = new ArrayList<>(boxes);
        ArrayList<Node> tempGoals = new ArrayList<>(goals);
        AstarGrid unMovablesUnaccessible = basicPathToBoxes();
        ArrayList<ArrayList<Node>> res = new ArrayList<>();
        for(Box box:tempBoxes){
            for(Node goal:tempGoals){
                AstarAlgo algo = new AstarAlgo(new Node(box.getX(),box.getY()), goal);
                Node endNode = algo.algoStart(unMovablesUnaccessible);
                ArrayList<Node> path = algo.getPath(endNode);
                if(path.size()!=0){
                    tempGoals.remove(goal);
                    res.add(path);
                }elif()

            }
        }
        return null;
    }
    */


    public ArrayList<BoxGoalCouples> heuristicBoxGoals() {
        ArrayList<BoxGoalCouples> res = new ArrayList<>();
        ArrayList<Node> newGoals = new ArrayList<>(goals);
        for (Box box : modele.getState().getBoxes()) {
            Node boxNode = new Node(box);
            int compare = 0;
            Node bestGoal = null;
            for (Node goal : newGoals) {
                if (Node.getHeuristicDistanceBetween(goal, boxNode) > compare) {
                    compare = Node.getHeuristicDistanceBetween(goal, boxNode);
                    bestGoal = goal;
                }
            }
            res.add(new BoxGoalCouples(boxNode, bestGoal));
            newGoals.remove(bestGoal);
        }
        return res;
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
        for (Box box : modele.getState().getBoxes()) {
            //inférieur ou égal à 1 car il faut 2 espace libre pour pousser une caisse
            if (basicGrid.getNeighbourNodes(box).size() <= 1 && !modele.getState().isOnGoal(box))
                return false;
        }
        return true;
    }

    public void makeMoves(ArrayList<Direction> directions) {
        for (Direction d : directions) {
            try {
                Thread.sleep(500);
                modele.deplacement(d);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }


}
