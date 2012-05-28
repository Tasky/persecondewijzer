package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

import views.panels.Timer;

public class WijzigAntwoord extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WijzigAntwoord frame = new WijzigAntwoord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WijzigAntwoord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[47.00][412.00,grow][49.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("Antwoorden wijzigen:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		getContentPane().add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 1,grow");
		
	    JPanel borderlayoutpanel = new JPanel();
	    scrollPane.setViewportView(borderlayoutpanel);
	    borderlayoutpanel.setLayout(new BorderLayout(0, 0));
	    
	    JPanel columnpanel = new JPanel();
	    borderlayoutpanel.add(columnpanel, BorderLayout.NORTH);
	    columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
	    columnpanel.setBackground(Color.gray);

		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 0 2,grow");
		panel.setLayout(new MigLayout("", "[131,fill][131.00,fill][grow][]", "[49.00,grow,fill]"));
		
		JButton button = new JButton("Stoppen");
		panel.add(button, "cell 0 0");
		
		JButton btnDoorgaan = new JButton("Doorgaan");
		panel.add(btnDoorgaan, "cell 1 0");
	    
		Timer panel_1 = new Timer();
		panel.add(panel_1, "cell 3 0,grow");
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

	    for(int i=0;i<9;i++)
	    {
	    	views.panels.WijzigAntwoordPanel speelscherm = new views.panels.WijzigAntwoordPanel();
		    columnpanel.add(speelscherm);
		}
	}
}
