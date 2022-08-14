package myCharpter4_4;

import edu.princeton.cs.algs4.Queue;

public class MeshSP {
//	Queue<CoordinateXY> queue;
//	public MeshSP(Maxtrix M) {
//		queue = new Queue<CoordinateXY>();
//		int N = M.size();
//		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(2*N*N+2);
//		int s = 2*N*N;
//		int t = 2*N*N+1;
//		G.addByVertex(s, 0, 0.0);
//		G.addByVertex(0, s, 0.0);
//		G.addByVertex(2*N*N-1, t, 0.0);
//		G.addByVertex(t, 2*N*N-1, 0.0);
//		for(int i = 0;i<N;i++) {
//			for(int j = 0;j<N;j++) {
//				G.addByVertex(i*N+j, i*N+j+N*N, 0);
//				G.addByVertex(i*N+j+N*N, i*N+j, 0);
//				
//				if(i!=N-1) {
//					G.addByVertex(i*N+j+N*N, (i+1)*N+j, M.get(i, j));
//					G.addByVertex((i+1)*N+j, i*N+j+N*N, M.get(i, j));
//				}
//				if(j!=N-1) {
//					G.addByVertex(i*N+j+N*N, i*N+j+1, M.get(i, j));
//					G.addByVertex(i*N+j+1, i*N+j+N*N, M.get(i, j));
//				}
//			}
//		}
//		MyDijkstraSP D = new MyDijkstraSP(G,s);
//		int cost = 0;
//		for(MyDirectedEdge e : D.pathTo(t)) {
//			if(cost++%2==1)
//			queue.enqueue(new CoordinateXY(e.from()/N,e.from()%N));
//		}
//			
//	}
//	
//	public Iterable<CoordinateXY> minPath(){
//		return queue;
//	}
//	
//	public static void main(String[] args) {
//		Maxtrix M = new Maxtrix(5);
//		M.add(0, 0, 1);
//		M.add(0, 1, 1);
//		M.add(0, 2, 1);
//		M.add(0, 3, 99);
//		M.add(0, 4, 1);
//		M.add(1, 0, 99);
//		M.add(1, 1, 99);
//		M.add(1, 2, 1);
//		M.add(1, 3, 99);
//		M.add(1, 4, 1);
//		M.add(2, 0, 1);
//		M.add(2, 1, 1);
//		M.add(2, 2, 1);
//		M.add(2, 3, 99);
//		M.add(2, 4, 1);
//		M.add(3, 0, 1);
//		M.add(3, 1, 1);
//		M.add(3, 2, 99);
//		M.add(3, 3, 1);
//		M.add(3, 4, 1);
//		M.add(4, 0, 1);
//		M.add(4, 1, 1);
//		M.add(4, 2, 1);
//		M.add(4, 3, 1);
//		M.add(4, 4, 1);
//		MeshSP SP = new MeshSP(M);
//		for(CoordinateXY n : SP.minPath())
//			System.out.println(n.X()+" "+n.Y());
//	}
	
	
	Queue<CoordinateXY> queue;
	public MeshSP(Maxtrix M) {
		queue = new Queue<CoordinateXY>();
		int N = M.size();
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(N*N+2);
		int s = N*N;
		int t = N*N+1;
		G.addByVertex(s, 0, M.get(0, 0));
		G.addByVertex(0, s, M.get(0, 0));
		G.addByVertex(N*N-1, t, 0.0);
		G.addByVertex(t, N*N-1, 0.0);
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(i!=N-1) {
					G.addByVertex(i*N+j, (i+1)*N+j, M.get(i+1, j));
					G.addByVertex((i+1)*N+j, i*N+j, M.get(i, j));
				}
				if(j!=N-1) {
					G.addByVertex(i*N+j, i*N+j+1, M.get(i, j+1));
					G.addByVertex(i*N+j+1, i*N+j, M.get(i, j));
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
		M.add(0, 3, 99);
		M.add(0, 4, 1);
		M.add(1, 0, 99);
		M.add(1, 1, 99);
		M.add(1, 2, 1);
		M.add(1, 3, 99);
		M.add(1, 4, 1);
		M.add(2, 0, 1);
		M.add(2, 1, 1);
		M.add(2, 2, 1);
		M.add(2, 3, 99);
		M.add(2, 4, 1);
		M.add(3, 0, 1);
		M.add(3, 1, 1);
		M.add(3, 2, 99);
		M.add(3, 3, 1);
		M.add(3, 4, 1);
		M.add(4, 0, 1);
		M.add(4, 1, 1);
		M.add(4, 2, 1);
		M.add(4, 3, 1);
		M.add(4, 4, 1);
		MeshSP SP = new MeshSP(M);
		for(CoordinateXY n : SP.minPath())
			System.out.println(n.X()+" "+n.Y());
	}
}
