package myCharpter2_4;

public class MaxPQWithoutBoundaryCheck<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	public MaxPQWithoutBoundaryCheck(int maxN)
	{ pq = (Key[]) new Comparable[maxN+1];}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{return N;}
	
	public void insert(Key v)
	{
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax()
	{
		Key max = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	private boolean less(int i,int j)
	{return pq[i].compareTo(pq[j])<0;}
	
	private void exch(int i,int j)
	{Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;}
	
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
		while(2*k<N)
		{
			int j = 2*k;
			if(less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}
		if(N==2*k&&less(k,k*2)) exch(k,k*2);
	}
	
	public static void main(String[] args)
	{
		MaxPQWithoutBoundaryCheck<Integer> test = new MaxPQWithoutBoundaryCheck<Integer>(10);
		test.insert(6);
		test.insert(4);
		test.insert(0);
		test.insert(5);
		test.insert(2);
		while(!test.isEmpty()) 
			System.out.print(test.delMax()+" ");
	}
	
	
}
