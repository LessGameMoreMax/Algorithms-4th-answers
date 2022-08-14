package myCharpter1_5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class WeightedQuickUnionVision {
	private int[] id;
	private int[] sz;
	private int count;
	private int total;
	private int arrayCount; 
	
	public WeightedQuickUnionVision(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for(int i = 0;i<N;i++)
			id[i] = i;
		for(int i = 0;i<N;i++)
			sz[i] = 1;
	}
	
	public int count()
	{return count;}
	
	public boolean connected(int p,int q)
	{return find(p)==find(q);}
	
	public int find(int p) {
		arrayCount++;
		while(id[p]!=p) {
			arrayCount += 2;
			p = id[p];
		}
		return p;
	}
	
	public int total()
	{ return total;}
	
	public int union(int p,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot) {
			int temp = arrayCount;
			total += arrayCount;
			arrayCount = 0;
			return temp;
		}
		
		if(sz[pRoot]>sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}else {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}
		arrayCount++;
		int temp = arrayCount;
		total += arrayCount;
		arrayCount = 0;
		count--;
		return temp;
	}
	
	public void stringPrint()
	{
		for(int i =0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
		for(int i =0;i<sz.length;i++)
			System.out.print(sz[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int N = 625;
		int n = 900;
		WeightedQuickUnionVision test = new WeightedQuickUnionVision(N);
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
