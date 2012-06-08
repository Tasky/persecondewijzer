package logic;


public class Timer {
	
	private static final int BEGIN_TIJD = 200;
	private static final int JOKER_TIJD = 16;
	private int huidigeTijd;
	
	public Timer() {
		huidigeTijd = BEGIN_TIJD;
	}
	
	public String toString() {
		return Integer.toString(huidigeTijd);
	}
	
	public boolean hasLost() {
		return ( huidigeTijd > 0 ) ? true : false;
	}
	
	public boolean canDeductJoker( int jokerAmount ) {
		return ( ( BEGIN_TIJD - ( jokerAmount * JOKER_TIJD ) ) > 0 ) ? true : false;
	}
	
	public void deductJoker( int jokerAmount ) {
		setTime( getTime() - ( jokerAmount * JOKER_TIJD ) );
	}
	
	private void setTime( int time ) {
		huidigeTijd = time;
	}
	
	public int getTime() {
		return huidigeTijd;
	}
	

}
