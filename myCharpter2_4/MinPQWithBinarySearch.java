package myCharpter2_4;

public class MinPQWithBinarySearch <Key extends Comparable<Key>>{
	private Key[] pq;
	private int N=0;
	
	public MinPQWithBinarySearch(int maxN)
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
		if(k==1) return;
		
		int deepth = (int)(Math.log(N)/Math.log(2)) + 2;
		int[] way = new int[deepth];
		int temp = k;
		for(deepth = 0; temp >= 1; deepth++)
		{
			way[deepth] = temp;
			temp=temp / 2;
		}
		int lo = 1;
		int hi = deepth-1;
		while(lo<=hi)
		{
			int mid = lo + (hi-lo)/2;
			if(less(way[mid],k)) 		hi = mid - 1;
			else						lo = mid + 1;
		}
		
		for(int i = 1;i<lo;i++)
			exch(way[i],way[i-1]);
		
//		while(k>1&&less(k,k/2)) 
//		{
//			exch(k,k/2);
//			k = k/2;
//		}
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
	
	public static void main(String[] args)
	{
		MinPQWithBinarySearch<Integer> test = new MinPQWithBinarySearch<Integer>(10);
		test.insert(7);
		test.insert(4);
		test.insert(6);
		test.insert(3);
		test.insert(2);
		test.insert(9);
		test.insert(6);
		while(!test.isEmpty())
			System.out.print(test.delMin()+" ");
	}
}
