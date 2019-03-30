package games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends JFrame implements KeyListener {

    private Panneau pan = new Panneau();

    public Fenetre() {
        this.setTitle("Sokoban");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        //JPanel pan = new JPanel();
        this.setBackground(Color.WHITE);
        this.setContentPane(pan);
        this.addKeyListener(this);
        this.setVisible(true);
        //go();
    }

    public void keyPressed(KeyEvent key) {

        int codeDeLaTouche = key.getKeyCode();

        switch (codeDeLaTouche) {
            case KeyEvent.VK_UP:
                pan.up();
                this.repaint();
                break;
            case KeyEvent.VK_DOWN:
                pan.down();
                this.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                pan.right();
                this.repaint();
                break;
            case KeyEvent.VK_LEFT:
                pan.left();
                this.repaint();
                break;
        }
    }

    public void keyReleased(KeyEvent key) {
    }

    public void keyTyped(KeyEvent key) {
    }

	/*private void go(){
		for(;;){
			int x = pan.getPosX(), y = pan.getPosY();
			x++;
			y++;
			pan.setPosX(x);
			pan.setPosY(y);
			pan.repaint();
			try {
				Thread.sleep(7);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			if(x == pan.getWidth() || y == pan.getHeight()){
				pan.setPosX(-50);
				pan.setPosY(-50);
			}
		}
	}*/
}