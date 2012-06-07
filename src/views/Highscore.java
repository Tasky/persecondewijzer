package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JScrollPane;

import views.components.NicePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import views.components.NicePanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.Spel;

public class Highscore extends NicePanel {
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
					Highscore ko = new Highscore(new MainWindow(null), null);
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
	public Highscore(final MainWindow mainWindow, final Spel spel) {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[grow]", "[80.00][111.00,grow][40.00]"));
		
		JLabel lblNewLabel = new JLabel("Highscores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		
		JButton btnTerug = new JButton("Terug");
		btnTerug.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.reset();
				spel.openPanel(new JokerScherm(spel));
			}
		});

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1.", "Jodi", "7500", "5:00"},
				{"2.", "Nanne", "300", "0:10"},
				{"3.", "Bas", "1", "0:01"},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Rang", "Naam", "Prijzengeld", "Tijd over"
			}
		));
		add(table, "cell 0 1,grow");
		add(btnTerug, "cell 0 2,grow");

	}
}
