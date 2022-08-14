package myCharpter3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TempFrequencyCounter {
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		TempSequentialSearchST<String,Integer> st = new TempSequentialSearchST<String,Integer>();
		In in = new In(args[1]);
		while(!in.isEmpty()) {
			String word = in.readString();
			if(word.length()<minlen) continue;
			Integer temp = st.get(word);
			if(temp==null) 		  st.put(word, 1);
			else				  st.put(word, temp+1);
		}
		String max = " ";
		st.put(max, 0);
		for(String word:st.keys())
			if(st.get(word)>st.get(max))
				max = word;
		StdOut.println(max+" "+st.get(max));
	}
}
