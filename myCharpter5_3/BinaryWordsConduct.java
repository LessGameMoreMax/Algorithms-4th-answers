package myCharpter5_3;

import edu.princeton.cs.algs4.StdRandom;

public class BinaryWordsConduct {
	public static String conduct(int N) {
		String s = "";
		for(int i = 0;i<N;i++)
			s += StdRandom.uniform(2);
		return s;
	}
	
	public static int search(int M,String s) {
		String str = s.substring(s.length()-M-1,s.length()-1);
		Brute B = new Brute(str);
		return B.search(s);
	}
}
