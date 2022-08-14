package myCharpter5_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class SpellChecker {
	public static void main(String[] args) {
		In in = new In(args[0]);
		StringSET set = new StringSET();
		while(in.hasNextLine())
			set.add(in.readString());
		System.out.println("Please input your string:");
		String s = StdIn.readString();
		System.out.println("Loading......");
		String[] words = s.split("\\s+");
		for(int i = 0;i < words.length;i++)
			if(!set.contains(words[i]))
				System.out.println(words[i]);
	}
}
