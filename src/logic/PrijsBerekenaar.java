package logic;

import java.util.List;

/**
 * PrijsBerekenaar klasse.
 *
 */
public class PrijsBerekenaar {
	private static final int	MAX_BELASTINGVRIJ		= 454;
	private static final int	KANSSPELBELASTING		= 25;

	/**
	 * Krijg score terug.
	 * 
	 * @param vragen
	 * @return berekende score
	 */
	public int getScore(final List<Vraag> vragen) {
		int vragenGoed = 0;
		
		for (Vraag vraag : vragen) {
			int aantalGoed = 0;
			int aantalFout = 0;
			int jokers = vraag.getHoeveelJokersGebruikt();
			for (GekozenAntwoord gk : vraag.getGekozenAntwoorden())
				if (gk.isGoed()) aantalGoed++;
				else aantalFout++;
			
			vragenGoed += (aantalGoed + Math.min(aantalFout, jokers));
		}
		
		double bedrag = 0;
		for (Vraag vraag : vragen) {
			bedrag += vragenGoed * vraag.getHoeveelWaard();
			if(vraag.isDoubling()) bedrag *= 2;
		}
		
		if (bedrag > MAX_BELASTINGVRIJ) bedrag /= (KANSSPELBELASTING / 100 + 1);
		
		return (int) Math.round(bedrag);
	}
}