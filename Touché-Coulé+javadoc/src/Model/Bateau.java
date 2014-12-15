package Model;

import java.io.Serializable;


public class Bateau implements Serializable {
	int longueur;							// longueur du bateau en nombre de case
	Case[] coordonnees;						// cases que le bateau occupe
	
	/*
	 * Cr�ation d'un bateau
	 * @param i d�finit la longueur du bateau
	 */
	public Bateau(int i){
		this.longueur=i+1;		
		this.coordonnees= new Case[i+1];
		for(int j=0; j<=i;j++){
			this.coordonnees[j]= new Case();
			this.coordonnees[j].X=10;			
		}
	}
	
	public Bateau(){
	}
	/*
	 * M�thode qui permet de savoir si un bateau est touch�
	 * @param position la position vis�e
	 * @return si la case vis�e poss�de une case bateau, il retourne vrai
	 */
	public boolean estTouche(Case position){
		for(int i=0; i<=this.longueur-1;i++){
			if((this.coordonnees[i].X==position.X)&&(this.coordonnees[i].Y==position.Y)){
				this.coordonnees[i].X=10;
				this.coordonnees[i].Y=10;
				return true;
			}
		}
		return false;
	}
}