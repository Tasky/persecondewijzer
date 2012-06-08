package data.testing;

import static org.junit.Assert.*;

import java.util.List;

import logic.Onderdeel;
import logic.Onderwerp;
import logic.Vraag;


import org.junit.Before;
import org.junit.Test;

import exceptions.DataException;

public class ContentTester {
	private data.Content content;
	
	@Before
	public void setUp() throws Exception {
		content = new data.Content();
	}

	@Test
	public void testOnderwerpen() throws DataException {
		//fail("Not yet implemented"); // TODO
		List<Onderwerp> onderwerpen = content.getOnderwerpen();
		
		assertTrue("Er moeten onderwerpen zijn.", onderwerpen.size() > 0);
	}

	@Test
	public void testVragen() throws DataException {
		//fail("Not yet implemented"); // TODO
		List<Onderwerp> onderwerpen = content.getOnderwerpen();
		
		for (Onderwerp onderwerp : onderwerpen) {
			List<Vraag> vragen = content.getVragen(onderwerp.getNaam());
			assertTrue(
					"Er moeten vragen zijn bij onderwerp \""+onderwerp.getNaam()+"\".",
					vragen.size() > 0);
			
			for (Vraag vraag : vragen) {
				List<Onderdeel> onderdelen = vraag.getOnderdelen();
				assertTrue(
						"Er moeten 9 onderdelen zijn bij vraag \""+vraag.getVraag()+"\".",
						onderdelen.size() == 9);
			}
		}
	}
}
