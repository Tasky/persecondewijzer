package controllers;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JPanel;

import data.Content;
import exceptions.DataException;

import views.MainWindow;
import views.SpeelScherm;

import logic.JokerUitrekenaar;
import logic.Onderwerp;
import logic.Onderdeel;
import logic.Speler;
import logic.Vraag;


public class Spel {
	
	private Speler speler;
	private JokerUitrekenaar joker;
	private Onderwerp _onderwerp;
	private MainWindow window;

	private int huidigeRonde = 0;
	private Content content;
	private List<Vraag> vragen;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Spel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Contructor
	 */
	public Spel() {
		speler = new Speler();
		joker = new JokerUitrekenaar();
		
		content = new Content();
		
		window = new MainWindow(this);
	}
	
	public void openPanel(JPanel panel) { window.openPanel(panel); }
	
	/**
	 * Spelermethodes
	 * @param naam
	 */
	public void setSpelerNaam( String naam ) { speler.setNaam(naam); }
	public String getSpelerNaam() { return speler.getNaam(); }
		
	/**
	 * Stel het ontwerp in.
	 * @param onderwerp
	 */
	public void setOnderwerp( Onderwerp onderwerp ) {
		this._onderwerp = onderwerp;
		try {
			vragen = content.getVragen(_onderwerp.getNaam());
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Joker methodes
	 */
	public int getJokerAantal() { return joker.getAantal(); }
	public void addJoker() { joker.addJoker(); }
	public void verwijderJokers( int aantal ) {	joker.verwijderJokers(aantal); }

	public List<Onderwerp> getOnderwerpen() throws DataException {
		return content.getOnderwerpen();
	}

	public List<logic.Onderdeel> getOnderdelen() {
		// TODO Auto-generated method stub
		
		return vragen.get(huidigeRonde).getOnderdelen();
	}
}
