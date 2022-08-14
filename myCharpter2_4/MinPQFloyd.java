package myCharpter2_4;

public class MinPQFloyd<Key extends Comparable<Key>>{
	private Key[] pq;
	private int N=0;
	
	public MinPQFloyd(int maxN)
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
		Key temp = pq[N--];
		pq[N+1] = null;
		int k = 1;
		while(k*2+1<=N)
			if(less(k*2,k*2+1)) {pq[k] = pq[k*2]; k = k*2;}
			else                {pq[k] = pq[k*2+1]; k = k*2+1;}
		pq[k]=temp;
		sink(k);
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
	
	public static void main(String[] args)
	{
		MinPQFloyd<Integer> test = new MinPQFloyd(10);
		test.insert(4);
		test.insert(4);
		test.insert(3);
		test.insert(8);
		test.insert(3);
		test.insert(8);
		test.insert(0);
		test.insert(9);
		test.insert(2);
		test.insert(1);
		while(!test.isEmpty())
			System.out.print(test.delMin()+" ");
	}
}
