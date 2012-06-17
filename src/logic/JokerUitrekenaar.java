package logic;

/**
 * @author tim
 *
 */
public class JokerUitrekenaar {
	private final int jokerKosten = 16;
	private int	aantalJokers;

	/**
	 * JokerUitrekenaar aanmaken, standaard 2 jokers.
	 */
	public JokerUitrekenaar() {
		setAantal(2);
	}

	/**
	 * Geeft aantal jokers terug.
	 * 
	 * @return aantal jokers
	 */
	public int getAantal() {
		return aantalJokers;
	}

	/**
	 * Krijg de kosten van een joker terug.
	 * @return joker kosten
	 */
	public int getKosten() {
		return jokerKosten;
	}

	/**
	 * Zet het aantal jokers op het opgegeven getal.
	 * 
	 * @param aantal
	 */
	public void setAantal(int aantal) {
		aantalJokers = aantal;
	}

	/**
	 * Verlaagd het jokeraantal met 1.
	 * 
	 * @return true met succes
	 */
	public boolean verwijderJoker() {
		int jokers = getAantal();
		if (jokers > 0) {
			setAantal(jokers - 1);
			// TODO: timer verlagen met 16 seconde.
			return true;
		}
		return false;
	}

	/**
	 * Joker wordt ingezet en verwijderd van het aantal jokers.
	 * 
	 * @param aantal
	 */
	public void verwijderJokers(int aantal) {
		for (int i = 0; i < aantal; i++) {
			verwijderJoker();
		}
	}

	/**
	 * Functie voor het toevoegen van een enkele joker. Deze functie haalt de
	 * huidige aantal jokers op en voegt daar er 1 aan toe.
	 */
	public void zetJokerIn() {
		setAantal(getAantal() + 1);
	}

	/**
	 * Functie voor het toevoegen van meerdere jokers. Deze functie loopt een
	 * aantal keer de functie addJoker().
	 * 
	 * @param aantal
	 */
	public void zetJokersIn(int aantal) {
		for (int i = 0; i < aantal; i++)
			zetJokerIn();
	}
}
