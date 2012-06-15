package logic;

import java.util.Observable;

public class GekozenAntwoord extends Observable {
	private Onderdeel	huidigeOnderdeel;
	private Onderdeel	gekozenOnderdeel;

	public GekozenAntwoord(Onderdeel huidigeOnderdeel,
			Onderdeel gekozenOnderdeel) {
		setHuidigeOnderdeel(huidigeOnderdeel);
		setGekozenOnderdeel(gekozenOnderdeel);
	}

	/**
	 * @return the gekozenOnderdeel
	 */
	public Onderdeel getGekozenOnderdeel() {
		return gekozenOnderdeel;
	}

	/**
	 * @return the huidigeOnderdeel
	 */
	public Onderdeel getHuidigeOnderdeel() {
		return huidigeOnderdeel;
	}

	public boolean isGoed() {
		return huidigeOnderdeel == gekozenOnderdeel;
	}

	/**
	 * @param gekozenOnderdeel
	 *            the gekozenOnderdeel to set
	 */
	public void setGekozenOnderdeel(Onderdeel gekozenOnderdeel) {
		this.gekozenOnderdeel = gekozenOnderdeel;
		setChanged();
		notifyObservers();
	}

	/**
	 * @param huidigeOnderdeel
	 *            the huidigeOnderdeel to set
	 */
	public void setHuidigeOnderdeel(Onderdeel huidigeOnderdeel) {
		this.huidigeOnderdeel = huidigeOnderdeel;
	}
}
