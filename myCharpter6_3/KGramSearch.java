package myCharpter6_3;

import edu.princeton.cs.algs4.ST;

public class KGramSearch {
	private int k;
	private ST<String,Integer> st;
	public KGramSearch(String s,int k) {
		this.k = k;
		st = new ST<String,Integer>();
		for(int i = 0;i<=s.length()-k;i++) {
			String str = s.substring(i,i+k);
			if(st.contains(str))
				st.put(str, st.get(str)+1);
			else
				st.put(str, 1);
		}
	}
	
	public int getNumber(String s) {
		if(s.length()!=k||!st.contains(s)) return 0;
		return st.get(s);
	}
	
	public static void main(String[] args) {
		String s = "ahgfuiahgf";
		KGramSearch K = new KGramSearch(s,3);
		System.out.println(K.getNumber("ahg"));
	}
}
