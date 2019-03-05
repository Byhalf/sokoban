package vue;
import modele.Case;
import modele.Grid;
import modele.State;
import modele.movables.Box;
import modele.movables.Movable;
import modele.movables.Player;
import utulities.EcouteurModele;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SokobanVue extends JPanel implements EcouteurModele {
    public static final int LARGEUR_CASE = 30;
    public static final int HAUTEUR_CASE = 30;
    private State state;
    private Grid grid;
    private int dimX;
    private int dimY;
    private Movable source;

    SokobanVue(State state){
        this.state = state;
        this.grid = state.getGrid();
        this.dimX = grid.getDimX();
        this.dimY = grid.getDimY();
        state.ajoutEcouteur(this);

        setPreferredSize(new Dimension(LARGEUR_CASE*dimX,HAUTEUR_CASE*dimY));
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        innnit_level(g);
        paint_movable(g,this.source);

    }

    public void innnit_level(Graphics g){

        for(int i=0;i<dimX;i++){
            for(int j=0;j<dimY;j++){
                if(grid.getCase(i,j)== Case.FLOOR){
                    g.setColor(Color.LIGHT_GRAY);
                }else if(grid.getCase(i,j)==Case.WALL){
                    g.setColor(Color.BLACK);
                }else if(grid.getCase(i,j)==Case.GOAL){
                    g.setColor(Color.GREEN);
                }
                g.fillRect(i*LARGEUR_CASE,j*HAUTEUR_CASE,LARGEUR_CASE,HAUTEUR_CASE);
            }
        }
    }
    //les 2 méthode qui suivent dans le tp il prennait un truc qui renvoyé un state la on ne fait que le modifié
    public void paint_movable(Graphics g,Movable movable){

        int x = movable.getX()*LARGEUR_CASE;
        int y = movable.getY()*HAUTEUR_CASE;
        if (movable instanceof Player)
            g.setColor(Color.BLUE);
        if (movable instanceof Box)
            g.setColor(Color.ORANGE);
        g.fillRect(x,y,LARGEUR_CASE,HAUTEUR_CASE);

    }



    @Override
    public void modeleMisAJour(Object source){
        this.source = (Movable) source;
        this.repaint();
        this.revalidate();
    }

}
