package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

import nu.xom.*;

import exceptions.DataException;

public class Highscore {
	private Document doc;
	private Transformer tf;
	private File file;

	public Highscore() throws DataException {
		try {
			file = new File(getClass().getResource("/resource/Highscores.xml").toURI());
		} catch (URISyntaxException e1) {
			throw new DataException("Het highscorebestand kan niet worden gevonden.");
		}

		try {
			doc = new Builder().build(file);
		} catch (ValidityException e) {
			throw new DataException("Fout bij validatie van highscorebestand.\r\n"+e.getMessage());
		} catch (ParsingException e) {
			throw new DataException("Fout bij parsen van highscorebestand.\r\n"+e.getMessage());
		} catch (IOException e) {
			throw new DataException("Het highscorebestand kan niet worden gevonden.");
		}
	}
	
	public List<Highscore> getHighscores(int hoeveel) {
		return null;
		
	}
	
	public void addHighscore(String spelerNaam, String prijs, String tijdOver) {
		//"Naam", "Prijzengeld", "Tijd over"
		Element elHighscore = new Element("highscore");
		elHighscore.addAttribute(new Attribute("naam", spelerNaam));
		elHighscore.addAttribute(new Attribute("prijs", prijs));
		elHighscore.addAttribute(new Attribute("tijdOver", tijdOver));
		doc.getRootElement().appendChild(elHighscore);
		String xml = doc.toXML();
		try {
			FileWriter fstream = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fstream);
		    out.write(xml);
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
