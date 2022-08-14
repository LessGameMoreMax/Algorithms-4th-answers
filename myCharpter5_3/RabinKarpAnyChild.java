package myCharpter5_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdRandom;

public class RabinKarpAnyChild {
	private int M;
	private long Q;
	private int R = 256;
	private long RM;
	private SET<Long> set;
	
	public RabinKarpAnyChild(Queue<String> q) {
		set = new SET<Long>();
		while(!q.isEmpty()) {
			String pat = q.dequeue();
			this.M = pat.length();
			Q = longRandomPrime();
			RM = 1;
			for(int i = 1;i<=M-1;i++)
				RM = (R*RM)%Q;
			set.add(hash(pat,M));
		}
	}
	
	private long hash(String key,int M) {
		long h = 0;
		for(int j = 0;j<M;j++)
			h = (R*h + key.charAt(j)) % Q;
		return h;
	}
	
	public int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(set.contains(txtHash)) return 0;
		for(int i = M;i<N;i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i-M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if(set.contains(txtHash)) return i - M + 1;
		}
		return N;
 	}
	
	private long longRandomPrime() {
		double number = StdRandom.random();
		long prime = (long)(number * 10E20);
		while(!isPrime(prime)) {
			number = StdRandom.random();
			prime = (long)(number * 10E20);
		}
		return prime;
	}
	
	private boolean isPrime(long num) {
		for(long i = 2;i<Math.sqrt(num);i++)
			if(num%i==0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		q.enqueue("abc");
		q.enqueue("bac");
		q.enqueue("cba");
		RabinKarpAnyChild R = new RabinKarpAnyChild(q);
		System.out.println(R.search("ugcbahfaytcvhjbacvbjagfty"));
	}
}
