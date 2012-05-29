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

public class JokerScherm extends JPanel {

	/**
	 * Create the panel.
	 */
	public JokerScherm() {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[182.00,grow][502.00,grow]", "[grow][423.00,grow][grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		add(panel_1, "cell 0 0 2 1,grow");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		add(panel, "cell 0 1,grow");
		
		JPanel panel_3 = new JPanel();
		add(panel_3, "cell 1 1,grow");
		panel_3.setLayout(new MigLayout("", "[144.00][]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("Hoeveel jokers wil je inzetten?");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		panel_3.add(lblNewLabel, "cell 0 0 2 1");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		panel_3.add(spinner, "cell 0 1,grow");
		
		JLabel lblJokers = new JLabel("Jokers");
		lblJokers.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel_3.add(lblJokers, "cell 1 1,alignx left,growy");
		
		JLabel lblJ = new JLabel("Je hebt nog 5 jokers");
		lblJ.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel_3.add(lblJ, "cell 0 2");
		
		JLabel lblEenJokerKost = new JLabel("Een Joker kost 15 seconden");
		lblEenJokerKost.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel_3.add(lblEenJokerKost, "cell 1 2");
		
		JButton btnNewButton = new JButton("Verder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_3.add(btnNewButton, "cell 0 3 2 1,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		add(panel_2, "cell 0 2 2 1,grow");
		panel_2.setLayout(new MigLayout("", "[][][419.00][][40.00]", "[44.00]"));
		
		JButton btnStoppen = new JButton("Stoppen");
		panel_2.add(btnStoppen, "cell 0 0,grow");
		
		JButton btnDoorgaan = new JButton("Doorgaan");
		panel_2.add(btnDoorgaan, "cell 1 0,grow");
		
		JLabel lblOnderwerp = new JLabel("Onderwerp");
		lblOnderwerp.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		panel_2.add(lblOnderwerp, "cell 3 0");
		
		JLabel lblKlok = new JLabel("klok");
		lblKlok.setBackground(Color.WHITE);
		panel_2.add(lblKlok, "cell 4 0");
	}

}
