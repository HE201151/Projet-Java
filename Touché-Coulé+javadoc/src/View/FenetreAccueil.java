package View;
/*
 *Projet Java Janvier 2014
 *@author Blan Romain et Vogeleer Martin
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.LancementJeu;
/*
 * Classe qui permet de voir une fenêtre d'acceuil.
 */
public class FenetreAccueil extends JFrame {	
	private LancementJeu tc;
	
	/*
	 * Instance qui crée la JFrame d'acceuil.
	 * @param tc Base de données.
	 */
	public FenetreAccueil(LancementJeu tc){
		this.tc=tc;
		build();
	}

	/*
	 * Méthode qui crée la JFrame et son menu.
	 */
	private void build(){		
		//Partie Frame
		setTitle("ToucheCoule");
		setSize(700,500);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ferme lors du clic sur la croix
		setContentPane(buildContentPane());
		//Partie menu
		JMenuBar menuBar = new JMenuBar();
		//Menu1
		JMenu menu1 = new JMenu("ToucheCoule");
		JMenuItem demarrer = new JMenuItem();
		demarrer.setText("Démarrer");
		demarrer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){		
            	tc.getControleur().lancerViewPlacement(tc); 	
            }
		});
		menu1.add(demarrer);
		JMenuItem bouttonQuitter = new JMenuItem();
		bouttonQuitter.setText("Quitter jeu");
		bouttonQuitter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){		
            	System.exit(0);           	
            }
		});
		menu1.add(bouttonQuitter);
		menuBar.add(menu1);
		//Menu2
		JMenu menu2 = new JMenu("Règles");
		JMenuItem bouttonRegle = new JMenuItem();
		bouttonRegle.setText("Règles");
		bouttonRegle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){		
            	JOptionPane.showMessageDialog(tc.getControleur().getFenetreAccueil(), "Touché-Coulé est un jeu de bataille navale, il se joue à deux et son principe est très simple ; en premier lieu, chaque joueur place ses bateaux sur sa propre grille, une fois que les deux joueurs ont validé leurs choix, le jeu peut commencer.");
            }
		});
		menu2.add(bouttonRegle);		
		menuBar.add(menu2);
		//Menu3
		JMenu menu3 = new JMenu("?");
		JMenuItem bouttonAPropos = new JMenuItem();
		bouttonAPropos.setText("A propos");
		bouttonAPropos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){		
            	JOptionPane.showMessageDialog(tc.getControleur().getFenetreAccueil(), "Ce programme a été développé par Vogeleer Martin, Blan Romain et Van Born Mathias");
            }
		});
		menu3.add(bouttonAPropos);
		menuBar.add(menu3);
		setJMenuBar(menuBar);		
	}

	/*
	 * Méthode qui construit le panel et ses composant.
	 * @return retourne le panel
	 */
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 0, 0));		
		//Partie composant
		JLabel label = new JLabel("Touche-Coule");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);		
		JButton bouttonDemarrer = new JButton();
		bouttonDemarrer.setText("Démarrer");
		bouttonDemarrer.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){	
		    	tc.getControleur().lancerViewPlacement(tc);
		    }
		});
		panel.add(bouttonDemarrer);		
		JButton bouttonQuitter = new JButton();
		bouttonQuitter.setText("Quitter jeu");
		bouttonQuitter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){		
            	System.exit(0);	
            }
		});
		panel.add(bouttonQuitter);
		return panel;
	}
}


	