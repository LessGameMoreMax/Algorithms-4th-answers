package myCharpter3_1;

import edu.princeton.cs.algs4.Queue;

public class MyBinarySearchST <Key extends Comparable<Key>,Value>{
	private Key[] keys;
	private Value[] vals;
	private int N;
	public MyBinarySearchST() {
		keys = (Key[]) new Comparable[1];
		vals = (Value[]) new Comparable[1];
	}
	
	public int size()
	{ return N;}
	
	public Value get(Key key){
		if(isEmpty()) return null;
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0) return vals[i];
		else 							   return null;
	}
	
	public int rank(Key key) {
		int lo = 0;
		int hi = N-1;
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp<0) hi = mid -1;
			else if(cmp>0) lo = mid +1;
			else return mid;
		}
		return lo;
	}
	
	public void put(Key key,Value val) {
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0)
		{ vals[i] = val; return;}
		for(int j = N;j>i;j--)
		{ keys[j] = keys[j-1]; vals[j] = vals[j-1];}
		keys[i] = key;
		vals[i] = val;
		N++;
		
		if(N==keys.length) {
			Key[] keyTemp = (Key[]) new Comparable[N*2];
			Value[] valueTemp = (Value[]) new Comparable[N*2];
			for(int k = 0;k<keys.length;k++) {
				keyTemp[k] = keys[k];
				valueTemp[k] = vals[k];
			}
			keys = keyTemp;
			vals = valueTemp;
 		}
	}
	
	public Key min()
	{ return keys[0];}
	
	public Key max()
	{ return keys[N-1];}
	
	public Key select(int k)
	{ return keys[k];}
	
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
	
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q = new Queue<Key>();
		for(int i = rank(lo);i<rank(hi);i++)
			q.enqueue(keys[i]);
		if(contains(hi))
			q.enqueue(keys[rank(hi)]);
		return q;
	}
	
	public boolean contains(Key key) 
	{return get(key)!=null;}
	
	public boolean isEmpty()
	{ return size()==0;}
	
	public Value delete(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i>=N) return null;
		Value temp = vals[i];
		N--;
		for(int j = i;j<N;j++)
		{ keys[j] = keys[j+1]; vals[j] = vals[j+1];}
		keys[N] = null;
		vals[N] = null;
		if(N<=keys.length/4) {
			Key[] keyTemp = (Key[]) new Comparable[keys.length/2];
			Value[] valueTemp = (Value[]) new Comparable[vals.length/2];
			for(int k = 0;k<N;k++) {
				keyTemp[k] = keys[k];
				valueTemp[k] = vals[k];
			}
			keys = keyTemp;
			vals = valueTemp;
		}
		return temp;
	}
	
	public Key floor(Key key) {
		int i = rank(key);
		if(i==0&&!keys[0].equals(key)) return null;
		if(i<N&&keys[i].equals(key)) return keys[i];
		else			  			 return keys[i-1];
	}
	
	public static void main(String[] args) {
		MyBinarySearchST<String,Integer> test = new MyBinarySearchST<String,Integer>();
		test.put("C", 3);
		test.put("D", 4);
		test.put("G", 7);
		test.put("J", 10);
		
		System.out.println(test.floor("Z"));
	}
}
