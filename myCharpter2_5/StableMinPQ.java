package myCharpter2_5;

public class StableMinPQ<Key extends Comparable<Key>>{
	private CheckIndex[] pq;
	private int N=0;
	
	public StableMinPQ(int maxN)
	{pq = new CheckIndex[maxN+1];}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{return N;}

	public void insert(Key v)
	{
		pq[++N] = new CheckIndex(N,v);
		swim(N);
	}
	
	public Key delMin()
	{
		Key min = (Key) pq[1].checkKey();
//		System.out.print(" ["+pq[1].checkIndex()+"] ");
		exch(1,N--);
		pq[N+1] = null;
		sink(1);
		return min;
	}
	
	private boolean less(int i,int j)
	{ 
		if(pq[i].checkKey().compareTo(pq[j].checkKey())<0) return true;
		if(pq[i].checkKey().compareTo(pq[j].checkKey())>0) return false;
		if(pq[i].checkIndex()<pq[j].checkIndex()) return true;
		if(pq[i].checkIndex()>pq[j].checkIndex()) return false;
		return false;
	}
	
	private void exch(int i,int j){
		Key tempKey = (Key) pq[i].checkKey();
		int tempIndex = pq[i].checkIndex();
		pq[i].checkChange(pq[j].checkIndex(), pq[j].checkKey());
		pq[j].checkChange(tempIndex, tempKey);
		
	}
	
	private void swim(int k)
	{
		while(k>1&&less(k,k/2)) 
		{
			exch(k,k/2);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while(2*k<=N)
		{
			int j = 2*k;
			if(j<N&&less(j+1,j)) j++;
			if(!less(j,k)) break;
			exch(j,k);
			k = j;
		}
	}
}
