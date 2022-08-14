package myCharpter5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.TST;

public class MyLZW {
	private static final int R = 256;
	private static final int L = 4096;
	private static final int W = 12;
	
	public static void compress() {
		String input = BinaryStdIn.readString();
		TST<Integer> st = new TST<Integer>();
		
		for(int i = 0;i<R;i++)
			st.put("" + (char) i, i);
		int code = R+1;
		
		while(input.length()>0) {
			String s = st.longestPrefixOf(input);
			BinaryStdOut.write(st.get(s),W);
			
			int t = s.length();
			if(t < input.length()) {
				st.put(input.substring(0,t+1), code++);
				if(code==L) {
					st = new TST<Integer>();
					for(int i = 0;i<R;i++)
						st.put("" + (char) i, i);
					code = R+1;
				}
			}
			input = input.substring(t);
		}
		BinaryStdOut.write(R,W);
		BinaryStdOut.close();
	}
	
	public static void expand() {
		String[] st = new String[L];
		int i;
		
		for(i = 0;i<R;i++)
			st[i] = "" + (char) i;
		st[i++] = " ";
		
		int codeword = BinaryStdIn.readInt(W);
		String val = st[codeword];
		while(true) {
			BinaryStdOut.write(val);
			codeword = BinaryStdIn.readInt(W);
			if(codeword == R) break;
			String s = st[codeword];
			if(i == codeword) s = val + val.charAt(0);
			if(i>=L) {
				st = new String[L];
				for(i = 0;i<R;i++)
					st[i] = "" + (char) i;
				st[i++] = " ";
			}
			st[i++] = val + s.charAt(0);
			val = s;
		}
	}
}
