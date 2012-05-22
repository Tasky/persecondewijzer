package views.panels;

import java.io.IOException;

import javax.swing.JPanel;


import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import views.components.ImagePanel;

import java.awt.Font;

public class Onderwerp extends JPanel {

	/**
	 * Create the panel.
	 */
	public Onderwerp() {
		setLayout(new MigLayout("", "[161.00][grow]", "[135.00,grow]"));
	    try {
		    ImagePanel image = new ImagePanel("images/stad.jpg");
		    //image.setBounds(5, 5, 100, 100);
		    add(image, "cell 0 0");
		    
		    JLabel lblHalloWereld = new JLabel("Hallo wereld!");
		    lblHalloWereld.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		    add(lblHalloWereld, "cell 1 0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
