package views;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;


import controllers.Spel;
import exceptions.DataException;

import views.components.NicePanel;

import java.util.List;

import logic.Onderwerp;
import java.awt.FlowLayout;

public class KiesOnderwerp extends NicePanel {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spel spel = new Spel();
					KiesOnderwerp ko = new KiesOnderwerp(spel);
					spel.openPanel(ko);
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
		setBounds(0, 0, 557, 318);
		setLayout(new MigLayout("", "[784px,grow]", "[60px][248.00px,grow]"));
		
		/**
		 * De titel "Kies een onderwerp"
		 */
		JLabel lblNewLabel = new JLabel("Kies een onderwerp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		add(lblNewLabel, "flowx,cell 0 0,alignx left,aligny top");
		
		/**
		 * Hier worden de onderwerpen op getoont
		 */
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_1.setLayout(fl_panel_1);

		
	    try {
			List<Onderwerp> onderwerpen;
			onderwerpen = spel.getOnderwerpen();
			for (Onderwerp onderwerp : onderwerpen) {
					panel_1.add(new views.panels.Onderwerp(onderwerp, spel));
			}
			
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
