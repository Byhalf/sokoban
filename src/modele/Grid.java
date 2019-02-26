package modele;

import utulities.LevelMaker;

public class Grid {
    Case[][] grid;
    public Grid(Case[][] grid){
        //peut être changer ça je trouve ça bizare
        this.grid = grid;
    }
    public Case getCase(int x, int y){
        return grid[x][y];
    }
}
