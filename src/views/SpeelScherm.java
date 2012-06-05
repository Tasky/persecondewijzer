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
import views.components.NicePanel;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import views.panels.TimerPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class SpeelScherm extends NicePanel {
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
					SpeelScherm ko = new SpeelScherm(new MainWindow());
					frame.setContentPane(ko);
					ko.updateUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param mainWindow 
	 * @throws IOException 
	 */
	public SpeelScherm(MainWindow mainWindow) {
		try {
			initialize(mainWindow);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int currentCell = 0;
	/**
	 * Initialize the contents of the frame.
	 * @param mainWindow 
	 * @throws IOException 
	 */
	private void initialize(final MainWindow mainWindow) throws IOException {
		//setBackground(SystemColor.info);
		setBounds(0, 0, 1024, 768);
		
		setLayout(new MigLayout("", "[124][grow][]", "[110.00][350px:24.00,grow][126.00,grow,fill]"));
		
		JLabel lblWelkeStadIs = DefaultComponentFactory.getInstance().createTitle("Welke stad is te zien op de afbeelding?");
		lblWelkeStadIs.setForeground(Color.WHITE);
		lblWelkeStadIs.setFont(new Font("Tahoma", Font.PLAIN, 47));
		add(lblWelkeStadIs, "cell 0 0 2 1");
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false);
		add(buttonsPanel, "cell 0 1,grow");
		buttonsPanel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		final JPanel panel = new JPanel();
		add(scrollPane, "cell 0 2 2 1,grow");
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
		plaatje.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		add(plaatje, "cell 1 1 2 1,grow");
		plaatje.setAutoResize(true);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[116px,grow]", "[grow][154px]"));
		
		views.panels.TimerPanel timer = new views.panels.TimerPanel();
		panel_1.add(timer, "cell 0 0,grow");
		
		JButton btnStoppen = new JButton("Stop de tijd");
		btnStoppen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.openPanel(new JokerScherm(mainWindow));
			}
		});
		panel_1.add(btnStoppen, "cell 0 1,alignx left,growy");
		
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
					
					ImagePanel imagePanel = null;
					try {
						imagePanel = new ImagePanel("images/Steden/"+optie+".jpg");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					panel.add(imagePanel, "cell "+currentCell+" 0,grow");
					imagePanel.setAutoResize(true);
					
					currentCell++;
					button.setEnabled(false);
					panel.getParent().validate();
				}
			});
			buttonsPanel.add(button, "cell 0 "+(cell)+",growx");
			cell++;
		}
																																		
	}

}
