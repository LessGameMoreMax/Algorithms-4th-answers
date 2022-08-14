package myCharpter1_5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class QuickUnionVision {
	private int[] id;
	private int count;
	private int arrCount;
	private int total;
	
	public QuickUnionVision(int N) {
		count = N;
		id = new int[N];
		for(int i = 0; i<N;i++)
			id[i] = i;
	}
	
	public int count()
	{ return count;}
	
	public boolean connected(int p,int q)
	{ return find(p)==find(q);}
	
	public int find(int p)
	{	
		arrCount++;
		while(id[p]!=p) {
			p = id[p];
			arrCount += 2;
		}
		return p;
	}

	public int union(int p,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot) {
			int temp = arrCount;
			total += arrCount;
			arrCount = 0;
			return temp;
		}
		
		arrCount++;
		id[pRoot] = qRoot;
		count--;
		int temp = arrCount;
		total += arrCount;
		arrCount = 0;
		return temp;
	}
	
	public int total()
	{return total;}
	
	public void printString()
	{ 
		for(int i =0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int N = 625;
		int n = 10000;
		QuickUnionVision test = new QuickUnionVision(N);
		StdDraw.setYscale(0,100);
		StdDraw.setXscale(0,n);
		StdDraw.setPenRadius(.02);
		for(int i = 1;i<n;i++) {
			int num = test.union(StdRandom.uniform(N),StdRandom.uniform(N));
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(i, num);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(i, test.total/i);		
		}
	}
}
