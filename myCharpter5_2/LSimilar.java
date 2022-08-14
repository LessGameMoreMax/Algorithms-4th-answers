package myCharpter5_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.TST;

public class LSimilar {
	public static double[] frequencyVector(In in) {
		TST<Integer> T = new TST<Integer>();
		int N = 0;
		while(in.hasNextLine()) {
			String input = in.readLine();
			for(int i = 0;i<=input.length()-3;i++) {
				N++;
				if(!T.contains(input.substring(i, i+3)))
					T.put(input.substring(i, i+3), 1);
				else
					T.put(input.substring(i, i+3), T.get(input.substring(i, i+3)+1));
			}
		}
		double[] arr = new double[T.size()];
		int index = 0;
		for(String key : T.keys())
			arr[index++] = (double) T.get(key) / (double) N;
		return arr;
	}
	
	public static double EulerDis(double[] a,double[] b) {
		double dis = 0;
		for(int i = 0;i<Math.max(a.length, b.length);i++) {
			if(i>=a.length) 	 dis += b[i] * b[i];
			else if(i>=b.length) dis += a[i] * a[i];
			else				 dis += (a[i]-b[i])*(a[i]-b[i]);
		}
		return Math.sqrt(dis);
	}
	
	public static void main(String[] args) {
		System.out.println("How many words would you like to input?");
		int L = StdIn.readInt();
		if(L<=1) throw new RuntimeException("L must more than one!");
		String[] steam = new String[L];
		for(int i = 0;i<L;i++) {
			System.out.printf("Please input %d word :",i+1);
			steam[i] = StdIn.readString();
		}
		System.out.println("Loading......");
		TST<double[]> T = new TST<double[]>();
		for(int i = 0;i<steam.length;i++)
			T.put(steam[i],frequencyVector(new In(steam[i])));
		for(int i = 0;i<steam.length-1;i++)
			for(int j = i+1;j<steam.length;j++)
				System.out.println(steam[i] +" and " +steam[j] + " : "+ EulerDis(T.get(steam[i]),T.get(steam[j])));
	}
}
