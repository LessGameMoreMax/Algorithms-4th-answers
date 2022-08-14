package myCharpter3_4;

import edu.princeton.cs.algs4.MinPQ;

public class MySeparateChainingHashSTPro <Key,Value>{
	private int N;
	private int M;
	private SequentialSearchSTPro<Key,Value>[] st;
	
	public MySeparateChainingHashSTPro()
	{ this(997);}
	
	public MySeparateChainingHashSTPro(int M) {
		this.M = M;
		st = (SequentialSearchSTPro<Key,Value>[]) new SequentialSearchSTPro[M];
		for(int i = 0;i<M;i++)
			st[i] = new SequentialSearchSTPro();
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
		st[index].put(key, val,N);
		this.N += st[index].size() - prevN;
	}
	
	public void checkDelete(int k) {
		for(int i = 0;i<M;i++)
			while(!st[i].kIsEmpty(k)) 
			  st[i].checkDelete(k);
	}
	
	public Iterable<Key> keys(){
		MinPQ<Key> pq = new MinPQ<Key>();
		for(int i = 0;i<M;i++)
			if(st[i]!=null)
				for(Key k : st[i].keys())
					pq.insert(k);
		return pq;
	}
}

