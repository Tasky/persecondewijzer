package logic;

// TODO: Automatisch een stel vragen en onderwerpen selecteren.
import java.util.Random;
import javax.xml.*;

public class Vraag {
	
	public String vraag;
	
	public Vraag( String vraag ) {
		
		setVraag(vraag);
		
	}
	
	public void setVraag ( String vraag ){
		
		this.vraag = vraag;
		
	}
	
	public String getVraag() {
		
		return this.vraag;
		
	}

}
