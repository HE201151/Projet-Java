package toucheCoule;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import action.AProposAction;
import action.DemarrerAction;
import action.QuitterAction;
import action.RegleAction;

public class FenetreAccueil extends JFrame {
	
	public FenetreAccueil(){
		super();
		build();
	}

	private void build(){
		
		setTitle("ToucheCoule"); //On donne un titre à l'application
		setSize(700,500); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
		
		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("ToucheCoule");
		JMenuItem demarrer = new JMenuItem(new DemarrerAction(this, "Démarrer"));
		menu1.add(demarrer);
		
		JMenuItem quitter = new JMenuItem(new QuitterAction(this, "Quitter"));
		menu1.add(quitter);
		menuBar.add(menu1);

		JMenu menu2 = new JMenu("Règles");
		JMenuItem regle = new JMenuItem(new RegleAction(this, "Règles"));
		menu2.add(regle);
		menuBar.add(menu2);
		
		JMenu menu3 = new JMenu("?");
		JMenuItem aPropos = new JMenuItem(new AProposAction(this, "A propos"));
		menu3.add(aPropos);
		menuBar.add(menu3);
		
		setJMenuBar(menuBar);
		
	}

	/**
	 * Create the frame.
	 */
	private JPanel buildContentPane(){

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		
		
		JLabel lblTouchecoule = new JLabel("Touche-Coule");
		lblTouchecoule.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTouchecoule);
		
		JButton demarrer = new JButton(new DemarrerAction(this, "Démarrer"));
		panel.add(demarrer);
		
		JButton quitter = new JButton(new QuitterAction(this, "Quitter"));
		panel.add(quitter);
		
		return panel;
	}

}