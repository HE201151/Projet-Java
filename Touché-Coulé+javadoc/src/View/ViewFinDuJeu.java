package View;
/*
 *Projet Java Janvier 2014
 *@author Blan Romain et Vogeleer Martin
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.LancementJeu;

/*
 * Classe qui permet de voir une fenêtre de fin de jeu.
 */
public class ViewFinDuJeu extends JFrame {
	private LancementJeu tc;
	
	/*
	 * Instance qui crée la JFrame de fin de jeu.
	 * @param tc Base de données.
	 */
	public ViewFinDuJeu(LancementJeu tc){
		build(tc);
	}
	
	/*
	 * Méthode qui crée la JFrame.
	 */
	private void build(LancementJeu tc){		
		setTitle("Fin Du Jeu"); //On donne un titre à l'application
		setSize(300,500); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane(tc));
	}

	/*
	 * Méthode qui construit le panel et ses composant.
	 * @param tc base de données
	 * @return retourne le panel
	 */
	private JPanel buildContentPane(LancementJeu tc){
		this.tc=tc;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 0, 0));		
		JLabel label = new JLabel("Fin du jeu");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);				
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
