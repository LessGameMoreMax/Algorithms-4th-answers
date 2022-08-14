package myCharpter3_5;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchMultiSET <Key extends Comparable<Key>,Value>{
	private Key[] keys;
	private int[] number;
	private int N;
	public BinarySearchMultiSET() {
		keys = (Key[]) new Comparable[1];
		number = new int[1];
	}
	
	public int size()
	{ return N;}
	
	public int getNumber(Key key){
		if(isEmpty()) return 0;
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0) return number[i];
		else 							   return 0;
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
	
	public void put(Key key) {
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0)
		{ number[i]++; return;}
		for(int j = N;j>i;j--)
		{ keys[j] = keys[j-1]; number[j] = number[j-1];}
		keys[i] = key;
		number[i] = 1;
		N++;
		
		if(N==keys.length) {
			Key[] keyTemp = (Key[]) new Comparable[N*2];
			int[] numTemp = new int[N*2];
			for(int k = 0;k<keys.length;k++) {
				keyTemp[k] = keys[k];
				numTemp[k] = number[k];
			}
			keys = keyTemp;
			number = numTemp;
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
	{return getNumber(key)!=0;}
	
	public boolean isEmpty()
	{ return size()==0;}
	
	public int delete(Key key) {
		if(isEmpty()) return 0;
		int i = rank(key);
		if(i>=N) return 0;
		int temp = number[i];
		N--;
		for(int j = i;j<N;j++)
		{ keys[j] = keys[j+1]; number[j] = number[j+1];}
		keys[N] = null;
		number[N] = 0;
		if(N<=keys.length/4) {
			Key[] keyTemp = (Key[]) new Comparable[keys.length/2];
			int[] numTemp = new int[number.length/2];
			for(int k = 0;k<N;k++) {
				keyTemp[k] = keys[k];
				numTemp[k] = number[k];
			}
			keys = keyTemp;
			number = numTemp;
		}
		return temp;
	}
}
