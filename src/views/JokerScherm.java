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
import javax.swing.JRadioButton;

public class JokerScherm extends JPanel {

	/**
	 * Create the panel.
	 */
	public JokerScherm() {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[200.00,grow][][130.00][200.00,grow]", "[200.00,grow][][][][-92.00][200.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("Hoeveel jokers wil je inzetten?");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		add(lblNewLabel, "cell 1 1 2 1");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		add(spinner, "cell 1 2,grow");
		
		JLabel lblJokers = new JLabel("Jokers");
		lblJokers.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(lblJokers, "cell 2 2,alignx left,growy");
		
		JLabel lblJ = new JLabel("Je hebt nog 5 jokers");
		lblJ.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(lblJ, "cell 1 3");
		
		JLabel lblEenJokerKost = new JLabel("Een Joker kost 15 seconden");
		lblEenJokerKost.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		add(lblEenJokerKost, "cell 2 3");
		
		JButton btnNewButton = new JButton("Verder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton, "cell 1 4 2 1,growx");
	}

}
