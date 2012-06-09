package views;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JRadioButton;

import controllers.Spel;

import views.components.NicePanel;

public class JokerScherm extends NicePanel {

	/**
	 * Create the panel.
	 * @param spel 
	 */
	public JokerScherm(final Spel spel) {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[100.00][300][300][100]", "[200.00,grow][][][][][][][200.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("Hoeveel jokers wil je inzetten?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		add(lblNewLabel, "cell 1 1 2 1");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		add(spinner, "cell 1 2,grow");
		
		JLabel lblJokers = new JLabel("Jokers");
		lblJokers.setForeground(Color.WHITE);
		lblJokers.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(lblJokers, "cell 2 2,alignx left,growy");
		
		JLabel lblJ = new JLabel("Je hebt nog 5 jokers");
		lblJ.setForeground(Color.WHITE);
		lblJ.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(lblJ, "cell 1 3");
		
		JLabel lblEenJokerKost = new JLabel("Een Joker kost 16 seconden");
		lblEenJokerKost.setForeground(Color.WHITE);
		lblEenJokerKost.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(lblEenJokerKost, "cell 2 3");
		
		JButton btnNewButton = new JButton("Verder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					spel.openPanel(new ResultatenScherm(spel));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblJeMoetDeze = new JLabel("Je moet deze ronde x vragen goed hebben");
		lblJeMoetDeze.setForeground(Color.WHITE);
		lblJeMoetDeze.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(lblJeMoetDeze, "cell 1 4");
		
		JLabel lblJeHuidigeScore = new JLabel("Je huidige score is: ");
		lblJeHuidigeScore.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblJeHuidigeScore.setForeground(Color.WHITE);
		add(lblJeHuidigeScore, "cell 1 5");
		add(btnNewButton, "cell 1 6 2 1,growx");
	}

}
