package data;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import logic.Onderwerp;
import logic.Vraag;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import exceptions.DataException;

public class Content {
	// verkrijg vragen (met onderwerp)
	private Document doc = null;
	public Content() {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			File file = new File(getClass().getResource("/resource/Vragen.xml").toURI());
			doc = docBuilder.parse(file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
	}
	
	// verkrijg onderwerpen
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
			} catch (URISyntaxException e) {
				throw new DataException("Fout in filepath van plaatje bij onderwerp \""+naam+"\"");
			}
        	Onderwerp onderwerp = new Onderwerp(naam, plaatje);
        	onderwerpen.add(onderwerp);
        }
		return onderwerpen;
	}
	
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
        	Vraag vraag = new Vraag(tekst);
        	
        	vragen.add(vraag);
		}
        
		return vragen;
	}
}
