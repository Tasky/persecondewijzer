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
	
	public String getNaam() {
		
		return this.naam;
		
	}
	
}
