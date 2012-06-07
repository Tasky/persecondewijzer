package data;

import org.w3c.dom.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Parser {

	private static final String XML_LOCATION = "etc/XML/";
	
	private Document doc;
	private String fileName;
	private File file;
	private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder dBuilder;

	public Parser ( String fileName ) {
		
		setFile( fileName );
		
	}
	
	private void setFile( String fileName ) {
		
		this.fileName = XML_LOCATION + fileName + ".xml";
		this.file = new File( this.fileName );
		
	}
	
	public boolean createXMLFile() {
		
		try{
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	private boolean isFile() {
		
		try{
			file.canRead();
			file.canWrite();
			file.isFile();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	public void readFile() {
		
		try{
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fileName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String doc1 = doc.getDocumentElement().getNodeName();
		System.out.println("1: " + doc1);
		NodeList doc2 = doc.getChildNodes();
		doc.getDocumentElement().normalize();
		NodeList nodes = doc.getDocumentElement().getElementsByTagName("vraag");
		System.out.println( "2: " + nodes.getLength() );
		
		for (  int i = 0; i < nodes.getLength(); i++ ) {
			Node nNode = nodes.item(1);
			System.out.println(nNode.getChildNodes());
		}
	}
	
	
}
