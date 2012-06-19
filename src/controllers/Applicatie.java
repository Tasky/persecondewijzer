package controllers;

import java.awt.EventQueue;

/**
 * Applicatieklasse, deze wordt gebruikt voor het opstarten van alles.
 * 
 */
public class Applicatie {
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Applicatie a = new Applicatie();
					a.nieuwSpel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Start een nieuw spel.
	 */
	public void nieuwSpel() {
		new Spel(this);
	}
}
