package myCharpter4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class Boruvka {
	private Bag<MyEdge> mst = new Bag<MyEdge>();
	
	public Boruvka(MyEdgeWeightedGraph G){
		UF uf = new UF(G.V());
		
		for(int t = 0;t<G.V()&&mst.size()<G.V()-1;t+=2) {
			MyEdge[] closet = new MyEdge[G.V()];
			for(MyEdge e : G.edges()) {
				int v = e.either();
				int w = e.other(v);
				int i = uf.find(v);
				int j = uf.find(w);
				if(i==j) continue;
				if(closet[i]==null||e.weight()<closet[i].weight()) closet[i] = e;
				if(closet[j]==null||e.weight()<closet[j].weight()) closet[j] = e;
			}
			
			for(int i = 0;i<G.V();i++) {
				MyEdge e = closet[i];
				if(e!=null) {
					int v = e.either();
					int w = e.other(v);
					if(!uf.connected(v, w)) {
						mst.add(e);
						uf.union(v, w);
					}
				}
			}
		}
	}
	
	public Iterable<MyEdge> mst(){
		return mst;
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
		Boruvka B = new Boruvka(G);
		for(MyEdge e : B.mst)
			System.out.println(e);
	}
}
