package logic;

import java.util.List;

public class PrijsBerekenaar {
	
	List<Vraag> vragen;
	int score = 0;
	
	public PrijsBerekenaar() {
		
	}
	
	public int krijgScore(List<Vraag> vragen) {
		this.vragen = vragen;
		
		parseVragen();
		
		return score;
	}
		
	private void parseVragen() {
		for (Vraag vraag : vragen) {
			this.score += vraag.getScore();
		}
	}
	
	

}
