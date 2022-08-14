package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BellmanFordHeuristicMethod {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private double[] distTo;
	private MyDirectedEdge[] edgeTo;
	private boolean[] onQ;
	private Queue<Integer> queue;
	private int cost;
	private Iterable<MyDirectedEdge> cycle;
	
	public BellmanFordHeuristicMethod(MyEdgeWeightedDigraph G,int s) {
		distTo = new double[G.V()];
		edgeTo = new MyDirectedEdge[G.V()];
		onQ = new boolean[G.V()];
		queue = new Queue<Integer>();
		
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;
		while(!queue.isEmpty()&&!this.hasNegativeCycle()) {
			int v = queue.dequeue();
			onQ[v] = false;
			if(edgeTo[v]!=null&&onQ[edgeTo[v].from()]) continue;
			relax(G,v);
		}
	}
	
	private void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]>distTo[v]+e.weight()&&Math.abs(distTo[w]-distTo[v]-e.weight())>FLOATING_POINT_EPSILON) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(!onQ[w]) {
					queue.enqueue(w);
					onQ[w] = true;
				}
			}
			if(cost++%G.V()==0) findNegativeCycle();
		}
	}
	
	private void findNegativeCycle() {
		int V = edgeTo.length;
		MyEdgeWeightedDigraph spt = new MyEdgeWeightedDigraph(V);
		for(int v = 0;v<V;v++)
			if(edgeTo[v]!=null)
				spt.addEdge(edgeTo[v]);
		EdgeWeightedCycleFinderBellmanFord cf = new EdgeWeightedCycleFinderBellmanFord(spt);
		cycle = cf.cycle();
	}
	
	public boolean hasNegativeCycle()
	{ return cycle!=null;}
	
	public Iterable<MyDirectedEdge> negativeCycle()
	{ return cycle;}
	
	public double distTo(int v) {
		if(hasNegativeCycle()) throw new RuntimeException("Wrong!");
		return distTo[v];
	}
	
	public boolean hasPathTo(int v) {
		if(hasNegativeCycle()) throw new RuntimeException("Wrong!");
		return distTo[v]<Double.NEGATIVE_INFINITY;
	}
	
	public Iterable<MyDirectedEdge> pathTo(int v){
		if(hasNegativeCycle()) throw new RuntimeException("Wrong!");
		Stack<MyDirectedEdge> stack = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			stack.push(e);
		return stack;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(5);
		G.addByVertex(0, 2, 1);
		G.addByVertex(1, 0, -100);
		G.addByVertex(0, 1, 1);
		G.addByVertex(1, 2, 1);
		G.addByVertex(2, 3, 1);
		G.addByVertex(3, 4, 1);
		BellmanFordHeuristicMethod B = new BellmanFordHeuristicMethod(G,0);
		for(MyDirectedEdge e : B.negativeCycle())
			System.out.println(e);
		//可以节省一次放松操作
	}
}
