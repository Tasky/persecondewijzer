package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.components.ImagePanel;
import views.components.NicePanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

public class ResultatenScherm extends NicePanel {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 1024, 768);
					frame.setVisible(true);
					ResultatenScherm ko = new ResultatenScherm(new MainWindow(null));
					frame.setContentPane(ko);
					ko.updateUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JLabel txtAthene;
	private JLabel txtAthene_1;
	private JLabel txtAthene_2;
	private JLabel txtAthene_3;
	private JLabel txtAthene_4;
	private JLabel txtAthene_5;
	private JLabel txtAthene_6;
	private JLabel txtAthene_7;
	private JLabel txtGoed;
	private JLabel txtFout;
	private JLabel textField_1;
	private JLabel textField_2;
	private JLabel txtFout_1;
	private JLabel textField_4;
	private JLabel txtFout_2;
	private JLabel txtFout_3;
	private ImagePanel plaatje;

	/**
	 * Create the panel.
	 * @param mainWindow 
	 * @throws IOException 
	 */
	public ResultatenScherm(final MainWindow mainWindow) throws IOException {
				
		txtAthene = new JLabel();
		txtAthene.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene.setForeground(Color.WHITE);
		txtAthene.setText("Athene");
		
		txtAthene_1 = new JLabel();
		txtAthene_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene_1.setForeground(Color.WHITE);
		txtAthene_1.setText("Athene");
		
		txtAthene_2 = new JLabel();
		txtAthene_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene_2.setForeground(Color.WHITE);
		txtAthene_2.setText("Athene");
		
		txtAthene_3 = new JLabel();
		txtAthene_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene_3.setForeground(Color.WHITE);
		txtAthene_3.setText("Athene");
		
		txtAthene_4 = new JLabel();
		txtAthene_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene_4.setForeground(Color.WHITE);
		txtAthene_4.setText("Athene");
		
		txtAthene_5 = new JLabel();
		txtAthene_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene_5.setForeground(Color.WHITE);
		txtAthene_5.setText("Athene");
		
		txtAthene_6 = new JLabel();
		txtAthene_6.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene_6.setForeground(Color.WHITE);
		txtAthene_6.setText("athene");
		
		txtAthene_7 = new JLabel();
		txtAthene_7.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtAthene_7.setForeground(Color.WHITE);
		txtAthene_7.setText("athene");
		
		txtGoed = new JLabel();
		txtGoed.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtGoed.setForeground(Color.GREEN);
		txtGoed.setText("Goed");
		
		txtFout = new JLabel();
		txtFout.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtFout.setForeground(Color.RED);
		txtFout.setText("Fout");
		
		textField_1 = new JLabel();
		textField_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textField_1.setForeground(Color.GREEN);
		textField_1.setText("Goed");
		
		textField_2 = new JLabel();
		textField_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textField_2.setForeground(Color.GREEN);
		textField_2.setText("Goed");
		
		txtFout_1 = new JLabel();
		txtFout_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtFout_1.setForeground(Color.RED);
		txtFout_1.setText("Fout");
		
		textField_4 = new JLabel();
		textField_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textField_4.setForeground(Color.GREEN);
		textField_4.setText("Goed");
		
		txtFout_2 = new JLabel();
		txtFout_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtFout_2.setForeground(Color.RED);
		txtFout_2.setText("Fout");
		
		txtFout_3 = new JLabel();
		txtFout_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtFout_3.setForeground(Color.RED);
		txtFout_3.setText("Fout");
		
		JButton btnStoppen = new JButton("Stoppen");
		btnStoppen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton = new JButton("Verder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.openPanel(new SpeelScherm(mainWindow));
			}
		});
		
		setLayout(new MigLayout("", "[grow][77px][86px][][95px][6px][90px][grow]", "[grow][20px,grow][20px][20px][20.00px][20px][20px][20px][20.00px][grow]"));
		
		try{
			plaatje = new ImagePanel("images/Steden/Brussel.jpg");
			add(plaatje, "cell 0 1,grow");
			plaatje.setAutoResize(true);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("blaat");
		}
		
		JEditorPane dtrpnScore = new JEditorPane();
		dtrpnScore.setBackground(new Color(0,0,0,0));
		dtrpnScore.setForeground(Color.WHITE);
		dtrpnScore.setEditable(false);
		dtrpnScore.setText("Aantal goed: 5 \r\nAantal fout: 4 \r\nAantal joker gebruikt: 0     \r\n \r\nScore: 1500 \r\n \r\nTijd: 90 sec");
		add(dtrpnScore, "cell 4 1 3 5,grow");
		add(txtAthene_5, "cell 1 6,grow");
		add(textField_4, "cell 2 6,grow");
		add(txtAthene_4, "cell 1 5,grow");
		add(txtFout_1, "cell 2 5,grow");
		add(txtAthene, "cell 1 1,grow");
		add(txtAthene_7, "cell 1 8,grow");
		add(txtAthene_2, "cell 1 3,grow");
		add(txtAthene_3, "cell 1 4,grow");
		add(txtAthene_1, "cell 1 2,grow");
		add(txtGoed, "cell 2 1,grow");
		add(txtFout, "cell 2 2,grow");
		add(textField_1, "cell 2 3,grow");
		add(textField_2, "cell 2 4,grow");
		add(txtFout_3, "cell 2 8,grow");
		add(txtAthene_6, "cell 1 7,grow");
		add(txtFout_2, "cell 2 7,grow");
		add(btnStoppen, "cell 4 7 1 2,grow");
		add(btnNewButton, "cell 6 7 1 2,grow");

	}
	
}
