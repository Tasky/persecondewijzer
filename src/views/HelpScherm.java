package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import views.components.NiceButton;
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

		NiceButton btnTerug = new NiceButton("Terug");
		btnTerug.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.reset();
			}
		});

		JLabel spelregels = new JLabel();
		spelregels.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		spelregels.setBackground(Color.white);
		spelregels.setOpaque(true);
		spelregels
				.setText("<html><p>Ieder spel bestaat uit vier vragen en elke vraag uit negen onderdelen waarvoor een antwoord moet worden gekozen. Eventueel kan je je antwoorden verbeteren. Je mag niet twee keer hetzelfde antwoord geven. Doet Je dat toch, dan geldt het eerste onderdeel als onbeantwoord (tenzij je alsnog een ander antwoord kiest).</p><br />" +
						"<p>Als speler heb je een jokersaldo. Bij het begin van de aflevering krijgt je twee jokers. Worden alle onderdelen van een vraag goed beantwoord (eventueel door het inzetten van jokers), dan krijgt je er een joker bij.</p><br />" +
						"<p>Nadat de onderdelen beantwoord zijn, kan je jokers inzetten om gemiste of foute antwoorden af te kopen. Het inzetten van een joker kost 16 seconden speeltijd per stuk. Bovendien moet er wel voldoende jokersaldo zijn.</p><br />" +
						"<p>Je moet minimaal 5 van de 9 onderdelen goed hebben om door te gaan naar de volgende ronde. Het totaalbedrag dat gewonnen kan worden varieert afhankelijk van het spelverloop. Je ontvangt een bedrag zodra je na een ronde stopt.</p></html>");




		setLayout(new MigLayout("", "[grow][500.00px][grow]", "[80.00][10.00][450.00px,grow][40.00px][11.00,grow]"));

		JLabel lblHelp = new JLabel("Spelregels");
		lblHelp.setForeground(Color.WHITE);
		lblHelp.setFont(new Font("Dialog", Font.PLAIN, 40));
		add(lblHelp, "cell 1 0,alignx center,aligny center");
		add(btnTerug, "cell 1 3,grow");
		add(spelregels, "cell 1 2,grow");
	}
}
