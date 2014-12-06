package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import Controleur.GoAction;
import Model.Run1;
import Controleur.Controleur;

public class ViewPlacement extends JFrame {

	private JPanel contentPane;
	String positionBouton="00";
	int selectionBateau;
	String tabSelection[]= {"Bateau de case 1","Bateau de cases 2","Bateau de cases 3","Bateau de cases 4","Bateau de cases 5"};
	
	JComboBox selection ;
	
	
	public ViewPlacement() {
		
		setTitle("viewPlacement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		//Panel de Base
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 5));
		
		//Panel supérieur gauche
		JPanel panel_3 = new JPanel();		
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Choissisez le bateau à placer");
		panel_3.add(lblNewLabel_1);
		
		selection = new JComboBox(tabSelection);
		panel_3.add(selection);
		
		
		
		//Panel inférieur gauche
		JPanel panel_4 = new JPanel();
		grille(panel_4);
		panel_1.add(panel_4);
		
		//Panel droite
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnNewButton = new JButton("Reset");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aléatoire");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(new GoAction(this, "Démarrer"));
		panel_2.add(btnNewButton_2);
	}
	
	public void grille(JPanel panel){
		final Controleur c = new Controleur();

		final JButton[][] maGrille = new JButton [10][10];
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		int i, j;
		for(i=0;i<=9;i++){
			for(j=0;j<=9;j++){
			maGrille[i][j]= new JButton();
			maGrille[i][j].setName(""+(i)+(j));
			
			maGrille[i][j].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){		// quand on clique sur le bouton on donne le nom de la case (qui sont ses coordonées)
	            	positionBouton=(((Component) e.getSource()).getName()+"");
	            	selectionBateau=selection.getSelectedIndex();
	            	//System.out.println(selectionBateau);
	            	
	            	c.click(Integer.parseInt(positionBouton), selectionBateau, e);
	            	
	            }
			});
			panel.add(maGrille[i][j]);
			
			}
		}
		
		
	}
	



}
