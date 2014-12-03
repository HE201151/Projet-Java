/*
 * @author Romain Blan, Vogeleer Martin
 */


package toucheCoule;

import vieuwPanel.Placement;

public class Run1 {
	Plateau plateauTC = new Plateau();
	Bateau1[] bateaux1;							// on construit les bateaux du joueur 1
	Bateau1[] bateaux2;							// on construit les bateaux du joueur 2
	int nb_bateaux=10;
	
	
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
		bateaux1 = new Bateau1[5];							// on construit le tableau de bateaux du joueur 1
		bateaux2 = new Bateau1[5];							// on construit le tableau de bateaux du joueur 2
		for(int i=0; i<=(nb_bateaux/2)-1;i++){
			bateaux1[i]= new Bateau1(i);					// on construit les bateaux du joueur 1
			bateaux2[i]= new Bateau1(i);					// on construit les bateaux du joueur 2
			//System.out.println(bateaux1[i].longueur);
		}
		

		
	}
	
	//public void constructionGrille(){
	//	Plateau grilles = new Plateau();
		
	//}
	
	/*
	 * méthode qui permet de donner la position des cases du bateau qui se trouvent entre les extrémités du bateau
	 */
	
	public void placerIntracase(Bateau1 bateau,int debutBateau, int finBateau){							
		int i;
		if(bateau.coordonnees[debutBateau].X==bateau.coordonnees[finBateau].X){							// si le bateau est positionné dans l'axe des X
			for(i=1;i<=bateau.longueur-2;i++){															// toutes les cases auront le même X
				
				bateau.coordonnees[i].X=bateau.coordonnees[i-1].X;										// donc on donne la coo X identique pour toutes les cases
				bateau.coordonnees[i].Y=bateau.coordonnees[i-1].Y+1;									// et on donne la coo Y qui augmente d'une case par rapport à la précédente
				System.out.println(bateau.coordonnees[i].Y);
			}
			System.out.println("fin");
			
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
	 */
	
	public void placerBateaux(Bateau1[] bateaux){
		int i=0;
		Case position = new Case();
		//position.X=1;   //essai
		//position.Y=5;	//essai
		int debutBateau=0;
		int finBateau=0;
		
		//if(Placement.getPositionBouton()!=0){
		position.X=(Placement.getPositionBouton()%10);
		position.Y=(Placement.getPositionBouton()/10);
		
		
		bateaux[i].coordonnees[debutBateau]=position;								// on met la position du premier bateau;
		System.out.println(bateaux[i].coordonnees[debutBateau]);
		
		//}
		for(i=1;i<=(nb_bateaux/2)-1;i++){											// on met la position des autres
			finBateau=bateaux[i].longueur-1;										// on donne la taille du bateau pour connaitre la fin du bateau
			bateaux[i].coordonnees[debutBateau]=position;							// la première case du bateau
			bateaux[i].coordonnees[finBateau]=position;								// la dernière case du bateau
			if(bateaux[i].longueur>2){												// si le bateau à plus de deux cases
				
				placerIntracase(bateaux[i],debutBateau, finBateau);					// on positione les cases entre le début et la fin
			}	
			
		}
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
		
		placerBateaux(bateaux1);						// on place les bateaux du premier joueur
		//placerBateaux(bateaux2);						// idem joueur 2
		
	}
	
	
	
	
	public static void main(String[] args){
		

		
	}
}
