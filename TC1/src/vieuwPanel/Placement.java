package vieuwPanel;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.JComboBox;

import toucheCoule.Run1;

public class Placement extends JFrame {

	private JPanel contentPane;
	static String positionBouton="00";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Placement frame = new Placement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Placement() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Bateau");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNbcase = new JLabel("nbCase");
		panel_3.add(lblNbcase);
		
		JLabel lblNewLabel_1 = new JLabel("Lettre");
		panel_3.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox);
		
		JLabel lblChiffre = new JLabel("Chiffre");
		panel_3.add(lblChiffre);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Direction");
		panel_3.add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_3.add(comboBox_2);
		
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
		
		JButton btnNewButton_2 = new JButton("GO");
		panel_2.add(btnNewButton_2);
	}
	
	public void grille(JPanel panel){
		Run1 r = new Run1();

		JButton[][] maGrille = new JButton [10][10];
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		int i, j;
		for(i=0;i<=9;i++){
			for(j=0;j<=9;j++){
			maGrille[i][j]= new JButton();
			maGrille[i][j].setName(""+(i)+(j));
			maGrille[i][j].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){		// quand on clique sur le bouton on donne le nom de la case (qui sont ses coordonées)
	            	positionBouton=(((Component) e.getSource()).getName()+"");
	            	r.placerBateaux(Integer.parseInt(positionBouton));
	            	//System.out.println(positionBouton);
	            	
	            }
			});
			panel.add(maGrille[i][j]);
			
			}
		}
		
		
	}
	



}
