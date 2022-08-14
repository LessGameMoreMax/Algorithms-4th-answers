package myCharpter6_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Quick3way;
import edu.princeton.cs.algs4.SET;

public class KTimes {
	private final String[] suffixes;
	private final int L;
	private final int k;
	private String result;
	
	public KTimes(String s,int k) {
		this.k = k;
		L = s.length();
		suffixes = new String[L];
		for(int i = 0;i < L; i++)
			suffixes[i] = s.substring(i);
		Quick3way.sort(suffixes);
		result = process(suffixes);
	}
	
	private String process(String[] s) {
		String str = "";
		for(int i = 0;i<=L-k;i++) {
			MinPQ<Integer> pq = new MinPQ<Integer>();
			for(int j = 0;j<k;j++) pq.insert(s[i].length());
			int N = pq.delMin();
			String temp = "";
			for(int m = 0;m<N;m++) {
				int t;
				for(t = 0;t<k-1;t++)
					if(s[i+t].charAt(m)!=s[i+t+1].charAt(m)) break;
				if(t!=k-1) break;
				temp += s[i].charAt(m);
			}
			if(str.length()<temp.length()) str = temp;
		}
		return str;
	}
	
	public String getString()
	{ return result;}
	
	public static void main(String[] args) {
		String s = "abehfgabhfgdtabhfab";
		KTimes K = new KTimes(s,3);
		System.out.println(K.getString());
	}
}

