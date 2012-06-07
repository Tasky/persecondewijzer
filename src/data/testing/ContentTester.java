package data.testing;

import static org.junit.Assert.*;

import java.util.List;

import logic.Onderwerp;


import org.junit.Before;
import org.junit.Test;

public class ContentTester {
	private data.Content content;
	
	@Before
	public void setUp() throws Exception {
		content = new data.Content();
	}

	@Test
	public void test() {
		//fail("Not yet implemented"); // TODO
		List<Onderwerp> onderwerpen = content.getOnderwerpen();
		
		assertTrue("Er moeten onderwerpen zijn.", onderwerpen.size() > 0);
	}

}
