package myCharpter4_3;

import edu.princeton.cs.algs4.MaxPQ;

public class BackwardDelete {
	MyEdgeWeightedGraph E;
	public BackwardDelete(MyEdgeWeightedGraph EG) {
		E = new MyEdgeWeightedGraph(EG.V());
		GraphDelete G = new GraphDelete(EG.V());
		MaxPQ<MyEdge> pq = new MaxPQ<MyEdge>();
		for(MyEdge e : EG.edges()) {
			pq.insert(e);
			int w = e.either();
			int v = e.other(w);
			G.addEdge(v, w);
		}
		for(MyEdge e : pq) {
			int w = e.either();
			int v = e.other(w);
			G.delete(w, v);
			IsCCGraphDelete I = new IsCCGraphDelete(G);
			if(!I.isCC()) G.addEdge(v, w);
		}
		for(int i = 0;i<EG.V();i++)
			for(int v : G.adj(i))
				if(v>i) E.addVertex(v, i, EG.twoVertex(v, i).weight());
	}
	
	public Iterable<MyEdge> MST(){
		return E.edges();
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
		BackwardDelete B = new BackwardDelete(G);
		for(MyEdge e : B.MST())
			System.out.println(e);
	}
}
