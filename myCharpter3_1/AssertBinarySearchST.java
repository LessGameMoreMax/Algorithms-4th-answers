package myCharpter3_1;

public class AssertBinarySearchST<Key extends Comparable<Key>,Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	public AssertBinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size()
	{ return N;}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0) return vals[i];
		else							   return null;
	}
	
	public int rank(Key key) {
		int lo = 0;
		int hi = N-1;
		while(lo<=hi) {
			int mid = lo + (hi-lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp<0) hi = mid-1;
			else if(cmp>0) lo = mid+1;
			else return mid;
		}
		return lo;
	}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public void put(Key key,Value val) {
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0)
		{ vals[i] = val; return;}
		for(int j = N;j>i;j--)
		{ keys[j] = keys[j-1]; vals[j] = vals[j-1];}
		keys[i] = key;
		vals[i] = val;
		N++;
        assert check() :"Put worng!";
	}
	
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;
        int i = rank(key);
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < N-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        N--;
        keys[N] = null;
        vals[N] = null;
        assert check() :"Delete worng!";
    }
	
	public Key select(int k)
	{ return keys[k];}
	
	public boolean check() {
		if(isSorted()&&rankCheck()) return true;
		return false;
	}
	
	public boolean isSorted() {
		for(int i = 1;i<size();i++)
			if(keys[i].compareTo(keys[i-1])<0) return false;
		return true;
	}
	
	public boolean rankCheck() {
		for(int i = 0;i<size();i++)
			if(i!=rank(select(i))) return false;
		return true;
	}
}
