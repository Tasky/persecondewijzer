package logic;

import java.io.File;

public class Onderdeel {
	private String _tekst;
	private File _plaatje;
	public Onderdeel(String antwoord, File plaatje) {
		setTekst(antwoord);
		setPlaatje(plaatje);
	}
	
	public File getPlaatje(){
		return _plaatje;
	}
	
	public void setPlaatje(File plaatje) {
		_plaatje = plaatje;
	}

	public String getTekst() {
		return _tekst;
	}
	public void setTekst(String tekst) {
		_tekst = tekst;
	}

	public boolean isGoed() {
		// TODO Auto-generated method stub
		return false;
	}
}
