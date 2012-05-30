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

public class Highscore extends NicePanel {
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
					Highscore ko = new Highscore(new MainWindow());
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
	public Highscore(final MainWindow mainWindow) {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[grow]", "[84.00][111.00,grow][]"));
		
		JLabel lblNewLabel = new JLabel("Highscores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		add(lblNewLabel, "cell 0 0");
		
		JButton btnTerug = new JButton("Terug");
		btnTerug.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.reset();
			}
		});
		
		
		DefaultTableModel model = new DefaultTableModel(new Object[][]{
				{ "1.", "Nanne", "Û 7500,-", "100sec over" },
				{ "2.", "Bas", "Û 7300,-", "30sec over" },
				{ "3.", "Jodi", "Û 7100,-", "10sec over" },
			},
			new Object[] { "Plek", "Naam", "Prijs", "Tijd" });
		table = new JTable(model);
		add(table, "cell 0 1,grow");
		add(btnTerug, "cell 0 2,alignx right");

	}
}
