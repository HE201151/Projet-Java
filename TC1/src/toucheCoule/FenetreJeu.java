package toucheCoule;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FenetreJeu extends JFrame {

	private JPanel contentPane;
	Bateau b1 = new Bateau();
	


	public FenetreJeu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		grille();
		setContentPane(contentPane);
		//placerBateau();
	}
	
	
	private void placerBateau(int i) {
		int j=0;

	}


	public void grille(){
		JButton[][] maGrille = new JButton [5][5];
		contentPane.setLayout(new GridLayout(5, 5, 0, 0));
		int i, j;
		for(i=0;i<=4;i++){
			for(j=0;j<=4;j++){
			maGrille[i][j]= new JButton();
			maGrille[i][j].setName(""+i+j);
			maGrille[i][j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object source = e.getSource();
					if (source instanceof JButton) {
						JButton button = (JButton) source;
						int i = Integer.parseInt(button.getName());
						placerBateau(i);
					}
				}	
			});
			contentPane.add(maGrille[i][j]);
			}
		}
		
	}
	


}
