package views.panels;

import java.io.IOException;

import javax.swing.JPanel;


import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import views.components.ImagePanel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Onderwerp extends JPanel {

	/**
	 * Create the panel.
	 */
	public Onderwerp(logic.Onderwerp onderwerp, ActionListener action) {
		setBorder(null);
		setLayout(new MigLayout("", "[123.00,fill][21.00][408.00,grow][]", "[135.00,grow,fill]"));
	    try {
		    ImagePanel image = new ImagePanel(onderwerp.getPlaatje());
		    //image.setBounds(5, 5, 100, 100);
		    add(image, "cell 0 0");
		    
		    JLabel lblHalloWereld = new JLabel(onderwerp.getNaam());
		    lblHalloWereld.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		    add(lblHalloWereld, "cell 2 0");
		    
		    JPanel panel = new JPanel();
		    add(panel, "cell 3 0,grow");
		    panel.setLayout(new MigLayout("", "[grow]", "[18.00][60.00,fill][]"));
		    
		    JButton btnNewButton = new JButton("Kiezen...");
		    btnNewButton.addActionListener(action);
		    panel.add(btnNewButton, "cell 0 1,aligny center");
		} catch (IOException e) {
			e.printStackTrace();
			//TODO doet iets hiermee
		}
	}

}
