package views.panels;

import java.io.IOException;

import javax.swing.JPanel;


import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import views.SpeelScherm;
import views.components.ImagePanel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;

public class Onderwerp extends JPanel {

	/**
	 * Create the panel.
	 */
	public Onderwerp(logic.Onderwerp onderwerp, ActionListener action) {
		setBorder(null);
		setLayout(new MigLayout("", "[123.00,fill][21.00][408.00,grow][]", "[][100px:135.00:100px,grow,fill][50.00px]"));
	    try {
		    JLabel lblSteden = new JLabel(onderwerp.getNaam());
		    lblSteden.setFont(new Font("Dialog", Font.PLAIN, 24));
		    add(lblSteden, "cell 0 0");
		    
		    
		    ImagePanel image = new ImagePanel(onderwerp.getPlaatje());
		    //image.setBounds(5, 5, 100, 100);
		    add(image, "cell 0 1");
		    image.setAutoResize(true);
		    image.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			//image.addActionListener(action);
		    
		    
		    JButton btnNewButton = new JButton("Kiezen...");
		    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    add(btnNewButton, "cell 0 2");
		    btnNewButton.addActionListener(action);
		} catch (IOException e) {
			e.printStackTrace();
			//TODO doet iets hiermee
		}
	}

}
