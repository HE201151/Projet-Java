package Controleur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import View.ViewJeu;
import View.ViewPlacement;

public class GoAction extends AbstractAction {
	private ViewPlacement fenetre;
	
	public GoAction(ViewPlacement fenetre, String texte){
		super(texte);		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		ViewJeu frame = new ViewJeu();
		frame.setVisible(true);
		fenetre.dispose(); 
	} 
}