package classes;

public class Speler {

	
	private String naam;

	
	
	public Speler() {
		
	}
	
	public Speler(String naam){
		
		setNaam( naam );
		
	}
	
	
	public void setNaam( String naam ) {
		
		this.naam = naam;
		
	}
	
	/**
	 * Geeft naam van de huidige speler terug
	 * @return Naam van de huidige speler
	 */
	public String getNaam() {
		
		return this.naam;
		
	}
	
}
