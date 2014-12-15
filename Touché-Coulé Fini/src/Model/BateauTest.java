package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BateauTest {
	Bateau[] bateaux;
	
	@Test
	public void testBateauInt() {
		bateaux = new Bateau[5];
		for(int i=0; i<=4;i++){
			bateaux[i]= new Bateau(i);		
		}
		assertEquals(5, bateaux[4].longueur);
	}

	@Test
	public void testEstTouche() {
		bateaux = new Bateau[5];
		Case position= new Case();
		for(int i=0; i<=4;i++){
			bateaux[i]= new Bateau(i);		
		}
		position.X=89;
		position.Y=45;
		bateaux[0].coordonnees[0].X=89;
		bateaux[0].coordonnees[0].Y=45;
		assertEquals(true, bateaux[0].estTouche(position));
		assertEquals(10, bateaux[0].coordonnees[0].X);
		assertEquals(10, bateaux[0].coordonnees[0].Y);
	}

}
