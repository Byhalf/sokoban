import modele.Modele;
import modele.State;
import utulities.FileParser;
import utulities.LevelMaker;
import vue.Gui;
import vue.SokobanVue;

public class Main {
    public static void main(String[] args) throws Exception {

        String filePath1 = "src/levels/lvl.xsb";
        String levels = FileParser.parse(filePath1);

        //LevelMaker est composé de méthode static

        SokobanVue.initializeResource();
        State state = LevelMaker.setLevel(levels, 3);
        Modele modele = new Modele(state);
        Gui sokoGui = new Gui(modele);


    }
}
