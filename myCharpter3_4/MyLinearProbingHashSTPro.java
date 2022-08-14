package myCharpter3_4;

import edu.princeton.cs.algs4.MinPQ;

public class MyLinearProbingHashSTPro <Key,Value>{
	private int N;
	private int M = 16;
	private Key[] keys;
	private Value[] vals;
	public MyLinearProbingHashSTPro() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public MyLinearProbingHashSTPro(int num) {
		keys = (Key[]) new Object[num];
		vals = (Value[]) new Object[num];
		M = num;
	}
	
	private int hash(Key key)
	{ return (key.hashCode()&0x7fffffff)%M;}
	
	private void resize(int cap) {
		MyLinearProbingHashSTPro<Key,Value> t = new MyLinearProbingHashSTPro<Key,Value>(cap);
		for(int i = 0;i<M;i++)
			if(keys[i]!=null)
				t.put(keys[i],vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	public void put(Key key,Value val) {
		if(N>=M/2) resize(2*M);
		int i;
		for(i = hash(key);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public Value get(Key key) {
		for(int i = hash(key);keys[i]!=null;i = (i+1)%M)
			if(keys[i].equals(key)) return vals[i];
		return null;
	}
	
	public void delete(Key key) {
		if(!contains(key)) return;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (i+1)%M;
		keys[i] = null;
		vals[i] = null;
		i = (i+1)%M;
		while(keys[i]!=null) {
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo,valToRedo);
			i = (i+1)%M;
		}
		N--;
		if(N>0&&N==M/8) resize(M/2);
	}
	
	public boolean contains(Key key)
	{return get(key)!=null;}
	
	public Iterable<Key> keys(){
		MinPQ<Key> pq = new MinPQ<Key>();
		for(int i = 0;i<keys.length;i++)
			if(keys[i]!=null) pq.insert(keys[i]);
		return pq; 
	}
	
	public int getCompare(Key key) {
		int num = 1;
		for(int i = hash(key);keys[i]!=null;i = (i+1)%M)
			if(keys[i].equals(key)) return num;
			else					num++;
		return 0;
	}
	
	public int avgCompare() {
		int num = 0;
		for(Key k : this.keys())
			num += getCompare(k);
		return num/N;
	}
}
