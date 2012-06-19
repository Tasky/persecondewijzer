package logic;

import java.util.ArrayList;

import exceptions.DataException;

/**
 * De vraag, hier staat alle informatie en logica over de vraag in.
 */
public class Vraag {
	private String								_tekst;
	private ArrayList<Onderdeel>				_onderdelen;
	private ArrayList<logic.GekozenAntwoord>	_antwoorden				= new ArrayList<logic.GekozenAntwoord>();
	private int									huidigOnderdeel			= -1;
	private int									moetGoedHebben			= 9;
	private int									hoeveelWaard			= 20;
	private int									hoeveelJokersGebruikt	= 0;
	private boolean								isDoubling				= false;

	/**
	 * @param vraag
	 * @param onderdelen
	 * @throws DataException
	 */
	public Vraag(String vraag, ArrayList<Onderdeel> onderdelen) throws DataException {
		setTekst(vraag);
		setOnderdelen(onderdelen);
	}

	/**
	 * @return
	 */
	public ArrayList<GekozenAntwoord> getGekozenAntwoorden() {
		return _antwoorden;
	}

	/**
	 * @return
	 */
	public int getHoeveelGoed() {
		int score = 0;

		for (GekozenAntwoord gk : _antwoorden)
			if (gk.isGoed()) score++;

		return score;
	}

	/**
	 * @return the hoeveelJokersGebruikt
	 */
	public int getHoeveelJokersGebruikt() {
		return hoeveelJokersGebruikt;
	}

	/**
	 * @return the hoeveelWaard
	 */
	public int getHoeveelWaard() {
		return hoeveelWaard;
	}

	/**
	 * @return
	 */
	public Onderdeel getHuidigeOnderdeel() {
		if (huidigOnderdeel > _onderdelen.size() - 1) return null;

		return _onderdelen.get(huidigOnderdeel);
	}

	/**
	 * @return the moetGoedHebben
	 */
	public int getMoetGoedHebben() {
		return moetGoedHebben;
	}

	/**
	 * @return
	 */
	public ArrayList<Onderdeel> getOnderdelen() {
		return _onderdelen;
	}

	public String getTekst() {
		return _tekst;
	}

	/**
	 * @return the isDoubling
	 */
	public boolean isDoubling() {
		return isDoubling;
	}

	public GekozenAntwoord kiesAntwoord(logic.Onderdeel gekozenOnderdeel) {
		GekozenAntwoord gk = new GekozenAntwoord(getHuidigeOnderdeel(), gekozenOnderdeel);
		_antwoorden.add(gk);
		return gk;
	}

	/**
	 * @return mag doorspelen?
	 */
	public boolean magDoorspelen() {
		return getHoeveelGoed() >= getMoetGoedHebben() - getHoeveelJokersGebruikt();
	}

	/**
	 * @param isDoubling
	 *            the isDoubling to set
	 */
	public void setDoubling(boolean isDoubling) {
		this.isDoubling = isDoubling;
	}

	/**
	 * @param hoeveelJokersGebruikt
	 *            the hoeveelJokersGebruikt to set
	 */
	public void setHoeveelJokersGebruikt(int hoeveelJokersGebruikt) {
		this.hoeveelJokersGebruikt = hoeveelJokersGebruikt;
	}

	/**
	 * @param hoeveelWaard
	 *            the hoeveelWaard to set
	 */
	public void setHoeveelWaard(int hoeveelWaard) {
		this.hoeveelWaard = hoeveelWaard;
	}

	/**
	 * @param moetGoedHebben
	 *            the moetGoedHebben to set
	 */
	public void setMoetGoedHebben(int moetGoedHebben) {
		this.moetGoedHebben = moetGoedHebben;
	}

	private void setOnderdelen(ArrayList<Onderdeel> onderdelen) throws DataException {
		if (onderdelen.size() != 9) throw new DataException("De hoeveelheid vragen klopt niet.");
		_onderdelen = onderdelen;
	}

	public void setTekst(String tekst) {
		_tekst = tekst;
	}

	public void volgendeOnderdeel() {
		huidigOnderdeel++;
	}

	public void wijzigAntwoord(Onderdeel van, Onderdeel naar) {
		GekozenAntwoord gkVan = null;
		GekozenAntwoord gkNaar = null;

		for (GekozenAntwoord gk : _antwoorden) {
			if (gk.getGekozenOnderdeel() == van) gkVan = gk;

			if (gk.getGekozenOnderdeel() == naar) gkNaar = gk;
		}
		if (gkVan != null) gkVan.setGekozenOnderdeel(naar);
		if (gkNaar != null) gkNaar.setGekozenOnderdeel(van);
	}

}