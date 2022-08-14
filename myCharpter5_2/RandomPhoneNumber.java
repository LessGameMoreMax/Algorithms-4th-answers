package myCharpter5_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.TrieST;

public class RandomPhoneNumber {
	public static String[] randomPhoneNumberConduct(int N) {
		String[] result = new String[N];
		TrieST<Integer> T = new TrieST<Integer>();
		System.out.println("Please input the whiteList name:");
		String whiteListName = StdIn.readString();
		In in = new In(whiteListName);
		System.out.println("Loading......");
		StringSET whiteList = new StringSET();
		while(in.hasNextLine())
			whiteList.add(in.readString());
		int i = 0;
		while(i<N) {
			String number = "";
			for(int j = 0;j<3;j++)
				number += StdRandom.uniform(10);
			if(!whiteList.contains(number)) continue;
			number += "-";
			for(int j = 0;j<4;j++)
				number += StdRandom.uniform(10);
			if(T.contains(number)) continue;
			else {
				T.put(number, 1);
				result[i++] = number;
			}
		}
		return result;
	}
}
