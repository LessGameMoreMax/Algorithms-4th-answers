package myCharpter6_4;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.StdOut;

public class TestCharpter6_4 {
	public static void main(String[] args) {
		FlowNetwork G = new FlowNetwork(6);
		G.addEdge(new FlowEdge(0,1,1));
		G.addEdge(new FlowEdge(0,2,1));
		G.addEdge(new FlowEdge(1,4,1));
		G.addEdge(new FlowEdge(1,3,1));
		G.addEdge(new FlowEdge(2,3,1));
		G.addEdge(new FlowEdge(2,4,1));
		G.addEdge(new FlowEdge(3,5,1));
		G.addEdge(new FlowEdge(4,5,1));
		
		G.addEdge(new FlowEdge(1,0,1));
		G.addEdge(new FlowEdge(2,0,1));
		G.addEdge(new FlowEdge(4,1,1));
		G.addEdge(new FlowEdge(3,1,1));
		G.addEdge(new FlowEdge(3,2,1));
		G.addEdge(new FlowEdge(4,2,1));
		G.addEdge(new FlowEdge(5,3,1));
		G.addEdge(new FlowEdge(5,4,1));
		
		int s = 0;
		int t = G.V()-1;
		FordFulkerson maxflow = new FordFulkerson(G,s,t);
		
		StdOut.println("Max flow from "+ s + " to " + t);
		for(int v = 0;v <G.V();v++)
			for(FlowEdge e : G.adj(v))
				if((v==e.from())&&e.flow()>0)
					StdOut.println("    "+e);
		StdOut.println("Max flow value = " + maxflow.value());
	}
}
