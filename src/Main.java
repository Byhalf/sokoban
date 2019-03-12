import utulities.*;
import modele.*;
import java.util.Arrays;
import java.util.ArrayList;

import vue.*;
public class Main {
    public static void main(String[] args) throws Exception{

        String filePath1 = "src/levels/lvl.xsb";
        String levels = FileParser.parse(filePath1);

        //LevelMaker est composé de méthode static
        State state = LevelMaker.setLevel(levels,3);

        Gui sokoGui = new Gui(state);






    }
}
