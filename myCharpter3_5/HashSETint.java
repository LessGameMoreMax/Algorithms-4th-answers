package myCharpter3_5;

public class HashSETint{
	private int N;
	private int M = 16;
	private int[] keys;
	private boolean[] vals;
	public HashSETint() {
		keys = new int[M];
		vals = new boolean[M];
	}
	
	public HashSETint(int num) {
		keys = new int[num];
		vals = new boolean[num];
		M = num;
	}
	
	private int hash(int key)
	{ return (((Integer)key).hashCode()&0x7fffffff)%M;}
	
	private void resize(int cap) {
		HashSETint t = new HashSETint(cap);
		for(int i = 0;i<M;i++)
			if(vals[i])
				t.put(keys[i],vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	public void put(int key)
	{ put(key,true);}
	
	private void put(int key,boolean val) {
		if(N>=M/2) resize(2*M);
		int i;
		for(i = hash(key);vals[i];i=(i+1)%M)
			if(keys[i]==key&&vals[i]) {
				vals[i] = val;
				return;
			}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	private boolean contains(int key) {
		for(int i = hash(key);vals[i];i = (i+1)%M)
			if(keys[i]==key&&vals[i]) return vals[i];
		return false;
	}
	
	public void delete(int key) {
		if(!contains(key)) return;
		int i = hash(key);
		while(key!=keys[i]&&vals[i])
			i = (i+1)%M;
		keys[i] = 0;
		vals[i] = false;
		i = (i+1)%M;
		while(vals[i]) {
			int keyToRedo = keys[i];
			boolean valToRedo = vals[i];
			keys[i] = 0;
			vals[i] = false;
			N--;
			put(keyToRedo,valToRedo);
			i = (i+1)%M;
		}
		N--;
		if(N>0&&N==M/8) resize(M/2);
	}
}

