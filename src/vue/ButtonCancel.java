package vue;

import modele.*;
import javax.swing.*;
import java.awt.*;

public class ButtonCancel extends JButton implements ActionListener {
	protected Modele modele;
	
	public ButtonCancel(Modele modele){
		super("modele");
		this.modele = modele;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		modele.annulDeplacement();
	}
}
