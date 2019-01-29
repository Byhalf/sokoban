package utulities;
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

    public int[] getDim(int lvlNbr){
        String lvl = getLevelAsString(lvlNbr);
        int dim[] = new int[2];
        int height = 0;
        int width = 0;
        int counter = 0;
        for(char s:lvl.toCharArray()){
            if(s!='\n'){
                counter +=1;
            }else{
                if (counter>width)
                        width = counter;
                counter = 0;
                height += 1;
            }
        }

        dim[0]=width;
        dim[1]=height;
        return dim;

    }

    public char[][] makeGameGrid(int lvlNbr){
        int x = getDim(lvlNbr)[0];
        int y = getDim(lvlNbr)[1];
        char grid[][] = new char[x][y];
        String lvl = getLevelAsString(lvlNbr);
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if (lvl.charAt(j)!='\n'){
                    grid[i][j] = lvl.charAt(j);
                }else break;
            }
        }

        return grid;
    }

}
