package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;

import views.components.Icon;
import views.components.ImagePanel;
import views.panels.Timer;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Color;
public class SpeelScherm extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpeelScherm frame = new SpeelScherm();
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
	public SpeelScherm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[46.00][393.00,grow][grow]"));
		
		JLabel lblWelkeStadHoort = new JLabel("Welke stad hoort er bij dit plaatje?");
		lblWelkeStadHoort.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		getContentPane().add(lblWelkeStadHoort, "cell 0 0");
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[142.00,left][grow,leading]", "[grow]"));
		
		JPanel antwoorden = new JPanel();
		panel_2.add(antwoorden, "cell 0 0,alignx left,growy");
		antwoorden.setLayout(new MigLayout("", "[45px,fill][25px:25px:25px,grow,right][]", "[16px][][][][][][][][]"));
		
		
		ArrayList<String> opties = new ArrayList<String>();
		opties.add("Brussel");
		opties.add("Kopenhagen");
		opties.add("Berlijn");
		opties.add("Parijs");
		opties.add("Dublin");
		opties.add("Rome");
		opties.add("Athene");
		opties.add("Oslo");
		opties.add("Monaco");
		
		int cell = 0;
		for (String optie : opties) {
			JLabel label = new JLabel(optie);
			label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			antwoorden.add(label, "cell 0 "+cell+",alignx left,aligny top");
			
			// Bepaalde opties al gekozen maken.. (als voorbeeld)
			if(cell == 2 || cell == 3 || cell == 6 || cell == 7)
			{
				label.setForeground(Color.GRAY);
				Icon pencilIcon = null;
				try {
					pencilIcon = new Icon("pencil");
				} catch (IOException e1) {
					// Icoontje foetsie..
					e1.printStackTrace();
				}
				antwoorden.add(pencilIcon, "cell 1 "+cell+",grow");
			}
			cell++;
		}
		
		ImagePanel plaatje;
		try {
			plaatje = new ImagePanel("images/stad.jpg");
			panel_2.add(plaatje, "cell 1 0,grow");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 0 2,grow");
		panel.setLayout(new MigLayout("", "[131.00,fill][grow][]", "[49.00,grow,fill]"));
		
		JButton btnNewButton = new JButton("Stoppen");
		panel.add(btnNewButton, "cell 0 0");
		
		Timer panel_1 = new Timer();
		panel.add(panel_1, "cell 2 0,grow");
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
	}
}
