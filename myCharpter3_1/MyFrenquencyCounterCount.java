package myCharpter3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class MyFrenquencyCounterCount {
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		ST<String,Integer> st = new ST<String,Integer>();
		In in = new In(args[1]);
		int number = 0;
		int num = 0;
		String str = null;
		while(!in.isEmpty()) {
			number++;
			String word = in.readString();
			if(word.length()<minlen) continue;
			if(!st.contains(word)) {st.put(word, 1); num = number; str = word;}
			else				   st.put(word, st.get(word)+1);
		}
		
		String max = " ";
		st.put(max, 0);
		for(String word : st.keys())
			if(st.get(word)>st.get(max))
				max = word;
		
		StdOut.println(max+" "+st.get(max));
		StdOut.println("Final insertion is : "+str);
		StdOut.println("Before "+str+" process : "+num);
	}
}

