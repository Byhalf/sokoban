package modele.movables;

import modele.*;
import utulities.AbstractModeleEcouteur;

public abstract class Movable extends AbstractModeleEcouteur {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNum_coup() {
        return num_coup;
    }

    private int num_coup = 0;

    public void increment_num_coup(){
        num_coup++;
    }
    public void decrement_num_coup(){
        num_coup--;
    }

    @Override
    public String toString(){
        return "x"+ getX() + "y" +getY();
    }
    public Movable(int x,int y){
        this.x=x;
        this.y=y;

    }

    public void deplacement(State s,Direction d){
        if(this.isPossible(s,d)){
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
            fireChangement();
        }

    }
    public int[] nextMove(int x, int y,Direction d){
        int x1= x;
        int y1= y;
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
        int[] coord;
        coord = new int[2];
        coord[0]=x1;
        coord[1]=y1;
        return coord;
    }

    public boolean isPossible(State tab,Direction d){
        int[] coord = nextMove(x,y,d);
        int x1=coord[0];
        int y1=coord[1];
        if(x1>=tab.getGrid().getDimX() || y1>=tab.getGrid().getDimY()
        ||x1<0||y1<0)
            return false;

        Grid grid = tab.getGrid();
        return (grid.getCase(x1,y1)!=Case.WALL);


    }
}