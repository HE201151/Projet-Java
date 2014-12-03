package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import toucheCoule.FenetreAccueil;
import toucheCoule.FenetreJeu;

public class DemarrerAction extends AbstractAction {
	private FenetreAccueil fenetre;
	
	public DemarrerAction(FenetreAccueil fenetre, String texte){
		super(texte);		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		FenetreJeu frame = new FenetreJeu();
		frame.setVisible(true);
		fenetre.dispose(); 
	} 
}