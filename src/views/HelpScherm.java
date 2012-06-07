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

	
	public class HelpScherm extends NicePanel {
		private JTable table;

		public static void main1(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						JFrame frame = new JFrame();
						frame.setBounds(100, 100, 800, 600);
						frame.setVisible(true);
						Highscore ko = new Highscore(new MainWindow(null));
						frame.setContentPane(ko);
						ko.updateUI();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

/*	
	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpScherm frame = new HelpScherm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public HelpScherm(final MainWindow mainWindow) {
		setBounds(0, 0, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnTerug = new JButton("Terug");
		btnTerug.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.reset();
			}
		});
		
		JEditorPane dtrpnHierKomtDe = new JEditorPane();
		dtrpnHierKomtDe.setText("Hier komt de uitleg van het spel;\r\n\r\nSpelverloop, jokers ect");
		dtrpnHierKomtDe.setEditable(false);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnTerug, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(dtrpnHierKomtDe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(dtrpnHierKomtDe, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTerug)
					.addContainerGap())
		);
		setLayout(gl_contentPane);
	}
}
