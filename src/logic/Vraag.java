package logic;

// TODO: Automatisch een stel vragen en onderwerpen selecteren.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.DataException;

public class Vraag {

	private String						_tekst;
	private List<logic.Onderdeel>		_onderdelen;
	private List<logic.GekozenAntwoord>	_antwoorden		= new ArrayList<logic.GekozenAntwoord>();
	private int							huidigOnderdeel	= -1;

	public Vraag(String vraag, List<logic.Onderdeel> onderdelen)
			throws DataException {
		setTekst(vraag);
		setOnderdelen(onderdelen);
	}

	public Onderdeel getHuidigeOnderdeel() {
		return _onderdelen.get(huidigOnderdeel);
	}

	public List<Onderdeel> getOnderdelen() {
		return _onderdelen;
	}

	public int getScore() {
		int score = 0;

		for (GekozenAntwoord gk : _antwoorden)
			if (gk.isGoed())
				score++;

		return score;
	}

	public String getTekst() {
		return _tekst;
	}

	public GekozenAntwoord kiesAntwoord(logic.Onderdeel gekozenOnderdeel) {
		GekozenAntwoord gk = new GekozenAntwoord(getHuidigeOnderdeel(),
				gekozenOnderdeel);
		_antwoorden.add(gk);
		return gk;
	}

	private void setOnderdelen(List<logic.Onderdeel> onderdelen)
			throws DataException {
		if (onderdelen.size() != 9) {
			throw new DataException("De hoeveelheid vragen klopt niet.");
		}
		Collections.shuffle(onderdelen);
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
			if (gk.getGekozenOnderdeel() == van)
				gkVan = gk;

			if (gk.getGekozenOnderdeel() == naar)
				gkNaar = gk;
		}
		if (gkVan != null)
			gkVan.setGekozenOnderdeel(naar);
		if (gkNaar != null)
			gkNaar.setGekozenOnderdeel(van);
	}

}