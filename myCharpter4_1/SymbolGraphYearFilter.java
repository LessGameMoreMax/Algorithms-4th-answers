package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraphYearFilter {
	private ST<String,Integer> st;
	private String[] keys;
	private Graph G;
	
	public SymbolGraphYearFilter(String stream,String sp,int year) {
		st = new ST<String,Integer>();
		In in = new In(stream);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			String[] str = a[0].split(" ");
			int c =Integer.parseInt(str[str.length-1].substring(1,str[str.length-1].length()-1));
			if(c<=year) continue;
			
			for(int i = 0;i<a.length;i++)
				if(!st.contains(a[i]))
					st.put(a[i], st.size());
		}
		keys = new String[st.size()];
		for(String name : st.keys())
			keys[st.get(name)] = name;
		
		G = new Graph(st.size());
		in = new In(stream);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1;i<a.length;i++)
				G.addEdge(v, st.get(a[i]));
		}
	}
	
	public boolean contains(String s) { return st.contains(s);}
	public int index(String s) {return st.get(s);}
	public String name(int v) { return keys[v];}
	public Graph G() {return G;}
}
