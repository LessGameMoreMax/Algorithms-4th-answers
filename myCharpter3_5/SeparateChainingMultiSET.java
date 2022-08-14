package myCharpter3_5;

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainingMultiSET <Key extends Comparable>{
	private int N;
	private int M;
	private MultiSET[] set;
	
	public SeparateChainingMultiSET()
	{ this(997);}
	
	public SeparateChainingMultiSET(int M) {
		this.M = M;
		set = new MultiSET[M];
		for(int i = 0;i<M;i++)
			set[i] = new MultiSET();
	}
	
	public int size()
	{ return N;}
	
	private int hash(Key key)
	{ return (key.hashCode() & 0x7fffffff) % M;}
	
	public boolean contains(Key key)
	{ return set[hash(key)].contains(key);}
	
	public void put(Key key)
	{
		int index = hash(key);
		int prevN = set[index].size();
		set[index].put(key);
		this.N += set[index].size() - prevN;
	}
	
	public void delete(Key key) 
	{ set[hash(key)].delete(key);}
	
}
