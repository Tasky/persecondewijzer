package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;
import views.components.NiceButton;
import controllers.Spel;

/**
 * @author ?
 * 
 */
public class JokerScherm extends JPanel {
	public int	vragen	= 6;

	/**
	 * Create the panel.
	 * 
	 * @param speelscherm
	 * 
	 * @param spel
	 */
	public JokerScherm(final SpeelScherm speelscherm, final Spel spel) {
		setBackground(new Color(0, 0, 0, 150));
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[grow][300,center][grow]", "[grow][center][grow]"));

		JPanel panel = new JPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[300][300]", "[][][][][][]"));

		JLabel lblNewLabel = new JLabel("Hoeveel jokers wil je inzetten?");
		panel.add(lblNewLabel, "cell 0 0 2 1");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));

		final JSpinner spinner = new JSpinner();
		panel.add(spinner, "cell 0 1,grow");
		spinner.setModel(new SpinnerNumberModel(0, 0, spel.getMaxJokers(), 1));

		JLabel lblJokers = new JLabel("Jokers");
		panel.add(lblJokers, "cell 1 1,alignx left,growy");
		lblJokers.setForeground(Color.BLACK);
		lblJokers.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblJ = new JLabel("Je hebt nog " + spel.getMaxJokers() + " jokers");
		panel.add(lblJ, "cell 0 2");
		lblJ.setForeground(Color.BLACK);
		lblJ.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblEenJokerKost = new JLabel("Een joker kost " + spel.getJokerKosten() + " seconden");
		panel.add(lblEenJokerKost, "cell 1 2");
		lblEenJokerKost.setForeground(Color.BLACK);
		lblEenJokerKost.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblJeMoetDeze = new JLabel("Je moet deze ronde " + vragen + " vragen goed hebben");
		panel.add(lblJeMoetDeze, "cell 0 3");
		lblJeMoetDeze.setForeground(Color.BLACK);
		lblJeMoetDeze.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblJeHuidigeScore = new JLabel("Je huidige score is: ");
		panel.add(lblJeHuidigeScore, "cell 0 4");
		lblJeHuidigeScore.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblJeHuidigeScore.setForeground(Color.BLACK);

		NiceButton btnNewButton = new NiceButton("Verder");
		panel.add(btnNewButton, "cell 0 5 2 1,growx");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spel.zetJokersIn((Integer) spinner.getValue());
				speelscherm.openResultaten();
			}
		});
	}

}
