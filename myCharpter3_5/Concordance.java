package myCharpter3_5;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Concordance {
	public static void main(String[] args) {
		System.out.println("How many Strings would you like to input?");
		int N = StdIn.readInt();
		String[] s = new String[N];
		System.out.println("Please input strings:");
		for(int i = 0;i<N;i++)
			s[i] = StdIn.readString();
		System.out.println("Loading......");
		BSTWithSameKey<String,Integer> st = new BSTWithSameKey<String,Integer>();
		for(int i = 0;i<s.length;i++)
			st.put(s[i],i+1);
		System.out.println("Now it is:");
		for(String key : st.keys()) {
			System.out.print(key+":");
			Iterator t = st.getAll(key);
			while(t.hasNext())
				System.out.print(" "+t.next()+" ");
			System.out.println();
		}
			
			
	}
}
