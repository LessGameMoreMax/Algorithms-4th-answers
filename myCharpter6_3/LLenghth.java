package myCharpter6_3;

import edu.princeton.cs.algs4.Quick3way;

public class LLenghth {
	private final String[] suffixes;
	private final int N;
	private final int L;
	private String result;
	
	public LLenghth(String s,int L) {
		this.L = L;
		N = s.length();
		suffixes = new String[N];
		for(int i = 0;i < N; i++)
			suffixes[i] = s.substring(i);
		Quick3way.sort(suffixes);
		result = process(suffixes);
	}
	
	private String process(String[] s) {
		String str = "";
		for(int i = 1;i<N;i++) {
			int N = Math.min(s[i].length(), s[i-1].length());
			if(N<L) continue;
			String temp = "";
			int m;
			for(m = 0;m<N;m++)
				if(s[i].charAt(m)!=s[i-1].charAt(m)) break;
				else 	temp += s[i].charAt(m);
			if(m<L) continue;
			if(str.length()<temp.length()) str = temp;
		}
		return str;
	}
	
	public String getString()
	{ return result;}
	
	public static void main(String[] args) {
		String s = "abcdyyabcd";
		LLenghth K = new LLenghth(s,3);
		System.out.println(K.getString());
	}
}
