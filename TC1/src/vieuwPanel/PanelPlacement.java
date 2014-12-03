package vieuwPanel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import battleshipgame.viewcomponent.FleetComponent;
import battleshipgame.viewcomponent.FleetComponentModel;
import battleshipgame.viewcomponent.GridComponent;
import battleshipgame.viewcomponent.GridComponentModel;
import action.DemarrerAction;
import action.QuitterAction;



public class PanelPlacement {
	
	super();
    

            
    m_buttonReset = new JButton("Reset");
    m_buttonRandom = new JButton("Aleatoire");
    m_buttonFinish = new JButton("Termine");
    m_labelOwner = new JLabel(getJoueur().getNom());
            
    
    
    initGUI();
    initListener();
    refreshFinishButton();

	
}
