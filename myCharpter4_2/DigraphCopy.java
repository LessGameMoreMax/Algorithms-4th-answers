package myCharpter4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class DigraphCopy {
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public DigraphCopy(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0;i<V;i++)
			adj[i] = new Bag<Integer>();
	}
	public DigraphCopy(DigraphCopy D) {
		this(D.V);
		this.E = D.E;
		for(int i = 0;i<D.V;i++)
			for(int v : D.adj(i))
				this.adj[i].add(v);
	}
	public DigraphCopy(In in) {
		this(in.readInt());
		this.E = in.readInt();
		for(int i = 0;i<this.E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w) {
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public DigraphCopy reverse() {
		DigraphCopy R = new DigraphCopy(V);
		for(int v = 0;v<this.V;v++)
			for(int w : adj[v])
				R.addEdge(w, v);
		return R;
	}
	
}
