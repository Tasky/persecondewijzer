package controllers;

import java.awt.EventQueue;

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

	public Applicatie() {}

	public void nieuwSpel() {
		new Spel(this);
	}
}
