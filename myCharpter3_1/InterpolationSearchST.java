package myCharpter3_1;

public class InterpolationSearchST<Key extends Comparable<Key>,Value> {
	private Integer[] keys;
	private Value[] vals;
	private int N;
	
	public InterpolationSearchST(int capacity) {
		keys = new Integer[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size()
	{ return N;}
	
	public Value get(Integer key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i<N&&keys[i]==key) return vals[i];
		else 							   return null;
	}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public void put(Integer key,Value val) {
		int i = rank(key);
		if(i<N&&keys[i]==key)
		{ vals[i] = val; return;}
		for(int j = N;j>i;j--)
		{keys[j] = keys[j-1]; vals[j] = vals[j-1];}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public int rank(Integer key) {
		int lo = 0;
		int hi = N-1;
		while(lo<=hi) {
			int seek = lo + (hi-lo)*(key-keys[lo])/(keys[hi]-keys[lo]);
			int cmp = key.compareTo(keys[seek]);
			if(cmp<0) hi = seek - 1;
			else if(cmp>0) lo = seek +1;
			else return seek;
		}
		return lo;
	}
}
