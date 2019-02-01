package modele;
import java.util.ArrayList;
public class State {
    String lvl;

    public Case[][] getGrid() {
        return grid;
    }

    Case[][] grid;
    ArrayList<Box> boxes = new ArrayList<Box>();


    public State(String lvl){
        this.lvl = lvl;
        this.grid = this.makeGameGrid(lvl);
    }
    public int[] getDim(String lvl) {
        int dim[] = new int[2];
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
        dim[0]= width;
        dim[1]= height;
        return dim;
    }

        public Case[][] makeGameGrid (String lvl){
            int[] dim = this.getDim(lvl);
            int x = dim[0];
            int y = dim[1];
            Case grid[][] = new Case[x][y];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    switch (lvl.charAt(j)) {
                        case ' ':
                            grid[i][j] = Case.FLOOR;
                            break;
                        case '#':
                            grid[i][j] = Case.WALL;
                            break;
                        case '.':
                            grid[i][j] = Case.GOAL;
                            break;

                    }

                }
            }
            return grid;
        }

        public boolean isFinished(){
            boxes = this.boxes;
            for (Box box:boxes){
                if(grid[box.x][box.y] != Case.GOAL){
                    return false;
                }
            }
            return true;
        }


        }
