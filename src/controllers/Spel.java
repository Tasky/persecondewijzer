package controllers;

import java.awt.EventQueue;
import logic.Speler;


public class Spel {
	
	private static Speler speler;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		speler = new Speler();
		
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
		views.MainWindow window = new views.MainWindow(this);
	}
	
	public void setSpelerNaam( String naam ) {
		
		speler.setNaam(naam);
		
	}

}
