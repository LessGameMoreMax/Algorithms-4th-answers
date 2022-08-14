package myCharpter4_3;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.UF;

public class AnimationBasedWithKruskalMST {
	EdgeWeightedGraph G;
	public AnimationBasedWithKruskalMST(EdgeWeightedGraph G) {
		this.G = G;
	}
	
	public void draw() {
		ST<Integer,AnimationCoordinate> st = new ST<Integer,AnimationCoordinate>();
		StdDraw.setXscale(-300, 300);
		StdDraw.setYscale(-300, 300);
		StdDraw.setPenRadius(.03);
		for(int i = 0;i<G.V();i++) {
			AnimationCoordinate A = new AnimationCoordinate(StdRandom.uniform(-290.0, 290.0),StdRandom.uniform(-290.0, 290.0));
			StdDraw.point(A.x(), A.y());
			st.put(i, A);
		}
		int num = 0;
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for(Edge e : G.edges())
			pq.insert(e);
		UF uf = new UF(G.V());
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor(StdDraw.RED);
		while(!pq.isEmpty()&&num<G.V()-1) {
			StdDraw.show(120);
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(uf.connected(v, w)) continue;
			uf.union(v, w);
			StdDraw.line(st.get(v).x(), st.get(v).y(), st.get(w).x(), st.get(w).y());
			num++;
		}
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G  = new EdgeWeightedGraph(in);
		AnimationBasedWithKruskalMST A = new AnimationBasedWithKruskalMST(G);
		A.draw();
	}
}
