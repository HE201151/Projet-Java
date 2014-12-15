package Controleur;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Case;
import Model.Joueur;
import Model.LancementJeu;
import Socket.Client;
import Socket.Serveur;
import View.FenetreAccueil;
import View.ViewFinDuJeu;
import View.ViewJeu;
import View.ViewPlacement;

/*
 * La classe Controleur permet de faire un lien entre le logique et le graphique.
 */
public class Controleur {
	ViewJeu viewJeu; 
	FenetreAccueil fenetreAccueil;
	ViewPlacement viewPlacement;
	Joueur joueurCourant;
	Joueur joueurDistant;
	private LancementJeu tc;
	Client client;
	Serveur serveur;

	public ViewJeu getViewJeu() {
		return viewJeu;
	}

	public FenetreAccueil getFenetreAccueil() {
		return fenetreAccueil;
	}

	/*
	 * Instance de la classe.
	 * Création de nos deux joueurs.
	 */
	public Controleur(){
		joueurCourant = new Joueur();
		joueurDistant = new Joueur();
	}

	/*
	 *Cette méthode permet de placer un bateau sur la grille.
	 *@param coordonee Position de la première case du bateau choisie par l'utilisateur.
	 *@param  selection Numero du bateau à placer, choisis par l'utilisateur.
	 *@param alignement Sens (vertical-horizontal) dans lequel le bateau va être placé.
	 *@param grillePlacement Grille sur laquelle on va placer le bateau.
	 */
	public void placerBateau(int coordonee, int selection,JButton[][] grillePlacement, int alignement){
		joueurCourant.placerBateau(coordonee, selection, alignement, grillePlacement);
	}	

	/*
	 * Méthode qui permet à l'utilisateur de tirer sur une case. Si on touche un bateau, la case devient rouge, sinon devient grise.
	 * @param coordonee Position du tire.
	 * @param boutonAttaque JButton sur lequel on a appuyé
	 * @param numJoueur 1 est le joueur courant, 2 es le joueur distant
	 * @param tc Base de données du jeu
	 */
	public void attaquer(int coordonee, ActionEvent boutonAttaque, int numJoueur, LancementJeu tc) {
		boolean bateauTouche;
		this.tc=tc;
		if (numJoueur==1){
			bateauTouche=joueurCourant.bateauTouche(coordonee);
			if(bateauTouche){
				((Component) boutonAttaque.getSource()).setBackground(Color.RED);
				if(joueurCourant.estMort()){
					finDuJeu(tc);
				}
			}
			else ((Component) boutonAttaque.getSource()).setBackground(Color.DARK_GRAY);
		}
		if (numJoueur==2){
			bateauTouche=joueurDistant.bateauTouche(coordonee);
			if(bateauTouche){
				((Component) boutonAttaque.getSource()).setBackground(Color.RED);
				if(joueurDistant.estMort()){
					finDuJeu(tc);
				}
			}
			else ((Component) boutonAttaque.getSource()).setBackground(Color.DARK_GRAY);
		}
	}

	/*
	 * Méthode qui permet d'ouvrir la fenêtre de fin du jeu.
	 * @param tc Base de donée du jeu.
	 */
	private void finDuJeu(LancementJeu tc) {
		ViewFinDuJeu finJeu = new ViewFinDuJeu(tc);
		finJeu.setVisible(true);
	}

	/*
	 * Méthode qui permet de savoir si une case est libre. Si elle est occupée, on la met en bleu.
	 * @param bouton La case que l'on vérifie (grapique).
	 * @param Y Coordonnée Y.
	 * @param X Coordonnée X.
	 * @param numJoeur 2 est le joueur distant, 1 est le joueur courant.
	 */
	public void caseOccupee(JButton bouton, int Y, int X, int numJoueur){
		boolean libre = true;
		Case position = new Case(X,Y);	
		//if (numJoueur==2){
		//	libre=joueurDistant.caseLibre(position);
		//}
		if (numJoueur==1){
			libre=joueurCourant.caseLibre(position);
		}
		if(!libre){
			bouton.setBackground(Color.BLUE);
		}	
	}

	/*
	 * Méthode qui permet de réinitialiser la position des bateaux.
	 * @param grillePlacement La grille sur laquelle on place les bateaux
	 */
	public void resetAction(JButton[][] grillePlacement){
		int i,j;
		joueurCourant.reset();
		for(i=0;i<=9;i++){
			for(j=0;j<=9;j++){
				grillePlacement[i][j].setBackground(Color.WHITE);
			}
		}
	}

	/*
	 * Méthode qui permet de recommencer une nouvelle partie.
	 */
	public void recommencer(){
		joueurCourant.reset();
	}

	public void lancerViewJeu(LancementJeu tc, String joueur){
		viewJeu= new ViewJeu(tc, joueur);
		viewJeu.setVisible(true);
		tc.getControleur().viewPlacement.dispose();
	}

	public void lancerFenetreAccueil(LancementJeu tc){
		fenetreAccueil = new FenetreAccueil(tc);
		fenetreAccueil.setVisible(true);

	}

	public void lancerViewPlacement(LancementJeu tc){
		viewPlacement = new ViewPlacement(tc);
		viewPlacement.setVisible(true);
		tc.getControleur().fenetreAccueil.dispose();

	}

	public void lancerClient(LancementJeu tc) throws IOException, ClassNotFoundException{
		String joueur="client";
		client = new Client(tc);
		tc.getControleur().lancerViewJeu(tc,joueur);
	}

	public void lancerServeur(LancementJeu tc) throws IOException, ClassNotFoundException{
		String joueur="serveur";
		serveur = new Serveur(tc);
		tc.getControleur().lancerViewJeu(tc,joueur);
	}

	public void envoyerAttaque(int coordonee, String joueur) throws IOException, ClassNotFoundException{
		if(joueur=="serveur"){
			tc.getControleur().serveur.envoyerAttaque(coordonee);
			tc.getControleur().serveur.lireAttaque();
		}
		if(joueur=="client"){
			tc.getControleur().client.envoyerAttaque(coordonee);
			tc.getControleur().client.lireAttaque();
		}
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Joueur getJoueurDistant() {
		return joueurDistant;
	}

	public void attaqueRecue(int coordonnee){
		int i = coordonnee/10;
		int j = coordonnee%10;
		boolean bateauTouche;
		bateauTouche=joueurCourant.bateauTouche(coordonnee);
		if(bateauTouche){
			(tc.getControleur().getViewJeu().getGrilleDistante())[i][j].setBackground(Color.RED);
		}
		else {
			(tc.getControleur().getViewJeu().getGrilleDistante())[i][j].setBackground(Color.GRAY);
		}
	}

}
