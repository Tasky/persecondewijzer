package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import logic.GekozenAntwoord;
import logic.Onderdeel;
import net.miginfocom.swing.MigLayout;
import views.components.ImagePanel;
import views.components.NiceButton;
import views.components.NicePanel;
import views.panels.OnderdeelButton;
import controllers.Spel;

public class SpeelScherm extends NicePanel {
	/**
	 * Opstarten speelscherm, handig voor debuggen of snel testen.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Spel spel = new Spel();
					List<logic.Onderwerp> onderwerpen = spel.getOnderwerpen();
					spel.setOnderwerp(onderwerpen.get(1));
					spel.openPanel(new SpeelScherm(spel));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private int							currentCell	= 0;
	private final JPanel				middenvlak	= new JPanel();
	private ArrayList<Onderdeel>		onderdelen;
	private Onderdeel					huidigeOnderdeel;
	private JPanel						gekozenAntwoordenPanel;

	private Spel						spel;

	private ArrayList<OnderdeelButton>	buttons		= new ArrayList<OnderdeelButton>();

	/**
	 * Opstarten van speelscherm
	 * 
	 * @param spel
	 */
	public SpeelScherm(Spel spel) {
		try {
			initialize(spel);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param mainWindow
	 * @throws IOException
	 */
	private void initialize(final Spel spel) throws IOException {
		this.spel = spel;

		// Haal informatie uit de controller
		String vraag = spel.getVraagTekst();
		onderdelen = spel.getOnderdelen();

		// Layout instellingen
		setBounds(0, 0, 1024, 768);
		setLayout(new MigLayout("ins 0 10px 10px 10px", "[124][grow][]", "[110.00][350px:24.00,grow][:126.00:250px,grow,fill]"));

		// Middenvlak toevoegen
		middenvlak.setBackground(new Color(0,0,0,0));
		middenvlak.setLayout(new GridLayout(1, 0, 0, 0));
		add(middenvlak, "cell 1 1 2 1,grow");

		JLabel lblTitle = new JLabel(vraag);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 47));
		add(lblTitle, "cell 1 0 2 1");

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false);
		buttonsPanel.setLayout(new MigLayout("ins 10px 10px 0 10px", "[grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		add(buttonsPanel, "cell 0 1,grow");

		gekozenAntwoordenPanel = new JPanel();
		gekozenAntwoordenPanel.setBackground(new Color(0, 0, 0, 0));
		gekozenAntwoordenPanel.setLayout(new MigLayout("ins 0", "[][][][][][][][][][]", "[grow,fill]"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.white));
		scrollPane.setBackground(new Color(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(gekozenAntwoordenPanel);
		add(scrollPane, "cell 0 2 2 1,grow");

		volgendeOnderdeel();

		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[116px,grow]", "[grow,fill][154px]"));

		final views.panels.InfoPanel timer = new views.panels.InfoPanel(spel);
		panel_1.add(timer, "cell 0 0,grow");

		NiceButton btnStoppen = new NiceButton("Stop de tijd");
		initStopButton(timer, btnStoppen);
		panel_1.add(btnStoppen, "cell 0 1,grow");

		toonOnderdelen(buttonsPanel, onderdelen);

	}

	private void initStopButton(final views.panels.InfoPanel timer, final JButton btnStoppen) {
		final SpeelScherm speelscherm = this;
		btnStoppen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				middenvlak.removeAll();
				for (JButton button : buttons) {
					button.setEnabled(false);
				}
				middenvlak.add(new JokerScherm(speelscherm, spel));
				middenvlak.revalidate();
				middenvlak.repaint();

				btnStoppen.setEnabled(false);
				timer.stopTimer();
			}
		});
	}

	ArrayList<views.panels.GekozenAntwoord> gekozenAntwoorden = new ArrayList<views.panels.GekozenAntwoord>();
	/**
	 * @param optie
	 * @return
	 */
	private GekozenAntwoord kiesOnderdeel(final Onderdeel optie) {
		final GekozenAntwoord gk = spel.kiesOnderdeel(optie);

		final DefaultComboBoxModel onderdelenComboBoxModel = new DefaultComboBoxModel();
		for (Onderdeel comboOptie : onderdelen)
			onderdelenComboBoxModel.addElement(comboOptie);
		onderdelenComboBoxModel.setSelectedItem(gk.getGekozenOnderdeel());
		onderdelenComboBoxModel.addListDataListener(new ListDataListener() {
			@Override
			public void contentsChanged(ListDataEvent e) {
				Onderdeel van = gk.getGekozenOnderdeel();
				Onderdeel naar = (Onderdeel) onderdelenComboBoxModel.getSelectedItem();
				spel.wijzigAntwoord(van, naar);
			}

			@Override
			public void intervalAdded(ListDataEvent e) {}

			@Override
			public void intervalRemoved(ListDataEvent e) {}
		});

		views.panels.GekozenAntwoord gkView = new views.panels.GekozenAntwoord(huidigeOnderdeel.getPlaatje(),
				onderdelenComboBoxModel);
		gekozenAntwoordenPanel.add(gkView, "cell " + currentCell + " 0,grow");
		gekozenAntwoorden.add(gkView);
		gk.addObserver(gkView);
		currentCell++;

		gekozenAntwoordenPanel.getParent().validate();

		try {
			volgendeOnderdeel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gk;
	}

	private void toonOnderdelen(JPanel buttonsPanel, ArrayList<Onderdeel> onderdelen) {
		int cell = 0;
		
		ArrayList<Onderdeel> buttonOnderdelen = new ArrayList<Onderdeel>();
		for (Onderdeel optie : onderdelen)
			buttonOnderdelen.add(optie);
		
		Collections.shuffle(buttonOnderdelen);
		
		for (final Onderdeel optie : buttonOnderdelen) {
			final OnderdeelButton button = new OnderdeelButton(optie);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					GekozenAntwoord gk = kiesOnderdeel(optie);
					for (OnderdeelButton obs : buttons)
						gk.addObserver(obs);

					button.clicked(gk);
				}
			});
			buttonsPanel.add(button, "cell 0 " + cell + ",growx");
			buttons.add(button);
			cell++;
		}
	}

	/**
	 * @throws IOException
	 */
	private void volgendeOnderdeel() throws IOException {
		spel.volgendeOnderdeel();
		huidigeOnderdeel = spel.getHuidigeOnderdeel();

		if(huidigeOnderdeel != null) {
			middenvlak.removeAll();
			ImagePanel plaatje = new ImagePanel(huidigeOnderdeel.getPlaatje());
			plaatje.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			plaatje.setAutoResize(true);
			middenvlak.add(plaatje);
		}
		middenvlak.revalidate();
		middenvlak.repaint();
	}

	/**
	 * 
	 */
	public void openResultaten() {
		for (views.panels.GekozenAntwoord gk : gekozenAntwoorden) {
			gk.geefLijntje(true);
		
		}
		middenvlak.removeAll();
		for (JButton button : buttons) {
			button.setEnabled(false);
		}
		middenvlak.revalidate();
		middenvlak.repaint();
		middenvlak.add(new ResultatenScherm(spel));
	}
}
