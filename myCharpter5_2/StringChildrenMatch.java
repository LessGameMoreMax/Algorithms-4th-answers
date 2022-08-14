package myCharpter5_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.TST;

public class StringChildrenMatch {
	public static TST<Integer> childrenString(String s){
		TST<Integer> T = new TST<Integer>();
		for(int i = 0;i<s.length();i++)
			for(int j = i + 1;j<=s.length();j++)
				T.put(s.substring(i,j), 1);
		return T;
	}
	
	public static void main(String[] args) {
		System.out.println("How many strings would you like to input?");
		int N = StdIn.readInt();
		String[] input = new String[N];
		TST<Integer>[] T = (TST<Integer>[])new TST[N];
		System.out.println("Please input:");
		for(int i = 0;i<N;i++) {
			input[i] = StdIn.readString();
			T[i] = childrenString(input[i]);
		}
		System.out.println("Now input your pre:");
		String pre = StdIn.readString();
		System.out.println("Loading......");
		for(int i = 0;i<N;i++)
			if(T[i].contains(pre)) System.out.println(input[i]);
	}
}
