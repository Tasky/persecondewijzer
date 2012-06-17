package logic;

public class Speler {

	private String	naam;

	public Speler() {

	}

	/**
	 * Constructor waarbij gelijk de naam toegewezen kan worden zonder setNaam() aan te roepen.
	 * 
	 * @param naam
	 *            Naam van de huidige speler
	 */
	public Speler(String naam) {

		setNaam(naam);

	}

	/**
	 * Geeft naam van de huidige speler terug
	 * 
	 * @return Naam van de huidige speler
	 */
	public String getNaam() {

		return naam;

	}

	/**
	 * Stelt naam in van het huidige object
	 * 
	 * @param naam
	 *            Naam van de huidige speler
	 */
	public void setNaam(String naam) {

		this.naam = naam;

	}

	/**
	 * Handig maar geeft het zelfde resultaat als getNaam()
	 * 
	 * @return Naam van de huidige speler
	 */
	@Override
	public String toString() {

		return getNaam();

	}

}
