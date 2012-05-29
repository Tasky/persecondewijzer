package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[300.00,grow,left][30.00][100.00][100.00][30.00][300.00,grow]", "[200.00][][][][]"));
		
		Panel panel = new Panel();
		panel.setBackground(Color.GREEN);
		frame.getContentPane().add(panel, "cell 1 0 4 1,grow");
		
		txtVulHierJe = new JTextField();
		txtVulHierJe.setText("Vul hier je naam in");
		frame.getContentPane().add(txtVulHierJe, "cell 2 1 2 1,growx");
		txtVulHierJe.setColumns(10);
		
		JButton btnNewButton = new JButton("Spelregels");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpScherm helpScherm = new HelpScherm();
				frame.setContentPane(helpScherm);
				helpScherm.updateUI();
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 2 2,growx");
		
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
		frame.getContentPane().add(btnNewButton_3, "cell 3 2 1 3,grow");
		
		JButton btnNewButton_1 = new JButton("Beheer");
		frame.getContentPane().add(btnNewButton_1, "cell 2 3,growx");
		
		JButton btnNewButton_2 = new JButton("Highscores");
		frame.getContentPane().add(btnNewButton_2, "cell 2 4,growx");
	}

}
