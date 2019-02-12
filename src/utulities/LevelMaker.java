package utulities;
import modele.Case;
import java.awt.*;
import java.util.ArrayList;
import modele.*;
import modele.movables.Box;
import modele.movables.Player;

public class LevelMaker {
    int dimX = 0;
    int dimY = 0;
    private String level;
    Case[][] grid;
    Player player;
    ArrayList<Box> boxes = new ArrayList<Box>();



    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }


    public String getLevel(){
        return level;
    }

    public LevelMaker(Levels lvl,int lvlNbr){
        this.level = lvl.getLevelAsString(lvlNbr);
        setDim(getLevel());

    }




    public void setLevel (int lvlNbr){
        String lvl = getLevel();
        int x = getDimX();
        int y = getDimY();
        int counter = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {

                switch (lvl.charAt(counter)) {
                    case ' ':
                        grid[i][j] = Case.FLOOR;
                        break;
                    case '#':
                        grid[i][j] = Case.WALL;
                        break;
                    case '.':
                        grid[i][j] = Case.GOAL;
                        break;
                    case '@':
                        player = new Player(i,j);
                    case '$':
                        boxes.add(new Box(i,j));

                }
            }
            counter++;
        }

    }



    public void setDim(String lvl) {
        int height = 0;
        int width = 0;
        int counter = 0;
        for (char s : lvl.toCharArray()) {
            if (s != '\n') {
                counter += 1;
            } else {
                if (counter > width)
                    width = counter;
                counter = 0;
                height += 1;
            }
        }
        this.dimX= width;
        this.dimY= height;
    }

}
