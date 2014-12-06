package Controleur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Model.FenetreAccueil;
import View.ViewPlacement;

public class DemarrerAction extends AbstractAction {
	private FenetreAccueil fenetre;
	
	public DemarrerAction(FenetreAccueil fenetre, String texte){
		super(texte);		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		ViewPlacement frame = new ViewPlacement();
		frame.setVisible(true);
		fenetre.dispose(); 
	} 
}