package myCharpter3_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupCSVPro {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int keyField = Integer.parseInt(args[1]);
		int valField = Integer.parseInt(args[1]);
		BSTWithSameKey<String,String> st = new BSTWithSameKey<String,String>();
		
		while(in.hasNextLine()) {
			String line = in.readLine();
			String[] tokens = line.split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			st.put(key, val);
		}
		
		while(!StdIn.isEmpty()) {
			String query = StdIn.readString();
			if(st.get(query)!=null)
				StdOut.println(st.get(query));
		}
	}
}
