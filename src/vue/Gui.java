package vue;

import modele.State;
import modele.movables.Direction;
import modele.Modele;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JFrame implements KeyListener {
    Modele modele;
    SokobanVue sokovue;
    public Gui(Modele modele){
        super("sokoban");
        this.modele = modele;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        setLayout(new BorderLayout());
        sokovue = new SokobanVue(modele);
        add(sokovue,BorderLayout.CENTER);
        pack();
        setVisible(true);
        setFocusable(true); //pour le keylistener


    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyReleased(KeyEvent e){
    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            modele.deplacement(Direction.R);
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            modele.deplacement(Direction.L);
        }else if (e.getKeyCode() == KeyEvent.VK_UP){
            modele.deplacement(Direction.U);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            modele.deplacement(Direction.D);
        }
    }
}
