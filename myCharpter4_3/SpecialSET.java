package myCharpter4_3;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.UF;

public class SpecialSET {
	private Queue<MyEdge> mst;
	
	public SpecialSET(MyEdgeWeightedGraph G,SET<MyEdge> set) {
		mst = new Queue<MyEdge>();
		MinPQ<MyEdge> pq = new MinPQ<MyEdge>();
		UF uf = new UF(G.V());
		for(MyEdge e : G.edges()) {
			if(set.contains(e)) {
				mst.enqueue(e);
				int v = e.either();
				int w = e.other(v);
				uf.union(v, w);
			}else
				pq.insert(e);
		}
		
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
		
		SET<MyEdge> set = new SET<MyEdge>();
		MyEdge a = G.twoVertex(4, 6);
		MyEdge b = G.twoVertex(4, 7);
		MyEdge c = G.twoVertex(1, 3);
		set.add(a);
		set.add(b);
		set.add(c);
		SpecialSET B = new SpecialSET(G,set);
		for(MyEdge e :B.mst)
			System.out.println(e);
	}
}
