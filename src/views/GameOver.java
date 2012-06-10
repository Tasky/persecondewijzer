package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;

import views.components.NicePanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import controllers.Spel;

import java.awt.Color;

public class GameOver extends NicePanel {

	/**
	 * Create the frame.
	 */
	public GameOver(final Spel spel) {
		setForeground(Color.WHITE);
		setBounds(0, 0, 800, 543);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JButton btnTerug = new JButton("Terug");
		btnTerug.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spel.backToMainMenu();
			}
		});
		setLayout(new MigLayout("", "[grow][500.00px][grow]",
				"[80.00][10.00][450.00px,grow][40.00px][11.00,grow]"));

		JLabel lblNewLabel = new JLabel("Game Over");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel, "cell 1 2");
		add(btnTerug, "cell 1 3,grow");
	}
}
