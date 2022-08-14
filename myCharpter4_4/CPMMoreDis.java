package myCharpter4_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CPMMoreDis {
	public static void main(String[] args) {
		int N = StdIn.readInt();
		StdIn.readLine();
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(2*N+2);
		int s = 2 * N;
		int t = 2 * N + 1;
		for(int i = 0;i<N;i++) {
			String[] a = StdIn.readLine().split("\\s+");
			double duration = Double.parseDouble(a[0]);
			G.addEdge(new MyDirectedEdge(i,i+N,duration));
			G.addEdge(new MyDirectedEdge(s,i,0.0));
			
			G.addEdge(new MyDirectedEdge(i+N,t,0.0));
			for(int j = 1;j<a.length;j++) {
				int successor = Integer.parseInt(a[j]);
				G.addEdge(new MyDirectedEdge(i+N,successor,0.0));
			}
		}
		
		AcyclicLPMoreDis lp = new AcyclicLPMoreDis(G,s);
		
		StdOut.println("Start times:");
		for(int i = 0;i<N;i++)
			StdOut.printf("%4d: %5.1f\n",i,lp.distTo(i));
		StdOut.printf("Finish time: %5.1f\n",lp.distTo(t));
	}
}
