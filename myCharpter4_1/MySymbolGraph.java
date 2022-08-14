package myCharpter4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SET;

public class MySymbolGraph {
	private RedBlackBST<String,SET<String>> adj;
	public MySymbolGraph(String steam,String sp) {
		In in = new In(steam);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			String v = a[0];
			for(int i = 1;i<a.length;i++) {
				if(!adj.contains(v))
					adj.put(v, new SET<String>());
				adj.get(v).add(a[i]);
			}
		}
	}
	public boolean contains(String s) {
		return adj.contains(s);
	}
}
