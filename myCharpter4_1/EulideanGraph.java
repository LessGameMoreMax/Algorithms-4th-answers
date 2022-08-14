package myCharpter4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class EulideanGraph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	private boolean marked[];
	private ST<Integer,Integer> st;
	public EulideanGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0;v<V;v++)
			adj[v] = new Bag<Integer>();
	}
	public EulideanGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i<E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public int V() { return V;}
	public int E() { return E;}
	public void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v)
	{ return adj[v];}
	public void show() {
		marked = new boolean[V];
		st = new ST<Integer,Integer>();
		StdDraw.setXscale(-1,2*V+1);
		StdDraw.setYscale(-1,2*V+1);
		for(int i = 0;i<V;i++)
			st.put(i,StdRandom.uniform(2*V));
		StdDraw.setPenRadius(.02);
		for(int i = 0;i<V;i++)
			StdDraw.point(2*i,st.get(i));
		StdDraw.setPenRadius(.01);
		for(int i = 0;i<V;i++)
			if(!marked[i])
				dfs(i);
	}
	private void dfs(int v) {
		marked[v] = true;
		for(int i : adj(v)) {
			StdDraw.line(2*v,st.get(v), 2*i,st.get(i));
			if(!marked[i]) 
				dfs(i);
		}
	}
	public static void main(String[] args) {
		EulideanGraph E = new EulideanGraph(6);
		E.addEdge(0, 1);
		E.addEdge(0, 2);
		E.addEdge(1, 2);
		E.addEdge(2, 3);
		E.addEdge(3, 4);
		E.addEdge(3, 5);
		E.addEdge(5, 4);
		E.addEdge(0, 4);
		E.show();
	}
	
}
