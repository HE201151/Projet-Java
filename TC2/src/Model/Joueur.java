package Model;

public class Joueur {
	Bateau[] bateaux = new Bateau[5];
	Case[] caseOccupee= new Case[15];
	int indiceCaseOccupee=0;
	
	
	public Joueur(){
		
		for(int i=0; i<=4;i++){
			bateaux[i]= new Bateau(i);					// on construit les bateaux du joueur 
			
			//System.out.println(bateaux1[i].longueur);
		}
		for(int i=0; i<=14;i++){
			caseOccupee[i]= new Case();					// on construit les bateaux du joueur 
			
			//System.out.println(bateaux1[i].longueur);
		}
	}
	
	
	
	/*
	 *Méthode pour placer une case du bateau, soit le début du bateau, soit la fin
	 *@Param cliclPosition est la case que l'utilisateur à choisie, selectionBateau est le bateau que l'utilisateur à choisi de placer
	 *@Return renvoie vrai ou faux, si la position choisie est correcte ou non
	 */
	
	
	
	public boolean placerBateau(int clicPosition,int selectionBateau){
		
		
		int i=0;
		boolean correcte= false;
		boolean aligne=false;
		
		Case position = new Case();																	// on crée un buffer pour la position choisie par l'utilisateur
		Case positionDebut = new Case();															/// buffer pour la case de début du bateau
		
		
		
		int debutBateau=0;
		int finBateau=(bateaux[selectionBateau].longueur)-1;										// pour connaitre la taille du bateau
		
		
		
		position.X=(clicPosition%10);																// pour récupérer le chiffre des unités (X)
		position.Y=(clicPosition/10);																// pour récupérer le chiffre des dizaines (Y)
		
		if(bateaux[selectionBateau].coordonnees[debutBateau].X==10){								// dans le cas ou l'on selectionne le début du bateau
			
			if(caseLibre(position)){																// on vérifie si la case est libre
				
				placerCase(selectionBateau,debutBateau,position);									// on place le début du bateau
				System.out.println("dbut bateau placé");
				correcte=true;																		// la position est correcte
			}

		}
		

		
		if((!correcte)&&(bateaux[selectionBateau].coordonnees[finBateau].X==10)) {					// si on a déjà placé le début du bateau on place la fin																		// dans le cas ou l'on sélectionne la fin du bateau


			
			
			positionDebut.X=bateaux[selectionBateau].coordonnees[debutBateau].X;					// je met en mémoire pour allèger la condition
			positionDebut.Y=bateaux[selectionBateau].coordonnees[debutBateau].Y;									
			
			aligne=estAligne(position,positionDebut, finBateau);									// on regarde si la case de fin de bateau est alignée avec la case de début de bateau
																									// on regarde aussi si on attribue un bon nombre de case (pas plus grand que la longueur du bateau)
			if (aligne){																			// si le bateau est aligné
				
				if(caseLibre(position)){															// on regarde si la case est libre
					placerCase(selectionBateau,finBateau,position);									// on place le bateau
					System.out.println("fin bateau placé");
					correcte=true;																	// la case est correctement placée
				}
				System.out.println("Condition True");				
				
			
				if(bateaux[selectionBateau].longueur>2){											// on regarde si le bateau à plus de deux cases
					correcte=placerIntracase(bateaux[selectionBateau],debutBateau, finBateau);		// si oui on positione les cases entre le début et la fin
				}																					// fin placer intraCase	
							
			}																						// fin condition qu'ils soient allignés
			else{																					// si le bateau n'est pas aligné il faut choisir à nouveau la case de fin
				System.out.println("Bateau pas aligné");
			}																						// fin else
		}																							// fin placer case de fin de bateau
		
		
		if (correcte){																				// si on a mis une case correcte on return vrai
			caseOccupee[indiceCaseOccupee]=position;
			indiceCaseOccupee++;
			
			return true;
		}																							// sinon return false
		else return false;
		
	}
	
	
	/*
	 * 
	 */
	
	
	public boolean estAligne(Case position, Case positionDebut, int finBateau){
		if ( ((position.X==positionDebut.X) && (Math.abs(position.Y-positionDebut.Y)==finBateau))				// si la case du début du bateau est aligné avec la case de fin du bateau 
				|| ((position.Y==positionDebut.Y) && (Math.abs(position.X-positionDebut.X)==finBateau)) ){
			return true;
		}
		else return false;
	}
	
	/*
	 * 
	 */
	
	
	public boolean placerIntracase(Bateau bateau,int debutBateau, int finBateau){							
		int i;
		if(bateau.coordonnees[debutBateau].X==bateau.coordonnees[finBateau].X){							// si le bateau est positionné dans l'axe des X
			for(i=1;i<=bateau.longueur-2;i++){															// toutes les cases auront le même X
				if(caseLibre(bateau.coordonnees[i])){
					bateau.coordonnees[i].X=bateau.coordonnees[i-1].X;										// donc on donne la coo X identique pour toutes les cases
					bateau.coordonnees[i].Y=bateau.coordonnees[i-1].Y+1;									// et on donne la coo Y qui augmente d'une case par rapport à la précédente
					caseOccupee[indiceCaseOccupee]=bateau.coordonnees[i];
					indiceCaseOccupee++;
					return true;
				}
			}
			
			
		}
		else{																							// sinon le bateau est placé sur l'axe des Y
			for(i=1;i<=bateau.longueur-2;i++){															// toutes les cases auront le même Y
				if(caseLibre(bateau.coordonnees[i])){
					bateau.coordonnees[i].Y=bateau.coordonnees[i-1].Y;										// donc on donne la coo Y identique pour toutes les cases
					bateau.coordonnees[i].X=bateau.coordonnees[i-1].X+1;									// et on donne la coo X qui augmente d'une case par rapport à la précédente
					caseOccupee[indiceCaseOccupee]=bateau.coordonnees[i];
					indiceCaseOccupee++;
					return true;
				}
			}
		}
		return false;
		
	}
	
	
	/*
	 * 
	 */
	
	
	
	public void placerCase(int selectionBateau, int selectionCase, Case position){
		bateaux[selectionBateau].coordonnees[selectionCase].X=position.X;	
		bateaux[selectionBateau].coordonnees[selectionCase].Y=position.Y;
		
		
	/*
	 * 
	 */
		
	}
	
	public boolean caseLibre(Case coordonee){
		for(int i=0; i<=indiceCaseOccupee;i++){
			if ((coordonee.X==caseOccupee[i].X)&&(coordonee.Y==caseOccupee[i].Y)){
				System.out.println("case occupée");
				return false;
			}
		}
		return true;
	}
		

}
