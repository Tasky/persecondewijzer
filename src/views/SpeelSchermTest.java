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
		frame.setBounds(300, 300, 1250, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[150][250][250][250][250][250][250][250][250][250][150,grow]", "[156.50,grow][200][grow][][][][][][][][][56.50][126.00,grow,fill][56.50]"));
		
		JTextPane txtpnWelkeStadIs = new JTextPane();
		txtpnWelkeStadIs.setBackground(SystemColor.info);
		txtpnWelkeStadIs.setText("Welke stad is te zien op de afbeelding?");
		txtpnWelkeStadIs.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		frame.getContentPane().add(txtpnWelkeStadIs, "cell 8 0 3 1,grow");
		
		JButton btnAthene = new JButton("Athene");
		frame.getContentPane().add(btnAthene, "cell 0 2,growx");
	//	try {
	//	} catch (IOException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		
		ImagePanel imagePanel_big = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_big, "cell 3 2 5 9,grow");
		
		JButton btnBerlijn = new JButton("Berlijn");
		frame.getContentPane().add(btnBerlijn, "cell 0 3,growx");
		
		JButton btnBrussel = new JButton("Brussel");
		frame.getContentPane().add(btnBrussel, "cell 0 4,growx");
		
		JButton btnDublin = new JButton("Dublin");
		frame.getContentPane().add(btnDublin, "cell 0 5,growx");
		
		JButton btnKopenhagen = new JButton("Kopenhagen");
		frame.getContentPane().add(btnKopenhagen, "cell 0 6,growx");
		
		JButton btnMonaco = new JButton("Monaco");
		frame.getContentPane().add(btnMonaco, "cell 0 7,growx");
		
		JButton btnOslo = new JButton("Oslo");
		frame.getContentPane().add(btnOslo, "cell 0 8,growx");
		
		JButton btnParijs = new JButton("Parijs");
		frame.getContentPane().add(btnParijs, "cell 0 9,growx");
		
		JButton btnRome = new JButton("Rome");
		frame.getContentPane().add(btnRome, "cell 0 10,growx");
		
		ImagePanel imagePanel = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel, "cell 1 12,grow");
		
		ImagePanel imagePanel_1 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_1, "cell 2 12,grow");
		
		ImagePanel imagePanel_2 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_2, "cell 3 12,grow");
		
		ImagePanel imagePanel_3 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_3, "cell 4 12,grow");
		
		ImagePanel imagePanel_4 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_4, "cell 5 12,grow");
		
		ImagePanel imagePanel_5 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_5, "cell 6 12,grow");
		
		ImagePanel imagePanel_6 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_6, "cell 7 12,grow");
		
		ImagePanel imagePanel_7 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_7, "cell 8 12,grow");
		
		ImagePanel imagePanel_8 = new ImagePanel("images/stad.jpg");
		frame.getContentPane().add(imagePanel_8, "cell 9 12,grow");
		
		JComboBox comboBox = new JComboBox();
		frame.getContentPane().add(comboBox, "cell 1 13,growx");
		
		JComboBox comboBox_1 = new JComboBox();
		frame.getContentPane().add(comboBox_1, "cell 2 13,growx");
		
		JComboBox comboBox_2 = new JComboBox();
		frame.getContentPane().add(comboBox_2, "cell 3 13,growx");
		
		JComboBox comboBox_3 = new JComboBox();
		frame.getContentPane().add(comboBox_3, "cell 4 13,growx");
		
		JComboBox comboBox_4 = new JComboBox();
		frame.getContentPane().add(comboBox_4, "cell 5 13,growx");
		
		JComboBox comboBox_5 = new JComboBox();
		frame.getContentPane().add(comboBox_5, "cell 6 13,growx");
		
		JComboBox comboBox_6 = new JComboBox();
		frame.getContentPane().add(comboBox_6, "cell 7 13,growx");
		
		JComboBox comboBox_7 = new JComboBox();
		frame.getContentPane().add(comboBox_7, "cell 8 13,growx");
		
		JComboBox comboBox_8 = new JComboBox();
		frame.getContentPane().add(comboBox_8, "cell 9 13,growx");
	}

}
