package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

public class Timer extends Observable {

	private static final int	BEGIN_TIJD	= 200;
	private static final int	JOKER_TIJD	= 16;
	private int					huidigeTijd;
	private javax.swing.Timer timer;
	private Date metingBeginTijd;
	private int	jokerAftrek = 0;

	public Timer() {
		huidigeTijd = BEGIN_TIJD;
		timer = new javax.swing.Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Date metingEindTijd = new Date();
				long verschil = (metingEindTijd.getTime() - metingBeginTijd.getTime()) / 1000;
				if(verschil >= 1) {
					huidigeTijd--;
					
					setChanged();
					notifyObservers();
					metingBeginTijd = new Date();
				}
			}
		});
	}
	
	/**
	 * Start de timer.
	 */
	public void start(){
		metingBeginTijd = new Date();
		timer.start();
	}
	
	/**
	 * Stop de timer.
	 */
	public void stop(){
		timer.stop();
	}

	/**
	 * Krijg de tijd van de timer terug
	 * @return tijd van de timer.
	 */
	public int getTime() {
		return huidigeTijd - (jokerAftrek * JOKER_TIJD);
	}

	/**
	 * Krijg terug of de speler heeft verloren
	 * @return heeft speler verloren
	 */
	public boolean hasLost() {
		return getTime() < 0;
	}

	/*private void setTime(int time) {
		huidigeTijd = time;
	}*/

	@Override
	public String toString() {
		return Integer.toString(huidigeTijd);
	}

	/**
	 * Haal joker van de tijd af.
	 */
	public void addJoker() {
		jokerAftrek++;
	}

}
