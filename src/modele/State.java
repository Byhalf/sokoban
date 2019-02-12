package modele;
import java.util.ArrayList;
import modele.movables.*;
public class State {

    Grid grid;
    Player player;
    ArrayList<Box> boxes = new ArrayList<Box>();


    public State(Grid grid, ArrayList<Box> boxes, Player player){
        this.grid = grid;
        this.boxes= boxes;
        this.player = player;
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
