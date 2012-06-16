package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Onderwerp;
import net.miginfocom.swing.MigLayout;
import views.components.NicePanel;
import controllers.Spel;
import exceptions.DataException;

public class KiesOnderwerp extends NicePanel {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		setBounds(0, 0, 773, 318);
		setLayout(new MigLayout("", "[100px:100px:100px,grow][700px,grow][100px:100px:100px]",
				"[173.00px][150.00][150px][173.00px,grow]"));

		/**
		 * De titel "Kies een onderwerp"
		 */
		JLabel lblNewLabel = new JLabel("Kies een onderwerp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		add(lblNewLabel, "flowx,cell 1 1,alignx center,aligny center");

		JPanel panel = new JPanel();
		add(panel, "cell 1 2,alignx center,aligny center");
		panel.setLayout(new MigLayout("", "[40px,grow][40px,grow][40px,grow][40px,grow][40px,grow]", "[]"));

		try {
			List<Onderwerp> onderwerpen;
			onderwerpen = spel.getOnderwerpen();
			for (Onderwerp onderwerp : onderwerpen)
				panel.add(new views.panels.Onderwerp(onderwerp, spel));

		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
