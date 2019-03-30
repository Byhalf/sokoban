package vue;

import modele.Modele;
import modele.movables.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JFrame implements KeyListener, ActionListener {
    Modele modele;
    JButton buttonCancel, buttonRestart;
    SokobanVue sokovue;
    JPanel pan;

    public Gui(Modele modele) {
        super("sokoban");
        this.modele = modele;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);

        setLayout(new BorderLayout());
        sokovue = new SokobanVue(modele);

        pan = new JPanel();
        pan.setLayout(new GridLayout(3, 1));

        buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(this);
        pan.add(buttonCancel);

        buttonRestart = new JButton("Restart");
        buttonRestart.addActionListener(this);
        pan.add(buttonRestart);

        sokovue.add(pan);
        add(sokovue, BorderLayout.CENTER);
        add(pan, BorderLayout.EAST);

        pack();
        setVisible(true);
        setFocusable(true); //pour le keylistener


    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == buttonCancel) {
            modele.annulDeplacement();
            this.requestFocus();
        } else if (obj == buttonRestart) {
            modele.resetLevel();
            this.requestFocus();
        }
    }
}
