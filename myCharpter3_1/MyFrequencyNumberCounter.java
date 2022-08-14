package myCharpter3_1;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdRandom;

public class MyFrequencyNumberCounter {
	public static void main(String[] args) {
		for(int N = 10;N<=10e6;N*=10) {
			int count = 0;
			BinarySearchST<Integer,Integer> st = new BinarySearchST<Integer,Integer>();
			for(int i = 0;i<N;i++) {
				int number = StdRandom.uniform(N);
				if(!st.contains(number)){
					st.put(number, 1); 
					count++;
				}
			}
			System.out.println("For"+N+":"+count);
		}
		 
	}
}
