import intelligence.AstarAlgo;
import intelligence.AstarGrid;
import intelligence.Node;
import modele.Modele;
import utulities.FileParser;
import utulities.LevelMaker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        String filePath1 = "src/levels/lvl.xsb";
        String levels = FileParser.parse(filePath1);

        //LevelMaker est composé de méthode static
        /*
        SokobanVue.initializeResource();
        new GUI(levels);

        */
        Modele modeleTest = new Modele(LevelMaker.setLevel(levels, 3));
        AstarGrid gridTest = new AstarGrid(modeleTest.getState());
        gridTest.showToDel();


        AstarAlgo astarAlgo = new AstarAlgo(new Node(2, 1), new Node(5, 1));
        Node endNode = astarAlgo.algoStart(gridTest);
        ArrayList<Node> path = astarAlgo.getPath(endNode);
        for (Node node : path) {
            System.out.println(node);
        }
        System.out.println(path.size());


    }
}
