package myCharpter3_4;

import edu.princeton.cs.algs4.SequentialSearchST;

public class MySeparateChainingHashSTProMax <Key,Value>{
	private int N;
	private int M;
	private int num;
	
	private SequentialSearchST<Key,Value>[] st;
	private int[] primes = {31,61,127,251,509,1021,2039,4093,8191,16381,32749,65521};
	
	public MySeparateChainingHashSTProMax(int num)
	{ this(10,0); this.num = num;}
	
	public MySeparateChainingHashSTProMax(int M,int num) {
		this.M = M;
		st = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[M];
		for(int i = 0;i<M;i++)
			st[i] = new SequentialSearchST();
	}
	
	private int hash(Key key) {
		int t = key.hashCode() & 0x7fffffff;
		if(Math.log10(M)<26) t = t % primes[(int)Math.log10(M)+5];
		return t%M;
	}
	
	public Value get(Key key)
	{ return (Value) st[hash(key)].get(key);}
	
	public void put(Key key,Value val) {
		int index = hash(key);
		int preN = st[index].size();
		st[index].put(key, val);
		N += st[index].size()-preN;
		if(N>=M*num/2)  resize(M*2);
	}
	
	private void resize(int cap) {
		SequentialSearchST[] newSt = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[cap];
		for(int i = 0;i<cap;i++)
			newSt[i] = new SequentialSearchST();
		for(int i = 0;i<M;i++)
			newSt[i] = st[i];
		st = newSt;
		M = cap;
	}
	
	public void delete(Key key) {
		int index = hash(key);
		int preN = st[index].size();
		st[index].delete(key);
		N += st[index].size()-preN;
		if(N<=M*num/4)  resize(M/2);
	}
	
	public double chiSquareStatistic() {
		double sum = 0;
		for(int i = 0;i<M;i++)
			sum += (st[i].size()-(double)N/M)*(st[i].size()-(double)N/M);
		return (double)M*sum/(double)N;
	}
}
