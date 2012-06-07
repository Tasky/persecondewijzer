package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;

import views.components.NicePanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;

	
	public class HelpScherm extends NicePanel {
		private JTable table;

		public static void main1(String[] args) {
			EventQueue.invokeLater(new Runnable() {
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
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.reset();
			}
		});
		
		JEditorPane dtrpnHierKomtDe = new JEditorPane();
		dtrpnHierKomtDe.setText("Ieder spel bestaat uit vier vragen en elke vraag uit negen onderdelen waarvoor een antwoord moet worden gekozen. Eventueel kan je je antwoorden verbeteren. Je mag niet twee keer hetzelfde antwoord geven. Doet Je dat toch, dan geldt het eerste onderdeel als onbeantwoord (tenzij je alsnog een ander antwoord kiest).\r\n\r\nAls speler heb je een jokersaldo. Bij het begin van de aflevering krijgt je twee jokers. Worden alle onderdelen van een vraag goed beantwoord (eventueel door het inzetten van jokers), dan krijgt je er een joker bij.\r\n\r\nNadat de onderdelen beantwoord zijn, kan je jokers inzetten om gemiste of foute antwoorden af te kopen. Het inzetten van een joker kost 16 seconden speeltijd per stuk. Bovendien moet er wel voldoende jokersaldo zijn.\r\n\r\nJe moet minimaal 5 van de 9 onderdelen goed hebben om door te gaan naar de volgende ronde. Het totaalbedrag dat gewonnen kan worden varieert afhankelijk van het spelverloop. Je ontvangt een bedrag zodra je na een ronde stopt.");
		dtrpnHierKomtDe.setEditable(false);
		setLayout(new MigLayout("", "[770px,grow]", "[80.00][300.00px,grow][40.00px]"));
		
		JLabel lblHelp = new JLabel("Spelregels");
		lblHelp.setForeground(Color.WHITE);
		lblHelp.setFont(new Font("Dialog", Font.PLAIN, 40));
		add(lblHelp, "cell 0 0,alignx center,aligny center");
		add(btnTerug, "cell 0 2,grow");
		add(dtrpnHierKomtDe, "cell 0 1,grow");
	}
}
