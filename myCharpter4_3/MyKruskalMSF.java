package myCharpter4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class MyKruskalMSF {
	private Queue<MyEdge> mst;
	
	public MyKruskalMSF(MyEdgeWeightedGraph G) {
		mst = new Queue<MyEdge>();
		MinPQ<MyEdge> pq = new MinPQ<MyEdge>();
		for(MyEdge e : G.edges())
			pq.insert(e);
		UF uf = new UF(G.V());
		
		while(!pq.isEmpty()&&mst.size()<G.V()-1) {
			MyEdge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(uf.connected(v, w)) continue;
			uf.union(v, w);
			mst.enqueue(e);
		}
	}
	
	public Iterable<MyEdge> edges()
	{ return mst;}
	
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
		MyKruskalMSF L = new MyKruskalMSF(G);
		for(MyEdge e : L.mst)
			System.out.println(e);
	}
}
