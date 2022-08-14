package myCharpter4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMSF {
	private boolean[] marked;
	private Queue<Queue<MyEdge>> mst;
	private MinPQ<MyEdge> pq;
	
	public LazyPrimMSF(MyEdgeWeightedGraph G) {
		marked = new boolean[G.V()];
		mst = new Queue<Queue<MyEdge>>();
		for(int i = 0;i<G.V();i++) {
			Queue<MyEdge> q = new Queue<MyEdge>();
			pq = new MinPQ<MyEdge>();
			if(!marked[i]) {
				visit(G,i);
				while(!pq.isEmpty()) {
					MyEdge e = pq.delMin();
					int v = e.either();
					int w = e.other(v);
					if(marked[v]&&marked[w]) continue;
					q.enqueue(e);
					if(!marked[v]) visit(G,v);
					if(!marked[w]) visit(G,w);
				}
			}
			if(!q.isEmpty()) mst.enqueue(q);
		}
	}
	
	private void visit(MyEdgeWeightedGraph G,int v) {
		marked[v] = true;
		for(MyEdge e : G.adj(v))
			if(!marked[e.other(v)]) pq.insert(e);
	}
	
	public Iterable<Queue<MyEdge>> edges(){
		return mst;
	}
	
	public void printMSF() {
		for(Queue<MyEdge> q : mst) {
			for(MyEdge e : q)
				System.out.print(e+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(8);
		G.addVertex(1, 5, 0.32);
		G.addVertex(1, 7, 0.19);
		G.addVertex(2, 3, 0.17);
		G.addVertex(6, 2, 0.40);
		G.addVertex(6, 3, 0.52);
		G.addVertex(0, 4, 0.38);
		G.addVertex(0, 7, 0.16);
		G.addVertex(4, 5, 0.35);
		G.addVertex(4, 7, 0.37);
		G.addVertex(5, 7, 0.28);
		LazyPrimMSF L = new LazyPrimMSF(G);
		L.printMSF();
	}
}
