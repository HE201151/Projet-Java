/*
 * @author Romain Blan, Vogeleer Martin
 */


package Model;


import javax.swing.SwingUtilities;

import Controleur.Controleur;
import View.FenetreAccueil;

public class LancementJeu {
	private Controleur controleur = new Controleur();
	
	public Controleur getControleur() {
		return controleur;
	}
	
	public static void main(String[] args){
			LancementJeu tc = new LancementJeu();
			tc.getControleur().lancerFenetreAccueil(tc);
	}
}