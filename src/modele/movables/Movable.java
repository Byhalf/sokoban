package modele.movables;

import modele.*;

public abstract class Movable{
    public int x;
    public int y;
    public int testx;
    public int testy;

    public Movable(int x,int y){
        this.x=x;
        this.y=y;
        this.testx=x;
        this.testy=y;
    }

    public void deplacement(char d){
        switch(d){
            case 'l':
                this.testx-=1;
                break;
            case 'r':
                this.testx+=1;
                break;
            case 'u':
                this.testy-=1;
                break;
            case 'd':
                this.testy+=1;
                break;
        }

    }

    public boolean isPossible(State tab,int x,int y){
        Case[][] grid = tab.getGrid();
        if (grid[x][y]==Case.WALL){
            return false;
        }
        return true;

    }
}