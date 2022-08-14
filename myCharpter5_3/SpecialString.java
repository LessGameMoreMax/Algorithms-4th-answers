package myCharpter5_3;

import edu.princeton.cs.algs4.SET;

public class SpecialString {
	private long Q;
	private int R = 256;
	
	private long hash(String key,int begin,int end) {
		long h = 0;
		for(int j = begin;j<=end;j++)
			h = (R*h + key.charAt(j)) % Q;
		return h;
	}
	
	public SpecialString() {
		this.Q = 997;
	}
	
	public int search(String txt,int L) {
		SET<Long> set = new SET<Long>();
		int N = txt.length();
		for(int i = 0;i<N-L;i++) {
			long txtHash = hash(txt,i,i+L-1);
			if(!set.contains(txtHash)) set.add(txtHash);
		}
		return set.size();
 	}
	
	public static void main(String[] args) {
		SpecialString S = new SpecialString();
		System.out.println(S.search("cgcgggcgcg", 3));
	}
}
