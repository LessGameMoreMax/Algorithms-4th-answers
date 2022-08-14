package myCharpter2_5;

public class Domain implements Comparable<Domain>{
	private final String first;
	private final String second;
	private final String third;
	
	public Domain(String domain)
	{
		String[] s = domain.split("\\.");
		first = s[0];
		second = s[1];
		third = s[2];
	}
	
	public int compareTo(Domain that)
	{
		if(this.third.compareTo(that.third)>0) return +1;
		if(this.third.compareTo(that.third)<0) return -1;
		
		if(this.second.compareTo(that.second)>0) return +1;
		if(this.second.compareTo(that.second)<0) return +1;
		
		if(this.first.compareTo(that.first)>0) return +1;
		if(this.first.compareTo(that.first)<0) return -1;
		
		return 0;
	}
	
	public String toString()
	{ return first+"."+second+"."+third;}

}
