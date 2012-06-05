package controllers;

import java.awt.EventQueue;

public class Spel {
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
		views.MainWindow window = new views.MainWindow(this);
	}

}
