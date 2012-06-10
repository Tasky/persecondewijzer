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

import controllers.Spel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;

public class Onderwerp extends JPanel {

	/**
	 * Create the panel.
	 */
	public Onderwerp(final logic.Onderwerp onderwerp, final Spel spel) {
		setBorder(null);
		setLayout(new MigLayout("", "[123.00,fill][21.00][408.00,grow][]", "[][100px:149.00:100px,grow,fill]"));
	    try {
		    JLabel lblSteden = new JLabel(onderwerp.getNaam());
		    lblSteden.setFont(new Font("Dialog", Font.PLAIN, 24));
		    add(lblSteden, "cell 0 0");
		    
		    //Dat je op het plaatje kan klikken
		    ImagePanel image = new ImagePanel(onderwerp.getPlaatje());
		    image.addMouseListener(new MouseAdapter() 
		    	{	@Override
		    		public void mouseClicked(MouseEvent arg0)
		    		{
		    		  spel.setOnderwerp(onderwerp);
		    	      spel.openPanel(new SpeelScherm(spel));
		    		}
		    	}
		    );
		    
		    add(image, "cell 0 1");
		    image.setAutoResize(true);

		} catch (IOException e) {
			e.printStackTrace();
			//TODO doet iets hiermee
		}
	}
}
