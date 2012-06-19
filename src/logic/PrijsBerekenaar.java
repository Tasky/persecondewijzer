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
		int score = hoeveelGoed(vragen);
		double bedrag = vragen.get(vragen.size() - 1).getHoeveelWaard() * score;
		
		if (bedrag > MAX_BELASTINGVRIJ) bedrag /= (KANSSPELBELASTING / 100 + 1);
		
		return (int) Math.round(bedrag);
	}

	/**
	 * Algoritme om uit te rekenen hoeveel vragen een speler geld voor krijgt.
	 * @param vragen
	 * @return hoeveel vragen er goed zijn
	 */
	private int hoeveelGoed(final List<Vraag> vragen) {
		int vragenGoed = 0;
		for (Vraag vraag : vragen) {
			int aantalGoed = 0;
			int aantalFout = 0;
			int jokers = vraag.getHoeveelJokersGebruikt();
			for (GekozenAntwoord gk : vraag.getGekozenAntwoorden())
				if (gk.isGoed()) aantalGoed++;
				else aantalFout++;
			
			vragenGoed += aantalGoed + Math.min(aantalFout, jokers);
		}
		return vragenGoed;
	}
}