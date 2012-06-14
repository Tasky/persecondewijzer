package logic;

// TODO: Automatisch een stel vragen en onderwerpen selecteren.
import java.util.List;
import java.util.Collections;
import javax.xml.*;

import exceptions.DataException;

public class Vraag {
	
	private String _vraag;
	private List<logic.Onderdeel> _onderdelen;
	
	public Vraag( String vraag, List<logic.Onderdeel>onderdelen ) throws DataException {
		setVraag(vraag);
		setOnderdelen(onderdelen);
	}
	
	private void setOnderdelen(List<logic.Onderdeel> onderdelen) throws DataException {
		if(onderdelen.size() != 9) {
			throw new DataException("De hoeveelheid vragen klopt niet.");
		}
		Collections.shuffle(onderdelen);
		_onderdelen = onderdelen;
	}

	public void setVraag ( String vraag ){
		this._vraag = vraag;
	}
	
	public String getVraag() {
		return this._vraag;
	}

	public List<Onderdeel> getOnderdelen() {
		// TODO Auto-generated method stub
		return _onderdelen;
	}
}