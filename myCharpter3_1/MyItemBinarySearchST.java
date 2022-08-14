package myCharpter3_1;

import edu.princeton.cs.algs4.Merge;

public class MyItemBinarySearchST<Key extends Comparable<Key>,Value>{
	private KeyAndValue[] keyValues;
	private Key key;
	private Value val;
	private int N = 0;
	
	public MyItemBinarySearchST(int capacity) {
		keyValues = new KeyAndValue[capacity];
	}
	
	public MyItemBinarySearchST(KeyAndValue[] keyValues) {
		this.keyValues = keyValues;
		Merge.sort((Comparable[]) keyValues);
	}
	
	public int size()
	{ return N;}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i<N&&keyValues[i].getKey().compareTo(key)==0) return (Value) keyValues[i].getValue();
		else											 return null;
	}
	
	public void put(KeyAndValue keyValue) {
		int i = rank((Key)keyValue.getKey());
		if(i<N&&keyValues[i].getKey().compareTo(key)==0) {
			keyValues[i].changeValue(keyValue.getValue());
			return;
		}
		for(int j = N;j>i;j--)
		{ 
			keyValues[j].changeKey(keyValues[j-1].getKey());
			keyValues[j].changeValue(keyValues[j-1].getValue());
		}
		keyValues[i].changeKey(keyValue.getKey()); 
		keyValues[i].changeValue(keyValue.getValue());
		N++;
	}
	
	public int rank(Key key) {
		int lo = 0;
		int hi = N-1;
		while(lo<=hi) {
			int mid = lo + (hi-lo)/2;
			int cmp = key.compareTo((Key) keyValues[mid].getKey());
			if(cmp<0) hi = mid-1;
			else if(cmp>0) lo = mid+1;
			else   return mid;
		}
		return lo;
	}
}
