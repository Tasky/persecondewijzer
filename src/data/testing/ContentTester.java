package data.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import logic.Onderdeel;
import logic.Onderwerp;
import logic.Vraag;

import org.junit.Before;
import org.junit.Test;

import exceptions.DataException;

/**
 * @author nanne
 * 
 */
public class ContentTester {
	private data.Content	content;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		content = new data.Content();
	}

	/**
	 * @throws DataException
	 */
	@Test
	public void testOnderwerpen() throws DataException {
		List<Onderwerp> onderwerpen = content.getOnderwerpen();

		assertTrue("Er moeten onderwerpen zijn.", onderwerpen.size() > 0);
	}

	/**
	 * @throws DataException
	 */
	@Test
	public void testVragen() throws DataException {
		List<Onderwerp> onderwerpen = content.getOnderwerpen();

		for (Onderwerp onderwerp : onderwerpen) {
			List<Vraag> vragen = content.getVragen(onderwerp.getNaam());
			assertTrue("Er moeten vragen zijn bij onderwerp \"" + onderwerp.getNaam() + "\".", vragen.size() > 0);
			assertTrue("Er meer dan 3 vragen zijn bij onderwerp \"" + onderwerp.getNaam() + "\".", vragen.size() > 3);

			for (Vraag vraag : vragen) {
				List<Onderdeel> onderdelen = vraag.getOnderdelen();
				assertTrue("Er moeten 9 onderdelen zijn bij vraag \"" + vraag.getTekst() + "\".",
						onderdelen.size() == 9);
			}
		}
	}
}
