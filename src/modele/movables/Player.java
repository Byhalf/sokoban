package modele.movables;

import modele.*;

public class Player extends Movable{
    private int x;
    private int y;


    public void deplacement(Direction d){
        super.deplacement(d);
    }

    public Player(int x,int y){
        super(x,y);
    }

    @Override
    public boolean isPossible(State tab,Direction d) {
        int x1 = x;
        int y1 = y;
        if (super.isPossible(tab, d)) {
            for (Box m : tab.getBoxes()) {
                if (m.getX() == x1 && m.getY() == y1) {
                    m.isPossible(tab, d);
                }
            }

        }
        return true;
    }
//    public boolean isPossible(State tab,int x,int y,char d){
//        if (!super.isPossible(tab,x,y)) {
//            for (Box m:tab.movables) {
//                if (m.x == this.testx && m.y == this.testy) {
//                    m.deplacement(d);
//                    if(m.isPossible(tab,x,y)){
//                        this.x=this.testx;
//                        this.y=this.testy;
//                        return false;
//                    }
//                }
//            }
//        }
//        this.testx=this.x;
//        this.testy=this.y;
//        return false;
            //if( m.mur(tab,x,y)==true){
             //   if(m.x,m.y)
               // return m.x,m.y,m.x,m.y;
          //  }
            //else{

          //  }
        //}


}