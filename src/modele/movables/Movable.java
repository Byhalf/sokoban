package modele.movables;

import modele.*;

public abstract class Movable{
    private int x;
    private int y;


    public Movable(int x,int y){
        this.x=x;
        this.y=y;

    }

    public void deplacement(Direction d){
        switch(d){
            case L:
                this.x-=1;
                break;
            case R:
                this.x+=1;
                break;
            case U:
                this.y-=1;
                break;
            case D:
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
        Grid grid = tab.getGrid();
        return!(grid.getCase(x1,y1)==Case.WALL);


    }
}