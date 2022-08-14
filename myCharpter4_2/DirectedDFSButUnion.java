package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;

public class DirectedDFSButUnion {
	private boolean[] marked;
	private int count;
	private int[] id;
	private ST<Integer,Queue<Integer>> union;
	public DirectedDFSButUnion(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int s = 0;s<G.V();s++)
			if(!marked[s]) {
				dfs(G,s);
				count++;
			}
		union = (ST<Integer,Queue<Integer>>) new ST();
		for(int v = 0;v<count;v++)
			union.put(v, new Queue<Integer>());
		for(int v = 0;v<id.length;v++)
			union.get(id[v]).enqueue(v);
	}
	private void dfs(Digraph G,int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	public ST<Integer,Queue<Integer>> CC(){
		return union;
	}
}
