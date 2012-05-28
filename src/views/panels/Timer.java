package views.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import views.components.Icon;

import java.awt.Font;
import java.io.IOException;

public class Timer extends JPanel {

	/**
	 * Create the panel.
	 */
	public Timer() {
		setLayout(null);
		
		JLabel lblTime = new JLabel("211");
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblTime.setBounds(29, 70, 75, 48);
		add(lblTime);
		
		Icon panel = null;
		try {
			panel = new Icon("clock");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.setBounds(36, 6, 54, 55);
		add(panel);

	}
}
