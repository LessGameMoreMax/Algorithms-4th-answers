package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Topological;

public class IsTopological {
	public static boolean isTopological(String s,Digraph G) {
		int count = 0;
		int j = 0;
		Topological t = new Topological(G);
		String[] str = s.split(" ");
		for(int i : t.order())
			count++;
		if(count!=str.length) return false;
		for(int i : t.order()) {
			if(Integer.parseInt(str[j])!=i) return false;
			j++;
		}
		return true;
	}
}
