package modele;
import java.util.ArrayList;
import modele.movables.*;
public class State {

    private Grid grid;
    private Player player;
    private ArrayList<Box> boxes = new ArrayList<Box>();
    public Grid getGrid() {
        return grid;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public State(Grid grid, ArrayList<Box> boxes, Player player){
        this.grid = grid;
        this.boxes= boxes;
        this.player = player;
    }






    public boolean isFinished(){
        boxes = this.boxes;
        for (Box box:boxes){
            if(this.grid.getCase(box.getX(),box.getY()) != Case.GOAL){
                return false;
            }
        }
        return true;
    }


}
