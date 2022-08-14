package myCharpter4_3;

import edu.princeton.cs.algs4.Queue;

public class ImportantEdge {
	//只适用于删除关键边后仍为连通图的情况
	private Queue<MyEdge> importantEdge;
	
	public ImportantEdge(MyEdgeWeightedGraph G) {
		MyPrimMST mst = new MyPrimMST(G);
		importantEdge = new Queue<MyEdge>();
		for(MyEdge e : mst.edges()) {
			ImportantEdgeBaseKruskal I = new ImportantEdgeBaseKruskal(G,e);
			MyEdge i = I.newEdge();
			if(i!=null&&i.weight()>e.weight())
			importantEdge.enqueue(e);
		}
	}
	
	public Iterable<MyEdge> importantEdge(){
		return importantEdge;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(4);
		G.addVertex(0, 1, 0.2);
		G.addVertex(1, 2, 0.2);
		G.addVertex(2, 3, 0.2);
		G.addVertex(2, 0, 0.2);
		ImportantEdge I = new ImportantEdge(G);
		for(MyEdge e : I.importantEdge)
			System.out.println(e);
	}
}
