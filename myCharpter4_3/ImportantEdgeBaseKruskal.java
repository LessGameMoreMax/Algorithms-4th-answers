package myCharpter4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

public class ImportantEdgeBaseKruskal {
	private MyEdge edge;
	public ImportantEdgeBaseKruskal(MyEdgeWeightedGraph G,MyEdge E) {
		MinPQ<MyEdge> pq = new MinPQ<MyEdge>();
		UF uf = new UF(G.V());
		MyPrimMST p = new MyPrimMST(G);
		for(MyEdge e : p.edges()) {
			if(e.equals(E)) continue;
			int v = e.either();
			int w = e.other(v);
			uf.union(v, w);
		}
		for(MyEdge e : G.edges()) {
			if(e.equals(E)) continue;
			pq.insert(e);
		}
		//应该添加判断两个连通分量之间是不是有路径可以连接
		while(!pq.isEmpty()) {
			MyEdge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(uf.connected(v, w)) continue;
			edge = e;
			break;
		}
	}
	public MyEdge newEdge() {
		return edge;
	}
}
