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

public class KiesOnderwerp extends NicePanel {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
					KiesOnderwerp ko = new KiesOnderwerp(new MainWindow());
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
	public KiesOnderwerp(final MainWindow mainWindow) {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[grow]", "[84.00][111.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("Kies een onderwerp.");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");
		
	    JPanel borderlayoutpanel = new JPanel();
	    scrollPane.setViewportView(borderlayoutpanel);
	    borderlayoutpanel.setLayout(new BorderLayout(0, 0));

	    JPanel columnpanel = new JPanel();
	    borderlayoutpanel.add(columnpanel, BorderLayout.NORTH);
	    columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
	    columnpanel.setBackground(Color.gray);

	    for(int i=0;i<10;i++)
	    {
	    	views.panels.Onderwerp onderwerp = new views.panels.Onderwerp(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		mainWindow.openPanel(new SpeelScherm(mainWindow));
		    	}
		    });
	    	
		    columnpanel.add(onderwerp);
		}
	}
}
