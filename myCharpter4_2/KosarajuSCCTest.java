package myCharpter4_2;

import edu.princeton.cs.algs4.DepthFirstOrder;
import edu.princeton.cs.algs4.Digraph;

public class KosarajuSCCTest {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public KosarajuSCCTest(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost()) 
			if(!marked[s]) {
				dfs(G,s);
				count++;
			}
	}
	
	private void dfs(Digraph G,int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	
	public boolean stronglyConnected(int v,int w) {
		return id[v]==id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		Digraph G = new Digraph(4);
		G.addEdge(0, 3);
		G.addEdge(0, 1);
		G.addEdge(1, 2);
		KosarajuSCCTest K = new KosarajuSCCTest(G);
		System.out.println(K.id(0));
		System.out.println(K.id(1));
		System.out.println(K.id(2));
		System.out.println(K.id(3));
	}
}
