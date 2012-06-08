package logic;


public class Timer {
	
	private static final int BEGIN_TIJD = 200;
	private int huidigeTijd;
	
	public Timer() {
		huidigeTijd = BEGIN_TIJD;
	}
	
	public boolean hasLost() {
		return ( huidigeTijd > 0 ) ? true : false;
	}
	
	public void setTime( int time ) {
		huidigeTijd = time;
	}
	
	public int getTime() {
		return huidigeTijd;
	}
	

}
