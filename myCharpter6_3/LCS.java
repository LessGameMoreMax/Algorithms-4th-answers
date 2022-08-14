package myCharpter6_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LCS {
	public static String lcs(String s,String t) {
		String str = s + "#" + t;
		int N = str.length();
		SuffixArray sa = new SuffixArray(str);
		String lrs = "";
		for(int i = 1;i<N;i++) {
			int length = sa.lcp(i);
			if(length > lrs.length())
				lrs = sa.select(i).substring(0,length);
		}
		return lrs;
	}
	
	public static void main(String[] args) {
		StdOut.println("Please input the first string:");
		String a = StdIn.readString();
		StdOut.println("Please input the second string:");
		String b = StdIn.readString();
		String s = lcs(a,b);
		StdOut.println(s);
	}
}
