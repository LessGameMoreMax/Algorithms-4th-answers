package myCharpter4_4;

import myCharpter4_3.MyEdge;

public class MyDirectedEdge implements Comparable<MyDirectedEdge> {
	private final int v;
	private final int w;
	private final double weight;
	
	public MyDirectedEdge(int v,int w,double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight()
	{ return weight;}
	
	public int from()
	{ return v;}
	
	public int to()
	{ return w;}
	
	public int compareTo(MyDirectedEdge that) {
		if(this.weight()<that.weight()) return -1;
		else if(this.weight()>that.weight()) return +1;
		else		return 0;
	}
	
	public String toString()
	{ return String.format("%d->%d %.2f", v, w,weight);}
	
	
}
