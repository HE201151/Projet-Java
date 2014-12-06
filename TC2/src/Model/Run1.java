/*
 * @author Romain Blan, Vogeleer Martin
 */
package Model;


import java.lang.Math;

import javax.swing.JButton;

import View.ViewPlacement;

import java.util.Observable;

public class Run1 extends Observable{
	Plateau plateauTC = new Plateau();
	Bateau[] bateaux1;							// on construit les bateaux du joueur 1
	Bateau[] bateaux2;							// on construit les bateaux du joueur 2
	int nb_bateaux=10;
	int selectionBateau=0;						// permet de choisir la case du bateau qui va être définie par l'utilisateur
	
	
	/*
	 * Le joueur choisi s'il veut commencer une partie ou quitter le jeu
	 */ 
	
	public Run1(){
		boolean lancerJeu=true;
		if (lancerJeu==false){
			//quitte le jeu
		}
		else lancement();

	}
	

		
	
	
	public void constructionBateaux(){
		bateaux1 = new Bateau[5];							// on construit le tableau de bateaux du joueur 1
		bateaux2 = new Bateau[5];							// on construit le tableau de bateaux du joueur 2
		for(int i=0; i<=(nb_bateaux/2)-1;i++){
			bateaux1[i]= new Bateau(i);					// on construit les bateaux du joueur 1
			bateaux2[i]= new Bateau(i);					// on construit les bateaux du joueur 2
			//System.out.println(bateaux1[i].longueur);
		}
		

		
	}
	
	//public void constructionGrille(){
	//	Plateau grilles = new Plateau();
		
	//}
	
	/*
	 * méthode qui permet de donner la position des cases du bateau qui se trouvent entre les extrémités du bateau
	 */
	
	public void placerIntracase(Bateau bateau,int debutBateau, int finBateau){							
		int i;
		if(bateau.coordonnees[debutBateau].X==bateau.coordonnees[finBateau].X){							// si le bateau est positionné dans l'axe des X
			for(i=1;i<=bateau.longueur-2;i++){															// toutes les cases auront le même X
				
				bateau.coordonnees[i].X=bateau.coordonnees[i-1].X;										// donc on donne la coo X identique pour toutes les cases
				bateau.coordonnees[i].Y=bateau.coordonnees[i-1].Y+1;									// et on donne la coo Y qui augmente d'une case par rapport à la précédente
				//System.out.println(bateau.coordonnees[i].Y);
			}
			//System.out.println("fin");
			
		}
		else{																							// sinon le bateau est placé sur l'axe des Y
			for(i=1;i<=bateau.longueur-2;i++){															// toutes les cases auront le même Y
				bateau.coordonnees[i].Y=bateau.coordonnees[i-1].Y;										// donc on donne la coo Y identique pour toutes les cases
				bateau.coordonnees[i].X=bateau.coordonnees[i-1].X+1;									// et on donne la coo X qui augmente d'une case par rapport à la précédente
			}
		}
		
	}
	
	/*
	 * méthode qui permet de positionner les bateaux du joueur 
	 * on a besoin de connaître sa position de début et de fin pour savoir placer un bateau correctement
	 * @param positionBouton L'endroit ou l'utilisateur va cliquer, c'est un entier de deux chiffre, le premier étant Y et le deuxième X.
	 * si l'utilisateur à cliqué sur une case considérée comme correcte on peut passer à la case suivante
	 */
	
	public boolean placerBateaux(int positionBouton){												
		int i=0;
		boolean correcte=true;
		Case position = new Case();
		Case positionDebut = new Case();
		//position.X=1;   //essai
		//position.Y=5;	//essai
		int debutBateau=0;
		int finBateau=0;
		
		position.X=(positionBouton%10);																			// pour récupérer le chiffre des unités (X)
		position.Y=(positionBouton/10);																			// pour récupérer le chiffre des dizaines (Y)
		
		
		switch (selectionBateau){
		case 0: {																								// dans le cas ou c'est le premier bateau
			bateaux1[selectionBateau].coordonnees[debutBateau].X=position.X;	
			bateaux1[selectionBateau].coordonnees[debutBateau].Y=position.Y;
			
			System.out.println("Bateau " + bateaux1[selectionBateau].longueur + "  :  ");
			System.out.println("coo X début: " + bateaux1[selectionBateau].coordonnees[debutBateau].X);
			System.out.println("coo Y début: " + bateaux1[selectionBateau].coordonnees[debutBateau].Y);
			break;
			}
		
		case 1: case 3: case 5: case 7: {																		// dans le cas ou l'on sélectionne le début des autres bateaux
			bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].X=position.X;	
			bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].Y=position.Y;
			//correcte=caseLibre();
			
			System.out.println("Bateau " + bateaux1[(selectionBateau+1)/2].longueur + "  :  ");									
			System.out.println("coo X début: " + bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].X);
			System.out.println("coo Y début: " + bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].Y);
			break;
			}
		
		case 2: case 4: case 6: case 8: {																		// dans le cas ou l'on sélectionne la fin des autres bateaux

			finBateau=(bateaux1[selectionBateau/2].longueur)-1;													// pour connaitre la dernière case du bateau

				

			bateaux1[selectionBateau/2].coordonnees[finBateau].X=position.X;									// on donne la position du bateau
			bateaux1[selectionBateau/2].coordonnees[finBateau].Y=position.Y;
			
			positionDebut.X=bateaux1[selectionBateau/2].coordonnees[debutBateau].X;								// je met en mémoire pour allèger la condition
			positionDebut.Y=bateaux1[selectionBateau/2].coordonnees[debutBateau].Y;									
			
	

			correcte=estAligne(position,positionDebut, finBateau);												// on regarde si la case de fin de bateau est alignée avec la case de début de bateau
																												// on regarde aussi si on attribue un bon nombre de case (pas plus grand ue la longueur du bateau)
			if (correcte){																						// si la condition est correcte
				
				
				System.out.println("Condition correcte");
				
				System.out.println("Bateau " + bateaux1[selectionBateau/2].longueur + "  :  ");
				System.out.println("coo X fin: " + bateaux1[selectionBateau/2].coordonnees[finBateau].X);
				System.out.println("coo Y fin: " + bateaux1[selectionBateau/2].coordonnees[finBateau].Y);
				
				
			
				if(bateaux1[selectionBateau/2].longueur>2){															// on regarde si le bateau à plus de deux cases
					placerIntracase(bateaux1[selectionBateau/2],debutBateau, finBateau);							// si oui on positione les cases entre le début et la fin
				}	
			}		// fin condition qu'ils soient allignés
			else{
				correcte=false;																						// si le bateau est mal placé il faut choisir à nouveau la case de fin
				System.out.println("Condition incorrecte");
			}
			break;
			}		// fin case
		}			// fin switch
		
		


		
		
		if (correcte){											// si on a mis une case correcte on peut passer à la case suivante
			selectionBateau=selectionBateau+1;
			System.out.println("+1");
			return true;
		}
		else return false;
		
	}
	
	public boolean caseLibre(){
		return false;
	}
	
	/*
	 * on regarde si les coordonées reçues par l'utilisateurs sont correcte, il faut que les cases de début ou de fin soient sur le même axe (horizontale ou vertivale)
	 * @Param position est la case choisie par l'utilisateur pour la fin du bateau
	 * @Return renvoie vrai si le bateau est correctement placé, sinon il renvoie faux
	 */
	
	public boolean estAligne(Case position, Case positionDebut, int finBateau){
		if ( ((position.X==positionDebut.X) && (Math.abs(position.Y-positionDebut.Y)==finBateau))				// si la case du début du bateau est aligné avec la case de fin du bateau 
				|| ((position.Y==positionDebut.Y) && (Math.abs(position.X-positionDebut.X)==finBateau)) ){
			return true;
		}
		else return false;
	}
	
	/*
	 * méthode de lancement du jeu
	 * 
	 */
	
	public void lancement(){
		initialisation();
	}
	
	
	/*
	 * Méthode ou on initialise une partie
	 */
	
	public void initialisation(){

		constructionBateaux();							// on construit les bateaux

		//constructionGrille();							// on construit la grille
		
		//placerBateaux(bateaux1);						// on place les bateaux du premier joueur
		//placerBateaux(bateaux2);						// idem joueur 2
		
	}
	
	public boolean caseLibre(Case coordonee){
		for(int i=0; i<4;i++){
			for(int j=0; j<bateaux[i].longueur-1;j++){
				if((bateaux[i].coordonnees[j].X==coordonee.X)&&(bateaux[i].coordonnees[j].Y==coordonee.Y)){
					System.out.println("case occupée");
					return false;
				}
			}
		}
		System.out.println("case libre");
		return true;
	}
		

	
	
	public static void main(String[] args){
		

		
	}
}
