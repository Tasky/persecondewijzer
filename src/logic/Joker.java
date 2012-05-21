package logic;

public class Joker {

	private int aantalJokers;
	
	public Joker() {
		
		setAantal(2);
		
	}
	
	/**
	 * Geeft aantal jokers terug.
	 * @return aantal jokers
	 */
	public int getAantal() {
		
		return this.aantalJokers;
		
	}
	
	/**
	 * Zet het aantal jokers op het opgegeven getal.
	 * @param aantal
	 */
	public void setAantal( int aantal ) {
		
		this.aantalJokers = aantal;
		
	}
	
	/**
	 * Functie voor het toevoegen van een enkele joker. Deze functie haalt de huidige aantal jokers op en voegt daar er 1 aan toe.
	 */
	public void addJoker () {
		
		int huidig = getAantal();
		
		setAantal( huidig+1 );
		
	}
	
	/**
	 * Functie voor het toevoegen van meerdere jokers. Deze functie loopt een aantal keer de functie addJoker().
	 * @param aantal
	 */
	public void addJokers ( int aantal ) {
		
		for ( int i = 0; i < aantal; i++  ) {
			addJoker();
		}
		
	}
	
	/**
	 * Verlaagd het jokeraantal met 1.
	 * @return true met succes
	 */
	public boolean verwijderJoker() {
		
		int jokers = getAantal();
		
		if ( jokers > 0 ) {
			setAantal(jokers-1);
			
			//TODO: timer verlagen met 16 seconde. 
			
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Joker wordt ingezet en verwijderd van het aantal jokers.
	 * @param aantal
	 */
	public void verwijderJokers(int aantal) {
		
		
		int verwijderd = 0;
		while ( aantal < verwijderd ) {
			verwijderJoker();
			verwijderd++;
		}
		
		
	}
	
	
}
