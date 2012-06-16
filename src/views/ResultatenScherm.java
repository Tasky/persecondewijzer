package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import views.components.ImagePanel;
import views.components.NiceButton;
import views.components.NicePanel;
import views.factories.JPanelFactory;
import controllers.Spel;
import javax.swing.JPanel;

public class ResultatenScherm extends NicePanel {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 1024, 768);
					frame.setVisible(true);
					ResultatenScherm ko = new ResultatenScherm(null);
					frame.setContentPane(ko);
					ko.updateUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JLabel		txtAthene;
	private JLabel		txtAthene_1;
	private JLabel		txtAthene_2;
	private JLabel		txtAthene_3;
	private JLabel		txtAthene_4;
	private JLabel		txtAthene_5;
	private JLabel		txtAthene_6;
	private JLabel		txtAthene_7;
	private JLabel		txtGoed;
	private JLabel		txtFout;
	private JLabel		textField_1;
	private JLabel		textField_2;
	private JLabel		txtFout_1;
	private JLabel		textField_4;
	private JLabel		txtFout_2;
	private JLabel		txtFout_3;
	private ImagePanel	plaatje;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 * 
	 * @param spel
	 */
	public ResultatenScherm(final Spel spel) {
		setBorder(null);

		setLayout(new MigLayout("", "[grow][77px][95px][grow]", "[grow][20px,growprio 50,grow][grow]"));
		
		panel = JPanelFactory.createTransparentJPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[100px:100px][86px]", "[20px][20px][20px][20.00px][20px][20px][20px][20.00px]"));
						txtAthene = new JLabel();
						panel.add(txtAthene, "cell 0 0,grow");
						txtAthene.setFont(new Font("Lucida Grande", Font.BOLD, 13));
						txtAthene.setForeground(Color.WHITE);
						txtAthene.setText("Athene");
										
												txtGoed = new JLabel();
												panel.add(txtGoed, "cell 1 0,grow");
												txtGoed.setFont(new Font("Lucida Grande", Font.BOLD, 13));
												txtGoed.setForeground(Color.GREEN);
												txtGoed.setText("Goed");
								
										txtAthene_1 = new JLabel();
										panel.add(txtAthene_1, "cell 0 1,grow");
										txtAthene_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										txtAthene_1.setForeground(Color.WHITE);
										txtAthene_1.setText("Athene");
								
										txtFout = new JLabel();
										panel.add(txtFout, "cell 1 1,grow");
										txtFout.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										txtFout.setForeground(Color.RED);
										txtFout.setText("Fout");
						
								txtAthene_2 = new JLabel();
								panel.add(txtAthene_2, "cell 0 2,grow");
								txtAthene_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
								txtAthene_2.setForeground(Color.WHITE);
								txtAthene_2.setText("Athene");
								
										textField_1 = new JLabel();
										panel.add(textField_1, "cell 1 2,grow");
										textField_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										textField_1.setForeground(Color.GREEN);
										textField_1.setText("Goed");
						
								txtAthene_3 = new JLabel();
								panel.add(txtAthene_3, "cell 0 3,grow");
								txtAthene_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
								txtAthene_3.setForeground(Color.WHITE);
								txtAthene_3.setText("Athene");
						
								textField_2 = new JLabel();
								panel.add(textField_2, "cell 1 3,grow");
								textField_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
								textField_2.setForeground(Color.GREEN);
								textField_2.setText("Goed");
				
						txtAthene_4 = new JLabel();
						panel.add(txtAthene_4, "cell 0 4,grow");
						txtAthene_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
						txtAthene_4.setForeground(Color.WHITE);
						txtAthene_4.setText("Athene");
				
						txtFout_1 = new JLabel();
						panel.add(txtFout_1, "cell 1 4,grow");
						txtFout_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
						txtFout_1.setForeground(Color.RED);
						txtFout_1.setText("Fout");
		
				txtAthene_5 = new JLabel();
				panel.add(txtAthene_5, "cell 0 5,grow");
				txtAthene_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
				txtAthene_5.setForeground(Color.WHITE);
				txtAthene_5.setText("Athene");
				
						textField_4 = new JLabel();
						panel.add(textField_4, "cell 1 5,grow");
						textField_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
						textField_4.setForeground(Color.GREEN);
						textField_4.setText("Goed");
								
										txtAthene_6 = new JLabel();
										panel.add(txtAthene_6, "cell 0 6,grow");
										txtAthene_6.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										txtAthene_6.setForeground(Color.WHITE);
										txtAthene_6.setText("athene");
								
										txtFout_2 = new JLabel();
										panel.add(txtFout_2, "cell 1 6,grow");
										txtFout_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										txtFout_2.setForeground(Color.RED);
										txtFout_2.setText("Fout");
						
								txtAthene_7 = new JLabel();
								panel.add(txtAthene_7, "cell 0 7,grow");
								txtAthene_7.setFont(new Font("Lucida Grande", Font.BOLD, 13));
								txtAthene_7.setForeground(Color.WHITE);
								txtAthene_7.setText("athene");
								
										txtFout_3 = new JLabel();
										panel.add(txtFout_3, "cell 1 7,grow");
										txtFout_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										txtFout_3.setForeground(Color.RED);
										txtFout_3.setText("Fout");
		
		panel_1 = JPanelFactory.createTransparentJPanel();
		add(panel_1, "cell 2 1,grow");
		panel_1.setLayout(new MigLayout("", "[95px][90px]", "[20px,growprio 50,grow][20px]"));

		JEditorPane dtrpnScore = new JEditorPane();
		panel_1.add(dtrpnScore, "cell 0 0 2 1,grow");
		dtrpnScore.setBackground(new Color(0, 0, 0, 0));
		dtrpnScore.setForeground(Color.WHITE);
		dtrpnScore.setEditable(false);
		dtrpnScore
				.setText("Aantal goed: 5 \r\nAantal fout: 4 \r\nAantal jokers gebruikt: 0     \r\n \r\nScore: 1500 \r\n \r\nTijd: 90 sec");
		
				NiceButton btnStoppen = new NiceButton("Stoppen");
				panel_1.add(btnStoppen, "cell 0 1,grow");
				
						NiceButton btnNewButton = new NiceButton("Verder");
						panel_1.add(btnNewButton, "cell 1 1,grow");
						btnNewButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								spel.volgendeVraag();
							}
						});
				btnStoppen.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						spel.backToMainMenu();
					}
				});

	}

}
