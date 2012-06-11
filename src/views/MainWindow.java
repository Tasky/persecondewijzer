package views;

import controllers.Spel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import views.components.NicePanel;


public class MainWindow {

	private JFrame frame;
	private JTextField txtVulHierJe;
	private Container ownPanel;
	
	private Spel spel;
	
	/**
	 * static variables
	 */
	private static final String TXT_PLACEH_NAAM_INPUT = "Vul hier je naam in";

	/**
	 * Create the application.
	 * @param spel 
	 */
	public MainWindow(controllers.Spel spel) {
		initialize();
		frame.setVisible(true);

		this.spel = spel;
	}
	
	public void reset()
	{
		frame.setContentPane(ownPanel);
		((JPanel) ownPanel).updateUI();
	}

	public void openPanel(JPanel panel) {
		frame.setContentPane(panel);
		panel.updateUI();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ownPanel = new NicePanel();
		frame.setContentPane(ownPanel);
		//frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1280, 720);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[300.00,grow,left][100.00,grow,fill][100.00,grow][300.00,grow]", "[157.00,grow,fill][160px:172.00px:180px,fill][][][][][157.00,grow]"));

		JLabel lblNewLabel = new JLabel("<html>PER<br />\nSECONDE<br />\nWIJZER</html>");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 42));
		lblNewLabel.setForeground(Color.WHITE);
		ownPanel.add(lblNewLabel, "cell 1 1 2 1");
		
		txtVulHierJe = new JTextField();
		txtVulHierJe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtVulHierJe.setText(TXT_PLACEH_NAAM_INPUT);
		frame.getContentPane().add(txtVulHierJe, "cell 1 2 2 1,growx");
		txtVulHierJe.setColumns(10);

		
		//Als er met de mouse geklikt wordt zal de placeholder text verwijderd worden
		txtVulHierJe.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ( arg0.getButton() == 0x1 && txtVulHierJe.getText().equals(TXT_PLACEH_NAAM_INPUT) )
					txtVulHierJe.setText("");
			}
		} );
		//Placeholder wijzgen d.m.v. een keypress
		txtVulHierJe.addKeyListener( new KeyAdapter() { 
                        @Override
			public void keyPressed( KeyEvent e ) {
				if ( txtVulHierJe.getText().equals(TXT_PLACEH_NAAM_INPUT) ) {
						txtVulHierJe.setText("");
				}
			}
		} );
		
		
		JButton btnNewButton = new JButton("Spelregels");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		final HelpScherm helpScherm = new HelpScherm(this);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPanel(helpScherm);
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 1 3,growx");
		
		JButton btnNewButton_3 = new JButton("Start");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		txtVulHierJe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					startGame();
				}
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGame();
			}
		});
		frame.getContentPane().add(btnNewButton_3, "cell 2 3 1 2,grow");
		
		JButton btnNewButton_2 = new JButton("Highscores");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		final Highscore highscore = new Highscore(this, null);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPanel(highscore);
			}
		});
		frame.getContentPane().add(btnNewButton_2, "cell 1 4,growx");
	}
	
	
	private void startGame()
	{
		KiesOnderwerp kiesOnderwerp = new KiesOnderwerp(spel);
		String naamNo = txtVulHierJe.getText();
		
		if (naamNo.equals(TXT_PLACEH_NAAM_INPUT) || naamNo.isEmpty())
		{
			txtVulHierJe.setBackground(Color.red);
			txtVulHierJe.selectAll();
		}
		else
		{
			openPanel(kiesOnderwerp);
			spel.setSpelerNaam( naamNo );
		}
	}
}
