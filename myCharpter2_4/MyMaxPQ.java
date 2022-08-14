package myCharpter2_4;

public class MyMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private Key min;
	private int N = 0;
	
	public MyMaxPQ(int maxN)
	{ pq = (Key[]) new Comparable[maxN+1];}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{ return N;}
	
	public void insert(Key v)
	{
		if(N==0) min = v;
		if(v.compareTo(min)<0) min = v;
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax()
	{
		if(N==0) return null;
		Key max = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		if(N!=0) sink(1);
		else min = null;
		return max;
	}
	
	private boolean less(int i,int j)
	{ return pq[i].compareTo(pq[j])<0;}
	
	private void exch(int i,int j)
	{Key temp = pq[i]; pq[i] = pq[j]; pq[j] = temp;}
	
	private void swim(int k)
	{
		while(k>1&&less(k/2,k))
		{
			exch(k/2,k);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while(2*k <= N)
		{
			int j = 2*k;
			if(j<N&&less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}
	}
	
	public Key min()
	{
		return min;
	}
	
	public static void main(String[] args)
	{
		MyMaxPQ<Integer> test = new MyMaxPQ<Integer>(10);
		test.insert(5);
		test.insert(8);
		test.insert(3);
		test.insert(0);
		test.insert(1);
		test.insert(2);
//		while(!test.isEmpty())
			System.out.print(test.min()+" ");

	}
}
