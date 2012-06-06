package data;

import org.w3c.dom.*;
import java.io.File;

public class Content {
	
	private Document doc;
	private String fileName;
	private File file;
	private static final String XML_LOCATION = "etc/XML/";

	public Content ( String fileName ) {
		
		setFile( fileName );
		createXMLFile();
		
	}
	
	private void setFile( String fileName ) {
		
		this.fileName = XML_LOCATION + file + ".xml";
		this.file = new File( this.fileName );
		
	}
	
	public boolean createXMLFile() {
		
		try{
			file.createNewFile();
		}catch(Exception e) {
			System.err.println(e);
			return false;
		}
		
		return true;
		
	}
	
	private boolean isFile() {
		
		try{
			file.canRead();
			file.canWrite();
		}catch(Exception e){
			System.err.println(e);
			return false;
		}
		
		return true;
		
	}
	
	
}
