package data;

import org.w3c.dom.*;
import java.io.File;

public class Content {
	
	private Document doc;
	private File file;
	private static final String XML_LOCATION = "etc/XML/";

	public Content ( String file ) {
		
		createXMLFile(file);
		
	}
	
	public boolean createXMLFile( String fileName ) {
		
		try{
			this.file = new File( XML_LOCATION + fileName);
			file.createNewFile();
		}catch(Exception e) {
			System.err.println(e);
			return false;
		}
		
		return true;
		
	}
	
	
}
