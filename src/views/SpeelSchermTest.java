package views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import views.components.ImagePanel;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import views.panels.Timer;
import javax.swing.DefaultComboBoxModel;
import logic.Antwoord.Steden;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpeelSchermTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpeelSchermTest window = new SpeelSchermTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public SpeelSchermTest() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(300, 300, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[124,grow][124][124][124][124][124][124][124][124][124]", "[226.00,grow][24.00,grow][][][][][][][][][56.50][126.00,grow,fill][56.50]"));
		
		JLabel lblWelkeStadIs = DefaultComponentFactory.getInstance().createTitle("Welke stad is te zien op de afbeelding?");
		lblWelkeStadIs.setFont(new Font("Tahoma", Font.PLAIN, 47));
		frame.getContentPane().add(lblWelkeStadIs, "cell 0 0 8 1");
		
		JButton btnAthene = new JButton("Athene");
		btnAthene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel = null;
				try {
					imagePanel = new ImagePanel("images/Steden/athene.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel, "cell 0 11,grow");
				imagePanel.setAutoResize(true);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setMaximumRowCount(9);
				comboBox.setModel(new DefaultComboBoxModel(Steden.values()));
				frame.getContentPane().add(comboBox, "cell 0 12,growx");
				frame.validate();
			}
			
		});
		
		Timer timer = new Timer();
		frame.getContentPane().add(timer, "cell 8 0,grow");
		frame.getContentPane().add(btnAthene, "cell 0 1,growx");
		//	try {
		//	} catch (IOException e) {
				// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
			
			ImagePanel imagePanel_big = new ImagePanel("images/stad.jpg");
			frame.getContentPane().add(imagePanel_big, "cell 2 1 6 9,grow");
		
		JButton btnBerlijn = new JButton("Berlijn");
		btnBerlijn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_1 = null;
				try {
					imagePanel_1 = new ImagePanel("images/Steden/berlijn.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
									}
				frame.getContentPane().add(imagePanel_1, "cell 1 11,grow");
				imagePanel_1.setAutoResize(true);
				
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setMaximumRowCount(9);
				comboBox_1.setModel(new DefaultComboBoxModel(Steden.values()));
				frame.getContentPane().add(comboBox_1, "cell 1 12,growx");
				frame.validate();
				
			}
		});
		
		JLabel lblSteden = DefaultComponentFactory.getInstance().createTitle("Steden");
		lblSteden.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblSteden, "cell 8 1");
		frame.getContentPane().add(btnBerlijn, "cell 0 2,growx");
		
		JButton btnBrussel = new JButton("Brussel");
		btnBrussel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_2 = null;
				try {
					imagePanel_2 = new ImagePanel("images/Steden/Brussel.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel_2, "cell 2 11,grow");
				imagePanel_2.setAutoResize(true);
				
				JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setMaximumRowCount(9);
				comboBox_2.setModel(new DefaultComboBoxModel(Steden.values()));
				frame.getContentPane().add(comboBox_2, "cell 2 12,growx");
				frame.validate();
			}
		});
		frame.getContentPane().add(btnBrussel, "cell 0 3,growx");
		
		JButton btnDublin = new JButton("Dublin");
		btnDublin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_3 = null;
				try {
					imagePanel_3 = new ImagePanel("images/Steden/Dublin.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel_3, "cell 3 11,grow");
				imagePanel_3.setAutoResize(true);
				
				JComboBox comboBox_3 = new JComboBox();
				comboBox_3.setMaximumRowCount(9);
				comboBox_3.setModel(new DefaultComboBoxModel(Steden.values()));
				frame.getContentPane().add(comboBox_3, "cell 3 12,growx");
				frame.validate();
			}
		});
		frame.getContentPane().add(btnDublin, "cell 0 4,growx");
		
		JButton btnKopenhagen = new JButton("Kopenhagen");
		btnKopenhagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_4 = null;
				try {
					imagePanel_4 = new ImagePanel("images/Steden/Kopenhagen.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel_4, "cell 4 11,grow");
				imagePanel_4.setAutoResize(true);
				
				JComboBox comboBox_4 = new JComboBox();
				comboBox_4.setMaximumRowCount(9);
				comboBox_4.setModel(new DefaultComboBoxModel(Steden.values()));
				frame.getContentPane().add(comboBox_4, "cell 4 12,growx");
				frame.validate();
			}
		});
		frame.getContentPane().add(btnKopenhagen, "cell 0 5,growx");
		
		JButton btnMonaco = new JButton("Monaco");
		btnMonaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_5 = null;
				try {
					imagePanel_5 = new ImagePanel("images/Steden/Monaco.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel_5, "cell 5 11,grow");
				imagePanel_5.setAutoResize(true);
				
				JComboBox comboBox_5 = new JComboBox();
				comboBox_5.setMaximumRowCount(9);
				comboBox_5.setModel(new DefaultComboBoxModel(Steden.values()));
				frame.getContentPane().add(comboBox_5, "cell 5 12,growx");
				frame.validate();
			}
		});
		frame.getContentPane().add(btnMonaco, "cell 0 6,growx");
		
		JButton btnOslo = new JButton("Oslo");
		btnOslo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_6 = null;
				try {
					imagePanel_6 = new ImagePanel("images/Steden/Oslo.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel_6, "cell 6 11,grow");
				imagePanel_6.setAutoResize(true);
				
				JComboBox comboBox_6 = new JComboBox();
				comboBox_6.setModel(new DefaultComboBoxModel(Steden.values()));
				comboBox_6.setMaximumRowCount(9);
				frame.getContentPane().add(comboBox_6, "cell 6 12,growx");
				frame.validate();
			}
		});
		frame.getContentPane().add(btnOslo, "cell 0 7,growx");
		
		JButton btnParijs = new JButton("Parijs");
		btnParijs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_7 = null;
				try {
					imagePanel_7 = new ImagePanel("images/Steden/Parijs.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel_7, "cell 7 11,grow");
				imagePanel_7.setAutoResize(true);
				
				JComboBox comboBox_7 = new JComboBox();
				comboBox_7.setModel(new DefaultComboBoxModel(Steden.values()));
				comboBox_7.setMaximumRowCount(9);
				frame.getContentPane().add(comboBox_7, "cell 7 12,growx");
				frame.validate();				
			}
		});
		frame.getContentPane().add(btnParijs, "cell 0 8,growx");
		
		JButton btnRome = new JButton("Rome");
		btnRome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePanel imagePanel_8 = null;
				try {
					imagePanel_8 = new ImagePanel("images/Steden/Rome.jpg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.getContentPane().add(imagePanel_8, "cell 8 11,grow");
				imagePanel_8.setAutoResize(true);
				
				JComboBox comboBox_8 = new JComboBox();
				comboBox_8.setModel(new DefaultComboBoxModel(Steden.values()));
				comboBox_8.setMaximumRowCount(9);
				frame.getContentPane().add(comboBox_8, "cell 8 12,growx");
				frame.validate();	
			}
		});
		frame.getContentPane().add(btnRome, "cell 0 9,growx");
		
		JButton btnStopDeTijd = new JButton("Stop de Tijd");
		frame.getContentPane().add(btnStopDeTijd, "cell 8 10");
																																		
	}

}
