package myCharpter3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounterTwoTable {
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		ST<String,Integer> st = new ST<String,Integer>();
		In in = new In(args[1]);
		while(!in.isEmpty()) {
			String word = in.readString();
			if(word.length()<minlen) continue;
			if(!st.contains(word)) 		  st.put(word, 1);
			else				 		  st.put(word, st.get(word)+1);
		}
		System.out.println("As a dictionary:");
		for(String word:st.keys())
		StdOut.println(word+":"+st.get(word));
		
		MaxPQ<WordAndNumber> pq = new MaxPQ<WordAndNumber>();
		
		for(String word:st.keys()) {
			WordAndNumber temp = new WordAndNumber(word,st.get(word));
			pq.insert(temp);
		}
		System.out.println("As numbers:");
		while(!pq.isEmpty()) System.out.println(pq.delMax());
	}
}
