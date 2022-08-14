package myCharpter6_3;

import edu.princeton.cs.algs4.Quick3way;
import edu.princeton.cs.algs4.StdIn;

public class BWT {
	public static String stringBWI(String s) {
		int N = s.length();
		String[] arr = LinearRotation.process(s);
		Quick3way.sort(arr);
		String str = "";
		for(int i = 0;i < arr.length; i++)
			str += arr[i].charAt(N-1);
		return str;
	}
	public static void main(String[] args) {
		System.out.println("Please input the string:");
		String s = StdIn.readString();
		System.out.println("Loading......");
		System.out.println(BWT.stringBWI(s));
	}
}
