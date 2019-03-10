package vue;

import modele.State;
import modele.movables.Direction;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JFrame implements KeyListener {
    State state;
    public Gui(State state){
        super("sokoban");
        this.state = state;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        setLayout(new BorderLayout());
        SokobanVue sokovue = new SokobanVue(state);
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
            state.deplacement(Direction.R);
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            state.deplacement(Direction.L);
        }else if (e.getKeyCode() == KeyEvent.VK_UP){
            state.deplacement(Direction.U);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            state.deplacement(Direction.D);
        }
    }
}
