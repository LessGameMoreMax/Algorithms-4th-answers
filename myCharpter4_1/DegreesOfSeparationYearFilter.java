package myCharpter4_1;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class DegreesOfSeparationYearFilter {
	public static void main(String[] args) {
		System.out.println("How many years beyond would you like to ignore?");
		int year = StdIn.readInt();
		System.out.println("Loading......");
		SymbolGraphYearFilter sg = new SymbolGraphYearFilter(args[0],args[1],2022-year);
		Graph G = sg.G();
		
		String source = args[2];
		if(!sg.contains(source))
		{ StdOut.println(source + " not in database."); return;}
		
		int s = sg.index(source);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G,s);
		while(!StdIn.isEmpty()) {
			String sink = StdIn.readLine();
			if(sg.contains(sink)) {
				int t = sg.index(sink);
				if(bfs.hasPathTo(t))
					for(int v : bfs.pathTo(t))
						StdOut.println("     "+sg.name(v));
				else StdOut.println("Not connected");
			}
			else StdOut.println("Not in database!");
		}
	}
}
