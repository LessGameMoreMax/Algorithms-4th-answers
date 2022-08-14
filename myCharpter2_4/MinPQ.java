package myCharpter2_4;

public class MinPQ<Key extends Comparable<Key>>{
	private Key[] pq;
	private int N=0;
	
	public MinPQ(int maxN)
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
	
	public static boolean isMinQueue(int[] arr)
	{
		for(int i = 1;i*2<=arr.length-1;i++)
		{
			if(arr[2*i]<arr[i]) return false;
			if(i*2==arr.length-1) break;
			if(arr[2*i+1]<arr[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		MinPQ<Integer> test = new MinPQ<Integer>(10);
		test.insert(7);
		test.insert(4);
		test.insert(9);
		test.insert(2);
		test.insert(4);
		test.insert(5);
		while(!test.isEmpty())
			System.out.print(test.delMin()+" ");

//		int[] arr = { 1,5,0};
//		System.out.print(isMinQueue(arr));
	}
}
