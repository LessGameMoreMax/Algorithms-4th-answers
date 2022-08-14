package myCharpter4_4;

import edu.princeton.cs.algs4.Queue;

public class MeshSPLimited {
	Queue<CoordinateXY> queue;
	public MeshSPLimited(Maxtrix M) {
		queue = new Queue<CoordinateXY>();
		int N = M.size();
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(N*N+2);
		int s = N*N;
		int t = N*N+1;
		G.addByVertex(s, 0, M.get(0, 0));
//		G.addByVertex(0, s, M.get(0, 0));
		G.addByVertex(N*N-1, t, 0.0);
//		G.addByVertex(t, N*N-1, 0.0);
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(i!=N-1) {
					G.addByVertex(i*N+j, (i+1)*N+j, M.get(i+1, j));
//					G.addByVertex((i+1)*N+j, i*N+j, M.get(i, j));
				}
				if(j!=N-1) {
					G.addByVertex(i*N+j, i*N+j+1, M.get(i, j+1));
//					G.addByVertex(i*N+j+1, i*N+j, M.get(i, j));
				}
			}
		}
		MyDijkstraSP D = new MyDijkstraSP(G,s);
		boolean first = false;
		for(MyDirectedEdge e : D.pathTo(t)) {
			if(first) queue.enqueue(new CoordinateXY(e.from()/N,e.from()%N));
			first = true;
		}
	}
	
	public Iterable<CoordinateXY> minPath(){
		return queue;
	}
	
	public static void main(String[] args) {
		Maxtrix M = new Maxtrix(5);
		M.add(0, 0, 1);
		M.add(0, 1, 1);
		M.add(0, 2, 1);
		M.add(0, 3, 9);
		M.add(0, 4, 1);
		M.add(1, 0, 9);
		M.add(1, 1, 9);
		M.add(1, 2, 1);
		M.add(1, 3, 9);
		M.add(1, 4, 1);
		M.add(2, 0, 1);
		M.add(2, 1, 1);
		M.add(2, 2, 1);
		M.add(2, 3, 9);
		M.add(2, 4, 1);
		M.add(3, 0, 1);
		M.add(3, 1, 1);
		M.add(3, 2, 9);
		M.add(3, 3, 1);
		M.add(3, 4, 1);
		M.add(4, 0, 1);
		M.add(4, 1, 1);
		M.add(4, 2, 1);
		M.add(4, 3, 1);
		M.add(4, 4, 1);
		MeshSPLimited SP = new MeshSPLimited(M);
		for(CoordinateXY n : SP.minPath())
			System.out.println(n.X()+" "+n.Y());
	}
}
