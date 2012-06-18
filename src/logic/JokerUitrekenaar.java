package logic;

import exceptions.LogicException;

/**
 * @author tim
 * 
 */
public class JokerUitrekenaar {
	private static final int	jokerKosten		= 16;
	private static final int	startSaldo		= 2;
	private int					jokersGebruikt	= 0;

	/**
	 * Geeft aantal jokers terug.
	 * 
	 * @return aantal jokers
	 */
	public int getAantalOver() {
		return startSaldo - jokersGebruikt;
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
	 * Krijg terug hoeveel jokers er gebruikt kunnen worden.
	 * 
	 * @param timer
	 * @return hoeveel jokers gebruikt kunnen worden
	 */
	public int getMaxJokers(Timer timer) {
		return Math.min(getAantalOver(), timer.getTime() / jokerKosten);
	}

	/**
	 * Verlaagd het jokeraantal met 1.
	 * @param timer waar jokers vanaf gehaald worden
	 * @throws LogicException jokers op
	 */
	public void zetJokerIn(Timer timer) throws LogicException {
		int jokers = getMaxJokers(timer);
		if (jokers <= 0) {
			throw new LogicException("Jokers zijn op!");
		}
		
		jokersGebruikt++;
	}
	
	/**
	 * Functie voor het toevoegen van meerdere jokers. Deze functie loopt een aantal keer de functie addJoker().
	 * @param timer 
	 * @param vraag 
	 * @param aantal
	 * @throws LogicException jokers op
	 */
	public void zetJokersIn(Timer timer, Vraag vraag, int aantal) throws LogicException {
		for (int i = 0; i < aantal; i++)
			zetJokerIn(timer);
	}
}
