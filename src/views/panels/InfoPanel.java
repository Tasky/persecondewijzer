package views.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import net.miginfocom.swing.MigLayout;
import views.GameOver;
import controllers.Spel;

public class InfoPanel extends JPanel {

	private Timer			timer;
	private JLabel			lblTime;
	private ActionListener	task;
	private int				seconds	= 200;
	protected Spel			spel;

	/**
	 * Create the panel.
	 */
	public InfoPanel(Spel spel) {
		this.spel = spel;

		setLayout(new MigLayout("", "[75px:75px,grow,center]", "[48px,grow]"));

		lblTime = new JLabel("200");
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		add(lblTime, "cell 0 0,alignx center,aligny center");

		initTimer(1000);
		startTimer();

	}

	public int getTime() {

		return seconds;

	}

	public void initTimer(int delay) {
		task = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				setText(Integer.toString(seconds));
				seconds--;
				if (seconds == 0) {
					GameOver gameover = new GameOver(spel);
					spel.openPanel(gameover);
				}
			}
		};

		timer = new Timer(delay, task);

	}

	private void setText(String seconds) {
		lblTime.setText(seconds);
	}

	public void startTimer() {

		timer.start();

	}

	public void stopTimer() {

		timer.stop();

	}
}
