package controllers;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.GekozenAntwoord;
import logic.JokerUitrekenaar;
import logic.Onderdeel;
import logic.Onderwerp;
import logic.Speler;
import logic.Timer;
import logic.Vraag;
import views.MainWindow;
import data.Content;
import exceptions.DataException;

public class Spel {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new Spel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Speler				speler;
	private Timer				timer;
	private JokerUitrekenaar	joker;
	private Onderwerp			_onderwerp;

	private MainWindow			window;
	private int					huidigeRonde	= 0;
	private Content				content;

	private List<Vraag>			vragen;

	/**
	 * Contructor
	 */
	public Spel() {
		speler = new Speler();
		timer = new Timer();
		joker = new JokerUitrekenaar();

		try {
			content = new Content();
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
			System.exit(0);
			return;
		}
		window = new MainWindow(this);
	}

	public void backToMainMenu() {
		window.reset();
	}

	public logic.Onderdeel getHuidigeOnderdeel() {
		return getHuidigeVraag().getHuidigeOnderdeel();
	}

	private Vraag getHuidigeVraag() {
		return vragen.get(huidigeRonde);
	}

	/**
	 * Joker methodes
	 */
	public int getJokerAantal() {
		return joker.getAantal();
	}

	public ArrayList<Onderdeel> getOnderdelen() {
		return getHuidigeVraag().getOnderdelen();
	}

	public List<Onderwerp> getOnderwerpen() throws DataException {
		return content.getOnderwerpen();
	}

	public String getSpelerNaam() {
		return speler.getNaam();
	}

	public String getVraagTekst() {
		return getHuidigeVraag().getTekst();
	}

	public GekozenAntwoord kiesOnderdeel(Onderdeel optie) {
		return getHuidigeVraag().kiesAntwoord(optie);
	}

	public void openPanel(JPanel panel) {
		window.openPanel(panel);
	}

	/**
	 * Stel het ontwerp in.
	 * 
	 * @param onderwerp
	 */
	public void setOnderwerp(Onderwerp onderwerp) {
		_onderwerp = onderwerp;
		try {
			vragen = content.getVragen(_onderwerp.getNaam());
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Spelermethodes
	 * 
	 * @param naam
	 */
	public void setSpelerNaam(String naam) {
		speler.setNaam(naam);
	}

	public void verwijderJokers(int aantal) {
		joker.verwijderJokers(aantal);
	}

	public void volgendeOnderdeel() {
		getHuidigeVraag().volgendeOnderdeel();
	}

	public void volgendeVraag() {
		huidigeRonde++;
	}

	public void wijzigAntwoord(Onderdeel van, Onderdeel naar) {
		getHuidigeVraag().wijzigAntwoord(van, naar);
	}

	public void zetJokersIn(int jokers) {
		joker.zetJokersIn(jokers);
	}
}
