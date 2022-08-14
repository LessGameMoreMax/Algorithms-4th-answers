package myCharpter6_4;

import edu.princeton.cs.algs4.Queue;

public class MyFordFulkerson {
	private boolean[] marked;
	private MyFlowEdge[] edgeTo;
	private double value;
	public MyFordFulkerson(MyFlowNetwork G,int s,int t) {
		while(hasAugmentingPath(G,s,t)) {
			double bottle = Double.POSITIVE_INFINITY;
			for(int v = t;v != s; v = edgeTo[v].other(v))
				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
			
			for(int v = t;v != s;v = edgeTo[v].other(v))
				edgeTo[v].addResidualFlowTo(v, bottle);
			
			value += bottle;
		}
	}
	
	public double value() { return value;}
	public boolean inCut(int v) { return marked[v];}
	
	private boolean hasAugmentingPath(MyFlowNetwork G,int s,int t) {
		marked = new boolean[G.V()];
		edgeTo = new MyFlowEdge[G.V()];
		Queue<Integer> q = new Queue<Integer>();
		
		marked[s] = true;
		q.enqueue(s);
		while(!q.isEmpty()) {
			int v = q.dequeue();
			for(MyFlowEdge e : G.adj(v)) {
				int w = e.other(v);
				if(e.residualCapacityTo(w)>0&&!marked[w]) {
					edgeTo[w] = e;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
		return marked[t];
	}
}
