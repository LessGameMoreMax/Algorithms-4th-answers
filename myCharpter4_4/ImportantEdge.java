package myCharpter4_4;

import edu.princeton.cs.algs4.In;

public class ImportantEdge {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private MyDirectedEdge importantEdge;
	private double maxDis;
	public ImportantEdge(MyEdgeWeightedDigraph EWD,int s,int t) {
		MyDijkstraSP D = new MyDijkstraSP(EWD,s);
		maxDis = D.distTo(t);
		for(MyDirectedEdge e : D.pathTo(t)) {
			MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(EWD.V());
			for(MyDirectedEdge edge : EWD.edges())
				if(!edge.equals(e)) G.addEdge(edge); 
			
			MyDijkstraSP SP = new MyDijkstraSP(G,s);
			if(SP.distTo(t)>maxDis&&Math.abs(SP.distTo(t)-maxDis)>FLOATING_POINT_EPSILON) {
				importantEdge = e;
				maxDis = SP.distTo(t);
			}
		}
	}
	
	public MyDirectedEdge importantEdge() {
		return importantEdge;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		ImportantEdge I = new ImportantEdge(G,0,6);
		System.out.println(I.importantEdge());
	}
}
