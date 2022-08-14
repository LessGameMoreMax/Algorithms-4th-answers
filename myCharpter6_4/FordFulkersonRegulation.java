package myCharpter6_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;

public class FordFulkersonRegulation {
	private boolean[] marked;
	private MyFlowEdge[] edgeTo;
	private double value;
	public FordFulkersonRegulation(MyFlowNetwork G,SET<Integer> begin,SET<Integer> end) {
		for(int s : begin) {
			for(int t : hasAugmentingPath(G,s,end)) {
				double bottle = Double.POSITIVE_INFINITY;
				for(int v = t;v != s; v = edgeTo[v].other(v))
					bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
				
				for(int v = t;v != s;v = edgeTo[v].other(v))
					edgeTo[v].addResidualFlowTo(v, bottle);
				
				value += bottle;
			}	
		}
	}
	
	public double value() { return value;}
	public boolean inCut(int v) { return marked[v];}
	
	private Queue<Integer> hasAugmentingPath(MyFlowNetwork G,int s,SET<Integer> end) {
		marked = new boolean[G.V()];
		edgeTo = new MyFlowEdge[G.V()];
		Queue<Integer> q = new Queue<Integer>();
		Queue<Integer> queue = new Queue<Integer>();
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
		for(int i : end) if(marked[i]) queue.enqueue(i); 
		return queue;
	}
}
