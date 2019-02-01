package utulities;
import modele.Case;
import java.awt.*;
import java.util.ArrayList;

public class LevelMaker {


    private String[] levelsList;

    public LevelMaker(String levels){
        this.levelsList = this.splitLevels(levels);
    }

    public static String[] splitLevels(String levels){
        return levels.split(";.*");
    }

    public String[] getLevelsList() {
        return levelsList;
    }


    public String getLevelAsString(int n){
        return getLevelsList()[n-1];
    }

}
