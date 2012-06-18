package views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Timer;

import net.miginfocom.swing.MigLayout;
import views.GameOver;
import views.components.GradientPanel;
import views.components.NoisePanel;
import controllers.Spel;

/**
 * @author nanne
 *
 */
public class InfoPanel extends NoisePanel implements Observer {

	private JLabel			lblTime;
	protected Spel			spel;

	/**
	 * Create the panel.
	 */
	public InfoPanel(Spel spel) {
		this.spel = spel;

		setRoundedCorners(true);
		setUpperColor(new Color(209, 199, 195));
		setLowerColor(new Color(231, 226, 224));
		
		setLayout(new MigLayout("", "[75px:75px,grow,center]", "[48px,grow]"));
		lblTime = new JLabel("200");
		lblTime.setForeground(Color.black);
		//lblTime.setBackground(new Color(0, 0, 0, 0));
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		add(lblTime, "cell 0 0,alignx center,aligny center");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(!(arg0 instanceof Timer)) return;
		Timer timer = (Timer)arg0;
		int s = timer.getTime();
		if(s < 5) {
			lblTime.setForeground(Color.red);
		}
		lblTime.setText(s + "");
		validate();
		repaint();	
	}
}
