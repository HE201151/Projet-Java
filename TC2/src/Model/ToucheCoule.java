/*
 * @author Romain Blan, Vogeleer Martin
 */


package Model;


import javax.swing.SwingUtilities;


public class ToucheCoule {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				FenetreAccueil fenetre = new FenetreAccueil();
				fenetre.setVisible(true);
			}
		});
	}
}