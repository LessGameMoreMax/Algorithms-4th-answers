package myCharpter6_3;

import edu.princeton.cs.algs4.Quick3way;

public class SuffixArray {
	private final String[] suffixes;
	private final int N;
	
	public SuffixArray(String s) {
		N = s.length();
		suffixes = new String[N];
		for(int i = 0;i < N; i++)
			suffixes[i] = s.substring(i);
		Quick3way.sort(suffixes);
	}
	
	public int length() { return N;}
	public String select(int i) { return suffixes[i];}
	public int index(int i) { return N - suffixes[i].length();}
	
	public int lcp(int i)
	{ return lcp(suffixes[i],suffixes[i-1]);}
	
	private int lcp(String s,String t) {
		int N = Math.min(s.length(), t.length());
		for(int i = 0;i<N;i++)
			if(s.charAt(i)!=t.charAt(i)) return i;
		return N;
	}
	
	public int rank(String key) {
		int lo = 0;
		int hi = N - 1;
		while(lo<=hi) {
			int mid = lo + (hi - lo)/2;
			int cmp = key.compareTo(suffixes[mid]);
			if(cmp<0) hi = mid - 1;
			else if(cmp>0) lo = mid + 1;
			else 	 return mid;
		}
		return lo;
	}
}
