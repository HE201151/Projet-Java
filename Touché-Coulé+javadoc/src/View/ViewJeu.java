package View;
/*
 *Projet Java Janvier 2014
 *@author Blan Romain et Vogeleer Martin
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.LancementJeu;

/*
 * Classe qui permet de voir la fen�tre de jeu.
 */
public class ViewJeu extends JFrame {
	private JPanel contentPane;
	static String positionBouton="00";
	private LancementJeu tc;
	private String joueur;
	private JButton[][] grilleCourante;
	private JButton[][] grilleDistante;

	/*
	 * Instance qui cr�e la JFrame de jeu.
	 * @param tc Base de donn�es.
	 */
	public ViewJeu(LancementJeu tc, String joueur) {
		this.joueur=joueur;
		this.tc=tc;
		setTitle("viewJeu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//PanelComplet
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(0, 2, 0, 0));
		//Partie de gauche
		JPanel panelGauche = new JPanel();
		panelPrincipal.add(panelGauche);
		panelGauche.setLayout(new GridLayout(2, 0, 0, 0));				
		JLabel labelGauche = new JLabel("Ennemy");
		labelGauche.setHorizontalAlignment(SwingConstants.CENTER);
		panelGauche.add(labelGauche);				
		JPanel panelGrilleGauche = new JPanel();	
		grille1(panelGrilleGauche,2);
		panelGauche.add(panelGrilleGauche);				
		panelGauche.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); //Bordure autour du panelGauche
		//partie de droite
		JPanel panelDroite = new JPanel();
		panelPrincipal.add(panelDroite);
		panelDroite.setLayout(new GridLayout(2, 0, 0, 0));				
		JLabel labelDroite = new JLabel("Owner");
		labelDroite.setHorizontalAlignment(SwingConstants.CENTER);
		panelDroite.add(labelDroite);				
		JPanel panelGrilleDroite = new JPanel();
		grille(panelGrilleDroite,1); 
		panelDroite.add(panelGrilleDroite);				
		panelDroite.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); //Bordure autour du panelDroite
	}

	/*
	 * M�thode qui cr�e une grille dans un JPanel.
	 * @param panel Panel dans lequel on cr�e la grille
	 * @param numJoueur Num�ro du joueur : 1 pour joueurCourant, 2 pour le joueurDistant.
	 */
	public void grille1(JPanel panel, final int numJoueur){
		grilleCourante = new JButton [10][10];
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		int i, j;
		for(i=0;i<=9;i++){
			for(j=0;j<=9;j++){
				grilleCourante[i][j]= new JButton();
				grilleCourante[i][j].setName(""+(i)+(j));
				tc.getControleur().caseOccupee(grilleCourante[i][j],i,j,numJoueur);
				grilleCourante[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){		// quand on clique sur le bouton on donne le nom de la case (qui sont ses coordon�es)
						((Component) e.getSource()).setEnabled(false);
						positionBouton=(((Component) e.getSource()).getName()+"");
						tc.getControleur().attaquer(Integer.parseInt(positionBouton), e,numJoueur,tc);
						try {
							tc.getControleur().envoyerAttaque(Integer.parseInt(positionBouton), joueur);
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				panel.add(grilleCourante[i][j]);	
			}
		}		
	}
	
	/*
	 * M�thode qui permet de cr�er une grille de JButton
	 * @param panel le panel sur lequel la grille va �tre cr�e
	 * @param numJoueur le num�ro du joueur
	 */
	public void grille(JPanel panel, final int numJoueur){
		grilleDistante = new JButton [10][10];
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		int i, j;
		for(i=0;i<=9;i++){
			for(j=0;j<=9;j++){
				grilleDistante[i][j]= new JButton();
				grilleDistante[i][j].setName(""+(i)+(j));
				tc.getControleur().caseOccupee(grilleDistante[i][j],i,j,numJoueur);
				grilleDistante[i][j].setEnabled(false);
				grilleDistante[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){		// quand on clique sur le bouton on donne le nom de la case (qui sont ses coordon�es)
						((Component) e.getSource()).setEnabled(false);
						positionBouton=(((Component) e.getSource()).getName()+"");
						tc.getControleur().attaquer(Integer.parseInt(positionBouton), e,numJoueur,tc);
						try {
							tc.getControleur().envoyerAttaque(Integer.parseInt(positionBouton), joueur);
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				panel.add(grilleDistante[i][j]);	
			}
		}		
	}

	public JButton[][] getGrilleCourante() {
		return grilleCourante;
	}

	public JButton[][] getGrilleDistante() {
		return grilleDistante;
	}
}