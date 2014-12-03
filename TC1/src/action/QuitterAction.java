package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import toucheCoule.FenetreAccueil;

public class QuitterAction extends AbstractAction {
	private FenetreAccueil fenetre;
	
	public QuitterAction(FenetreAccueil fenetre, String texte){
		super(texte);		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		System.exit(0);
	} 
}