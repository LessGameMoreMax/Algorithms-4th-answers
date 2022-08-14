package myCharpter3_5;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;

public class NoOverlapCheck {
	public static void main(String[] args) {
		System.out.println("How many range would you like to input?");
		int N = StdIn.readInt()*2;
		RedBlackBST<Integer,Integer> st = new RedBlackBST<Integer,Integer>();
		System.out.println("Please input:");
		for(int i = 0;i<N;i++)
			st.put(StdIn.readInt(),1);
		System.out.println("Please input a number:");
		int num = StdIn.readInt();
		int ran = st.rank(num);
		int flag = ran % 2;
		if(flag!=0) System.out.println(num +" is in "+(ran/2+1)+" range.");
		else System.out.println("Sorry,it is null.");
	}
}
