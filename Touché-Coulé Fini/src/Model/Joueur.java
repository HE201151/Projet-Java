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
	 * Cr�ation d'un joueur et de ses bateaux
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
	 * Regarde si le joueur poss�de encore des bateaux
	 * Si sa vie tombe � 0 �a veut dire que tout ses bateaux sont coul�
	 * @return vrai si la vie tombe � z�ro
	 */
	public boolean estMort(){
		if(vie <=0){
			return true;
		}
		else return false;
	}	
	
	/*
	 *M�thode pour placer une case du bateau, soit le d�but du bateau, soit la fin
	 *@Param cliclPosition est la case que l'utilisateur � choisie, selectionBateau est le bateau que l'utilisateur � choisi de placer
	 *@Return renvoie vrai ou faux, si la position choisie est correcte ou non
	 */
	public void placerBateau(int clicPosition,int selectionBateau, int alignement, JButton[][] maGrille){
		boolean correcte= false;
		boolean aligne=false;
		Case position = new Case();																	// on cr�e un buffer pour la position choisie par l'utilisateur
		Case positionDebut = new Case();															/// buffer pour la case de d�but du bateau
		int debutBateau=0;
		int finBateau=(bateaux[selectionBateau].longueur)-1;										// pour connaitre la taille du bateau
		position.X=(clicPosition%10);																// pour r�cup�rer le chiffre des unit�s (X)
		position.Y=(clicPosition/10);																// pour r�cup�rer le chiffre des dizaines (Y)
		positionDebut.X=position.X;
		positionDebut.Y=position.Y;	
		if(bateaux[selectionBateau].coordonnees[debutBateau].X==10){								// dans le cas ou l'on selectionne le d�but du bateau
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
	 * Donne une position � une case d'un bateau
	 * @param selectionBateau le bateau choisi
	 * @param selectionCase est la case du bateau qui va recevoir la position
	 * @param position est la position donn�e � la case
	 */
	public void placerCase(int selectionBateau, int selectionCase, Case position){
		bateaux[selectionBateau].coordonnees[selectionCase].X=position.X;	
		bateaux[selectionBateau].coordonnees[selectionCase].Y=position.Y;		
	}
	
	/*
	 * M�thode qui permet de v�rifier si la case est vide
	 * @param coordonnee est la case vis�e
	 * @return false si la case est occup�e par une case bateau
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
	 * M�thode qui permet de v�rifier si la case vis�e contient une case bateau
	 * @param clicPosition est la case vis�e par l'utilisateur
	 * @return true si un bateau est touch�
	 */
	public boolean bateauTouche(int clicPosition){
		Case position= new Case();	
		position.X=(clicPosition%10);																// pour r�cup�rer le chiffre des unit�s (X)
		position.Y=(clicPosition/10);																// pour r�cup�rer le chiffre des dizaines (Y)
		for(int i=0; i<=4;i++){
			if(bateaux[i].estTouche(position)){
				vie--;				
				return true;
			}
		}
		return false;
	}
	
	/*
	 * m�thode qui permet de v�rifier si le bateau est bien positionn�
	 * Le bateau ne doit pas sortir de la grille et il ne doit pas �tre sur un autre bateau
	 * @param alignement horizontal ou vertical;
	 * @param position la position vis�e par l'utilisateur
	 * @param selectionBateau le bateau qui va �tre plac�
	 * @return false si le bateau n'est pas dans une position ad�quate
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
	 * M�thode qui permet de placer le bateau
	 * @param alignement horriontal ou vetical
	 * @param position case vis�e par l'utilisateur
	 * @param selectionBateau le bateau s�lectionn� par l'utilisateur
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
