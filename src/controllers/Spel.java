package controllers;

import java.awt.EventQueue;

import javax.swing.JPanel;

import views.MainWindow;

import logic.JokerUitrekenaar;
import logic.Onderwerp;
import logic.Speler;


public class Spel {
	
	private Speler speler;
	private JokerUitrekenaar joker;
	private Onderwerp onderwerp;
	private MainWindow window;

	private int huidigeRonde = 1;
	
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
		
		window = new MainWindow(this);
	}
	
	public void openPanel(JPanel panel) { window.openPanel(panel); }
	
	/**
	 * Stel de spelernaam in.
	 * @param naam
	 */
	public void setSpelerNaam( String naam ) { speler.setNaam(naam); }
	
	/**
	 * Stel het ontwerp in.
	 * @param onderwerp
	 */
	public void setOnderwerp( Onderwerp onderwerp ) { this.onderwerp = onderwerp; }
	
}
