package utulities;
import modele.Case;
import java.awt.*;
import java.util.ArrayList;
import modele.*;
import modele.movables.Box;
import modele.movables.Player;

public class LevelMaker {
    private int dimX = 0;
    private int dimY = 0;
    private String level;
    private Case[][] grid;
    private Player player;
    private ArrayList<Box> boxes = new ArrayList<Box>();



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




    public State setLevel (int lvlNbr){
        String lvl = getLevel();
        int x = getDimX();
        int y = getDimY();

        // problème, le \n compte comme un caractère? à tester brouillon a simplifier
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {

                switch (lvl.charAt(i+j*i)) {
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
                        break;
                    case '$':
                        boxes.add(new Box(i,j));
                        break;

                }
            }

        }
        return new State(new Grid(grid),boxes,player);

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
