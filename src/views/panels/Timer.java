package views.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import views.components.Icon;

import java.awt.Font;
import java.io.IOException;
import net.miginfocom.swing.MigLayout;

public class Timer extends JPanel {

	/**
	 * Create the panel.
	 */
	public Timer() {
		setLayout(new MigLayout("", "[75px:75px,grow,center]", "[55px:55px][48px]"));
		
		JLabel lblTime = new JLabel("211");
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		add(lblTime, "cell 0 1,alignx left,aligny top");
		
		Icon panel = null;
		try {
			panel = new Icon("clock");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(panel, "cell 0 0,grow");

	}
}
