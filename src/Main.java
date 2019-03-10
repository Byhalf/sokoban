import utulities.*;
import modele.*;
import java.util.Arrays;
import vue.*;
public class Main {

    public static void main(String[] args) throws Exception{
        String filePath1 = "src/levels/lvl.sxb";
        String levels = FileParser.parse(filePath1);
        Levels levels_list = new Levels(levels);
        LevelMaker state = new LevelMaker(levels_list,1);
        State etat = state.setLevel(1);


    }
}
