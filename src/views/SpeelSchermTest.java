package views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import views.components.ImagePanel;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import views.panels.Timer;
import javax.swing.DefaultComboBoxModel;
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

	int currentCell = 0;
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(300, 300, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[124][124][124][124][124][124][124][124][124][124]", "[226.00,grow][24.00,grow][][][][][][][][][56.50][126.00,grow,fill]"));
		
		JLabel lblWelkeStadIs = DefaultComponentFactory.getInstance().createTitle("Welke stad is te zien op de afbeelding?");
		lblWelkeStadIs.setFont(new Font("Tahoma", Font.PLAIN, 47));
		frame.getContentPane().add(lblWelkeStadIs, "cell 0 0 8 1");
		
		JButton btnStopDeTijd = new JButton("Stop de Tijd");
		frame.getContentPane().add(btnStopDeTijd, "cell 8 10");
		
		final JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 11 9 1,grow");
		panel.setLayout(new MigLayout("", "[][][][][][][][][][]", "[grow][]"));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 1 0,grow");
		
		
		final ArrayList<String> opties = new ArrayList<String>();
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
		
		for (final String optie : opties) {			
			//antwoorden.add(label, "cell 0 "+cell+",alignx left,aligny top");
			final JButton button = new JButton(optie);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox combobox = new JComboBox();
					DefaultComboBoxModel model = new DefaultComboBoxModel();
					for(String comboOptie : opties) {
						model.addElement(comboOptie);
					}
					model.setSelectedItem(optie);
					combobox.setModel(model);
					combobox.setMaximumRowCount(9);
					panel.add(combobox, "cell "+currentCell+" 1,growx");
					frame.validate();
					
					ImagePanel imagePanel = null;
					try {
						imagePanel = new ImagePanel("images/Steden/"+optie+".jpg");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					panel.add(imagePanel, "cell "+currentCell+" 0,grow");
					imagePanel.setAutoResize(true);
					
					frame.validate();
					
					currentCell++;
					button.setEnabled(false);
				}
			});
			frame.getContentPane().add(button, "cell 0 "+cell+",growx");
			cell++;
		}
																																		
	}

}
