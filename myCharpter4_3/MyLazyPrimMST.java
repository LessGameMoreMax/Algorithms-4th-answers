package myCharpter4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class MyLazyPrimMST {
	private boolean[] marked;
	private Queue<MyEdge> mst;
	private MinPQ<MyEdge> pq;
	private MyEdgeWeightedGraph G;
	private double weight;
	
	public MyLazyPrimMST(MyEdgeWeightedGraph G) {
		this.G = G;
		pq = new MinPQ<MyEdge>();
		marked = new boolean[G.V()];
		mst = new Queue<MyEdge>();
		
		visit(G,0);
		while(!pq.isEmpty()) {
			MyEdge e = pq.delMin();
			
			int v = e.either();
			int w = e.other(v);
			if(marked[v]&&marked[w]) continue;
			mst.enqueue(e);
			weight += e.weight();
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
	}
	
	private void visit(MyEdgeWeightedGraph G,int v) {
		marked[v] = true;
		for(MyEdge e : G.adj(v))
			if(!marked[e.other(v)]) pq.insert(e);
	}
	
	public Iterable<MyEdge> edges()
	{ return mst;}
	
	public MyEdgeWeightedGraph getGraph()
	{ return G;}
	
	public double lazyWeighted() {
		double w = 0;
		for(MyEdge e :this.edges())
			w += e.weight();
		return w;
	}
	
	public double weight() {
		return weight;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(8);
		G.addVertex(4, 5, 0.35);
		G.addVertex(4, 7, 0.37);
		G.addVertex(5, 7, 0.28);
		G.addVertex(0, 7, 0.16);
		G.addVertex(1, 5, 0.32);
		G.addVertex(0, 4, 0.38);
		G.addVertex(2, 3, 0.17);
		G.addVertex(1, 7, 0.19);
		G.addVertex(0, 2, 0.26);
		G.addVertex(1, 2, 0.36);
		G.addVertex(1, 3, 0.29);
		G.addVertex(2, 7, 0.34);
		G.addVertex(6, 2, 0.40);
		G.addVertex(3, 6, 0.52);
		G.addVertex(6, 0, 0.58);
		G.addVertex(6, 4, 0.93);
		MyLazyPrimMST B = new MyLazyPrimMST(G);
		System.out.println(B.weight());
		System.out.println(B.lazyWeighted());
	}
	
}
