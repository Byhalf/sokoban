public class Player extends ObjetsDeplacables{
    public int x;
    public int y;

    public void déplacement(char deplacement){
        super(deplacement);
    }

    public Player(int x,int y){
        this.x=x;
        this.y=y;
    }

    public boolean box(State tab,int x,int y){
        if (player.x,player.y== box.x,box.y){
            Box.déplacement(deplacement);
            if( Box.mur(tab,x,y)==true){
                return box.x,box.y,player.x,player.y;
            }
            else{

            }
        }
    }

}