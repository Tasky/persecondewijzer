package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import views.components.NicePanel;

public class HelpScherm extends NicePanel {
	public static void main1(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
					HelpScherm ko = new HelpScherm(new MainWindow(null));
					frame.setContentPane(ko);
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
	public HelpScherm(final MainWindow mainWindow) {
		setBounds(0, 0, 800, 543);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JButton btnTerug = new JButton("Terug");
		btnTerug.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnTerug.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.reset();
			}
		});

		JEditorPane dtrpnHierKomtDe = new JEditorPane();
		dtrpnHierKomtDe
				.setText("Ieder spel bestaat uit vier vragen en elke vraag uit negen onderdelen waarvoor een \r\nantwoord moet worden gekozen. Eventueel kan je je antwoorden verbeteren. Je mag niet \r\ntwee keer hetzelfde antwoord geven. Doet Je dat toch, dan geldt het eerste onderdeel als \r\nonbeantwoord (tenzij je alsnog een ander antwoord kiest).\r\n\r\nAls speler heb je een jokersaldo. Bij het begin van de aflevering krijgt je twee jokers. \r\nWorden alle onderdelen van een vraag goed beantwoord \r\n(eventueel door het inzetten van jokers), dan krijgt je er een joker bij.\r\n\r\nNadat de onderdelen beantwoord zijn, kan je jokers inzetten om gemiste of foute \r\nantwoorden af te kopen. Het inzetten van een joker kost 16 seconden speeltijd per stuk. \r\nBovendien moet er wel voldoende jokersaldo zijn.\r\n\r\nJe moet minimaal 5 van de 9 onderdelen goed hebben om door te gaan naar de volgende ronde. Het totaalbedrag dat gewonnen kan worden varieert afhankelijk van het spelverloop. Je ontvangt een bedrag zodra je na een ronde stopt.");
		dtrpnHierKomtDe.setEditable(false);
		setLayout(new MigLayout("", "[grow][500.00px][grow]",
				"[80.00][10.00][450.00px,grow][40.00px][11.00,grow]"));

		JLabel lblHelp = new JLabel("Spelregels");
		lblHelp.setForeground(Color.WHITE);
		lblHelp.setFont(new Font("Dialog", Font.PLAIN, 40));
		add(lblHelp, "cell 1 0,alignx center,aligny center");
		add(btnTerug, "cell 1 3,grow");
		add(dtrpnHierKomtDe, "cell 1 2,grow");
	}
}
