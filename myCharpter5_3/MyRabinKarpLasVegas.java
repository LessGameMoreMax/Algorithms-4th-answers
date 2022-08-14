package myCharpter5_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class MyRabinKarpLasVegas {
	private String pat;
	private long patHash;
	private int M;
	private long Q;
	private int R = 256;
	private long RM;
	
	public MyRabinKarpLasVegas(String pat) {
		this.pat = pat;
		this.M = pat.length();
		Q = 1997;
		RM = 1;
		for(int i = 1;i<=M-1;i++)
			RM = (R*RM)%Q;
		patHash = hash(pat,M);
	}
	
	private boolean check(String txt,int i)
	{ 
		for(int j = 0;j<M;j++)
			if(txt.charAt(i+j)!=pat.charAt(j)) return false;
		return true;
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
		if(patHash == txtHash && check(txt,0)) return 0;
		for(int i = M;i<N;i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i-M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if(patHash == txtHash)
				if(check(txt,i-M+1)) return i - M + 1;
		}
		return N;
 	}
	
	public static void main(String[] args) {
		MyRabinKarpLasVegas R = new MyRabinKarpLasVegas("ab");
		System.out.println(R.search("bbabaabab"));
	}
}
