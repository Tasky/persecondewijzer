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
import javax.swing.JScrollPane;

import views.components.ImagePanel;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import views.panels.Timer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class SpeelScherm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpeelScherm window = new SpeelScherm();
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
	public SpeelScherm() throws IOException {
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
		frame.getContentPane().setLayout(new MigLayout("", "[124][][124,grow][124][][124]", "[110.00][350px:24.00,growprio 90,grow][56.50][126.00,grow,fill]"));
		
		JLabel lblWelkeStadIs = DefaultComponentFactory.getInstance().createTitle("Welke stad is te zien op de afbeelding?");
		lblWelkeStadIs.setFont(new Font("Tahoma", Font.PLAIN, 47));
		frame.getContentPane().add(lblWelkeStadIs, "cell 0 0 3 1");
		
		JPanel buttonsPanel = new JPanel();
		frame.getContentPane().add(buttonsPanel, "cell 0 1,grow");
		buttonsPanel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][]"));
		
		JButton btnStoppen = new JButton("Stop de tijd");
		frame.getContentPane().add(btnStoppen, "cell 3 2 2 1");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		final JPanel panel = new JPanel();
		frame.getContentPane().add(scrollPane, "cell 0 3 6 1,grow");
		panel.setLayout(new MigLayout("", "[][][][][][][][][][]", "[grow][]"));
		scrollPane.setViewportView(panel);
		
		
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
		
		final ImagePanel plaatje = new ImagePanel("images/Steden/Brussel.jpg");
		frame.getContentPane().add(plaatje, "cell 2 1 2 1,grow");
		plaatje.setAutoResize(true);
		
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
			buttonsPanel.add(button, "cell 0 "+(cell)+",growx");
			cell++;
		}
																																		
	}

}
