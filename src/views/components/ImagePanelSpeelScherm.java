package views.components;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ImagePanelSpeelScherm extends JFrame{

	/**
	 * Create the panel.
	 */
	public ImagePanelSpeelScherm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[46.00][393.00,grow][grow]"));
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[142.00,left][grow,leading]", "[grow]"));
		
		
		ImagePanel plaatje;
		try {
			plaatje = new ImagePanel("images/stad.jpg");
			panel_2.add(plaatje, "cell 1 0,grow");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
