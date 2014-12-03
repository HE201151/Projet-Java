package toucheCoule;


import toucheCoule.Case;
import toucheCoule.Plateau;


	/**
	 * Classe Bateau, on construit un tableau de bateau, on leur donne un propriétaire, leur vie et leur longueur
	 * 
	 */


public class Bateau extends Plateau{
	int proprietaire; 						// Définit à quel joueur appartient le bateau (1=joueur1, 2= joueur2)
	int longueur;							// longueur du bateau en nombre de case
	Case[] coordonnees;						// cases que le bateau occupe

	int vie;										// nombre de case non-touchée du bateau
	private final int NB_BATEAU=10;  				// nombre de bateau (NB_BATEAU/2 par joueur)
	Bateau [] TBateau = new Bateau[NB_BATEAU];		//On crée le tableau de bateau
	
	
	/**
	 * pour voir si le bateau est coulé
	 * @return vrai ou faux en fonction de la vie du bateau
	 */
	public boolean estCoule(){
		if (this.vie<=0){
			return true;
		}
		else return false;
	}
	
	/**
	 * Pour voir si le bateau est touché
	 * Reçoit en argument le numéro du joueur ainsi que la coordonée
	 * @return vrai ou faux en fonction de la position visée
	 */
	public boolean estTouche(int i, int cooX, int cooY){    
		int j, u;
		
		if (i==1){																// si le joueur 1 est visé
			for(u=0;u<=NB_BATEAU/2-1;u++){
				for(j=0;j<=TBateau[u].longueur;j++){
				
					if(TBateau[i].coordonnees[j].X==cooX){
						
						if(TBateau[i].coordonnees[j].Y==cooY){
							
							TBateau[i].vie--;
							return true;
						}
					
					}
				}
				
			}
		}
		if (i==2){																// si le joueur 2 est visé
			for(u=4;u<=NB_BATEAU/2-1;u++){
				for(j=0;j<=TBateau[u].longueur;j++){
				
					if(TBateau[i].coordonnees[j].X==cooX){
						if(TBateau[i].coordonnees[j].Y==cooY){
							TBateau[i].vie--;
							return true;
						}
					
					}
				}
				
			}
		}
		return false;
	}
	
	/**
	 * Permet de voir à la console notre tableau de bateau
	 * @return
	 */
	
	public String toString(){
		String repr = "  Longueur: " + this.longueur + "  vie: " + this.vie + "  proprietaire: " + this.proprietaire;
		return repr;
	}
	
	/**
	 * Construction d'un bateau
	 * @return
	 */

	public Bateau(int i,int proprio){
		int u;
		this.longueur=i;
		this.vie=this.longueur;
		if(proprio==1){
			this.proprietaire=1;
		}
		else this.proprietaire=2;
		this.coordonnees=new Case[i];
		for(u=0;u<=i-1;u++){
			//this.coordonnees[u].coordoneeX='o';
			//this.coordonnees[u].coordoneeY=0;
		}

		
	}
	

	
	
	public Bateau[] getTBateau() {
		return TBateau;
	}

	/**
	 * Méthode Main
	 * @return
	 */
	public Bateau(){
		int i;
		
		for(i=0; i<=(NB_BATEAU-1)/2;i++){				// On construit les 5 premiers bateaux
			TBateau[i]=new Bateau(i+1,1);				// Ils appartiennent au Joueur 1

		}
		//for(i=5; i<=(NB_BATEAU-1);i++){					// Les 5 bateaux suivants
		//	TBateau[i]=new Bateau(i-4,2);				// Appartiennent au Joueur 2

		//}

		//TBateau[0].coordonnees[0].coordoneeX='a';
		//TBateau[0].coordonnees[0].coordoneeX=1;
		
	}
	
	
	public int getNB_BATEAU() {
		return (NB_BATEAU/2)-1;
	}



	public static void main(String[] args){
		//constructionB(args);

		
		//rangement(TBateau);								// Range les bateaux dans le tableau de rangement en leur donnant une coordonnée
		
		
		//for (Bateau x : TBateau ){						// Affiche à la console le tableau de bateaux
		//	System.out.println(x);	
			
		//}
		
		
	}
	
	
	
}
