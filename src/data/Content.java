package data;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import logic.Onderdeel;
import logic.Onderwerp;
import logic.Vraag;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import exceptions.DataException;

public class Content {
	// verkrijg vragen (met onderwerp)
	private Document doc = null;
	/**
	 * Maak de contentparser aan en bereidt voor op inlezen vragen bestand.
	 * @throws DataException Als de vragen niet gevonden kunnen worden.
	 */
	public Content() throws DataException {
		File file;
		try {
			file = new File(getClass().getResource("/resource/Vragen.xml").toURI());
		} catch (URISyntaxException e1) {
			throw new DataException("Het vragenbestand kan niet worden gevonden.");
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new DataException("Het vragenbestand kan niet gelezen worden.");
		}
		try {
			doc = db.parse(file);
		} catch (SAXException e) {
			throw new DataException("Het vragenbestand kan niet gelezen worden.");
		} catch (IOException e) {
			throw new DataException("Het vragenbestand kan niet worden gevonden.");
		}
		//throw new DataException("Het vragenbestand kan niet worden gevonden.");
		doc.getDocumentElement().normalize();
	}
	
	/**
	 * Haal alle onderwerpen uit resource/Vragen.xml.
	 * @return Lijst met onderwerpen.
	 * @throws DataException Wanneer het path van het plaatje verkeerd is.
	 */
	public List<Onderwerp> getOnderwerpen() throws DataException {
		List<Onderwerp> onderwerpen = new ArrayList<Onderwerp>();
		
        NodeList nodes = doc.getElementsByTagName("onderwerp");
        for(int i=0; i< nodes.getLength(); i++){
        	Element node = (Element) nodes.item(i);
        	String naam = node.getAttribute("name");
        	String path = node.getAttribute("image");
        	File plaatje = null;
        	try {
        		plaatje = new File(getClass().getResource("/resource/images/"+path).toURI());
        	}catch(Exception e) {
        		throw new DataException("Plaatje \""+path+"\" is onvindbaar.");
        	}
			if(!plaatje.canRead()){
				throw new DataException("Plaatje \""+plaatje.getAbsolutePath()+"\" is onvindbaar.");
			}
        	Onderwerp onderwerp = new Onderwerp(naam, plaatje);
        	onderwerpen.add(onderwerp);
        }
		return onderwerpen;
	}
	/**
	 * 
	 * @param onderwerpNaam
	 * @return
	 * @throws DataException
	 */
	public List<Vraag> getVragen(String onderwerpNaam) throws DataException {
		return getVragen(onderwerpNaam, 4);
	}
	public List<Vraag> getVragen(String onderwerpNaam, int hoeveel) throws DataException {
        NodeList nodes = doc.getElementsByTagName("onderwerp");
        Element onderwerp = null;
        for(int i=0; i< nodes.getLength(); i++){
        	Element node = (Element) nodes.item(i);
        	if(node.getAttribute("name") == onderwerpNaam)
        	{
        		onderwerp = node;
        	}
        }
        
        if(onderwerp == null) {
        	throw new DataException("Onderwerp bestaat niet");
        }
        
        List<Vraag> vragen = new ArrayList<Vraag>();
        nodes = onderwerp.getElementsByTagName("vraag");
        ArrayList<Integer> vragenKeys = new ArrayList<Integer>();
        for (int i = 0; i < nodes.getLength(); i++) {
			vragenKeys.add(i);
		}
        Collections.shuffle(vragenKeys);
        if(hoeveel > nodes.getLength()) {
        	hoeveel = nodes.getLength();
        }
        for (int i = 0; i < hoeveel; i++) {
        	Element node = (Element) nodes.item(vragenKeys.get(i));
        	String tekst = node.getElementsByTagName("tekst").item(0).getTextContent();
        	List<Onderdeel> onderdelen = new ArrayList<Onderdeel>();
        	
        	NodeList nodesOnderdelen = ((Element)node.getElementsByTagName("onderdelen").item(0)).getElementsByTagName("onderdeel");
        	for (int j = 0; j < nodesOnderdelen.getLength(); j++) {
        		Element nodeOnderdeel = (Element) nodesOnderdelen.item(j);
        		String antwoord = nodeOnderdeel.getTextContent();
        		String path = nodeOnderdeel.getAttribute("image");
        		File plaatje = null;
    			try {
    				plaatje = new File(getClass().getResource("/resource/images/"+path).toURI());
    			} catch (URISyntaxException e) {
    				throw new DataException("Fout in filepath van plaatje van onderdeel \""+antwoord+"\"");
    			}
    			
        		Onderdeel o = new Onderdeel(antwoord, plaatje);
        		
        		onderdelen.add(o);	
			}
        	vragen.add(new Vraag(tekst, onderdelen));
		}
        
		return vragen;
	}
}
