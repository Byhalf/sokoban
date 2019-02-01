package modele.movables;

import modele.*;
public class Player extends Movable{
    public int x;
    public int y;
    public int testx;
    public int testy;

    public void deplacement(char d){
        super.deplacement(d);
    }

    public Player(int x,int y){
        super(x,y);
    }

    public boolean box(State tab,int x,int y,char d){
        for (Movable m:tab.movables) {
            if (m.x == this.testx && m.y == this.testy) {
                m.deplacement(d);
            }
        }
            //if( m.mur(tab,x,y)==true){
             //   if(m.x,m.y)
               // return m.x,m.y,m.x,m.y;
          //  }
            //else{

          //  }
        //}
    }

}