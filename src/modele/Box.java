public class Box extends ObjetsDeplacables{
    public int x;
    public int y;

    public void déplacement(char deplacement){
        super(deplacement);
    }

    public boolean mur(State tab,int x,int y){
        super(tab,x,y);
    }

    public Box(int x,int y){
        this.x=x;
        this.y=y;
    }


}