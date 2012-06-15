package logic;

// TODO: Automatisch een stel vragen en onderwerpen selecteren.
import java.util.List;
import java.util.Collections;
import java.util.Observable;

import javax.xml.*;

import exceptions.DataException;

public class Vraag {
	
	private String _tekst;
	private List<logic.Onderdeel> _onderdelen;
	private List<logic.GekozenAntwoord> _antwoorden;
	private int huidigOnderdeel = -1;
	
	public Vraag( String vraag, List<logic.Onderdeel>onderdelen ) throws DataException {
		setTekst(vraag);
		setOnderdelen(onderdelen);
	}
	
	private void setOnderdelen(List<logic.Onderdeel> onderdelen) throws DataException {
		if(onderdelen.size() != 9) {
			throw new DataException("De hoeveelheid vragen klopt niet.");
		}
		Collections.shuffle(onderdelen);
		_onderdelen = onderdelen;
	}
	
	public Onderdeel getHuidigeOnderdeel() {
		return _onderdelen.get(huidigOnderdeel);
	}

	public List<Onderdeel> getOnderdelen() {
		return _onderdelen;
	}
	
	public void kiesAntwoord(logic.Onderdeel gekozenOnderdeel) {
		_antwoorden.add(new GekozenAntwoord(
				getHuidigeOnderdeel(),
				gekozenOnderdeel
		));
	}
	
	public void volgendeOnderdeel() {
		huidigOnderdeel++;
	}

	public void setTekst( String tekst ){
		this._tekst = tekst;
	}
	
	public String getTekst() {
		return this._tekst;
	}

}