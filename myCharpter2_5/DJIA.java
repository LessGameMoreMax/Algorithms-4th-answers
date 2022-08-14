package myCharpter2_5;

public class DJIA implements Comparable<DJIA>{
	private final String information;
	private final long number;
	
	public DJIA(String information,long number) {
		this.information = information;
		this.number = number;
	}
	
	public int compareTo(DJIA that)
	{
		if(this.number>that.number) return +1;
		if(this.number<that.number) return -1;
		return 0;
	}
	
	public String toString()
	{ return information+" "+number;}
}
