package myCharpter4_3;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.Queue;

public class EdgeWeightedGraphWithMaxtrix {
	private final int V;
	private int E;
	private Double[][] maxtrix;
	
	public EdgeWeightedGraphWithMaxtrix(int V) {
		this.V = V;
		this.E = 0;
		maxtrix = new Double[V][V];
	}
	
	public int V() { return V;}
	public int E() { return E;}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		if(maxtrix[v][w]!=null) return;
		maxtrix[v][w] = e.weight();
		maxtrix[w][v] = e.weight();
		E++;
	}
	
	public Iterable<Edge> adj(int v){
		Queue<Edge> q = new Queue<Edge>();
		for(int i = 0;i<V;i++)
			if(maxtrix[v][i]!=null) {
				Edge e = new Edge(v,i,maxtrix[v][i]);
				q.enqueue(e);
			}
		return q;
	}
	
	public Iterable<Edge> edges(){
		Queue<Edge> q = new Queue<Edge>();
		for(int v = 0;v<V;v++)
			for(int i = 0;i<=v;i++)
				if(maxtrix[v][i]!=null) {
					Edge e = new Edge(v,i,maxtrix[v][i]);
					q.enqueue(e);
				}
		return q;
	}
	
}
