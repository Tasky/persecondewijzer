package logic;

// TODO: Automatisch een stel vragen en onderwerpen selecteren.
import java.util.List;
import java.util.Collections;
import javax.xml.*;

import exceptions.DataException;

public class Vraag {
	
	private String _tekst;
	private List<logic.Onderdeel> _onderdelen;
	
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

	public void setTekst( String tekst ){
		this._tekst = tekst;
	}
	
	public String getTekst() {
		return this._tekst;
	}

	public List<Onderdeel> getOnderdelen() {
		return _onderdelen;
	}
}