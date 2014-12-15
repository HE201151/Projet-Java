package Model;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Joueur {
	Bateau[] bateaux = new Bateau[5];
	Case[] caseOccupee= new Case[15];
	int indiceCaseOccupee=0;
	int vie=15;
	
	public void setBateaux(Bateau[] bateaux) {
		this.bateaux = bateaux;
	}
	
	/*
	 * Création d'un joueur et de ses bateaux
	 */
	public Joueur(){
		for(int i=0; i<=4;i++){
			bateaux[i]= new Bateau(i);					// on construit les bateaux du joueur 
		}
		for(int i=0; i<=14;i++){
			caseOccupee[i]= new Case(10,10);	
		}
	}
	
	/*
	 * Regarde si le joueur possède encore des bateaux
	 * Si sa vie tombe à 0 ça veut dire que tout ses bateaux sont coulé
	 * @return vrai si la vie tombe à zéro
	 */
	public boolean estMort(){
		if(vie <=0){
			return true;
		}
		else return false;
	}	
	
	/*
	 *Méthode pour placer une case du bateau, soit le début du bateau, soit la fin
	 *@Param cliclPosition est la case que l'utilisateur à choisie, selectionBateau est le bateau que l'utilisateur à choisi de placer
	 *@Return renvoie vrai ou faux, si la position choisie est correcte ou non
	 */
	public void placerBateau(int clicPosition,int selectionBateau, int alignement, JButton[][] maGrille){
		boolean correcte= false;
		boolean aligne=false;
		Case position = new Case();																	// on crée un buffer pour la position choisie par l'utilisateur
		Case positionDebut = new Case();															/// buffer pour la case de début du bateau
		int debutBateau=0;
		int finBateau=(bateaux[selectionBateau].longueur)-1;										// pour connaitre la taille du bateau
		position.X=(clicPosition%10);																// pour récupérer le chiffre des unités (X)
		position.Y=(clicPosition/10);																// pour récupérer le chiffre des dizaines (Y)
		positionDebut.X=position.X;
		positionDebut.Y=position.Y;	
		if(bateaux[selectionBateau].coordonnees[debutBateau].X==10){								// dans le cas ou l'on selectionne le début du bateau
			correcte=casesSontLibre(alignement,positionDebut, selectionBateau);
			if (correcte){
				placerLesCases(alignement,position,selectionBateau,maGrille);
			}
		}	
	}
	
	public Bateau[] getBateaux() {
		return bateaux;
	}

	/*
	 * Donne une position à une case d'un bateau
	 * @param selectionBateau le bateau choisi
	 * @param selectionCase est la case du bateau qui va recevoir la position
	 * @param position est la position donnée à la case
	 */
	public void placerCase(int selectionBateau, int selectionCase, Case position){
		bateaux[selectionBateau].coordonnees[selectionCase].X=position.X;	
		bateaux[selectionBateau].coordonnees[selectionCase].Y=position.Y;		
	}
	
	/*
	 * Méthode qui permet de vérifier si la case est vide
	 * @param coordonnee est la case visée
	 * @return false si la case est occupée par une case bateau
	 */
	public boolean caseLibre(Case coordonnee){	
		for(int i=0; i<=4;i++){
			for(int j=0; j<=bateaux[i].longueur-1;j++){
				if((bateaux[i].coordonnees[j].X==coordonnee.X)&&(bateaux[i].coordonnees[j].Y==coordonnee.Y)){
				return false;
				}			
			}
		}
		return true;
	}
	
	/*
	 * Méthode qui permet de vérifier si la case visée contient une case bateau
	 * @param clicPosition est la case visée par l'utilisateur
	 * @return true si un bateau est touché
	 */
	public boolean bateauTouche(int clicPosition){
		Case position= new Case();	
		position.X=(clicPosition%10);																// pour récupérer le chiffre des unités (X)
		position.Y=(clicPosition/10);																// pour récupérer le chiffre des dizaines (Y)
		for(int i=0; i<=4;i++){
			if(bateaux[i].estTouche(position)){
				vie--;				
				return true;
			}
		}
		return false;
	}
	
	/*
	 * méthode qui permet de vérifier si le bateau est bien positionné
	 * Le bateau ne doit pas sortir de la grille et il ne doit pas être sur un autre bateau
	 * @param alignement horizontal ou vertical;
	 * @param position la position visée par l'utilisateur
	 * @param selectionBateau le bateau qui va être placé
	 * @return false si le bateau n'est pas dans une position adéquate
	 */
	public boolean casesSontLibre(int alignement,Case position, int selectionBateau){
		boolean caseEstLibre=false;
		if(alignement==0){
			for (int i=0; i<=selectionBateau;i++){
				if(position.X>9){
					return false;
				}
				caseEstLibre=caseLibre(position);
				if(!caseEstLibre){
					return false;
				}
				else	position.X++;
			}
		}
		if(alignement==1){
			for (int i=0; i<=selectionBateau;i++){
				if(position.Y>9){
					return false;
				}
				caseEstLibre=caseLibre(position);
				if(!caseEstLibre){
					return false;
				}
				else	position.Y++;	
			}	
		}
		return true;
	}
	
	/*
	 * Méthode qui permet de placer le bateau
	 * @param alignement horriontal ou vetical
	 * @param position case visée par l'utilisateur
	 * @param selectionBateau le bateau sélectionné par l'utilisateur
	 * @param maGrille la grille de placement de bateau
	 */
	public void placerLesCases(int alignement,Case position,int selectionBateau,JButton[][] maGrille){
		if(alignement==0){
			for (int i=0; i<=selectionBateau;i++){
				bateaux[selectionBateau].coordonnees[i].X=position.X;
				bateaux[selectionBateau].coordonnees[i].Y=position.Y;
				caseOccupee[indiceCaseOccupee].X=position.X;
				caseOccupee[indiceCaseOccupee].Y=position.Y;
				indiceCaseOccupee++;
				maGrille[position.Y][position.X].setBackground(Color.GREEN);
				position.X++;				
			}
		}
		if(alignement==1){
			for (int i=0; i<=selectionBateau;i++){
				bateaux[selectionBateau].coordonnees[i].X=position.X;
				bateaux[selectionBateau].coordonnees[i].Y=position.Y;
				caseOccupee[indiceCaseOccupee].X=position.X;
				caseOccupee[indiceCaseOccupee].Y=position.Y;
				indiceCaseOccupee++;
				maGrille[position.Y][position.X].setBackground(Color.GREEN);
				position.Y++;				
			}			
		}
		indiceCaseOccupee--;
	}
	
	public void reset(){
		for (int i=0; i<=4;i++){
			for(int j=0; j<=bateaux[i].longueur-1;j++){
				bateaux[i].coordonnees[j].X=10;
				bateaux[i].coordonnees[j].Y=10;
			}
		}
		for(int i=0; i<=indiceCaseOccupee;i++){
			caseOccupee[indiceCaseOccupee].X=10;
			caseOccupee[indiceCaseOccupee].Y=10;
		}
		indiceCaseOccupee=0;
	}
}
