package games;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent; 
 
public class Panneau extends JPanel { 

	private int posX = 50;
	private int posY = 50;

	/*public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		g.fillOval(posX, posY, 50, 50);
	}*/
	
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("/home/etudiants/21705826/Cours/tpa/test/games/index.png"));
			g.drawImage(img, posX, posY, 50, 50, this);
			//Pour une image de fond
			//g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}                
	} 

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
        
	public void up(){
		if(this.getPosY()>0){
			int y = this.getPosY();
			y=y-5;
			this.setPosY(y);
		}
	}
	
	public void down(){
		if(this.getPosY()<325){
			int y = this.getPosY();
			y=y+5;
			this.setPosY(y);
		}
	}
	
	public void right(){
		if(this.getPosX()<350){
			int x = this.getPosX();
			x=x+5;
			this.setPosX(x);
		}
	}

	public void left(){
		if(this.getPosX()>0){
			int x = this.getPosX();
			x=x-5;
			this.setPosX(x);
		}
	}
	
	/*public void paintComponent(Graphics g){
		try{
		Image img = ImageIO.read(new File("images.jpg"));
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawString("Tiens ! Le Site du Zéro !", 10, 20);
		System.out.println("Je suis exécutée !"); 
		g.fillOval(185, 175, 75, 75);
		}
		catch(IOException e){
		e.printStackTrace();
		}	
  	}*/              
}