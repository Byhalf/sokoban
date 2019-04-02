package modele.movables;

import modele.State;

/**
 * Classe des boites déplacables
 */
public class Box extends Movable {
    /**
     * Constructeur d'une boite
     * @param x Coordonnée x
     * @param y Coordonée y
     */
    public Box(int x, int y) {
        super(x, y);

    }

    /**
     * Définit si le coup est possible
     * @param tab Etat du jeu actuellement
     * @param d Direction (LEFT,RIGHT,UP,DOWN)
     * @return
     */
    public boolean isPossible(State tab, Direction d) {
        int x = getX();
        int y = getY();
        int[] coord = nextMove(x, y, d);
        int x1 = coord[0];
        int y1 = coord[1];
        if (super.isPossible(tab, d)) {
            for (Box b : tab.getBoxes()) {
                if (b.getX() == x1 && b.getY() == y1) {
                    return false;
                }
            }
            return true;
        } else
            return false;

    }


}