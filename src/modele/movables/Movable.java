package modele.movables;

import modele.*;

public abstract class Movable{
    public int x;
    public int y;


    public Movable(int x,int y){
        this.x=x;
        this.y=y;

    }

    public void deplacement(char d){
        switch(d){
            case 'l':
                this.x-=1;
                break;
            case 'r':
                this.x+=1;
                break;
            case 'u':
                this.y-=1;
                break;
            case 'd':
                this.y+=1;
                break;
        }

    }

    public boolean isPossible(State tab,Direction d){
        int x1=this.x;
        int y1=this.y;
        switch(d){
            case L:
                x1-=1;
                break;
            case R:
                x1+=1;
                break;
            case U:
                y1-=1;
                break;
            case D:
                y1+=1;
                break;
        }
        Case[][] grid = tab.getGrid();
        if (grid[x1][y1]==Case.WALL){
            return false;
        }
        return true;

    }
}