package myCharpter2_5;

public class SPT implements Comparable<SPT> {
	private final String name;
	private final double time;
	
	public SPT(String name,double time)
	{this.name = name; this.time = time;}
	
	public int compareTo(SPT that)
	{
		if(this.time<that.time) return -1;
		if(this.time>that.time) return +1;
		return 0;
	}
	
	public String toString()
	{ return name+" "+time;}
}
