package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import toucheCoule.FenetreAccueil;

public class RegleAction extends AbstractAction {
	private FenetreAccueil fenetre;
	
	public RegleAction(FenetreAccueil fenetre, String texte){
		super(texte);		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		JOptionPane.showMessageDialog(fenetre, "Voici les règles trolololol");
	} 
}