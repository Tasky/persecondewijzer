package logic;

import java.util.Observable;

public class GekozenAntwoord extends Observable {
	private Onderdeel huidigeOnderdeel;
	private Onderdeel gekozenOnderdeel;
	public GekozenAntwoord(Onderdeel huidigeOnderdeel,
			Onderdeel gekozenOnderdeel) {
		setHuidigeOnderdeel(huidigeOnderdeel);
		setGekozenOnderdeel(gekozenOnderdeel);
	}

	public boolean isGoed() {
		return huidigeOnderdeel == gekozenOnderdeel;
	}

	/**
	 * @return the huidigeOnderdeel
	 */
	public Onderdeel getHuidigeOnderdeel() {
		return huidigeOnderdeel;
	}

	/**
	 * @param huidigeOnderdeel the huidigeOnderdeel to set
	 */
	public void setHuidigeOnderdeel(Onderdeel huidigeOnderdeel) {
		this.huidigeOnderdeel = huidigeOnderdeel;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the gekozenOnderdeel
	 */
	public Onderdeel getGekozenOnderdeel() {
		return gekozenOnderdeel;
	}

	/**
	 * @param gekozenOnderdeel the gekozenOnderdeel to set
	 */
	public void setGekozenOnderdeel(Onderdeel gekozenOnderdeel) {
		this.gekozenOnderdeel = gekozenOnderdeel;
	}
}
