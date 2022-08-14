package myCharpter3_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;

public class RangeLookupCSV {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int keyField = Integer.parseInt(args[1]);
		int valField = Integer.parseInt(args[2]);
		RedBlackBST<String,String> st = new RedBlackBST<String,String>();
		while(in.hasNextLine()) {
			String line = in.readLine();
			String[] tokens = line.split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			st.put(key, val);
		}
		
		while(!StdIn.isEmpty()) {
			System.out.println("Please input your first board:");
			String board1 = StdIn.readString();
			System.out.println("Please input your second board:");
			String board2 = StdIn.readString();
			System.out.println("Loading......");
			String min = board1.compareTo(board2)<0 ? board1 : board2;
			String max = board1.compareTo(board2)<0 ? board2 : board1;
			for(String s :st.keys(min, max))
				System.out.println(s);
		}
	}
}
