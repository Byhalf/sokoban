public class abstract ObjetsDeplacables{
    public int x;
    public int y;


    public void déplacement(char deplacement){
        switch(deplacement){
            case left;
                this.x=-1;
                break;
            case right;
                this.x=+1;
                break;
            case up;
                this.y=-1;
                break;
            case down;
                this.y=+1;
                break;
        }

    }
    public ObjetsDeplacables(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean mur(State tab,int x,int y){
        if (tab[x][y]==Case.WALL){
            return false;
        }
        else return true;
    }
}