package myCharpter3_5;

import edu.princeton.cs.algs4.ST;

public class SparseVector {
	private ST<Integer,Double> st;
	public SparseVector()
	{ st = new ST<Integer,Double>();}
	public int size()
	{ return st.size();}
	public void put(int i,double x)
	{ st.put(i, x);}
	public double get(int i) {
		if(!st.contains(i)) return 0.0;
		else return st.get(i);
	}
	public int getMax()
	{ return st.max();}
	public double dot(double[] that) {
		double sum = 0.0;
		for(int i : st.keys())
			sum += that[i]*this.get(i);
		return sum;
	}
	public SparseVector sum(SparseVector that) {
		SparseVector vector = new SparseVector();
		int max = this.getMax()<that.getMax() ? that.getMax() : this.getMax();
		for(int i = 0;i<=max;i++) {
			if(this.st.contains(i)&&!that.st.contains(i))
				vector.put(i, this.get(i));
			if(!this.st.contains(i)&&that.st.contains(i))
				vector.put(i, that.get(i));
			if(this.st.contains(i)&&that.st.contains(i)) 
				vector.put(i, this.get(i)+that.get(i));
		}
		return vector;
	}
}
