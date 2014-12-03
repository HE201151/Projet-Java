package action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import toucheCoule.FenetreAccueil;

public class AProposAction extends AbstractAction {
	private FenetreAccueil fenetre;
	
	public AProposAction(FenetreAccueil fenetre, String texte){
		super(texte);		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		JOptionPane.showMessageDialog(fenetre, "Ce programme a été développé par Vogeleer Martin et Blan Romain");
	} 
}