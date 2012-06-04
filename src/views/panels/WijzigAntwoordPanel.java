package views.panels;

import java.io.IOException;

import javax.swing.JPanel;


import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import views.components.ImagePanel;

import java.awt.Font;
import javax.swing.JButton;

public class WijzigAntwoordPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WijzigAntwoordPanel() {
		setBorder(null);
		setLayout(new MigLayout("", "[60.00,fill][10.50][204.00,grow][grow][grow]", "[57.50,grow,fill]"));
	    try {
		    ImagePanel image = new ImagePanel("images/stad.jpg");
		    //image.setBounds(5, 5, 100, 100);
		    add(image, "cell 0 0");
		    
		    JLabel lblHalloWereld = new JLabel("ANTWOORD");
		    lblHalloWereld.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		    add(lblHalloWereld, "cell 2 0");
		    
		    JPanel panel = new JPanel();
		    add(panel, "cell 3 0,alignx right,growy");
		    panel.setLayout(new MigLayout("", "[grow,right]", "[18.00][60.00,fill][]"));
		    
		    JButton btnNewButton = new JButton("Wijzig");
		    panel.add(btnNewButton, "cell 0 1,aligny center");
		    
		    JPanel panel_1 = new JPanel();
		    add(panel_1, "cell 4 0,alignx right,growy");
		    
		    JButton button = new JButton("Zet Joker In");
		    panel_1.add(button);
		    panel.setLayout(new MigLayout("", "[grow,right]", "[18.00][60.00,fill][]"));
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
