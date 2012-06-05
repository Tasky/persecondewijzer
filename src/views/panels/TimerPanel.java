package views.panels;

import javax.swing.Timer;

import javax.swing.JPanel;
import javax.swing.JLabel;

import views.components.Icon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import net.miginfocom.swing.MigLayout;

public class TimerPanel extends JPanel {

	private Timer timer;
	private JLabel lblTime;
	private ActionListener task;
	private int seconds = 200;
	
	/**
	 * Create the panel.
	 */
	public TimerPanel() {
		setLayout(new MigLayout("", "[75px:75px,grow,center]", "[55px:55px][48px]"));
		
		this.lblTime = new JLabel();
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		add(lblTime, "cell 0 1,alignx left,aligny top");
		
		Icon panel = null;
		try {
			panel = new Icon("clock");
		} catch (IOException e) {
			e.printStackTrace();
		}
		add(panel, "cell 0 0,grow");
		
		this.initTimer(1000);
		this.startTimer();

	}
	
	private void setText ( String seconds ) {
		
		lblTime.setText(seconds);
		
	} 
	
	public void initTimer(int delay) {
		
		this.task = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setText( Integer.toString(seconds) );
				seconds--;
			}
		};
		
		this.timer = new Timer(delay, task);
		
	}
	
	public void startTimer() {
		
		timer.start();
		
	}
	
	public void stopTimer() {
		
		timer.stop();
		
	}
}
