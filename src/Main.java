import intelligence.Intelligence;
import modele.Modele;
import utulities.FileParser;
import utulities.LevelMaker;
import vue.SokobanVue;

/**
 * @author KLAEYLE Pierre-Louis, LAFAY Gareth, MIALON Laurine, JAROSSAY Max
 */
public class Main {
    public static void main(String[] args) throws Exception {

        String filePath1 = "src/levels/lvl.xsb";
        String levels = FileParser.parse(filePath1);

        //LevelMaker est composé de méthode static

        SokobanVue.initializeResource();
        //new GUI(levels);

        Modele modele = new Modele(LevelMaker.setLevel(levels, 3));

        Intelligence intelligence = new Intelligence(modele);
        System.out.println(intelligence.basicIntelligence());

    }
}
