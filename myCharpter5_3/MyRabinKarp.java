package myCharpter5_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class MyRabinKarp {
	private long patHash;
	private int M;
	private long Q;
	private int R = 256;
	private long RM;
	
	public MyRabinKarp(String pat) {
		this.M = pat.length();
		Q = longRandomPrime();
		RM = 1;
		for(int i = 1;i<=M-1;i++)
			RM = (R*RM)%Q;
		patHash = hash(pat,M);
	}
	
	private boolean check(int i)
	{ return true;}
	
	private long hash(String key,int M) {
		long h = 0;
		for(int j = 0;j<M;j++)
			h = (R*h + key.charAt(j)) % Q;
		return h;
	}
	
	public int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash == txtHash && check(0)) return 0;
		for(int i = M;i<N;i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i-M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if(patHash == txtHash)
				if(check(i-M+1)) return i - M + 1;
		}
		return N;
 	}
	
	public int search(In in) {
		String txt = "";
		while(in.hasNextLine()) txt += in.readString();
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash == txtHash && check(0)) return 0;
		for(int i = M;i<N;i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i-M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if(patHash == txtHash)
				if(check(i-M+1)) return i - M + 1;
		}
		return N;
 	}

	
	public int count(String txt) {
		int count = 0;
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash == txtHash && check(0)) count++;
		for(int i = M;i<N;i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i-M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if(patHash == txtHash)
				if(check(i-M+1)) count++;
		}
		return count;
 	}
	
	public Iterable<Integer> searchAll(String txt) {
		Queue<Integer> q = new Queue<Integer>();
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash == txtHash && check(0)) q.enqueue(0);;
		for(int i = M;i<N;i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i-M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if(patHash == txtHash)
				if(check(i-M+1)) q.enqueue(i-M+1);;
		}
		return q;
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
		MyRabinKarp R = new MyRabinKarp("aaa");
//		for(Integer i : R.searchAll("ahjgvavab"))
			System.out.println(R.search("aaaa"));
	}
}
