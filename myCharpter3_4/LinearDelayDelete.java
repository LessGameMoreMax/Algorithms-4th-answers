package myCharpter3_4;

public class LinearDelayDelete <Key,Value>{
	private int N;
	private int M = 16;
	private Key[] keys;
	private Value[] vals;
	public LinearDelayDelete() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public LinearDelayDelete(int num) {
		keys = (Key[]) new Object[num];
		vals = (Value[]) new Object[num];
		M = num;
	}
	
	private int hash(Key key)
	{ return (key.hashCode()&0x7fffffff)%M;}
	
	private void resize(int cap) {
		LinearDelayDelete<Key,Value> t = new LinearDelayDelete<Key,Value>(cap);
		for(int i = 0;i<M;i++)
			if(keys[i]!=null&&vals[i]!=null)
				t.put(keys[i],vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	public void put(Key key,Value val) {
		int i;
		for(i = hash(key);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		keys[i] = key;
		vals[i] = val;
		N++;
		if(N>=M/4) resize(2*M);
	}
	
	public Value get(Key key) {
		for(int i = hash(key);keys[i]!=null;i = (i+1)%M)
			if(keys[i].equals(key)) return vals[i];
		return null;
	}
	
	public void deleteDelay(Key key) {
		if(!contains(key)) return;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (i+1)%M;
		vals[i] = null;
		N--;
		if(N<=M/8) resize(M/2);
	}
	
	public boolean contains(Key key)
	{return get(key)!=null;}
}
