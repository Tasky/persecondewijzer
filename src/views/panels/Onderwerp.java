package views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import views.SpeelScherm;
import views.components.ImagePanel;
import controllers.Spel;
import javax.swing.SwingConstants;

public class Onderwerp extends JPanel {

	/**
	 * Create the panel.
	 */
	public Onderwerp(final logic.Onderwerp onderwerp, final Spel spel) {
		setOpaque(false);
		setBorder(null);
		setLayout(new MigLayout("", "[123px:176.00,grow,fill]", "[40.00][100px:149.00:100px,grow,fill]"));
		try {
			JLabel lblSteden = new JLabel(onderwerp.getNaam());
			lblSteden.setHorizontalAlignment(SwingConstants.CENTER);
			lblSteden.setFont(new Font("Dialog", Font.PLAIN, 15));
			add(lblSteden, "cell 0 0,growx");

			// Dat je op het plaatje kan klikken
			ImagePanel image = new ImagePanel(onderwerp.getPlaatje());
			image.setBorder(new LineBorder(new Color(0, 0, 0)));
			image.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					spel.setOnderwerp(onderwerp);
					spel.openPanel(new SpeelScherm(spel));
				}
			});

			add(image, "cell 0 1,alignx center,aligny center");
			image.setAutoResize(true);

		} catch (IOException e) {
			e.printStackTrace();
			// TODO doet iets hiermee
		}
	}
}
