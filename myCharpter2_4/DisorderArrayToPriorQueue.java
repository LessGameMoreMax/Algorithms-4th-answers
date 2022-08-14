package myCharpter2_4;

public class DisorderArrayToPriorQueue<Key extends Comparable<Key>> {
	private Key[] pq = (Key[])new Comparable[1];
	
	private int N = 0;
	
	public boolean isEmpty()
	{return N==0;}
	
	public int size()
	{return N;}
	
	public void insert(Key v){
		pq[N++] = v;	
		if(N==pq.length) {
			Key[] temp =(Key[])new Comparable[pq.length*2];
			for(int i = 0;i<N;i++)
				temp[i] = pq[i];
			pq = temp;
		}
	}
	
	public Key delMax() {
		if(N==0) return null;
		if(N==1) {
			Key max = pq[0];
			pq[0] = null;
			return max;
		}
		int flag = 0;
		for(int i = 1;i<N;i++)
			if(less(flag,i)) flag = i;
		exch(flag,--N);
		Key max = pq[N];
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
		DisorderArrayToPriorQueue test = new DisorderArrayToPriorQueue();
		test.insert(5);
		test.insert(4);
		test.insert(6);
		test.insert(2);
		test.insert(3);
		for(int i = 0;i<5;i++)
		System.out.println(test.delMax());
	}
	
	
}
