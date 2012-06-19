package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import logic.GekozenAntwoord;
import logic.Onderdeel;
import net.miginfocom.swing.MigLayout;
import views.components.ImagePanel;
import views.components.NiceButton;
import views.components.NicePanel;
import views.factories.JLabelFactory;
import views.factories.JPanelFactory;
import views.panels.OnderdeelButton;
import controllers.Spel;

/**
 * Ons prachige speelscherm.
 * @author bas
 */
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

	private int								currentCell			= 0;
	private final JPanel					middenvlak			= JPanelFactory.createTransparentJPanel();
	private ArrayList<Onderdeel>			onderdelen;
	private Onderdeel						huidigeOnderdeel;
	private JPanel							gekozenAntwoordenPanel;

	private Spel							spel;

	private ArrayList<OnderdeelButton>		buttons				= new ArrayList<OnderdeelButton>();

	ArrayList<views.panels.GekozenAntwoord>	gekozenAntwoorden	= new ArrayList<views.panels.GekozenAntwoord>();
	private JButton	btnStoppen;

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
		setLayout(new MigLayout("ins 0 10px 10px 10px", "[124][grow][]",
				"[110.00][350px:24.00,grow][:126.00:250px,grow,fill]"));

		// Middenvlak toevoegen
		middenvlak.setLayout(new GridLayout(1, 0, 0, 0));
		add(middenvlak, "cell 1 1 2 1,grow");

		// Vraag toevoegen
		add(JLabelFactory.createJLabel(vraag), "cell 1 0 2 1");

		// Toon kiesbare onderdelen
		JPanel buttonsPanel = JPanelFactory.createTransparentJPanel();
		buttonsPanel.setLayout(new MigLayout("ins 10px 10px 0 10px", "[grow]",
				"[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		add(buttonsPanel, "cell 0 1,grow");
		toonOnderdelen(buttonsPanel, onderdelen);

		gekozenAntwoordenPanel = JPanelFactory.createTransparentJPanel();
		gekozenAntwoordenPanel.setBackground(new Color(0, 0, 0, 0));
		gekozenAntwoordenPanel.setLayout(new MigLayout("ins 0", "[][][][][][][][][][]", "[grow,fill]"));

		JScrollPane scrollPane = JPanelFactory.createJScrollPane(gekozenAntwoordenPanel);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.white));
		add(scrollPane, "cell 0 2 2 1,grow");

		volgendeOnderdeel();
		toonInfoPanel(spel);
		spel.getTimer().start();
		spel.getTimer().addObserver(new Observer(){

			@Override
			public void update(Observable arg0, Object arg1) {
				if(spel.getTimer().hasLost())
					spel.openPanel(new GameOver(spel, GameOver.Reason.TIMEUP));
			}
			
		});
	}

	/**
	 * Kies onderdeel.
	 * 
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

		views.panels.GekozenAntwoord gkView = new views.panels.GekozenAntwoord(gk, onderdelenComboBoxModel);
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

	
	/**
	 * Open het jokerscherm.
	 */
	public void openJokerscherm() {
		middenvlak.removeAll();
		for (JButton button : buttons)
			button.setEnabled(false);
		middenvlak.add(new JokerScherm(this, spel));
		middenvlak.revalidate();
		middenvlak.repaint();

		btnStoppen.setEnabled(false);
		spel.getTimer().stop();
	}
	/**
	 * Geef resultaten weer.
	 */
	public void openResultaten() {
		for (views.panels.GekozenAntwoord gk : gekozenAntwoorden)
			gk.geefLijntje(true);
		middenvlak.removeAll();
		for (JButton button : buttons)
			button.setEnabled(false);
		middenvlak.revalidate();
		middenvlak.repaint();
		middenvlak.add(new ResultatenScherm(spel));
	}
	
	private void toonInfoPanel(final Spel spel) {
		JPanel infoPanel = JPanelFactory.createTransparentJPanel();
		add(infoPanel, "cell 2 2,grow");
		infoPanel.setLayout(new MigLayout("", "[116px,grow]", "[grow,fill][154px]"));

		final views.panels.InfoPanel timer = new views.panels.InfoPanel(spel);
		spel.getTimer().addObserver(timer);
		infoPanel.add(timer, "cell 0 0,grow");

		NiceButton btnStoppen = new NiceButton("Stop de tijd");
		infoPanel.add(btnStoppen, "cell 0 1,grow");

		btnStoppen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openJokerscherm();
			}
		});
		
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

	private void volgendeOnderdeel() throws IOException {
		spel.volgendeOnderdeel();
		huidigeOnderdeel = spel.getHuidigeOnderdeel();

		if (huidigeOnderdeel != null) {
			middenvlak.removeAll();
			ImagePanel plaatje = new ImagePanel(huidigeOnderdeel.getPlaatje());
			plaatje.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			plaatje.setAutoResize(true);
			middenvlak.add(plaatje);
		}
		middenvlak.revalidate();
		middenvlak.repaint();
	}
}
