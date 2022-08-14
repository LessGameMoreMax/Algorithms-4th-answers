package myCharpter1_5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomGrid {
	
	public static WeightedQuickUnion generate(int N) {
		WeightedQuickUnion uf = new WeightedQuickUnion(N*N);
		int[] arr = new int[N*N];
		for(int i =0;i<N*N;i++)
			arr[i] = i;
		StdRandom.shuffle(arr);
		for(int i = 0;i<N*N-1;i+=2)
			uf.union(arr[i], arr[i+1]);
		return uf;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		WeightedQuickUnion uf = generate(N);
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0,N);
		StdDraw.setPenRadius(.02);
		StdDraw.setPenColor(StdDraw.BLACK);
		for(int i = 0;i<N;i++)
			for(int j = 0;j<N;j++)
				StdDraw.point(i, j);
		StdDraw.setPenRadius(.01);
		for(int i = 0;i<N*N-1;i++)
			for(int j = i+1;j<N*N;j++)
				if(uf.connected(i, j)) StdDraw.line(i%N,i/N,j%N,j/N);
	}
	
	
			
}
