package View;
/*
 *Projet Java Janvier 2014
 *@author Blan Romain et Vogeleer Martin
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import Model.LancementJeu;

/*
 * Classe qui permet de voir la fenêtre de placement.
 */
public class ViewPlacement extends JFrame {
	private JPanel contentPane;
	private LancementJeu tc;
	String positionBouton="00";
	int selectionBateau;
	int alignementBateau;
	String tabSelection[]= {"Bateau de case 1","Bateau de cases 2","Bateau de cases 3","Bateau de cases 4","Bateau de cases 5"};
	String tabAlignement[]= {"Horizontal", "Vertical"};	
	JComboBox selection ;
	JComboBox alignement;	
	JButton[][] maGrille;
	
	/*
	 * Instance qui crée la JFrame de jeu.
	 * @param tc Base de données.
	 */
	public ViewPlacement(final LancementJeu tc) {
		this.tc=tc;
		setTitle("viewPlacement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//Panel Principal
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(0, 2, 0, 0));
		//Panel Gauche
		JPanel panelGauche = new JPanel();
		panelPrincipal.add(panelGauche);
		panelGauche.setLayout(new GridLayout(2, 0, 0, 5));
		//Panel supérieur gauche
		JPanel panelSupGauche = new JPanel();		
		panelGauche.add(panelSupGauche);
		panelSupGauche.setLayout(new GridLayout(4, 2, 0, 0));		
		JLabel label = new JLabel("Choissisez le bateau à placer");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panelSupGauche.add(label);		
		selection = new JComboBox(tabSelection);
		panelSupGauche.add(selection);		
		alignement = new JComboBox(tabAlignement);
		panelSupGauche.add(alignement);		
		//Panel inférieur gauche
		JPanel panelInfGauche = new JPanel();
		grille(panelInfGauche);
		panelGauche.add(panelInfGauche);
		//Panel droite
		JPanel panelDroite = new JPanel();
		panelPrincipal.add(panelDroite);
		panelDroite.setLayout(new GridLayout(3, 0, 0, 0));		
		JButton bouttonReset = new JButton("Reset");
		bouttonReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){		
            	tc.getControleur().resetAction(maGrille);    	
            }
		});
		panelDroite.add(bouttonReset);			
		JButton bouttonClient = new JButton();
		bouttonClient.setText("Démarrer en tant que Client");
		bouttonClient.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){	
            	try {
					tc.getControleur().lancerClient(tc);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
            }
		});
		panelDroite.add(bouttonClient);		
		JButton bouttonServeur = new JButton();
		bouttonServeur.setText("Démarrer en tant que Serveur");
		bouttonServeur.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){		
            	try {
					tc.getControleur().lancerServeur(tc);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
            }
		});
		panelDroite.add(bouttonServeur);		
	}
	
	/*
	 * Méthode qui crée une grille dans un JPanel.
	 * @param panel Panel dans lequel on crée la grille
	 * @param numJoueur Numéro du joueur : 1 pour joueurCourant, 2 pour le joueurDistant.
	 */
	public void grille(JPanel panel){
		maGrille = new JButton [10][10];
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		int i, j;
		for(i=0;i<=9;i++){
			for(j=0;j<=9;j++){
			maGrille[i][j]= new JButton();
			maGrille[i][j].setBackground(Color.WHITE);
			maGrille[i][j].setName(""+(i)+(j));			
			maGrille[i][j].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){		// quand on clique sur le bouton on donne le nom de la case (qui sont ses coordonées)
	            	positionBouton=(((Component) e.getSource()).getName()+"");
	            	selectionBateau=selection.getSelectedIndex();
	            	alignementBateau=alignement.getSelectedIndex();	            	
	            	tc.getControleur().placerBateau(Integer.parseInt(positionBouton), selectionBateau,maGrille , alignementBateau);	            	
	            }
			});
			panel.add(maGrille[i][j]);			
			}
		}		
	}
}
