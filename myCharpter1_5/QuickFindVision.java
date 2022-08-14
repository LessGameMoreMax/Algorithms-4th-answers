package myCharpter1_5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class QuickFindVision {
		private int[] id;
		private int count;
		private int total;
		
		public QuickFindVision(int N) {
			count = N;
			id = new int[N];
			for(int i =0;i<N;i++)
				id[i] = i;
		}
		
		public int count()
		{ return count;}
		
		public int find(int p)
		{ return id[p];}
		
		public boolean connected(int p,int q) 
		{ return id[p]==id[q];}
		
		public int union(int p, int q) {
			int arrayCount = 0;
			int pId = id[p];
			int qId = id[q];
			
			arrayCount += 2;
			
			if(pId==qId) {
				total += arrayCount;
				return arrayCount;
			}
			
			for(int i = 0;i < id.length;i++) {
				arrayCount++;
				if(id[i]==pId) {
					arrayCount++;
					id[i] = qId;
				}
			}
			total += arrayCount;
			count--;
			return arrayCount;
		}
		
		public void printString() {
			for(int i = 0;i<id.length;i++)
				System.out.print(id[i]+" ");
			System.out.println();
		}
		
		public int total()
		{return total;}
		
		public static void main(String[] args) {
			int N = 10;
			QuickFindVision test = new QuickFindVision(N);
			StdDraw.setYscale(0,2*N);
			StdDraw.setXscale(0,N*(N-1)/2);
			StdDraw.setPenRadius(.02);
				for(int p = 0;p<N-1;p++) {
					for(int q=p+1;q<N;q++) {
						int num = test.union(p,q);
						StdDraw.setPenColor(StdDraw.GRAY);
						StdDraw.point(p*(N-2)+q, num);
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.point(p*(N-2)+q, test.total/(p*(N-2)+q));		
					}
				}
			}
}
