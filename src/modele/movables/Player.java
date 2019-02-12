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

    public boolean isPossible(State tab,int x,int y,char d){
        if (!super.isPossible(tab,x,y)) {
            for (Box m:tab.movables) {
                if (m.x == this.testx && m.y == this.testy) {
                    m.deplacement(d);
                    if(m.isPossible(tab,x,y)){
                        this.x=this.testx;
                        this.y=this.testy;
                        return false;
                    }
                }
            }
        }
        this.testx=this.x;
        this.testy=this.y;
        return false;
            //if( m.mur(tab,x,y)==true){
             //   if(m.x,m.y)
               // return m.x,m.y,m.x,m.y;
          //  }
            //else{

          //  }
        //}
    }

}