package games;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent; 

public class Fenetre extends JFrame implements KeyListener{

	private Panneau pan = new Panneau();

	public Fenetre(){
		this.setTitle("Sokoban");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		//JPanel pan = new JPanel();
		//pan.setBackground(Color.YELLOW);
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(this);
		//go();
	}

	public void keyPressed(KeyEvent key) {
		
		int codeDeLaTouche = key.getKeyCode();
         
        	switch (codeDeLaTouche){
		 	case KeyEvent.VK_UP :
				pan.up();
				pan.repaint();
				break;
			case KeyEvent.VK_DOWN :
				pan.down();
				pan.repaint();
				break;
			case KeyEvent.VK_RIGHT :
				pan.right();
				pan.repaint();
				break;
			case KeyEvent.VK_LEFT :
				pan.left();
				pan.repaint();
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