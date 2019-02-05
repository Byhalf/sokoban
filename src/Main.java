import utulities.*;
import modele.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{

        String filePath1 = "src/levels/lvl.xsb";
        String levels = FileParser.parse(filePath1);
        LevelMaker test = new LevelMaker(levels);
        String level = test.getLevelAsString(1);
        System.out.println(level);
        State etat  = new State(level);
        System.out.println(etat.getDim(level)[0]);
        System.out.println(etat.getDim(level)[1]);

    }
}
