package modele;

import modele.movables.Box;
import modele.movables.Direction;
import modele.movables.Player;
import utulities.AbstractModeleEcouteur;

import java.util.ArrayList;

/**
 * Classe de l'Etat du jeu
 */
public class State extends AbstractModeleEcouteur {

    private Grid grid;
    private Player player;
    private ArrayList<Box> boxes;

    /**
     * Constructeur de l'Etat du jeu
     * @param grid Grille de jeu
     * @param boxes Boites à déplacer
     * @param player Joueur
     */
    public State(Grid grid, ArrayList<Box> boxes, Player player) {
        this.grid = grid;
        this.boxes = boxes;
        this.player = player;
    }

    /**
     * Retourne la grille de Jeu
     * @return Grille de jeu
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Retourne les informations du joueur
     * @return Informations sur le joueur
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Retourne la liste des Boites à déplacer
     * @return Liste des boites à déplacer
     */
    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    /**
     * Effectue le déplacement d'un Joueur ou plus
     * @param d Direction (LEFT,RIGHT,UP,DOWN)
     * @return Nouvel état de jeu avec le déplacement effectué
     */
    public State deplacement(Direction d) {
        State newState = getCopy(this);
        newState.getPlayer().deplacement(newState, d);
        return newState;
    }

    /**
     * Détermine si le jeu est fini
     * @return Booléen indiquant si le jeu est fini
     */
    public boolean isFinished() {
        boxes = this.boxes;
        for (Box box : boxes) {
            if (this.grid.getCase(box.getX(), box.getY()) != Case.GOAL) {
                return false;
            }
        }

        return true;
    }

    /**
     * Copie l'état actuel pour ensuite en créer un nouveau
     * @param state Etat actuel
     * @return Nouvel Etat de jeu
     */
    public State getCopy(State state) {
        ArrayList<Box> newBoxes = new ArrayList<Box>();
        for (Box box : boxes) {
            Box newBox = new Box(box.getX(), box.getY());
            newBoxes.add(newBox);
        }
        Player newPlayer = new Player(player.getX(), player.getY());
        return new State(getGrid(), newBoxes, newPlayer);
    }


}
