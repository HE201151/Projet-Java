package Model;


public class Bateau {
	int longueur;							// longueur du bateau en nombre de case
	Case[] coordonnees;						// cases que le bateau occupe
	int vie;
	
	public boolean estCoule(){
		if (this.vie<=0){
			return true;
		}
		else return false;
	}
	
	
	public String toString(){
		String repr = "  Longueur: " + this.longueur + "  vie: " + this.vie ;
		return repr;
	}
	
	public Bateau(int i){
		
		this.longueur=i+1;
		this.vie= this.longueur;
		this.coordonnees= new Case[i+1];
		for(int j=0; j<=i;j++){
			//System.out.println(j);
			this.coordonnees[j]= new Case();
			this.coordonnees[j].X=10;
			
		}
		//System.out.println("fin");
		
	}
	
	
	
	

	
}