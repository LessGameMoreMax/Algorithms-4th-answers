package myCharpter2_4;

public class MaxPQDynamicArray<Key extends Comparable<Key>> {
	private Key[] pq = (Key[])new Comparable[2];
	private int N = 0;
		
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{ return N;}
	
	public void insert(Key v)
	{
		if(N==pq.length-1) {
			Key[] temp = (Key[])new Comparable[2*pq.length];
			for(int i = 1;i<=N;i++)
				temp[i] = pq[i];
			pq = temp;
		}
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax()
	{
		if(N==0) return null;
		Key max = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		sink(1);
		if(N<pq.length/4) {
			Key[] temp = (Key[])new Comparable[pq.length/2];
			for(int i = 1;i<=N;i++)
				temp[i] = pq[i];
			pq = temp;
		}
		return max;
	}
	
	private boolean less(int i,int j)
	{ return pq[i].compareTo(pq[j])<0;}
	
	private void exch(int i,int j)
	{ Key temp = pq[i]; pq[i] = pq[j]; pq[j] = temp;}
	
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
		while(2*k<=N)
		{
			int j = 2 * k;
			if(j<N&&less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}
	}
	
	public static void main(String[] args)
	{
		MaxPQDynamicArray<Integer> test = new MaxPQDynamicArray<Integer>();
		test.insert(3);
		test.insert(7);
		test.insert(5);
		test.insert(4);
		test.insert(8);
		test.insert(3);
		test.insert(6);
		test.insert(8);
		test.insert(5);
		test.insert(1);
		test.insert(4);
		while(!test.isEmpty())
			System.out.print(test.delMax()+" ");
		test.insert(6);
		test.insert(8);
		test.insert(5);
		test.insert(1);
		test.insert(4);
		System.out.println();
		while(!test.isEmpty())
			System.out.print(test.delMax()+" ");
	}
}
