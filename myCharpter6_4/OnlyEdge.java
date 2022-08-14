package myCharpter6_4;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class OnlyEdge {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		FlowNetwork F = new FlowNetwork(G.V());
		for(int v = 0;v<G.V();v++)
			for(int w : G.adj(v))
				F.addEdge(new FlowEdge(v,w,1));
		int s = 0;
		int t = F.V()-1;
		FordFulkerson maxflow = new FordFulkerson(F,s,t);
		System.out.println("Max edge is : " +(int)maxflow.value());
				
	}
}
