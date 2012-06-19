package logic;

import java.io.File;

public class Onderdeel {
	private String	_tekst;
	private String	_antwoord;
	private File	_plaatje;

	public Onderdeel(String antwoord, File plaatje) {
		setTekst(antwoord);
		setPlaatje(plaatje);
	}

	/**
	 * @return the _antwoord
	 */
	public String getAntwoord() {
		if (_antwoord == null) return getTekst();
		return _antwoord;
	}

	public File getPlaatje() {
		return _plaatje;
	}

	public String getTekst() {
		return _tekst;
	}

	/**
	 * @param _antwoord
	 *            the _antwoord to set
	 */
	public void setAntwoord(String _antwoord) {
		this._antwoord = _antwoord;
	}

	public void setPlaatje(File plaatje) {
		_plaatje = plaatje;
	}

	public void setTekst(String tekst) {
		_tekst = tekst;
	}

	@Override
	public String toString() {
		return getTekst();
	}
}
