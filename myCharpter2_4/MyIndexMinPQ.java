package myCharpter2_4;

public class MyIndexMinPQ <Key extends Comparable<Key>>{
	private int[] pq;
	private Key[] keys;
	private int[] qp;
	private int N = 0;
	
	public MyIndexMinPQ(int maxN)
	{
		pq = new int[maxN+1];
		qp = new int[maxN+1];
		keys = (Key[])new Comparable[maxN+1];
		for(int i = 0;i <= maxN;i++)
			qp[i] = -1;
	}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public boolean contains(int k)
	{ return qp[k] != -1;}
	
	public void insert(int k,Key key)
	{
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}
	
	public Key min()
	{ return keys[pq[1]];}
	
	public int delMin()
	{
		int indexOfMin = pq[1];
		exch(1,N--);
		sink(1);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
		return indexOfMin;
	}
	
	public void change(int k,Key key)
	{
		if(!this.contains(k)) this.insert(k,key);
		else                  {
			keys[k] = key;
			swim(qp[k]);
			sink(qp[k]);
		}
	}
	
	public int minIndex()
	{return pq[1];}
	
	public void delete(int k)
	{
		if(!this.contains(k)) throw new RuntimeException("Sorry,index k do not exist!");
		exch(qp[k],N--);
		sink(qp[k]);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
	}
	
//	public Key indexKey(int index)
//	{ return keys[index];}
	
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
	
	private boolean less(int v,int w)
	{ return keys[pq[v]].compareTo(keys[pq[w]])>0;}
	
	private void exch(int i,int j)
	{
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		
		temp = qp[pq[i]];
		qp[pq[i]] = qp[pq[j]];
		qp[pq[j]] = temp;
	}
	
	public static void main(String[] args)
	{
		MyIndexMinPQ<Integer> test = new MyIndexMinPQ<Integer>(10);
		test.insert(3, 3);
		test.insert(2, 7);
		test.insert(1, 4);
		test.insert(4, 8);
		test.insert(5, 9);
		test.insert(6, 2);
		test.insert(7, 1);
		test.delete(1);
		test.delete(2);
		test.delete(3);
		while(!test.isEmpty()) {
			System.out.print(test.delMin()+" ");
		}
	}
	
		
}
