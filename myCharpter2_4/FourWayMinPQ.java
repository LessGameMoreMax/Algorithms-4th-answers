package myCharpter2_4;

public class FourWayMinPQ<Key extends Comparable<Key>>{
	private Key[] pq;
	private int N = 0;
	
	public FourWayMinPQ(int maxN)
	{pq = (Key[]) new Comparable[maxN+1];}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{return N;}

	public void insert(Key v)
	{
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMin()
	{
		Key min = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		sink(1);
		return min;
	}
	
	private boolean less(int i,int j)
	{ return pq[i].compareTo(pq[j])<0;}
	
	private void exch(int i,int j)
	{ Key temp = pq[i]; pq[i] = pq[j]; pq[j] = temp;}
	
	private void swim(int k)
	{
		while(k>1&&less(k,(k+2)/4)) 
		{
			exch(k,(k+2)/4);
			k = (k+2)/4;
		}
	}
	
	private void sink(int k)
	{
		while(4*k<=N)
		{
			int j = 4*k;
			if(j<N) {
				int i = j-2;
				if(!less(i,j-1)) i = j-1;
				if(!less(i,j)) i = j;
				if(!less(i,j+1)) i = j+1;
				j = i;
			}
			if(!less(j,k)) break;
			exch(j,k);
			k = j;
		}
	}
	
	public static void main(String[] args)
	{
		FourWayMinPQ<Integer> test = new FourWayMinPQ<Integer>(10);
		test.insert(4);
		test.insert(6);
		test.insert(7);
		test.insert(2);
		test.insert(3);
		test.insert(1);
		test.insert(9);
		while(!test.isEmpty())
			System.out.print(test.delMin()+" ");
	}
}

