package Socket;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Model.Bateau;
import Model.LancementJeu;

public class Serveur {
	private ServerSocket s ;
	private LancementJeu tc;
	Bateau[] tableauAEmettre;
	Bateau[] tableauRecu;
	private Socket soc;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	/*
	 * Cr�ation du serveur et envoie du tableau de bateau au client
	 */
	public Serveur(LancementJeu tc) throws IOException, ClassNotFoundException{
		tableauAEmettre= new Bateau[5];
		for(int i = 0 ; i<=4; i++){
			tableauAEmettre[i]=new Bateau(i);
		}
		this.tc=tc;
		s = new ServerSocket(12345);
		soc = s.accept();
		out = new ObjectOutputStream(soc.getOutputStream());
		out.flush();	 
        in = new ObjectInputStream(soc.getInputStream());      
        tableauAEmettre = tc.getControleur().getJoueurCourant().getBateaux();
        out.writeObject(tableauAEmettre);
        out.flush();       
        Object objetRecu = in.readObject();
        tableauRecu = (Bateau[]) objetRecu;
        tc.getControleur().getJoueurDistant().setBateaux(tableauRecu);
 		//in.close();
		//out.close();
		
	}
	
	/*
	 * M�thode qui ferme le serveur
	 */
	public void fermerServeur() throws IOException{
		soc.close();
	}
	
	/*
	 * m�thode qui permet de recevoir les coordon�es vis�es par l'ennemi
	 */
	public void lireAttaque() throws ClassNotFoundException, IOException{
		Object objetRecu = in.readObject();	
		int coordoneeRecue = (int) objetRecu;
		tc.getControleur().attaqueRecue(coordoneeRecue);
	}
	
	/*
	 * m�thode qui permet de transmettre � l'ennemi la case que l'on a vis�
	 * @param coordonnee la case vis�e par l'utilisateur
	 */
	public void envoyerAttaque(int coordonee) throws IOException{
		out.writeObject(coordonee);
		
	}
}
