import utulities.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{

        String filePath1 = "/home/gareth/IdeaProjects/sokoban/src/levels/lvl.xsb";
        String levels = FileParser.parse(filePath1);
        //System.out.println(FileParser.parse(filePath1));
        String[] levelSplit = LevelMaker.splitLevels(levels);
        System.out.println(Arrays.toString(levelSplit));
        //LevelMaker test = new LevelMaker(levels);
        //System.out.println(Arrays.toString(test.getLevelsList()));
    }
}
