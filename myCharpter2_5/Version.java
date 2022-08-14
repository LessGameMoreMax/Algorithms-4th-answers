package myCharpter2_5;

public class Version implements Comparable<Version>{
	private final int first;
	private final int second;
	private final int third;
	
	public Version(String str)
	{
		String[] fields = str.split("\\.");		//需要使用双转义字符"\\"
		first = Integer.parseInt(fields[0]);
		second = Integer.parseInt(fields[1]);
		third = Integer.parseInt(fields[2]);
	}
	
	public int compareTo(Version that)
	{
		if(this.first>that.first) return +1;
		if(this.first<that.first) return -1;
		if(this.second>that.second) return +1;
		if(this.second>that.second) return -1;
		if(this.third>that.third) return +1;
		if(this.third>that.third) return -1;
		return 0;
	}
	
	public String toString()
	{ return first+"."+second+"."+third;}
	
}
