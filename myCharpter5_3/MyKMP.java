package myCharpter5_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class MyKMP {
	private String pat;
	private int[][] dfa;
	public MyKMP(String pat) {
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for(int X = 0,j = 1;j<M;j++) {
			for(int c = 0;c<R;c++)
				dfa[c][j] = dfa[c][X];
			dfa[pat.charAt(j)][j] = j + 1;
			X = dfa[pat.charAt(j)][X];
		}
	}
	
	public int search(String txt) {
		int i,j,N = txt.length(),M = pat.length();
		for(i = 0,j = 0;i<N&&j<M;i++)
			j = dfa[txt.charAt(i)][j];
		if(j==M) return i - M;
		else 	 return N;
	}
	
	public int search(In in) {
		String txt = "";
		while(in.hasNextLine()) txt += in.readString();
		int i,j,N = txt.length(),M = pat.length();
		for(i = 0,j = 0;i<N&&j<M;i++)
			j = dfa[txt.charAt(i)][j];
		if(j==M) return i - M;
		else 	 return N;
	}
	
	public int count(String txt) {
		int count = 0;
		int i,j,N = txt.length(),M = pat.length();
		i = 0;
		while(i<N) {
			for(j = 0;i<N&&j<M;i++) 
				j = dfa[txt.charAt(i)][j];
			if(j==M) count++;	
		}
		return count;
	}
	
	public Iterable<Integer> searchAll(String txt) {
		Queue<Integer> q = new Queue<Integer>();
		int i,j,N = txt.length(),M = pat.length();
		i = 0;
		while(i<N) {
			for(j = 0;i<N&&j<M;i++) 
				j = dfa[txt.charAt(i)][j];
			if(j==M) q.enqueue(i-M);	
		}
		return q;
	}
	
	public static void main(String[] args) {
		MyKMP K = new MyKMP("ab");
		for(Integer i : K.searchAll("ababhefgabababauefguie"))
		System.out.println(i);
	}
	
}
