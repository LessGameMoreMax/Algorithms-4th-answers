package myCharpter3_5;

import edu.princeton.cs.algs4.MinPQ;
public class HashSTint <Value>{
	private int N;
	private int M = 16;
	private int[] keys;
	private Value[] vals;
	public HashSTint() {
		keys = new int[M];
		vals = (Value[]) new Object[M];
	}
	
	public HashSTint(int num) {
		keys = new int[num];
		vals = (Value[]) new Object[num];
		M = num;
	}
	
	private int hash(int key)
	{ return (((Integer)key).hashCode()&0x7fffffff)%M;}
	
	private void resize(int cap) {
		HashSTint<Value> t = new HashSTint<Value>(cap);
		for(int i = 0;i<M;i++)
			if(vals[i]!=null)
				t.put(keys[i],vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	public void put(int key,Value val) {
		if(N>=M/2) resize(2*M);
		int i;
		for(i = hash(key);vals[i]!=null;i=(i+1)%M)
			if(keys[i]==key&&vals!=null) {
				vals[i] = val;
				return;
			}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public Value get(int key) {
		for(int i = hash(key);vals[i]!=null;i = (i+1)%M)
			if(keys[i]==key&&vals[i]!=null) return vals[i];
		return null;
	}
	
	public void delete(int key) {
		if(!contains(key)) return;
		int i = hash(key);
		while(key!=keys[i]&&vals[i]!=null)
			i = (i+1)%M;
		keys[i] = 0;
		vals[i] = null;
		i = (i+1)%M;
		while(vals[i]!=null) {
			int keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = 0;
			vals[i] = null;
			N--;
			put(keyToRedo,valToRedo);
			i = (i+1)%M;
		}
		N--;
		if(N>0&&N==M/8) resize(M/2);
	}
	
	public boolean contains(int key)
	{return get(key)!=null;}
}
