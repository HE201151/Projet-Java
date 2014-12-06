package Controleur;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import Model.Joueur;

public class Controleur {
	Joueur joueur1 ;
	Joueur joueur2;
	
	public Controleur(){
		joueur1 = new Joueur();
		joueur2 = new Joueur();
	}
	
	public void click(int coordonee, int selection, ActionEvent e){
		boolean caseCorrecte;

		caseCorrecte=joueur1.placerBateau(coordonee, selection);
		if(caseCorrecte){
			((Component) e.getSource()).setBackground(Color.RED);
		}
		
	}
}
