package myCharpter5_2;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.TST;

public class MonkeyTest {
	public static void main(String[] args) {
		System.out.println("Please input the p(p must low than 1/26!)");
		double p = StdIn.readDouble();
		System.out.println("How many numbers would you like to test?");
		int N = StdIn.readInt();
		System.out.println("Loading......");
		TST<Integer> T = new TST<Integer>();
		ST<Integer,Integer> st = new ST<Integer,Integer>();
		for(int i = 0;i<N;i++) {
			String s = "";
			int M = (int) (1.0/p);
			int R = StdRandom.uniform(0,M);
			while(R<26) {
				s += (char)(97+R);
				R = StdRandom.uniform(0,M);
			}
			if(s.length()<1||T.contains(s)) continue;
			else {
				T.put(s, 1);
				if(st.contains(s.length())) st.put(s.length(), st.get(s.length())+1);
				else						st.put(s.length(), 1);
			}
		}
		for(Integer key : st.keys())
			System.out.println(key + " length's frequency is : " + (double)st.get(key)/(double)T.size());
	}
}
