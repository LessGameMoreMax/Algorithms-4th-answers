package myCharpter5_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.TST;

public class SpecialChildString {
	public static void main(String[] args) {
		System.out.println("Please input the string:");
		String input = StdIn.readString();
		System.out.println("Please input the L:");
		int L = StdIn.readInt();
		TST<Integer> T = new TST<Integer>();
		for(int i = 0;i<=input.length()-L;i++)
			T.put(input.substring(i, i+L), 1);
		System.out.println("So,the number is :"+T.size());
	}
}
