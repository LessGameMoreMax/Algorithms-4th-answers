package myCharpter3_4;

import edu.princeton.cs.algs4.SequentialSearchST;

public class MySeparateChainingHashST <Key,Value>{
	private int N;
	private int M;
	private SequentialSearchST<Key,Value>[] st;
	
	public MySeparateChainingHashST()
	{ this(997);}
	
	public MySeparateChainingHashST(int M) {
		this.M = M;
		st = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[M];
		for(int i = 0;i<M;i++)
			st[i] = new SequentialSearchST();
	}
	
	public int size()
	{ return N;}
	
	private int hash(Key key)
	{ return (key.hashCode() & 0x7fffffff) % M;}
	
	public Value get(Key key)
	{ return (Value) st[hash(key)].get(key);}
	
	public void put(Key key,Value val)
	{
		int index = hash(key);
		int prevN = st[index].size();
		st[index].put(key, val);
		this.N += st[index].size() - prevN;
	}
	
	public void delete(Key key) 
	{ st[hash(key)].delete(key);}
	
	
}
