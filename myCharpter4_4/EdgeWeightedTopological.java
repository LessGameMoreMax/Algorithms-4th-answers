package myCharpter4_4;

public class EdgeWeightedTopological {
	private Iterable<Integer> order;
	
	public EdgeWeightedTopological(MyEdgeWeightedDigraph G) {
		EdgeWeightedCycleFinder C = new EdgeWeightedCycleFinder(G);
		if(!C.hasCycle()) {
			DepthFirstOrderEWD dfs = new DepthFirstOrderEWD(G);
			order = dfs.reversePost();
		}
	}
	
	public Iterable<Integer> order()
	{ return order;}
	
	public boolean isDAG()
	{ return order!=null;}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(4);
		G.addByVertex(0, 2, 0.1);
		G.addByVertex(0, 1, 0.3);
		G.addByVertex(1, 3, 0.7);
		G.addByVertex(2, 1, 0.5);
		EdgeWeightedTopological T = new EdgeWeightedTopological(G);
		for(int i : T.order()) System.out.print(i+" ");
	}
}
