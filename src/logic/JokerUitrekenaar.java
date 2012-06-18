package logic;

/**
 * @author tim
 * 
 */
public class JokerUitrekenaar {
	private static final int	jokerKosten	= 16;
	private int					jokersOver	= 0;

	/**
	 * JokerUitrekenaar aanmaken, standaard 2 jokers.
	 */
	public JokerUitrekenaar() {
		setAantalOver(2);
	}

	/**
	 * Geeft aantal jokers terug.
	 * 
	 * @return aantal jokers
	 */
	public int getAantalOver() {
		return jokersOver;
	}

	/**
	 * Krijg de kosten van een joker terug.
	 * 
	 * @return joker kosten
	 */
	public int getKosten() {
		return jokerKosten;
	}

	/**
	 * 
	 * @param timer
	 * @return hoeveel jokers gebruikt kunnen worden
	 */
	public int getMaxJokers(Timer timer) {
		return getAantalOver();
	}

	/**
	 * Zet het aantal jokers op het opgegeven getal.
	 * 
	 * @param aantal
	 */
	public void setAantalOver(int aantal) {
		jokersOver = aantal;
	}

	/**
	 * Verlaagd het jokeraantal met 1.
	 * 
	 * @return true met succes
	 */
	public boolean verwijderJoker() {
		int jokers = getAantalOver();
		if (jokers > 0) {
			setAantalOver(jokers - 1);
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
		for (int i = 0; i < aantal; i++)
			verwijderJoker();
	}

	/**
	 * Functie voor het toevoegen van een enkele joker. Deze functie haalt de huidige aantal jokers op en voegt daar er
	 * 1 aan toe.
	 */
	public void zetJokerIn() {
		setAantalOver(getAantalOver() + 1);
	}

	/**
	 * Functie voor het toevoegen van meerdere jokers. Deze functie loopt een aantal keer de functie addJoker().
	 * 
	 * @param aantal
	 */
	public void zetJokersIn(int aantal) {
		for (int i = 0; i < aantal; i++)
			zetJokerIn();
	}
}
