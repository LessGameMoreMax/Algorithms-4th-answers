package myCharpter3_5;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class InvertedConcordance {
	public static void main(String[] args) {
		System.out.println("How many lines would you like to input?");
		int N = StdIn.readInt();
		String[] s = new String[N];
		System.out.println("Please input "+(N-1)+" lines:");
		for(int i = 0;i<N;i++)
			s[i] = StdIn.readLine();
		System.out.println("Loading......");
		ST<Integer,String> st = new ST<Integer,String>();
		for(int i = 0;i<N;i++) {
			String[] str = s[i].split(" ");
			for(int j = 1;j<str.length;j++)
				st.put(Integer.parseInt(str[j]), str[0]);
		}
		for(Integer num : st.keys())
			System.out.print(" "+st.get(num)+" ");
	}
}
