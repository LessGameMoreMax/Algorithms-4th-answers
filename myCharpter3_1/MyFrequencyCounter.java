package myCharpter3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class MyFrequencyCounter {
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		ST<String,Integer> st = new ST<String,Integer>();
		In in = new In(args[1]);
		while(!in.isEmpty()) {
			String word = in.readString();
			if(word.length()<minlen) continue;
			if(!st.contains(word)) st.put(word, 1);
			else				   st.put(word, st.get(word)+1);
		}
		Queue<String> ask = new Queue<String>();
		String max = " ";
		st.put(max, 0);
		for(String word : st.keys())
			if(st.get(word)>st.get(max)) {
				max = word;
				while(!ask.isEmpty()) ask.dequeue();
				ask.enqueue(max);
			}
			else if(st.get(word).equals(st.get(max))) ask.enqueue(word);
		while(!ask.isEmpty())
		StdOut.println(ask.dequeue()+" "+st.get(max));
	}
}
