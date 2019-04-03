package vue;

import modele.Modele;
import modele.movables.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe creant les elements graphiques autour du niveau de jeu tel que les boutons
 */
public class GameVue extends JPanel implements KeyListener, ActionListener {
    Modele modele;
    JButton buttonCancel, buttonRestart, buttonMenu, buttonAI;
    SokobanVue sokovue;
    JPanel pan;
    GUI gui;

    /**
     * Constructeur des Objets exterieur au jeu
     * @param modele Modele du jeu
     * @param gui Interface graphique du Jeu
     */
    public GameVue(Modele modele, GUI gui) {
        this.gui = gui;
        this.modele = modele;
        this.addKeyListener(this);

        setLayout(new BorderLayout());
        sokovue = new SokobanVue(modele);

        pan = new JPanel();
        pan.setLayout(new GridLayout(4, 1));

        buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(this);
        pan.add(buttonCancel);

        buttonRestart = new JButton("Restart");
        buttonRestart.addActionListener(this);
        pan.add(buttonRestart);

        buttonMenu = new JButton("Menu");
        buttonMenu.addActionListener(this);
        pan.add(buttonMenu);

        buttonAI = new JButton("AI");
        buttonAI.addActionListener(this);
        pan.add(buttonAI);

        sokovue.add(pan);
        add(sokovue, BorderLayout.CENTER);
        add(pan, BorderLayout.EAST);

        setFocusable(true);
        setVisible(true);
    }

    /**
     * Detecte quand une touche est enfoncee
     * @param e Touche enfoncee
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Detecte quand une touche est relachee
     * @param e Touche relachee
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Detecte et traduit pour le modele la touche appuyee
     * @param e Touche appuyée
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            modele.deplacement(Direction.R);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            modele.deplacement(Direction.L);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            modele.deplacement(Direction.U);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            modele.deplacement(Direction.D);
        }
    }

    /**
     * Effectue l'action venant d'un bouton
     * @param e Objet appuye
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == buttonCancel) {
            modele.annulDeplacement();
            this.requestFocus();
        } else if (obj == buttonRestart) {
            modele.resetLevel();
            this.requestFocus();
        } else if (obj == buttonMenu) {
            gui.showMenu();
        } else if (obj == buttonAI) {
            this.requestFocus();
        }
    }
}
