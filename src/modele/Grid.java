package modele;

import utulities.LevelMaker;

public class Grid {
    Case[][] grid;

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    int dimX;
    int dimY;
    public Grid(Case[][] grid,int dimX,int dimY){
        //peut être changer ça je trouve ça bizare
        this.grid = grid;
        this.dimX = dimX;
        this.dimY = dimY;
    }
    public Case getCase(int x, int y){
        return grid[x][y];
    }
}
