package myCharpter2_4;

public class MaxPQNoExch<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	public MaxPQNoExch(int maxN)
	{ pq = (Key[]) new Comparable[maxN+1];}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{ return N;}
	
	public void insert(Key v)
	{
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax()
	{
		Key max = pq[1];
		pq[1] = pq[N];
		pq[N--] = max;
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	private boolean less(int i,int j)
	{ return pq[i].compareTo(pq[j])<0;}
	
	private void swim(int k)
	{
		while(k>1)
		{
			Key a = pq[k/2];
			if(a.compareTo(pq[k])<0) {
				pq[k/2] = pq[k];
				pq[k] = a;
				k = k/2;
			}else break;
			
		}
	}
	
	private void sink(int k)
	{
		while(2*k <= N)
		{
			int j = 2*k;
			if(j<N&&less(j,j+1)) j++;
			Key a = pq[k];
			if(!(a.compareTo(pq[j])<0)) break;
			pq[k] = pq[j];
			pq[j] = a;
			k = j;
		}
	}
	
	public static void main(String[] args)
	{
		MaxPQNoExch<Integer> test = new MaxPQNoExch<Integer>(10);
		test.insert(7);
		test.insert(4);
		test.insert(9);
		test.insert(2);
		test.insert(4);
		test.insert(5);
		while(!test.isEmpty())
			System.out.print(test.delMax()+" ");
	}
}
