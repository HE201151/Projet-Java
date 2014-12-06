package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;


import Model.Run1;

public class ViewJeu extends JFrame {

	private JPanel contentPane;
	static String positionBouton="00";
	
	public ViewJeu() {
		setTitle("viewJeu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//PanelComplet
				JPanel panel = new JPanel();
				contentPane.add(panel, BorderLayout.CENTER);
				panel.setLayout(new GridLayout(0, 2, 0, 0));
				
				//Partie de gauche
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new GridLayout(2, 0, 0, 0));
				
				JLabel lblNewLabel = new JLabel("Ennemy");
				panel_1.add(lblNewLabel);
				
				JPanel panel_3 = new JPanel();	//Grille Ennemi
				grille(panel_3);
				panel_1.add(panel_3);
				
				panel_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

				//partie de droite
				JPanel panel_2 = new JPanel();
				panel.add(panel_2);
				panel_2.setLayout(new GridLayout(2, 0, 0, 0));
				
				JLabel lblNewLabel_1 = new JLabel("Owner");
				panel_2.add(lblNewLabel_1);
				
				JPanel panel_4 = new JPanel();	//Grille Owner
				grille(panel_4);
				panel_2.add(panel_4);
				
				panel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			}
	
	public void grille(JPanel panel){
		final Run1 r = new Run1();

		JButton[][] maGrille = new JButton [10][10];
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		int i, j;
		for(i=0;i<=9;i++){
			for(j=0;j<=9;j++){
			maGrille[i][j]= new JButton();
			maGrille[i][j].setName(""+(i)+(j));
			
			maGrille[i][j].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){		// quand on clique sur le bouton on donne le nom de la case (qui sont ses coordonées)
	            	//Instruction d'action
	            }
			});
			panel.add(maGrille[i][j]);
			
			}
		}
		
		
	}
	



}