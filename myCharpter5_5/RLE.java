package myCharpter5_5;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.SET;

public class RLE {
	public static void compress() {
		String s = BinaryStdIn.readString();
		SET<Character> set = new SET<Character>();
		for(int i = 0;i<s.length();i++)
			set.add(s.charAt(i));
		String alphabet = "";
		for(char c : set) alphabet += c;
		BinaryStdOut.write(alphabet.length());
		BinaryStdOut.write(alphabet);
		Alphabet A = new Alphabet(alphabet);
		for(int i = 0;i<s.length();i++) {
			int d = A.toIndex(s.charAt(i));
			BinaryStdOut.write(d,A.lgR());
		}
		BinaryStdOut.close();
	}
	
	public static void expand() {
		int N = BinaryStdIn.readInt();
		String alphabet = "";
		for(int i = 0;i<N;i++) alphabet += (char)BinaryStdIn.readByte();
		Alphabet A = new Alphabet(alphabet);
		int w = A.lgR();
		for(int i = 0;i<N;i++) {
			char c = BinaryStdIn.readChar(w);
			BinaryStdOut.write(A.toChar(c));
		}
		BinaryStdOut.close();
	}
	
	
}
