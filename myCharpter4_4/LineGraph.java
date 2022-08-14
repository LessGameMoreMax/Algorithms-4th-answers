package myCharpter4_4;

import myCharpter4_2.Degrees;
import myCharpter4_3.MyEdge;
import myCharpter4_3.MyEdgeWeightedGraph;

public class LineGraph {
	private double[] distTo;
	private boolean[] marked;
	
	public LineGraph(MyEdgeWeightedGraph G) {
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		int v = 0;
		while(v<G.V()) {
			int count = 0;
			for(MyEdge c : G.adj(v))
				count++;
			if(count==1) break;
			v++;
		}
		
		distTo[v] = 0.0;
		dfs(G,v);
	}
	
	private void dfs(MyEdgeWeightedGraph G,int v) {
		marked[v] = true;
		for(MyEdge e : G.adj(v)) {
			int w = e.other(v);
			if(!marked[w]) {
				distTo[w] = distTo[v] + e.weight();
				dfs(G,w);
			}
		}
	}
	
	public double anyDis(int v,int w) {
		if(v<0||w<0||v>=distTo.length||w>=distTo.length)
			throw new RuntimeException("Worong!");
		return Math.abs(distTo[v]-distTo[w]);
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(4);
		G.addVertex(2, 0, 0.3);
		G.addVertex(3, 0, 0.2);
		G.addVertex(3, 1, 0.4);
		LineGraph L = new LineGraph(G);
		System.out.println(L.anyDis(2, 3));
		System.out.println(L.anyDis(0, 3));
		System.out.println(L.anyDis(0, 1));
	}
}
