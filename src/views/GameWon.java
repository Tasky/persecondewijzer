package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import views.components.NiceButton;
import views.components.NicePanel;
import controllers.Spel;

public class GameWon extends NicePanel {

	/**
	 * Create the frame.
	 */
	public GameWon(final Spel spel) {
		setForeground(Color.WHITE);
		setBounds(0, 0, 800, 543);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		NiceButton btnTerug = new NiceButton("Terug");
		btnTerug.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spel.backToMainMenu();
			}
		});
		setLayout(new MigLayout("", "[grow][500.00px][grow]", "[80.00][10.00][450.00px,grow][40.00px][11.00,grow]"));

		JLabel lblNewLabel = new JLabel("Gewonnen!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel, "flowy,cell 1 2,alignx center");
		add(btnTerug, "cell 1 3,grow");

		JLabel lblDeTijdIs = new JLabel("Je hebt " + spel.getEindScore() + " gewonnen.");
		lblDeTijdIs.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblDeTijdIs.setForeground(Color.WHITE);
		add(lblDeTijdIs, "cell 1 2,alignx center");

		spel.addHighScore();
	}
}
