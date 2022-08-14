package myCharpter5_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;

public class LinearSameSearch {
	public static int search(String txt,String pat) {
		int M = pat.length();
		MyKMP K = new MyKMP(pat);
		ST<Integer,Integer> st = new ST<Integer,Integer>();
		Queue<Integer> q = new Queue<Integer>();
		for(Integer i : K.searchAll(txt)) q.enqueue(i);
		if(q.isEmpty()) return -1;
		int first = q.dequeue();
		int count = 1;
		while(!q.isEmpty()) {
			int second = q.dequeue();
			if((second-first)== count * M) count++;
			else						   {st.put(count, first); first = second; count = 1;}
		}
		st.put(count, first);
		return st.get(st.max());
	}
	
	public static void main(String[] args) {
		String txt = "afefefaaaaahuvbsaaaa";
		String pat = "aaa";
		System.out.println(search(txt,pat));
	}
}
