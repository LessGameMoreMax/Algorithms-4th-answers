package myCharpter4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

public class MyPrimMST {
	private MyEdge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;
	private double weight;
	
	public MyPrimMST(MyEdgeWeightedGraph G) {
		edgeTo = new MyEdge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		
		distTo[0] = 0.0;
		pq.insert(0, 0.0);
		while(!pq.isEmpty()) {
			int v = pq.delMin();
			visit(G,v);
			if(v==0) continue;
			weight += edgeTo[v].weight();
		}
			
	}
	
	private void visit(MyEdgeWeightedGraph G,int v) {
		marked[v] = true;
		for(MyEdge e : G.adj(v)) {
			int w = e.other(v);
			if(marked[w]) continue;
			if(e.weight()<distTo[w]) {
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w))  pq.change(w, distTo[w]);
				else				pq.insert(w, distTo[w]);
			}
		}
	}
	
	public Iterable<MyEdge> edges(){
		Bag<MyEdge> mst = new Bag<MyEdge>();
		for(int i = 1;i<edgeTo.length;i++)
			mst.add(edgeTo[i]);
		return mst;
	}
	
	public double lazyWeighted() {
		double w = 0;
		for(int i = distTo.length-1;i>0;i--)
			w += distTo[i];
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
		MyPrimMST B = new MyPrimMST(G);
		System.out.println(B.weight());
		System.out.println(String.format("%.2f", B.lazyWeighted())); //浮点数的操作会损失精度，需要额外注意
	}
}
