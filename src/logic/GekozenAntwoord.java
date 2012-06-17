package logic;

import java.util.Observable;

/**
 * @author nanne
 *
 */
public class GekozenAntwoord extends Observable {
	private Onderdeel	huidigeOnderdeel;
	private Onderdeel	gekozenOnderdeel;

	/**
	 * @param huidigeOnderdeel
	 * @param gekozenOnderdeel
	 */
	public GekozenAntwoord(final Onderdeel huidigeOnderdeel, final Onderdeel gekozenOnderdeel) {
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

	/**
	 * @return is het antwoord goed of fout?
	 */
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
