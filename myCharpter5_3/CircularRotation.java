package myCharpter5_3;

import edu.princeton.cs.algs4.KMP;

public class CircularRotation {
	public static boolean isCircularRotation(String first,String second) {
		String firstDouble = first + first;
		KMP K = new KMP(second);
		return K.search(firstDouble)!= firstDouble.length();
	}
	
	public static void main(String[] args) {
		if(isCircularRotation("example","ampleex"))
			System.out.println(1);
		else 
			System.out.println(2);
	}
}
