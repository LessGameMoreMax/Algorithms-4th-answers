package myCharpter3_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class FullLookupCSV {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int keyField = Integer.parseInt(args[1]);
		int valRange = Integer.parseInt(args[2]);
		ST<String, String>[] st = new ST[valRange];
		
		while(in.hasNextLine()) {
			String line = in.readLine();
			String[] tokens = line.split(",");
			String key = tokens[keyField];
			for(int i = 0;i<valRange;i++) 
				st[i].put(key, tokens[keyField+i+1]);
		}
		
		while(!StdIn.isEmpty()) {
			String query = StdIn.readString();
			for(int i = 0;i<st.length;i++)
				if(st[i].contains(query))
					System.out.println(st[i].get(query));
		}
		
	}
}
