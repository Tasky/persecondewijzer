package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import views.components.ImagePanel;
import views.components.NicePanel;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class MainWindow {

	private JFrame frame;
	private JTextField txtVulHierJe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new NicePanel());
		//frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[300.00,grow,left][100.00,grow,fill][100.00,grow][300.00,grow]", "[grow,fill][150px:150px:150px,fill][][][][][][100.00,grow]"));
		
		//Panel panel = new Panel();
		//panel.;
		//frame.getContentPane().add(panel, "cell 1 0 4 1,grow");
		
		ImagePanel hoofdmenuPlaatje;
		try {
			//panel.setLayout(new MigLayout("", "[1.00,grow][176.00px][1.00,grow]", "[grow][135.00px][grow]"));
			hoofdmenuPlaatje = new ImagePanel("images/PSWTitel.png");
			hoofdmenuPlaatje.setSize(176, 204);
			
			//panel.add(hoofdmenuPlaatje, "cell 1 0 4 1,grow");
			frame.getContentPane().add(hoofdmenuPlaatje, "cell 1 1 2 1,alignx left,aligny baseline");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtVulHierJe = new JTextField();
		txtVulHierJe.setText("Vul hier je naam in");
		frame.getContentPane().add(txtVulHierJe, "cell 1 2 2 1,growx");
		txtVulHierJe.setColumns(10);
		
		JButton btnNewButton = new JButton("Spelregels");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpScherm helpScherm = new HelpScherm();
				frame.setContentPane(helpScherm);
				helpScherm.updateUI();
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 1 3,growx");
		
		JButton btnNewButton_3 = new JButton("Start");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String naamNo = txtVulHierJe.getText();
						
				if (naamNo.equals("Vul hier je naam in") || naamNo.equals(""))
				{
					txtVulHierJe.setBackground(Color.red);
				}
				else
				{
					String naam = txtVulHierJe.getText();
					KiesOnderwerp kiesOnderwerp = new KiesOnderwerp();
					frame.setContentPane(kiesOnderwerp);
					kiesOnderwerp.updateUI();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_3, "cell 2 3 1 3,grow");
		
		JButton btnNewButton_1 = new JButton("Beheer");
		frame.getContentPane().add(btnNewButton_1, "cell 1 4,growx");
		
		JButton btnNewButton_2 = new JButton("Highscores");
		frame.getContentPane().add(btnNewButton_2, "cell 1 5,growx");
	}

}
