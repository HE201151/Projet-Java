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
	int selectionBateau=0;
	
	
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
	 */
	
	public void placerBateaux(int positionBouton){
		int i=0;

		Case position = new Case();
		//position.X=1;   //essai
		//position.Y=5;	//essai
		int debutBateau=0;
		int finBateau=0;
		
		position.X=(positionBouton%10);
		position.Y=(positionBouton/10);
		
		
		switch (selectionBateau){
		case 0: {
			bateaux1[selectionBateau].coordonnees[debutBateau].X=position.X;	
			bateaux1[selectionBateau].coordonnees[debutBateau].Y=position.Y;
			
			System.out.println("Bateau " + (selectionBateau+1) + "  :  ");
			System.out.println("coo X début: " + bateaux1[selectionBateau].coordonnees[debutBateau].X);
			System.out.println("coo Y début: " + bateaux1[selectionBateau].coordonnees[debutBateau].Y);
			break;
			}
		
		case 1: case 3: case 5: case 7: {
			bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].X=position.X;	
			bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].Y=position.Y;
			
			System.out.println("Bateau " + ((selectionBateau+3)/2) + "  :  ");
			System.out.println("coo X début: " + bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].X);
			System.out.println("coo Y début: " + bateaux1[(selectionBateau+1)/2].coordonnees[debutBateau].Y);
			break;
			}
		
		case 2: case 4: case 6: case 8: {
			
			finBateau=(bateaux1[selectionBateau/2].longueur)-1;

			bateaux1[selectionBateau/2].coordonnees[finBateau].X=position.X;								
			bateaux1[selectionBateau/2].coordonnees[finBateau].Y=position.Y;
			
			System.out.println("Bateau " + ((selectionBateau+2)/2) + "  :  ");
			System.out.println("coo X fin: " + bateaux1[selectionBateau/2].coordonnees[finBateau].X);
			System.out.println("coo Y fin: " + bateaux1[selectionBateau/2].coordonnees[finBateau].Y);
			
			
			if(bateaux1[selectionBateau/2].longueur>2){												// si le bateau à plus de deux cases
				placerIntracase(bateaux1[selectionBateau/2],debutBateau, finBateau);								// on positione les cases entre le début et la fin
			}
			break;
			}
		}
		
		


		
		
		selectionBateau=selectionBateau+1;
		
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
	
	
	
	
	public static void main(String[] args){
		

		
	}
}
