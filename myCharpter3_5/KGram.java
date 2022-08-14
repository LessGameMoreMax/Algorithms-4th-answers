package myCharpter3_5;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class KGram {
	public static void main(String[] args) {
		System.out.println("Please input a string:");
		String s = StdIn.readString();
		System.out.println("Please input the k:");
		int k = StdIn.readInt();
		ST<Integer,Character> st = new ST<Integer,Character>(); 
		for(int i = 1;i<=s.length();i++)
			st.put(i, s.charAt(i-1));
		
		for(int i = 1;i<=s.length() - k + 1;i++) {
			System.out.print(i+": ");
			for(int j = 0;j<k;j++)
				System.out.print(st.get(i+j));
			System.out.println();
		}
		
		System.out.println("That is all.");
	}
}
