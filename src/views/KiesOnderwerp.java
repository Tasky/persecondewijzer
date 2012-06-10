package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JScrollPane;

import controllers.Spel;
import exceptions.DataException;

import views.components.ImagePanel;
import views.components.NicePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import logic.Onderwerp;
import javax.swing.ScrollPaneConstants;

public class KiesOnderwerp extends NicePanel {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
					KiesOnderwerp ko = new KiesOnderwerp(null);
					frame.setContentPane(ko);
					ko.updateUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public KiesOnderwerp(Spel spel) {
		setBounds(0, 0, 798, 319);
		setLayout(new MigLayout("", "[784px,grow]", "[60px][248.00px]"));
		
		//De titel "Kies een onderwerp"
		JLabel lblNewLabel = new JLabel("Kies een onderwerp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		add(lblNewLabel, "flowx,cell 0 0,alignx left,aligny top");
	    	    	    	    
	    
		
		JPanel panel = new JPanel();
	    add(panel, "cell 0 1,grow");
	    
	    
	    JPanel borderlayoutpanel = new JPanel();
	    panel.add(borderlayoutpanel);
	    borderlayoutpanel.setLayout(new BorderLayout(0, 0));
	    
	    
	    //De streep tussen Steden en plaatje
	    JPanel columnpanel = new JPanel();
	    panel.add(columnpanel);
	    columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
	    columnpanel.setBackground(Color.red);

		
	    try {
			List<Onderwerp> onderwerpen;
			onderwerpen = spel.getOnderwerpen();
			for (Onderwerp onderwerp : onderwerpen) {
				columnpanel.add(new views.panels.Onderwerp(onderwerp, spel));
			}
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
