package myCharpter2_4;

public class OrderArrayToPriorQueue<Key extends Comparable<Key>> {
	private Key[] pq = (Key[])new Comparable[1];
	
	private int N = 0;
	
	public boolean isEmpty()
	{return N==0;}
	
	public int size()
	{return N;}
	
	public void insert(Key v){
		pq[N++] = v;	
		for(int i = N-1;i>0&&less(i,i-1);i--)
			 exch(i,i-1);
		if(N==pq.length) {
			Key[] temp =(Key[])new Comparable[pq.length*2];
			for(int i = 0;i<N;i++)
				temp[i] = pq[i];
			pq = temp;
		}
	}
	
	public Key delMax() {
		if(N==0) return null;
		Key max = pq[--N];
		pq[N] = null;
		if(N<pq.length/4) {
			Key[] temp = (Key[])new Comparable[pq.length/2];
			for(int i = 0;i<N;i++)
				temp[i] = pq[i];
			pq = temp;
		}
		return max;
	}
	
	private boolean less(int i,int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i,int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	public static void main(String[] args) {
		OrderArrayToPriorQueue test = new OrderArrayToPriorQueue();
		test.insert(5);
		test.insert(4);
		test.insert(6);
		test.insert(2);
		test.insert(3);
		test.insert(6);
		test.insert(9);
		for(int i = 0;i<7;i++)
		System.out.println(test.delMax());
	}
}
